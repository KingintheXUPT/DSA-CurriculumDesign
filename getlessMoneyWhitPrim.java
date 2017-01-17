package MainPackage;

import java.util.*;

public class getlessMoneyWhitPrim {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 	
	public static int[] visited = new int[MAXVEX];			//��־����
	
	
	public static void Prim(AdjMatrix G,int start){				//��prim�㷨������С���������Դ��������������
		Closedge[] closedge = new Closedge[G.vexnum];
		int min,m=0;
		for( int i =0; i<G.vexnum; i++)		closedge[i] = new Closedge();		//Ϊ������ÿһ��Ԫ�ؿ��ٿռ�
		closedge[start].lowcost = 0;	//��־����u�Ѿ����뵽��u-�������ļ���֮��
		
		//�Գ��˳�������������ж����ʼ����Ӧ�Ķ�closedge����
		for(int i=0; i<G.vexnum; i++){
			if( i!=start){
				closedge[i].adjvex = start;
				closedge[i].lowcost = G.arcs[start][i].car;
			}
		}
		
		for(int i = 0;i<G.vexnum; i++){			//����ѡ�е�n-1�����������ı�
			//ѡ����СȨֵ�ı�
			min=INFINITY;
			for( int j = 0 ;j<G.vexnum;j++){
				if(closedge[j].lowcost!=0&&closedge[j].lowcost<min){
					m=j;
					min=closedge[j].lowcost;
				}
			}
			closedge[m].lowcost=0;			//��־����v0���뵽U-����������
			
			//��v0����֮�����u-�������ļ���
			for(int k= 0;k<G.vexnum;k++){
				if(k!=m&&G.arcs[m][k]<closedge[k].lowcost){ 		//һ�������и�С��Ȩֵ�߳��֣����滻ԭ����Ϣ
					closedge[i].lowcost = G.arcs[m][i];
					closedge[i].adjvex = m;
				}
			}
		}
		for(Closedge u :closedge){
			System.out.println(u.adjvex);
		}
	}
}


class Closedge{
	int adjvex;
	int lowcost;
}
