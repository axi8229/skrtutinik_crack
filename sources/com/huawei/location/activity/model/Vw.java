package com.huawei.location.activity.model;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Vw {
    public static boolean FB(int i) {
        return i == 200 || i == 100 || i == 102 || i == 104 || i == 300 || i == 105 || i == 400;
    }

    public static byte[] FB(String str, String str2) {
        StringBuilder sb;
        String apiMsg;
        try {
            RequestJsonBody.Builder builder = new RequestJsonBody.Builder();
            return new HttpClientEx(ContextUtil.getContext(), new HttpClientBuilder().setNeedCheckUcsAuth(false)).newSubmit(new BaseRequest.Builder(str2).setBaseUrl(str).setHeads(new HeadBuilder(String.valueOf(UUID.randomUUID()))).setMethod("GET").setBody(builder.build()).build()).executeOriginal();
        } catch (OnErrorException e) {
            sb = new StringBuilder();
            sb.append("OnErrorException:code:");
            sb.append(e.getErrorCode().code);
            sb.append(",apiCode:");
            sb.append(e.getApiCode());
            sb.append(",apiMsg:");
            apiMsg = e.getApiMsg();
            sb.append(apiMsg);
            LogLocation.e("DownloadUtils", sb.toString());
            return new byte[0];
        } catch (OnFailureException e2) {
            sb = new StringBuilder();
            sb.append("OnFailureException:");
            sb.append(e2.getErrorCode().code);
            sb.append(",");
            apiMsg = e2.getErrorCode().msg;
            sb.append(apiMsg);
            LogLocation.e("DownloadUtils", sb.toString());
            return new byte[0];
        }
    }

    public static void LW(String str, String str2) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = ContextUtil.getContext().openFileOutput(str2, 0);
            try {
                fileOutputStreamOpenFileOutput.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtil", "save to file failed");
        }
    }

    public static DeviceInfo Vw() {
        DeviceInfo.Builder builderWithSdkLevel = DeviceInfo.Builder.aDeviceInfo().withChipName(com.huawei.location.vdr.util.yn.Vw(SystemPropertiesUtil.getProperty("ro.board.platform", ""))).withManufacturer(Build.MANUFACTURER).withSdkLevel(Build.VERSION.SDK_INT);
        LogLocation.i("VdrAlgoUtil", "DeviceInfo:" + GsonUtil.getInstance().toJson(builderWithSdkLevel));
        return builderWithSdkLevel.build();
    }

    public static String Vw(String str) {
        String string;
        StringBuilder sb;
        ErrorCode errorCode;
        try {
            RequestJsonBody.Builder builder = new RequestJsonBody.Builder();
            HeadBuilder headBuilder = new HeadBuilder(String.valueOf(UUID.randomUUID()));
            String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress("com.huawei.configserver");
            if (TextUtils.isEmpty(grsHostAddress)) {
                LogLocation.i("DownloadUtils", "Failed to obtain the domain name using GRS.");
                return null;
            }
            return new String(new HttpClientEx().newSubmit(new BaseRequest.Builder("/servicesupport/updateserver/data/com.huawei.higeo_dataModule_SDMConfigV2?cityId=" + str).setBaseUrl(grsHostAddress).setHeads(headBuilder).setMethod("GET").setBody(builder.build()).build()).executeOriginal(), "UTF-8");
        } catch (OnErrorException e) {
            string = "OnErrorException:code:" + e.getErrorCode().code + ",apiCode:" + e.getApiCode() + ",apiMsg:" + e.getApiMsg();
            LogLocation.e("DownloadUtils", string);
            return null;
        } catch (OnFailureException e2) {
            sb = new StringBuilder();
            sb.append("OnFailureException:");
            sb.append(e2.getErrorCode().code);
            sb.append(",");
            errorCode = e2.getErrorCode();
            sb.append(errorCode.msg);
            string = sb.toString();
            LogLocation.e("DownloadUtils", string);
            return null;
        } catch (IOException e3) {
            if (!(e3 instanceof AuthException)) {
                string = "IOException:" + ErrorCode.valueOf(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED) + "," + ErrorCode.valueOfKey(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED);
                LogLocation.e("DownloadUtils", string);
                return null;
            }
            AuthException authException = (AuthException) e3;
            sb = new StringBuilder();
            sb.append("IOException:");
            sb.append(authException.getErrorCode().code);
            sb.append(",");
            errorCode = authException.getErrorCode();
            sb.append(errorCode.msg);
            string = sb.toString();
            LogLocation.e("DownloadUtils", string);
            return null;
        }
    }

    public static boolean Vw(int i) {
        return i == 0;
    }

    public static boolean Vw(Context context, String str, String str2) {
        File file = new File(str2);
        String str3 = context.getDir("libs", 0).getAbsolutePath() + File.separator + str;
        try {
            Log.d("SdmLocationLite", "ret=" + Vw(file.getCanonicalPath(), new File(str3).getCanonicalPath()));
            System.load(str3);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean Vw(String str, String str2) throws IOException {
        String str3;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                                byteArrayOutputStream.close();
                                fileOutputStream.close();
                                fileInputStream.close();
                                return true;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused) {
            str3 = "FileNotFoundException";
            Log.e("SdmLocationLite", str3);
            return false;
        } catch (IOException unused2) {
            str3 = "IOException";
            Log.e("SdmLocationLite", str3);
            return false;
        }
    }

    public static void dC(String str, String str2) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = ContextUtil.getContext().openFileOutput(str2, 0);
            try {
                fileOutputStreamOpenFileOutput.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtil", "save to file failed");
        }
    }

    public static long yn(double d, double d2, int i) {
        long j = (-9223372036854775808) >>> (i > 29 ? 59 : (i * 2) + 1);
        double d3 = -90.0d;
        double d4 = 90.0d;
        double d5 = -180.0d;
        double d6 = 180.0d;
        long j2 = 0;
        boolean z = true;
        for (long j3 = Long.MIN_VALUE; j3 != j; j3 >>>= 1) {
            if (z) {
                double d7 = (d5 + d6) / 2.0d;
                if (d >= d7) {
                    j2 |= j3;
                    d5 = d7;
                } else {
                    d6 = d7;
                }
            } else {
                double d8 = (d3 + d4) / 2.0d;
                if (d2 >= d8) {
                    j2 |= j3;
                    d3 = d8;
                } else {
                    d4 = d8;
                }
            }
            z = !z;
        }
        return (i << 59) | (j2 >>> 5);
    }

    public static String yn(int i) {
        if (Vw(i)) {
            return "Success";
        }
        if (i == -1) {
            return "INVALID";
        }
        if (i == 100002 || i == 100003) {
            return "The channel requests are too frequent";
        }
        if (i == 200001) {
            return "The required parameter is empty or missing";
        }
        if (i == 200002) {
            return "Parameter format error";
        }
        if (i == 200007) {
            return "Interface authentication failed";
        }
        if (i == 200008) {
            return "Log file unique id not found";
        }
        if (i == 200009) {
            return "Fragmentation policy is inconsistent";
        }
        if (i == 302001) {
            return "The channel does not exist or the channel is illegal";
        }
        if (i == 302002) {
            return "The country is not supported";
        }
        if (i == 302003) {
            return "The country code does not match the log server site";
        }
        if (i == 302004) {
            return "Upload log file is not supported for this mode";
        }
        return "Unknown error:" + i;
    }

    public static ArrayList<float[]> yn(ArrayList<float[]> arrayList, int i) {
        float[][] fArr;
        int i2 = i;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList.size(), arrayList.get(0).length);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            System.arraycopy(arrayList.get(i3), 0, fArr2[i3], 0, arrayList.get(i3).length);
        }
        if (fArr2.length == 0) {
            return arrayList;
        }
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i2, fArr2[0].length);
        double dDoubleValue = new BigDecimal(fArr2.length / i2).setScale(2, 4).doubleValue();
        int i4 = 0;
        while (i4 < fArr2[0].length) {
            int iRound = 0;
            int i5 = 0;
            while (true) {
                if (iRound >= fArr2.length) {
                    break;
                }
                if (i5 == i2 - 1) {
                    fArr3[i5][i4] = fArr2[fArr2.length - 1][i4];
                    break;
                }
                if (iRound == 0) {
                    fArr3[i5][i4] = fArr2[iRound][i4];
                    i5++;
                    iRound += (int) Math.round(dDoubleValue);
                } else {
                    double dRound = (((int) Math.round(dDoubleValue)) * dDoubleValue) / 2.0d;
                    if (Math.abs(dRound) >= 1.0E-6d) {
                        fArr = fArr3;
                        fArr3[i5][i4] = (float) (fArr2[iRound - ((int) Math.round(dDoubleValue))][i4] + ((fArr2[iRound][i4] - fArr2[iRound - ((int) Math.round(dDoubleValue))][i4]) / dRound));
                    } else {
                        fArr = fArr3;
                        fArr[i5][i4] = 0.0f;
                    }
                    i5++;
                    iRound += (int) Math.round(dDoubleValue);
                    fArr3 = fArr;
                    i2 = i;
                }
            }
            i4++;
            fArr3 = fArr3;
            i2 = i;
        }
        float[][] fArr4 = fArr3;
        ArrayList<float[]> arrayList2 = new ArrayList<>(i);
        for (float[] fArr5 : fArr4) {
            arrayList2.add(fArr5);
        }
        return arrayList2;
    }

    public static ArrayList<float[]> yn(ArrayList<float[]> arrayList, ArrayList<float[]> arrayList2, int i) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList.size(), arrayList.get(0).length);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            System.arraycopy(arrayList.get(i2), 0, fArr[i2], 0, arrayList.get(i2).length);
        }
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList2.size(), arrayList2.get(0).length);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            System.arraycopy(arrayList2.get(i3), 0, fArr2[i3], 0, arrayList2.get(i3).length);
        }
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, i);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                fArr3[i4][i5] = 0.0f;
                for (int i6 = 0; i6 < i; i6++) {
                    float[] fArr4 = fArr3[i4];
                    fArr4[i5] = fArr4[i5] + (fArr[i4][i6] * fArr2[i6][i5]);
                }
            }
        }
        ArrayList<float[]> arrayList3 = new ArrayList<>(i);
        for (float[] fArr5 : fArr3) {
            arrayList3.add(fArr5);
        }
        return arrayList3;
    }

    public static JSONObject yn(Location location) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (location == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("mProvider", location.getProvider());
        jSONObject2.put("mAltitude", location.getAltitude());
        jSONObject2.put("mBearing", location.getBearing());
        jSONObject2.put("mHorizontalAccuracyMeters", location.getAccuracy());
        jSONObject2.put("mLatitude", location.getLatitude());
        jSONObject2.put("mLongitude", location.getLongitude());
        jSONObject2.put("mSpeed", location.getSpeed());
        jSONObject2.put("mTime", location.getTime());
        int i = Build.VERSION.SDK_INT;
        jSONObject2.put("mElapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        if (i >= 26) {
            jSONObject2.put("mBearingAccuracyDegrees", location.getBearingAccuracyDegrees());
            jSONObject2.put("mSpeedAccuracyMetersPerSecond", location.getSpeedAccuracyMetersPerSecond());
            jSONObject2.put("mVerticalAccuracyMeters", location.getVerticalAccuracyMeters());
        }
        if (location.getExtras() != null) {
            JSONObject jSONObject3 = new JSONObject();
            if (location.getExtras().containsKey("SourceType")) {
                jSONObject3.put("SourceType", location.getExtras().getInt("SourceType", -1));
            }
            if (location.getExtras().containsKey("LocationSource")) {
                jSONObject3.put("LocationSource", location.getExtras().getInt("LocationSource", 0));
            }
            if (location.getExtras().containsKey("session_id")) {
                jSONObject3.put("session_id", location.getExtras().getString("session_id"));
            }
            if (location.getExtras().containsKey("vendorType")) {
                jSONObject3.put("vendorType", location.getExtras().getInt("vendorType"));
            }
            if (location.getExtras().containsKey("locateType")) {
                jSONObject3.put("locateType", location.getExtras().getString("locateType"));
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("mExtraInfo", jSONObject3);
            jSONObject.put("address", jSONObject4);
        }
        jSONObject.put("location", jSONObject2);
        return jSONObject;
    }

    public static boolean yn() {
        try {
            if (Build.VERSION.SDK_INT > 30 && !ROMUtil.isChineseRom()) {
                return true ^ PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION");
            }
            return false;
        } catch (Exception unused) {
            LogLocation.e("LocationInnerUtil", "checkApproximatelyPermission exception");
            return true;
        }
    }

    public static boolean yn(Context context, String str, String str2) throws Throwable {
        StringBuilder sb;
        String str3;
        File file = new File(str2);
        try {
            String str4 = context.getDir("libs", 0).getCanonicalPath() + File.separator + str;
            File file2 = new File(str4);
            Log.d("LibraryUtils", "src: " + file.getCanonicalPath() + "," + str4);
            boolean zYn = yn(file.getCanonicalPath(), file2.getCanonicalPath());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ret=");
            sb2.append(zYn);
            Log.d("LibraryUtils", sb2.toString());
            if (!zYn) {
                return false;
            }
            System.load(str4);
            return true;
        } catch (IOException e) {
            e = e;
            sb = new StringBuilder();
            str3 = "load file dir error: ";
            sb.append(str3);
            sb.append(e.getMessage());
            Log.e("LibraryUtils", sb.toString());
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
            sb = new StringBuilder();
            str3 = "invalid file: ";
            sb.append(str3);
            sb.append(e.getMessage());
            Log.e("LibraryUtils", sb.toString());
            return false;
        }
    }

    public static boolean yn(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest == null) {
            return false;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (locationRequest == null) {
            str = "checkRequestInvalid false, locationRequest is invalid";
        } else {
            if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
                return locationRequest.getNumUpdates() >= 1;
            }
            str = "checkRequestInvalid false, expirationTime is invalid";
        }
        LogLocation.i("LocationInnerUtil", str);
        return false;
    }

    public static boolean yn(String str) {
        String str2;
        try {
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                return ((LocationManager) systemService).isProviderEnabled(str);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str2 = "isProviderEnabled IllegalArgumentException";
            LogLocation.e("LocationInnerUtil", str2);
            return false;
        } catch (SecurityException unused2) {
            str2 = "isProviderEnabled SecurityException";
            LogLocation.e("LocationInnerUtil", str2);
            return false;
        } catch (Exception unused3) {
            str2 = "isProviderEnabled exception";
            LogLocation.e("LocationInnerUtil", str2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5 A[Catch: IOException -> 0x00c1, TryCatch #7 {IOException -> 0x00c1, blocks: (B:55:0x00bd, B:59:0x00c5, B:61:0x00ca), top: B:71:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ca A[Catch: IOException -> 0x00c1, TRY_LEAVE, TryCatch #7 {IOException -> 0x00c1, blocks: (B:55:0x00bd, B:59:0x00c5, B:61:0x00ca), top: B:71:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean yn(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.model.Vw.yn(java.lang.String, java.lang.String):boolean");
    }

    public static synchronized boolean yn(String str, String str2, String str3, String str4) {
        LogLocation.i("DownloadUtils", "download zip files from the cloud");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (new File(str).exists()) {
                LogLocation.i("DownloadUtils", "The file already exists.");
                return false;
            }
            String str5 = str + ".temp";
            File file = new File(str5);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                LogLocation.e("DownloadUtils", "Failed to create the file directory.");
                return false;
            }
            if (file.exists()) {
                LogLocation.e("DownloadUtils", "The file is being downloaded.");
                return false;
            }
            try {
                URI uriCreate = URI.create(str2);
                StringBuilder sb = new StringBuilder();
                sb.append(uriCreate.getScheme());
                sb.append(File.pathSeparator);
                String str6 = File.separator;
                sb.append(str6);
                sb.append(str6);
                sb.append(uriCreate.getHost());
                byte[] bArrFB = FB(sb.toString(), uriCreate.getPath());
                if (bArrFB.length <= 0) {
                    LogLocation.d("DownloadUtils", "zip file InputStream is null");
                    return false;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                    try {
                        fileOutputStream.write(bArrFB, 0, bArrFB.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (IOException unused) {
                    LogLocation.e("FileUtils", "saveToSd createSdFile stream read write exception");
                }
                String strYn = com.huawei.location.tiles.utils.LW.yn(str5, str3);
                if (!TextUtils.isEmpty(strYn) && strYn.equals(str4)) {
                    if (file.renameTo(new File(str))) {
                        LogLocation.d("DownloadUtils", "download file success");
                        LogLocation.i("DownloadUtils", "The zip file is downloaded successfully.");
                        return true;
                    }
                    file.delete();
                    LogLocation.d("DownloadUtils", "download file error");
                    return false;
                }
                file.delete();
                LogLocation.d("DownloadUtils", "Signature verification failed");
                return false;
            } catch (IllegalArgumentException unused2) {
                file.delete();
                LogLocation.e("DownloadUtils", "downloadUrl is illegal");
                return false;
            }
        }
        LogLocation.e("DownloadUtils", "The url or file path is abnormal.");
        return false;
    }
}
