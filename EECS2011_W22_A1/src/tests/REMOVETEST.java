package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;

public class REMOVETEST {

	@Test
	public void test() {
		ListUtilities util = new ListUtilities();
		Node<Integer> input = 
			new Node<>(23, 
			new Node<>(46, 
			new Node<>(19, 
			new Node<>(-9, null))));
		
		Node<String> output = util.getAllPrefixes(input, 1, 4);
		
		assertEquals("[23]", output.getElement());
		assertEquals("[23, 46]", output.getNext().getElement());
		assertEquals("[23, 46, 19]", output.getNext().getNext().getElement());
		assertEquals("[23, 46, 19, -9]", output.getNext().getNext().getNext().getElement()); 
		assertNull(output.getNext().getNext().getNext().getNext());
		
	}

}
