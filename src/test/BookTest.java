package test;
import static org.junit.Assert.*;

import org.junit.Test;

import project.Book;

public class BookTest {

	@Test
	public void testBook() {
		String testTitle = "The book of test 1";
		String testAuthor = "John Author";
		String testISBN = "000001";
		Book testBook = new Book(testTitle, testAuthor, testISBN);
		
		assertEquals(testTitle, testBook.getTitle());
		assertEquals(testAuthor, testBook.getAuthor());
		assertEquals(testISBN, testBook.getIsbn());
		
		testBook.borrowBook();
		
		assertFalse(testBook.isAvailable());
		
		testBook.returnBook();
		
		assertTrue(testBook.isAvailable());

	}

}
