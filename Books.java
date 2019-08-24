package LibraryManagement;
import java.io.Serializable;
public class Books implements Serializable {
	
	private static final long serialVersionUID = 2L;
	String name;
	int id;
	String type;
	int count;
	public Books(String name, int id, String type, int count) {
		this.name = name;
		this.id = id;
		this.type = type;
		this.count = count;
		
	}
	void ShowBook() {
		System.out.println("-------------------------------------------");
		System.out.println("Book Name : "+name);
		System.out.println("Book ID is : "+id);
		System.out.println("Book Type is : "+type);
		System.out.println("Current No of this book in library : "+count);
		System.out.println("-------------------------------------------");
	}
	
	
}
