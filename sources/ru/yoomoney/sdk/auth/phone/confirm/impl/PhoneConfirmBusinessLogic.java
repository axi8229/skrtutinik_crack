package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/PhoneConfirmBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractor;", "interactor", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractor;Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Content;", "state", "action", "processStateContentAction", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Content;Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Progress;", "processStateProgressAction", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Progress;Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractor;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneConfirmBusinessLogic implements Function2<PhoneConfirm.State, PhoneConfirm.Action, Out<? extends PhoneConfirm.State, ? extends PhoneConfirm.Action>> {
    private final PhoneConfirm.AnalyticsLogger analyticsLogger;
    private final BasePhoneConfirmInteractor interactor;
    private final Function2<PhoneConfirm.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PhoneConfirm.State, Continuation<? super PhoneConfirm.Action>, Object> showState;
    private final Function1<Continuation<? super PhoneConfirm.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.a(PhoneConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PhoneConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.b(PhoneConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.c(PhoneConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.d(PhoneConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.e(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.f(PhoneConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.g(PhoneConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.h(PhoneConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.i(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.j(PhoneConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.k(PhoneConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.l(PhoneConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.m(PhoneConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.n(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.confirm.impl.o(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new p(PhoneConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new q(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action>, Unit> {
        public m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new r(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action>, Unit> {
        public final /* synthetic */ PhoneConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PhoneConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Content, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new s(PhoneConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new t(PhoneConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action>, Unit> {
        public o() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> builder) {
            Out.Builder<? extends PhoneConfirm.State.Progress, PhoneConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new u(PhoneConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneConfirmBusinessLogic(Function2<? super PhoneConfirm.State, ? super Continuation<? super PhoneConfirm.Action>, ? extends Object> showState, Function2<? super PhoneConfirm.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PhoneConfirm.Action>, ? extends Object> source, BasePhoneConfirmInteractor interactor, PhoneConfirm.AnalyticsLogger analyticsLogger) {
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

    private final Out<PhoneConfirm.State, PhoneConfirm.Action> processStateContentAction(PhoneConfirm.State.Content state, PhoneConfirm.Action action) {
        Out.Companion companion;
        Function iVar;
        Out.Companion companion2;
        PhoneConfirm.State.Progress progress;
        Function fVar;
        if (action instanceof PhoneConfirm.Action.CodeChanged) {
            return Out.INSTANCE.invoke(state, new a(action));
        }
        if (!(action instanceof PhoneConfirm.Action.CodeValid)) {
            if (action instanceof PhoneConfirm.Action.Expired) {
                companion = Out.INSTANCE;
                iVar = new c();
            } else {
                if (action instanceof PhoneConfirm.Action.CodeInvalid) {
                    PhoneConfirm.Action.CodeInvalid codeInvalid = (PhoneConfirm.Action.CodeInvalid) action;
                    return Out.INSTANCE.invoke(PhoneConfirm.State.Content.copy$default(state, codeInvalid.getValue(), false, null, codeInvalid.getValue().length() <= 0 ? state.getError() : null, 6, null), new d());
                }
                if (action instanceof PhoneConfirm.Action.RestartProcess) {
                    companion = Out.INSTANCE;
                    iVar = new e();
                } else if (action instanceof PhoneConfirm.Action.Retry) {
                    companion2 = Out.INSTANCE;
                    progress = new PhoneConfirm.State.Progress(state.getConfirmCode(), state.isEnabledRetryAction());
                    fVar = new f(action);
                } else if (action instanceof PhoneConfirm.Action.StopTimer) {
                    companion = Out.INSTANCE;
                    state = PhoneConfirm.State.Content.copy$default(state, null, true, null, null, 13, null);
                    iVar = new g();
                } else {
                    if (action instanceof PhoneConfirm.Action.Forgot) {
                        return Out.INSTANCE.invoke(new PhoneConfirm.State.Progress(state.getConfirmCode(), false, 2, null), new h(action));
                    }
                    if (!(action instanceof PhoneConfirm.Action.ShowHelp)) {
                        return Out.INSTANCE.skip(state, this.source);
                    }
                    companion = Out.INSTANCE;
                    iVar = new i();
                }
            }
            return companion.invoke(state, iVar);
        }
        companion2 = Out.INSTANCE;
        progress = new PhoneConfirm.State.Progress(((PhoneConfirm.Action.CodeValid) action).getValue(), state.isEnabledRetryAction());
        fVar = new b(action);
        return companion2.invoke(progress, fVar);
    }

    private final Out<PhoneConfirm.State, PhoneConfirm.Action> processStateProgressAction(PhoneConfirm.State.Progress state, PhoneConfirm.Action action) {
        Out.Companion companion;
        Function oVar;
        Out.Companion companion2;
        PhoneConfirm.State.Content content;
        Function nVar;
        if (action instanceof PhoneConfirm.Action.ConfirmPhoneSuccess) {
            companion2 = Out.INSTANCE;
            content = new PhoneConfirm.State.Content(state.getConfirmCode(), state.isEnabledRetryAction(), null, null, 12, null);
            nVar = new j(action);
        } else if (action instanceof PhoneConfirm.Action.ConfirmPhoneFail) {
            companion2 = Out.INSTANCE;
            content = new PhoneConfirm.State.Content("", state.isEnabledRetryAction(), null, ((PhoneConfirm.Action.ConfirmPhoneFail) action).getError(), 4, null);
            nVar = new k();
        } else {
            if (!(action instanceof PhoneConfirm.Action.TechnicalError)) {
                if (action instanceof PhoneConfirm.Action.StopTimer) {
                    companion = Out.INSTANCE;
                    state = PhoneConfirm.State.Progress.copy$default(state, null, true, 1, null);
                    oVar = new m();
                } else if (action instanceof PhoneConfirm.Action.ForgotPhoneSuccess) {
                    companion2 = Out.INSTANCE;
                    content = new PhoneConfirm.State.Content(state.getConfirmCode(), state.isEnabledRetryAction(), null, null, 12, null);
                    nVar = new n(action);
                } else {
                    if (!(action instanceof PhoneConfirm.Action.ShowHelp)) {
                        return Out.INSTANCE.skip(state, this.source);
                    }
                    companion = Out.INSTANCE;
                    oVar = new o();
                }
                return companion.invoke(state, oVar);
            }
            companion2 = Out.INSTANCE;
            content = new PhoneConfirm.State.Content(state.getConfirmCode(), state.isEnabledRetryAction(), null, null, 12, null);
            nVar = new l(action);
        }
        return companion2.invoke(content, nVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PhoneConfirm.State, PhoneConfirm.Action> invoke(PhoneConfirm.State state, PhoneConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PhoneConfirm.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PhoneConfirm.State.Content) {
            return processStateContentAction((PhoneConfirm.State.Content) state, action);
        }
        if (state instanceof PhoneConfirm.State.Progress) {
            return processStateProgressAction((PhoneConfirm.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
