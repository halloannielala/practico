import java.util.*;

class Dog implements Comparable<Dog>{
	String name;
	int age;
	int weight;
	int height;

	public int compareTo(Dog d){
		return weight - d.weight;
	}

	Dog(String n, int a, int w, int h){
		name = n;
		age = a;
		weight = w;
		height = h;
	}

	public String toString(){
		return name + " is " + age + " yrs old and " + weight + " lbs";
	}
}

public class ComparatorGenericsTest{
	public static void main(String[] args){
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("Barfy", 2, 15, 10));
		dogs.add(new Dog("Odie", 5, 30, 15));
		dogs.add(new Dog("Tiny", 6, 8, 6));
		dogs.add(new Dog("Dummy", 7, 20, 13));

		class NameCompare implements Comparator<Dog>{
			public int compare(Dog one, Dog two){
				return one.name.compareTo(two.name);
			}
		}

		class AgeCompare implements Comparator<Dog>{
			public int compare(Dog one, Dog two){
				return one.age - two.age;
			}
		}


		System.out.println("Unsorted " + dogs);
		Collections.sort(dogs);
		System.out.println("Sorted with comparable, weight " + dogs);
		NameCompare nameCompare = new NameCompare();
		Collections.sort(dogs, nameCompare);
		System.out.println("Sorted with nameCompare " + dogs);
		Collections.sort(dogs, new AgeCompare());
		System.out.println("Sorted with ageCompare " + dogs);
	}
}