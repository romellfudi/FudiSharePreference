package com.romellfudi.sharepreferencesample;

import com.romellfudi.sharepreference.SharePreferenced;

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

public class SessionObj {

    private static SessionObj instance;

    private SessionObj(){}

    public static SessionObj getInstance(){
        if (instance == null)
            instance = new SessionObj();
        return  instance;
    }

    public void setObjectDetailBeanCurrent(ObjectDetailBean objectDetailBeanCurrent) {
        SharePreferenced.save(objectDetailBeanCurrent,ObjectDetailBean.class);
    }
    public ObjectDetailBean getObjectDetailBeanCurrent() {
        return  SharePreferenced.load(ObjectDetailBean.class);
    }

    public void setObjectDetailBeanCurrentTAG(ObjectDetailBean objectDetailBeanCurrent) {
        SharePreferenced.save(objectDetailBeanCurrent,ObjectDetailBean.class,"TAG");
    }
    public ObjectDetailBean getObjectDetailBeanCurrentTAG() {
        return  SharePreferenced.load(ObjectDetailBean.class,"TAG");
    }
}
