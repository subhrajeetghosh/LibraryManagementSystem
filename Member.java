package LibraryManagement;
import java.io.Serializable;
public class Member implements Serializable {
   
	private static final long serialVersionUID = 1L;
	String Name;
    int Id;
    int BookId = 0;
    String Date;
    String SubDate;
    int Fine;
    public Member(String Name, int Id, int CurrentBook, String date, String subdate, int fine) {
        this.Name = Name;
        this.Id = Id; 
        this.BookId = CurrentBook;
        this.Date = date;
        this.SubDate = subdate;
        this.Fine = fine;
    }
    
    void ShowMember () {
        System.out.println("--------------------------------------");
        System.out.println("Name Of The Member : "+Name);
        System.out.println("UID No of Memeber : "+Id);
        System.out.println("Current Book Id : "+BookId);
        System.out.println("Date in which book issued : "+Date);
        System.out.println("Date of submission : "+SubDate);
        System.out.println("Fine : "+Fine+" rupees");
        System.out.println("--------------------------------------");
    }
}