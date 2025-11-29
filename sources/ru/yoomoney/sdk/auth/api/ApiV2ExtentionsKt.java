package ru.yoomoney.sdk.auth.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.model.ErrorResponse;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.api.model.InvalidTokenFailure;
import ru.yoomoney.sdk.auth.api.model.RegistrationRuleViolationFailure;
import ru.yoomoney.sdk.auth.api.model.RegistrationRuleViolationType;
import ru.yoomoney.sdk.auth.api.model.TechnicalFailure;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetEmailRulesViolationError;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetPhoneRulesViolationError;
import ru.yoomoney.sdk.core_api.ApiErrorBodyResponse;
import ru.yoomoney.sdk.core_api.ArgumentRuleViolationErrorResponse;
import ru.yoomoney.sdk.core_api.ArgumentsParametersErrorResponse;
import ru.yoomoney.sdk.core_api.AuthenticationTokenErrorResponse;
import ru.yoomoney.sdk.core_api.TechnicalErrorResponse;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001aB\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bH\u0080@¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000e\u001a'\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0015H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0016H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0017H\u0002¨\u0006\u0018"}, d2 = {"executeNotSuspendWithResult", "Lkotlin/Result;", "T", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "executeWithResult", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseErrorToResult", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "parseResponseToResult", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "toFailure", "Lru/yoomoney/sdk/auth/api/model/Failure;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationSetEmailRulesViolationError;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationSetPhoneRulesViolationError;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "Lru/yoomoney/sdk/core_api/ArgumentRuleViolationErrorResponse;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiV2ExtentionsKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RegistrationSetEmailRulesViolationError.values().length];
            try {
                iArr[RegistrationSetEmailRulesViolationError.EMAIL_ALREADY_TAKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RegistrationSetPhoneRulesViolationError.values().length];
            try {
                iArr2[RegistrationSetPhoneRulesViolationError.PHONE_NUMBER_LIMIT_REACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt", f = "ApiV2Extentions.kt", l = {21}, m = "executeWithResult")
    public static final class a<T> extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            Object objExecuteWithResult = ApiV2ExtentionsKt.executeWithResult(null, this);
            return objExecuteWithResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecuteWithResult : Result.m2627boximpl(objExecuteWithResult);
        }
    }

    public static final <T> Object executeNotSuspendWithResult(Function0<? extends Result<? extends T>> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke().getValue();
        } catch (Exception e) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m2628constructorimpl(ResultKt.createFailure(ApiExtentionsKt.toFailure(e)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object executeWithResult(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r4, kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.a
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt$a r0 = (ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt$a r0 = new ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L29
            goto L3f
        L29:
            r4 = move-exception
            goto L46
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.b = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r4.invoke(r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L3f
            return r1
        L3f:
            kotlin.Result r5 = (kotlin.Result) r5     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r5.getValue()     // Catch: java.lang.Exception -> L29
            goto L54
        L46:
            kotlin.Result$Companion r5 = kotlin.Result.INSTANCE
            ru.yoomoney.sdk.auth.api.model.Failure r4 = ru.yoomoney.sdk.auth.api.ApiExtentionsKt.toFailure(r4)
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m2628constructorimpl(r4)
        L54:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object parseErrorToResult(String str) {
        ErrorResponse errorResponse = (ErrorResponse) ApiClientUtilsKt.getGson().fromJson(str, (Class) ErrorResponse.class);
        Result.Companion companion = Result.INSTANCE;
        Intrinsics.checkNotNull(errorResponse);
        return Result.m2628constructorimpl(ResultKt.createFailure(ApiExtentionsKt.toFailure(errorResponse)));
    }

    public static final <T> Object parseResponseToResult(Response<T> response) {
        TechnicalFailure technicalFailure;
        Object objCreateFailure;
        Intrinsics.checkNotNullParameter(response, "<this>");
        try {
            if (response.isSuccessful()) {
                objCreateFailure = response.body();
                if (objCreateFailure != null) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(objCreateFailure);
                }
                Result.Companion companion2 = Result.INSTANCE;
                technicalFailure = new TechnicalFailure(null, 1, null);
            } else {
                ResponseBody responseBodyErrorBody = response.errorBody();
                if (responseBodyErrorBody != null) {
                    return parseErrorToResult(responseBodyErrorBody.string());
                }
                Result.Companion companion3 = Result.INSTANCE;
                technicalFailure = new TechnicalFailure(null, 1, null);
            }
            objCreateFailure = ResultKt.createFailure(technicalFailure);
            return Result.m2628constructorimpl(objCreateFailure);
        } catch (Exception e) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m2628constructorimpl(ResultKt.createFailure(ApiExtentionsKt.toFailure(e)));
        }
    }

    private static final Failure toFailure(RegistrationSetEmailRulesViolationError registrationSetEmailRulesViolationError) {
        RegistrationRuleViolationType registrationRuleViolationType = WhenMappings.$EnumSwitchMapping$0[registrationSetEmailRulesViolationError.ordinal()] == 1 ? RegistrationRuleViolationType.EMAIL_ALREADY_TAKEN : null;
        return registrationRuleViolationType != null ? new RegistrationRuleViolationFailure(registrationRuleViolationType) : new TechnicalFailure(null, 1, null);
    }

    private static final Failure toFailure(RegistrationSetPhoneRulesViolationError registrationSetPhoneRulesViolationError) {
        RegistrationRuleViolationType registrationRuleViolationType = WhenMappings.$EnumSwitchMapping$1[registrationSetPhoneRulesViolationError.ordinal()] == 1 ? RegistrationRuleViolationType.PHONE_NUMBER_LIMIT_REACHED : null;
        return registrationRuleViolationType != null ? new RegistrationRuleViolationFailure(registrationRuleViolationType) : new TechnicalFailure(null, 1, null);
    }

    public static final Failure toFailure(ApiErrorBodyResponse apiErrorBodyResponse) {
        Intrinsics.checkNotNullParameter(apiErrorBodyResponse, "<this>");
        if (!(apiErrorBodyResponse instanceof TechnicalErrorResponse)) {
            return apiErrorBodyResponse instanceof AuthenticationTokenErrorResponse ? InvalidTokenFailure.INSTANCE : apiErrorBodyResponse instanceof ArgumentsParametersErrorResponse ? new IllegalParametersFailure(((ArgumentsParametersErrorResponse) apiErrorBodyResponse).getParameterNames()) : apiErrorBodyResponse instanceof ArgumentRuleViolationErrorResponse ? toFailure((ArgumentRuleViolationErrorResponse<?>) apiErrorBodyResponse) : new TechnicalFailure(null, 1, null);
        }
        return new TechnicalFailure(((TechnicalErrorResponse) apiErrorBodyResponse).getRetryAfter() != null ? Long.valueOf(r3.intValue()) : null);
    }

    private static final Failure toFailure(ArgumentRuleViolationErrorResponse<?> argumentRuleViolationErrorResponse) {
        Object rule = argumentRuleViolationErrorResponse.getRule();
        if (rule instanceof RegistrationSetEmailRulesViolationError) {
            Object rule2 = argumentRuleViolationErrorResponse.getRule();
            Intrinsics.checkNotNull(rule2, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetEmailRulesViolationError");
            return toFailure((RegistrationSetEmailRulesViolationError) rule2);
        }
        if (!(rule instanceof RegistrationSetPhoneRulesViolationError)) {
            return new TechnicalFailure(null, 1, null);
        }
        Object rule3 = argumentRuleViolationErrorResponse.getRule();
        Intrinsics.checkNotNull(rule3, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetPhoneRulesViolationError");
        return toFailure((RegistrationSetPhoneRulesViolationError) rule3);
    }
}
