package MainPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		AdjMatrix G = new AdjMatrix();
//		CreateAdj.CreateG(G);
//		IOFile.objectOutput(G);
		
//		ergodicG.ergodicG();	//全部输出
//		System.out.println("图的深度优先遍历");
//		DFS.DFS(G, 0);
//		System.out.println(G.getCityNumWhisName(in.nextLine()));		//依据城市的名字给出城市的编号
//		G.getAllCityDistanceDirectly();			//显示出所有城市之间的直接距离
//		System.out.println(G.getDistanceBeturnBetweenTowCitysDirectly());		//给出两个城市之间的直接距离
//		System.out.println(G.getCityNameWhisNum(in.nextInt()));
		System.out.println("--------------------我是分界线----------------------------------");
		
		
//		ChangeG.addRoute(G);			//添加新的直接路线
		
//		ChangeG.delRoute(G);					//删除新的路线
		
		ChangeG.addCity();				//添加新的城市
		
//		ChangeG.delCity();				//删除城市

//		getlessMoneyWhitPrim.Prim(G, 0);
		
		System.out.println("--------------------我是分界线----------------------------------");
//		G.getAllCityDistanceDirectly();
//		ergodicG.ergodicG();	//全部输出		
//		System.out.println("--------------------我是分界线----------------------------------");
//		System.out.println(G.getDistanceBeturnBetweenTowCitysDirectly());
//		
	}
}

class Vextype implements Serializable{		//顶点的信息
	int Num;			//顶点编号
	String name;			//顶点名字
}



class AdjMatrix implements Serializable{
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	public int[][] arcs = new int[MAXVEX][MAXVEX]; 		//边的信息	
	public Vextype[] vex = new Vextype[MAXVEX];			//定点信息	
	public int vexnum;		//定点数目
	public int arcum;		//边的数目

	public int[][] F =	new int[MAXVEX][MAXVEX]; 		//当前最短路径
	public String[][] Path = new String[MAXVEX][MAXVEX];
}


class Arcunm implements Serializable{
	int plane = 0;
	int	train = 0;
	int	car = 0;
}


class addss implements Serializable{
	int a =3;
	double b =5.5;
	String c = "name";
}


