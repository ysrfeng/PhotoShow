package cn.bingoogolapple.photopicker.demo;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/7/11 上午10:23
 * 描述:
 */
public class App extends Application {
    /**
     * 当前的context对象
     */
    public static App context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            Log.d("App", "In LeakCanary Analyzer Process");
            return;
        }
        LeakCanary.install(this);
    }

    public static App getContext() {
        return context;
    }

}