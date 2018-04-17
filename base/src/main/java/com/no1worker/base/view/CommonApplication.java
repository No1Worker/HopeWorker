package com.no1worker.base.view;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.no1worker.base.BuildConfig;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class CommonApplication extends Application{

    private static CommonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (BuildConfig.DEBUG) {
            // 打印日志,默认关闭
            ARouter.openLog();
            // 开启调试模式，默认关闭(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace();
        }

        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);

    }
}
