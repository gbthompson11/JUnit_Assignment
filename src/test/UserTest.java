package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project.Book;
import project.User;

import java.util.ArrayList;

public class UserTest {
	User testUser1;
	Book testBook;

	@Before
	public void set_defaults() {
		testUser1 = new User("Alice", "1");
		testBook = new Book("b1", "t1", "i1");
	}
	
	@Test
	public void t_getName() {
		assertEquals(testUser1.getName(), "Alice");
	}
	
	@Test
	public void t_getUserId() {
		assertEquals(testUser1.getUserId(), "1");
	}
	
	@Test
	public void t_borrowBook() {
		testUser1.borrowBook(testBook);
		
		ArrayList<Book> expected = new ArrayList<Book>();
		expected.add(testBook);
		
		assertEquals(testUser1.getBorrowedBooks(), expected);
	}
	
	@Test
	public void t_returnBook() {		
		testUser1.borrowBook(testBook);
		testUser1.returnBook(testBook);
		
		ArrayList<Book> expected = new ArrayList<Book>();
		assertEquals(testUser1.getBorrowedBooks(), expected);
		
	}

}
