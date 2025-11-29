package ru.yoomoney.sdk.kassa.payments.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class k extends CallAdapter.Factory {
    public final ru.yoomoney.sdk.kassa.payments.api.failures.a a;
    public Boolean b;

    public k(ru.yoomoney.sdk.kassa.payments.api.failures.a apiErrorMapper) {
        Intrinsics.checkNotNullParameter(apiErrorMapper, "apiErrorMapper");
        this.a = apiErrorMapper;
    }

    @Override // retrofit2.CallAdapter.Factory
    public final CallAdapter get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Object objM2628constructorimpl;
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(returnType), Call.class) || !(returnType instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType gVar = (ParameterizedType) returnType;
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, gVar);
        Intrinsics.checkNotNullExpressionValue(parameterUpperBound, "getParameterUpperBound(...)");
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(parameterUpperBound), Result.class) || !(parameterUpperBound instanceof ParameterizedType)) {
            return null;
        }
        Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
        if (!Intrinsics.areEqual(this.b, Boolean.TRUE)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM2628constructorimpl = Result.m2628constructorimpl(retrofit.nextResponseBodyConverter(null, parameterUpperBound, new Annotation[0]));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
            }
            boolean zM2634isSuccessimpl = Result.m2634isSuccessimpl(objM2628constructorimpl);
            this.b = Boolean.valueOf(zM2634isSuccessimpl);
            if (!zM2634isSuccessimpl) {
                Intrinsics.checkNotNull(parameterUpperBound2);
                gVar = new g(parameterUpperBound2);
            }
        }
        CallAdapter<?, ?> callAdapterNextCallAdapter = retrofit.nextCallAdapter(this, gVar, annotations);
        Intrinsics.checkNotNullExpressionValue(callAdapterNextCallAdapter, "nextCallAdapter(...)");
        return new j(callAdapterNextCallAdapter, this.a);
    }
}
