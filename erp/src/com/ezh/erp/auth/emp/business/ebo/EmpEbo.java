package com.ezh.erp.auth.emp.business.ebo;

import java.util.List;

import com.ezh.erp.auth.emp.business.ebi.EmpEbi;
import com.ezh.erp.auth.emp.dao.dao.EmpDao;
import com.ezh.erp.auth.emp.vo.EmpModel;
import com.ezh.erp.util.base.BaseQueryModel;
import com.ezh.erp.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpEbo implements EmpEbi{

	@Autowired
	private EmpDao empDao;

	/*
    @Param userName 用户名
    @Param pwd 密码
    @return null:登陆失败   否则登陆成功
     */
	@Override
	public EmpModel login(String userName, String pwd,String lastLoginIp) {
		EmpModel em = empDao.login(userName,pwd);
		if (em != null){
			if (em.getLoginTimes() == null)em.setLoginTimes(1);else {
				em.setLoginTimes(em.getLoginTimes() + 1);
				System.out.println("最后登录ip："+lastLoginIp);
				em.setLastLoginIp(lastLoginIp);
				em.setLastLoginTime(System.currentTimeMillis());
			}
		}
		return em;
	}

	@Override
	public boolean changePwd(String userName, String pwd, String newPwd) {

		return empDao.changePwd(userName,pwd,newPwd);
	}

	public void save(EmpModel em) {
		//使用自定义异常
		if (em.getUserName()==null || em.getUserName().trim().length()==0){
			throw new AppException("用户名输入有误，请重新访问！");
		}
		//初始化登录时间，ip，登录次数
		em.setLastLoginIp("-");
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLoginTimes(0);
		empDao.save(em);
	}

	public void update(EmpModel em) {
		//调用update方法，全部都能改变，我们可以使用持久状态来更新，避免不必要的更新
		EmpModel nem = empDao.get(em.getUuid());
		nem.setAddress(em.getAddress());
		nem.setName(em.getName());
		nem.setTele(em.getTele());
		nem.setEmail(em.getTele());
		nem.setDe(em.getDe());
//		empDao.update(em);
	}

	public void delete(EmpModel em) {
		empDao.delete(em);
	}

	@Override
	public EmpModel get(long uuid) {
		return empDao.get(uuid);
	}

	public List<EmpModel> getAll() {
		return empDao.getAll();
	}

	public List<EmpModel> getAll(BaseQueryModel qm, Integer pageNum,Integer pageCount) {
		return empDao.getAll(qm,pageNum,pageCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return empDao.getCount(qm);
	}
}
