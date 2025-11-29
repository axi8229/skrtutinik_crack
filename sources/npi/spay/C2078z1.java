package npi.spay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StatFs;
import java.io.File;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.z1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2078z1 {
    public final Context a;
    public final T3 b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public C2078z1(Context context, T3 settings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.a = context;
        this.b = settings;
        this.c = LazyKt.lazy(new C2028x1(this));
        this.d = LazyKt.lazy(new C2053y1(this));
        this.e = LazyKt.lazy(new C1978v1(this));
        this.f = LazyKt.lazy(new C2003w1(this));
    }

    public static final String a(C2078z1 c2078z1) {
        c2078z1.getClass();
        try {
            File externalFilesDir = c2078z1.a.getExternalFilesDir(null);
            long totalBytes = new StatFs(externalFilesDir != null ? externalFilesDir.getPath() : null).getTotalBytes();
            return totalBytes <= -1 ? "UNKNOWN" : String.valueOf(totalBytes);
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static final String b(C2078z1 c2078z1) {
        c2078z1.getClass();
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr == null || strArr.length == 0) {
            return "UNKNOWN";
        }
        String str = strArr[0];
        Intrinsics.checkNotNullExpressionValue(str, "abis[0]");
        return str;
    }

    public static final String c(C2078z1 c2078z1) {
        ApplicationInfo applicationInfo = c2078z1.a.getApplicationInfo();
        int i = applicationInfo.labelRes;
        if (i == 0) {
            return applicationInfo.nonLocalizedLabel.toString();
        }
        String string = c2078z1.a.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
        return string;
    }

    public final C2001w a() {
        String str = this.b.b;
        String string = Locale.getDefault().toString();
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        String MANUFACTURER = Build.MANUFACTURER;
        String MODEL = Build.MODEL;
        String str2 = (String) this.c.getValue();
        String str3 = (String) this.d.getValue();
        String str4 = (String) this.e.getValue();
        String str5 = (String) this.f.getValue();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return new C2001w(str, "MOBILE", "Android", "Android", strValueOf, string, MANUFACTURER, MODEL, str2, str3, str4, str5, E2.a());
    }
}
