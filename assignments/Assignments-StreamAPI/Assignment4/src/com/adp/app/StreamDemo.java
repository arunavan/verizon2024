package com.adp.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		Stream<Integer> intStream = Stream.of(10,20,15,35,20,55);
		intStream.forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		Integer intArr[] = {1,2,3,4,5};
		Arrays.stream(intArr).map(n->n*n).forEach(System.out::println);
		
		  
		Object squaredInts[] = Arrays.stream(intArr).map(n->n*n).toArray();
		Arrays.stream(squaredInts).forEach(System.out::println);
		
		System.out.println("----------------------------------------");
		
		List<String> namesList= new ArrayList<>();
		namesList.add("Ravi");
		namesList.add("Vinod");
		namesList.add("Rohit Sharma");
		namesList.add("Virat Kohli");
		
		System.out.println("Total names: "+ namesList.stream().count());
		
		System.out.println("----------------------------------------");
		
		List<String> namesListUpdated=
				namesList.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(namesListUpdated);
		//display names which has at least 5 characters in upper case
		
		
		List<String> filteredList = namesList.stream()
									.filter(s->s.length()>=5)
									.map(s->s.toUpperCase()).toList();
		
		filteredList.stream().forEach(System.out::println);
		
		System.out.println("----------------------------------");
		int marks[]= {67,78,90,85,57,45,95};
		//display minimum and maximum marks
		OptionalInt optionalInt1 = Arrays.stream(marks).min();
		if(optionalInt1.isPresent()) {
			System.out.println("Minimum Marks = "+ optionalInt1.getAsInt());
		}
		
		
		OptionalInt optionalInt2 = Arrays.stream(marks).max();
		if(optionalInt2.isPresent()) {
			System.out.println("Maximum Marks = "+ optionalInt2.getAsInt());
		}
		
		//display sorted list of marks
		System.out.println("Sorted list of marks..");
		Arrays.stream(marks).sorted().forEach(System.out::println);
		
		//display sum of the list of marks
		int total= Arrays.stream(marks).sum();
		System.out.println("Total Marks = "+ total);
		
		//display sum of squares of the list of marks
		
		OptionalInt optional = Arrays.stream(marks).map(n->n*n).reduce((a,b)->a+b);
		System.out.println("Sum of squares of marks..."+ optional.getAsInt());
			
		
		
		System.out.println("----------------------------");
		int[] ints = {1,2,3,4,5};
		List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
		System.out.println(list);
		System.out.println("----------------------------------");
		//Following works in JDK 16 and above
		list = Arrays.stream(ints).boxed().toList();
		System.out.println(list);
		
		System.out.println("Special filters, limit() and skip()...");
		
		int totalPayroll[] = {75000,50000,195000,245000,165000};
		List<Integer> payrollList = Arrays.stream(totalPayroll).boxed().toList();
						
		System.out.println("Displaying first 3 payrolls...");
		payrollList.stream().limit(3).forEach(System.out::println);
		
		System.out.println("Displaying last 3 payrolls...");
		payrollList.stream().skip(3).forEach(System.out::println);
		
		

	}

}
