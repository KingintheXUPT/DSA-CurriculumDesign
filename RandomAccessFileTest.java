package MainPackage;

/** 
 * ���ļ�������д��3��Ա������Ϣ�� 
 * ÿλԱ����������Ա�������ֶ� Ȼ���� 
 * �ڶ�������һ�������������Ⱥ�˳���ȡԱ����Ϣ 
 */  
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;  
import java.io.*;
  
public class RandomAccessFileTest { 
    public static void main(String[] args) throws Exception {  
        Employee e1 = new Employee(23, "����");  
        Employee e2 = new Employee(24, "lisi");  
        Employee e3 = new Employee(25, "����");  
        File file = new File("employee.txt");  
        if (!file.exists()) {  
            file.createNewFile();  
        }  
        // һ������ռ�����ֽ� һ��Ӣ����ĸռһ���ֽ�  
        // ���� ռ���ֽ���Ŀ ��cpuλ���й� 32λ��ռ4���ֽ�  
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");  
        randomAccessFile.writeChars(e1.getName());  
        randomAccessFile.writeInt(e1.getAge());  
        randomAccessFile.writeChars(e2.getName());  
        randomAccessFile.writeInt(e2.getAge());  
        randomAccessFile.writeChars(e3.getName());  
        randomAccessFile.writeInt(e3.getAge());  
        randomAccessFile.close();  
  
        RandomAccessFile raf2 = new RandomAccessFile(file, "r");  
        raf2.skipBytes(Employee.LEN * 2 + 4);  
        String strName2 = "";  
        for (int i = 0; i < Employee.LEN; i++) {  
            strName2 = strName2 + raf2.readChar();  
        }  
        int age2 = raf2.readInt();  
        System.out.println("strName2 = " + strName2.trim());  
        System.out.println("age2 = " + age2);  
  
        raf2.seek(0);  
        String strName1 = "";  
        for (int i = 0; i < Employee.LEN; i++) {  
            strName1 = strName1 + raf2.readChar();  
        }  
        int age1 = raf2.readInt();  
        System.out.println("strName1 = " + strName1.trim());  
        System.out.println("age1 = " + age1);  
  
        raf2.skipBytes(Employee.LEN * 2 + 4);  
        String strName3 = "";  
        for (int i = 0; i < Employee.LEN; i++) {  
            strName3 = strName3 + raf2.readChar();  
        }  
        int age3 = raf2.readInt();  
        System.out.println("strName3 = " + strName3.trim());  
        System.out.println("age3 = " + age3); 
    }  
}  
  
class Employee {  
    // ����  
    public int age;  
    // ����  
    public String name;  
    // �����ĳ���  
    public static final int LEN = 8;  
  
    public Employee(int age, String name) {  
        this.age = age;  
  
        // ��name�ַ����ȵ�һ������  
        if (name.length() > LEN) {  
            name = name.substring(0, LEN);  
        } else {  
            while (name.length() < LEN) {  
                name = name + "/u0000";  
            }  
        }  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
}  
