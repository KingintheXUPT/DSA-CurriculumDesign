package MainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Text{
	public static void writeByBufferedReader() {  
        try {  
  
            String content = "This is the content to write into file";  
            File file = new File("/users/mkyong/filename.txt");  
            // if file doesnt exists, then create it  
            if (!file.exists()) {  
                file.createNewFile();  
            }  
            FileWriter fw = new FileWriter(file, true);  
            BufferedWriter bw = new BufferedWriter(fw);  
            bw.write(content);  
            bw.flush();  
            bw.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
	
	public static void addchange(add arr){
		arr.a=23;
		arr.name="dadsddsa";
	}
	
	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		csd aa = new csd();
//		System.out.print(aa.b[1].name);
//		String a = "sda";
//		String b = in.next();
//		if(a==b){			//字符串的比较应该用equals函数
//			System.out.println(3);
//		}
//		System.out.println(b);
//		int  b = (int)(0+Math.random()*3);
//		System.out.println(b);
		
//		add[] arr = new add[5];
//		for(int i = 0; i<5;i++){
//			arr[i] = new add();
//		}
//		
//		arr[0].a=1;
//		arr[0].name="aa";
//		arr[1].a=2;
//		arr[1].name="bb";
//		arr[2].a=3;
//		arr[2].name="cc";
//		arr[3].a=4;
//		arr[3].name="dd";
//		arr[4].a=5;
//		arr[4].name="ee";
//		
//		for(int i = 2 ; i<4 ; i++){
//			arr[i]=arr[i+1];
//		}
//		
//		for(add u:arr){
//			System.out.println(u.name);
//		}
//		add arr = new add();
//		addchange(arr);
//		System.out.println(arr.a+arr.name);
		
		String a ="sdasds";
		a = a+"呵呵";
		System.out.println(a);
	}
}




class add{
	int  a =0;
	String name="afg";
}

class adsadsa extends add{
	add[] b = new add[3];	
	
}

class csd extends adsadsa{
	int i =0;
	Vextype aaa;
	String a="222";

	
	public csd(){					//子类继承父类的创建方法不能有类型
		for(int i =0;i<3;i++){				//需要给每个数组元素开辟空间
			add a =new add();
			this.b[i]=a;
		}
		this.i=i;
		this.a="sdds";
		b[1].a=34;
		b[1].name="dasdas";
	}	
}
