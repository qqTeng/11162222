package com.ezh.erp.auth.emp.vo;

import com.ezh.erp.util.base.BaseQueryModel;
import com.ezh.erp.util.format.FormatUtil;

/**
 * Created by Administrator on 2016-11-09.
 */
public class EmpQueryModel extends EmpModel implements BaseQueryModel{
    private Long birthday2;
    private String birthday2View;

    public Long getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(Long birthday2) {
        this.birthday2 = birthday2;
        if(birthday2 != null){
            this.birthday2View = FormatUtil.formatDate(birthday2);
        }
    }

    public String getBirthday2View() {
        return birthday2View;
    }
}
