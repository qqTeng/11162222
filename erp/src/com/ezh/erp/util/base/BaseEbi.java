package com.ezh.erp.util.base;

import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.dep.vo.DepQueryModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016-11-08.
 */
@Transactional
public interface BaseEbi<T,Q> {
    void save(T t);

    void update(T t);

    void delete(T t);

    T get(long uuid);

    List<T> getAll();

    List<T> getAll(Q dqe, Integer pageNum, Integer pageCount);

    Integer getCount(Q q);
}
