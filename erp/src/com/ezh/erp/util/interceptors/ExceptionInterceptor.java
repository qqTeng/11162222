package com.ezh.erp.util.interceptors;

import com.ezh.erp.util.exception.AppException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by HSAEE on 2016/11/13.
 */
public class ExceptionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        try {
            actionInvocation.invoke();
        } catch (AppException e) {
            ActionSupport as = (ActionSupport) actionInvocation.getAction();
            as.addActionError(e.getMessage());
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return actionInvocation.invoke();
        }
        return  null;
    }
}
