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
		
//		ergodicG.ergodicG();	//ȫ�����
//		System.out.println("ͼ��������ȱ���");
//		DFS.DFS(G, 0);
//		System.out.println(G.getCityNumWhisName(in.nextLine()));		//���ݳ��е����ָ������еı��
//		G.getAllCityDistanceDirectly();			//��ʾ�����г���֮���ֱ�Ӿ���
//		System.out.println(G.getDistanceBeturnBetweenTowCitysDirectly());		//������������֮���ֱ�Ӿ���
//		System.out.println(G.getCityNameWhisNum(in.nextInt()));
		System.out.println("--------------------���Ƿֽ���----------------------------------");
		
		
//		ChangeG.addRoute(G);			//����µ�ֱ��·��
		
//		ChangeG.delRoute(G);					//ɾ���µ�·��
		
		ChangeG.addCity();				//����µĳ���
		
//		ChangeG.delCity();				//ɾ������

//		getlessMoneyWhitPrim.Prim(G, 0);
		
		System.out.println("--------------------���Ƿֽ���----------------------------------");
//		G.getAllCityDistanceDirectly();
//		ergodicG.ergodicG();	//ȫ�����		
//		System.out.println("--------------------���Ƿֽ���----------------------------------");
//		System.out.println(G.getDistanceBeturnBetweenTowCitysDirectly());
//		
	}
}

class Vextype implements Serializable{		//�������Ϣ
	int Num;			//������
	String name;			//��������
}



class AdjMatrix implements Serializable{
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	public int[][] arcs = new int[MAXVEX][MAXVEX]; 		//�ߵ���Ϣ	
	public Vextype[] vex = new Vextype[MAXVEX];			//������Ϣ	
	public int vexnum;		//������Ŀ
	public int arcum;		//�ߵ���Ŀ

	public int[][] F =	new int[MAXVEX][MAXVEX]; 		//��ǰ���·��
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


