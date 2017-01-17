package MainPackage;


public class DFS{
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 	
	public static int[] visited = new int[MAXVEX];			//��־����
	
	public void Vis(){
		for( int i = 0; i<MAXVEX;i++){
			visited[i]=0;
		}
	}
	
	public static int FirstAdjVex( CreateG G,int v0){			//���ض���v0�ĵ�һ���ٽ��
		for(int i = 0 ;i<G.vexnum;i++){
			if(G.arcs[v0][i]!=INFINITY){
				return i;
			}
		}
		return -1;
	}
	
	public static int NextAdjVex(CreateG G,int v0,int w){  		//���ض���v0����һ���ڽӵ�
		for(int i = w+1;i<G.vexnum;i++){
			if(G.arcs[v0][i]!=INFINITY){
				return i;
			}
		}
		
		return -1;
	}
	
 	public static void DFS(CreateG G,int v0){		//������ȱ���
 		System.out.println(G.vex[v0].name);
 		visited[v0] = 1;
 		int w=FirstAdjVex(G, v0);
 		while(w!=-1){
 			if(visited[w]!=1) DFS(G,w);
 			w=NextAdjVex(G, v0, w);
 		}
	}
}

