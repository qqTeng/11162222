package com.ezh.erp.auth.dep.dao.impl;

import com.ezh.erp.auth.dep.dao.dao.DepDao;
import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.dep.vo.DepQueryModel;
import com.ezh.erp.util.base.BaseImpl;
import com.ezh.erp.util.base.BaseQueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-11-06.
 */
@Repository
public class DepImpl extends BaseImpl<DepModel> implements DepDao {

    @Override
    public void doQbc(DetachedCriteria dc, BaseQueryModel dqe) {
        DepModel dq = (DepModel)dqe;
        if(dq.getName() != null && dq.getName().trim().length()>0){
            dc.add(Restrictions.like("name","%"+dq.getName()+"%"));
        }
        if(dq.getTele() != null && dq.getTele().trim().length()>0){
            dc.add(Restrictions.like("tele",dq.getTele()));
        }
    }
}
