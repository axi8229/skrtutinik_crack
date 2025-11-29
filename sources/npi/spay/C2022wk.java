package npi.spay;

import android.content.Context;
import bz.AbstractC0507d1;
import bz.AbstractC0538n1;
import bz.AbstractC0543p0;
import bz.AbstractC0569y0;
import bz.C0519h1;
import bz.C0555t1;
import bz.C0573z1;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import javax.crypto.NoSuchPaddingException;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.json.JSONException;

/* renamed from: npi.spay.wk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2022wk implements InterfaceC1847pj {
    public final C0555t1 a;
    public final C1853q0 b;

    public C2022wk(C0555t1 bizoneFingerprintFactory, C1853q0 systemProperties) {
        Intrinsics.checkNotNullParameter(bizoneFingerprintFactory, "bizoneFingerprintFactory");
        Intrinsics.checkNotNullParameter(systemProperties, "systemProperties");
        this.a = bizoneFingerprintFactory;
        this.b = systemProperties;
    }

    public final String a(Rj fingerprintSettings) throws JSONException, NoSuchPaddingException, zone.bi.mobile.fingerprint.api.serialize.b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Serializable serializableA;
        Serializable serializableI;
        Intrinsics.checkNotNullParameter(fingerprintSettings, "fingerprintSettings");
        C0555t1 c0555t1 = this.a;
        c0555t1.getClass();
        Context context = c0555t1.a;
        C0519h1 c0519h1A = AbstractC0507d1.a();
        if (bz.F0.b == null) {
            synchronized (bz.F0.class) {
                bz.F0.b = new bz.T1();
            }
        }
        bz.T1 t1 = bz.F0.b;
        t1.a.clear();
        bz.H1 h1 = new bz.H1(context, fingerprintSettings, c0519h1A, new C0573z1(t1), c0555t1.b);
        for (Object obj : h1.f.values()) {
            if (obj instanceof bz.U1) {
                ((bz.U1) obj).g();
            }
        }
        Intrinsics.checkNotNullExpressionValue(h1, "bizoneFingerprintFactory…eate(fingerprintSettings)");
        Iterator it = h1.e.iterator();
        while (it.hasNext()) {
            bz.S0.o.execute(((bz.S0) it.next()).b());
        }
        zone.bi.mobile.fingerprint.api.f[] fVarArr = (zone.bi.mobile.fingerprint.api.f[]) h1.f.keySet().toArray(new zone.bi.mobile.fingerprint.api.f[0]);
        h1.d.a.a(zone.bi.mobile.fingerprint.api.g.Info, AbstractC0569y0.a(new byte[]{79, -23, -52, 110, 58, 117, 99, 13, 85, 6, 67, -53, 38, -67, 14, -92, Utf8.REPLACEMENT_BYTE, 28, -18, ByteSourceJsonBootstrapper.UTF8_BOM_3, 49, 36, 75, 56, -38, 110, -122, -54, -99, -16, 106, 47}), 0);
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = new zone.bi.mobile.fingerprint.api.serialize.model.a();
        HashMap map = new HashMap();
        for (zone.bi.mobile.fingerprint.api.f fVar : fVarArr) {
            AbstractC0538n1 abstractC0538n1 = (AbstractC0538n1) h1.f.get(fVar);
            if (abstractC0538n1 == null) {
                throw new IllegalArgumentException(AbstractC0569y0.a(new byte[]{-105, 50, 67, -30, 37, 109, 42, 74, -48, 104, Utf8.REPLACEMENT_BYTE, -81, 117, 75, -82, 44}) + fVar.name() + AbstractC0569y0.a(new byte[]{-2, -101, 24, -126, -107, -34, 10, 45, 104, -112, 108, 105, 76, -44, -20, -113, -2, -15, -101, 16, 106, 96, 35, -59, 66, -119, 39, 59, 100, 71, 69, -50, 110, -61, -92, 88, 37, 45, -119, -27, -81, 54, 119, 60, -128, -107, 6, 26}));
            }
            String strName = fVar.name();
            try {
                serializableI = abstractC0538n1.i();
            } catch (AbstractC0543p0 e) {
                if (fVar.b) {
                    serializableA = e.a(fVar);
                } else {
                    h1.b.getClass();
                    serializableA = null;
                }
                map.put(fVar, e);
                h1.d.a(fVar, e);
                serializableI = serializableA;
            }
            if (serializableI != null) {
                aVar.put(strName, serializableI);
            } else {
                aVar.remove(strName);
            }
        }
        h1.b.getClass();
        h1.b.getClass();
        h1.b.getClass();
        ((Rj) h1.b).getClass();
        try {
            zone.bi.mobile.fingerprint.api.serialize.model.c cVarA = zone.bi.mobile.fingerprint.api.serialize.d.a(aVar);
            if (aVar.containsKey("LocationHash")) {
                try {
                    cVarA.remove("LocationHash");
                    cVarA.put("LocationHash", zone.bi.mobile.fingerprint.api.serialize.c.a(zone.bi.mobile.fingerprint.api.serialize.c.a(cVarA), ""));
                } catch (JSONException e2) {
                    throw new zone.bi.mobile.fingerprint.api.serialize.b(e2);
                }
            }
            String string = cVarA.toString(0);
            aVar.containsKey("LocationHash");
            h1.d.a.a(zone.bi.mobile.fingerprint.api.g.Info, AbstractC0569y0.a(new byte[]{-62, -71, -22, -19, 110, 17, 111, 44, 66, 62, -74, -31, 35, -39, -123, -64}), 0);
            for (Object obj2 : h1.f.values()) {
                if (obj2 instanceof bz.U1) {
                    ((bz.U1) obj2).d();
                }
            }
            return string;
        } catch (Exception e3) {
            throw new zone.bi.mobile.fingerprint.api.serialize.b(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final npi.spay.Vm a() throws org.json.JSONException, javax.crypto.NoSuchPaddingException, zone.bi.mobile.fingerprint.api.serialize.b, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2022wk.a():npi.spay.Vm");
    }
}
