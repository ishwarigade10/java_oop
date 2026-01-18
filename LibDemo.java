import java.util.Scanner;
import java.io.*;
class Book {
    int bookId;
    String title;
    String author;

    void accept(Scanner sc) { 
        System.out.print("Enter Book ID: ");
        bookId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Book Title: ");
        title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        author = sc.nextLine();
	}
    

    void display() {
	
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Student {
    int studentId;
    String name;
    String course;

    void accept(Scanner sc) {
        System.out.print("Enter Student ID: ");
        studentId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();
    }

    void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

class Librarian {
    int librarianId;
    String name;

    void accept(Scanner sc) {
        System.out.print("Enter Librarian ID: ");
        librarianId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Librarian Name: ");
        name = sc.nextLine();
    }

    void display() {
        System.out.println("Librarian ID: " + librarianId);
        System.out.println("Name: " + name);
    }
}


class Library {
    String libraryName;
    String location;

    void accept(BufferedReader br)throws IOException {
        System.out.print("Enter Library Name: ");
        libraryName = br.readLine();

        System.out.print("Enter Library Location: ");
        location = br.readLine();
    }

    void display() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("Location: " + location);
    }
}

class Issue {
    int issueId;
    int bookId;
    int studentId;
    String issueDate;

    void accept(BufferedReader br)throws IOException {
        System.out.print("Enter Issue ID: ");
        issueId =Integer.parseInt(br.readLine());

        System.out.print("Enter Book ID: ");
        bookId = Integer.parseInt(br.readLine());


        System.out.print("Enter Student ID: ");
        studentId = Integer.parseInt(br.readLine());

        System.out.print("Enter Issue Date: ");
        issueDate = br.readLine();
    }

    void display() {
        System.out.println("Issue ID: " + issueId);
        System.out.println("Book ID: " + bookId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Issue Date: " + issueDate);
    }
}


public class LibDemo {
    public static void main(String[] args)throws IOException {

        Scanner sc = new Scanner(System.in);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int n;
	System.out.println("Enter no.of books");
	n=sc.nextInt();
	sc.nextLine();
        Book[] b = new Book[n];
        Student s = new Student();
        Librarian l = new Librarian();
        Library lib = new Library();
        Issue i = new Issue();

        System.out.println("\n--- Enter Book Details ---");
	for(int j=0;j<n;j++)
	{
	System.out.println("Book"+(j+1));
	b[j]=new Book();
        b[j].accept(sc);
	}

        System.out.println("\n--- Enter Student Details ---");
        s.accept(sc);

        System.out.println("\n--- Enter Librarian Details ---");
        l.accept(sc);

        System.out.println("\n--- Enter Library Details ---");
        lib.accept(br);

        System.out.println("\n--- Enter Issue Details ---");
        i.accept(br);

        System.out.println("\n------ DISPLAY DETAILS ------");
	for(int j=0;j<n;j++)
	{ 
	System.out.println("Book"+(j+1));
        b[j].display();
	}
        System.out.println();
        s.display();
        System.out.println();
        l.display();
	sc.close();
        System.out.println();
        lib.display();
        System.out.println();
        i.display();

            }
}
