package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLambdaDemo {

	public static void main(String[] args) {
	
        List<String> names = Arrays.asList("aish", "akshu", "veda", "kannan");

        List<String> uppercasedNamesLambda = names.stream()
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());
        
        List<String> uppercasedNamesMethodReference = names.stream()
                .map(String::toUpperCase) 
                .collect(Collectors.toList());

            System.out.println("Uppercased Names using method reference: " + uppercasedNamesMethodReference);

        System.out.println("Uppercased Names using lambda: " + uppercasedNamesLambda);

	}

}
