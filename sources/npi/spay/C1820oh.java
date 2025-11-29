package npi.spay;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* renamed from: npi.spay.oh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1820oh extends Converter.Factory {
    @Override // retrofit2.Converter.Factory
    public final Converter responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (type == Hg.class) {
            return new C1845ph();
        }
        return null;
    }
}
