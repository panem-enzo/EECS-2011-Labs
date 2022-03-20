package model;

import tests.*;

public class TreeUtilities<Integer> {

	public SLLNode<TreeNode<Integer>> getElementsOfRanks(TreeNode<Integer> root, int lower, int upper) {





		return null;

	}

	private SLLNode<TreeNode<Integer>> getElementsOfRanksHelper(SLLNode<TreeNode<Integer>> input) {

		SLLNode<TreeNode<Integer>> head = input.getElement().getHeadOfChild(input);
		SLLNode<TreeNode<Integer>> tail = input.getElement().getTailOfChild(input);
		SLLNode<TreeNode<Integer>> child = head;

		while (child.getNext() != null) {

			if (child.getElement().getChildren() != null) {
				tail.setNext(getElementsOfRanksHelper(child));
				while (tail.getNext() != null) {
					tail = tail.getNext();
				}

			} 

			child = child.getNext();

		}

		return head;

	}

/**
 * Old Implementation
 */
	
//	public SLLNode<TreeNode<Integer>> getElementsOfRanks(TreeNode<Integer> root, int lower, int upper) {
//
//		TreeNode<Integer> current = root;
//		SLLNode<TreeNode<Integer>> elementsOfRanks = new SLLNode<TreeNode<Integer>>(current, null); //head
//
//		elementsOfRanks.setNext(getElementsOfRanksHelper(elementsOfRanks));
//
//		//Insertion Sort
//		SLLNode<TreeNode<Integer>> sortedList = null;
//		SLLNode<TreeNode<Integer>> pointer = elementsOfRanks.getNext();
//		SLLNode<TreeNode<Integer>> prev = elementsOfRanks;
//
//		while (pointer != null) {
//
//			int pointerInt = (int) pointer.getElement().getElement();
//			int prevInt = (int) prev.getElement().getElement();
//			int prevNextInt = (int) prev.getNext().getElement().getElement();
//
//			if (prevInt > pointerInt) {
//				prev = elementsOfRanks;
//			}
//
//			while (prev.getNext() != null && prevNextInt < pointerInt) {
//				prev = prev.getNext();
//			}
//
//			SLLNode<TreeNode<Integer>> pointerNext = pointer.getNext();
//			SLLNode<TreeNode<Integer>> prevNext = prev.getNext();
//			pointerNext = prev.getNext();
//			prevNext = pointer;
//
//			pointer = pointer.getNext();
//		}
//
//		int min = 0;
//
//
//
//		return elementsOfRanks;
//
//	}

	//	private SLLNode<TreeNode<Integer>> getElementsOfRanksHelper(SLLNode<TreeNode<Integer>> input) {
	//
	//		SLLNode<TreeNode<Integer>> head = input.getElement().getHeadOfChild(input);
	//		SLLNode<TreeNode<Integer>> tail = input.getElement().getTailOfChild(input);
	//		SLLNode<TreeNode<Integer>> child = head;
	//		
	//		while (child.getNext() != null) {
	//			
	//			if (child.getElement().getChildren() != null) {
	//				tail.setNext(getElementsOfRanksHelper(child));
	//				while (tail.getNext() != null) {
	//					tail = tail.getNext();
	//				}
	//				
	//			} 
	//			
	//			child = child.getNext();
	//			
	//		}
	//	
	//		return head;
	//		
	//	}

	/**
	 * SLLNode Methods
	 */

	private SLLNode<TreeNode<Integer>> getPrevNode(SLLNode<TreeNode<Integer>> head, SLLNode<TreeNode<Integer>> input) {

		SLLNode<TreeNode<Integer>> current = head;

		while (current.getNext() != input) {
			current = current.getNext();
		}

		return current;
	}

	private void addAt(SLLNode<TreeNode<Integer>> input, SLLNode<TreeNode<Integer>> inputPrev) {


		return ;
	}	

}
