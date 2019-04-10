package transcoder.hc.com.transcoder.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.base.BaseActivity;

/**
 * Created by ly on 2019/4/10.
 */

public class CertificateActivity extends BaseActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qc_certifi_result);
    }
}
