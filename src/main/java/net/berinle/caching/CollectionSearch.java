package net.berinle.caching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSearch {
	public static void main(String[] args) {
		List<Integer> alist = new ArrayList<Integer>();
		for(int i=0; i<30000; i++){
			alist.add(i);
		}
		
		for(int i=0; i<100; i++){
			long start = System.currentTimeMillis();
			//find(25908, alist);
			
			Collections.binarySearch(alist, 25908);
			
			long end = System.currentTimeMillis();
			System.out.println(" time elapsed: " + (end - start) + " ms");
		}
		
	}
	
	//Linear search
	public static Integer find(int val, List list){
		for(int i=0; i<list.size(); i++){
			if(val == (Integer)list.get(i)){
				return val;
			}
		}
		return null;
	}
}
