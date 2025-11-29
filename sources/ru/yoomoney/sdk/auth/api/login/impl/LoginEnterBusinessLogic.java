package ru.yoomoney.sdk.auth.api.login.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.login.LoginEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterInteractor;", "interactor", "Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterAnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterInteractor;Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterAnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Content;Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/api/login/LoginEnter$State$Progress;Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterInteractor;", "Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterAnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginEnterBusinessLogic implements Function2<LoginEnter.State, LoginEnter.Action, Out<? extends LoginEnter.State, ? extends LoginEnter.Action>> {
    private final LoginEnterAnalyticsLogger analyticsLogger;
    private final LoginEnterInteractor interactor;
    private final Function2<LoginEnter.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<LoginEnter.State, Continuation<? super LoginEnter.Action>, Object> showState;
    private final Function1<Continuation<? super LoginEnter.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.api.login.impl.a(LoginEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public final /* synthetic */ LoginEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LoginEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.api.login.impl.b(LoginEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, LoginEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Progress, LoginEnter.Action>, Unit> {
        public final /* synthetic */ LoginEnter.State.Content b;
        public final /* synthetic */ LoginEnter.Action c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LoginEnter.State.Content content, LoginEnter.Action action) {
            super(1);
            this.b = content;
            this.c = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Progress, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Progress, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.api.login.impl.c(LoginEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.api.login.impl.d(LoginEnterBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.api.login.impl.e(LoginEnterBusinessLogic.this, null));
            CoreKt.input(invoke, LoginEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.api.login.impl.f(LoginEnterBusinessLogic.this, null));
            CoreKt.input(invoke, LoginEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.api.login.impl.g(LoginEnterBusinessLogic.this, null));
            CoreKt.input(invoke, LoginEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public final /* synthetic */ LoginEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(LoginEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.api.login.impl.h(LoginEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new i(LoginEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action>, Unit> {
        public final /* synthetic */ LoginEnter.Action b;
        public final /* synthetic */ LoginEnter.State.Progress c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(LoginEnter.Action action, LoginEnter.State.Progress progress) {
            super(1);
            this.b = action;
            this.c = progress;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> builder) {
            Out.Builder<? extends LoginEnter.State.Content, LoginEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new j(LoginEnterBusinessLogic.this, this.b, this.c, null));
            CoreKt.input(invoke, new k(LoginEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginEnterBusinessLogic(Function2<? super LoginEnter.State, ? super Continuation<? super LoginEnter.Action>, ? extends Object> showState, Function2<? super LoginEnter.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super LoginEnter.Action>, ? extends Object> source, LoginEnterInteractor interactor, LoginEnterAnalyticsLogger loginEnterAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.analyticsLogger = loginEnterAnalyticsLogger;
    }

    private final Out<LoginEnter.State, LoginEnter.Action> handleContentState(LoginEnter.State.Content state, LoginEnter.Action action) {
        Out.Companion companion;
        Function fVar;
        if (action instanceof LoginEnter.Action.LoginChanged) {
            return Out.INSTANCE.invoke(state.copy(((LoginEnter.Action.LoginChanged) action).getValue()), new a());
        }
        if (action instanceof LoginEnter.Action.CheckExpiration) {
            return Out.INSTANCE.invoke(state, new b(action));
        }
        if (action instanceof LoginEnter.Action.Submit) {
            return Out.INSTANCE.invoke(new LoginEnter.State.Progress(state.getValue()), new c(state, action));
        }
        if (action instanceof LoginEnter.Action.RestartProcess) {
            companion = Out.INSTANCE;
            fVar = new d();
        } else if (action instanceof LoginEnter.Action.ShowMigrationDescriptionScreen) {
            companion = Out.INSTANCE;
            fVar = new e();
        } else {
            if (!(action instanceof LoginEnter.Action.Expired)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            fVar = new f();
        }
        return companion.invoke(state, fVar);
    }

    private final Out<LoginEnter.State, LoginEnter.Action> handleProgressState(LoginEnter.State.Progress state, LoginEnter.Action action) {
        return action instanceof LoginEnter.Action.EnterIdentifierSuccess ? Out.INSTANCE.invoke(new LoginEnter.State.Content(state.getValue()), new g(action)) : action instanceof LoginEnter.Action.LoginEnterFailure ? Out.INSTANCE.invoke(new LoginEnter.State.Content(state.getValue()), new h(action, state)) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<LoginEnter.State, LoginEnter.Action> invoke(LoginEnter.State state, LoginEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        LoginEnterAnalyticsLogger loginEnterAnalyticsLogger = this.analyticsLogger;
        if (loginEnterAnalyticsLogger != null) {
            loginEnterAnalyticsLogger.invoke(state, action);
        }
        if (state instanceof LoginEnter.State.Content) {
            return handleContentState((LoginEnter.State.Content) state, action);
        }
        if (state instanceof LoginEnter.State.Progress) {
            return handleProgressState((LoginEnter.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
