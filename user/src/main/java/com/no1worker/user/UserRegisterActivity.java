package com.no1worker.user;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.no1worker.base.config.UrlConfig;
import com.no1worker.base.view.CommonActivity;

/**
 * Created by admin on 2018/4/17.
 */
@Route(path = UrlConfig.USER_REG_ACTIVITY)
public class UserRegisterActivity extends CommonActivity {

    @Override
    public void findView() {
        setContentView(R.layout.user_activity_reg);
    }

    @Override
    public void initView() {

    }

}
