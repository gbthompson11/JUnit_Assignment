package test;

import static org.junit.Assert.*;

import org.junit.Test;

import project.Book;
import project.User;

import java.util.ArrayList;

public class UserTest {

	@Test
	public void testUser() {
		User testUser1 = new User("Alice", "1");
		
		assertEquals(testUser1.getName(), "Alice");
		assertEquals(testUser1.getUserId(), "1");
		
		Book testBook = new Book("b1", "t1", "i1");
		
		testUser1.borrowBook(testBook);
				
		ArrayList<Book> expected = new ArrayList<Book>();
		expected.add(testBook);
		
		assertEquals(testUser1.getBorrowedBooks(), expected);
		
		testUser1.returnBook(testBook);
		expected.remove(0);
		
		assertEquals(testUser1.getBorrowedBooks(), expected);
		
	}

}
