package com.ezh.erp.auth.dep.business.ebo;

import com.ezh.erp.auth.dep.business.ebi.DepEbi;
import com.ezh.erp.auth.dep.dao.dao.DepDao;
import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.dep.vo.DepQueryModel;
import com.ezh.erp.util.base.BaseQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016-11-06.
 */
@Service
public class DepEbo implements DepEbi {
    @Autowired
    private DepDao depDao;

    @Override
    public void save(DepModel depModel) {
        depDao.save(depModel);
    }

    @Override
    public void update(DepModel depModel) {
        depDao.update(depModel);
    }

    @Override
    public void delete(DepModel depModel) {
        depDao.delete(depModel);
    }

    @Override
    public DepModel get(long uuid) {
        return depDao.get(uuid);
    }

    @Override
    public List<DepModel> getAll() {
        return depDao.getAll();
    }

    @Override
    public List<DepModel> getAll(BaseQueryModel dqe, Integer pageNum, Integer pageCount) {
        return depDao.getAll(dqe,pageNum,pageCount);
    }

    @Override
    public Integer getCount(BaseQueryModel baseQueryModel) {
        return depDao.getCount(baseQueryModel);
    }
}
