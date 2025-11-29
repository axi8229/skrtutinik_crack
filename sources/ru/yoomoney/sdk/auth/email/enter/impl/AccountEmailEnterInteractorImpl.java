package ru.yoomoney.sdk.auth.email.enter.impl;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/AccountEmailEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/email/enter/impl/AccountEmailEnterInteractor;", "Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractorImpl;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "changeEmail", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", Scopes.EMAIL, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEmailChangeSetEmailResponse", "response", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailResponse;", "registrationConfirmEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmail", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountEmailEnterInteractorImpl extends BaseEmailEnterInteractorImpl implements AccountEmailEnterInteractor {
    private final EmailChangeRepository emailChangeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractorImpl", f = "AccountEmailEnterInteractor.kt", l = {36, 43}, m = "changeEmail")
    public static final class a extends ContinuationImpl {
        public AccountEmailEnterInteractorImpl a;
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
            return AccountEmailEnterInteractorImpl.this.changeEmail(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountEmailEnterInteractorImpl(EmailChangeRepository emailChangeRepository, ServerTimeRepository serverTimeRepository) {
        super(serverTimeRepository);
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.emailChangeRepository = emailChangeRepository;
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
    public final java.lang.Object changeEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.enter.EmailEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractorImpl.changeEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final EmailEnter.Action handleEmailChangeSetEmailResponse(EmailChangeSetEmailResponse response) {
        if (response instanceof EmailChangeSetEmailSuccessResponse) {
            return new EmailEnter.Action.SendEmailSuccess(((EmailChangeSetEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof EmailChangeSetEmailErrorResponse) {
            return new EmailEnter.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((EmailChangeSetEmailErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    public Object registrationConfirmEmail(String str, Continuation<? super EmailEnter.Action> continuation) {
        throw new IllegalArgumentException("no command for interaction " + this);
    }

    @Override // ru.yoomoney.sdk.auth.email.enter.impl.BaseEmailEnterInteractor
    public Object sendEmail(EmailEnter.Action.SendEmail sendEmail, String str, Continuation<? super EmailEnter.Action> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[sendEmail.getProcessType().ordinal()] == 1) {
            return changeEmail(sendEmail.getProcessId(), str, continuation);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }
}
