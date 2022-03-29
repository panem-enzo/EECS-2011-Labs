package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TreeUtilities;

public class REMOVE {

	@Test 
	public void test_getElementsOfRanks_5() {
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);
		TreeNode<Integer> n3 = new TreeNode<>(69);
		TreeNode<Integer> n4 = new TreeNode<>(92);
		TreeNode<Integer> n5 = new TreeNode<>(115);
		TreeNode<Integer> n6 = new TreeNode<>(138);
		TreeNode<Integer> n7 = new TreeNode<>(161);

		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);

		TreeUtilities u = new TreeUtilities();

		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 7);
		assertTrue(output.getElement() == 23);
		assertTrue(output.getNext().getElement() == 46);
		assertTrue(output.getNext().getNext().getElement() == 69);
		assertTrue(output.getNext().getNext().getNext().getElement() == 92);
		assertTrue(output.getNext().getNext().getNext().getNext().getElement() == 115);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getElement() == 138);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getNext().getElement() == 161);
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext());
	}

	@Test 
	public void test_getElementsOfRanks_6() {
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);
		TreeNode<Integer> n3 = new TreeNode<>(69);
		TreeNode<Integer> n4 = new TreeNode<>(92);
		TreeNode<Integer> n5 = new TreeNode<>(115);
		TreeNode<Integer> n6 = new TreeNode<>(138);
		TreeNode<Integer> n7 = new TreeNode<>(161);

		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);

		TreeUtilities u = new TreeUtilities();

		SLLNode<Integer> output = u.getElementsOfRanks(n2, 7, 7);
		assertTrue(output.getElement() == 161);
		assertNull(output.getNext());
	}

	@Test 
	public void test_getElementsOfRanks_7() {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(1);
		TreeNode<Integer> n3 = new TreeNode<>(1);
		TreeNode<Integer> n4 = new TreeNode<>(1);
		TreeNode<Integer> n5 = new TreeNode<>(1);
		TreeNode<Integer> n6 = new TreeNode<>(1);
		TreeNode<Integer> n7 = new TreeNode<>(1);

		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);

		TreeUtilities u = new TreeUtilities();

		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 7);
		assertTrue(output.getElement() == 1);
		assertTrue(output.getNext().getElement() == 1);
		assertTrue(output.getNext().getNext().getElement() == 1);
		assertTrue(output.getNext().getNext().getNext().getElement() == 1);
		assertTrue(output.getNext().getNext().getNext().getNext().getElement() == 1);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getElement() == 1);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getNext().getElement() == 1);
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext());
	}

	@Test 
	public void test_getElementsOfRanks_8() {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(1);
		TreeNode<Integer> n3 = new TreeNode<>(1);
		TreeNode<Integer> n4 = new TreeNode<>(1);
		TreeNode<Integer> n5 = new TreeNode<>(1);
		TreeNode<Integer> n6 = new TreeNode<>(1);
		TreeNode<Integer> n7 = new TreeNode<>(1000);

		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);
	}
}
