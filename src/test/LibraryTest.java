package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import project.Book;
import project.Library;
import project.User;

public class LibraryTest {

	public Library testLibrary;
	public User testUser1, testUser2;
	public Book testBook1, testBook2;
	
	@Before
	public void set_defaults() {
		testLibrary = new Library();
		
		testUser1 = new User("Alice", "1");
		testUser2 = new User("Bob", "2");
		
		testBook1 = new Book("Book 1", "Alison", "0001");
		testBook2 = new Book("Book 2", "Bobby", "0002");

	}
	
	@Ignore
	private void fillLibrary() {
		testLibrary.addBook(testBook1);		
		testLibrary.addBook(testBook2);
		testLibrary.registerUser(testUser1);
		testLibrary.registerUser(testUser2);
	}
	
	@Test
	public void t_getAverageBooksPerUser_noBorrows() {
		testLibrary.addBook(testBook1);
		
		assertEquals((int) (testLibrary.getAverageBooksPerUser() * 100), 0);
	}
	
	@Test
	public void t_displayAvailableBooks() {
		try {
			testLibrary.displayAvailableBooks();
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void t_getAvailableBooks() {
		fillLibrary();
		
		assertEquals(testLibrary.getAvailableBooks().size(), 2);
		testLibrary.borrowBook("1", "0001");
		assertEquals(testLibrary.getAvailableBooks().size(), 1);
	}
	
	@Test
	public void t_getTotalNumberOfBooks() {
		fillLibrary();
		
		assertEquals(testLibrary.getTotalNumberOfBooks(), 2);
		testLibrary.borrowBook("1", "0001");
		assertEquals(testLibrary.getTotalBorrowedBooks(), 1);
	}

}
