package ru.yoomoney.sdk.auth.api;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J=\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/EnumRetrofitConverterFactory;", "Lretrofit2/Converter$Factory;", "()V", "getSerializedNameValue", "", "e", "", "stringConverter", "Lretrofit2/Converter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnumRetrofitConverterFactory extends Converter.Factory {
    private final String getSerializedNameValue(Enum<?> e) {
        try {
            SerializedName serializedName = (SerializedName) e.getClass().getField(e.name()).getAnnotation(SerializedName.class);
            if (serializedName != null) {
                return serializedName.value();
            }
            return null;
        } catch (Exception unused) {
            return e.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String stringConverter$lambda$0(EnumRetrofitConverterFactory this$0, Enum r2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(r2);
        return this$0.getSerializedNameValue(r2);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if ((type instanceof Class) && ((Class) type).isEnum()) {
            return new Converter() { // from class: ru.yoomoney.sdk.auth.api.EnumRetrofitConverterFactory$$ExternalSyntheticLambda0
                @Override // retrofit2.Converter
                public final Object convert(Object obj) {
                    return EnumRetrofitConverterFactory.stringConverter$lambda$0(this.f$0, (Enum) obj);
                }
            };
        }
        return null;
    }
}
