package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import tests.*;

public class REMOVETEST {

	@Test
	public void test() {
//		ListUtilities util = new ListUtilities();
//		Node<Integer> input = 
//			new Node<>(23, 
//			new Node<>(46, 
//			new Node<>(19, 
//			new Node<>(-9, null))));
//		
//		Node<String> output = util.getAllPrefixes(input, 1, 4);
//		
//		assertEquals("[23]", output.getElement());
//		assertEquals("[23, 46]", output.getNext().getElement());
//		assertEquals("[23, 46, 19]", output.getNext().getNext().getElement());
//		assertEquals("[23, 46, 19, -9]", output.getNext().getNext().getNext().getElement()); 
//		assertNull(output.getNext().getNext().getNext().getNext());
//		
//		Node<String> output2 = util.getAllPrefixes(input, 2, 3);
//		
//		assertEquals("[23, 46]", output2.getElement());
//		assertEquals("[23, 46, 19]", output2.getNext().getElement()); 
//		assertNull(output2.getNext().getNext());
	
		ListUtilities util = new ListUtilities();
		/*
		 * Get a sequence interleaving elements from:
		 * 	- An arithmetic sequence, starting at 5 with a common difference 3, of size 4.
		 * 	- A Fibonacci sequence of size 5.
		 * 	  Recall. A Fibonacci sequence is infinite: <1, 1, 2, 3, 5, 8, 13, ...>
		 * (The interleaving starts with one element from the arith. seq., then one element from the Fib. seq., and so on.)  
		 */
		Node<Integer> output = util.getInterleavedArithmeticFibonacciSequences(5, 3, 4, 0);
		
		assertTrue(5 == output.getElement());
		assertTrue(8 == output.getNext().getElement());
		assertTrue(11 == output.getNext().getNext().getElement());
		assertTrue(14 == output.getNext().getNext().getNext().getElement());
		assertNull(output.getNext().getNext().getNext().getNext());
		
	}

}
