package ru.yoomoney.sdk.auth.api;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.model.ErrorResponse;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersErrorResponse;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.api.model.InvalidTokenErrorResponse;
import ru.yoomoney.sdk.auth.api.model.InvalidTokenFailure;
import ru.yoomoney.sdk.auth.api.model.NetworkConnectionFailure;
import ru.yoomoney.sdk.auth.api.model.RuleViolationType;
import ru.yoomoney.sdk.auth.api.model.RulesViolationErrorResponse;
import ru.yoomoney.sdk.auth.api.model.RulesViolationFailure;
import ru.yoomoney.sdk.auth.api.model.TechnicalErrorResponse;
import ru.yoomoney.sdk.auth.api.model.TechnicalFailure;
import ru.yoomoney.sdk.auth.api.model.UpdateRequireFailure;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000bH\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\fH\u0000¨\u0006\r"}, d2 = {"executeCall", "Lkotlin/Result;", "T", "", "block", "Lkotlin/Function0;", "Lretrofit2/Call;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toFailure", "Lru/yoomoney/sdk/auth/api/model/Failure;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lru/yoomoney/sdk/auth/api/model/ErrorResponse;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiExtentionsKt {
    public static final <T> Object executeCall(Function0<? extends Call<T>> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Response<T> responseExecute = block.invoke().execute();
            Intrinsics.checkNotNullExpressionValue(responseExecute, "execute(...)");
            return ApiV2ExtentionsKt.parseResponseToResult(responseExecute);
        } catch (Exception e) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m2628constructorimpl(ResultKt.createFailure(toFailure(e)));
        }
    }

    public static final Failure toFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        return ((exc instanceof SocketException) || (exc instanceof SocketTimeoutException) || (exc instanceof InterruptedIOException) || (exc instanceof UnknownHostException)) ? new NetworkConnectionFailure(exc.getMessage()) : exc instanceof UpdateRequiredException ? UpdateRequireFailure.INSTANCE : new TechnicalFailure(null, 1, null);
    }

    public static final Failure toFailure(ErrorResponse errorResponse) {
        Intrinsics.checkNotNullParameter(errorResponse, "<this>");
        if (errorResponse instanceof TechnicalErrorResponse) {
            return new TechnicalFailure(((TechnicalErrorResponse) errorResponse).getRetryAfter());
        }
        if (errorResponse instanceof IllegalParametersErrorResponse) {
            return new IllegalParametersFailure(((IllegalParametersErrorResponse) errorResponse).getParameterNames());
        }
        if (errorResponse instanceof InvalidTokenErrorResponse) {
            return InvalidTokenFailure.INSTANCE;
        }
        if (!(errorResponse instanceof RulesViolationErrorResponse)) {
            throw new NoWhenBranchMatchedException();
        }
        RuleViolationType rule = ((RulesViolationErrorResponse) errorResponse).getRule();
        return rule != null ? new RulesViolationFailure(rule) : new TechnicalFailure(null, 1, null);
    }
}
