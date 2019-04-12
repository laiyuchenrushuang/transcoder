package transcoder.hc.com.transcoder.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ly on 2019/4/9.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected void showToast(String toastString) {
        Toast.makeText(this,toastString,Toast.LENGTH_SHORT).show();
    }
}
