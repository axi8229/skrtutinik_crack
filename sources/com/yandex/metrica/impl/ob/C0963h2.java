package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Log;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.plugins.PluginErrorDetails;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;

/* renamed from: com.yandex.metrica.impl.ob.h2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0963h2 {
    private static final Pattern a = Pattern.compile(".*at com\\.yandex\\.metrica\\.push\\.*");
    private static final Pattern b = Pattern.compile(".*at com\\.yandex\\.metrica\\.(?!push)");

    /* renamed from: com.yandex.metrica.impl.ob.h2$a */
    static class a {
        static final String a;

        static {
            a = C0963h2.a("com.unity3d.player.UnityPlayer") ? PluginErrorDetails.Platform.UNITY : C0963h2.a("mono.MonoPackageManager") ? PluginErrorDetails.Platform.XAMARIN : C0963h2.a("org.apache.cordova.CordovaPlugin") ? PluginErrorDetails.Platform.CORDOVA : C0963h2.a("com.facebook.react.ReactRootView") ? "react" : C0963h2.a("io.flutter.embedding.engine.FlutterEngine") ? PluginErrorDetails.Platform.FLUTTER : PluginErrorDetails.Platform.NATIVE;
        }
    }

    public static void a(String str, Object... objArr) {
        Log.i("AppMetrica-Attribution", String.format(str, objArr));
    }

    static void b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Initializing of Metrica, ");
        String str = "release";
        if (TextUtils.isEmpty("release")) {
            str = "";
        } else {
            char cCharAt = "release".charAt(0);
            if (!Character.isUpperCase(cCharAt)) {
                str = Character.toUpperCase(cCharAt) + "elease";
            }
        }
        sb.append(str);
        sb.append(" type, Version ");
        sb.append("5.3.0");
        sb.append(", API Level ");
        sb.append(YandexMetrica.getLibraryApiLevel());
        sb.append(", Dated ");
        sb.append("03.03.2023");
        sb.append(".");
        Log.i("AppMetrica", sb.toString());
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e("AppMetrica-Attribution", String.format(str, objArr), th);
    }

    public static String a() {
        return a.a;
    }

    static boolean a(Throwable th) {
        String string;
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            string = stringWriter.toString();
            printWriter.close();
        } else {
            string = "";
        }
        return !TextUtils.isEmpty(string) && b.matcher(string).find();
    }

    public static boolean a(String str) {
        return b(str) != null;
    }

    public static void b(String str, Object... objArr) {
        Log.w("AppMetrica-Attribution", String.format(str, objArr));
    }

    static boolean b(Throwable th) {
        String string;
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            string = stringWriter.toString();
            printWriter.close();
        } else {
            string = "";
        }
        return !TextUtils.isEmpty(string) && a.matcher(string).find();
    }

    public static Class b(String str) {
        try {
            return Class.forName(str, false, C0963h2.class.getClassLoader());
        } catch (Throwable unused) {
            return null;
        }
    }
}
