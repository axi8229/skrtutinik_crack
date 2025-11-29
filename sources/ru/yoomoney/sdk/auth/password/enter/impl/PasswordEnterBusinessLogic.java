package ru.yoomoney.sdk.auth.password.enter.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/PasswordEnterBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;", "interactor", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State$Content;Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State$Progress;Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State;Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordEnterBusinessLogic implements Function2<PasswordEnter.State, PasswordEnter.Action, Out<? extends PasswordEnter.State, ? extends PasswordEnter.Action>> {
    private final PasswordEnter.AnalyticsLogger analyticsLogger;
    private final BasePasswordEnterInteractor interactor;
    private final Function2<PasswordEnter.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PasswordEnter.State, Continuation<? super PasswordEnter.Action>, Object> showState;
    private final Function1<Continuation<? super PasswordEnter.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.a(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, PasswordEnterBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.b(PasswordEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.c(PasswordEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.d(PasswordEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.e(PasswordEnterBusinessLogic.this, null));
            CoreKt.input(invoke, PasswordEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.f(PasswordEnterBusinessLogic.this, null));
            CoreKt.input(invoke, PasswordEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Progress, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.g(PasswordEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.h(PasswordEnterBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.i(PasswordEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.j(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.k(PasswordEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.enter.impl.l(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new m(PasswordEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new n(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new o(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public final /* synthetic */ PasswordEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PasswordEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new p(PasswordEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new q(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action>, Unit> {
        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> builder) {
            Out.Builder<? extends PasswordEnter.State.Content, PasswordEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new r(PasswordEnterBusinessLogic.this, null));
            CoreKt.input(invoke, new s(PasswordEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PasswordEnterBusinessLogic(Function2<? super PasswordEnter.State, ? super Continuation<? super PasswordEnter.Action>, ? extends Object> showState, Function2<? super PasswordEnter.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PasswordEnter.Action>, ? extends Object> source, BasePasswordEnterInteractor interactor, PasswordEnter.AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.analyticsLogger = analyticsLogger;
    }

    private final Out<PasswordEnter.State, PasswordEnter.Action> handleContentState(PasswordEnter.State.Content state, PasswordEnter.Action action) {
        Out.Companion companion;
        Function eVar;
        if (action instanceof PasswordEnter.Action.PasswordChanged) {
            return Out.INSTANCE.invoke(state.copy(((PasswordEnter.Action.PasswordChanged) action).getPassword(), null), new a());
        }
        if (action instanceof PasswordEnter.Action.CheckExpiration) {
            return Out.INSTANCE.invoke(state, new b(action));
        }
        if (action instanceof PasswordEnter.Action.Submit) {
            return Out.INSTANCE.invoke(new PasswordEnter.State.Progress(state.getPassword()), new c(action));
        }
        if (action instanceof PasswordEnter.Action.RestartProcess) {
            companion = Out.INSTANCE;
            eVar = new d();
        } else {
            if (!(action instanceof PasswordEnter.Action.Expired)) {
                return action instanceof PasswordEnter.Action.PasswordRecovery ? Out.INSTANCE.invoke(new PasswordEnter.State.Progress(state.getPassword()), new f()) : Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            eVar = new e();
        }
        return companion.invoke(state, eVar);
    }

    private final Out<PasswordEnter.State, PasswordEnter.Action> handleProgressState(PasswordEnter.State.Progress state, PasswordEnter.Action action) {
        Out.Companion companion;
        PasswordEnter.State.Content content;
        Function kVar;
        if (action instanceof PasswordEnter.Action.EnterPasswordSuccess) {
            companion = Out.INSTANCE;
            content = new PasswordEnter.State.Content(state.getPassword(), null, 2, null);
            kVar = new g(action);
        } else if (action instanceof PasswordEnter.Action.PasswordRecoverySuccess) {
            companion = Out.INSTANCE;
            content = new PasswordEnter.State.Content(state.getPassword(), null, 2, null);
            kVar = new h(action);
        } else if (action instanceof PasswordEnter.Action.PasswordEnterFailure) {
            companion = Out.INSTANCE;
            content = new PasswordEnter.State.Content(state.getPassword(), null, 2, null);
            kVar = new i(action);
        } else {
            if (action instanceof PasswordEnter.Action.PasswordEnterFeatureFailure) {
                return Out.INSTANCE.invoke(new PasswordEnter.State.Content(state.getPassword(), ((PasswordEnter.Action.PasswordEnterFeatureFailure) action).getFailure()), new j());
            }
            if (!(action instanceof PasswordEnter.Action.PasswordRecoveryFailure)) {
                return action instanceof PasswordEnter.Action.PasswordRecoveryTechnicalFailure ? Out.INSTANCE.invoke(new PasswordEnter.State.Content(state.getPassword(), null, 2, null), new l()) : Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = new PasswordEnter.State.Content(state.getPassword(), null, 2, null);
            kVar = new k(action);
        }
        return companion.invoke(content, kVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PasswordEnter.State, PasswordEnter.Action> invoke(PasswordEnter.State state, PasswordEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PasswordEnter.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PasswordEnter.State.Content) {
            return handleContentState((PasswordEnter.State.Content) state, action);
        }
        if (state instanceof PasswordEnter.State.Progress) {
            return handleProgressState((PasswordEnter.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
