package transcoder.hc.com.transcoder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.base.BaseActivity;
import transcoder.hc.com.transcoder.zxing.activity.CaptureActivity;

/**
 * Created by ly on 2019/4/12.
 */

public class ErrorActivity extends BaseActivity implements View.OnClickListener {
    ImageView bt_back;
    Button button_again;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.failed_result);
        bt_back = findViewById(R.id.result_failed_back);
        button_again = findViewById(R.id.button_again1);
        bindevent();

    }

    private void bindevent() {
        button_again.setOnClickListener(this);
        bt_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.result_failed_back:
                startActivity(new Intent(ErrorActivity.this, CaptureActivity.class));
                finish();
                break;
            case  R.id.button_again1:
                startActivity(new Intent(ErrorActivity.this, CaptureActivity.class));
                finish();
                break;
        }
    }
}
