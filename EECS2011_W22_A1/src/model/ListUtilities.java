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

	private int getSize(Node<Integer> input) {

		Node<Integer> current = input;
		int size = 0;

		while (current != null) {
			current = current.getNext();
			size ++;
		}

		return size;
	}

}
