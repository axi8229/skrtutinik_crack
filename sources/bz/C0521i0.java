package bz;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.File;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.NoSuchPaddingException;

/* renamed from: bz.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0521i0 extends AbstractC0538n1 {
    public final Z0 c;

    public C0521i0(Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.OSFontsNumber);
        this.c = z0;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        File[] fileArrListFiles = new File(AbstractC0569y0.a(new byte[]{110, -70, -1, ByteSourceJsonBootstrapper.UTF8_BOM_2, 42, -64, -70, -72, -128, 16, 15, 68, 112, -98, -50, -67})).listFiles();
        if (fileArrListFiles == null) {
            return String.valueOf(0);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (File file : fileArrListFiles) {
            arrayList.add(String.valueOf(file).replace(AbstractC0569y0.a(new byte[]{9, -92, -96, 118, 17, -126, -49, 92, -55, -76, 74, 112, 20, 8, 65, -58}), AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81})));
            i++;
            AbstractC0569y0.a(new byte[]{-80, 100, 120, -77, 101, 33, 34, 65, -101, 11, 89, 121, -73, -4, 19, -14});
        }
        Z0 z0 = this.c;
        zone.bi.mobile.fingerprint.api.f fVar = zone.bi.mobile.fingerprint.api.f.OSFontsHash;
        Integer numValueOf = Integer.valueOf(arrayList.hashCode());
        z0.getClass();
        z0.a(fVar, new C0572z0(numValueOf));
        return String.valueOf(i);
    }
}
