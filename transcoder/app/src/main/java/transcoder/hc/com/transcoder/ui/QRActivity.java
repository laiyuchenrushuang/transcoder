package transcoder.hc.com.transcoder.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.base.BaseActivity;
import transcoder.hc.com.transcoder.zxing.activity.CaptureActivity;

public class QRActivity extends BaseActivity implements View.OnClickListener {
ImageView bt_capture;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode_main);
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
        switch (v.getId()){
            case R.id.bt_capture:
                Drawable bgDrawable =getDrawable(R.mipmap.button_clicked);
                bt_capture.setBackground(bgDrawable);
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
