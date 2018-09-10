package grafo;

import java.util.LinkedList;
import java.util.List;

public class Stack {

	private List<Node> nodes = new LinkedList<Node>();

	public void insert(Node node) {
		this.nodes.add(node);
	}

	public Node remove() {
	 return this.nodes.remove(this.nodes.size() - 1);
	}

	public boolean isEmpty() {
		return this.nodes.size() == 0;
	}
}
