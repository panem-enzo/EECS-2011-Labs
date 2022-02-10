package model;
import tests.Node;

public class ListUtilities {
	
	public Node<String> getAllPrefixes(Node<Integer> input, int low, int upper) {
		
		Node<Integer> current = input;
		Node<String> prefixHead = new Node<>("["+current+"]", null);
		Node<String> prefix = prefixHead;
		
		int i = 1;
		int size = getSize(input);
		
		while (input.getNext() != null) {
			
			for (int j=0; j < i; j++) {
				prefix.setNext(new Node<>());
			}
			
			i++;
			
		}
		
		return prefix;
	}
	
	private int getSize(Node<Integer> input) {
		
		Node<Integer> current = input;
		int size = 0;
		
		while (current.getNext() != null) {
			current = current.getNext();
			size ++;
		}
		
		return size;
	}
	
}
