package ru.yoomoney.sdk.kassa.payments.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.ResultJacksonResponseBodyConverter;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u00030\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJE\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/YooKassaJacksonConverterFactory;", "Lretrofit2/Converter$Factory;", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "parameterAnnotations", "methodAnnotations", "Lokhttp3/RequestBody;", "requestBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "<init>", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "Companion", "ru/yoomoney/sdk/kassa/payments/api/l", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class YooKassaJacksonConverterFactory extends Converter.Factory {
    public static final int $stable = 8;
    public static final l Companion = new l();
    private final ObjectMapper mapper;

    private YooKassaJacksonConverterFactory(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(methodAnnotations, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return ResultJacksonResponseBodyConverter.INSTANCE.requestBodyConverter(type, this.mapper);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return ResultJacksonResponseBodyConverter.INSTANCE.responseBodyConverter(type, this.mapper);
    }

    public /* synthetic */ YooKassaJacksonConverterFactory(ObjectMapper objectMapper, DefaultConstructorMarker defaultConstructorMarker) {
        this(objectMapper);
    }
}
