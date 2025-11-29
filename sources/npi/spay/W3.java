package npi.spay;

import android.content.Context;
import android.provider.Settings;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class W3 implements InterfaceC1532d3 {
    public final Context a;
    public final C1555e1 b;
    public String c;

    public W3(Context appContext, C1555e1 deviceIdPreferences) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(deviceIdPreferences, "deviceIdPreferences");
        this.a = appContext;
        this.b = deviceIdPreferences;
        this.c = C1555e1.a(appContext);
    }

    public final String a() {
        if (this.c.length() == 0) {
            synchronized (this) {
                try {
                    if (this.c.length() == 0) {
                        String strB = b();
                        this.c = strB;
                        this.b.a(this.a, strB);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public final String b() throws NoSuchAlgorithmException {
        String androidId = Settings.System.getString(this.a.getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(androidId, "androidId");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = androidId.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] hash = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(hash, "hash");
        for (byte b : hash) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "hexString.toString()");
        return StringsKt.trim(new Regex("[\\r\\n\\t]").replace(string, "")).toString();
    }
}
