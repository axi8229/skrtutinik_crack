package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"Lretrofit2/converter/jackson/ResultJacksonResponseBodyConverter;", "", "()V", "requestBodyConverter", "Lretrofit2/Converter;", "T", "Lokhttp3/RequestBody;", "type", "Ljava/lang/reflect/Type;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "responseBodyConverter", "Lokhttp3/ResponseBody;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResultJacksonResponseBodyConverter {
    public static final int $stable = 0;
    public static final ResultJacksonResponseBodyConverter INSTANCE = new ResultJacksonResponseBodyConverter();

    private ResultJacksonResponseBodyConverter() {
    }

    public final <T> Converter<T, RequestBody> requestBodyConverter(Type type, ObjectMapper mapper) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new JacksonRequestBodyConverter(mapper.writerFor(mapper.getTypeFactory().constructType(type)));
    }

    public final <T> Converter<ResponseBody, T> responseBodyConverter(Type type, ObjectMapper mapper) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (Intrinsics.areEqual(parameterizedType.getRawType(), Result.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                return new JacksonResponseBodyConverter(mapper.readerFor(mapper.getTypeFactory().constructType((Type) ArraysKt.firstOrNull(actualTypeArguments))));
            }
        }
        return new JacksonResponseBodyConverter(mapper.readerFor(mapper.getTypeFactory().constructType(type)));
    }
}
