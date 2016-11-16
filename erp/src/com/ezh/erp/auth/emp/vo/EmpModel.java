package com.ezh.erp.auth.emp.vo;

import com.ezh.erp.auth.dep.vo.DepModel;
import com.ezh.erp.util.format.FormatUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016-11-09.
 */
public class EmpModel {

    public static final String EMP_LOGIN_USER_OBJECT_NAME = "loginEm";

    public static final Integer EMP_GENDER_OF_MAN = 1;
    public static final Integer EMP_GENDER_OF_WOMAN = 0;

    public static final String EMP_GENDER_OF_MAN_view = "男";
    public static final String EMP_GENDER_OF_WOMAN_view = "女";

    public static final Map<Integer,String> genderMap = new HashMap<Integer,String>();

    static{
        genderMap.put(EMP_GENDER_OF_MAN,EMP_GENDER_OF_MAN_view);
        genderMap.put(EMP_GENDER_OF_WOMAN,EMP_GENDER_OF_WOMAN_view);
    }

    private Long uuid;
    private String userName;
    private String pwd;
    private String name;
    private String address;
    private String email;
    private String tele;
    private Integer gender;
    private Long birthday;
    private String lastLoginIp;
    private Long lastLoginTime;
    private Integer loginTimes;



    //定义视图值
    private String birthdayView;
    private String genderView;
    private String lastLoginTimeView;
    //关系配置
    private DepModel de;

    public String getLastLoginTimeView() {
        return lastLoginTimeView;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        if (lastLoginTime!=null){
            this.lastLoginTimeView = FormatUtil.formatDate(lastLoginTime);
        }
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public DepModel getDe() {
        return de;
    }

    public void setDe(DepModel de) {
        this.de = de;
    }

    public String getBirthdayView() {
        return birthdayView;
    }

    public String getGenderView() {
        return genderView;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
        if(gender != null){
            this.genderView = genderMap.get(gender);
        }
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
        if(birthday != null){
            this.birthdayView = FormatUtil.formatDate(birthday);
        }
    }
}
