package demo.liaoli.retrofit.com.retrofitdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2017/12/10.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
