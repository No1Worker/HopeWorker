package com.no1worker.lookmsi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.no1worker.retrofit.callback.MSICallback;
import com.no1worker.retrofit.common.RetrofitManager;
import com.no1worker.retrofit.response.MSIBase;
import com.no1worker.retrofit.service.MSIService;
import com.no1worker.retrofit.service.TestService;

import retrofit2.Call;

/**
 * Created by yuzhiyong on 2018/3/22.
 */

public class TestActivity extends Activity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RetrofitManager.createService(TestService.class).getTestMessage("test").enqueue(new MSICallback<String>() {
            @Override
            public void onSuccess(MSIBase<String> msiBaseInfo) {
                // TODO: 2018/3/22 成功操作 
            }

            @Override
            public void onFailure(MSIBase<String> msiBaseInfo) {
                // TODO: 2018/3/22 失败操作
            }

        });

        RetrofitManager.createService(MSIService.class).login("18888888888","123456").enqueue(new MSICallback<String>() {
            @Override
            public void onSuccess(MSIBase<String> msiBaseInfo) {

            }

            @Override
            public void onFailure(MSIBase<String> msiBaseInfo) {

            }
        });
    }
}
