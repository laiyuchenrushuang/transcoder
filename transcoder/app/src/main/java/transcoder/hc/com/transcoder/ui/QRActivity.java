package transcoder.hc.com.transcoder.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.base.BaseActivity;
import transcoder.hc.com.transcoder.utils.AppUtils;
import transcoder.hc.com.transcoder.zxing.activity.CaptureActivity;

public class QRActivity extends BaseActivity implements View.OnClickListener {
    ImageView bt_capture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode_main);
        requestPermision();
        initView();
        initClick();
    }

    private void initClick() {
        bt_capture.setOnClickListener(this);
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        bt_capture = findViewById(R.id.bt_capture);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_capture:
                //Drawable bgDrawable = getApplication().getDrawable(R.mipmap.button_clicked);
                //bt_capture.setBackground(bgDrawable);
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, CaptureActivity.class);
                    startActivity(intent);
                } else {
                    showToast("相机权限没打开，请打开使用相机权限");
                    requestPermision();
                }
                break;
        }
    }

    private void requestPermision() {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请权限，CEMERA_OK是自定义的常量
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    AppUtils.CEMERA_OK);
        }
    }
}
