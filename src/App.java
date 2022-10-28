import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		List<Animal> animals = new ArrayList<>();
		for (String done = "done"; !done.equalsIgnoreCase(userInput);) {

			System.out.println(
					"What animal do you see and how many? Make sure you include the number first, followed by the animal.");
			userInput = scan.nextLine();
			if (!done.equalsIgnoreCase(userInput)) {
				String[] splitUserInputList = userInput.split("(?<=\\d)(?=\\D)");
				Animal animal = new Animal(splitUserInputList[1].trim(), Integer.parseInt(splitUserInputList[0]));
				animals.add(animal);
			}
		}
		scan.close();
		System.out.println();
		printAnimals(animals);
		System.out.println();
		System.out.println("There are " + countFamilies(animals) + " families.");
	}

	List<Animal> animals = new ArrayList<>();

	public static void printAnimals(List<Animal> animals) {
		animals.forEach((animal) -> System.out.println(animal.name + ": " + animal.count));
	}

	public static int countFamilies(List<Animal> animals) {
		int count = 0;
		for (Animal animal : animals) {
			if (animal.isFamily())
				count++;
		}
		return count;
	}
}