package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.l5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1065l5 extends X4 {
    public C1065l5(L3 l3) {
        super(l3);
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        String strP = c0836c0.p();
        com.yandex.metrica.g gVarA = C0810b.a(strP);
        String strH = a().h();
        com.yandex.metrica.g gVarA2 = C0810b.a(strH);
        if (gVarA.equals(gVarA2)) {
            return true;
        }
        if (TextUtils.isEmpty(gVarA.c()) && !TextUtils.isEmpty(gVarA2.c())) {
            c0836c0.e(strH);
            a(c0836c0, EnumC1007im.LOGOUT);
        } else if (!TextUtils.isEmpty(gVarA.c()) && TextUtils.isEmpty(gVarA2.c())) {
            a(c0836c0, EnumC1007im.LOGIN);
        } else if (TextUtils.isEmpty(gVarA.c()) || gVarA.c().equals(gVarA2.c())) {
            a(c0836c0, EnumC1007im.UPDATE);
        } else {
            a(c0836c0, EnumC1007im.SWITCH);
        }
        a().a(strP);
        return true;
    }

    private void a(C0836c0 c0836c0, EnumC1007im enumC1007im) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("action", enumC1007im.toString());
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = null;
        }
        c0836c0.f(string);
        a().r().b(c0836c0);
    }
}
