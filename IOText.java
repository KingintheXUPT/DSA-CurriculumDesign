package MainPackage;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class IOText {
	Scanner in= new Scanner(System.in);
	public static String getInputMessage() throws IOException{
        System.out.println("���������������");
        byte buffer[]=new byte[1024];
        int count=System.in.read(buffer);
        char[] ch=new char[count-2];//�����λΪ��������ɾȥ��Ҫ
        for(int i=0;i<count-2;i++)
            ch[i]=(char)buffer[i];
        String str=new String(ch);
        return str;
    }
	
	public static void getFileWithBufferedReader() throws IOException{		//��BufferedReader�����ļ���ȡ
		BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
		String data = br.readLine();	//�Դ˶���һ�У�ֱ������nullΪ�ļ�����
		while(data!=null){
			System.out.println(data);
			data =br.readLine();	//������һ��
		}
		br.close();
	}
	
	public static void getFileWithInputStream() throws IOException{
		InputStream is = new FileInputStream(new File("employee.txt"));  
        InputStreamReader fr = new InputStreamReader(is);  
        int ch = 0;    
        while((ch = fr.read())!=-1 ){    
            System.out.print((char)ch);    
        }
        is.close();
	}
	
	public static void getWriter() throws IOException{	//д���ļ�
		Scanner in= new Scanner(System.in);
		FileWriter fw = new FileWriter("employee.txt");    
        String s = in.next();    
        fw.write(s);    
        fw.flush();    
          
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("employee.txt"));    
        osw.write(s);    
        osw.flush();    
          
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("employee.txt")),true);    
        pw.println(s);    
          
        fw.close();    
        osw.close();    
        pw.close();  
	}
	
	public static void getWriterG(AdjMatrix G) throws IOException{	//ֱ���ö���д���ͼ����

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.dat"));    
		
		
		output.writeObject(G);
		
        output.close();
	}
	
	public static void getInputG() throws IOException, ClassNotFoundException{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.dat"));
		

		AdjMatrix G=(AdjMatrix)input.readObject();

		
		input.close();
		System.out.println(G.vexnum);
	}
	
	public static void getBuffer() throws IOException{
        File file = new File("employee.txt");  
        File dest = new File("employee.txt");    
        	BufferedReader reader = new BufferedReader(new FileReader(file));  
        	BufferedWriter writer  = new BufferedWriter(new FileWriter(dest));  
        	String line = reader.readLine();  
        	while(line!=null){  
        		writer.write(line);  
        		line = reader.readLine();  
        	}  
        	writer.flush();  
        	reader.close();  
        	writer.close();  

	}
	
	public static void getWriter(addss arr) throws IOException{	//ֱ���ö���д���ͼ����

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.dat"));    
		
		
		output.writeObject(arr);
		
        output.close();
	}
	
	public static void getInput() throws IOException, ClassNotFoundException{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.dat"));
		

		addss ar=(addss)input.readObject();

		
		input.close();
		System.out.println(ar.a+ar.b+ar.c);
	}
	
		
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Student arr = new Student();
		addss ar = new addss();
		CreateG G = new CreateG();
		AdjMatrix	A = new AdjMatrix();
		
		
		
		getWriterG(A);
		getInputG();
		
//		getWriter(ar);
//		getInput();
	}
}



class Student implements Serializable {
	public static final int MAXVEX = 20; 		//��󶨵����
	public static final int INFINITY = 32768;   	//��ʾ����ֵ�� 
	 
	  private static final long serialVersionUID = -6601903208557464574L;
	 
	  int id=0;
	  String name="caonima";
	 
	  public Student() {
	    super();
	  }
	 
	  public Student(int id, String name) {
	    super();
	    this.id = id;
	    this.name = name;
	  }
	 
	  public int getId() {
	    return id;
	  }
	 
	  public void setId(int id) {
	    this.id = id;
	  }
	 
	  public String getName() {
	    return name;
	  }
	 
	  public void setName(String name) {
	    this.name = name;
	  }
	 
}

