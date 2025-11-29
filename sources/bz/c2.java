package bz;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class c2 extends AbstractC0538n1 {
    public static final String e = AbstractC0569y0.a(new byte[]{50, -104, -90, 92, -59, 33, 101, 51, -119, -126, -92, -16, -11, -101, 25, -33, -125, -121, 100, -57, -33, 28, 38, 67, -63, 86, -3, 91, 107, -128, -18, -100});
    public static final String f = AbstractC0569y0.a(new byte[]{-8, -66, 39, 65, -115, -33, 106, 48, -34, 73, 112, 98, -68, -6, 58, 61, 32, -77, -60, 113, 6, -15, 81, -125, 48, ByteSourceJsonBootstrapper.UTF8_BOM_1, -109, -28, 123, -90, -25, -3});
    public final Context c;
    public final boolean d;

    public c2(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.RSA_ApplicationKey);
        this.c = context;
        this.d = true;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        if (!this.d) {
            throw new C0564w1(AbstractC0569y0.a(new byte[]{102, -80, -128, 127, 104, -83, 75, 9, -45, 83, 18, 77, 80, -32, 34, -92, -63, -61, 30, -28, -118, -112, 3, 92, 105, ByteSourceJsonBootstrapper.UTF8_BOM_1, 65, 74, -80, -32, 117, -86, -126, -119, 97, -84, -96, -24, 115, 45, 7, -18, 66, 115, -73, 84, -113, -108}));
        }
        SharedPreferences sharedPreferences = this.c.getSharedPreferences(e, 0);
        String str = f;
        String string = sharedPreferences.getString(str, AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81}));
        if (!TextUtils.isEmpty(string.trim())) {
            return string;
        }
        String strReplaceAll = UUID.randomUUID().toString().toUpperCase(Locale.ROOT).replaceAll(AbstractC0569y0.a(new byte[]{109, -45, 59, -37, -21, 76, -108, 111, -7, 81, 37, 1, 24, 116, 45, 40}), AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81}));
        sharedPreferences.edit().putString(str, strReplaceAll).apply();
        return strReplaceAll;
    }
}
