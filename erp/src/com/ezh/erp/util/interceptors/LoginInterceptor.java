package com.ezh.erp.util.interceptors;

import com.ezh.erp.auth.emp.vo.EmpModel;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by Administrator on 2016-11-05.
 */
public class LoginInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String className = (String) actionInvocation.getAction().getClass().getName();
        String method = actionInvocation.getProxy().getMethod();
        String name = className +"."+ method;
//        System.out.println("登陆的拦截器！");

        //如果是登陆的action就放行
       //如果不是登陆，就看session中是否存在用户存在：放行，不存在：返回登陆页面
        if (name.equals("com.ezh.erp.auth.emp.web.EmpAction.login")){
            return actionInvocation.invoke();
        }else{
             EmpModel loginEm = (EmpModel) ServletActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
            if (loginEm == null){
                return "noLogin";
            }else{
                return  actionInvocation.invoke();
            }
        }
    }
}
