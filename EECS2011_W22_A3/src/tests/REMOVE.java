package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TreeUtilities;

public class REMOVE {

	@Test
	public void test_getInfixTree_03() {
		TreeUtilities u = new TreeUtilities();
		
		Expression operand1 = new Operand(23);
		Expression operand2 = new Operand(46);
		Expression operand3 = new Operand(69);
		Expression operator1 = new Operator('+');
		Expression operator2 = new Operator('*');
		
		/* Create a postfix expression "23 46 69 * +" */
		SLLNode<Expression> expression = 
			new SLLNode<>(operand1, 
			new SLLNode<>(operand2, 
			new SLLNode<>(operand3,
			new SLLNode<>(operator2, 
			new SLLNode<>(operator1, null)))));
		
		/* 
		 * Expected to return a tree storing the infix expression `23 + (46 * 69)`
		 * Note: The parentheses here are only meant to indicate the order of evaluation: they need not be stored in the output tree. 
		 */
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		/*
		 * Hint: Visualize what tree structure is being asserted by the tests.
		 * See TestGeneralTrees on how to use SLLNode and TreeNode. 
		 */  
		SLLNode<TreeNode<Expression>> levelOneChild1 = root.getChildren();
		SLLNode<TreeNode<Expression>> levelOneChild2 = levelOneChild1.getNext();
		assertNull(levelOneChild2.getNext());
		SLLNode<TreeNode<Expression>> levelTwoChild1 = levelOneChild2.getElement().getChildren();
		SLLNode<TreeNode<Expression>> levelTwoChild2 = levelTwoChild1.getNext();
		assertNull(levelTwoChild2.getNext());
		
		assertTrue(root.getElement() == operator1);
		assertTrue(levelOneChild1.getElement().getElement() == operand1);
		assertTrue(levelOneChild2.getElement().getElement() == operator2);
		assertTrue(levelTwoChild1.getElement().getElement() == operand2);
		assertTrue(levelTwoChild2.getElement().getElement() == operand3);
		
		assertNull(root.getParent());
		assertTrue(root == levelOneChild1.getElement().getParent());
		assertTrue(root == levelOneChild2.getElement().getParent());
		assertTrue(levelOneChild2.getElement() == levelTwoChild1.getElement().getParent());
		assertTrue(levelOneChild2.getElement() == levelTwoChild2.getElement().getParent());
		assertNull(levelOneChild1.getElement().getChildren());
		assertNull(levelTwoChild1.getElement().getChildren());
		assertNull(levelTwoChild2.getElement().getChildren());
	}

}
