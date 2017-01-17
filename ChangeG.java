package MainPackage;

import java.io.IOException;
import java.util.Scanner;

public class ChangeG {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	
	public static void addRoute() throws ClassNotFoundException, IOException{			//Ϊ��������֮�����ֱ�ӵ����·��
		AdjMatrix G = IOFile.objectInput();			//���ļ��ж�ȡ��ͼ��Ϣ����G
		
		Scanner in = new Scanner(System.in);
		System.out.println("��������·�ߵĳ������");
		String newStart = in.next();
		System.out.println("��������·�ߵĳ����յ�");
		String newEnd = in.next();
		if(Search.searchNum(newStart, G)==0||Search.searchNum(newEnd, G)==0){
			System.out.println("����ĳ�������������������");
		}else{
			int startNum = Search.searchNum(newStart, G);
			int endNum = Search.searchNum(newEnd, G);
			System.out.println("������������֮��ľ���");
			int	distance = in.nextInt();
			G.arcs[startNum-1][endNum-1] = distance;
			G.arcs[endNum-1][startNum-1] = distance;
		}
		lessDistance.Floyd();		//��������·����
		
		IOFile.objectOutput(G);			//���µ�·��ͼֱ��д���ļ�֮��
	}
	
	
	public static void delRoute() throws ClassNotFoundException, IOException{	//ɾ���µ�·��
		AdjMatrix G = IOFile.objectInput();			//���ļ��ж�ȡ��ͼ��Ϣ����G
		
		Scanner in = new Scanner(System.in);
		System.out.println("������ɾ��·�ߵĳ������");
		String newStart = in.next();
		System.out.println("������ɾ��·�ߵĳ����յ�");
		String newEnd = in.next();
		if(Search.searchNum(newStart, G)==0||Search.searchNum(newEnd, G)==0){
			System.out.println("����ĳ�������������������");
		}else{
			int startNum = Search.searchNum(newStart, G);
			int endNum = Search.searchNum(newEnd, G);
			G.arcs[startNum-1][endNum-1] = INFINITY;
			G.arcs[endNum-1][startNum-1] = INFINITY;
		}
		lessDistance.Floyd();		//��������·����
		IOFile.objectOutput(G);			//���µ�·��ͼֱ��д���ļ�֮��
	}
	
	public static void addCity() throws ClassNotFoundException, IOException{			//����µĳ���
		AdjMatrix G = IOFile.objectInput();			//���ļ��ж�ȡ��ͼ��Ϣ����G
		
		Scanner in = new Scanner(System.in);
		String oldCity;
		int newDistance;
		int a=1;
		if(G.vexnum>=20){
			System.out.println("�ĵ�ͼ�ڴ��Ѿ����ˣ��޷�������ӳ���");
		}else{
			G.vexnum++;
			System.out.println("������������Ҫ��ӵĳ�����");
			G.vex[G.vexnum-1].name = in.next();
			G.vex[G.vexnum-1].Num = G.vexnum;
			G.arcs[G.vexnum-1][G.vexnum-1]=0;
			for(int j =0; j<G.vexnum-1;j++){
				G.arcs[G.vexnum-1][j]=INFINITY;
			}
			for(int i =0; i <G.vexnum-1 ; i++){
				G.arcs[i][G.vexnum-1]=INFINITY;
			}
			while(a!=0){				//����ѡ���Ƿ�����������
				System.out.println("��������ó��е������ӵĳ�������");
				oldCity = in.next();
				if(Search.searchNum(oldCity, G)==0){
					System.out.println("����ĳ���������������������");
				}else{
					System.out.println("�������³�����"+oldCity+"�ľ���");
					newDistance = in.nextInt();
					G.arcs[G.vexnum-1][Search.searchNum(oldCity, G)-1] = newDistance;
					G.arcs[Search.searchNum(oldCity, G)-1][G.vexnum-1] = newDistance;
					System.out.println("��ѡ���Ƿ����������ó������ӵ��³���--��:����1����:����0");
					a = in.nextInt();
				}
			}
			lessDistance.Floyd();		//��������·����
			IOFile.objectOutput(G);			//���µ�G���д���ļ�
		}
	}
	
	public static void delCity() throws ClassNotFoundException, IOException{
		AdjMatrix G = IOFile.objectInput();			//���ļ��ж�ȡ��ͼ��Ϣ����G
		
		Scanner in = new Scanner(System.in);
		if( G.vexnum<=0 ){
			System.out.println("�õ�ͼ�Ѿ�û�г���");
		}else{
			String delCity;
			System.out.println("��������Ҫɾ�����е�����");
			delCity = in.next();   
			int a =	Search.searchNum(delCity, G);
			if(a==0){
				System.out.println("��������ĳ������ֲ�����");
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
		lessDistance.Floyd();		//��������·����
		
		IOFile.objectOutput(G);			//���µ�G���д���ļ�
	}
}
