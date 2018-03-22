package com.no1worker.retrofit.common;

import com.no1worker.retrofit.service.TestService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuzhiyong on 2018/3/22.
 */

public class RetrofitManager {

    private static Map<Class<?>, Object> serviceCache = new ConcurrentHashMap<Class<?>, Object>();


    public static TestService createTestService(){
        TestService testService = (TestService) serviceCache.get(TestService.class);
        if(testService == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(getHeadersLogInterceptor())
                    .addInterceptor(getBodyLogInterceptor())
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            testService = retrofit.create(TestService.class);
            serviceCache.put(TestService.class,testService);
        }
        return testService;
    }

    private static HttpLoggingInterceptor getBodyLogInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }
    private static HttpLoggingInterceptor getHeadersLogInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return logging;
    }

    public static void clearServiceCache(){
        serviceCache.clear();
    }

}
