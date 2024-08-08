package com.collections;

import java.lang.reflect.Method;

public class MyAnnotationTest {
	    public static void main(String[] args) throws NoSuchMethodException {
	        // Get the class object
	        Class<MyClass> x = MyClass.class;
     // Get the method object
	        Method method = x.getMethod("myAnnotatedMethod");

	        // Check if the annotation is present
	        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
	            // Get the annotation instance
	            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);

	            // Access annotation elements
	            String value = annotation.value();
	            int count = annotation.count();

	            System.out.println("Annotation value: " + value);
	            System.out.println("Annotation count: " + count);
	        }
	    }
	}