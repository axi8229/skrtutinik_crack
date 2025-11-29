package ru.yoomoney.sdk.auth.api.sessionTicket;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.api.ApiExtentionsKt;
import ru.yoomoney.sdk.auth.api.model.ErrorResponse;
import ru.yoomoney.sdk.auth.api.model.RequestParametersFailure;
import ru.yoomoney.sdk.auth.api.model.TechnicalFailure;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"parseErrorToResult", "Lkotlin/Result;", "T", "", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "parseSessionTicketResponse", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SessionTicketApiExtensionsKt {
    private static final <T> Object parseErrorToResult(String str) {
        ErrorResponse errorResponse = (ErrorResponse) ApiClientUtilsKt.getGson().fromJson(str, (Class) ErrorResponse.class);
        Result.Companion companion = Result.INSTANCE;
        Intrinsics.checkNotNull(errorResponse);
        return Result.m2628constructorimpl(ResultKt.createFailure(ApiExtentionsKt.toFailure(errorResponse)));
    }

    public static final <T> Object parseSessionTicketResponse(Response<T> response) {
        TechnicalFailure technicalFailure;
        Object objCreateFailure;
        Intrinsics.checkNotNullParameter(response, "<this>");
        try {
            if (response.isSuccessful()) {
                objCreateFailure = response.body();
                if (objCreateFailure != null) {
                    Result.Companion companion = Result.INSTANCE;
                } else {
                    Result.Companion companion2 = Result.INSTANCE;
                    technicalFailure = new TechnicalFailure(null, 1, null);
                    objCreateFailure = ResultKt.createFailure(technicalFailure);
                }
            } else if (response.code() == 400) {
                Result.Companion companion3 = Result.INSTANCE;
                ResponseBody responseBodyErrorBody = response.errorBody();
                objCreateFailure = ResultKt.createFailure(new RequestParametersFailure(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
            } else {
                ResponseBody responseBodyErrorBody2 = response.errorBody();
                if (responseBodyErrorBody2 != null) {
                    return parseErrorToResult(responseBodyErrorBody2.string());
                }
                Result.Companion companion4 = Result.INSTANCE;
                technicalFailure = new TechnicalFailure(null, 1, null);
                objCreateFailure = ResultKt.createFailure(technicalFailure);
            }
            return Result.m2628constructorimpl(objCreateFailure);
        } catch (Exception e) {
            Result.Companion companion5 = Result.INSTANCE;
            return Result.m2628constructorimpl(ResultKt.createFailure(ApiExtentionsKt.toFailure(e)));
        }
    }
}
