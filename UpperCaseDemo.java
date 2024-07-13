package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseDemo {

	public static void main(String[] args) {
		
        List<String> names = Arrays.asList("aish", "akshu", "veda", "kannan");

        List<String> uppercasedNames = names.stream()
                .map(String::toUpperCase) 
                .collect(Collectors.toList()); 

        
        System.out.println("Uppercase Names: " + uppercasedNames);

	}

}
