package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotErrorResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotErrorResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\r2\u0006\u0010#\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010#\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010#\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/AccountEmailConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/email/confirm/impl/AccountEmailConfirmInteractor;", "Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractorImpl;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "changeEmailConfirmEmail", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "code", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmailConfirmEmailForgot", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmailConfirmEmailResend", "changePasswordConfirmEmail", "changePasswordConfirmEmailForgot", "changePasswordConfirmEmailResend", "confirmEmail", "action", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmailChangeConfirmEmailForgotResponse", "response", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailForgotResponse;", "handleEmailChangeConfirmEmailResendResponse", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResendResponse;", "handleEmailChangeConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResponse;", "handlePasswordChangeConfirmEmailForgotResponse", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailForgotResponse;", "handlePasswordChangeConfirmEmailResendResponse", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResendResponse;", "handlePasswordChangeConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountEmailConfirmInteractorImpl extends BaseEmailConfirmInteractorImpl implements AccountEmailConfirmInteractor {
    private final EmailChangeRepository emailChangeRepository;
    private final PasswordChangeRepository passwordChangeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.CHANGE_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {110, 117}, m = "changeEmailConfirmEmail")
    public static final class a extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
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
            return AccountEmailConfirmInteractorImpl.this.changeEmailConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {152, 158}, m = "changeEmailConfirmEmailForgot")
    public static final class b extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountEmailConfirmInteractorImpl.this.changeEmailConfirmEmailForgot(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {70, 76}, m = "changeEmailConfirmEmailResend")
    public static final class c extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountEmailConfirmInteractorImpl.this.changeEmailConfirmEmailResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6, 138}, m = "changePasswordConfirmEmail")
    public static final class d extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AccountEmailConfirmInteractorImpl.this.changePasswordConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {172, 178}, m = "changePasswordConfirmEmailForgot")
    public static final class e extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountEmailConfirmInteractorImpl.this.changePasswordConfirmEmailForgot(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl", f = "AccountEmailConfirmInteractor.kt", l = {90, 96}, m = "changePasswordConfirmEmailResend")
    public static final class f extends ContinuationImpl {
        public AccountEmailConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountEmailConfirmInteractorImpl.this.changePasswordConfirmEmailResend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountEmailConfirmInteractorImpl(EmailChangeRepository emailChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(passwordRecoveryRepository, serverTimeRepository);
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.emailChangeRepository = emailChangeRepository;
        this.passwordChangeRepository = passwordChangeRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changeEmailConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmEmailForgot(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changeEmailConfirmEmailForgot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmEmailResend(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changeEmailConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changePasswordConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmEmailForgot(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changePasswordConfirmEmailForgot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmEmailResend(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractorImpl.changePasswordConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final EmailConfirm.Action handleEmailChangeConfirmEmailForgotResponse(EmailChangeConfirmEmailForgotResponse response) {
        if (response instanceof EmailChangeConfirmEmailForgotSuccessResponse) {
            return new EmailConfirm.Action.ForgotEmailSuccess(((EmailChangeConfirmEmailForgotSuccessResponse) response).getProcess());
        }
        if (response instanceof EmailChangeConfirmEmailForgotErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailTechnicalError(ProcessErrorExtensionsKt.toFailure(((EmailChangeConfirmEmailForgotErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleEmailChangeConfirmEmailResendResponse(EmailChangeConfirmEmailResendResponse response) {
        if (response instanceof EmailChangeConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((EmailChangeConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof EmailChangeConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((EmailChangeConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handleEmailChangeConfirmEmailResponse(EmailChangeConfirmEmailResponse response) {
        if (response instanceof EmailChangeConfirmEmailSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((EmailChangeConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof EmailChangeConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((EmailChangeConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handlePasswordChangeConfirmEmailForgotResponse(PasswordChangeConfirmEmailForgotResponse response) {
        if (response instanceof PasswordChangeConfirmEmailForgotSuccessResponse) {
            return new EmailConfirm.Action.ForgotEmailSuccess(((PasswordChangeConfirmEmailForgotSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordChangeConfirmEmailForgotErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailTechnicalError(ProcessErrorExtensionsKt.toFailure(((PasswordChangeConfirmEmailForgotErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handlePasswordChangeConfirmEmailResendResponse(PasswordChangeConfirmEmailResendResponse response) {
        if (response instanceof PasswordChangeConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((PasswordChangeConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordChangeConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((PasswordChangeConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handlePasswordChangeConfirmEmailResponse(PasswordChangeConfirmEmailResponse response) {
        if (response instanceof PasswordChangeConfirmEmailSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((PasswordChangeConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordChangeConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((PasswordChangeConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmail(String str, EmailConfirm.Action.Submit submit, Continuation<? super EmailConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[submit.getProcessType().ordinal()];
        if (i == 1) {
            return changeEmailConfirmEmail(str, submit.getProcessId(), continuation);
        }
        if (i == 2) {
            return changePasswordConfirmEmail(str, submit.getProcessId(), continuation);
        }
        if (i == 3) {
            return passwordRecoveryConfirmEmail(str, submit.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmailForgot(EmailConfirm.Action.Forgot forgot, Continuation<? super EmailConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[forgot.getProcessType().ordinal()];
        if (i == 1) {
            return changeEmailConfirmEmailForgot(forgot.getProcessId(), continuation);
        }
        if (i == 2) {
            return changePasswordConfirmEmailForgot(forgot.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public Object confirmEmailResend(EmailConfirm.Action.Retry retry, Continuation<? super EmailConfirm.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[retry.getProcessType().ordinal()];
        if (i == 1) {
            return changeEmailConfirmEmailResend(retry.getProcessId(), continuation);
        }
        if (i == 2) {
            return changePasswordConfirmEmailResend(retry.getProcessId(), continuation);
        }
        if (i == 3) {
            return passwordRecoveryConfirmEmailResend(retry.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
