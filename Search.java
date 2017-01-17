package MainPackage;

import java.util.Scanner;

public class Search {			
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	
	
	public static String searchNmae(int Num,AdjMatrix G){		//通过城市编号来寻找城市名字
		if(Num>G.vexnum||Num<1)	return "输入名字错误，请重新输入";
		for(int i =0; i<G.vexnum;i++){
			if(G.vex[i].Num==Num){
				return G.vex[i].name;
			}
		}
		return " ";
	}
	
	public static int searchNum(String name,AdjMatrix G){		//通过城市名字来寻找城市编号
		for(int i = 0;i<G.vexnum;i++){
			if(G.vex[i].name.equals(name))	return G.vex[i].Num;
		}
		return 0;
	}
	
	public static int getDistanceBeturnBetweenTowCitysDirectly(AdjMatrix G,String Vehicle){  		//直接返回两个城市之间的距离，如果两个城市之间没有直接关联或输入错误则返回0
		Scanner in = new Scanner(System.in);
		System.out.println("输入第一个城市名");
		String FirstCity =  in.next();
		System.out.println("请输入第二个城市名");
		String SecondCity = in.next();
		int f = searchNum(FirstCity,G);
		int s = searchNum(SecondCity,G);
		
		
		if(Vehicle.equals("汽车")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}else if(Vehicle.equals("飞机")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}else if(Vehicle.equals("火车")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}
		return 0;
	}
	
	public static int getlessDistance(AdjMatrix G,String FirstCity,String SecondCity){  		//返回两个城市之间最短路径距离，如果两个城市之间没有直接关联或输入错误则返回0

		int f = searchNum(FirstCity,G);
		int s = searchNum(SecondCity,G);
		
		
		
			if(f!=0&&s!=0){
				return G.F[f-1][s-1];
			}else{
				return 0;
			}
		
	}
	public static void main(String[] args){
		
	}
}
