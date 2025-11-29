package ru.yoomoney.sdk.auth.email.enter.impl;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractor;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateEmail", Scopes.EMAIL, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseEmailEnterInteractorImpl implements BaseEmailEnterInteractor {
    private final ServerTimeRepository serverTimeRepository;

    public BaseEmailEnterInteractorImpl(ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.serverTimeRepository = serverTimeRepository;
    }

    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    public final Object checkExpiration(EmailEnter.Action.CheckExpiration checkExpiration, Continuation<? super EmailEnter.Action> continuation) {
        OffsetDateTime expireAt = checkExpiration.getExpireAt();
        return (expireAt == null || !expireAt.isBefore(this.serverTimeRepository.getCurrentDateTime())) ? new EmailEnter.Action.SendEmail(checkExpiration.getProcessType(), checkExpiration.getProcessId()) : EmailEnter.Action.Expired.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object validateEmail(java.lang.String r2, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r3) {
        /*
            r1 = this;
            int r3 = r2.length()
            r0 = 6
            if (r3 < r0) goto L1b
            java.util.regex.Pattern r3 = androidx.core.util.PatternsCompat.EMAIL_ADDRESS
            java.lang.String r0 = "EMAIL_ADDRESS"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            kotlin.text.Regex r0 = new kotlin.text.Regex
            r0.<init>(r3)
            boolean r3 = r0.matches(r2)
            if (r3 == 0) goto L1b
            r3 = 1
            goto L1c
        L1b:
            r3 = 0
        L1c:
            ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$EmailChanged r0 = new ru.yoomoney.sdk.auth.email.enter.EmailEnter$Action$EmailChanged
            r0.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractorImpl.validateEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
