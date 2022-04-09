package model;

import tests.Expression;
import tests.SLLNode;
import tests.TreeNode;
import tests.Operator;

public class TreeUtilities {

	public TreeNode<Expression> getInfixTree(SLLNode<Expression> expression) {
		
		SLLNode<Expression> current = expression;
		SLLNode<TreeNode<Expression>> postFixStack = null; // Initially empty
		SLLNode<TreeNode<Expression>> orderStack = null; // Initially empty
		TreeNode<Expression> root = null;
		
		while (current != null) {
			
			root = new TreeNode<>(current.getElement()); // TreeNode alternative of current expression
			
			if (current.getElement() instanceof Operator) {
				// push to orderStack
				
				orderStack = push(orderStack, postFixStack);
				postFixStack = pop(postFixStack);
				orderStack = push(orderStack, postFixStack);
				postFixStack = pop(postFixStack);
				
				TreeNode<Expression> firstChild = top(orderStack);
				orderStack = pop(orderStack);
				TreeNode<Expression> secondChild = top(orderStack);
				orderStack = pop(orderStack);
			
				root.addChild(firstChild);
				firstChild.setParent(root);
				root.addChild(secondChild);
				secondChild.setParent(root);
				
				SLLNode<TreeNode<Expression>> family = new SLLNode<>(root, postFixStack);
				postFixStack = family;
				
			} else {
				SLLNode<TreeNode<Expression>> newNode = new SLLNode<>(root, null);
				postFixStack = push(postFixStack, newNode);
			}
			
			current = current.getNext();
		}
		
		return root;
	}
	
	private SLLNode<TreeNode<Expression>> push (SLLNode<TreeNode<Expression>> stack, SLLNode<TreeNode<Expression>> current) {
		
		TreeNode<Expression> top = current.getElement();
		
		if (stack == null) {
			stack = new SLLNode<>(top, null);
		} else {
			SLLNode<TreeNode<Expression>> newNode = new SLLNode<>(top, null);
			newNode.setNext(stack);
			stack = newNode;
		}

		return stack;
	}
	
	private SLLNode<TreeNode<Expression>> pop (SLLNode<TreeNode<Expression>> stack) {
		
		SLLNode<TreeNode<Expression>> result;
		result = stack.getNext();
		stack = null;
		
		return result;
	}
	
	private TreeNode<Expression> top (SLLNode<TreeNode<Expression>> stack) {
		return stack.getElement();
	}
	
}
