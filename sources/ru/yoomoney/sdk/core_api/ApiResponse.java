package ru.yoomoney.sdk.core_api;

import _COROUTINE.ArtificialStackFrames;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.yoomoney.sdk.core_api.ApiResponseFold;

/* compiled from: ApiResponses.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004:\u0001)B9\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011Jo\u0010\u0010\u001a\u0002H\u0012\"\u0004\b\u0003\u0010\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00120\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u00120\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u00172\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0017¢\u0006\u0002\u0010\u001cJ²\u0001\u0010\u001d\u001a\u0002H\u0012\"\u0004\b\u0003\u0010\u00122(\u0010\u0013\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001e2\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00142&\b\u0002\u0010\u0019\u001a \b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142&\b\u0002\u0010\u001b\u001a \b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0002J-\u0010&\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0003\u0010\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00120\tH\u0002¢\u0006\u0002\u0010(R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponse;", "Success", "RuleViolation", "PermissionRuleViolation", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "classT", "Ljava/lang/Class;", "classArgumentRV", "classPermissionRV", "(Lretrofit2/Response;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "body", "", "errorBody", "fold", "Lru/yoomoney/sdk/core_api/ApiResponseFold;", "T", "success", "Lkotlin/Function2;", "Lokhttp3/Headers;", "error", "Lkotlin/Function1;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "retry", "Lru/yoomoney/sdk/core_api/ProcessApiResponseBody;", "notModified", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "foldSuspend", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseError", "json", "code", "", "parseProgress", "parseSuccess", "classSuccess", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiResponse<Success, RuleViolation, PermissionRuleViolation> {
    private static final String TAG = ApiResponse.class.getName();
    private final String body;
    private final Class<?> classArgumentRV;
    private final Class<?> classPermissionRV;
    private final Class<Success> classT;
    private final String errorBody;
    private final Response<ResponseBody> value;

    public ApiResponse(Response<ResponseBody> value, Class<Success> classT, Class<?> classArgumentRV, Class<?> classPermissionRV) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(classT, "classT");
        Intrinsics.checkNotNullParameter(classArgumentRV, "classArgumentRV");
        Intrinsics.checkNotNullParameter(classPermissionRV, "classPermissionRV");
        this.value = value;
        this.classT = classT;
        this.classArgumentRV = classArgumentRV;
        this.classPermissionRV = classPermissionRV;
        ResponseBody responseBodyBody = value.body();
        this.body = responseBodyBody != null ? responseBodyBody.string() : null;
        ResponseBody responseBodyErrorBody = value.errorBody();
        this.errorBody = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
    }

    public final ApiResponseFold<Success> fold() {
        ApiErrorBodyResponse error;
        try {
            int iCode = this.value.code();
            if (iCode == 200) {
                Log.d(TAG, "response success with body = " + this.body);
                String str = this.body;
                Object success = str != null ? parseSuccess(str, this.classT) : null;
                if (success != null) {
                    Headers headers = this.value.headers();
                    Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
                    return new ApiResponseFold.Success(success, headers);
                }
                return new ApiResponseFold.Error(UnknownErrorResponse.INSTANCE);
            }
            if (iCode == 202) {
                Log.d(TAG, "response accepted with body = " + this.body);
                String str2 = this.body;
                ProcessApiResponseBody progress = str2 != null ? parseProgress(str2) : null;
                if (progress != null) {
                    return new ApiResponseFold.RetryAfter(progress);
                }
                return new ApiResponseFold.Error(UnknownErrorResponse.INSTANCE);
            }
            if (iCode == 304) {
                Log.d(TAG, "response not modified");
                Headers headers2 = this.value.headers();
                Intrinsics.checkNotNullExpressionValue(headers2, "headers(...)");
                return new ApiResponseFold.NotModified(headers2);
            }
            Log.d(TAG, "error response with code = " + this.value.code() + " and errorBody = " + this.errorBody);
            String str3 = this.errorBody;
            if (str3 == null || (error = parseError(str3, this.value.code())) == null) {
                error = UnknownErrorResponse.INSTANCE;
            }
            return new ApiResponseFold.Error(error);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponseFold.Error(UnknownErrorResponse.INSTANCE);
        }
    }

    public static /* synthetic */ Object fold$default(ApiResponse apiResponse, Function2 function2, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = null;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        return apiResponse.fold(function2, function1, function12, function13);
    }

    public final <T> T fold(Function2<? super Success, ? super Headers, ? extends T> success, Function1<? super ApiErrorBodyResponse, ? extends T> error, Function1<? super ProcessApiResponseBody, ? extends T> retry, Function1<? super Headers, ? extends T> notModified) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
        ApiResponseFold<Success> apiResponseFoldFold = fold();
        if (apiResponseFoldFold instanceof ApiResponseFold.Success) {
            ArtificialStackFrames artificialStackFrames = (Object) ((ApiResponseFold.Success) apiResponseFoldFold).getValue();
            Headers headers = this.value.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
            return success.invoke(artificialStackFrames, headers);
        }
        if (apiResponseFoldFold instanceof ApiResponseFold.Error) {
            return error.invoke(((ApiResponseFold.Error) apiResponseFoldFold).getValue());
        }
        if (apiResponseFoldFold instanceof ApiResponseFold.RetryAfter) {
            if (retry != null) {
                return retry.invoke(((ApiResponseFold.RetryAfter) apiResponseFoldFold).getValue());
            }
            return error.invoke(UnknownErrorResponse.INSTANCE);
        }
        if (!(apiResponseFoldFold instanceof ApiResponseFold.NotModified)) {
            throw new NoWhenBranchMatchedException();
        }
        if (notModified != null) {
            return notModified.invoke(((ApiResponseFold.NotModified) apiResponseFoldFold).getValue());
        }
        return error.invoke(UnknownErrorResponse.INSTANCE);
    }

    public final <T> Object foldSuspend(Function3<? super Success, ? super Headers, ? super Continuation<? super T>, ? extends Object> function3, Function2<? super ApiErrorBodyResponse, ? super Continuation<? super T>, ? extends Object> function2, Function2<? super ProcessApiResponseBody, ? super Continuation<? super T>, ? extends Object> function22, Function2<? super Headers, ? super Continuation<? super T>, ? extends Object> function23, Continuation<? super T> continuation) {
        ApiResponseFold<Success> apiResponseFoldFold = fold();
        if (apiResponseFoldFold instanceof ApiResponseFold.Success) {
            ArtificialStackFrames artificialStackFrames = (Object) ((ApiResponseFold.Success) apiResponseFoldFold).getValue();
            Headers headers = this.value.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
            return function3.invoke(artificialStackFrames, headers, continuation);
        }
        if (apiResponseFoldFold instanceof ApiResponseFold.Error) {
            return function2.invoke(((ApiResponseFold.Error) apiResponseFoldFold).getValue(), continuation);
        }
        if (apiResponseFoldFold instanceof ApiResponseFold.RetryAfter) {
            if (function22 != null) {
                return function22.invoke(((ApiResponseFold.RetryAfter) apiResponseFoldFold).getValue(), continuation);
            }
            return function2.invoke(UnknownErrorResponse.INSTANCE, continuation);
        }
        if (!(apiResponseFoldFold instanceof ApiResponseFold.NotModified)) {
            throw new NoWhenBranchMatchedException();
        }
        if (function23 != null) {
            return function23.invoke(((ApiResponseFold.NotModified) apiResponseFoldFold).getValue(), continuation);
        }
        return function2.invoke(UnknownErrorResponse.INSTANCE, continuation);
    }

    private final ApiErrorBodyResponse parseError(String json, int code) {
        ApiErrorBodyResponse argumentRuleViolationErrorResponse;
        try {
            ApiErrorBodyResponse error = ((ApiErrorResponse) Serializer.getJacksonObjectMapper().readValue(json, ApiErrorResponse.class)).getError();
            if (!(error instanceof RuleViolationErrorResponse)) {
                return error;
            }
            if (code == 400) {
                argumentRuleViolationErrorResponse = new ArgumentRuleViolationErrorResponse(((RuleViolationErrorResponse) error).ruleTo(this.classArgumentRV), ((RuleViolationErrorResponse) error).getDescription());
            } else if (code == 403) {
                argumentRuleViolationErrorResponse = new PermissionRuleViolationErrorResponse(((RuleViolationErrorResponse) error).ruleTo(this.classPermissionRV), ((RuleViolationErrorResponse) error).getDescription());
            } else {
                return UnknownErrorResponse.INSTANCE;
            }
            return argumentRuleViolationErrorResponse;
        } catch (Exception e) {
            Log.d(TAG, "can't parse error response = " + json);
            e.printStackTrace();
            return null;
        }
    }

    private final ProcessApiResponseBody parseProgress(String json) {
        try {
            return ((ProcessApiResponse) Serializer.getJacksonObjectMapper().readValue(json, ProcessApiResponse.class)).getError();
        } catch (Exception e) {
            Log.d(TAG, "can't parse accept response = " + json);
            e.printStackTrace();
            return null;
        }
    }

    private final <T> T parseSuccess(String json, Class<T> classSuccess) {
        try {
            return (T) Serializer.getJacksonObjectMapper().readValue(json, classSuccess);
        } catch (Exception e) {
            Log.d(TAG, "can't parse success response = " + json);
            e.printStackTrace();
            return null;
        }
    }
}
