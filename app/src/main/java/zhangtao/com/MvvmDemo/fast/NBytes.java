package zhangtao.com.MvvmDemo.fast;

import java.util.Arrays;

public class NBytes {
    public static byte[] Slice(byte[] in,int start,int end){
        return Arrays.copyOfRange(in, start, end);
    }
}
