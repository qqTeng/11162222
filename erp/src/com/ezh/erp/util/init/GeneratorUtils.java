package com.ezh.erp.util.init;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016-11-08.
 * 初始化目录结构
 */
public class GeneratorUtils {
    public GeneratorUtils() throws IOException {
        String rootDir = "MYERM/src/com/ezh/erp/invoice/dep";
        Class clazz;   //java
        String big;    //Emp
        String small = "emp";   //emp
        String little;  //e
                        //MYERM/src/com/ezh/erp/invoce/auth/dep
                        // MYERM/src/com/ezh/erp/invoce/auth/dep/business/ebi/DepEbi.java
        File dir ;

        //生成queryModel

        //生成model.hbm.xml
        System.out.println(rootDir+"/web");

        //生成dao
        dir = new File(rootDir+"/dao/dao");
        dir.mkdirs();
        dir = new File(rootDir+"/dao/dao/"+small+"Dao"+".java");
        dir.createNewFile();

        //生成impl
        dir = new File(rootDir+"/dao/impl");
        dir.mkdirs();
        dir = new File(rootDir+"/dao/impl/"+small+"Impl"+".java");
        dir.createNewFile();

        //生成ebi
        dir = new File(rootDir+"/business/ebi");
        dir.mkdirs();
        dir = new File(rootDir+"/business/ebi/"+small+"Ebi"+".java");
        dir.createNewFile();

        //生成ebo
        dir = new File(rootDir+"/business/ebo");
        dir.mkdirs();
        dir = new File(rootDir+"/business/ebo/"+small+"Ebo"+".java");
        dir.mkdirs();

        //生成action
        dir = new File(rootDir+"/web");
        dir.mkdirs();
        dir = new File(rootDir+"/web/"+small+"Action"+".java");
        dir.mkdirs();

        //生成applicationContext.xml

    }

    public static void main(String[] args) throws IOException {
        new GeneratorUtils();
    }
}
