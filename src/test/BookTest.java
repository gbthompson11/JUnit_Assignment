package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project.Book;

public class BookTest {
	String testTitle, testAuthor, testISBN;
	Book testBook;
	
	@Before
	public void set_defaults() {
		// Set default globals for each test
		testTitle = "The book of test 1";
		testAuthor = "John Author";
		testISBN = "000001";
		testBook = new Book(testTitle, testAuthor, testISBN);
	}
	
	@Test
	public void t_getTitle() {
		assertEquals(testTitle, testBook.getTitle());
	}
	
	@Test
	public void t_getAuthor() {
		assertEquals(testAuthor, testBook.getAuthor());
	}
	
	@Test
	public void t_getIsbn() {
		assertEquals(testISBN, testBook.getIsbn());
	}
	
	@Test
	public void t_borrowBook() {
		assertTrue(testBook.isAvailable());
		testBook.borrowBook();
		assertFalse(testBook.isAvailable());
		
		try {
			testBook.borrowBook();
			fail("Allowed borrow of unavailable book");
		} catch (Exception e) {
			// all good
		}
	}
	
	@Test
	public void t_returnBook() {
		testBook.borrowBook();
		testBook.returnBook();
		assertTrue(testBook.isAvailable());
	}

}
