package com.zfx.forj;

/**
 * Created by zhangxx on 2018-05-21.
 */
public class User extends baseModel {

    public User() {
        Members.put("loginName","");
    }
    public String loginName(){
        return Members.get("loginName").toString();
    }
    public void loginName(String val){
        Members.put("loginName", val);
    }
//    public String loginName(String... val){
//        if(val!=null){
//            for(Object o:val){
//                if(o==null||"".equals(o)){
//                    return Members.get("loginName").toString();
//                }
//            }
//        }
//        Members.put("loginName", val);
//        return Members.get("loginName").toString();
//    }
}
