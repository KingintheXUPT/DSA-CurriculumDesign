package MainPackage;

import java.io.IOException;
import java.util.Scanner;

public class ChangeG {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	
	public static void addRoute() throws ClassNotFoundException, IOException{			//为两个城市之间添加直接到达的路线
		AdjMatrix G = IOFile.objectInput();			//从文件中读取地图信息赋予G
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入新路线的城市起点");
		String newStart = in.next();
		System.out.println("请输入新路线的城市终点");
		String newEnd = in.next();
		if(Search.searchNum(newStart, G)==0||Search.searchNum(newEnd, G)==0){
			System.out.println("输入的城市名错误，请重新输入");
		}else{
			int startNum = Search.searchNum(newStart, G);
			int endNum = Search.searchNum(newEnd, G);
			System.out.println("请输入两城市之间的距离");
			int	distance = in.nextInt();
			G.arcs[startNum-1][endNum-1] = distance;
			G.arcs[endNum-1][startNum-1] = distance;
		}
		lessDistance.Floyd();		//更新最少路径表
		
		IOFile.objectOutput(G);			//将新的路线图直接写入文件之中
	}
	
	
	public static void delRoute() throws ClassNotFoundException, IOException{	//删除新的路线
		AdjMatrix G = IOFile.objectInput();			//从文件中读取地图信息赋予G
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入删除路线的城市起点");
		String newStart = in.next();
		System.out.println("请输入删除路线的城市终点");
		String newEnd = in.next();
		if(Search.searchNum(newStart, G)==0||Search.searchNum(newEnd, G)==0){
			System.out.println("输入的城市名错误，请重新输入");
		}else{
			int startNum = Search.searchNum(newStart, G);
			int endNum = Search.searchNum(newEnd, G);
			G.arcs[startNum-1][endNum-1] = INFINITY;
			G.arcs[endNum-1][startNum-1] = INFINITY;
		}
		lessDistance.Floyd();		//更新最少路径表
		IOFile.objectOutput(G);			//将新的路线图直接写入文件之中
	}
	
	public static void addCity() throws ClassNotFoundException, IOException{			//添加新的城市
		AdjMatrix G = IOFile.objectInput();			//从文件中读取地图信息赋予G
		
		Scanner in = new Scanner(System.in);
		String oldCity;
		int newDistance;
		int a=1;
		if(G.vexnum>=20){
			System.out.println("改地图内存已经满了，无法继续添加城市");
		}else{
			G.vexnum++;
			System.out.println("请输入你所需要添加的城市名");
			G.vex[G.vexnum-1].name = in.next();
			G.vex[G.vexnum-1].Num = G.vexnum;
			G.arcs[G.vexnum-1][G.vexnum-1]=0;
			for(int j =0; j<G.vexnum-1;j++){
				G.arcs[G.vexnum-1][j]=INFINITY;
			}
			for(int i =0; i <G.vexnum-1 ; i++){
				G.arcs[i][G.vexnum-1]=INFINITY;
			}
			while(a!=0){				//做出选择是否继续输入城市
				System.out.println("请输入与该城市的所连接的城市名称");
				oldCity = in.next();
				if(Search.searchNum(oldCity, G)==0){
					System.out.println("输入的城市名称有误，请重新输入");
				}else{
					System.out.println("请输入新城市与"+oldCity+"的距离");
					newDistance = in.nextInt();
					G.arcs[G.vexnum-1][Search.searchNum(oldCity, G)-1] = newDistance;
					G.arcs[Search.searchNum(oldCity, G)-1][G.vexnum-1] = newDistance;
					System.out.println("请选择是否继续输入与该城市链接的新城市--是:输入1，否:输入0");
					a = in.nextInt();
				}
			}
			lessDistance.Floyd();		//更新最少路径表
			IOFile.objectOutput(G);			//将新的G冲进写入文件
		}
	}
	
	public static void delCity() throws ClassNotFoundException, IOException{
		AdjMatrix G = IOFile.objectInput();			//从文件中读取地图信息赋予G
		
		Scanner in = new Scanner(System.in);
		if( G.vexnum<=0 ){
			System.out.println("该地图已经没有城市");
		}else{
			String delCity;
			System.out.println("请输入需要删除城市的名字");
			delCity = in.next();   
			int a =	Search.searchNum(delCity, G);
			if(a==0){
				System.out.println("您所输入的城市名字不存在");
			}else{
				for(int i =a-1;i<G.vexnum-1;i++){				
					G.vex[i] = G.vex[i+1];
				}
				for(int j = 0;j<G.vexnum-1;j++){
					G.arcs[a-1][j] = G.arcs[a][j+1];			
				}
				for(int i = 0;i<G.vexnum-1;i++){
					G.arcs[i][a-1] = G.arcs[i+1][a];
				}
				G.vexnum--;
				for(int i = 0;i<G.vexnum;i++){
					G.vex[i].Num=i+1;
				}
			}
		}
		lessDistance.Floyd();		//更新最少路径表
		
		IOFile.objectOutput(G);			//将新的G冲进写入文件
	}
}
