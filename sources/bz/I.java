package bz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class I extends AbstractC0538n1 {
    public static final String c = AbstractC0569y0.a(new byte[]{96, -13, 101, -45, -46, -90, 59, 109, -82, 69, 31, -92, 68, 110, 78, 117, 43, -4, -58, -75, 74, -19, -18, 93, 72, -102, 75, -64, 124, -126, -64, -44});

    public I() {
        super(zone.bi.mobile.fingerprint.api.f.BootId);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws IOException, C0564w1 {
        try {
            FileInputStream fileInputStream = new FileInputStream(c);
            try {
                String strTrim = new BufferedReader(new InputStreamReader(fileInputStream)).readLine().trim();
                fileInputStream.close();
                return strTrim;
            } finally {
            }
        } catch (IOException unused) {
            throw new C0564w1(AbstractC0569y0.a(new byte[]{-22, 50, 49, 30, 56, -21, 8, 106, -97, 78, -12, 124, -57, -3, 70, 110, 43, -19, 14, 14, -54, -60, 109, -75, 2, -29, 116, -45, -11, -84, -29, -48, 6, -127, 66, 54, -24, 4, -107, 68, 36, 11, 84, 37, -61, 61, 69, 40, -112, -70, 74, -39, 50, -91, 124, 76, -13, 98, -22, 100, 19, -97, -61, -61}));
        }
    }
}
