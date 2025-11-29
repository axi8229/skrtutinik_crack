package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneErrorResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneSuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractor;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPreloadData", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$LoadData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePasswordRecoveryEnterPhoneResponse", "response", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneResponse;", "handlePasswordRecoveryProcess", "process", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "setPhonePasswordRecovery", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BasePhoneEnterInteractorImpl implements BasePhoneEnterInteractor {
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractorImpl", f = "BasePhoneEnterInteractor.kt", l = {54, 61}, m = "setPhonePasswordRecovery")
    public static final class a extends ContinuationImpl {
        public BasePhoneEnterInteractorImpl a;
        public String b;
        public PasswordRecoveryEnterPhoneRequest c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return BasePhoneEnterInteractorImpl.this.setPhonePasswordRecovery(null, null, this);
        }
    }

    public BasePhoneEnterInteractorImpl(PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.passwordRecoveryRepository = passwordRecoveryRepository;
        this.serverTimeRepository = serverTimeRepository;
    }

    private final PhoneEnter.Action handlePasswordRecoveryEnterPhoneResponse(PasswordRecoveryEnterPhoneResponse response) {
        if (response instanceof PasswordRecoveryEnterPhoneSuccessResponse) {
            return handlePasswordRecoveryProcess(((PasswordRecoveryEnterPhoneSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordRecoveryEnterPhoneErrorResponse) {
            return new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((PasswordRecoveryEnterPhoneErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PhoneEnter.Action handlePasswordRecoveryProcess(PasswordRecoveryProcess process) {
        return process instanceof PasswordRecoveryProcessFailure ? new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((PasswordRecoveryProcessFailure) process).getError())) : new PhoneEnter.Action.PhoneSetSuccess(process);
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    public final Object checkExpiration(PhoneEnter.Action.CheckExpiration checkExpiration, Continuation<? super PhoneEnter.Action> continuation) {
        OffsetDateTime expireAt = checkExpiration.getExpireAt();
        return (expireAt == null || !expireAt.isBefore(this.serverTimeRepository.getCurrentDateTime())) ? new PhoneEnter.Action.SetPhone(checkExpiration.getProcessType(), checkExpiration.getProcessId(), checkExpiration.getPhone()) : PhoneEnter.Action.Expired.INSTANCE;
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    public final Object checkPreloadData(PhoneEnter.Action.LoadData loadData, Continuation<? super PhoneEnter.Action> continuation) {
        return (loadData.getResultDataPhone() != null || loadData.getPredefinedPhone() == null) ? new PhoneEnter.Action.ShowContent(loadData.getSelectedCountry()) : new PhoneEnter.Action.ShowContentWithPreloadedData(loadData.getSelectedCountry(), loadData.getPredefinedPhone());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b4 -> B:13:0x0034). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhonePasswordRecovery(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractorImpl.setPhonePasswordRecovery(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
