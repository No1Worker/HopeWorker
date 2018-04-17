package com.no1worker.base.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

/**
 * Created by yuzhiyong on 2018/3/26.
 */
public abstract class CommonActivity extends AppCompatActivity {

    public Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        /**
         * activity被回收之后，下次启动时清除上次保存的fragment。
         */
        if (savedInstanceState != null) {
            savedInstanceState.putParcelable("android:support:fragments", null);
        }
        registerEventBus();
        findView();
        ButterKnife.bind(this);
        beforeInit();
        initView();
        afterInit();
        bindListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterEventBus();
    }

    public abstract void findView();

    public abstract void initView();

    public void bindListener() {
    }

    /**
     * 在initView之前进行一点操作，可不重写
     */
    public void beforeInit() {
    }

    /**
     * 在initView之后进行一点操作，可不重写
     */
    public void afterInit() {
    }

    /**
     * 注册EventBus
     */
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    /**
     * 反注册EventBus
     */
    private void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(Event event) {

    }

    /**
     * 隐藏键盘
     */
    protected void hideSoftInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    protected void showSoftInputMethod(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        // 接受软键盘输入的编辑文本或其它视图
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }
}
