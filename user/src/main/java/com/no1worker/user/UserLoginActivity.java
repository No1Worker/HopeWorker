package com.no1worker.user;

import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.no1worker.base.config.UrlConfig;
import com.no1worker.base.view.CommonActivity;

import butterknife.OnClick;

@Route(path = UrlConfig.USER_LOGIN_ACTIVITY)
public class UserLoginActivity extends CommonActivity {

    @Override
    public void findView() {
        setContentView(R.layout.user_activity_login);
    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.user_login_to_reg)
    public void toRegClick(TextView v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptionsCompat compat = ActivityOptionsCompat
                    .makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
            ARouter.getInstance().build(UrlConfig.USER_REG_ACTIVITY)
                    .withOptionsCompat(compat)
                    .navigation();
        }else{
            ARouter.getInstance()
                    .build(UrlConfig.USER_REG_ACTIVITY)
                    .withTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    .navigation();
        }

    }
}
