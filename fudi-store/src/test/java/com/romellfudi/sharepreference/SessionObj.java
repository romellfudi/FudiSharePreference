package com.romellfudi.sharepreference;

import com.romellfudi.sharepreference.resources.ObjectBean;
import com.romellfudi.sharepreference.resources.ObjectDetailBean;

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

public class SessionObj {

    public static void setObjectDetailBeanCurrent(ObjectDetailBean objectDetailBeanCurrent) {
        SharePreferenced.save(objectDetailBeanCurrent,ObjectDetailBean.class);
    }
    public static ObjectDetailBean getObjectDetailBeanCurrent() {
        return  SharePreferenced.load(ObjectDetailBean.class);
    }

    public static void setObjectDetailBeanCurrentTAG(ObjectDetailBean objectDetailBeanCurrent) {
        SharePreferenced.save(objectDetailBeanCurrent,ObjectDetailBean.class,"TAG");
    }
    public static ObjectDetailBean getObjectDetailBeanCurrentTAG() {
        return  SharePreferenced.load(ObjectDetailBean.class,"TAG");
    }

    public static void currentObject(ObjectBean objectBean){
        SharePreferenced.save(objectBean,ObjectBean.class);
    }

    public static ObjectBean currentObject(){
        return SharePreferenced.load(ObjectBean.class);
    }
}
