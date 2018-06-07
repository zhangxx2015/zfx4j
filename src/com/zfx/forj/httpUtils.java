package com.zfx.forj;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import static com.zfx.forj.stringUtils.utf8Togb2312;

/**
 * Created by zhangxx on 2018-05-21.
 */
public class httpUtils {

    public static String Get(String url){
        String response=new String();
        HttpClient client = new HttpClient();
        HttpMethod method=new GetMethod(url);
        try{
            client.executeMethod(method);
        }catch (Exception ex)
        {
        }
        if(method.getStatusCode()==200){
            try {
                response = method.getResponseBodyAsString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        method.releaseConnection();
        return utf8Togb2312(response);
    }


    public static String Post(String url,Map<String, String> args){
        HttpClient client = new HttpClient();

        PostMethod method = new PostMethod(url);
        RequestEntity se = null;
        try {
            JSONObject jsonObject = new JSONObject();
            try {
                if (args != null) {
                    @SuppressWarnings("rawtypes")
                    Iterator iter = args.entrySet().iterator();
                    while (iter.hasNext()) {
                        @SuppressWarnings("rawtypes")
                        Map.Entry entry = (Map.Entry) iter.next();
                        String inputName = (String) entry.getKey();
                        String inputValue = (String) entry.getValue();
                        if (inputValue == null) {
                            continue;
                        }
                        jsonObject.put(inputName,inputValue);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            se = new StringRequestEntity(jsonObject.toString(),"application/json", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        method.setRequestEntity(se);
        method.setRequestHeader("Content-Type","application/json; charset=utf-8");
        method.setRequestHeader("Accept","application/json");
        method.releaseConnection();
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 1200000);
        try {
            client.executeMethod(method);
            String response = method.getResponseBodyAsString();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
