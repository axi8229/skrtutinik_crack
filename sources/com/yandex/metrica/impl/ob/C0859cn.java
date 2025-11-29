package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* renamed from: com.yandex.metrica.impl.ob.cn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0859cn extends Sm<String> {
    public C0859cn(int i, String str) {
        this(i, str, Ul.a());
    }

    public C0859cn(int i, String str, C0858cm c0858cm) {
        super(i, str, c0858cm);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0934fn
    public String a(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes.length <= super.b()) {
                return str;
            }
            String str2 = new String(bytes, 0, super.b(), "UTF-8");
            try {
                if (this.c.isEnabled()) {
                    this.c.fw("\"%s\" %s exceeded limit of %d bytes", super.a(), str, Integer.valueOf(super.b()));
                }
            } catch (UnsupportedEncodingException unused) {
            }
            return str2;
        } catch (UnsupportedEncodingException unused2) {
            return str;
        }
    }
}
