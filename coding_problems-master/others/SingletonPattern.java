//Medallia

//Singleton Design Pattern

public class SingletonPatter{
	public static void main(String[] args){
		SingleObject obj = SingleObject.getInstance();
		obj.message();
	}

}

public class SingleObject{
	//create an instance
	private static SingleObject instance = new SingleObject();
    
    //constructor is priavate, so class cannot be initiated
	private SingleObject(){};

	//get the only instance
	public static SingleObject getInstance(){
		return instance;
	}

	public void message(){
		System.out.println("Hello world");
	}
}