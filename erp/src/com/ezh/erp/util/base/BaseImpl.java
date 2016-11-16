package com.ezh.erp.util.base;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016-11-08.
 */
public abstract class BaseImpl<T> implements BaseDao<T> {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    private Class<T> entityClass = null;

    //获取泛型的泛型
    public BaseImpl(){
        Type type=getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType)type;
        Type[] actualTypeArguments = pType.getActualTypeArguments();
        entityClass = (Class)actualTypeArguments[0];

    }

    @Override
    public void save(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public void delete(T t) {
        hibernateTemplate.delete(t);
    }

    @Override
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    @Override
    public T get(Serializable uuid) {
        return hibernateTemplate.get(entityClass,uuid);
    }

    @Override
    public List<T> getAll() {
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);

        return (List<T>) hibernateTemplate.findByCriteria(dc);
    }

    @Override
    public List<T> getAll(BaseQueryModel qm, Integer pageNum, Integer pageCount) {
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        doQbc(dc,qm);
        System.out.println("当前页数："+pageNum+":"+pageCount);
        return (List<T>) hibernateTemplate.findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
    }

    @Override
    public Integer getCount(BaseQueryModel qm) {
//        System.out.println("看看泛型获取到了没有啊："+entityClass);
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        dc.setProjection(Projections.rowCount());
        doQbc(dc,qm);
        List<Long> count = (List<Long>) hibernateTemplate.findByCriteria(dc);
        return count.get(0).intValue();
    }

//    doQbc的方法主要是设置条件，获取分页的结果
    public abstract void   doQbc(DetachedCriteria dc,BaseQueryModel dqe);

}
