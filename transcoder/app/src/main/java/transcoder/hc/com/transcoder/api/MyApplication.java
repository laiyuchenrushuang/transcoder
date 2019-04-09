package transcoder.hc.com.transcoder.api;

import android.app.Application;
import android.content.Context;

/**
 * Created by ly on 2019/4/9.
 */

public class MyApplication extends Application {
    public static Context context;
    private static MyApplication mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static MyApplication getInstance() {
        if (mInstance == null) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }
}
