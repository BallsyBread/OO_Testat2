import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Module> modules = getfromfile("StudyCatalogue.txt");
		
		
		for(Module m : modules) {
			System.out.println(m.name+" Prerequisites: ");
			for(String s : m.prerequisite) {
				System.out.println("- "+s);
			}
		}
	}
	
	static ArrayList<Module> getfromfile(String filename) throws Exception{
		
		ArrayList<Module> modules = new ArrayList<Module>();
		
		try (var reader = new CatalogueReader(filename)) {
			String[] names;
			while ((names = reader.readNexteLine()) != null) {
				
				ArrayList<String> prerequisites = new ArrayList<String>();
				
				for (int i = 1; i < names.length; i++) {
					prerequisites.add(names[i]);
				}
				modules.add(new Module(names[0], prerequisites));
			}
		}
		return modules;
	}
}
