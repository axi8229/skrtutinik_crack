package com.huawei.location.ephemeris;

import com.google.gson.JsonSyntaxException;
import com.huawei.location.ephemeris.net.EphemerisResponse;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.utils.FB;
import com.huawei.riemann.location.bean.eph.BdsEphemeris;
import com.huawei.riemann.location.bean.eph.BdsIon;
import com.huawei.riemann.location.bean.eph.BdsNav;
import com.huawei.riemann.location.bean.eph.BdsTim;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.eph.GalileoEphemeris;
import com.huawei.riemann.location.bean.eph.GalileoNav;
import com.huawei.riemann.location.bean.eph.GalileoTim;
import com.huawei.riemann.location.bean.eph.GlonassEphemeris;
import com.huawei.riemann.location.bean.eph.GlonassNav;
import com.huawei.riemann.location.bean.eph.GlonassTim;
import com.huawei.riemann.location.bean.eph.GpsEphemeris;
import com.huawei.riemann.location.bean.eph.GpsIon;
import com.huawei.riemann.location.bean.eph.GpsNav;
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
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphModule", "getGalNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private GlonassEphemeris FB(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        fb.getClass();
        GlonassTim glonassTimBuild = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.15292150460684698E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        GlonassNav[] glonassNavArrFB = this.LW.FB(jSONObject2.getJSONArray("gloNavItemList"));
        LogLocation.i("EphModule", "GlonassNav size = " + glonassNavArrFB.length);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(glonassNavArrFB).withGlonassTim(glonassTimBuild).build();
    }

    private GpsEphemeris LW(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        fb.getClass();
        GpsIon gpsIonBuild = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", ConfigValue.DOUBLE_DEFAULT_VALUE) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withB3(jSONObject.optInt("b3", 0) * pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        GpsNav[] gpsNavArrLW = this.LW.LW(jSONObject2.getJSONArray("ephList"));
        LogLocation.i("EphModule", "GpsNav size = " + gpsNavArrLW.length);
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(gpsNavArrLW).withGpsIon(gpsIonBuild).build();
    }

    private GalileoEphemeris Vw(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        fb.getClass();
        GalileoTim galileoTimBuild = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", ConfigValue.DOUBLE_DEFAULT_VALUE) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", ConfigValue.DOUBLE_DEFAULT_VALUE) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0L)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        GalileoNav[] galileoNavArrVw = this.LW.Vw(jSONObject2.getJSONArray("ephList"));
        LogLocation.i("EphModule", "galNavArray size = " + galileoNavArrVw.length);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(galileoNavArrVw).withGalileoTim(galileoTimBuild).build();
    }

    private JSONArray d2(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e) {
            LogLocation.e("EphModule", "getGloNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private JSONArray dC(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphModule", "getBdsNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    private JSONArray zp(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e) {
            LogLocation.e("EphModule", "getGpsNavs JSONException:" + e.getMessage());
            return new JSONArray();
        }
    }

    public long FB() {
        if (yn <= 0) {
            yn = new PreferencesHelper("ephemeris_expire_time").getLong("ephemeris_expire_time");
        }
        LogLocation.i("EphModule", "getExpireTime = " + yn);
        return yn;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean yn() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.ephemeris.yn.yn():boolean");
    }

    public Ephemeris Vw() {
        String string;
        String str = "json syntax error";
        try {
            FileInputStream fileInputStreamOpenFileInput = ContextUtil.getContext().openFileInput("ephData");
            try {
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
                fileInputStreamOpenFileInput.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtil", "read from file failed");
            string = null;
        }
        if (string == null) {
            LogLocation.i("EphModule", "read Ephemeris From Json is null");
            return null;
        }
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        String[] strArrSplit = string.split("\n");
        StringBuffer stringBuffer = new StringBuffer();
        if (strArrSplit.length == 1) {
            stringBuffer.append(locationSecurityManager.decrypt(string, "LOCATION_LITE_SDK"));
        } else {
            for (String str2 : strArrSplit) {
                stringBuffer.append(locationSecurityManager.decrypt(str2, "LOCATION_LITE_SDK"));
            }
        }
        try {
            EphemerisResponse ephemerisResponse = (EphemerisResponse) GsonUtil.getInstance().fromJson(stringBuffer.toString().trim(), EphemerisResponse.class);
            if (ephemerisResponse == null) {
                return null;
            }
            try {
                if (this.LW == null) {
                    this.LW = new FB();
                }
                GpsEphemeris gpsEphemerisLW = LW(ephemerisResponse);
                return Ephemeris.Builder.anEphemeris().withGpsEphemeris(gpsEphemerisLW).withBdsEphemeris(yn(ephemerisResponse)).withGalileoEphemeris(Vw(ephemerisResponse)).withGlonassEphemeris(FB(ephemerisResponse)).build();
            } catch (JsonSyntaxException unused2) {
                LogLocation.e("EphModule", str);
                return null;
            } catch (JSONException e) {
                str = "jsonException:" + e.getMessage();
                LogLocation.e("EphModule", str);
                return null;
            }
        } catch (JsonSyntaxException unused3) {
            LogLocation.e("EphModule", "json syntax error");
            return null;
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
        LogLocation.i("EphModule", "BdsNav size = " + bdsNavArrYn.length);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(jSONObject.optInt("satNumber", 0)).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(bdsNavArrYn).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }
}
