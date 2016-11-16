package com.ezh.erp.auth.dep.web;

import com.ezh.erp.auth.dep.business.ebi.DepEbi;
import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.dep.vo.DepQueryModel;
import com.ezh.erp.util.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016-11-06.
 */
@Controller
public class DepAction extends BaseAction{
    @Resource
    private DepEbi depEbi;

    public DepModel de = new DepModel();
    public DepQueryModel dqe = new DepQueryModel();

    public String list(){
        dataTotal = depEbi.getCount(dqe);
        setDataTotal(dataTotal);
        List<DepModel> list = depEbi.getAll(dqe,pageNum,pageCount);
        put("depList",list);
        return LIST;
    }

    public String input(){
//        System.out.println("点击了修改按钮："+de.getUuid());
        if(de.getUuid() != 0){
            de = depEbi.get(de.getUuid());
        }
        return INPUT;
    }

    public String save(){
        //把保存和修改合并成一个功能
        if(de.getUuid() == 0){
            depEbi.save(de);
        }else{
            depEbi.update(de);
        }
        return TO_LIST;
    }

    public String delete(){
//        System.out.println("执行到了删除的操作："+de+":"+de.getUuid());
        depEbi.delete(de);
        return TO_LIST;
    }
}
