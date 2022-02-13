package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import tests.*;

public class REMOVETEST {

	@Test
	public void test() {

		ListUtilities util = new ListUtilities();

		Node<String> input = 
				new Node<>("vwxyzj", 
						new Node<>("xy", 
								new Node<>("ghic", 
										new Node<>("pqrstu", 
												new Node<>("def", 
														new Node<>("bc", 
																new Node<>("a", 
																		new Node<>("", null))))))));
		
		Node<String> output = util.getGroupedStrings(input, 2, 4);
		
		/* 
		 * Group 1: strings from the input chain whose lengths are 
		 * 	less than 2 (i.e., 0, 1) 
		 */
		assertEquals("a"		, output.getElement());
		assertEquals(""			, output.getNext().getElement());
		/* 
		 * Group 2: strings from the input chain whose lengths are 
		 * 	greater than or equal to 2 and less than 4 (i.e., 2, 3) 
		 */
		assertEquals("xy"		, output.getNext().getNext().getElement());
		assertEquals("def"		, output.getNext().getNext().getNext().getElement());
		assertEquals("bc"		, output.getNext().getNext().getNext().getNext().getElement());
		/* 
		 * Group 3: strings from the input chain whose lengths are 
		 * 	greater than or equal to 4 (i.e., 4, 5, ...) 
		 */
		assertEquals("vwxyzj"	, output.getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals("ghic"		, output.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals("pqrstu"	, output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());
	}

}
