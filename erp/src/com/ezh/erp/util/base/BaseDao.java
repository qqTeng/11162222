package com.ezh.erp.util.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-11-08.
 */
public interface BaseDao<T> {
//    增加
    public void save(T t);
//    删除
    public void delete(T t);
//    修改
    public void update(T t);
//    查询单一数据
    public T get(Serializable uuid);
//    查询全部数据
    public List<T> getAll();
//    按条件分页查询
    public List<T> getAll(BaseQueryModel qm, Integer pageNum, Integer prePageNum);
//    按条件获取数据总量
    public Integer getCount(BaseQueryModel qm);

}
