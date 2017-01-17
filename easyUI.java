package MainPackage;

import java.io.IOException;
import java.util.*;

public class easyUI {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	public static void MainMenu() throws ClassNotFoundException, IOException{

		
		Scanner in = new Scanner(System.in);
		int choice=0;
		System.out.println("���������ѡ�� 1.��ͼ��ѯ  2.��ͼ�޸�   0.�˳�");
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
		System.out.println("���������ѡ�� 1.Ϊ·������µ�·��  2.ɾ���µ�·��   3.����³���  4.ɾ������  5.������һ���˵�  0.�������˵� "); 
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
			System.out.println("�����ʽ����ȷ����������");
			ChangeMenu(IOFile.objectInput());
		}
		changeUIloop();
	}
	
	
	
	public static void SearchMenu(AdjMatrix G) throws ClassNotFoundException, IOException{
		Scanner in = new Scanner(System.in);
		int choice=0;
		
		System.out.println("--------------------------------�ֽ���-----------------------------------");
		
		System.out.println("���������ѡ�� 1.���ݳ������Ʋ�ѯ���б��  2.���ݳ��б�Ų�ѯ��������  3.��ѯ������֮���ֱ�Ӿ���  4.��ѯ������֮�����̾���   5.������һ���˵�  0.�������˵�");
		choice = in.nextInt();
		
		if(choice == 1){
			String name = in.next();
			System.out.println(Search.searchNum(name, G));
		}else if(choice ==2 ){
			int Num = in.nextInt();
			System.out.println(Search.searchNmae(Num, G));
		}else if(choice ==3 ){
			int distance =	Search.getDistanceBeturnBetweenTowCitysDirectly(G,"����");
			if(distance >= INFINITY){
				System.out.println("��������֮��û��ֱ����ͨ");
			}else{
				System.out.println("������֮���ֱ�Ӿ���Ϊ"+distance);
				System.out.println("�����ѵ���ʱ��Ϊ:");
			}
		}else if(choice ==4 ){
			System.out.println("�����һ��������");
			String FirstCity =  in.next();
			System.out.println("������ڶ���������");
			String SecondCity = in.next();
			int f = Search.searchNum(FirstCity,G);
			int s = Search.searchNum(SecondCity,G);
			int distance = Search.getlessDistance(G,FirstCity,SecondCity);
			System.out.println("������֮�����̾���Ϊ"+distance);
			System.out.println("���зֱ𾭹���"+G.Path[f-1][s-1]);
		}
		else if(choice == 5){
			SearchMenu(G);
			
		}else if(choice ==6 ){
			MainMenu();
		}else if(choice ==0 ){
			MainMenu();	
		}else{
			System.out.println("���벻��ȷ�����������");
			SearchMenu(G);
		}
		searchUIloop();
	}
	
	public static void searchUIloop() throws ClassNotFoundException, IOException{
		Scanner in= new Scanner(System.in);
		
		int choice = 0;
		System.out.println("������������ѡ�� 1.������һ���˵�  2.�������˵�  3.��������  0.ֹͣ����");
		
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
			System.out.println("�����ʽ����ȷ����������");
			searchUIloop();
		}
	}
	
	
	
	public static void changeUIloop() throws ClassNotFoundException, IOException{
		Scanner in= new Scanner(System.in);
		
		int choice = 0;
		System.out.println("������������ѡ�� 1.������һ���˵�  2.�������˵�  3.��������  0.ֹͣ����");
		
		choice =in.nextInt();
		System.out.println("--------------------------------�ֽ���-----------------------------------");
		
		if(choice == 1){
			MainMenu();
		}else if(choice == 2){
			MainMenu();
		}else if(choice == 3){
			ChangeMenu(IOFile.objectInput());
		}else if(choice == 0){
			System.exit(0);
		}else{
			System.out.println("�����ʽ����ȷ����������");
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
