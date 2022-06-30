package _09_Graph;

public class MatrixGraph {
	private int numberOfVertices;
	private int[][] matrix;
	
	public MatrixGraph(int n) {
		numberOfVertices = n;
		matrix=new int[n][n];
	}
	
	//정점 v1, v2를 매개변수로 받아 간선 (v1, v2)를 삽입 + 무방향 그래프이므로 대칭행렬로 구현
	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=numberOfVertices || v2<0 || v2>=numberOfVertices) {
			System.out.println("그래프에 없는 정점입니다.");
		}
		else {
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
	}
	
	//오름차순으로 출력
	public void printAdjacentVertices() {
		for(int i=0; i<numberOfVertices; i++) {
			System.out.print(i+"에 인접한 정점 = ");
			for(int j=0; j<numberOfVertices; j++) {
				if(matrix[i][j]==1)
					System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
