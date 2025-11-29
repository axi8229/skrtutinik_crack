package ru.yoomoney.sdk.two_fa.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.api.method.GetAuthContextApiResponse;
import ru.yoomoney.sdk.two_fa.api.method.StartAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApiDefaultType;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApiPushApp;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApiPushCode;
import ru.yoomoney.sdk.two_fa.api.model.AvailableSessionOption;
import ru.yoomoney.sdk.two_fa.api.model.MonetaryAmount;
import ru.yoomoney.sdk.two_fa.api.model.SessionApi;
import ru.yoomoney.sdk.two_fa.api.model.SessionApiDefaultType;
import ru.yoomoney.sdk.two_fa.api.model.SessionEmailApi;
import ru.yoomoney.sdk.two_fa.api.model.SessionPhoneCallApi;
import ru.yoomoney.sdk.two_fa.api.model.SessionPushAppApi;
import ru.yoomoney.sdk.two_fa.api.model.SessionPushCodeApi;
import ru.yoomoney.sdk.two_fa.api.model.SessionSmsApi;

/* compiled from: DomainExtension.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0000\u001a\f\u0010\u0000\u001a\u00020\u000b*\u00020\fH\u0000\u001a\f\u0010\u0000\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0000\u001a\f\u0010\u0000\u001a\u00020\u0010*\u00020\u0011H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0012*\u00020\u0013H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0014H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0015*\u00020\u0016H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0017*\u00020\u0018H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0019*\u00020\u001aH\u0000\u001a\f\u0010\u0000\u001a\u00020\u001b*\u00020\u001cH\u0000\u001a\f\u0010\u0000\u001a\u00020\u001d*\u00020\u001eH\u0000\u001a\f\u0010\u0000\u001a\u00020\u001f*\u00020 H\u0000¨\u0006!"}, d2 = {"toDomainModel", "Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "Lru/yoomoney/sdk/two_fa/api/method/GetAuthContextApiResponse;", "Lru/yoomoney/sdk/two_fa/domain/Session;", "Lru/yoomoney/sdk/two_fa/api/method/StartAuthSessionApiResponse;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApi;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionDefaultType;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiDefaultType;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionPushApp;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiPushApp;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionPushCode;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiPushCode;", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionOperationInfo;", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionOperationInfo;", "Lru/yoomoney/sdk/two_fa/api/model/AuthContext;", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "Lru/yoomoney/sdk/two_fa/api/model/AvailableSessionOption;", "Lru/yoomoney/sdk/two_fa/domain/Amount;", "Lru/yoomoney/sdk/two_fa/api/model/MonetaryAmount;", "Lru/yoomoney/sdk/two_fa/api/model/SessionApi;", "Lru/yoomoney/sdk/two_fa/domain/SessionDefaultType;", "Lru/yoomoney/sdk/two_fa/api/model/SessionApiDefaultType;", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "Lru/yoomoney/sdk/two_fa/api/model/SessionEmailApi;", "Lru/yoomoney/sdk/two_fa/domain/SessionPhoneCall;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPhoneCallApi;", "Lru/yoomoney/sdk/two_fa/domain/SessionPushApp;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPushAppApi;", "Lru/yoomoney/sdk/two_fa/domain/SessionPushCode;", "Lru/yoomoney/sdk/two_fa/api/model/SessionPushCodeApi;", "Lru/yoomoney/sdk/two_fa/domain/SessionSms;", "Lru/yoomoney/sdk/two_fa/api/model/SessionSmsApi;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainExtensionKt {
    public static final AuthContext toDomainModel(GetAuthContextApiResponse getAuthContextApiResponse) {
        Intrinsics.checkNotNullParameter(getAuthContextApiResponse, "<this>");
        return toDomainModel(getAuthContextApiResponse.getContext());
    }

    public static final AuthContext toDomainModel(ru.yoomoney.sdk.two_fa.api.model.AuthContext authContext) {
        Intrinsics.checkNotNullParameter(authContext, "<this>");
        AuthStatus authStatusValueOf = AuthStatus.valueOf(authContext.getAuthStatus().name());
        List<AvailableSessionOption> availableSessionOptions = authContext.getAvailableSessionOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availableSessionOptions, 10));
        Iterator<T> it = availableSessionOptions.iterator();
        while (it.hasNext()) {
            arrayList.add(toDomainModel((AvailableSessionOption) it.next()));
        }
        SessionApi activeSession = authContext.getActiveSession();
        return new AuthContext(authStatusValueOf, arrayList, activeSession != null ? toDomainModel(activeSession) : null);
    }

    public static final SessionType toDomainModel(AvailableSessionOption availableSessionOption) {
        Intrinsics.checkNotNullParameter(availableSessionOption, "<this>");
        return SessionType.valueOf(availableSessionOption.getType().name());
    }

    public static final Session toDomainModel(SessionApi sessionApi) {
        Intrinsics.checkNotNullParameter(sessionApi, "<this>");
        if (sessionApi instanceof SessionEmailApi) {
            return toDomainModel((SessionEmailApi) sessionApi);
        }
        if (sessionApi instanceof SessionPhoneCallApi) {
            return toDomainModel((SessionPhoneCallApi) sessionApi);
        }
        if (sessionApi instanceof SessionPushAppApi) {
            return toDomainModel((SessionPushAppApi) sessionApi);
        }
        if (sessionApi instanceof SessionPushCodeApi) {
            return toDomainModel((SessionPushCodeApi) sessionApi);
        }
        if (sessionApi instanceof SessionSmsApi) {
            return toDomainModel((SessionSmsApi) sessionApi);
        }
        if (sessionApi instanceof SessionApiDefaultType) {
            return toDomainModel((SessionApiDefaultType) sessionApi);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SessionEmail toDomainModel(SessionEmailApi sessionEmailApi) {
        Intrinsics.checkNotNullParameter(sessionEmailApi, "<this>");
        return new SessionEmail(SessionType.valueOf(sessionEmailApi.getType().name()), sessionEmailApi.getValidUntil(), sessionEmailApi.getNextAvailableFrom(), sessionEmailApi.getEmail(), sessionEmailApi.getCodeLength(), sessionEmailApi.getAttemptsLeft());
    }

    public static final SessionPhoneCall toDomainModel(SessionPhoneCallApi sessionPhoneCallApi) {
        Intrinsics.checkNotNullParameter(sessionPhoneCallApi, "<this>");
        return new SessionPhoneCall(SessionType.valueOf(sessionPhoneCallApi.getType().name()), sessionPhoneCallApi.getValidUntil(), sessionPhoneCallApi.getNextAvailableFrom(), sessionPhoneCallApi.getPhone(), sessionPhoneCallApi.getCodeLength(), sessionPhoneCallApi.getAttemptsLeft());
    }

    public static final SessionPushApp toDomainModel(SessionPushAppApi sessionPushAppApi) {
        Intrinsics.checkNotNullParameter(sessionPushAppApi, "<this>");
        return new SessionPushApp(SessionType.valueOf(sessionPushAppApi.getType().name()), sessionPushAppApi.getValidUntil(), sessionPushAppApi.getNextAvailableFrom());
    }

    public static final SessionPushCode toDomainModel(SessionPushCodeApi sessionPushCodeApi) {
        Intrinsics.checkNotNullParameter(sessionPushCodeApi, "<this>");
        return new SessionPushCode(SessionType.valueOf(sessionPushCodeApi.getType().name()), sessionPushCodeApi.getValidUntil(), sessionPushCodeApi.getNextAvailableFrom(), sessionPushCodeApi.getCodeLength(), sessionPushCodeApi.getAttemptsLeft());
    }

    public static final SessionSms toDomainModel(SessionSmsApi sessionSmsApi) {
        Intrinsics.checkNotNullParameter(sessionSmsApi, "<this>");
        return new SessionSms(SessionType.valueOf(sessionSmsApi.getType().name()), sessionSmsApi.getValidUntil(), sessionSmsApi.getNextAvailableFrom(), sessionSmsApi.getPhone(), sessionSmsApi.getCodeLength(), sessionSmsApi.getAttemptsLeft());
    }

    public static final SessionDefaultType toDomainModel(SessionApiDefaultType sessionApiDefaultType) {
        Intrinsics.checkNotNullParameter(sessionApiDefaultType, "<this>");
        return new SessionDefaultType(SessionType.valueOf(sessionApiDefaultType.getType().name()), sessionApiDefaultType.getValidUntil(), sessionApiDefaultType.getNextAvailableFrom());
    }

    public static final Session toDomainModel(StartAuthSessionApiResponse startAuthSessionApiResponse) {
        Intrinsics.checkNotNullParameter(startAuthSessionApiResponse, "<this>");
        return toDomainModel(startAuthSessionApiResponse.getSession());
    }

    public static final ActiveSession toDomainModel(ActiveSessionApi activeSessionApi) {
        Intrinsics.checkNotNullParameter(activeSessionApi, "<this>");
        if (activeSessionApi instanceof ActiveSessionApiPushApp) {
            return toDomainModel((ActiveSessionApiPushApp) activeSessionApi);
        }
        if (activeSessionApi instanceof ActiveSessionApiPushCode) {
            return toDomainModel((ActiveSessionApiPushCode) activeSessionApi);
        }
        if (activeSessionApi instanceof ActiveSessionApiDefaultType) {
            return toDomainModel((ActiveSessionApiDefaultType) activeSessionApi);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ActiveSessionPushApp toDomainModel(ActiveSessionApiPushApp activeSessionApiPushApp) {
        Intrinsics.checkNotNullParameter(activeSessionApiPushApp, "<this>");
        ActiveSessionType activeSessionTypeValueOf = ActiveSessionType.valueOf(activeSessionApiPushApp.getType().name());
        String authProcessId = activeSessionApiPushApp.getAuthProcessId();
        ru.yoomoney.sdk.two_fa.api.model.ActiveSessionOperationInfo operationInfo = activeSessionApiPushApp.getOperationInfo();
        return new ActiveSessionPushApp(activeSessionTypeValueOf, authProcessId, operationInfo != null ? toDomainModel(operationInfo) : null);
    }

    public static final ActiveSessionPushCode toDomainModel(ActiveSessionApiPushCode activeSessionApiPushCode) {
        Intrinsics.checkNotNullParameter(activeSessionApiPushCode, "<this>");
        ActiveSessionType activeSessionTypeValueOf = ActiveSessionType.valueOf(activeSessionApiPushCode.getType().name());
        String authProcessId = activeSessionApiPushCode.getAuthProcessId();
        String confirmationCode = activeSessionApiPushCode.getConfirmationCode();
        ru.yoomoney.sdk.two_fa.api.model.ActiveSessionOperationInfo operationInfo = activeSessionApiPushCode.getOperationInfo();
        return new ActiveSessionPushCode(activeSessionTypeValueOf, authProcessId, confirmationCode, operationInfo != null ? toDomainModel(operationInfo) : null);
    }

    public static final ActiveSessionDefaultType toDomainModel(ActiveSessionApiDefaultType activeSessionApiDefaultType) {
        Intrinsics.checkNotNullParameter(activeSessionApiDefaultType, "<this>");
        return new ActiveSessionDefaultType(ActiveSessionType.valueOf(activeSessionApiDefaultType.getType().name()), activeSessionApiDefaultType.getAuthProcessId());
    }

    public static final ActiveSessionOperationInfo toDomainModel(ru.yoomoney.sdk.two_fa.api.model.ActiveSessionOperationInfo activeSessionOperationInfo) {
        Intrinsics.checkNotNullParameter(activeSessionOperationInfo, "<this>");
        String operationName = activeSessionOperationInfo.getOperationName();
        String operationKey = activeSessionOperationInfo.getOperationKey();
        MonetaryAmount amount = activeSessionOperationInfo.getAmount();
        return new ActiveSessionOperationInfo(operationName, operationKey, amount != null ? toDomainModel(amount) : null);
    }

    public static final Amount toDomainModel(MonetaryAmount monetaryAmount) {
        Intrinsics.checkNotNullParameter(monetaryAmount, "<this>");
        BigDecimal bigDecimal = new BigDecimal(monetaryAmount.getValue());
        Currency currency = Currency.getInstance(monetaryAmount.getCurrency());
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        return new Amount(bigDecimal, currency);
    }
}
