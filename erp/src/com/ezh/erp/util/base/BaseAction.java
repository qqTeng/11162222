package com.ezh.erp.util.base;

import com.ezh.erp.auth.emp.vo.EmpModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016-11-08.
 */
public class BaseAction extends ActionSupport {

//    定义跳转页面常用的常量
    protected static final String LIST = "list";
    protected static final String TO_LIST = "toList";
    protected static final String INPUT = "input";

    //定义分页使用的常量
    public Integer pageCount = 3;//页大小
    public Integer pageNum = 1;//当前页
    public Integer maxPageNum;//最大页数
    public Integer dataTotal;//总行数

    //定义存放数据的方法
    public void put(String key,Object value){
        ActionContext.getContext().put(key,value);
    }

    public void putSession(String key,Object value){
        ActionContext.getContext().getSession().put(key,value);
    }
    public HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }

    protected void setDataTotal (Integer dataTotal){
        this.dataTotal = dataTotal;
        maxPageNum = (dataTotal+pageCount-1)/pageCount;
    }
    public String getActionName(){
//        String simpleName = ;//EmpAction
////        System.out.println();
//        String first = simpleName.substring(0,1);
//        System.out.println(simpleName.substring();
//        System.out.println("A".toLowerCase());

        return this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1,this.getClass().getSimpleName().trim().length()-6);
    }

    public EmpModel getLogin(){
        return (EmpModel) getSession().getAttribute(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
    }



}
