package com.ezh.erp.auth.emp.business.ebi;

import com.ezh.erp.auth.emp.vo.EmpModel;
import com.ezh.erp.util.base.BaseQueryModel;
import org.springframework.transaction.annotation.Transactional;

import com.ezh.erp.util.base.BaseEbi;

@Transactional
public interface EmpEbi extends BaseEbi<EmpModel,BaseQueryModel>{

    EmpModel login(String userName, String pwd,String lastLoginIp);


    boolean changePwd(String userName, String pwd, String newPwd);
}
