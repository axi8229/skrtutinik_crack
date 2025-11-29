package ru.yoomoney.sdk.auth.select.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.select.SelectAccount;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/select/impl/SelectAccountBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractor;", "interactor", "Lru/yoomoney/sdk/auth/select/SelectAccount$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractor;Lru/yoomoney/sdk/auth/select/SelectAccount$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/select/SelectAccount$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/select/SelectAccount$State$Content;Lru/yoomoney/sdk/auth/select/SelectAccount$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/select/SelectAccount$State;Lru/yoomoney/sdk/auth/select/SelectAccount$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractor;", "Lru/yoomoney/sdk/auth/select/SelectAccount$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountBusinessLogic implements Function2<SelectAccount.State, SelectAccount.Action, Out<? extends SelectAccount.State, ? extends SelectAccount.Action>> {
    private final SelectAccount.AnalyticsLogger analyticsLogger;
    private final SelectAccountInteractor interactor;
    private final Function2<SelectAccount.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<SelectAccount.State, Continuation<? super SelectAccount.Action>, Object> showState;
    private final Function1<Continuation<? super SelectAccount.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.b(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.c(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.select.impl.a(SelectAccountBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.select.impl.d(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.e(SelectAccountBusinessLogic.this, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.select.impl.f(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.g(SelectAccountBusinessLogic.this, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.h(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.i(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.j(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action>, Unit> {
        public final /* synthetic */ SelectAccount.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SelectAccount.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> builder) {
            Out.Builder<? extends SelectAccount.State.Content, SelectAccount.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.select.impl.k(SelectAccountBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SelectAccountBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectAccountBusinessLogic(Function2<? super SelectAccount.State, ? super Continuation<? super SelectAccount.Action>, ? extends Object> showState, Function2<? super SelectAccount.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super SelectAccount.Action>, ? extends Object> source, SelectAccountInteractor interactor, SelectAccount.AnalyticsLogger analyticsLogger) {
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

    private final Out<SelectAccount.State, SelectAccount.Action> handleContentState(SelectAccount.State.Content state, SelectAccount.Action action) {
        Out.Companion companion;
        Function bVar;
        Out.Companion companion2;
        Function gVar;
        if (action instanceof SelectAccount.Action.ShowContent) {
            return Out.INSTANCE.invoke(SelectAccount.State.Content.INSTANCE, new c());
        }
        if (!(action instanceof SelectAccount.Action.CreateNewAccount)) {
            if (action instanceof SelectAccount.Action.Expired) {
                companion2 = Out.INSTANCE;
                gVar = new e();
            } else if (action instanceof SelectAccount.Action.SelectAccount) {
                companion = Out.INSTANCE;
                bVar = new f(action);
            } else if (action instanceof SelectAccount.Action.RestartProcess) {
                companion2 = Out.INSTANCE;
                gVar = new g();
            } else if (action instanceof SelectAccount.Action.SelectAccountSuccess) {
                companion = Out.INSTANCE;
                bVar = new h(action);
            } else if (action instanceof SelectAccount.Action.RegistrationSuccess) {
                companion = Out.INSTANCE;
                bVar = new i(action);
            } else if (action instanceof SelectAccount.Action.ShowFailure) {
                companion = Out.INSTANCE;
                bVar = new j(action);
            } else if (action instanceof SelectAccount.Action.MigrateAccount) {
                companion = Out.INSTANCE;
                bVar = new k(action);
            } else if (action instanceof SelectAccount.Action.PasswordRecoverySelectAccountSuccess) {
                companion = Out.INSTANCE;
                bVar = new a(action);
            } else {
                if (!(action instanceof SelectAccount.Action.EnrollmentSuccess)) {
                    return Out.INSTANCE.skip(state, this.source);
                }
                companion = Out.INSTANCE;
                bVar = new b(action);
            }
            return companion2.invoke(state, gVar);
        }
        companion = Out.INSTANCE;
        bVar = new d(action);
        return companion.invoke(state, bVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<SelectAccount.State, SelectAccount.Action> invoke(SelectAccount.State state, SelectAccount.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        SelectAccount.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof SelectAccount.State.Content) {
            return handleContentState((SelectAccount.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
