package main.java;// Java Program for traversing a
// ConcurrentHashMap
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	static ConcurrentHashMap<Integer, String> chmap
			= new ConcurrentHashMap<Integer, String>();

	public static void main(String[] args)
	{
		ConcurrentHashMapDemo traversingConcurrentHashMap = new ConcurrentHashMapDemo();
		Test2It test2It = new Test2It(traversingConcurrentHashMap);
		Test2It test3It = new Test2It(traversingConcurrentHashMap);
		test2It.start();
		test3It.start();
		chmap.remove(6);
		chmap.remove(3);
		// create an instance of ConcurrentHashMap

		/*while (itr1.hasNext()){
			itr1.next();
		}

		while (itr.hasNext()) {
			ConcurrentHashMap.Entry<Integer, String> entry
				= itr.next();
			System.out.println("Key = " + entry.getKey()
							+ ", Value = "
							+ entry.getValue());
		}*/
	}

	public void method1(){


		// Add elements using put()
		chmap.put(8, "Third");
		chmap.put(6, "Second");
		chmap.put(3, "First");
		chmap.put(11, "Fourth");

		// Create an Iterator over the
		// ConcurrentHashMap
		for (Map.Entry<Integer, String> entry : chmap.entrySet()) //using map.entrySet() for iteration
		{
//returns keys and values respectively
			System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
			chmap.remove(entry.getKey());
		}
		System.out.println(chmap.size());
	}
}

class Test2It extends  Thread{

	ConcurrentHashMapDemo traversingConcurrentHashMap;


	public Test2It(ConcurrentHashMapDemo traversingConcurrentHashMap){
		this.traversingConcurrentHashMap=traversingConcurrentHashMap;
	}
	@Override
	public void run() {
		traversingConcurrentHashMap.method1();
	}
}
