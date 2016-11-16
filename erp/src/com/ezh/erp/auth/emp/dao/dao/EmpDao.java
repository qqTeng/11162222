package com.ezh.erp.auth.emp.dao.dao;

import com.ezh.erp.auth.emp.vo.EmpModel;
import com.ezh.erp.util.base.BaseDao;
import com.ezh.erp.util.base.BaseQueryModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmpDao extends BaseDao<EmpModel> {
    EmpModel login(String userName, String pwd);

    boolean changePwd(String userName, String pwd, String newPwd);
}
