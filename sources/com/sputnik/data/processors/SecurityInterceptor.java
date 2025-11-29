package com.sputnik.data.processors;

import com.google.gson.Gson;
import com.sputnik.data.entities.auth.DataSecureRequest;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* compiled from: SecurityInterceptor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/data/processors/SecurityInterceptor;", "Lokhttp3/Interceptor;", "()V", "gson", "Lcom/google/gson/Gson;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "getBodyAsString", "", "Lokhttp3/Request;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SecurityInterceptor implements Interceptor {
    public static final SecurityInterceptor INSTANCE = new SecurityInterceptor();
    private static final Gson gson = new Gson();

    private SecurityInterceptor() {
    }

    private final String getBodyAsString(Request request) throws IOException {
        Buffer buffer = new Buffer();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            requestBodyBody.writeTo(buffer);
        }
        return buffer.readUtf8();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        String url = request.url().getUrl();
        NetworkString networkString = NetworkString.INSTANCE;
        if ((StringsKt.contains$default((CharSequence) url, (CharSequence) networkString.getEndpoint1(), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) networkString.getEndpoint2(), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) "auth2", false, 2, (Object) null)) && Intrinsics.areEqual(request.method(), "POST")) {
            DataSecureRequest dataSecureRequest = (DataSecureRequest) gson.fromJson(getBodyAsString(request), DataSecureRequest.class);
            Request.Builder builderAddHeader = builderNewBuilder.addHeader(networkString.getStringHeader(), NetworkProcessUtils.INSTANCE.process((dataSecureRequest != null ? dataSecureRequest.getPhone() : null) + "-" + (dataSecureRequest != null ? Long.valueOf(dataSecureRequest.getTime()) : null), networkString.getString()));
            RequestBody requestBodyBody = request.body();
            Intrinsics.checkNotNull(requestBodyBody);
            return chain.proceed(builderAddHeader.post(requestBodyBody).build());
        }
        return chain.proceed(request);
    }
}
