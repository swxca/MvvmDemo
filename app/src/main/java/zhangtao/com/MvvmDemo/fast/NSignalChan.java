package zhangtao.com.MvvmDemo.fast;

import java.util.concurrent.Semaphore;

public class NSignalChan {
    public static NSignalChan New(){
        NSignalChan chan = new NSignalChan();
        chan.semaphore = new Semaphore(0,false);
        return chan;
    }

    private Semaphore semaphore;

    public void send(){
        semaphore.release();
    }
    public void recv(){
        semaphore.acquireUninterruptibly();
    }
}
