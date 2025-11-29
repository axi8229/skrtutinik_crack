package ru.yoomoney.sdk.auth.auxToken.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractorImpl;", "Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "auxAuthorizationRepository", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "(Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;Lru/yoomoney/sdk/auth/api/account/AccountRepository;)V", "auxAuthorization", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auxAuthorizationInfo", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssueInteractorImpl implements AuxTokenIssueInteractor {
    private final AccountRepository accountRepository;
    private final AuxAuthorizationRepository auxAuthorizationRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl", f = "AuxTokenIssueInteractor.kt", l = {50}, m = "auxAuthorization")
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
            return AuxTokenIssueInteractorImpl.this.auxAuthorization(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl", f = "AuxTokenIssueInteractor.kt", l = {33, 34}, m = "auxAuthorizationInfo")
    public static final class b extends ContinuationImpl {
        public Object a;
        public String b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return AuxTokenIssueInteractorImpl.this.auxAuthorizationInfo(null, null, null, this);
        }
    }

    public AuxTokenIssueInteractorImpl(AuxAuthorizationRepository auxAuthorizationRepository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(auxAuthorizationRepository, "auxAuthorizationRepository");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        this.auxAuthorizationRepository = auxAuthorizationRepository;
        this.accountRepository = accountRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object auxAuthorization(java.lang.String r5, java.util.List<? extends ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope> r6, java.lang.String r7, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue.Action> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository r8 = r4.auxAuthorizationRepository
            r0.c = r3
            java.lang.Object r5 = r8.mo3241auxAuthorizationBWLJW6A(r5, r6, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L53
            ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken r5 = (ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken) r5
            ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$AuxTokenIssued r6 = new ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$AuxTokenIssued
            r6.<init>(r5)
            goto L60
        L53:
            ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$AuxTokenIssueFailed r5 = new ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$AuxTokenIssueFailed
            java.lang.String r7 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.auxAuthorization(java.lang.String, java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object auxAuthorizationInfo(java.lang.String r7, java.util.List<? extends ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope> r8, java.lang.String r9, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue.Action> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r8 = r10.getValue()
            goto L75
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.String r7 = r0.b
            java.lang.Object r8 = r0.a
            ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl r8 = (ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl) r8
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r9 = r10.getValue()
            r5 = r9
            r9 = r8
            r8 = r5
            goto L62
        L4f:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository r10 = r6.auxAuthorizationRepository
            r0.a = r6
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r10.mo3242auxAuthorizationInfoBWLJW6A(r7, r8, r9, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            r9 = r6
        L62:
            ru.yoomoney.sdk.auth.api.account.AccountRepository r9 = r9.accountRepository
            r0.a = r8
            r10 = 0
            r0.b = r10
            r0.e = r3
            java.lang.Object r7 = r9.mo3209accountgIAlus(r7, r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            r5 = r8
            r8 = r7
            r7 = r5
        L75:
            boolean r9 = kotlin.Result.m2633isFailureimpl(r8)
            java.lang.String r10 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            if (r9 == 0) goto L8c
            ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed r7 = new ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed
            java.lang.Throwable r8 = kotlin.Result.m2631exceptionOrNullimpl(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r10)
            ru.yoomoney.sdk.auth.api.model.Failure r8 = (ru.yoomoney.sdk.auth.api.model.Failure) r8
            r7.<init>(r8)
            goto Lb2
        L8c:
            boolean r9 = kotlin.Result.m2633isFailureimpl(r7)
            if (r9 == 0) goto La2
            ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed r8 = new ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r10)
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            r8.<init>(r7)
            r7 = r8
            goto Lb2
        La2:
            ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoSuccess r9 = new ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue$Action$LoadAuxAuthorizationInfoSuccess
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r8 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r8
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.model.ApplicationInfo r7 = (ru.yoomoney.sdk.auth.api.model.ApplicationInfo) r7
            r9.<init>(r8, r7)
            r7 = r9
        Lb2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl.auxAuthorizationInfo(java.lang.String, java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
