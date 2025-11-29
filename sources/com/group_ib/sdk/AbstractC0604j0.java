package com.group_ib.sdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Process;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0604j0 {
    public static final char[] a = "0123456789abcdef".toCharArray();

    static {
    }

    public static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable th) {
            System.out.println("GIBSDK: [Tools] Unable to check ActivityThread for processName " + th.getMessage());
        }
        return null;
    }

    public static String[] b(String str) throws IOException {
        try {
            InputStream inputStream = Runtime.getRuntime().exec(str).getInputStream();
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toString("UTF-8").split("\n");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            c1.b("Tools", "failed to execute '" + str + "'", e);
            return null;
        }
    }

    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\+", "%20").replaceAll("\\%27", "'").replaceAll("\\%21", "!").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static boolean b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int i;
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return (!runningAppProcessInfo.processName.equals(context.getPackageName()) || (i = runningAppProcessInfo.importance) == 230 || i == 300 || i == 400 || (Build.VERSION.SDK_INT < 26 && i == 130)) ? false : true;
                }
            }
        }
        System.out.println("GIBSDK: [Tools] Unable to check process importance");
        return true;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(40);
        for (byte b : bArr) {
            char[] cArr = a;
            stringBuffer.append(cArr[(b >> 4) & 15]);
            stringBuffer.append(cArr[b & 15]);
        }
        return stringBuffer.toString();
    }

    public static boolean a(MobileSdkService mobileSdkService, String str) {
        return ContextCompat.checkSelfPermission(mobileSdkService, str) == 0;
    }

    public static JSONObject a(MobileSdkService mobileSdkService) throws JSONException {
        Display defaultDisplay;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("version", "0.0.1").put(RemoteMessageConst.DATA, jSONObject2);
            jSONObject2.put("referrer", "");
            JSONObject jSONObjectPut = new JSONObject().put("href", T.i());
            URL url = T.b;
            jSONObject2.put("page", jSONObjectPut.put("hostname", url != null ? url.getHost() : ""));
            WindowManager windowManager = (WindowManager) mobileSdkService.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getRealSize(new Point());
                if (mobileSdkService.getResources().getDisplayMetrics() != null) {
                    int iCeil = (int) Math.ceil(r3.y / r7.density);
                    int iCeil2 = (int) Math.ceil(r3.x / r7.density);
                    jSONObject2.put("display", new JSONObject().put("height", iCeil).put("width", iCeil2).put("colorDepth", 24).put("availLeft", 0).put("availWidth", iCeil2).put("availTop", 0).put("availHeight", iCeil));
                }
            }
            TimeZone timeZone = TimeZone.getDefault();
            jSONObject2.put("timezone", Math.round(timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 60000) * (-1));
            jSONObject2.put("userAgent", System.getProperty("http.agent"));
            jSONObject2.put("device", new JSONObject().put("browser", "Netscape Mozilla").put("platform", Build.HARDWARE));
            return jSONObject;
        } catch (Exception e) {
            c1.b("Tools", "failed to build sysInfo", e);
            return null;
        }
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
