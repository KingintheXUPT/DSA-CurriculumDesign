package MainPackage;


public class DFS{
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 	
	public static int[] visited = new int[MAXVEX];			//标志数组
	
	public void Vis(){
		for( int i = 0; i<MAXVEX;i++){
			visited[i]=0;
		}
	}
	
	public static int FirstAdjVex( CreateG G,int v0){			//返回顶点v0的第一个临界点
		for(int i = 0 ;i<G.vexnum;i++){
			if(G.arcs[v0][i]!=INFINITY){
				return i;
			}
		}
		return -1;
	}
	
	public static int NextAdjVex(CreateG G,int v0,int w){  		//返回顶点v0的下一个邻接点
		for(int i = w+1;i<G.vexnum;i++){
			if(G.arcs[v0][i]!=INFINITY){
				return i;
			}
		}
		
		return -1;
	}
	
 	public static void DFS(CreateG G,int v0){		//深度优先遍历
 		System.out.println(G.vex[v0].name);
 		visited[v0] = 1;
 		int w=FirstAdjVex(G, v0);
 		while(w!=-1){
 			if(visited[w]!=1) DFS(G,w);
 			w=NextAdjVex(G, v0, w);
 		}
	}
}

