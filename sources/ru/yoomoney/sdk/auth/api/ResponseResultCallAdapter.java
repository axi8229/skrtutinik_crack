package ru.yoomoney.sdk.auth.api;

import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/ResponseResultCallAdapter;", "T", "Lretrofit2/CallAdapter;", "Lretrofit2/Response;", "responseType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "adapt", "call", "Lretrofit2/Call;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseResultCallAdapter<T> implements CallAdapter<T, Response<T>> {
    private final Type responseType;

    public ResponseResultCallAdapter(Type responseType) {
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        this.responseType = responseType;
    }

    @Override // retrofit2.CallAdapter
    /* renamed from: responseType, reason: from getter */
    public Type getResponseType() {
        return this.responseType;
    }

    @Override // retrofit2.CallAdapter
    public Response<T> adapt(Call<T> call) throws IOException {
        Intrinsics.checkNotNullParameter(call, "call");
        Response<T> responseExecute = call.execute();
        Intrinsics.checkNotNullExpressionValue(responseExecute, "execute(...)");
        return responseExecute;
    }
}
