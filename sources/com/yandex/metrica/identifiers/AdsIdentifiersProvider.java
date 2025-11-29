package com.yandex.metrica.identifiers;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.yandex.metrica.identifiers.impl.h;

@Keep
/* loaded from: classes3.dex */
public class AdsIdentifiersProvider {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final h retriever = new h(null, 1);

    public static Bundle requestIdentifiers(Context context, Bundle bundle) {
        return retriever.a(context, bundle.getString("com.yandex.metrica.identifiers.extra.PROVIDER"));
    }
}
