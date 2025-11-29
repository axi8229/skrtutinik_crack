package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.pm.FeatureInfo;

/* renamed from: com.yandex.metrica.impl.ob.rb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1218rb {

    /* renamed from: com.yandex.metrica.impl.ob.rb$a */
    public static class a extends AbstractC1218rb {
        @Override // com.yandex.metrica.impl.ob.AbstractC1218rb
        @TargetApi(24)
        public C1242sb b(FeatureInfo featureInfo) {
            return new C1242sb(featureInfo.name, featureInfo.version, c(featureInfo));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.rb$b */
    public static class b extends AbstractC1218rb {
        @Override // com.yandex.metrica.impl.ob.AbstractC1218rb
        public C1242sb b(FeatureInfo featureInfo) {
            return new C1242sb(featureInfo.name, -1, c(featureInfo));
        }
    }

    public C1242sb a(FeatureInfo featureInfo) {
        if (featureInfo.name != null) {
            return b(featureInfo);
        }
        int i = featureInfo.reqGlEsVersion;
        return i == 0 ? b(featureInfo) : new C1242sb("openGlFeature", i, c(featureInfo));
    }

    protected abstract C1242sb b(FeatureInfo featureInfo);

    boolean c(FeatureInfo featureInfo) {
        return (featureInfo.flags & 1) != 0;
    }
}
