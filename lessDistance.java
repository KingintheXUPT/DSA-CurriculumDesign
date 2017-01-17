package MainPackage;

import java.io.IOException;
import java.lang.Object;

public class lessDistance {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	public static void Floyd(AdjMatrix G) throws ClassNotFoundException, IOException{
		for(int i=0 ;i<G.vexnum;i++){
			for(int j=0;j<G.vexnum;j++){			
				G.F[i][j]=G.arcs[i][j];
				G.F[i][j]=INFINITY;
				if(G.arcs[i][j]!=INFINITY){
					G.Path[i][j]= G.vex[i].name +"乘汽车"+"->"+G.vex[j].name;				
				}
			}
		}
		
		
		

//		
//
//
//		
//
//		
		for(int i =0;i<G.vexnum;i++){
			for(int j=0;j<G.vexnum;j++){
				for(int k=0;k<G.vexnum;k++){
					if(G.F[i][j]>G.F[i][k]+G.F[k][j]){		//依次尝试加入各个顶点并和加入汽车的权值进行比较
						G.F[i][j]=G.F[i][k]+G.F[k][j];
						G.Path[i][j]=G.vex[i].name+"乘汽车"+"->"+G.Path[k][j];
					}
				}
			}
		}
		
		IOFile.objectOutput(G);
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException{
//		CreateAdj.CreateG(new AdjMatrix());
		Floyd(IOFile.objectInput());
		ergodicG.ergodicG();
//		System.out.println("------------------------------------------");
//		ergodicG.ergodicG("火车");
		System.out.println("------------------------------------------");
//		ergodicG.ergodicG("飞机");
//		System.out.println("------------------------------------------");
		ergodicG.ergodicF();
		System.out.println(IOFile.objectInput().Path[0][2]);
		AdjMatrix G = IOFile.objectInput();
		System.out.println(G.F[0][2]);
	}
}
