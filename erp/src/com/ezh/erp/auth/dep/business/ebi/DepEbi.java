package com.ezh.erp.auth.dep.business.ebi;

import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.auth.dep.vo.DepQueryModel;
import com.ezh.erp.util.base.BaseEbi;
import com.ezh.erp.util.base.BaseQueryModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016-11-06.
 */
@Transactional
public interface DepEbi extends BaseEbi<DepModel,BaseQueryModel>{

}
