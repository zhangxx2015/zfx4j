package com.zfx.forj;

/**
 * Created by zhangxx on 2018-05-22.
 */
public class byteUtils {
    /**
     * int到byte[]
     * @param i
     * @return
     */
    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }
    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value=0;
        //由高位到低位
        for(int i = 0; i < 4; i++) {
            int shift= (4-1-i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;//往高位游
        }
        return value;
    }



    public static String ToByteString(long countBytes) {
        return ToByteString(1d * countBytes);
    }
    public static String ToByteString(int countBytes) {
        return ToByteString(1d * countBytes);
    }
    public static String ToByteString(float countBytes) {
        return ToByteString(1d * countBytes);
    }

//    private final static double EB = 0x1000000000000000;
//    private final static double PB = 0x4000000000000;
//    private final static double TB = 0x10000000000;
    private final static double GB = 0x40000000;
    private final static double MB = 0x100000;
    private final static double KB = 0x400;
    public static String ToByteString(double countBytes) {
//        if (countBytes >= EB)
//            return string.Format("{0:f2} EB", countBytes / EB);
//        if (countBytes >= PB)
//            return string.Format("{0:f2} PB", countBytes / PB);
//        if (countBytes >= TB)
//            return string.Format("{0:f2} TB", countBytes / TB);
        if (countBytes >= GB)
            return stringUtils.string_Format("{0:f2} GB", countBytes / GB);

        if (countBytes >= MB)
            return stringUtils.string_Format("{0:f2} MB", countBytes / MB);
        if (countBytes >= KB)
            return stringUtils.string_Format("{0:f2} KB", countBytes / KB);
        return stringUtils.string_Format("{0:f2} Byte", countBytes);
    }
}
