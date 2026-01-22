import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
//-----------------Person---------------
abstract class Person{
Person() {
        System.out.println("Person constructor");
    }

public abstract void display();		//Abstract method in Abstract class

public void show(){
System.out.println("I am  Person");
}

}

// ---------------- Student ----------------
class Student extends Person{
    int studentId;
    String name;
    String course;

    void accept(Scanner sc) {
        try {
            System.out.print("Enter Student ID: ");
            studentId = sc.nextInt();
            sc.nextLine();

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
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

// ---------------- Librarian ----------------
class Librarian extends Person{
    int librarianId;
    String name;
    Librarian()
	{ 
	super();					// SUPER() calls the parent class constructor
	System.out.println("Librarian Constructor");
         }
    void accept(Scanner sc) {
        try {
            System.out.print("Enter Librarian ID: ");
            librarianId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Librarian Name: ");
            name = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numeric Librarian ID.");
            sc.nextLine();
        }
    }

   public void display() {
        System.out.println("Librarian ID: " + librarianId);
        System.out.println("Name: " + name);
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

    final int bookId;
    int stock;
    int no_of_book;
    String issueDate;

    Issue(int bookId) {
        this.bookId = bookId;
    }

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
public class Librarydemo {
    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();
        Book[] b = new Book[n];
        Student s = new Student();
        Librarian l = new Librarian();
        Library lib = new Library();
  

        System.out.println("\n--- Enter Book Details ---");
        for (int j = 0; j < n; j++) {
            System.out.println("Book " + (j + 1));
            b[j] = new Book();
            b[j].accept(sc);
        }

        System.out.println("\n--- Enter Student Details ---");
        s.accept(sc);

        System.out.println("\n--- Enter Librarian Details ---");
        l.accept(sc);

        System.out.println("\n--- Enter Library Details ---");
        lib.accept(br);

	System.out.println("Enter Book ID to Issue");
	int bid=Integer.parseInt(br.readLine());
	Issue i = new Issue(bid);

        System.out.println("\n--- Enter Issue Details ---");
        i.accept(br);

        System.out.println("\n------ DISPLAY DETAILS ------");
        for (int j = 0; j < n; j++) {
            System.out.println("\nBook " + (j + 1));
            b[j].display();
        }
        System.out.println();
        s.show();

        System.out.println();
        s.display();
        System.out.println();
        l.display();
        System.out.println();
        lib.display();
        System.out.println();
        i.display();

        sc.close();
    }
}
