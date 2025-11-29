package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class H {
    private final Context a;
    private final C0845c9 b;
    private final String c;
    private final C1108mn d;

    public H(Context context, C0845c9 c0845c9) {
        this(context, c0845c9, context.getPackageName(), new C1108mn());
    }

    public List<String> a() {
        Signature[] apkContentsSigners;
        String strReplaceAll;
        List<String> listH = this.b.h();
        boolean zIsEmpty = listH.isEmpty();
        List<String> list = listH;
        if (zIsEmpty) {
            ArrayList arrayList = new ArrayList();
            try {
                if (A2.a(28)) {
                    SigningInfo signingInfo = this.d.b(this.a, this.c, 134217728).signingInfo;
                    apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
                } else {
                    apkContentsSigners = this.d.b(this.a, this.c, 64).signatures;
                }
                if (apkContentsSigners != null) {
                    for (Signature signature : apkContentsSigners) {
                        try {
                            strReplaceAll = C0810b.a(MessageDigest.getInstance("SHA1").digest(signature.toByteArray())).toUpperCase(Locale.US).replaceAll("(.{2})(?=.+)", "$1:");
                        } catch (Throwable unused) {
                            strReplaceAll = null;
                        }
                        if (strReplaceAll != null) {
                            arrayList.add(strReplaceAll);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            Collections.sort(arrayList);
            boolean zIsEmpty2 = arrayList.isEmpty();
            list = arrayList;
            if (!zIsEmpty2) {
                this.b.a(arrayList).d();
                list = arrayList;
            }
        }
        return list;
    }

    H(Context context, C0845c9 c0845c9, String str, C1108mn c1108mn) {
        this.a = context;
        this.b = c0845c9;
        this.c = str;
        this.d = c1108mn;
    }
}
