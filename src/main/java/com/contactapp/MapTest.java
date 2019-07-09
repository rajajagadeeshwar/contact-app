package com.contactapp;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
public static void main(String args[]) {
	// TODO Auto-generated method stub
	Map<Long, String> names = new HashMap<>();
	names.put(new Long(0), "Jag");
	System.out.println(names.get(0L));
	String oldName = names.put(0L, "Vank");

	System.out.println(names.get(0L));

	System.out.println(oldName);
	
	
}
}
