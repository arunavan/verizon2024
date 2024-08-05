package com.adp.service;

import java.util.List;
import java.util.Map;

public interface IDuck {
	List<String> getAllBreeds(List<Duck> duckList);
	Duck getDuckWithMaxWeight(List<Duck> duckList);
	void showDucksSortedByWeight(List<Duck> duckList);
	//returns a Map where key is breed and values number ducks with that breed
	Map<String,Integer> getBreedCount(List<Duck> duckList);
}
