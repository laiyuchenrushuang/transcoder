package transcoder.hc.com.transcoder.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by ly on 2019/4/11.
 */

public class AppUtils {
    public static boolean REQUESTING = true;
    public static int RESULT_OK = 0xA1;
    public static int CEMERA_OK =   1;

    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";
    public static final String INTENT_EXTRA_KEY_QR_SCAN_MIN = "qr_min_result";

    public static String getMinCodeString(String gsonResult) {
        JsonParser parser = new JsonParser();
        //String decodeString = decodeUnicode(codeResult);
        JsonObject object=(JsonObject) parser.parse(gsonResult);
        JsonObject result = object.getAsJsonObject();
        HashMap<String,String> codehs = new LinkedHashMap<>();

        try {
            codehs.put("产品合格证证书编号",result.get("产品合格证证书编号").getAsString());
            codehs.put("CCC证书编号",result.get("CCC证书编号").getAsString());
            codehs.put("整车编码",result.get("整车编码").getAsString());
            codehs.put("制造商",result.get("制造商").getAsString());
            codehs.put("生产厂",result.get("生产厂").getAsString());
            codehs.put("车辆中文商标",result.get("车辆中文商标").getAsString());
            codehs.put("车辆英文商标",result.get("车辆英文商标").getAsString());
            codehs.put("产品型号",result.get("产品型号").getAsString());
            codehs.put("电动机编码",result.get("电动机编码").getAsString());
            codehs.put("长×宽×高(mm×mm×mm)",result.get("长×宽×高(mm×mm×mm)").getAsString());
            codehs.put("前后轮中心距（mm）",result.get("前后轮中心距（mm）").getAsString());
            codehs.put("装配完整的电动自行车的整车质量(kg)",result.get("装配完整的电动自行车的整车质量(kg)").getAsString());
            codehs.put("车身颜色",result.get("车身颜色").getAsString());
            codehs.put("制造日期",result.get("制造日期").getAsString());
            codehs.put("CCC证书发证日期",result.get("CCC证书发证日期").getAsString());
        } catch (Exception e) {
           return null;
        }
        JSONObject jsonObj = new JSONObject(codehs);
        return jsonObj.toString();
    }

    public static void setQuest(boolean quest) {
        REQUESTING = quest;
    }
}
