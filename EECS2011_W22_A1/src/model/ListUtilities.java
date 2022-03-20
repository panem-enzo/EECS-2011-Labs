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

	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int arithStart, int arithDiff, int arithSize, int fibSize) {

		// We need to create our lists first! (arithmetic sequence and fibnoacci sequence)
		// Fibonacci Sequence

		Node<Integer> fibHead = new Node<>(1, null);
		Node<Integer> fib = fibHead;
		Node<Integer> nodeBefore = null;

		int i = 0;
		boolean finArith = false, finFib = false;

		if (fibSize == 0) {
			finFib = true;
		} else {
			
			while (i < fibSize-1) {

				if (i == 0) {
					nodeBefore = new Node<>(0, fib);
					fib.setNext(new Node<>(nodeBefore.getElement() + fib.getElement(), null));
					fib = fib.getNext();
				} else {

					nodeBefore = getNodeAt(fibHead, i-1);
					fib.setNext(new Node<>(nodeBefore.getElement() + fib.getElement(), null));
					fib = fib.getNext();

				}

				i ++;

			}

			fib = fibHead;
			
		}

		// Arithmetic Sequence

		Node<Integer> arithHead = new Node<>(arithStart, null);
		Node<Integer> arith = arithHead;

		int j = 0;
		
		if (arithSize == 0) {
			finArith = true;
		} else {
			while (j < arithSize-1) {

				arith.setNext(new Node<>(arith.getElement() + arithDiff, null));
				arith = arith.getNext();

				j ++;
			}

			arith = arithHead;
		}

		//Now we can interleave!

		Node<Integer> interleaveHead = null;
		Node<Integer> interleave = null;
		int interleaveSize = arithSize + fibSize;
		int k = 0;

		while (k < interleaveSize) {

			// Reset both lists
			
			if (k == 0) {
				
				if (!finArith) {
					interleaveHead = new Node<>(arith.getElement(), null);
					interleave = interleaveHead;
				} else {
					interleaveHead = new Node<>(fib.getElement(), null);
					interleave = interleaveHead;
					fib = fib.getNext();
				}
			
				
			} else if ((k % 2 == 0 && !finArith) || (finFib && !finArith)) {
				
				arith = arith.getNext();
				interleave.setNext(new Node<>(arith.getElement(), null));
				interleave = interleave.getNext();
				
				if (arith.getNext() == null) {
					finArith = true;
				}

			} else {
				
				if (fib.getNext() == null) {
					finFib = true;
				}
				
				interleave.setNext(new Node<>(fib.getElement(), null));
				fib = fib.getNext();
				interleave = interleave.getNext();

			}

			k ++;
		}

		return interleaveHead;
	}
	
	public Node<String> getGroupedStrings(Node<String> input, int m, int n) {
		
		if (input == null) {
			return null;
		}
		
		Node<String> output = null;
		
		//Creating Group 1, 2, 3
		
		Node<String> groupOneHead = null;
		Node<String> groupOne = null;
		boolean oneInit = false;
		
		Node<String> groupTwoHead = null;
		Node<String> groupTwo = null;
		boolean twoInit = false;
		
		Node<String> groupThreeHead = null;
		Node<String> groupThree = null;
		boolean threeInit = false;
		
		while (input != null) {
			if (input.getElement().length() < m) {
				if (!oneInit) {
					groupOneHead = new Node<>(input.getElement(),null);
					groupOne = groupOneHead;
					oneInit = true;
				} else {
					groupOne.setNext(new Node<>(input.getElement(), null));
					groupOne = groupOne.getNext();
				}
				input = input.getNext();
			} else if (input.getElement().length() >= m && input.getElement().length() < n) {
				if (!twoInit) {
					groupTwoHead = new Node<>(input.getElement(),null);
					groupTwo = groupTwoHead;
					twoInit = true;
				} else {
					groupTwo.setNext(new Node<>(input.getElement(), null));
					groupTwo = groupTwo.getNext();
				}
				input = input.getNext();
			} else if (input.getElement().length() >= n) {
				if (!threeInit) {
					groupThreeHead = new Node<>(input.getElement(),null);
					groupThree = groupThreeHead;
					threeInit = true;
				} else {
					groupThree.setNext(new Node<>(input.getElement(), null));
					groupThree = groupThree.getNext();
				}
				input = input.getNext();
			}
		}
		
		output = groupOneHead;
		groupOne.setNext(groupTwoHead);
		groupTwo.setNext(groupThreeHead);
		
		return output;
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
