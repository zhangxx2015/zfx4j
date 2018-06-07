import com.zfx.forj.*;
import org.apache.commons.codec.binary.Base64;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Created by zhangxx on 2018-05-21.
 */
public class Program {
    public static void main(String[] commandLines) throws Exception {
        User user=new User();
        user.loginName("a");
        System.out.println(user.toString());
    }
    public static void main2(String[] commandLines) throws Exception {
//        String host = "http://106.3.133.115:10000";
//        String loginName  = "ikangOC";
//        String password   = "123456";
//        System.out.println("鉴权,获取令牌...");

        //String guid=java.util.UUID.randomUUID().toString().replace("-","");
        //guid="5bc217cfe5ed41f0b22cce2c7003836a";
        //
        //System.out.println(guid);
        //
        //
        //byte[] byteGuid=new byte[guid.length()/2];
        //Integer idxGuid=0;
        //while(guid.length()>0) {
        //    String hex = guid.substring(0, 2);
        //    //System.out.printf("hex:%s\r\n",hex);
        //    guid=guid.substring(2);
        //    Integer val = Integer.parseInt(hex,16);
        //    //System.out.printf("%d\r\n",  val);
        //
        //    //byteGuid[idxGuid++]=intToByteArray(val)[3];
        //
        //    byteGuid[byteGuid.length- idxGuid-1]= byteUtils.intToByteArray(val)[3];
        //    idxGuid++;
        //}
        //for(int i=0;i<byteGuid.length;i++){
        //    //System.out.printf("%x\r\n",byteGuid[i]);
        //}
        //
        ////-1134364059842919845
        ////F041EDE5CF17C25B
        //
        //Long lval=new BigInteger(byteGuid).longValue();
        //BigInteger bi = new BigInteger(lval.toString());
        //byte[] bytes = bi.toByteArray();
        //byte[] littleEndian=new byte[]{bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]};
        //
        //System.out.printf("%x-%x-%x-%x-%x-%x-%x-%x\r\n",bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]);
        ////System.out.printf("base64:%s\r\n", base64.encode(new byte[]{bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]}));
        //byte[] result = Base64.encodeBase64(littleEndian);
        //// W8IXz+XtQfA
        //String unqiuId=new String(result);
        //System.out.println(unqiuId);


        //System.out.println(jobNumber.gen());


        long ticks=System.currentTimeMillis();
        int rounds=1000*10000;
        HashSet<String> hashSet = new HashSet<String>(rounds);
        for(int i=1;i<rounds;i++) {
            if(0==i%10000){
                System.out.printf("%d/%d\r\n",i,rounds);
            }
            hashSet.add(jobNumber.gen());
            //System.out.println(hashSet.size());
            if(hashSet.size()!=i){
                String msg = System.out.printf("reduplicate %d",hashSet.size()).toString();
                throw new Exception(msg);
            }
        }
        ticks=System.currentTimeMillis()-ticks;
        float excTime=(float)(ticks)/1000;
        System.out.println("done,elapse："+excTime+"s");




//        byte[] _test={
//                0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x10,
//                0x10,0x09,0x08,0x07,0x06,0x05,0x04,0x03,0x02,0x01
//        };
//        System.out.printf("crc:%X\r\n", crcUtils.GetCRC(_test));
//
//
//        HashMap<String, Object> args = new HashMap<String, Object>();
//        args.put("loginName",loginName);
//        args.put("password",password);
//        System.out.printf("JSON:%s\r\n",new baseModel(args).toString());
//
//        try {
//            String accessKey = SDK.Auth(host,loginName,password);
//            System.out.println(accessKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
