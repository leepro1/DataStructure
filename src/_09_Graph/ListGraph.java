package _09_Graph;

public class ListGraph {
	private int numberOfVertices;
	private Node[] lists;
	
	private class Node{
		int vertex;
		Node link;
	}
	
	public ListGraph(int n) {
		numberOfVertices = n;
		lists= new Node[n];
	}
	
	private boolean check=false; 
	
	//그래프에 간선 (v1, v2) 삽입 + 무방향 그래프이므로 addEdge(v2,v1)사용
	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=numberOfVertices || v2<0 || v2>=numberOfVertices) {
			System.out.println("그래프에 없는 정점입니다!");
		}			
		else {
			Node newNode = new Node();
			newNode.vertex = v2;
			
			if(lists[v1]==null) {
				lists[v1]=newNode;
				
				if(check==false) { 
					check=true;
					addEdge(v2,v1);
					check=false;
				}
			}
			
			else {
				if(v2<lists[v1].vertex) {
					newNode.link=lists[v1];
					lists[v1]=newNode;
				}
				else {
					Node temp = lists[v1];
					while(true) {
						if(temp.link==null) { //입력받은 간선이 입접 리스트의 오름차순으로 마지막 노드에 들어가야 할 때
							temp.link=newNode;
							break;
						}
						else if(temp.link.vertex>v2) { //입력받은 간선의 자리를 오름차순으로 찾는다
							newNode.link=temp.link;
							temp.link=newNode;
							break;
						}
						temp = temp.link;
					}
				}
				if(check==false) { //(v1,v2)와 (v2,v1)을 모두 표시
					check=true;
					addEdge(v2,v1);
					check=false;
				}
			}
		}
	}
	
	public void printAdjacentVertices() {
		for(int i=0; i<numberOfVertices; i++) {
			System.out.print(i+ "에 인접한 정점 = ");
			for(Node temp = lists[i]; temp != null; temp = temp.link) {
				System.out.print(temp.vertex+" ");
			}
			System.out.println();
		}
	}
}
