package com.no1worker.retrofit.service;

import com.no1worker.retrofit.response.MSIBase;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yuzhiyong on 2018/3/22.
 */

public interface TestService {

    @POST("URL")
    @FormUrlEncoded
    Call<MSIBase<String>> getTestMessage(@Field("testParam") String testParam);
}
