package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/password/create/impl/PasswordCreateBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractor;", "interactor", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractor;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Progress;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractor;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordCreateBusinessLogic implements Function2<PasswordCreate.State, PasswordCreate.Action, Out<? extends PasswordCreate.State, ? extends PasswordCreate.Action>> {
    private final PasswordCreate.AnalyticsLogger analyticsLogger;
    private final BasePasswordCreateInteractor interactor;
    private final Function2<PasswordCreate.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PasswordCreate.State, Continuation<? super PasswordCreate.Action>, Object> showState;
    private final Function1<Continuation<? super PasswordCreate.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.a(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PasswordCreateBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.b(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.c(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreateBusinessLogic a;
        public final /* synthetic */ PasswordCreate.State.Content b;
        public final /* synthetic */ PasswordCreate.Action c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PasswordCreate.Action action, PasswordCreate.State.Content content, PasswordCreateBusinessLogic passwordCreateBusinessLogic) {
            super(1);
            this.a = passwordCreateBusinessLogic;
            this.b = content;
            this.c = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            PasswordCreateBusinessLogic passwordCreateBusinessLogic = this.a;
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.d(null, this.c, this.b, passwordCreateBusinessLogic));
            CoreKt.input(invoke, this.a.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.create.impl.e(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PasswordCreateBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Progress, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreateBusinessLogic a;
        public final /* synthetic */ PasswordCreate.Action b;
        public final /* synthetic */ PasswordCreate.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PasswordCreate.Action action, PasswordCreate.State.Content content, PasswordCreateBusinessLogic passwordCreateBusinessLogic) {
            super(1);
            this.a = passwordCreateBusinessLogic;
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Progress, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Progress, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.f(this.a, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.g(null, this.b, this.c, this.a));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.create.impl.h(PasswordCreateBusinessLogic.this, null));
            CoreKt.input(invoke, PasswordCreateBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, PasswordCreateBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.i(PasswordCreateBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, PasswordCreateBusinessLogic.this.source);
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.create.impl.j(PasswordCreateBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.create.impl.k(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.create.impl.l(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.create.impl.m(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new n(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new o(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new p(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action>, Unit> {
        public final /* synthetic */ PasswordCreate.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PasswordCreate.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> builder) {
            Out.Builder<? extends PasswordCreate.State.Content, PasswordCreate.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new q(PasswordCreateBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new r(PasswordCreateBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PasswordCreateBusinessLogic(Function2<? super PasswordCreate.State, ? super Continuation<? super PasswordCreate.Action>, ? extends Object> showState, Function2<? super PasswordCreate.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PasswordCreate.Action>, ? extends Object> source, BasePasswordCreateInteractor interactor, PasswordCreate.AnalyticsLogger analyticsLogger) {
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

    private final Out<PasswordCreate.State, PasswordCreate.Action> handleContentState(PasswordCreate.State.Content state, PasswordCreate.Action action) {
        Out.Companion companion;
        Function iVar;
        Out.Companion companion2;
        Function hVar;
        Out.Companion companion3;
        PasswordCreate.State.Content contentCopy$default;
        Function cVar;
        if (!(action instanceof PasswordCreate.Action.FirstPasswordChanged)) {
            if (action instanceof PasswordCreate.Action.SecondPasswordChanged) {
                companion3 = Out.INSTANCE;
                contentCopy$default = PasswordCreate.State.Content.copy$default(state, null, ((PasswordCreate.Action.SecondPasswordChanged) action).getValue(), false, false, false, 29, null);
                cVar = new b();
            } else if (action instanceof PasswordCreate.Action.SetValidationResult) {
                companion3 = Out.INSTANCE;
                PasswordCreate.Action.SetValidationResult setValidationResult = (PasswordCreate.Action.SetValidationResult) action;
                contentCopy$default = PasswordCreate.State.Content.copy$default(state, null, null, setValidationResult.isValidLetters(), setValidationResult.isValidLength(), setValidationResult.isValidNumbersContains(), 3, null);
                cVar = new c();
            } else if (action instanceof PasswordCreate.Action.ValidateBeforeSubmit) {
                companion = Out.INSTANCE;
                iVar = new d(action, state, this);
            } else {
                if (!(action instanceof PasswordCreate.Action.PasswordsIsInvalid)) {
                    if (action instanceof PasswordCreate.Action.Submit) {
                        return Out.INSTANCE.invoke(new PasswordCreate.State.Progress(state.getFirstPassword(), state.getSecondPassword()), new f(action, state, this));
                    }
                    if (action instanceof PasswordCreate.Action.RestartProcess) {
                        companion2 = Out.INSTANCE;
                        hVar = new g();
                    } else if (action instanceof PasswordCreate.Action.GeneratePassword) {
                        companion2 = Out.INSTANCE;
                        hVar = new h();
                    } else {
                        if (!(action instanceof PasswordCreate.Action.SetGeneratedPassword)) {
                            return Out.INSTANCE.skip(state, this.source);
                        }
                        companion = Out.INSTANCE;
                        PasswordCreate.Action.SetGeneratedPassword setGeneratedPassword = (PasswordCreate.Action.SetGeneratedPassword) action;
                        state = PasswordCreate.State.Content.copy$default(state, setGeneratedPassword.getPassword(), setGeneratedPassword.getPassword(), false, false, false, 28, null);
                        iVar = new i(action);
                    }
                    return companion2.invoke(state, hVar);
                }
                companion = Out.INSTANCE;
                iVar = new e(action);
            }
            return companion3.invoke(contentCopy$default, cVar);
        }
        companion = Out.INSTANCE;
        state = PasswordCreate.State.Content.copy$default(state, ((PasswordCreate.Action.FirstPasswordChanged) action).getValue(), null, false, false, false, 30, null);
        iVar = new a(action);
        return companion.invoke(state, iVar);
    }

    private final Out<PasswordCreate.State, PasswordCreate.Action> handleProgressState(PasswordCreate.State.Progress state, PasswordCreate.Action action) {
        Out.Companion companion;
        PasswordCreate.State.Content content;
        Function mVar;
        if (action instanceof PasswordCreate.Action.SetPasswordSuccess) {
            companion = Out.INSTANCE;
            content = new PasswordCreate.State.Content(state.getFirstPassword(), state.getSecondPassword(), false, false, false, 28, null);
            mVar = new j(action);
        } else if (action instanceof PasswordCreate.Action.RegistrationSetPasswordSuccess) {
            companion = Out.INSTANCE;
            content = new PasswordCreate.State.Content(state.getFirstPassword(), state.getSecondPassword(), false, false, false, 28, null);
            mVar = new k(action);
        } else if (action instanceof PasswordCreate.Action.SetPasswordFail) {
            companion = Out.INSTANCE;
            content = new PasswordCreate.State.Content(state.getFirstPassword(), state.getSecondPassword(), false, false, false, 28, null);
            mVar = new l(action);
        } else {
            if (!(action instanceof PasswordCreate.Action.PasswordCreateFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = new PasswordCreate.State.Content(state.getFirstPassword(), state.getSecondPassword(), false, false, false, 28, null);
            mVar = new m(action);
        }
        return companion.invoke(content, mVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PasswordCreate.State, PasswordCreate.Action> invoke(PasswordCreate.State state, PasswordCreate.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PasswordCreate.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PasswordCreate.State.Content) {
            return handleContentState((PasswordCreate.State.Content) state, action);
        }
        if (state instanceof PasswordCreate.State.Progress) {
            return handleProgressState((PasswordCreate.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
