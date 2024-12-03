package integration_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import project.Book;
import project.Library;
import project.User;

public class UserLibraryTest {
	
	public Library testLibrary;
	public User testUser1, testUser2;
	public Book testBook1, testBook2;
	
	@Before
	public void set_defaults() {
		// Set default globals for each test
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
	public void t_borrowBook() {
		testLibrary.addBook(testBook1);		
		testLibrary.addBook(testBook2);
		testLibrary.registerUser(testUser1);

		// "2" not registered
		try {
			testLibrary.borrowBook("2", "0001");
			fail("IllegalStateException expected");
		} catch (Exception e) {
			// all good
		}
		
		testLibrary.borrowBook("1", "0001");
		
		assertFalse(testBook1.isAvailable());
		assertEquals(testUser1.getBorrowedBooks().size(), 1);
		
		testLibrary.registerUser(testUser2);

		// "0001" already borrowed
		try {
			testLibrary.borrowBook("2", "0001");
			fail("IllegalStateException expected");
		} catch (Exception e) {
			// all good
		}

	}
	
	@Test
	public void t_getAverageBooksPerUser() {
		fillLibrary();
		
		testLibrary.borrowBook("1", "0001");
		
		// expected return: 0.5, *10=5 to avoid floating point equality
		assertEquals((int) (testLibrary.getAverageBooksPerUser() * 10), 5);
	}

	@Test
	public void t_returnBook() {
		fillLibrary();
		testLibrary.borrowBook("1", "0001");
		
		// "1" has not borrowed "0002"
		try {
			testLibrary.returnBook("1", "0002");
			fail("IllegalStateException expected");
		} catch (Exception e) {
			// all good
		}	
		
		testLibrary.returnBook("1", "0001");
		assertTrue(testBook1.isAvailable());
		assertEquals(testUser1.getBorrowedBooks().size(), 0);

		
	}

}
