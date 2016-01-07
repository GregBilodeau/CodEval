import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class MarsNetworks {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
				
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String coordPairs[] = line.split("\\s");
			
				ArrayList<Node> nodes = new ArrayList<Node>();
				for(String pair : coordPairs){
					Node node = new Node(pair);
					nodes.add(node);
				}
				
				ArrayList<Edge> edges = new ArrayList<Edge>();
				for(Node node1 : nodes){
					for(Node node2 : nodes){
						if(node1 != node2){
							Edge newEdge = new Edge(node1, node2);
							// do we already have this edge?
							if(edges.isEmpty()){
								edges.add(newEdge);
							}
							for(Edge oldEdge : edges){
								if(!compareNodes(newEdge.getNodes(), oldEdge.getNodes())){
									edges.add(newEdge);
								}
							}
							
						}
					}
				}
				
				Collections.sort(edges, new Comparator<Edge>() {
				    public int compare(Edge e1, Edge e2) {
				        return e1.getDistance() - e2.getDistance();
				    }});
				
				
				
				System.out.println(nodes.size() + " nodes, " + edges.size() + " edges.");
			}
			
		}
		
		fileScanner.close();

	}
	
	public static boolean compareNodes(Node[] edge1, Node[] edge2){
		if((edge1[0] == edge2[0] && edge1[1] == edge2[1]) || (edge1[0] == edge2[1] && edge1[1] == edge2[0]) ){
			return true;
		}else{
			return false;
		}
	}

}

class Node{
	
	private int xCoord;
	private int yCoord;
	
	public Node(String xAndy){
		String coords[] = xAndy.split(",");
		xCoord = Integer.parseInt(coords[0]);
		yCoord = Integer.parseInt(coords[1]);
	}
	
	public int getXCoord(){
		return xCoord;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
}

class Edge{
	
	Node nodeA;
	Node nodeB;
	int distance = Integer.MAX_VALUE;
	
	public Edge(Node node1, Node node2){
		nodeA = node1;
		nodeB = node2;
		distance = setDistance();
	}
	
	private int setDistance(){
		int x1, x2, y1, y2;
		x1 = nodeA.getXCoord();
		y1 = nodeA.getYCoord();
		x2 = nodeB.getXCoord();
		y2 = nodeB.getYCoord();
		
		int base = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		int myDistance = (int)Math.sqrt(Math.pow(base, 2.0) + Math.pow(height, 2.0));
		return myDistance;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public Node[] getNodes(){
		Node[] myNodes = {nodeA, nodeB};
		return myNodes;
	}
}