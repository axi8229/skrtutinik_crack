package ru.yoomoney.sdk.auth.nickname.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractorImpl;", "Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractor;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "(Lru/yoomoney/sdk/auth/api/account/AccountRepository;)V", "displayName", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "nickname", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NicknameInteractorImpl implements NicknameInteractor {
    private final AccountRepository accountRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl", f = "NicknameInteractor.kt", l = {15}, m = "displayName")
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return NicknameInteractorImpl.this.displayName(null, null, this);
        }
    }

    public NicknameInteractorImpl(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        this.accountRepository = accountRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object displayName(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.nickname.Nickname.Action> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.account.AccountRepository r7 = r4.accountRepository
            r0.c = r3
            java.lang.Object r5 = r7.mo3210displayName0E7RQCE(r5, r6, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L53
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r5 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r5
            ru.yoomoney.sdk.auth.nickname.Nickname$Action$SetNicknameSuccess r6 = new ru.yoomoney.sdk.auth.nickname.Nickname$Action$SetNicknameSuccess
            r6.<init>(r5)
            goto L60
        L53:
            ru.yoomoney.sdk.auth.nickname.Nickname$Action$SetNicknameFail r5 = new ru.yoomoney.sdk.auth.nickname.Nickname$Action$SetNicknameFail
            java.lang.String r7 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl.displayName(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
