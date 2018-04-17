package com.no1worker.retrofit.service;

import com.no1worker.retrofit.entity.UserInfo;
import com.no1worker.retrofit.response.MSIBase;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yuzhiyong on 2018/4/4.
 */

public interface MSIService {

    /**
     * 用户注册
     * @param phone  手机号
     * @param password  密码
     * @param username  用户名
     * @param email  邮箱
     * @param question  找回密码问题
     * @param answer  找回密码答案
     * @return
     */
    @POST("/user/register.do")
    @FormUrlEncoded
    Call<MSIBase<Void>> register(@Field("phone") String phone,
                                     @Field("password") String password,
                                     @Field("username") String username,
                                     @Field("email") String email,
                                     @Field("question") String question,
                                     @Field("answer") String answer);


    /**
     * 用户登录
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    @POST("/user/login.do")
    @FormUrlEncoded
    Call<MSIBase<String>> login(@Field("phone") String phone,
                                @Field("password") String password);

    /**
     * 获取用户信息
     * @param access_token
     * @return
     */
    @POST("/user/get_user_info.do")
    @FormUrlEncoded
    Call<MSIBase<UserInfo>> getUserInfo(@Field("access_token") String access_token);
}
