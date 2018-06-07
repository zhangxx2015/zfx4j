package com.zfx.forj;

import org.apache.commons.codec.binary.Base64;

import java.math.BigInteger;

/**
 * Created by zhangxx on 2018-05-22.
 */
public class jobNumber {
    /*
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
    * */
    public static String gen(){
        String unqiuId="";
        do{
            String guid=java.util.UUID.randomUUID().toString().replace("-","");
            //System.out.println(guid);
            byte[] byteGuid=new byte[guid.length()/2];
            Integer idxGuid=0;
            while(guid.length()>0) {
                String hex = guid.substring(0, 2);
                //System.out.printf("hex:%s\r\n",hex);
                guid=guid.substring(2);
                Integer val = Integer.parseInt(hex,16);
                //System.out.printf("%d\r\n",  val);
                //byteGuid[idxGuid++]=intToByteArray(val)[3];
                byteGuid[byteGuid.length- idxGuid-1]= byteUtils.intToByteArray(val)[3];
                idxGuid++;
            }
            //for(int i=0;i<byteGuid.length;i++){
            //    System.out.printf("%x\r\n",byteGuid[i]);
            //}

            //-1134364059842919845
            //F041EDE5CF17C25B

            /*
            Long lval=new BigInteger(byteGuid).longValue();
            BigInteger bi = new BigInteger(lval.toString());
            byte[] bytes = bi.toByteArray();
            byte[] littleEndian=new byte[]{bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]};

            System.out.printf("%x-%x-%x-%x-%x-%x-%x-%x\r\n",bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]);
            //System.out.printf("base64:%s\r\n", base64.encode(new byte[]{bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]}));
            byte[] result = Base64.encodeBase64(littleEndian);
            // W8IXz+XtQfA
            String unqiuId=new String(result);
            System.out.println(unqiuId);
            */
            Long val=new BigInteger(byteGuid).longValue();
            byte[] bytes = new BigInteger(val.toString()).toByteArray();
            if(bytes.length<8)continue;
            unqiuId=new String( Base64.encodeBase64(new byte[]{bytes[7],bytes[6],bytes[5],bytes[4],bytes[3],bytes[2],bytes[1],bytes[0]}));
            if(unqiuId.length()<12)continue;
        }while(-1==unqiuId.indexOf("+")&&-1==unqiuId.indexOf("/")&&-1==unqiuId.indexOf("="));

        return unqiuId.substring(0,11);
    }
}
