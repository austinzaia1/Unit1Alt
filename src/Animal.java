
public class Animal {

	String name;
	int count;

	public Animal(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public boolean isFamily() {
		if (count >= 2) {
			return true;
		} else {
			return false;
		}
	}
}