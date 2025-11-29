package ru.yoomoney.sdk.core_api.calladapter;

import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import ru.yoomoney.sdk.core_api.ApiResponse;

/* compiled from: ApiResponseResultCallAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012 \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0002B3\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/core_api/calladapter/ApiResponseResultCallAdapter;", "T", "Lretrofit2/CallAdapter;", "Lokhttp3/ResponseBody;", "Lru/yoomoney/sdk/core_api/ApiResponse;", "", "responseType", "Ljava/lang/reflect/Type;", "classT", "Ljava/lang/Class;", "argumentErrorType", "permissionErrorType", "(Ljava/lang/reflect/Type;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "adapt", "call", "Lretrofit2/Call;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiResponseResultCallAdapter<T> implements CallAdapter<ResponseBody, ApiResponse<T, Object, Object>> {
    private final Class<?> argumentErrorType;
    private final Class<T> classT;
    private final Class<?> permissionErrorType;
    private final Type responseType;

    public ApiResponseResultCallAdapter(Type responseType, Class<T> classT, Class<?> argumentErrorType, Class<?> permissionErrorType) {
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(classT, "classT");
        Intrinsics.checkNotNullParameter(argumentErrorType, "argumentErrorType");
        Intrinsics.checkNotNullParameter(permissionErrorType, "permissionErrorType");
        this.responseType = responseType;
        this.classT = classT;
        this.argumentErrorType = argumentErrorType;
        this.permissionErrorType = permissionErrorType;
    }

    @Override // retrofit2.CallAdapter
    /* renamed from: responseType, reason: from getter */
    public Type getResponseType() {
        return this.responseType;
    }

    @Override // retrofit2.CallAdapter
    public ApiResponse<T, Object, Object> adapt(Call<ResponseBody> call) throws IOException {
        Intrinsics.checkNotNullParameter(call, "call");
        Response<ResponseBody> responseExecute = call.execute();
        Intrinsics.checkNotNullExpressionValue(responseExecute, "execute(...)");
        return new ApiResponse<>(responseExecute, this.classT, this.argumentErrorType, this.permissionErrorType);
    }
}
