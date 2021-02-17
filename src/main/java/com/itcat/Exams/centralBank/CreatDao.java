package com.itcat.Exams.centralBank;

import javax.annotation.Resources;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CreatDao {
//    @Autowired
//    protected config.properties properties;
//
//    public static void getLoder() throws IOException {
//        InputStream in = Resources.getResourceAsStream(properties.getProperty("tableXML"));
//        String tableXml = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining(System.lineSeparator()));
//        String doPackageString = properties.getProperty("tableXML");
//        createFile(tableXml, doPackageString);
//    }
//
//    public static void createFile(String tableXml, String dirDao) throws IOException {
//        if (tableXml == null || tableXml.length() == 0) return;
//        String[] xmlList = tableXml.split(".xml");
//        for (int i = 0; i < xmlList.length; i++) {
//            try {
//                String FileName = xmlList[i].substring(0, 1).toUpperCase() + xmlList[i].substring(1) + "Dao.java";
//                BufferedWriter bw = new BufferedWriter(new FileWriter(dirDao + "\\" + FileName));
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

//        if (file.exists()) {
//            System.out.println("创建单个文件" + FileNmae + "失败，目标文件已存在！");
//            return false;
//        }
//        if (FileNmae.endsWith(File.separator)) {
//            System.out.println("创建单个文件" + FileNmae + "失败，目标文件不能为目录！");
//            return false;
//        }
//        //判断目标文件所在的目录是否存在
//        if (!file.getParentFile().exists()) {
//            //如果目标文件所在的目录不存在，则创建父目录
//            System.out.println("目标文件所在目录不存在，准备创建它！");
//            if (!file.getParentFile().mkdirs()) {
//                System.out.println("创建目标文件所在目录失败！");
//                return false;
//            }
//        }
//        //创建目标文件
//        try {
//            if (file.createNewFile()) {
//                System.out.println("创建单个文件" + FileNmae + "成功！");
//                return true;
//            } else {
//                System.out.println("创建单个文件" + FileNmae + "失败！");
//                return false;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("创建单个文件" + FileNmae + "失败！" + e.getMessage());
//            return false;
//        }
//    }
//}
