package transcoder.hc.com.transcoder.ui;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.zxing.CaptureActivity;

public class QRActivity extends AppCompatActivity implements View.OnClickListener {
ImageView bt_capture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
