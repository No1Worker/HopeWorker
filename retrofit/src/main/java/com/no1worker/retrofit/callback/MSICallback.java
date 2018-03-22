package com.no1worker.retrofit.callback;

import com.no1worker.retrofit.response.MSIBase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yuzhiyong on 2018/3/22.
 */
public abstract class MSICallback<T> implements Callback<MSIBase<T>> {

    @Override
    public void onResponse(Call<MSIBase<T>> call, Response<MSIBase<T>> response) {
        if (response.isSuccessful()) {// Returns true if code() is in the range [200..300).
            /**
             * 注意，这里的成功表示请求成功了，即消息已经和服务器端进行了交互，并且服务器给与了所需要的返回值。
             */
            if (response.body() != null) {
                // TODO: 2018/3/22 后续与后端指定规则之后进行成功与失败操作
            }
        } else {
            // 与后端通信异常
        }
        onFinish();
    }

    @Override
    public void onFailure(Call<MSIBase<T>> call, Throwable t) {}

    public void handleError(MSIBase<T> msiBaseInfo) {
        onFailure(msiBaseInfo);
    }

    /**
     * 如果 Http响应码为200，且LogibeatBase中suc为true，则回调此方法
     * 
     * @param msiBaseInfo 为了更好兼容之前的网络请求
     */
    public abstract void onSuccess(MSIBase<T> msiBaseInfo);

    /**
     * 如果 Http响应吗非200，或LogibeatBase中suc为false，或JSON转对象发生异常，则回调此方法
     * 
     * @param msiBaseInfo
     */
    public abstract void onFailure(MSIBase<T> msiBaseInfo);

    /**
     * onSuccess 与 onFailure 方法结束之后都用调用此方法
     */
    public void onFinish() {}
}
