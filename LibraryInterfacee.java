import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
//----------------Interface-------------
interface Identity{
int getID();   //Abstract Method
default void whoamI()			//Default Method 
{
System.out.println("I belongs to the Library System");
}

}
interface Printable{
void printdetails();
}
interface LibraryMember extends Identity,Printable{
}
//-----------------Person---------------
abstract class Person implements LibraryMember{
int id;
Person(int id) {
	this.id=id;
        System.out.println("Person constructor");
    }
public int getID()
{
 return id;
}
public abstract void display();		//Abstract method in Abstract class

public void show(){
System.out.println("Persons ID:"+id);
}
}

// ---------------- Student ----------------
class Student extends Person implements Library.Rules{
    String name;
    String course;
	Student(int id)
		{
		super(id);
		}

	public void followrules()
		{
		 System.out.println("Student must maintain Silence in Library");
		 System.out.println("Books Should be return in Proper condition");

		}
    void accept(Scanner sc) {
        try {
      
            System.out.print("Enter Student Name: ");
            name = sc.nextLine();

            System.out.print("Enter Course: ");
            course = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numeric Student ID.");
            sc.nextLine();
        }
    }
   public void show()				//METHOD OVERRIDING
	{
	System.out.println("I am Student");
	}
       public void display() {
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
   
   public void printdetails(){
		System.out.println("Student Library Time 10:30 AM to 12:30 PM and 1:20 PM to 5:00 PM");
	}
}

// ---------------- Librarian ----------------
class Librarian extends Person{
    String name;
    Librarian(int id)
	{ 
	super(id);					// SUPER() calls the parent class constructor
	System.out.println("Librarian Constructor");
         }
    void accept(Scanner sc) {
        try {
           
            System.out.print("Enter Librarian Name: ");
            name = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numeric Librarian ID.");
            sc.nextLine();
        }
    }

   public void display() {
     
        System.out.println("Name: " + name);
    }
	public void printdetails(){
		System.out.println("Librarian should do Biometrics process before 10:00 AM");
  }
}

// ---------------- Book ----------------
final class Book {	//Basically we stops inheritance [class Book is final]
    int bookId;
    String title;
    String author;

    void accept(Scanner sc) {
        try {
            System.out.print("Enter Book ID: ");
            bookId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Title: ");
            title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            author = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numeric Book ID.");
            sc.nextLine(); // clear buffer
        }
    }

    void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}


// ---------------- Library ----------------
class Library {
    String libraryName;
    String location;
    
    interface Rules{		//NESTED INTERFACE
	void followrules();
	}

    void accept(BufferedReader br) {
        try {
            System.out.print("Enter Library Name: ");
            libraryName = br.readLine();

            System.out.print("Enter Library Location: ");
            location = br.readLine();
        } catch (IOException e) {
            System.out.println("Input error while reading Library details.");
        }
    }

    void display() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("Location: " + location);
    }
}

// ---------------- Issue ----------------
class Issue {

    final int bookId=101;
    int stock;
    int no_of_book;
    String issueDate;

    void accept(BufferedReader br) throws IOException {
        System.out.print("Enter stock: ");
        stock = Integer.parseInt(br.readLine());

        System.out.print("Enter number of books to issue: ");
        no_of_book = Integer.parseInt(br.readLine());

        System.out.print("Enter issue date: ");
        issueDate = br.readLine();
    }

    // Method overloading
    void issueBook(int qty) {
        if (qty <= stock) {
            stock -= qty;
            System.out.println(qty + " book(s) issued");
        } else {
            System.out.println("Insufficient stock");
        }
    }

    void issueBook(String date) {
        System.out.println("Issued on: " + date);
    }

    void display() {
        issueBook(no_of_book);
        issueBook(issueDate);

        System.out.println("Book ID: " + bookId);
        System.out.println("Remaining stock: " + stock);
    }
}


// ---------------- Main Class ----------------
public class LibraryInterfacee {
    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();
        Book[] b = new Book[n];  	

        System.out.println("\n--- Enter Book Details ---");
        for (int j = 0; j < n; j++) {
            System.out.println("Book " + (j + 1));
            b[j] = new Book();
            b[j].accept(sc);
        }

        System.out.println("\n--- Enter Student Details ---");
	System.out.println("Enter Student ID:");
	int sid=sc.nextInt();
	sc.nextLine();
	Student s=new Student(sid);
	s.printdetails();
        s.accept(sc);

	System.out.println();
        System.out.println("\n--- Enter Librarian Details ---");
	System.out.println("Enter Librarian ID");
	int lid=sc.nextInt();
	sc.nextLine();
	Librarian l=new Librarian(lid);
	l.printdetails();
	l.whoamI();
        l.accept(sc);
	Library lib=new Library();
        System.out.println("\n--- Enter Library Details ---");
        lib.accept(br);

	Issue i = new Issue();

        System.out.println("\n--- Enter Issue Details ---");
        i.accept(br);

        System.out.println("\n------ DISPLAY DETAILS ------");
        for (int j = 0; j < n; j++) {
            System.out.println("\nBook " + (j + 1));
            b[j].display();
        }
        System.out.println();
        s.show();

        System.out.println("-----Student details-----");
	s.followrules();
        s.display();				//Displays Student Details
        System.out.println("-----Librarian details------");
        l.display();				//Displays Librarian Details
	System.out.println("------Library details------");
	lib.display();				//Displays Library Details
        System.out.println("------Issue details-------");
        i.display();				//Displays Issue Details

        sc.close();				//Scanner close..
    }
}
