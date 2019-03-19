package com.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	/*public static void main(String[] args) {
		String x="14243,12,2017,0,0,0,0,,0,0,155670,155000,0,0,0,43070,1589413,43071.62674,SAI,murali.b,,,,,,,43071.62674,,,,";
		
		String[] y=x.split(",",-1);
		System.out.println(y.length);
		for(String abc : y){
			System.out.println(abc);
		}
	}*/
	
	/*private static void m1(String val){
		System.out.println("string "+val);
	}
	private  void m1(Object val1){
		System.out.println("onj "+val1);
	}
	
	public static void main(String[] args) {
		try {
			
			m1(null);
			Test t  = new Test();
			t.m1(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*public static void main(String[] args) { // hash code and equals
		Map<Employee, String> objMap = new HashMap<>();
		Map<Integer, String> map = new HashMap<>();
		Employee e= new Employee(1);
		Employee e1= new Employee(1);
		objMap.put(e, "Sudha");
		objMap.put(e1, "Sudha");
		System.out.println(objMap.size());
		
		
		Integer i = new Integer(1);
		Integer i1 = new Integer(1);
		
		map.put(i, "Sudha");
		map.put(i1, "Sudha");
		System.out.println(map.size());
	}*/
	
	
	public static void main(String[] args) {
		String[] array = {"sudha","sudha","solomon","birapogu"};
		
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		
		for(int i= 0 ; i<array.length; i++){
			System.out.println(array[i]);
			for(int j= 0;j< array.length; j++){
				if(array[i]==array[j] && i != j){
					System.out.println("duplicate "+array[i]);
				}
			}
		}
	}
}



/*class Employee{  //hash code
	int id;
	
	Employee(int id){
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}*/
