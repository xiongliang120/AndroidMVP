package chongchong.wei.rx_retrofit_mvp.login;


import android.util.Log;

import chongchong.wei.rx_retrofit_mvp.ICallBack;
import chongchong.wei.rx_retrofit_mvp.base.BasePresenter;

/**
 * 包名：chongchong.wei.rx_retrofit_mvp.login
 * 创建人：apple
 * 创建时间：2019-12-11 13:33
 * 描述：
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.IView, RegisterModel> implements RegisterContract.IPresenter {

    @Override
    public void onClickRegister(String username, String pwd) {
        mView.showProgress(true);
        mModel.getUserInfo(username, pwd, new ICallBack<String>() {
            @Override
            public void success(String data) {
                if (mView != null) {
                    mView.showToast("注册成功");
                    Log.i("xiongliang","注册成功");
                    mView.showProgress(false);
                    mView.goToLoginActivity();
                }
            }

            @Override
            public void error(String error) {
                if (mView != null) {
                    mView.showProgress(false);
                    mView.showToast("注册失败");
                    Log.i("xiongliang","注册失败");
                }
            }
        });
    }
}
