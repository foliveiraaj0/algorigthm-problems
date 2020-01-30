package problems.amazon;

public class CloneABinaryTree {
	
	class Tree{
		int data;
		Tree left,right,random;
		Tree(int d){
			data=d;
			left=null;
			right=null;
			random=null;
		}
	}
	
	class GfG{
	    public Tree cloneTree(Tree tree){
	    	Tree copy = new Tree(tree.data);
	    	copy.left = tree.left != null ? cloneTree(tree.left) : null;
	    	copy.right = tree.right != null ? cloneTree(tree.right) : null;
	    	copy.random = tree.random == null ? null : tree.left != null ? tree.left : tree.right;
	    	return copy;
	    }
	}

}
