package model;

import tests.*;

public class TreeUtilities {

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> root, int lower, int upper) {

		SLLNode<Integer> elementsOfRanks = null;
		SLLNode<Integer> elementsOfRanksHead = null;
		SLLNode<TreeNode<Integer>> rootHead = new SLLNode<TreeNode<Integer>>(root, null);
		SLLNode<Integer> intNode = null;

		for (int i = 1; i <= upper; i++) {

			SLLNode<TreeNode<Integer>> element;

			if (i == 1) {
				element = new SLLNode<TreeNode<Integer>>(getElementsOfRanksHelper(rootHead, null, 0), null);
				intNode = new SLLNode<Integer>(element.getElement().getElement(), null);
			} else {
				element = new SLLNode<TreeNode<Integer>>(getElementsOfRanksHelper(rootHead, root, (int)intNode.getElement()), null);
				intNode.setNext(new SLLNode<Integer>(element.getElement().getElement(), null));
				intNode = intNode.getNext();
			}

			if (i >= lower) {

				if (elementsOfRanks == null) {
					elementsOfRanks = intNode;
					elementsOfRanksHead = elementsOfRanks;
				} else {
					elementsOfRanks.setNext(intNode);
					elementsOfRanks = elementsOfRanks.getNext();
				}

			} 
		}

		return elementsOfRanksHead;

	}

	private TreeNode<Integer> getElementsOfRanksHelper(SLLNode<TreeNode<Integer>> head, TreeNode<Integer> currentMin, int previousMin) {

		SLLNode<TreeNode<Integer>> current = head;
		TreeNode<Integer> finalMin = currentMin;

		while (current != null) {

			Integer currentNum = current.getElement().getElement();
			SLLNode<TreeNode<Integer>> child = current.getElement().getChildren();

			if ((int) currentNum > (int) previousMin) {

				if (finalMin == null || (int) currentNum < (int) finalMin.getElement()) {
					if (child != null) { 
						finalMin = getElementsOfRanksHelper(child, current.getElement(), previousMin);
					}  else {
						finalMin = current.getElement();
					}
				}

			} else {

				if (child != null) { 
					finalMin = getElementsOfRanksHelper(child, finalMin, previousMin);
				} 

			}

			current = current.getNext();
		}

		return finalMin;

	}

	/**
	 * getStats()
	 */

	public TreeNode<String> getStats(TreeNode<Integer> root) {
		return getStatsHelper(root, null);
	}

	private TreeNode<String> getStatsHelper(TreeNode<Integer> root, TreeNode<String> parent) {

		SLLNode<TreeNode<Integer>> child = root.getChildren();
		int numDescendants = getStatsNumDescendants(root, 1);
		int sumDescendants = getStatsSumDescendants(root, root.getElement());
		TreeNode<String> result = new TreeNode<String>(String.format("Number of descendants: %d; Sum of descendants: %d", numDescendants, sumDescendants));
		result.setParent(parent);

		while (child != null) {
			result.addChild(getStatsHelper(child.getElement(), result));
			child = child.getNext();
		}

		return result;
	}

	private int getStatsNumDescendants(TreeNode<Integer> root, int numDescendants) {

		SLLNode<TreeNode<Integer>> child = root.getChildren();
		int count = numDescendants;

		if (root.getChildren() == null) {
			return 1;
		} else {
			// iterate through children
			while (child != null) {
				if (root.getParent() == null) {
					count = 1;
				}
				numDescendants += getStatsNumDescendants(child.getElement(), count);
				child = child.getNext();
				
			}
		}

		return numDescendants;
	}

	private int getStatsSumDescendants(TreeNode<Integer> root, int sumDescendants) {

		SLLNode<TreeNode<Integer>> child = root.getChildren();

		if (root.getChildren() == null) {
			return root.getElement();
		} else {
			// iterate through children
			while (child != null) {
				sumDescendants += getStatsSumDescendants(child.getElement(), child.getElement().getElement());
				child = child.getNext();
			}
		}

		return sumDescendants;
	}

}
