package MainPackage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞
	public static d[] visited = new d[MAXVEX];			//标志数组
	
	public static void Vis(){
		for( int i = 0; i<MAXVEX;i++){
			visited[i] = new d();
			visited[i].flag=0;
		}
	}
	
	public static int BFScar(Queue<Integer> Q,AdjMatrix G,int vi,int v1){
		int v,i;
		Vis();
		visited[vi].flag=1;
		Q.offer(vi);
		while(Q.peek()!=null){
			v=Q.poll();
			i=0;
			while(i<G.vexnum){
				if(visited[i].flag==0&&G.arcs[v][i].car!=0&&G.arcs[v][i].car!=INFINITY){
					visited[i].flag=1;
					visited[i].last=v;
					
					if(i==v1){
						System.out.print(G.vex[v1].name);
						int j =visited[v1].last;
						G.distance+=G.arcs[i][visited[v1].last].car;
//						G.time+=3;
						while(j>0){		
							G.time+=3;
							System.out.print("<-"+G.vex[j].name);
							G.distance+= G.arcs[j][visited[j].last].car;
							j = visited[j].last;
						}
						G.time+=G.distance/G.speed;
						System.out.println("<-"+G.vex[vi].name);
						
						return 0;
					}
					Q.offer(i);
				}
				i++;
			}
		}
		return 0;
	}
	
	public static int BFSplane(Queue<Integer> Q,AdjMatrix G,int vi,int v1){
		int v,i;
		Vis();
		visited[vi].flag=1;
		Q.offer(vi);
		while(Q.peek()!=null){
			v=Q.poll();
			i=0;
			while(i<G.vexnum){
				if(visited[i].flag==0&&G.arcs[v][i].plane!=0&&G.arcs[v][i].plane!=INFINITY){
					visited[i].flag=1;
					visited[i].last=v;
					
					if(i==v1){
						System.out.print(G.vex[v1].name);
						int j =visited[v1].last;
						G.distance+=G.arcs[i][visited[v1].last].plane;
//						G.time+=3;
						while(j>0){		
							G.time+=3;
							System.out.print("<-"+G.vex[j].name);
							G.distance+= G.arcs[j][visited[j].last].plane;
							j = visited[j].last;
						}
						G.time+=G.distance/G.speed;
						System.out.println("<-"+G.vex[vi].name);
						
						return 0;
					}
					Q.offer(i);
				}
				i++;
			}
		}
		return 0;
	}
	
	
	public static int BFStrain(Queue<Integer> Q,AdjMatrix G,int vi,int v1){
		int v,i;
		Vis();
		visited[vi].flag=1;
		Q.offer(vi);
		while(Q.peek()!=null){
			v=Q.poll();
			i=0;
			while(i<G.vexnum){
				if(visited[i].flag==0&&G.arcs[v][i].train!=0&&G.arcs[v][i].train!=INFINITY){
					visited[i].flag=1;
					visited[i].last=v;
					
					if(i==v1){
						System.out.print(G.vex[v1].name);
						int j =visited[v1].last;
						G.distance+=G.arcs[i][visited[v1].last].train;
//						G.time+=3;
						while(j>0){		
							G.time+=3;
							System.out.print("<-"+G.vex[j].name);
							G.distance+= G.arcs[j][visited[j].last].train;
							j = visited[j].last;
						}
						G.time+=G.distance/G.speed;
						System.out.println("<-"+G.vex[vi].name);
						
						return 0;
					}
					Q.offer(i);
				}
				i++;
			}
		}
		return 0;
	}
	

	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Queue<Integer> queue = new LinkedList<Integer>();

//		CreateAdj.CreateG(new AdjMatrix());
		AdjMatrix G=IOFile.objectInput();
		ergodicG.ergodicG("火车");
		System.out.println("-------------------------------------------------");
		int time =0;
		BFScar(queue,G,0,3);
		System.out.println("总路程为"+G.distance);
		System.out.println("总时间为"+G.time);

	}

}

class d{
	int last=0;
	int flag;
}
