package MainPackage;

import java.io.IOException;

public class ergodicG {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	private static final String G = null;
	
	public static void ergodicG() throws ClassNotFoundException, IOException{
		AdjMatrix G =	IOFile.objectInput();
		
		
			for(int i = 0; i<G.vexnum;i++){
				for(int j = i;j<G.vexnum;j++){
					if(G.arcs[i][j]!=INFINITY&&i!=j){
						System.out.println(Search.searchNmae(i+1, G)+"��"+Search.searchNmae(j+1, G)+"�Ĺ�·ֱ�Ӿ���Ϊ"+G.arcs[i][j]);
					}
				}
			}
			
		}
	
	public static void ergodicF() throws ClassNotFoundException, IOException{
		AdjMatrix G =	IOFile.objectInput();
		
		
		
			for(int i = 0; i<G.vexnum;i++){
				for(int j = i;j<G.vexnum;j++){
					if(G.F[i][j]!=INFINITY&&i!=j){
						System.out.println(Search.searchNmae(i+1, G)+"��"+Search.searchNmae(j+1, G)+"����̾���Ϊ"+G.F[i][j]);
					}
				}
			}
		
		
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		AdjMatrix G =IOFile.objectInput();
		ergodicG();
		System.out.println("----------------------------�ֽ���------------------------------");
		System.out.println(G.arcs[0][5]);
		ergodicF();
//		System.out.println("��������֮���ֱ�Ӿ���Ϊ"+Search.getDistanceBeturnBetweenTowCitysDirectly(IOFile.objectInput()),"��");

	}
}
