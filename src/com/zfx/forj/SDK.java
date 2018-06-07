package com.zfx.forj;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhangxx on 2018-05-21.
 */
public class SDK {

    /**
     * 身份验证:
     *
     * @return 访问令牌
     * @param host 服务地址
     * @param loginName 登录帐号
     * @param password 登录密码
     * @throws Exception 错误描述
     */
    public static String Auth(String host, String loginName,String password) throws Exception{
        String url=host+"/api/Auth";
        Map<String, String> args = new HashMap<String, String>();
        args.put("loginName",loginName);
        args.put("password",password);
        String json = httpUtils.Post(url,args);
        try {
            JSONObject jobj = new JSONObject(json);
            if(!jobj.has("total")||!jobj.has("PageMax")||!jobj.has("pageIndex")||!jobj.has("pageSize")||!jobj.has("Request")||!jobj.has("Status")||!jobj.has("ResType")||!jobj.has("data")||!jobj.has("Error")){
                throw new Exception("Illegal http message");
            }
            if(!jobj.getString("Status").equals("OK")){
                throw new Exception("err:"+jobj.getString("Error"));
            }
            return  new JSONObject(jobj.getString("data")).getString("accessKey");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        throw new Exception("Unknow error");
    }
}
