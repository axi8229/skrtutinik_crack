package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/AccountPhoneConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/AccountPhoneConfirmInteractor;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractorImpl;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "phoneChangeRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "changeEmailConfirmPhone", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "code", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmailConfirmPhoneForgot", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmailConfirmPhoneResend", "changePasswordConfirmPhone", "changePasswordConfirmPhoneForgot", "changePasswordConfirmPhoneResend", "changePhoneConfirmPhone", "changePhoneConfirmPhoneForgot", "changePhoneConfirmPhoneResend", "confirmPhone", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPhoneConfirmInteractorImpl extends BasePhoneConfirmInteractorImpl implements AccountPhoneConfirmInteractor {
    private final EmailChangeRepository emailChangeRepository;
    private final PasswordChangeRepository passwordChangeRepository;
    private final PhoneChangeRepository phoneChangeRepository;

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
                iArr[ProcessType.CHANGE_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.CHANGE_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {72, 79}, m = "changeEmailConfirmPhone")
    public static final class a extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changeEmailConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {244, 249}, m = "changeEmailConfirmPhoneForgot")
    public static final class b extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changeEmailConfirmPhoneForgot(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {159, 163}, m = "changeEmailConfirmPhoneResend")
    public static final class c extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changeEmailConfirmPhoneResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {124, pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6}, m = "changePasswordConfirmPhone")
    public static final class d extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changePasswordConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {292, 297}, m = "changePasswordConfirmPhoneForgot")
    public static final class e extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changePasswordConfirmPhoneForgot(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {211, 215}, m = "changePasswordConfirmPhoneResend")
    public static final class f extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
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
            return AccountPhoneConfirmInteractorImpl.this.changePasswordConfirmPhoneResend(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {98, 105}, m = "changePhoneConfirmPhone")
    public static final class g extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AccountPhoneConfirmInteractorImpl.this.changePhoneConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {268, 273}, m = "changePhoneConfirmPhoneForgot")
    public static final class h extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountPhoneConfirmInteractorImpl.this.changePhoneConfirmPhoneForgot(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl", f = "AccountPhoneConfirmInteractor.kt", l = {186, 190}, m = "changePhoneConfirmPhoneResend")
    public static final class i extends ContinuationImpl {
        public AccountPhoneConfirmInteractorImpl a;
        public String b;
        public int c;
        public /* synthetic */ Object d;
        public int f;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AccountPhoneConfirmInteractorImpl.this.changePhoneConfirmPhoneResend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPhoneConfirmInteractorImpl(EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        super(serverTimeRepository, passwordRecoveryRepository);
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(phoneChangeRepository, "phoneChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.emailChangeRepository = emailChangeRepository;
        this.phoneChangeRepository = phoneChangeRepository;
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changeEmailConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmPhoneForgot(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changeEmailConfirmPhoneForgot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeEmailConfirmPhoneResend(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changeEmailConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePasswordConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmPhoneForgot(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePasswordConfirmPhoneForgot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePasswordConfirmPhoneResend(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePasswordConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePhoneConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePhoneConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePhoneConfirmPhoneForgot(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePhoneConfirmPhoneForgot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a5 -> B:45:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changePhoneConfirmPhoneResend(java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl.changePhoneConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhone(PhoneConfirm.Action.CodeValid codeValid, Continuation<? super PhoneConfirm.Action> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[codeValid.getProcessType().ordinal()];
        if (i2 == 1) {
            return changeEmailConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i2 == 2) {
            return changePhoneConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i2 == 3) {
            return changePasswordConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        if (i2 == 4) {
            return passwordRecoveryConfirmPhone(codeValid.getValue(), codeValid.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhoneForgot(PhoneConfirm.Action.Forgot forgot, Continuation<? super PhoneConfirm.Action> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[forgot.getProcessType().ordinal()];
        if (i2 == 1) {
            return changeEmailConfirmPhoneForgot(forgot.getProcessId(), continuation);
        }
        if (i2 == 2) {
            return changePhoneConfirmPhoneForgot(forgot.getProcessId(), continuation);
        }
        if (i2 == 3) {
            return changePasswordConfirmPhoneForgot(forgot.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public Object confirmPhoneResend(PhoneConfirm.Action.Retry retry, Continuation<? super PhoneConfirm.Action> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[retry.getProcessType().ordinal()];
        if (i2 == 1) {
            return changeEmailConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i2 == 2) {
            return changePhoneConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i2 == 3) {
            return changePasswordConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        if (i2 == 4) {
            return passwordRecoveryConfirmPhoneResend(retry.getProcessId(), continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
