package bz;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* renamed from: bz.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0556u implements InterfaceC0502c {
    public static final String b = Q1.a(new byte[]{-77, 86, -16, 76, 62, 61, -27, 4, 105, -77, -68, 55, -108, 119, -80, -62});
    public final Y0 a;

    public C0556u(Y0 y0) {
        this.a = y0;
    }

    public final String a(Context context, String str) throws IOException {
        String string = null;
        try {
            InputStream inputStreamOpen = context.getAssets().open(String.format(Locale.ROOT, Q1.a(new byte[]{89, 46, 19, -18, -101, 71, 69, 64, 48, 48, -122, 107, 19, 67, -103, -92}), b, str));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.a.getClass();
                this.a.getClass();
                this.a.getClass();
                D1.a(inputStreamOpen, byteArrayOutputStream);
                string = byteArrayOutputStream.toString(Q1.a(new byte[]{-89, 92, -101, 125, 98, -109, 58, -47, 98, -18, -99, -32, 94, 108, 13, 84}));
                byteArrayOutputStream.close();
                inputStreamOpen.close();
            } finally {
            }
        } catch (Exception unused) {
        }
        return string;
    }
}
