package com.zfx.forj;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zhangxx on 2018-05-21.
 */
public class stringUtils {
    public static String string_Format(String format,Object p0){
        return string_Format(format,new Object[]{p0});
    }
    public static String string_Format(String format,Object p0,Object p1){
        return string_Format(format,new Object[]{p0,p1});
    }
    public static String string_Format(String format,Object p0,Object p1,Object p2){
        return string_Format(format,new Object[]{p0,p1,p2});
    }
    public static String string_Format(String format,Object p0,Object p1,Object p2,Object p3){
        return string_Format(format,new Object[]{p0,p1,p2,p3});
    }
    /**
     * 辅助函数: 格式化字符串, 模仿 C# 中 String.Format("{0}{1}",param1,param2);
     *
     * @return String of format
     * @version etcomm.SDK.HttpService 1.0.0
     * @since JDK 1.6
     */
    public static String string_Format(String format,Object[] params)
    {
        String result=format;
        for(int i=0;i<params.length;i++)
            result = result.replace(String.format("{%d}",i),params[i].toString());
        return result;
    }

    /**
     * 辅助函数: 合并字符串
     *
     * @return String of strAry
     * @version etcomm.SDK.HttpService 1.0.0
     * @since JDK 1.6
     */
    public static String string_Join(String join,String[] strAry){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<strAry.length;i++){
            if(i==(strAry.length-1)){
                sb.append(strAry[i]);
            }else{
                sb.append(strAry[i]).append(join);
            }
        }
        return new String(sb);
    }

    /**
     * 辅助函数: UTF-8  编码转 GB2312 编码
     *
     * @return gb2312 String
     * @version etcomm.SDK.HttpService 1.0.0
     * @since JDK 1.6
     */
    public static String utf8Togb2312(String str){
        StringBuffer sb = new StringBuffer();
        for ( int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+' :
                    sb.append( ' ' );
                    break ;
                case '%' :
                    try {
                        sb.append(( char )Integer.parseInt (
                                str.substring(i+1,i+3),16));
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                    i += 2;
                    break ;
                default :
                    sb.append(c);
                    break ;
            }
        }
        String result = sb.toString();
        String res= null ;
        try {
            byte [] inputBytes = result.getBytes( "8859_1" );
            res= new String(inputBytes, "UTF-8" );
        }
        catch (Exception e){}
        return res;
    }
    /**
     * 辅助函数: GB2312  编码转 UTF-8  编码
     *
     * @return UTF-8 String
     * @version etcomm.SDK.HttpService 1.0.0
     * @since JDK 1.6
     */
    public static String gb2312ToUtf8(String str) {
        String urlEncode = "" ;
        try {
            urlEncode = URLEncoder.encode (str, "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncode;
    }


}
