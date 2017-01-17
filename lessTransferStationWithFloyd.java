package MainPackage;

public class lessTransferStationWithFloyd {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	public static void Floyd(AdjMatrix G,int F[][]){
		int[][] Path = new int[MAXVEX][MAXVEX];
		int path;
		for(int i=0 ;i<G.vexnum;i++){
			for(int j=0;j<G.vexnum;j++){
				F[i][j]=G.arcs[i][j];
				Path[i][j] = INFINITY;
			}
		}
		
		for(int i =0;i<G.vexnum;i++){
			for(int j=0;j<G.vexnum;j++){
				for(int k=0;k<G.vexnum;k++){
					if(F[i][j]>F[i][k]+F[k][j]){		//���γ��Լ���������㲢�ͼ���֮ǰ��Ȩֵ���бȽ�
						F[i][j]=F[i][k]+F[k][j];
						path=k;
					}
				}
			}
		}
	}
}
