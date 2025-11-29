package ru.yoomoney.sdk.auth.nickname.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.nickname.Nickname;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/nickname/impl/NicknameBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractor;", "interactor", "Lru/yoomoney/sdk/auth/nickname/Nickname$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractor;Lru/yoomoney/sdk/auth/nickname/Nickname$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/nickname/Nickname$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/nickname/Nickname$State$Content;Lru/yoomoney/sdk/auth/nickname/Nickname$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/nickname/Nickname$State$Progress;Lru/yoomoney/sdk/auth/nickname/Nickname$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/nickname/Nickname$State;Lru/yoomoney/sdk/auth/nickname/Nickname$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractor;", "Lru/yoomoney/sdk/auth/nickname/Nickname$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NicknameBusinessLogic implements Function2<Nickname.State, Nickname.Action, Out<? extends Nickname.State, ? extends Nickname.Action>> {
    private final Nickname.AnalyticsLogger analyticsLogger;
    private final NicknameInteractor interactor;
    private final Function2<Nickname.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<Nickname.State, Continuation<? super Nickname.Action>, Object> showState;
    private final Function1<Continuation<? super Nickname.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends Nickname.State.Content, Nickname.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Nickname.State.Content, Nickname.Action> builder) {
            Out.Builder<? extends Nickname.State.Content, Nickname.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.nickname.impl.a(NicknameBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends Nickname.State.Progress, Nickname.Action>, Unit> {
        public final /* synthetic */ Nickname.Action b;
        public final /* synthetic */ Nickname.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Nickname.Action action, Nickname.State.Content content) {
            super(1);
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Nickname.State.Progress, Nickname.Action> builder) {
            Out.Builder<? extends Nickname.State.Progress, Nickname.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.nickname.impl.b(NicknameBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.nickname.impl.c(NicknameBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends Nickname.State.Content, Nickname.Action>, Unit> {
        public final /* synthetic */ Nickname.State.Progress b;
        public final /* synthetic */ Nickname.Action c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Nickname.State.Progress progress, Nickname.Action action) {
            super(1);
            this.b = progress;
            this.c = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Nickname.State.Content, Nickname.Action> builder) {
            Out.Builder<? extends Nickname.State.Content, Nickname.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.nickname.impl.d(NicknameBusinessLogic.this, this.b, null));
            CoreKt.output(invoke, new e(NicknameBusinessLogic.this, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends Nickname.State.Content, Nickname.Action>, Unit> {
        public final /* synthetic */ Nickname.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Nickname.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Nickname.State.Content, Nickname.Action> builder) {
            Out.Builder<? extends Nickname.State.Content, Nickname.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new f(NicknameBusinessLogic.this, invoke, null));
            CoreKt.output(invoke, new g(NicknameBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NicknameBusinessLogic(Function2<? super Nickname.State, ? super Continuation<? super Nickname.Action>, ? extends Object> showState, Function2<? super Nickname.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super Nickname.Action>, ? extends Object> source, NicknameInteractor interactor, Nickname.AnalyticsLogger analyticsLogger) {
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

    private final Out<Nickname.State, Nickname.Action> handleContentState(Nickname.State.Content state, Nickname.Action action) {
        return action instanceof Nickname.Action.NicknameChanged ? Out.INSTANCE.invoke(state.copy(((Nickname.Action.NicknameChanged) action).getNickname()), new a()) : action instanceof Nickname.Action.Submit ? Out.INSTANCE.invoke(new Nickname.State.Progress(state.getNewNickname()), new b(action, state)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<Nickname.State, Nickname.Action> handleProgressState(Nickname.State.Progress state, Nickname.Action action) {
        return action instanceof Nickname.Action.SetNicknameSuccess ? Out.INSTANCE.invoke(new Nickname.State.Content(state.getNewNickname()), new c(state, action)) : action instanceof Nickname.Action.SetNicknameFail ? Out.INSTANCE.invoke(new Nickname.State.Content(state.getNewNickname()), new d(action)) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<Nickname.State, Nickname.Action> invoke(Nickname.State state, Nickname.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Nickname.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof Nickname.State.Content) {
            return handleContentState((Nickname.State.Content) state, action);
        }
        if (state instanceof Nickname.State.Progress) {
            return handleProgressState((Nickname.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
