package MainPackage;

import java.io.IOException;
import java.util.*;

public class easyUI {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	public static void MainMenu() throws ClassNotFoundException, IOException{

		
		Scanner in = new Scanner(System.in);
		int choice=0;
		System.out.println("请输入你的选择： 1.地图查询  2.地图修改   0.退出");
		choice = in.nextInt();
		if(choice == 1){
			SearchMenu(IOFile.objectInput());
		}else if(choice ==2){
			ChangeMenu(IOFile.objectInput());
		}
	}
	
	public static void ChangeMenu(AdjMatrix G) throws ClassNotFoundException, IOException{
		Scanner in = new Scanner(System.in);
		int choice=0;
		System.out.println("请输入你的选择： 1.为路线添加新的路线  2.删除新的路线   3.添加新城市  4.删除城市  5.返回上一个菜单  0.返回主菜单 "); 
		choice = in.nextInt();
		if(choice == 1 ){
			ChangeG.addRoute();
		}else if(choice == 2 ){
			ChangeG.delRoute();
		}else if(choice == 3 ){
			ChangeG.addCity();
		}else if(choice == 4 ){
			ChangeG.delCity();
		}else if(choice == 5 ){
			MainMenu();
		}else{
			System.out.println("输入格式不正确请重新输入");
			ChangeMenu(IOFile.objectInput());
		}
		changeUIloop();
	}
	
	
	
	public static void SearchMenu(AdjMatrix G) throws ClassNotFoundException, IOException{
		Scanner in = new Scanner(System.in);
		int choice=0;
		
		System.out.println("--------------------------------分界线-----------------------------------");
		
		System.out.println("请输入你的选择 1.根据城市名称查询城市编号  2.根据城市编号查询城市名称  3.查询两城市之间的直接距离  4.查询两城市之间的最短距离   5.返回上一个菜单  0.返回主菜单");
		choice = in.nextInt();
		
		if(choice == 1){
			String name = in.next();
			System.out.println(Search.searchNum(name, G));
		}else if(choice ==2 ){
			int Num = in.nextInt();
			System.out.println(Search.searchNmae(Num, G));
		}else if(choice ==3 ){
			int distance =	Search.getDistanceBeturnBetweenTowCitysDirectly(G,"汽车");
			if(distance >= INFINITY){
				System.out.println("两个城市之间没有直接联通");
			}else{
				System.out.println("两城市之间的直接距离为"+distance);
				System.out.println("所花费的总时间为:");
			}
		}else if(choice ==4 ){
			System.out.println("输入第一个城市名");
			String FirstCity =  in.next();
			System.out.println("请输入第二个城市名");
			String SecondCity = in.next();
			int f = Search.searchNum(FirstCity,G);
			int s = Search.searchNum(SecondCity,G);
			int distance = Search.getlessDistance(G,FirstCity,SecondCity);
			System.out.println("两城市之间的最短距离为"+distance);
			System.out.println("城市分别经过："+G.Path[f-1][s-1]);
		}
		else if(choice == 5){
			SearchMenu(G);
			
		}else if(choice ==6 ){
			MainMenu();
		}else if(choice ==0 ){
			MainMenu();	
		}else{
			System.out.println("输入不正确，请继续输入");
			SearchMenu(G);
		}
		searchUIloop();
	}
	
	public static void searchUIloop() throws ClassNotFoundException, IOException{
		Scanner in= new Scanner(System.in);
		
		int choice = 0;
		System.out.println("请继续输入你的选择： 1.返回上一个菜单  2.返回主菜单  3.继续输入  0.停止运行");
		
		choice =in.nextInt();
		
		if(choice == 1){
			MainMenu();
		}else if(choice == 2){
			MainMenu();
		}else if(choice == 3){
			SearchMenu(IOFile.objectInput());
		}else if(choice == 0){
			System.exit(0);
		}else{
			System.out.println("输入格式不正确请重新输入");
			searchUIloop();
		}
	}
	
	
	
	public static void changeUIloop() throws ClassNotFoundException, IOException{
		Scanner in= new Scanner(System.in);
		
		int choice = 0;
		System.out.println("请继续输入你的选择： 1.返回上一个菜单  2.返回主菜单  3.继续输入  0.停止运行");
		
		choice =in.nextInt();
		System.out.println("--------------------------------分界线-----------------------------------");
		
		if(choice == 1){
			MainMenu();
		}else if(choice == 2){
			MainMenu();
		}else if(choice == 3){
			ChangeMenu(IOFile.objectInput());
		}else if(choice == 0){
			System.exit(0);
		}else{
			System.out.println("输入格式不正确请重新输入");
			changeUIloop();
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException{
//		CreateAdj.CreateG(new AdjMatrix());
		SearchMenu(IOFile.objectInput());
//		ergodicG.ergodicF();
		ergodicG.ergodicG();
		System.out.println("--------------------------------------------");
		ergodicG.ergodicF();
		
		MainMenu();
	}
}
