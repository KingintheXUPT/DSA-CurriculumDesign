package MainPackage;

import java.io.IOException;

public class CreateAdj {				//创造地图
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	
	
//	public static void CreateTime(travelTime time) throws ClassNotFoundException, IOException{
//		IOFileTime.timeOutput(time);
//	}
	
	public static void CreateG(AdjMatrix G) throws ClassNotFoundException, IOException{
		
		for(int i = 0 ;i<MAXVEX;i++){		//需要给每一个实例开辟空间
			Vextype a = new Vextype();
			G.vex[i]=a;
		}

		G.vexnum = 6;
				

		
		for(int i = 0; i<G.vexnum; i++){
			for(int j = 0; j <G.vexnum; j++){
				G.arcs[i][j] = INFINITY;

			}
		}

		
		
		


		//以下默认为6个顶点的顶点信息
		G.vex[0].name = "LijiangTower";
		G.vex[0].Num = 1;
		G.vex[1].name = "Hanamura";
		G.vex[1].Num = 2;
		G.vex[2].name = "Route66";
		G.vex[2].Num = 3;
		G.vex[3].name = "Hollywood";
		G.vex[3].Num = 4;
		G.vex[4].name = "King'sRow";
		G.vex[4].Num = 5;
		G.vex[5].name = "Nepal";
		G.vex[5].Num = 6;
		

		
		//默认的边的信息,赋予权值
		for(int i = 0;i<G.vexnum;i++){
			for(int j = i ;j<G.vexnum ;j++){
					if(i!=j){
						int b = (int)(0+Math.random()*3);
						if(b != 0){
							int a =(int)(1+Math.random()*15);
							G.arcs[i][j] = a;
							G.arcs[j][i] = a;
						}
					}else{
						G.arcs[i][j] = 0;
						G.arcs[j][i] = 0;
					}
			}
		}
		
		for(int i = 0;i<G.vexnum;i++){
			for(int j = i ;j<G.vexnum ;j++){
					if(i!=j){
						int b = (int)(0+Math.random()*3);
						if(b != 0){
							int a =(int)(1+Math.random()*15);
							G.arcs[i][j] = a;
							G.arcs[j][i] = a;
						}
					}else{
						G.arcs[i][j] = 0;
						G.arcs[j][i] = 0;
					}
			}
		}
		

		
		for(int i = 0;i<G.vexnum;i++){
			for(int j = i ;j<G.vexnum ;j++){
					if(G.arcs[i][j]!=INFINITY&&G.arcs[i][j]!=0){
						G.arcum++;
					}
			}
		}
		
		lessDistance.Floyd(G);		//先赋予地图的F当前最小路径
		
		IOFile.objectOutput(G);
		

	}
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		CreateG(new AdjMatrix());
	}
}
