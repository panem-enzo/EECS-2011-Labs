package model;
import tests.Node;

public class ListUtilities {

	public Node<String> getAllPrefixes(Node<Integer> input, int low, int upper) {

		Node<Integer> headInt = input;
		Node<Integer> currentInt = headInt;
		Node<String> prefix = null;
		Node<String> currentPrefix = null;

		int i = 0, length = 0;
		int size = getSize(input);
		boolean foundHead = false;

		while (i < size) {
			
			String str = "[";
			currentInt = headInt;
			
			for (int j=0; j < i; j++) {
				str += currentInt.getElement() + ", ";
				currentInt = currentInt.getNext();
			}
			
			str += currentInt.getElement() + "]";
			length ++;
			
			if (length >= low && length <= upper) {
				
				if (!foundHead) {
					prefix = new Node<>(str, null);
					currentPrefix = prefix;
					foundHead = true;
				} else {
					currentPrefix.setNext(new Node<>(str, null));
					currentPrefix = currentPrefix.getNext();
				}
				
			}
			i++;

		}

		return prefix;

	}

	public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {
		
		if (leftChain == null && rightChain == null) {
			return null;
		} 
		
		// Merge both chains
		
		Node<Integer> head = leftChain;
		Node<Integer> mergedChain = head;
		
		if (leftChain == null) {
			mergedChain = rightChain;
			head = rightChain;
		} else if (rightChain == null) {
			mergedChain = leftChain;
		} else {
			
			// Find tail of leftChain
			while (mergedChain.getNext() != null) {
				mergedChain = mergedChain.getNext();
				
			}
			mergedChain.setNext(rightChain);
			mergedChain = head;
		}
		
		// Apply insertion sort algorithm
		
		// Find the absolute minimum
		Node<Integer> sortedHead = null;
		Node<Integer> sorted = null;
		
		boolean foundAbsMin = false;
		int size = getSize(mergedChain);
		
		for (int i = 0; i < size; i ++) {
			
			Node<Integer> currentMin = mergedChain;
			int minIndex = 0;
			int counter = 0;
			
			while (mergedChain.getNext() != null) {
				
				if (mergedChain.getNext().getElement() <= mergedChain.getElement()) {
					if (mergedChain.getNext().getElement() <= currentMin.getElement()) {
						currentMin = mergedChain.getNext();
						minIndex = counter + 1;
					}
							
				}  else {
					if (mergedChain.getNext().getElement() <= currentMin.getElement()) {
						currentMin = mergedChain;
						minIndex = counter;
					}
				}
				mergedChain = mergedChain.getNext();
				counter ++;
			}
			
			// Insert currentMin into new list
			if (!foundAbsMin) {
				sortedHead = new Node<>(currentMin.getElement(), null);
				sorted = sortedHead;
				foundAbsMin = true;
				
			} else {
				sorted.setNext(new Node<>(currentMin.getElement(), null));
				sorted = sorted.getNext();
			}
			
			
			//Remove min from list to shorten unsorted list
			if (currentMin == head) {
				head = head.getNext();
				mergedChain.setNext(null);
			} else {
		
				Node<Integer> beforeMin = getNodeAt(head, minIndex-1);
				beforeMin.setNext(currentMin.getNext());
				currentMin.setNext(null);
				
			}
			mergedChain = head;
			
		}
		
		return sortedHead;
	}
	
	private int getSize(Node<Integer> input) {

		Node<Integer> current = input;
		int size = 0;

		while (current != null) {
			current = current.getNext();
			size ++;
		}

		return size;
	}
	
	private Node<Integer> getNodeAt(Node<Integer> head, int size) {
		
		int index = 0;
		Node<Integer> current = head;
		
		while (index < size) {
			index ++;
			current = current.getNext();
		}
		
		return current;
		
	}

}
