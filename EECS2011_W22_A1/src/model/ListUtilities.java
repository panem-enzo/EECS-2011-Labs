package model;
import tests.Node;

public class ListUtilities {

	public Node<String> getAllPrefixes(Node<Integer> input, int low, int upper) {

		Node<String> allPrefixesHead = getAllPrefixesHelper(input);
		
		return allPrefixesHead;

	}

	private Node<String> getAllPrefixesHelper(Node<Integer> input) {

		Node<Integer> currentHead = input;
		Node<Integer> current = currentHead;
		Node<String> prefixHead = new Node<>("["+current.getElement()+"]", null);
		Node<String> prefix = prefixHead;

		int i = 1;
		int size = getSize(input);

		if (size != 1) {

			while (i < size) {

				String str = "[";
				current = currentHead;
				for (int j=0; j < i; j++) {
					str += current.getElement() + ", ";
					current = current.getNext();
				}
				str += current.getElement() + "]";

				prefix.setNext(new Node<>(str, null));
				prefix = prefix.getNext();
				i++;

			}

		}

		prefix = prefixHead;

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
