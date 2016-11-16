package com.ezh.erp.auth.emp.web;

import com.ezh.erp.auth.dep.business.ebi.DepEbi;
import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.emp.business.ebi.EmpEbi;
import com.ezh.erp.auth.emp.vo.*;
import com.ezh.erp.util.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class EmpAction extends BaseAction{

	public EmpModel em = new EmpModel();
	public EmpQueryModel qm = new EmpQueryModel();

	@Autowired
	private EmpEbi empEbi;
	private String newPwd;

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	@Autowired
	private DepEbi depEbi;

	//列表
	public String list(){
		List<DepModel> depList = depEbi.getAll();
		put("depList",depList);
//		Logger.getLogger(String.class).info("查询员工列表");
		setDataTotal(empEbi.getCount(qm));
		List<EmpModel> empList = empEbi.getAll(qm,pageNum,pageCount);
		put("empList",empList);
		return LIST;
	}

	//跳转到修改页面，或者跳转到添加操作
	public String input(){
//		System.out.println("执行到了添加的方法："+em.getUuid());

		List<DepModel> depList = depEbi.getAll();
		put("depList",depList);

		if(em.getUuid()!= null){
			em = empEbi.get(em.getUuid());
		}
		return INPUT;
	}

	//执行保存操作，或者执行修改操作
	public String save(){
//		System.out.println("看看qm："+qm+":"+qm.getUserName());
//		System.out.println("执行到了保存的方法");
		if(em.getUuid() == null){
			empEbi.save(em);
		}else{
			empEbi.update(em);
		}
		System.out.println("执行完了保存操作");
		return TO_LIST;
	}

	//删除
	public String delete(){
		empEbi.delete(em);
		return TO_LIST;
	}
	public String login(){
		//获取登录ip地址
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginIp = request.getHeader("x-forwarded-for");
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getHeader("Proxy-Client-IP");
		}
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getRemoteAddr();
		}

		EmpModel loginEm = empEbi.login(em.getUserName(), em.getPwd(),loginIp);
//		System.out.println(loginEm.getName()+"--->");
		if(loginEm != null){
			putSession(EmpModel.EMP_LOGIN_USER_OBJECT_NAME,loginEm);
			return "loginSuccess";
		}else{
			this.addActionError("登陆失败，用户名或密码错误");
			return "loginFail";
		}
	}
	public String logout(){
		putSession(EmpModel.EMP_LOGIN_USER_OBJECT_NAME,null);
		return "noLogin";
	}

	public String toChangePwd(){
		return "changePwd";
	}

	public String changePwd(){
		Boolean rs = empEbi.changePwd(getLogin().getUserName(),em.getPwd(),newPwd);
		if (rs){
			//重新跳转到登录页面
			putSession(EmpModel.EMP_LOGIN_USER_OBJECT_NAME,null);
			return "noLogin";
		}else{
			//跳转回到原来的登录页面
			this.addActionError("用户名或者密码不符合要求，修改失败");
			return "changePwd";
		}
	}
}
