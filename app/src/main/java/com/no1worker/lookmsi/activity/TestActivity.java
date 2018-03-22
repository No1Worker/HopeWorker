package com.no1worker.lookmsi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.no1worker.retrofit.callback.MSICallback;
import com.no1worker.retrofit.common.RetrofitManager;
import com.no1worker.retrofit.response.MSIBase;

import retrofit2.Call;

/**
 * Created by yuzhiyong on 2018/3/22.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RetrofitManager.createTestService().getTestMessage("test").enqueue(new MSICallback<String>() {
            @Override
            public void onSuccess(MSIBase<String> msiBaseInfo) {
                // TODO: 2018/3/22 成功操作 
            }

            @Override
            public void onFailure(MSIBase<String> msiBaseInfo) {
                // TODO: 2018/3/22 失败操作
            }

        });
    }
}
