package ru.yoomoney.sdk.auth.phone.enter.impl;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneErrorResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/AccountPhoneEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/enter/impl/AccountPhoneEnterInteractor;", "Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractorImpl;", "phoneChangeRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "changePhone", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "selectedCountry", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "phone", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePhoneChangeSetPhoneResponse", "response", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneResponse;", "registrationConfirmPhone", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "action", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action$SetPhone;Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPhoneEnterInteractorImpl extends BasePhoneEnterInteractorImpl implements AccountPhoneEnterInteractor {
    private final PhoneChangeRepository phoneChangeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.enter.impl.AccountPhoneEnterInteractorImpl", f = "AccountPhoneEnterInteractor.kt", l = {53, 60}, m = "changePhone")
    public static final class a extends ContinuationImpl {
        public AccountPhoneEnterInteractorImpl a;
        public String b;
        public PhoneChangeSetPhoneRequest c;
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
            return AccountPhoneEnterInteractorImpl.this.changePhone(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPhoneEnterInteractorImpl(PhoneChangeRepository phoneChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(passwordRecoveryRepository, serverTimeRepository);
        Intrinsics.checkNotNullParameter(phoneChangeRepository, "phoneChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.phoneChangeRepository = phoneChangeRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b8 -> B:13:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePhone(java.lang.String r10, ru.yoomoney.sdk.auth.api.model.CountryCallingCode r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.enter.PhoneEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.enter.impl.AccountPhoneEnterInteractorImpl.changePhone(java.lang.String, ru.yoomoney.sdk.auth.api.model.CountryCallingCode, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PhoneEnter.Action handlePhoneChangeSetPhoneResponse(PhoneChangeSetPhoneResponse response) {
        if (response instanceof PhoneChangeSetPhoneSuccessResponse) {
            return new PhoneEnter.Action.PhoneSetSuccess(((PhoneChangeSetPhoneSuccessResponse) response).getProcess());
        }
        if (response instanceof PhoneChangeSetPhoneErrorResponse) {
            return new PhoneEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((PhoneChangeSetPhoneErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    public Object registrationConfirmPhone(String str, Continuation<? super PhoneEnter.Action> continuation) {
        throw new IllegalArgumentException("no command for interaction " + this);
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.impl.BasePhoneEnterInteractor
    public Object setPhone(PhoneEnter.Action.SetPhone setPhone, CountryCallingCode countryCallingCode, Continuation<? super PhoneEnter.Action> continuation) throws IOException {
        String phone = setPhone.getPhone();
        StringBuilder sb = new StringBuilder();
        int length = phone.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = phone.charAt(i);
            if (Character.isDigit(cCharAt) || cCharAt == '+') {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        int i2 = WhenMappings.$EnumSwitchMapping$0[setPhone.getProcessType().ordinal()];
        if (i2 == 1) {
            return changePhone(setPhone.getProcessId(), countryCallingCode, string, continuation);
        }
        if (i2 == 2) {
            return setPhonePasswordRecovery(setPhone.getProcessId(), setPhone.getPhone(), continuation);
        }
        throw new IllegalArgumentException("no command for interaction " + this);
    }
}
