package test.ser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestJars {
  
  public static void main(String[] args) throws IOException {
    
    /* 读入TXT文件 */
    String pathname = "E:\\downloaded\\sendmsg_jars.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
    File filename = new File(pathname); // 要读取以上路径的input。txt文件
    InputStreamReader reader = new InputStreamReader(
            new FileInputStream(filename)); // 建立一个输入流对象reader
    BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
    String line = "";
    line = br.readLine();
    while (line != null) {
        line = br.readLine(); // 一次读入一行数据
        if(null != line)
        System.out.println(line.substring(0,line.lastIndexOf("-")));
  }
  

}
}
