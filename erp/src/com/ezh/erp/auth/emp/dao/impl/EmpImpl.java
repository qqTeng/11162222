package com.ezh.erp.auth.emp.dao.impl;
import com.ezh.erp.auth.emp.vo.EmpModel;
import com.ezh.erp.auth.emp.vo.EmpQueryModel;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;

import com.ezh.erp.auth.emp.dao.dao.EmpDao;
import com.ezh.erp.util.base.BaseImpl;
import com.ezh.erp.util.base.BaseQueryModel;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpImpl extends BaseImpl<EmpModel> implements EmpDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
    private Logger log = Logger.getLogger(String.class);

	public void doQbc(DetachedCriteria dc,BaseQueryModel qm){
		EmpQueryModel eqm = (EmpQueryModel) qm;
		// TODO 添加自定义查询条件
		if(eqm.getUserName()!=null && eqm.getUserName().trim().length()>0){
			dc.add(Restrictions.eq("userName",eqm.getUserName()));
		}
		if(eqm.getName()!=null && eqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name","%"+eqm.getName()+"%"));
		}
		if(eqm.getTele()!=null && eqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele","%"+eqm.getTele()+"%"));
		}
		if(eqm.getGender()!=null && eqm.getGender() != -1){
			dc.add(Restrictions.eq("gender",eqm.getGender()));
		}
		if(eqm.getEmail()!=null && eqm.getEmail().trim().length()>0){
			dc.add(Restrictions.like("email",eqm.getEmail()));
		}
		if(eqm.getDe()!=null && eqm.getDe().getUuid() != null && eqm.getDe().getUuid() != -1){
			dc.add(Restrictions.eq("de",eqm.getDe()));
		}
		//增加关于时间的判断依据
		if (eqm.getBirthday()!=null){
			dc.add(Restrictions.ge("birthday",eqm.getBirthday()));
		}
		if (eqm.getBirthday2()!=null){
			dc.add(Restrictions.le("birthday",eqm.getBirthday2()));
		}

	}

	@Override
	public EmpModel login(String userName, String pwd) {

        log.info("impl-》登陆数据--》用户名："+userName+"--》密码："+pwd);
		String hql = "from EmpModel where userName = ? and pwd = ?";
		List<EmpModel> empModel = (List<EmpModel>) hibernateTemplate.find(hql,userName,pwd);
        log.info("登陆返回的内容："+empModel);
		return empModel.size()>0?empModel.get(0):null;
	}

	@Override
	public boolean changePwd(String userName, String pwd, String newPwd) {
		System.out.println(userName+":"+pwd+":"+newPwd);
		int row = hibernateTemplate.bulkUpdate("update EmpModel set pwd = ? where userName = ? and pwd = ?",newPwd,userName,pwd);
		return row>0;
	}

	;

}
