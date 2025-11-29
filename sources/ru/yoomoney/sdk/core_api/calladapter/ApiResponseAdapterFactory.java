package ru.yoomoney.sdk.core_api.calladapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import ru.yoomoney.sdk.core_api.ApiResponse;

/* compiled from: ApiResponseAdapterFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/core_api/calladapter/ApiResponseAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiResponseAdapterFactory extends CallAdapter.Factory {
    public static final ApiResponseAdapterFactory INSTANCE = new ApiResponseAdapterFactory();

    private ApiResponseAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(returnType), ApiResponse.class)) {
            return null;
        }
        if (!(returnType instanceof ParameterizedType)) {
            throw new IllegalStateException("Return type must be a parameterized type.");
        }
        ParameterizedType parameterizedType = (ParameterizedType) returnType;
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, parameterizedType);
        Class<?> rawType = CallAdapter.Factory.getRawType(CallAdapter.Factory.getParameterUpperBound(1, parameterizedType));
        Class<?> rawType2 = CallAdapter.Factory.getRawType(CallAdapter.Factory.getParameterUpperBound(2, parameterizedType));
        Class<?> rawType3 = CallAdapter.Factory.getRawType(parameterUpperBound);
        Intrinsics.checkNotNullExpressionValue(rawType3, "getRawType(...)");
        Intrinsics.checkNotNull(rawType);
        Intrinsics.checkNotNull(rawType2);
        return new ApiResponseResultCallAdapter(ResponseBody.class, rawType3, rawType, rawType2);
    }
}
