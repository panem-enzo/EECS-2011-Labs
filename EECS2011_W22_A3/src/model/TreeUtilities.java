package model;

import tests.TreeNode;
import tests.SLLNode;
import tests.Expression;
import tests.Operator;

public class TreeUtilities {
	
	public TreeNode<Expression> getInfixTree(SLLNode<Expression> e) {
		
		TreeNode<Expression> infix = new TreeNode<>(null);
		SLLNode<Expression> current = e;
		SLLNode<Expression> stack = null;
		
		while (current != null) {
			if (current.getElement() instanceof Operator) {
				infix.setElement(current.getElement());
				
				infix.addChild(new TreeNode<>(pop(stack)));
				infix.addChild(new TreeNode<>(pop(stack)));
			} else {
				stack = push(stack, current.getElement());
			}
		}
		
		return infix;
	}
	
	private SLLNode<Expression> push(SLLNode<Expression> stack, Expression element) {
		
		SLLNode<Expression> stackHead = stack;
		
		if (stack == null) {
			stackHead = new SLLNode<>(element, null);
			stack = stackHead;
		} else {
			stack.setNext(new SLLNode<>(element, null));
			stack = stack.getNext();
		}
		
		return stackHead;
	}
 	
	private Expression pop (SLLNode<Expression> stack) {
		
		Expression element = null;
		return element;
		
	}
	
//	private int size(SLLNode<Expression> stack) {
//	
//	SLLNode<Expression> current = stack;
//	int size = 0;
//	
//	while (current != null) {
//		size ++;
//		current = current.getNext();
//	}
//	
//	return size;
//}
	
}
