package utils.data_structures;

public class Tree {
	NodeTree root;
	int readPointer = 0;
	public Tree() {}

	public void add(int value) {
		if (value > 0) {
			if (root == null) {
				root = new NodeTree(value);
			} else {
				addNode(value, this.root);
			}
		}
	}

	public void addNode(int value, NodeTree current) {
		if (value > current.value) {
			current.size++;
			if (current.right == null) {
				current.right = new NodeTree(value);
			} else {
				addNode(value, current.right);
			}
		} else if (value < current.value) {
			current.size++;
			if (current.left == null) {
				current.left = new NodeTree(value);
			} else {
				addNode(value, current.left);
			}
		}
	}
	
	public int[] readData(){
		int[] data = new int[root.size];
		readData(data, root);
		readPointer = 0;
		return data;
	}

	public void readData(int[] data, NodeTree root) {
		if(root.left != null) {
			readData(data, root.left);
		}
		data[readPointer] = root.value;
		readPointer++;
		if(root.right != null) {
			readData(data, root.right);
		}
	}

	class NodeTree {
		NodeTree right;
		NodeTree left;
		int value;
		int size;

		public NodeTree(int value) {
			this.value = value;
			this.size = 1;
		}
	}


}

