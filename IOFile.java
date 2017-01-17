package MainPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IOFile {
	public static final int MAXVEX = 20; 		//最大定点个数
	public static final int INFINITY = 32768;   	//表示极大值∞ 
	public static void objectOutput(AdjMatrix G) throws IOException, ClassNotFoundException{	//写入文件
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/MainPackage/File/file.dat"));
				
		output.writeObject(G);
		
		output.close();
	}
	
	public static AdjMatrix objectInput() throws IOException, ClassNotFoundException{	//返回文件中的对象
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/MainPackage/File/file.dat"));
		
		AdjMatrix G = (AdjMatrix)input.readObject();
		
		input.close();
		
		return G;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		AdjMatrix G = new AdjMatrix();
		CreateAdj.CreateG(G);
		objectOutput(G);
		System.out.println(Search.searchNmae(1,objectInput()));
	}
}

class Vextype implements Serializable{		//定点的信息
	 int Num;			//定点编号
	 String name;			//定点名字
}
