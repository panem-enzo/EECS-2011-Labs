package model;

import tests.TreeNode;
import tests.SLLNode;
import tests.Expression;
import tests.Operator;

public class TreeUtilities {
	
	public TreeNode<Expression> getInfixTree(SLLNode<Expression> e) {
		
		TreeNode<Expression> infix = new TreeNode<>(e.getElement());
		
		SLLNode<Expression> current = e;
		SLLNode<Expression> stack = null;
		
		while (current != null) {
			
			if (current.getElement() instanceof Operator) {
				infix = new TreeNode<Expression>(current.getElement());
				getInfixTreeHelper(infix, stack);
				stack = null;
			} else {
				stack = pushStack(current, stack);
			}
			
			current = current.getNext();
		}
		
		return infix;
	}
	
	private void getInfixTreeHelper(TreeNode<Expression> infix, SLLNode<Expression> stack) {
		
		SLLNode<Expression> current = stack;
		
		while (current != null) {
			
			TreeNode<Expression> child = new TreeNode<Expression>(current.getElement());
			child.setParent(infix);
			infix.addChild(child);
			
			current = current.getNext();
		}

	}
	
	private Expression topStack(SLLNode<Expression> top) {
		return top.getElement();
	}
	
	private SLLNode<Expression> pushStack(SLLNode<Expression> input, SLLNode<Expression> stack) {
		
		if (stack == null) {
			stack = new SLLNode<Expression>(input.getElement(), null);
		} else {
			
			SLLNode<Expression> top = new SLLNode<Expression>(topStack(input), null);
			stack.setNext(top);
		}
		
		return stack;
		
	}
	
	private Expression popStack(SLLNode<Expression> stack) {
		Expression result;
		result = topStack(stack);
		// remove topStack
		return result;
	}
	
}
