package StreamAPI.casestudy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	public static void main(String[] args) {
	
		//list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		
		
		//list city and count of candidates per city
		System.out.println("Candidate count per city");
		
		//list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		
		//list fresher candidates
		System.out.println("Fresher Candidate list");
		
		//listing candidates with highest experience

		//first find out the highest years of experience value
		
		System.out.println("Sorted List of Candidates by Experience");
		
		
	
		
		//sort the candidates by city name
		printLine();
		System.out.println("Sorted List of Candidates by City Name");
		
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}
}
