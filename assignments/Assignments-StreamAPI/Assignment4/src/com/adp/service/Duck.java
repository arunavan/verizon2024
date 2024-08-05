package com.adp.service;
/**
 * 
 * @author sriniva1
 *
 * this reference: reference to invoking object
 * 
 * this() method:
 *  to invoke one constructor from within another constructor method.
 *  Note: to eliminate boilerplate (repetitive) code
 */
public class Duck {
	private String breed;
	private String color;
	private Double weight;
	
	private static Integer duckCount;
	
	//initialize static data members, use static block
	//executed during class loading by classloader
	static {
		duckCount=0;
	}
	
	//default constructor
	public Duck() {
		this(null,null,null);
	}
	
	
	public Duck(String breed) {
		this(breed,null,null); //invoking 3-arg constructor
		
	}
	

	public Duck(String breed, String color) {
		this(breed,color,null); ////invoking 3-arg constructor
		
	}


	//all-arg constructor
	// Duck duck= new Duck("","",1.5); here this is duck
	/*
	 * duck1.getColor(); "this" will contain the invoking object which is duck1
	 * duck2.getCOlor();  this" will contain the invoking object which is duck2
	 */
	public Duck(String breed, String color, Double weight) {
		super();
		this.breed = breed;
		this.color = color;
		this.weight = weight;
		duckCount++;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public static Integer getDuckCount() {
		return duckCount;
	}

	@Override
	public String toString() {
		return "Duck Details: \nBreed:" + breed + "\nColor:" + color + "\nWeight:" + weight ;
	}
	
	
	
	

}
