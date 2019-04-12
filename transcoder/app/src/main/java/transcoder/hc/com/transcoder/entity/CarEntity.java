package transcoder.hc.com.transcoder.entity;

/**
 * Created by ly on 2019/4/11.
 */

public class CarEntity {

    //产品合格证编号
    private String cphgzbh;
    //ccc证书编号
    private String ccczsbh;
    //ccc证书状态
    private String ccczszt;
    //ccc证书有效期止日期
    private String cccyxrq;
    //车辆制造商
    private String zlzzs;
    //长
    private String length;
    //宽
    private String width;
    //高
    private String height;
    //续航里程
    private String xhlc;
    //整车质量
    private String zczl;
    //最高设计时速
    private String zgsjss;
    //车架上整车编码的位置
    private String cjbmwz;
    //铭牌固定位置
    private String mpwz;
    //车身颜色
    private String csys;
    //制造日期
    private String zzrq;
    // 车辆外形简图
    private String zlwxtt;


    public String getCphgzbh() {
        return cphgzbh;
    }

    public void setCphgzbh(String cphgzbh) {
        this.cphgzbh = cphgzbh;
    }

    public String getCcczsbh() {
        return ccczsbh;
    }

    public void setCcczsbh(String ccczsbh) {
        this.ccczsbh = ccczsbh;
    }

    public String getCcczszt() {
        return ccczszt;
    }

    public void setCcczszt(String ccczszt) {
        this.ccczszt = ccczszt;
    }

    public String getCccyxrq() {
        return cccyxrq;
    }

    public void setCccyxrq(String cccyxrq) {
        this.cccyxrq = cccyxrq;
    }

    public String getZlzzs() {
        return zlzzs;
    }

    public void setZlzzs(String zlzzs) {
        this.zlzzs = zlzzs;
    }

    public String getChang() {
        return length;
    }

    public void setChang(String chang) {
        this.length = chang;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getXhlc() {
        return xhlc;
    }

    public void setXhlc(String xhlc) {
        this.xhlc = xhlc;
    }

    public String getZczl() {
        return zczl;
    }

    public void setZczl(String zczl) {
        this.zczl = zczl;
    }

    public String getZgsjss() {
        return zgsjss;
    }

    public void setZgsjss(String zgsjss) {
        this.zgsjss = zgsjss;
    }

    public String getCjbmwz() {
        return cjbmwz;
    }

    public void setCjbmwz(String cjbmwz) {
        this.cjbmwz = cjbmwz;
    }

    public String getMpwz() {
        return mpwz;
    }

    public void setMpwz(String mpwz) {
        this.mpwz = mpwz;
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys;
    }

    public String getZzrq() {
        return zzrq;
    }

    public void setZzrq(String zzrq) {
        this.zzrq = zzrq;
    }

    public String getZlwxtt() {
        return zlwxtt;
    }

    public void setZlwxtt(String zlwxtt) {
        this.zlwxtt = zlwxtt;
    }

    @Override
    public String toString() {
        return "产品合格证编号 :" + cphgzbh +
                "ccc证书编号 :" + ccczsbh +
                "ccc证书状态 :" + ccczszt +
                "ccc证书有效期止日期 :" + cccyxrq +
                "车辆制造商 :" + zlzzs +
                "长 :" + length +
                "宽 :" + width +
                "高 :" + height +
                "续航里程 :" + xhlc +
                "整车质量 :" + zczl +
                "最高设计时速 :" + zgsjss +
                "车架上整车编码的位置 :" + cjbmwz +
                "铭牌固定位置 :" + mpwz +
                "车身颜色 :" + csys +
                "制造日期 :" + zzrq +
                "车辆外形简图 :" + zlwxtt
                ;
    }
}
