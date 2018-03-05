package com.zhaihuilin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaihuilin on 2018/1/29  9:29.
 */
public class testFileStream {


    public  static  void  Test(){
        InputStreamReader reader =null;
        BufferedReader bufferedReader =null;
        String FileTxt= "F:\\test.txt";//文件路劲
        Set<String> tempSet = new HashSet<>();
        List<String> allRulesList =new ArrayList<>();
        String encoding = "utf-8";
         try {
             reader = new  InputStreamReader(new FileInputStream(FileTxt),encoding);

             bufferedReader =new BufferedReader(reader);

             String lineTxt;

             while ((lineTxt=bufferedReader.readLine())!=null){
                 if (tempSet.add(lineTxt)){ // set 去重复
                     if (lineTxt.isEmpty()){ //处理空行
                          continue;
                     }
                     allRulesList.add(lineTxt);
                 }
             }
         }catch (Exception e){
             System.out.println("读取文件异常.........");
             e.printStackTrace();
         }finally {
             if (reader !=null){
                 try {
                     reader.close();
                 }catch (Exception e){
                     System.out.println("关闭文件异常.......");
                 }
             }
             if (bufferedReader !=null){
                 try {
                     bufferedReader.close();
                 }catch (Exception e){
                     System.out.println("关闭bufferedReader流异常............");
                 }
             }
         }
         //打印输出
         for (String s :allRulesList){
             System.out.println("打印:"+ s);
             System.out.println("s的长度:"+s.length());
             String[] s4=s.split("phone:");
             System.out.println("s4----------->"+s4);
             if (s4 !=null){
                  for (int i=0;i<s4.length;i++){
                     if (i==1){
                         String ss= s4[1];
                         System.out.println("截取的----------->:"+ss);
                         String s1=ss.substring(0,11);
                         System.out.println("截取的------s1----->:"+s1);
                         try {
                             File file= new File("F:\\phone.txt");//将提取的手机号写入到
                             if (!file.exists()){//不存在就新建
                                 file.createNewFile();
                             }
                             //创建一个向具有指定 name 的文件中写入数据的输出文件流。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
                             FileOutputStream fileOutputStream=new FileOutputStream(file,true);
                             //获取字节的内容数组
                             byte[] bb=s1.getBytes();
                             System.out.println("字节bb--------->"+bb);
                             fileOutputStream.write(bb);
                             fileOutputStream.write("\r\n".getBytes()); //换行
                             fileOutputStream.flush();
                             fileOutputStream.close();
                             //开始写
                         }catch (Exception e){
                             e.printStackTrace();
                         }
                     }

                  }
             }
         }
    }
}
