package com.yandex.metrica.impl.ob;

import android.net.Uri;
import com.yandex.metrica.networktasks.api.IParamsAppender;

/* loaded from: classes3.dex */
public class Ng implements IParamsAppender {
    @Override // com.yandex.metrica.networktasks.api.IParamsAppender
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void appendParams(Uri.Builder builder, C1410zb c1410zb) {
        a(builder, "adv_id", "limit_ad_tracking", c1410zb.a().a);
        a(builder, "oaid", "limit_oaid_tracking", c1410zb.b().a);
        a(builder, "yandex_adv_id", "limit_yandex_adv_id_tracking", c1410zb.c().a);
    }

    private void a(Uri.Builder builder, String str, String str2, C1266tb c1266tb) {
        String str3 = "";
        if (c1266tb == null) {
            builder.appendQueryParameter(str, "");
            builder.appendQueryParameter(str2, "");
            return;
        }
        String str4 = c1266tb.b;
        if (str4 == null) {
            str4 = "";
        }
        builder.appendQueryParameter(str, str4);
        Boolean bool = c1266tb.c;
        if (bool != null) {
            str3 = bool.booleanValue() ? "1" : "0";
        }
        builder.appendQueryParameter(str2, str3);
    }
}
