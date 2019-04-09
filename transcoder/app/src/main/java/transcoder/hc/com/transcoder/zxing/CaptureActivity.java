package transcoder.hc.com.transcoder.zxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.ui.QRActivity;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class CaptureActivity extends Activity implements View.OnClickListener {
ImageButton bt_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        initView();
        initClick();
    }

    private void initClick() {
        bt_back.setOnClickListener(this);

    }

    private void initView() {
        bt_back = findViewById(R.id.bt_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.bt_back:
                Intent i = new Intent(this, QRActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
