package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1199qf;

/* renamed from: com.yandex.metrica.impl.ob.cm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0858cm extends Vl {
    private static final int[] c = {3, 6, 4};
    private static final C0858cm d = new C0858cm("");

    public C0858cm(String str) {
        super(str);
    }

    public static C0858cm a() {
        return d;
    }

    @Override // com.yandex.metrica.coreutils.logger.BaseLogger
    public String getTag() {
        return "AppMetrica";
    }

    public C0858cm() {
        this("");
    }

    public void a(C1199qf.d dVar, String str) {
        String string;
        for (C1199qf.d.a aVar : dVar.c) {
            if (aVar != null) {
                int[] iArr = c;
                int length = iArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (aVar.c == iArr[i]) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(": ");
                            if (aVar.c == 3 && TextUtils.isEmpty(aVar.d)) {
                                string = "Native crash of app";
                            } else if (aVar.c == 4) {
                                StringBuilder sb2 = new StringBuilder(aVar.d);
                                byte[] bArr = aVar.e;
                                if (bArr != null) {
                                    String str2 = new String(bArr);
                                    if (!TextUtils.isEmpty(str2)) {
                                        sb2.append(" with value ");
                                        sb2.append(str2);
                                    }
                                }
                                string = sb2.toString();
                            } else {
                                string = aVar.d;
                            }
                            sb.append(string);
                            i(sb.toString());
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
    }
}
