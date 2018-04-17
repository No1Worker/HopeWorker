package com.no1worker.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public abstract class CommonFragment extends Fragment {
    //缓存视图
    private View viewContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewContent == null) {
            viewContent = inflater.inflate(getContentView(), container, false);
            initContentView(viewContent);
            initData();
        }
        //判断Fragment 对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null) {
            //如果存在，销毁，重新添加。这样就能缓存视图
            parent.removeView(viewContent);
        }
        ButterKnife.bind(viewContent);
        return viewContent;
    }


    protected abstract int getContentView();

    public void initData(){

    }

    protected abstract void initContentView(View viewContent);

}
