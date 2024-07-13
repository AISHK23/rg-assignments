package java8;
import java.util.Optional;

public class OptionalExample {
	
	private static Optional<Integer> assignNumberOfStudents(Integer value) {
        return Optional.of(value); 
    }

	public static void main(String[] args) {
		Optional<Integer> number_of_students_full_class = Optional.empty();
		Optional<Integer> number_of_students_empty_class = Optional.empty();
		number_of_students_full_class=assignNumberOfStudents(20);
		if(number_of_students_full_class.isPresent())
		{
			System.out.println("Register number of the last student in full class: " + number_of_students_full_class.get());
		}
		
		Integer rollno=number_of_students_empty_class.orElse(1);
		System.out.println("Register number of the last student in empty class: " + rollno);
	}
}
