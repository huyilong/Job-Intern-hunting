import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * The program will read in one or more sorted .txt file from user
 * and merge them while keeping the sorted order.
 * The result will be printed to standard output.
 * 
 * Usage:
 * For standard output, type
 *   java MergeFile f1.txt [f2.txt] [f3.txt] ... 
 *   
 * To redirect output to output.txt, type
 *   java MergeFile f1.txt [f2.txt] [f3.txt] ... > output.txt
 * 
 * NOTE: if unsorted file (input.txt) is detected, the program
 * will sort the file and output a new file named sorted-input.txt
 * Please use the output file as arguments for program execution
 * Also, note that the program uses string comparator to do the sorting.
 * Integers in the file will be read as strings
 *
 * @author jinglu
 *
 */

public class MergeFile {
	//size to split
	private static int splitSize = 100000;
	public static void main(String[] args) throws Exception{
		//list to store file names
		List<String> files = new ArrayList<String>();
		//check command line arguments
		//if no arguments, print instructions
		if(args.length < 1){
			programInfo();
		}else{
			//read file names into list
			for(int i=0; i<args.length; i++){
			   File f = new File(args[i]);
			   if(f.exists()){
			      files.add(f.getAbsolutePath());
			   //if user-specified file doesn't exist,
			   //print error message and exit
			   }else{
			   	  System.out.println("Input file [" + args[i] + "] not found in current directory.");
			   	  System.exit(1);
			   }
			}
		}
		mergeFile(files);
	}
    
    /**
     * Merge the files in the list while maintaining the sorted order
     * 
     */
	public static void mergeFile(List<String> files) throws Exception{
		int fileNum = 1;
		//sorted set to rank files using comparator
		SortedSet<MyFile> fSet = new TreeSet<MyFile>(new MyFileComparator());
		//construct MyFile object for each file in the list
		for(int i=0; i<files.size(); i++){
			File f = new File(files.get(i));
			BufferedReader reader = new BufferedReader(new FileReader(f));
			MyFile myFile = new MyFile();
			//increment fileNum each time
			myFile.setFileNum(fileNum);
			fileNum ++;
			myFile.setReader(reader);
			//set currVal of myFile to be the first elment in the file
			String currVal = reader.readLine();
			//only add file to set if it is not empty
			if(currVal != null){
				myFile.setCurrVal(currVal);
				myFile.setCurrLine(1);
				fSet.add(myFile);
			}
		}
        
        //use a queue to store output
		Queue<String> valSet = new LinkedList<String>();
		while(!fSet.isEmpty()){
			//get the file with first rank
			MyFile currFile = fSet.first();
			valSet.add(currFile.getCurrVal());
			//if queue gets too large, 
			//print the contents to standard output and clear the queue
	        if(valSet.size() >= splitSize){
	        	 stdWrite(valSet);
                 valSet.clear();
	        }
	        //clone a new file
	        MyFile nextFile = currFile.clone();

	        //remove currFile from the set
	        fSet.remove(currFile);
            //if this file still has data to read
            //add nextFile to set
            //and the set will re-rank the files
            int cond = nextFile.nextVal();
	        if(cond == 1){
	        	fSet.add(nextFile);	
	        }else if(cond == 0){
                String unsortedName = files.get(nextFile.getFileNum()-1);
                sortFile(unsortedName);
                unsortedName = unsortedName.substring(unsortedName.lastIndexOf("/")+1);
                System.out.println("----------NOTE-----------");
                System.out.println("DETECTED: " +  unsortedName + " is unsorted.");
                System.out.println("Sorted version of the file is output as sorted-" + unsortedName);
                System.out.println("Please use sorted-" + unsortedName + " as arguments for program execution");
                System.exit(1);
	        }
	        	
	     }
         //print rest contents in the queue to standard output
         stdWrite(valSet);	
         valSet.clear();
	}
    
    /**
     * write results to standard output
     * @param queue containing partial results
     */
	public static void stdWrite(Queue<String> valSet){
		PrintWriter writer = new PrintWriter(System.out, true);
		Iterator<String> iter = valSet.iterator();
		while(iter.hasNext()){
			writer.println(iter.next());
		}
		writer.close();
	}
    
    /**
     * sort the file
     * @param file name of the file to be sorted
     * @return name of sorted file
     */
	public static void sortFile(String fileName) throws Exception{
		File f = new File(fileName);
		SortedSet<String> s = new TreeSet<String>();
		FileReader fRead = new FileReader(f);
		BufferedReader reader = new BufferedReader(fRead);
		//build name of output file
        String fName = fileName.substring(0,fileName.lastIndexOf("/")+1) + "sorted-" + fileName.substring(fileName.lastIndexOf("/")+1);
        String curr = reader.readLine();
        boolean isFirst = true;
        while(curr != null){
        	//skip empty lines
        	if(!curr.trim().isEmpty()){
        	   s.add(curr);
        	   if(s.size() >= splitSize){
	        	 writeOutput(s,fName,isFirst);
	        	 isFirst = false;
                 s.clear();
	           }
        	}
        	curr = reader.readLine();
        	
        }
        reader.close();
        fRead.close();
        writeOutput(s, fName,isFirst);
	}
    
    /**
     * write contents of set into a file
     * @param set containing elements to be writter
     * @param name of output file
     */
	public static void writeOutput(SortedSet<String> s, String fileName, boolean isFirst) throws Exception{
		File output = new File(fileName);
		//delete file if it is previously exists
		if(output.exists() && isFirst){
			output.delete();
		}
		if(!output.exists()){
		   output.createNewFile();
		}
		FileWriter fWriter = new FileWriter(output, true);
		BufferedWriter writer = new BufferedWriter(fWriter);
		Iterator<String> iter = s.iterator();
		while(iter.hasNext()){
			writer.write(iter.next());
			writer.newLine();
		}
		writer.flush();
		if(writer != null){
			writer.close();
		}
		if(fWriter != null){
			fWriter.close();
		}
	}
    
    /**
     * print instructions for the program
     */
	public static void programInfo(){
        System.out.println("---------------- Usage ---------------------");
		System.out.println("To execute the program, type");
		System.out.println("   java MergeFile f1.txt f2.txt f3.txt ... ");  
		System.out.println();
		System.out.println("To redirect output to file, type ");
		System.out.println("   java MergeFile f1.txt [f2.txt] ... > output.txt ");
		System.out.println();
		System.out.println("NOTE: If unsorted file is detected, the program will output");
		System.out.println("a sorted version of the file and please use the output file");
		System.out.println("as arguments for program execution");
	}

}


/**
 * The MyFile object extracts important information
 * from the input file.
 */
class MyFile {
	private int fileNum;
	private int currLine = 0;
	private String currVal;
	private BufferedReader reader;
    
    /**
     * get file number
     * @return file number
     */
    public int getFileNum(){
    	return this.fileNum;
    }
    
    /**
     * set file number
     * @param file number
     */
    public void setFileNum(int fileNum){
    	this.fileNum = fileNum;
    }
    
    /**
     * get current line number
     * @return current line number
     */
    public int getCurrLine(){
    	return this.currLine;
    }
    
    /**
     * set current line number
     * @param current line number
     */
    public void setCurrLine(int currLine){
    	this.currLine = currLine;
    }
    
    /**
     * get current element it is reading
     * @return current element
     */
    public String getCurrVal(){
    	return this.currVal;
    }
    
    /**
     * set current-reading element
     * @param current element
     */
    public void setCurrVal(String currVal){
    	this.currVal = currVal;
    }
    
    /**
     * get BufferedReader for the file
     * @return bufferedreader
     */
    public BufferedReader getReader(){
    	return this.reader;
    }
    
    /**
     * set BufferedReader for the file
     * @param buffered reader
     */
    public void setReader(BufferedReader reader){
    	this.reader = reader;
    }
    
    /**
     * clone a new file using myFile
     * @return cloned file
     */
    public MyFile clone(){
    	MyFile cloneFile = new MyFile();
        cloneFile.setFileNum(getFileNum());
        cloneFile.setCurrLine(getCurrLine());
        cloneFile.setCurrVal(getCurrVal());
        cloneFile.setReader(getReader());
        return cloneFile;
    }
    
    /**
     * read next element in the file and update currVal
     * @return 1 if successfully read a new element 
     *         -1 if we reach the end of the file
     *         0 if unsorted file detected
     */
	public int nextVal() throws Exception{
		String readVal = this.reader.readLine();
		//if some empty lines exist between the words in the file
		//skip the empty lines
		while(readVal!=null && readVal.trim().isEmpty()){
			readVal = this.reader.readLine();
			this.currLine ++;
		}
		if(readVal != null){
			if(this.currVal.compareTo(readVal) > 0){
				return 0;
			}
			this.currVal = readVal;
			this.currLine ++;
			return 1;
		}else{
			this.reader.close();
			return -1;
		}
	}
    
    /**
     * get file information
     * @return file info
     */
	public String toString(){
		String info = "FileNum: " + getFileNum() + "; ";
		info += "CurrLine: " + getCurrLine() + "; ";
		info += "CurrVal: " + getCurrVal() + ".";
		return info;
	}
    
}

/**
 * Comparator for MyFile object
 * 
 * Compare currently-reading element of two files
 * If two elements are the same, compare by file number
 */
class MyFileComparator implements Comparator<MyFile>{
    public int compare(MyFile f1, MyFile f2){
    	String v1 = f1.getCurrVal();
    	String v2 = f2.getCurrVal();
    	if(v1.compareTo(v2) != 0){
    		return v1.compareTo(v2);
    	}else{
    		return f1.getFileNum() - f2.getFileNum();
    	}
    }
}