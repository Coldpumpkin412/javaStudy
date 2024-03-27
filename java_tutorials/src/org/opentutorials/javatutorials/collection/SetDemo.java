package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {

	public static void main(String[] args) {
		Collection<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		Iterator hi = A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
	}

}
