package ru.yoomoney.sdk.auth.password.create.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordErrorResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordSuccessResponse;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.utils.RandomPasswordGenerator;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractorImpl;", "Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractor;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "generatePassword", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePasswordRecoverySetPasswordResponse", "response", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordResponse;", "isValid", "", "firstPassword", "", "secondPassword", "isValidLength", AppMeasurementSdk.ConditionalUserProperty.VALUE, "isValidLetters", "isValidNumbersContains", "isValidSecondPassword", "recoverPassword", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateBeforeSubmit", "state", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "action", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validatePassword", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BasePasswordCreateInteractorImpl implements BasePasswordCreateInteractor {
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractorImpl", f = "BasePasswordCreateInteractor.kt", l = {78, 85}, m = "recoverPassword")
    public static final class a extends ContinuationImpl {
        public BasePasswordCreateInteractorImpl a;
        public String b;
        public String c;
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
            return BasePasswordCreateInteractorImpl.this.recoverPassword(null, null, this);
        }
    }

    public BasePasswordCreateInteractorImpl(PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.passwordRecoveryRepository = passwordRecoveryRepository;
        this.serverTimeRepository = serverTimeRepository;
    }

    private final PasswordCreate.Action handlePasswordRecoverySetPasswordResponse(PasswordRecoverySetPasswordResponse response) {
        if (response instanceof PasswordRecoverySetPasswordSuccessResponse) {
            return new PasswordCreate.Action.SetPasswordSuccess(((PasswordRecoverySetPasswordSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordRecoverySetPasswordErrorResponse) {
            return new PasswordCreate.Action.SetPasswordFail(((PasswordRecoverySetPasswordErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean isValid(String firstPassword, String secondPassword) {
        return isValidLetters(firstPassword) && isValidLength(firstPassword) && isValidNumbersContains(firstPassword) && isValidSecondPassword(firstPassword, secondPassword);
    }

    private final boolean isValidLength(String value) {
        int length = StringsKt.trim(value).toString().length();
        return 8 <= length && length < 31;
    }

    private final boolean isValidLetters(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i))) {
                for (int i2 = 0; i2 < value.length(); i2++) {
                    if (Character.isLowerCase(value.charAt(i2))) {
                        return BasePasswordCreateInteractorKt.REGEX_VALID_SYMBOLS.matches(value);
                    }
                }
                return false;
            }
        }
        return false;
    }

    private final boolean isValidNumbersContains(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isValidSecondPassword(String firstPassword, String secondPassword) {
        return Intrinsics.areEqual(firstPassword, secondPassword) && secondPassword.length() > 0;
    }

    @Override // ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractor
    public final Object generatePassword(Continuation<? super PasswordCreate.Action> continuation) {
        return new PasswordCreate.Action.SetGeneratedPassword(RandomPasswordGenerator.INSTANCE.generate(8));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object recoverPassword(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.create.PasswordCreate.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractorImpl.recoverPassword(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractor
    public final Object validateBeforeSubmit(PasswordCreate.State.Content content, PasswordCreate.Action.ValidateBeforeSubmit validateBeforeSubmit, Continuation<? super PasswordCreate.Action> continuation) {
        OffsetDateTime expireAt = validateBeforeSubmit.getExpireAt();
        if (expireAt != null && expireAt.isBefore(this.serverTimeRepository.getCurrentDateTime())) {
            return PasswordCreate.Action.Expired.INSTANCE;
        }
        if (isValid(content.getFirstPassword(), content.getSecondPassword())) {
            return new PasswordCreate.Action.Submit(validateBeforeSubmit.getProcessType(), validateBeforeSubmit.getProcessId());
        }
        return new PasswordCreate.Action.PasswordsIsInvalid(isValidLetters(content.getFirstPassword()) && isValidLength(content.getFirstPassword()) && isValidNumbersContains(content.getFirstPassword()), isValidSecondPassword(content.getFirstPassword(), content.getSecondPassword()));
    }

    @Override // ru.yoomoney.sdk.auth.password.create.impl.BasePasswordCreateInteractor
    public final PasswordCreate.Action validatePassword(String firstPassword) {
        Intrinsics.checkNotNullParameter(firstPassword, "firstPassword");
        return new PasswordCreate.Action.SetValidationResult(isValidLetters(firstPassword), isValidLength(firstPassword), isValidNumbersContains(firstPassword));
    }
}
