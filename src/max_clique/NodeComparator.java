package max_clique;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{
	public int compare(Node o1, Node o2) {
		if(o1.getK() < o2.getK()) {
			return 1;
		} else if (o1.getK() > o2.getK()) {
			return -1;
		} else {
			return 0;
		}
	} 
}