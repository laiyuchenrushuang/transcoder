package transcoder.hc.com.transcoder.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.zxing.WriterException;

import java.net.HttpCookie;

import transcoder.hc.com.transcoder.R;
import transcoder.hc.com.transcoder.base.BaseActivity;
import transcoder.hc.com.transcoder.utils.AppUtils;
import transcoder.hc.com.transcoder.zxing.activity.CaptureActivity;
import transcoder.hc.com.transcoder.zxing.encoding.EncodingHandler;

/**
 * Created by ly on 2019/4/10.
 */

public class CertificateActivity extends BaseActivity implements View.OnClickListener {
    private  ImageView mBt_back;
    private ImageView codePicture;

    //产品合格证编号
    private TextView cphgzbh;
    //ccc证书编号
    private TextView ccczsbh;
    //CCC证书版本号
    private TextView ccczszt;
    //CCC证书发证日期
    private TextView cccyxrq;
    //车辆制造商
    private TextView zlzzs;
    //长
    private TextView length;
    //宽
//    private TextView width;
//    //高
//    private TextView height;
    //续行里程（km）
    private TextView xhlc;
    //整车质量
    private TextView zczl;
    //最高设计时速
    private TextView zgsjss;
    //车架上整车编码的位置
    private TextView cjbmwz;
    //铭牌固定位置
    private TextView mpwz;
    //车身颜色
    private TextView csys;
    //制造日期
    private TextView zzrq;
//    // 车辆外形简图
//    private ImageView zlwxtt;

    Intent intent;
    private String codeResult;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qc_certifi_result);
        intent = getIntent();
        Bundle bundle=intent.getExtras();//.getExtras()得到intent所附带的额外数据
        codeResult =bundle.getString("qr_scan_result");
        initView();
        bindEvent();
        if (codeResult != null) {
            codePicture.setImageBitmap(getNewCodeBitmap(codeResult));
            getJson(codeResult);
        }
    }

    private void getJson(String codeResult) {
        JsonParser  parser = new JsonParser();
        //String decodeString = decodeUnicode(codeResult);
        JsonObject object=(JsonObject) parser.parse(codeResult);
        JsonObject result = object.getAsJsonObject();

//        Log.d("llllllllll", "onResponse: "+result.size());
//        Log.d("llllllllll", "车辆颜色: "+result.get("车身颜色").getAsString());
        try {
            cphgzbh.setText(result.get("产品合格证证书编号").getAsString());
            ccczsbh.setText(result.get("CCC证书编号").getAsString());
            ccczszt.setText(result.get("CCC证书版本号").getAsString());
            cccyxrq.setText(result.get("CCC证书发证日期").getAsString());
            zlzzs.setText(result.get("车辆制造商").getAsString());
            length.setText(result.get("长×宽×高(mm×mm×mm)").getAsString());
            xhlc.setText(result.get("续行里程（km）").getAsString());
            zczl.setText(result.get("装配完整的电动自行车的整车质量(kg)").getAsString());
            zgsjss.setText(result.get("最高设计车速（km/h）").getAsString());
            cjbmwz.setText(result.get("车架上整车编码的位置").getAsString());
            mpwz.setText(result.get("铭牌固定位置").getAsString());
            csys.setText(result.get("车身颜色").getAsString());
            zzrq.setText(result.get("制造日期").getAsString());
        } catch (NullPointerException e) {
            showToast("数据格式异常，请检查与服务器的数据");
            e.printStackTrace();
        }
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());
//        cphgzbh.setText(result.get("车身颜色").getAsString());


//        for (int i = 0;i<result.size();i++) {
//        }
    }

    private void bindEvent() {
        mBt_back.setOnClickListener(this);
    }

    private void initView() {
        mBt_back = findViewById(R.id.result_toolbar_back);

        cphgzbh = findViewById(R.id.cphgbh);
        ccczsbh = findViewById(R.id.cccbh);
        ccczszt = findViewById(R.id.ccczt);
        cccyxrq = findViewById(R.id.cccyxrq);
        zlzzs = findViewById(R.id.clzzs);

        length = findViewById(R.id.chang);
//        width = findViewById(R.id.kuan);
//        height = findViewById(R.id.gao);
        xhlc = findViewById(R.id.xhlc);

        zczl = findViewById(R.id.zczl);
        zgsjss = findViewById(R.id.zgsjss);
        cjbmwz = findViewById(R.id.clbmwz);
        cphgzbh = findViewById(R.id.cphgbh);

        mpwz = findViewById(R.id.mpgdwz);
        zgsjss = findViewById(R.id.zgsjss);
        csys = findViewById(R.id.csys);
        zzrq = findViewById(R.id.zzrq);


//        zlwxtt = findViewById(R.id.car_picture);
        codePicture  = findViewById(R.id.code_picture);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.result_toolbar_back:
                startActivity(new Intent(this, CaptureActivity.class));
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("lylog", "onActivityResult: resultCode="+resultCode);
        if (resultCode == AppUtils.RESULT_OK) {
            Log.d("lylog", "onActivityResult: ");
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");
            Bitmap codeBitmap = getNewCodeBitmap(scanResult);
            if (codeBitmap != null) {
                codePicture.setImageBitmap(codeBitmap);
            }else {
                showToast("文本信息为空,二维码生成失败");
            }
        }

    }


    private Bitmap getNewCodeBitmap(String codeText) {

        try {

            return EncodingHandler.createQRCode(codeText, 500);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * http 请求数据返回 json 中中文字符为 unicode 编码转汉字转码
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
