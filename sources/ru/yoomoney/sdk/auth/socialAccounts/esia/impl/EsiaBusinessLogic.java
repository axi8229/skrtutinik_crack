package ru.yoomoney.sdk.auth.socialAccounts.esia.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.socialAccounts.esia.Esia;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bm\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/impl/EsiaBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Empty;", "state", "action", "handleEmptyState", "(Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Empty;Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Waiting;", "handleWaitingState", "(Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Waiting;Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EsiaBusinessLogic implements Function2<Esia.State, Esia.Action, Out<? extends Esia.State, ? extends Esia.Action>> {
    private final Function2<Esia.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<Esia.State, Continuation<? super Esia.Action>, Object> showState;
    private final Function1<Continuation<? super Esia.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends Esia.State.Empty, Esia.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Empty, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Empty, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.a(EsiaBusinessLogic.this, null));
            CoreKt.input(invoke, EsiaBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends Esia.State.Waiting, Esia.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Waiting, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Waiting, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.b(EsiaBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends Esia.State.Empty, Esia.Action>, Unit> {
        public final /* synthetic */ Esia.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Esia.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Empty, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Empty, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.c(EsiaBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EsiaBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends Esia.State.Empty, Esia.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Empty, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Empty, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.d(EsiaBusinessLogic.this, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.e(EsiaBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends Esia.State.Waiting, Esia.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Waiting, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Waiting, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.esia.impl.f(EsiaBusinessLogic.this, null));
            CoreKt.input(invoke, EsiaBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends Esia.State.Waiting, Esia.Action>, Unit> {
        public final /* synthetic */ Esia.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Esia.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends Esia.State.Waiting, Esia.Action> builder) {
            Out.Builder<? extends Esia.State.Waiting, Esia.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new g(EsiaBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EsiaBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EsiaBusinessLogic(Function2<? super Esia.State, ? super Continuation<? super Esia.Action>, ? extends Object> showState, Function2<? super Esia.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super Esia.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<Esia.State, Esia.Action> handleEmptyState(Esia.State.Empty state, Esia.Action action) {
        return action instanceof Esia.Action.Open ? Out.INSTANCE.invoke(state, new a()) : action instanceof Esia.Action.WaitForDeeplink ? Out.INSTANCE.invoke(Esia.State.Waiting.INSTANCE, new b()) : action instanceof Esia.Action.DeeplinkReceived ? Out.INSTANCE.invoke(state, new c(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<Esia.State, Esia.Action> handleWaitingState(Esia.State.Waiting state, Esia.Action action) {
        return action instanceof Esia.Action.Open ? Out.INSTANCE.invoke(Esia.State.Empty.INSTANCE, new d()) : action instanceof Esia.Action.Cancel ? Out.INSTANCE.invoke(state, new e()) : action instanceof Esia.Action.DeeplinkReceived ? Out.INSTANCE.invoke(state, new f(action)) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<Esia.State, Esia.Action> invoke(Esia.State state, Esia.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof Esia.State.Empty) {
            return handleEmptyState((Esia.State.Empty) state, action);
        }
        if (state instanceof Esia.State.Waiting) {
            return handleWaitingState((Esia.State.Waiting) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
