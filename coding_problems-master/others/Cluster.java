// Vecna
// find number of clusters that contain >=4 infected patients


import java.util.*;
public class Cluster{
	public static void main(String[] args){
		 int[][] patients= new int[][]{
			{1,0,0,1,1,1,1,1},
			{1,1,0,0,0,0,0,1},
			{1,0,0,0,1,0,0,1},
			{1,0,0,0,1,0,1,1},
		};
		System.out.println(numberCluster(patients));

	}

	public static int numberCluster(int[][] patients){
		int res = 0;
        int row = patients.length;
        int col = patients[0].length;
        
        //traverse all patients
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				//if unvisited infected patient found, do BFS
				if(patients[i][j] == 1){
					//patients in the cluster needs to be >=4
					if(checkCluster(patients, i,j) >= 4){
						res++;
					}
				}
			}
		}
		return res;
	}

	public static int checkCluster(int[][] patients, int i, int j){
		int num = 0;

		//four directions: up, right, down, left
		int[] tryRow = new int[]{-1,0,1,0};
		int[] tryCol = new int[]{0,1,0,-1};
		int currX = i;
		int currY = j;

        //store row and col index of unvisited infected neighbor
		Queue<Integer> r = new LinkedList<Integer>();
		Queue<Integer> c = new LinkedList<Integer>();

		while(true){
			//try four directions
			for(int pos=0; pos<4; pos++){
				//store unvisited infected neighbors if found
				if(checkInfected(patients, currX+tryRow[pos], currY+tryCol[pos])){
                     r.add(currX+tryRow[pos]);
                     c.add(currY+tryCol[pos]);
				}
			}
			//previously, i use 2d boolean array
			//here, i can just reset value to 0 to flag it as visited
			patients[currX][currY] = 0;
            
            //stop if no unvisited infected neighbors
			if(r.isEmpty() && c.isEmpty()){
				break;
			}
            
            //increment number of patients in the cluster
            num++;

            //repeat the same procedure on the neighbors
			currX = r.remove();
			currY = c.remove(); 
		}
		return num;
	}


	public static boolean checkInfected(int[][] patients, int x, int y){
		//check if neighbor index is in range
		boolean inRange = (x>=0)&&(x<patients.length)&&(y>=0)&&(y<patients[0].length);
		if(!inRange){
			return false;
		}
		//check if neighbor is unvisited and infected
		boolean isUnvistedInfected = patients[x][y]==1;
		return isUnvistedInfected && inRange;
	}


}