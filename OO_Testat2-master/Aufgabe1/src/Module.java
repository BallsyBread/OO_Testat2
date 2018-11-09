import java.util.ArrayList;

public class Module {

	String name;
	ArrayList<String> prerequisite;

	Module(String name, ArrayList<String> prerequisite) {
		this.name = name;
		this.prerequisite = prerequisite;
	}
}
