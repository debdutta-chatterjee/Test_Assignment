package com.automation.Test_Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Int_Arr_Sort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{7,1,3,5,4,6,7,1,3,2,6,5};
		
		
		System.out.println(getDuplicates(arr));

	}
	
	
	public static List<Integer> getDuplicates(int[] arr ) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<Integer> lst= new ArrayList<Integer>(1);
		
		//store in map
		for(int i: arr) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}
			else {
				//map.put(i, map.get(i)+1);
				lst.add(i);
				
			}
		}
		return lst;
	}

}
