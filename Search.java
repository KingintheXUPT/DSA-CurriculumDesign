package MainPackage;

import java.util.Scanner;

public class Search {			
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	
	
	public static String searchNmae(int Num,AdjMatrix G){		//ͨ�����б����Ѱ�ҳ�������
		if(Num>G.vexnum||Num<1)	return "�������ִ�������������";
		for(int i =0; i<G.vexnum;i++){
			if(G.vex[i].Num==Num){
				return G.vex[i].name;
			}
		}
		return " ";
	}
	
	public static int searchNum(String name,AdjMatrix G){		//ͨ������������Ѱ�ҳ��б��
		for(int i = 0;i<G.vexnum;i++){
			if(G.vex[i].name.equals(name))	return G.vex[i].Num;
		}
		return 0;
	}
	
	public static int getDistanceBeturnBetweenTowCitysDirectly(AdjMatrix G,String Vehicle){  		//ֱ�ӷ�����������֮��ľ��룬�����������֮��û��ֱ�ӹ�������������򷵻�0
		Scanner in = new Scanner(System.in);
		System.out.println("�����һ��������");
		String FirstCity =  in.next();
		System.out.println("������ڶ���������");
		String SecondCity = in.next();
		int f = searchNum(FirstCity,G);
		int s = searchNum(SecondCity,G);
		
		
		if(Vehicle.equals("����")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}else if(Vehicle.equals("�ɻ�")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}else if(Vehicle.equals("��")){
			if(f!=0&&s!=0){
				return G.arcs[f-1][s-1];
			}else{
				return 0;
			}
		}
		return 0;
	}
	
	public static int getlessDistance(AdjMatrix G,String FirstCity,String SecondCity){  		//������������֮�����·�����룬�����������֮��û��ֱ�ӹ�������������򷵻�0

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
