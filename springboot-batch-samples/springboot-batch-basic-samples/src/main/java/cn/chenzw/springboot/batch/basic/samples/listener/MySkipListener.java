package cn.chenzw.springboot.batch.basic.samples.listener;

import org.springframework.batch.core.SkipListener;


public class MySkipListener implements SkipListener {

    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println("skip读的时候发生错误:" + throwable.getMessage());
    }

    @Override
    public void onSkipInWrite(Object o, Throwable throwable) {
        System.out.println("skip写的时候发生错误:" + o);
    }

    @Override
    public void onSkipInProcess(Object o, Throwable throwable) {
        System.out.println("skip处理的时候发生错误:" + o);
    }
}
