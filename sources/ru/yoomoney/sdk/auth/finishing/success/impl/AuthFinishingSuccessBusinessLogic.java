package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\"\u0010#R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;", "interactor", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingAnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingAnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Progress;", "state", "action", "handleProgressState", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Progress;Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$Content;Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAccount;", "handleErrorAccountState", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAccount;Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAcquire;", "handleErrorAcquireState", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State$ErrorAcquire;Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingAnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingSuccessBusinessLogic implements Function2<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, Out<? extends AuthFinishingSuccess.State, ? extends AuthFinishingSuccess.Action>> {
    private final AuthFinishingAnalyticsLogger analyticsLogger;
    private final AuthFinishingSuccessInteractor interactor;
    private final Function2<AuthFinishingSuccess.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<AuthFinishingSuccess.State, Continuation<? super AuthFinishingSuccess.Action>, Object> showState;
    private final Function1<Continuation<? super AuthFinishingSuccess.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.a(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.b(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.c(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.d(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.e(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.f(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Content, AuthFinishingSuccess.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Content, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Content, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.g(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.h(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthFinishingSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.ErrorAcquire, AuthFinishingSuccess.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.ErrorAcquire, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.ErrorAcquire, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.i(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.j(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthFinishingSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.finishing.success.impl.k(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthFinishingSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.ErrorAccount, AuthFinishingSuccess.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.ErrorAccount, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.ErrorAccount, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new l(AuthFinishingSuccessBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new m(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthFinishingSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action>, Unit> {
        public final /* synthetic */ AuthFinishingSuccess.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AuthFinishingSuccess.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> builder) {
            Out.Builder<? extends AuthFinishingSuccess.State.Progress, AuthFinishingSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new n(AuthFinishingSuccessBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthFinishingSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthFinishingSuccessBusinessLogic(Function2<? super AuthFinishingSuccess.State, ? super Continuation<? super AuthFinishingSuccess.Action>, ? extends Object> showState, Function2<? super AuthFinishingSuccess.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super AuthFinishingSuccess.Action>, ? extends Object> source, AuthFinishingSuccessInteractor interactor, AuthFinishingAnalyticsLogger authFinishingAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.analyticsLogger = authFinishingAnalyticsLogger;
    }

    private final Out<AuthFinishingSuccess.State, AuthFinishingSuccess.Action> handleContentState(AuthFinishingSuccess.State.Content state, AuthFinishingSuccess.Action action) {
        return action instanceof AuthFinishingSuccess.Action.LoadAcquire ? Out.INSTANCE.invoke(AuthFinishingSuccess.State.Progress.INSTANCE, new a(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuthFinishingSuccess.State, AuthFinishingSuccess.Action> handleErrorAccountState(AuthFinishingSuccess.State.ErrorAccount state, AuthFinishingSuccess.Action action) {
        return action instanceof AuthFinishingSuccess.Action.LoadAccount ? Out.INSTANCE.invoke(AuthFinishingSuccess.State.Progress.INSTANCE, new b(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuthFinishingSuccess.State, AuthFinishingSuccess.Action> handleErrorAcquireState(AuthFinishingSuccess.State.ErrorAcquire state, AuthFinishingSuccess.Action action) {
        return action instanceof AuthFinishingSuccess.Action.LoadAcquire ? Out.INSTANCE.invoke(AuthFinishingSuccess.State.Progress.INSTANCE, new c(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuthFinishingSuccess.State, AuthFinishingSuccess.Action> handleProgressState(AuthFinishingSuccess.State.Progress state, AuthFinishingSuccess.Action action) {
        Out.Companion companion;
        Function kVar;
        Out.Companion companion2;
        AuthFinishingSuccess.State errorAccount;
        Function iVar;
        if (!(action instanceof AuthFinishingSuccess.Action.LoadAppInfo)) {
            if (action instanceof AuthFinishingSuccess.Action.LoadAcquire) {
                companion = Out.INSTANCE;
                kVar = new e(action);
            } else if (action instanceof AuthFinishingSuccess.Action.FailAcquire) {
                companion2 = Out.INSTANCE;
                errorAccount = new AuthFinishingSuccess.State.ErrorAcquire(((AuthFinishingSuccess.Action.FailAcquire) action).getFailure());
                iVar = new f();
            } else if (action instanceof AuthFinishingSuccess.Action.LoadAccount) {
                companion = Out.INSTANCE;
                kVar = new g(action);
            } else if (action instanceof AuthFinishingSuccess.Action.SuccessAccount) {
                companion = Out.INSTANCE;
                kVar = new h(action);
            } else if (action instanceof AuthFinishingSuccess.Action.FailAccount) {
                companion2 = Out.INSTANCE;
                AuthFinishingSuccess.Action.FailAccount failAccount = (AuthFinishingSuccess.Action.FailAccount) action;
                errorAccount = new AuthFinishingSuccess.State.ErrorAccount(failAccount.getAccessToken(), failAccount.getFailure());
                iVar = new i();
            } else if (action instanceof AuthFinishingSuccess.Action.NextStep) {
                companion = Out.INSTANCE;
                kVar = new j(action);
            } else {
                if (!(action instanceof AuthFinishingSuccess.Action.NextRegistrationStep)) {
                    throw new NoWhenBranchMatchedException();
                }
                companion = Out.INSTANCE;
                kVar = new k(action);
            }
            return companion.invoke(state, kVar);
        }
        companion2 = Out.INSTANCE;
        errorAccount = new AuthFinishingSuccess.State.Content(((AuthFinishingSuccess.Action.LoadAppInfo) action).getApplicationInfo());
        iVar = new d();
        return companion2.invoke(errorAccount, iVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<AuthFinishingSuccess.State, AuthFinishingSuccess.Action> invoke(AuthFinishingSuccess.State state, AuthFinishingSuccess.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        AuthFinishingAnalyticsLogger authFinishingAnalyticsLogger = this.analyticsLogger;
        if (authFinishingAnalyticsLogger != null) {
            authFinishingAnalyticsLogger.invoke(state, action);
        }
        if (state instanceof AuthFinishingSuccess.State.Progress) {
            return handleProgressState((AuthFinishingSuccess.State.Progress) state, action);
        }
        if (state instanceof AuthFinishingSuccess.State.Content) {
            return handleContentState((AuthFinishingSuccess.State.Content) state, action);
        }
        if (state instanceof AuthFinishingSuccess.State.ErrorAccount) {
            return handleErrorAccountState((AuthFinishingSuccess.State.ErrorAccount) state, action);
        }
        if (state instanceof AuthFinishingSuccess.State.ErrorAcquire) {
            return handleErrorAcquireState((AuthFinishingSuccess.State.ErrorAcquire) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
