package com.zfx.forj;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;


/**
 * Created by zhangxx on 2018-05-21.
 */
public class baseModel {
    protected HashMap<String,Object> Members;
    //    protected JSONObject Members;
    //    {
    //        Members = new JSONObject();
    //    }




    public baseModel() {
        Members = new HashMap<String, Object>();

        Members.put("uniqueId",jobNumber.gen());
        Members.put("addDate",absTime.getDate());
        Members.put("addTime",absTime.getTime());
        Members.put("addUtc",absTime.absSecs());
    }
    public String uniqueId(){
        return Members.get("uniqueId").toString();
    }
    //public void uniqueId(String val){ Members.put("uniqueId",val);}

    public String addDate(){
        return Members.get("addDate").toString();
    }
    //public void addDate(String val){Members.put("addDate",val);}
    public String addTime(){
        return Members.get("addTime").toString();
    }
    //public void addTime(String val){    Members.put("addTime",val);}
    public Long addUtc(){
        return Long.parseLong(Members.get("addUtc").toString());
    }
    //public void addUtc(Long val){        Members.put("addUtc",val);    }

    public baseModel(HashMap<String,Object> dict){
        this();
        //Members = new HashMap<String, Object>();
        this.clone(dict);
    }

    public void clone(HashMap<String,Object> dict) {
        Object[] keys = dict.keySet().toArray();
        for(Integer i=0;i<keys.length;i++){
            String key=keys[i].toString();
            Members.put(key,dict.get(key));
        }
    }

    public String toString() {
        //return new JSONObject  (Members).toString();
        return new JSONObject(Members).toString();
    }


    public HashMap<String,Object> toDictionary() {
    //public JSONObject ToDictionary(){
        return Members;
    }

    public Set<String> keys() {
    //public Iterator keys() {
        return Members.keySet();
    }

    //public Object[] Vals(){
    //    public Object[] Vals(){
    //        return Members.
    //    }

    //    public object this[string key] {
    //        get { return Members[key]; }
    //        set { Members[key] = value; }
    //    }


}
