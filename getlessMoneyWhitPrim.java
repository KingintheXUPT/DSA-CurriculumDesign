package MainPackage;

import java.util.*;

public class getlessMoneyWhitPrim {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 	
	public static int[] visited = new int[MAXVEX];			//标志数组
	
	
	public static void Prim(AdjMatrix G,int start){				//用prim算法计算最小生成树，以此来计算费用最少
		Closedge[] closedge = new Closedge[G.vexnum];
		int min,m=0;
		for( int i =0; i<G.vexnum; i++)		closedge[i] = new Closedge();		//为数组中每一个元素开辟空间
		closedge[start].lowcost = 0;	//标志顶点u已经加入到了u-生成树的集合之中
		
		//对除了出发点以外的所有顶点初始化对应的额closedge数组
		for(int i=0; i<G.vexnum; i++){
			if( i!=start){
				closedge[i].adjvex = start;
				closedge[i].lowcost = G.arcs[start][i].car;
			}
		}
		
		for(int i = 0;i<G.vexnum; i++){			//控制选中的n-1条符合条件的边
			//选择最小权值的边
			min=INFINITY;
			for( int j = 0 ;j<G.vexnum;j++){
				if(closedge[j].lowcost!=0&&closedge[j].lowcost<min){
					m=j;
					min=closedge[j].lowcost;
				}
			}
			closedge[m].lowcost=0;			//标志顶点v0加入到U-生成数集合
			
			//当v0加入之后更新u-生成数的集合
			for(int k= 0;k<G.vexnum;k++){
				if(k!=m&&G.arcs[m][k]<closedge[k].lowcost){ 		//一旦发现有更小的权值边出现，则替换原有信息
					closedge[i].lowcost = G.arcs[m][i];
					closedge[i].adjvex = m;
				}
			}
		}
		for(Closedge u :closedge){
			System.out.println(u.adjvex);
		}
	}
}


class Closedge{
	int adjvex;
	int lowcost;
}
