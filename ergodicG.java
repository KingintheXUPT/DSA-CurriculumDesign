package MainPackage;

import java.io.IOException;

public class ergodicG {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	private static final String G = null;
	
	public static void ergodicG() throws ClassNotFoundException, IOException{
		AdjMatrix G =	IOFile.objectInput();
		
		
			for(int i = 0; i<G.vexnum;i++){
				for(int j = i;j<G.vexnum;j++){
					if(G.arcs[i][j]!=INFINITY&&i!=j){
						System.out.println(Search.searchNmae(i+1, G)+"到"+Search.searchNmae(j+1, G)+"的公路直接距离为"+G.arcs[i][j]);
					}
				}
			}
			
		}
	
	public static void ergodicF() throws ClassNotFoundException, IOException{
		AdjMatrix G =	IOFile.objectInput();
		
		
		
			for(int i = 0; i<G.vexnum;i++){
				for(int j = i;j<G.vexnum;j++){
					if(G.F[i][j]!=INFINITY&&i!=j){
						System.out.println(Search.searchNmae(i+1, G)+"到"+Search.searchNmae(j+1, G)+"的最短距离为"+G.F[i][j]);
					}
				}
			}
		
		
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		AdjMatrix G =IOFile.objectInput();
		ergodicG();
		System.out.println("----------------------------分界线------------------------------");
		System.out.println(G.arcs[0][5]);
		ergodicF();
//		System.out.println("两个城市之间的直接距离为"+Search.getDistanceBeturnBetweenTowCitysDirectly(IOFile.objectInput()),"火车");

	}
}
