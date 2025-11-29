package com.huawei.location.vdr.data.ephemeris;

import com.google.gson.JsonSyntaxException;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes3.dex */
public class yn {
    private static long FB = 0;
    private static boolean Vw = false;
    private static long yn;
    private FB LW = new FB();

    private JSONArray E5(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphProvider", "getBdsNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private GalileoEphemeris FB(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        fb.getClass();
        GalileoTim galileoTimBuild = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0L)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        GalileoNav[] galileoNavArrVw = this.LW.Vw(jSONObject2.getJSONArray("ephList"));
        LogLocation.i("EphProvider", "galNavArray size = " + galileoNavArrVw.length);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(galileoNavArrVw).withGalileoTim(galileoTimBuild).build();
    }

    private GlonassEphemeris LW(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        fb.getClass();
        GlonassTim glonassTimBuild = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.15292150460684698E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        GlonassNav[] glonassNavArrFB = this.LW.FB(jSONObject2.getJSONArray("gloNavItemList"));
        LogLocation.i("EphProvider", "GlonassNav size = " + glonassNavArrFB.length);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(glonassNavArrFB).withGlonassTim(glonassTimBuild).build();
    }

    private Ephemeris Vw(EphemerisResponse ephemerisResponse) {
        String str;
        if (ephemerisResponse == null) {
            return null;
        }
        try {
            if (this.LW == null) {
                this.LW = new FB();
            }
            GpsEphemeris gpsEphemerisDC = dC(ephemerisResponse);
            BdsEphemeris bdsEphemerisYn = yn(ephemerisResponse);
            return Ephemeris.Builder.anEphemeris().withGpsEphemeris(gpsEphemerisDC).withBdsEphemeris(bdsEphemerisYn).withGalileoEphemeris(FB(ephemerisResponse)).withGlonassEphemeris(LW(ephemerisResponse)).build();
        } catch (JsonSyntaxException unused) {
            str = "json syntax error";
            LogLocation.e("EphProvider", str);
            return null;
        } catch (JSONException e) {
            str = "jsonException:" + e.getMessage();
            LogLocation.e("EphProvider", str);
            return null;
        }
    }

    private JSONArray d2(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphProvider", "getGalNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private GpsEphemeris dC(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        fb.getClass();
        GpsIon gpsIonBuild = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withB3(jSONObject.optInt("b3", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        GpsNav[] gpsNavArrLW = this.LW.LW(jSONObject2.getJSONArray("ephList"));
        LogLocation.i("EphProvider", "GpsNav size = " + gpsNavArrLW.length);
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(gpsNavArrLW).withGpsIon(gpsIonBuild).build();
    }

    private JSONArray ut(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphProvider", "getGpsNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private BdsEphemeris yn(EphemerisResponse ephemerisResponse) throws JSONException {
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getBdsNav());
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getBdsIon());
        JSONObject jSONObject3 = new JSONObject(ephemerisResponse.getBdsTim());
        BdsNav[] bdsNavArrYn = this.LW.yn(jSONObject.getJSONArray("ephList"));
        FB fb = this.LW;
        JSONArray jSONArray = jSONObject2.getJSONArray("ionList");
        fb.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            arrayList.add(BdsIon.Builder.aBdsIon().withA0(jSONObjectOptJSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.073741824E9d).withA1(jSONObjectOptJSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.34217728E8d).withA2(jSONObjectOptJSONObject.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withA3(jSONObjectOptJSONObject.optDouble("a3", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withB0(jSONObjectOptJSONObject.optInt("b0", 0) * 2048).withB1(jSONObjectOptJSONObject.optInt("b1", 0) * 16384).withB2(jSONObjectOptJSONObject.optInt("b2", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withB3(jSONObjectOptJSONObject.optInt("b3", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 8).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).build());
        }
        BdsIon[] bdsIonArr = new BdsIon[arrayList.size()];
        arrayList.toArray(bdsIonArr);
        FB fb2 = this.LW;
        JSONArray jSONArray2 = jSONObject3.getJSONArray("timList");
        fb2.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i2);
            arrayList2.add(BdsTim.Builder.aBdsTim().withA0(jSONObjectOptJSONObject2.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 3.4359738368E10d).withA1(jSONObjectOptJSONObject2.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 2.251799813685248E15d).withA2((jSONObjectOptJSONObject2.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.15292150460684698E18d) / 256.0d).withDeltaT(jSONObjectOptJSONObject2.optInt("deltaT", 0)).withGnssToId(jSONObjectOptJSONObject2.optInt("gnssToId", 0)).withWeekNumber(jSONObjectOptJSONObject2.optInt("weekNumber", 0)).withWeekSecond(jSONObjectOptJSONObject2.optInt("weekSecond", 0) * 16).build());
        }
        BdsTim[] bdsTimArr = new BdsTim[arrayList2.size()];
        arrayList2.toArray(bdsTimArr);
        LogLocation.i("EphProvider", "BdsNav size = " + bdsNavArrYn.length);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(jSONObject.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(bdsNavArrYn).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }

    private JSONArray zp(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e) {
            LogLocation.e("EphProvider", "getGloNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    public long FB() {
        if (yn <= 0) {
            yn = new PreferencesHelper("ephemeris_expire_time").getLong("ephemeris_expire_time");
        }
        LogLocation.i("EphProvider", "getExpireTime = " + yn);
        return yn;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris Vw() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.ephemeris.yn.Vw():com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris");
    }

    public Ephemeris yn() throws IOException {
        String string;
        Vw vw = new Vw(System.currentTimeMillis());
        long jVw = vw.Vw();
        LogLocation.i("EphProvider", "gpsTime = " + vw.Vw());
        if (jVw <= FB()) {
            LogLocation.i("EphProvider", "try to get local Ephemeris here");
            try {
                FileInputStream fileInputStreamOpenFileInput = ContextUtil.getContext().openFileInput("ephData");
                try {
                    if (fileInputStreamOpenFileInput.available() < 0 || fileInputStreamOpenFileInput.available() > 20971520) {
                        LogLocation.e("FileUtil", "FileInputStream length is illegal");
                        string = null;
                    } else {
                        byte[] bArr = new byte[1024];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i = fileInputStreamOpenFileInput.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                        }
                        string = sb.toString();
                    }
                    fileInputStreamOpenFileInput.close();
                } finally {
                }
            } catch (IOException unused) {
                LogLocation.e("FileUtil", "read from file failed");
                string = null;
            }
            if (string == null) {
                LogLocation.i("EphProvider", "read Ephemeris From Json is null");
                return null;
            }
            LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
            String[] strArrSplit = string.split("\n");
            StringBuffer stringBuffer = new StringBuffer();
            if (strArrSplit.length == 1) {
                stringBuffer.append(locationSecurityManager.decrypt(string, "LOCATION_LITE_SDK"));
            } else {
                for (String str : strArrSplit) {
                    stringBuffer.append(locationSecurityManager.decrypt(str, "LOCATION_LITE_SDK"));
                }
            }
            try {
                return Vw((EphemerisResponse) GsonUtil.getInstance().fromJson(stringBuffer.toString().trim(), EphemerisResponse.class));
            } catch (JsonSyntaxException unused2) {
                LogLocation.e("EphProvider", "json syntax error");
                return null;
            }
        }
        return Vw();
    }
}
