package integration_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project.Book;
import project.User;

public class BookUserTest {

	@Test
	public void test() {
		User testUser1 = new User("Alice", "1");
		Book testBook = new Book("b1", "t1", "i1");
		
		testUser1.borrowBook(testBook);
		assertFalse(testBook.isAvailable());
		
		testUser1.returnBook(testBook);
		assertTrue(testBook.isAvailable());
		
	}

}
