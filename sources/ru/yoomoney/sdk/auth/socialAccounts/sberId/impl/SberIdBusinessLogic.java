package ru.yoomoney.sdk.auth.socialAccounts.sberId.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.socialAccounts.sberId.SberId;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bm\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/impl/SberIdBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Empty;", "state", "action", "handleEmptyState", "(Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Empty;Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$OpenSberDialog;", "handleOpenSberDialogState", "(Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$OpenSberDialog;Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Waiting;", "handleWaitingState", "(Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Waiting;Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SberIdBusinessLogic implements Function2<SberId.State, SberId.Action, Out<? extends SberId.State, ? extends SberId.Action>> {
    private final Function2<SberId.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<SberId.State, Continuation<? super SberId.Action>, Object> showState;
    private final Function1<Continuation<? super SberId.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends SberId.State.Empty, SberId.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Empty, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Empty, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.a(SberIdBusinessLogic.this, null));
            CoreKt.input(invoke, SberIdBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.b(SberIdBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends SberId.State.Waiting, SberId.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Waiting, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Waiting, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.c(SberIdBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends SberId.State.Empty, SberId.Action>, Unit> {
        public final /* synthetic */ SberId.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SberId.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Empty, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Empty, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.d(SberIdBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SberIdBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.OpenSberDialog, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.e(SberIdBusinessLogic.this, null));
            CoreKt.input(invoke, SberIdBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends SberId.State.Empty, SberId.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Empty, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Empty, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.f(SberIdBusinessLogic.this, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.g(SberIdBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends SberId.State.Empty, SberId.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Empty, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Empty, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.h(SberIdBusinessLogic.this, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.socialAccounts.sberId.impl.i(SberIdBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends SberId.State.Waiting, SberId.Action>, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Waiting, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Waiting, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new j(SberIdBusinessLogic.this, null));
            CoreKt.input(invoke, SberIdBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends SberId.State.Waiting, SberId.Action>, Unit> {
        public final /* synthetic */ SberId.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SberId.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends SberId.State.Waiting, SberId.Action> builder) {
            Out.Builder<? extends SberId.State.Waiting, SberId.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new k(SberIdBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, SberIdBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SberIdBusinessLogic(Function2<? super SberId.State, ? super Continuation<? super SberId.Action>, ? extends Object> showState, Function2<? super SberId.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super SberId.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<SberId.State, SberId.Action> handleEmptyState(SberId.State.Empty state, SberId.Action action) {
        Out.Companion companion;
        SberId.State state2;
        Function cVar;
        if (action instanceof SberId.Action.Open) {
            return Out.INSTANCE.invoke(state, new a());
        }
        if (action instanceof SberId.Action.ShowDialog) {
            companion = Out.INSTANCE;
            state2 = SberId.State.OpenSberDialog.INSTANCE;
            cVar = new b();
        } else {
            if (!(action instanceof SberId.Action.WaitForDeeplink)) {
                return action instanceof SberId.Action.DeeplinkReceived ? Out.INSTANCE.invoke(state, new d(action)) : Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            state2 = SberId.State.Waiting.INSTANCE;
            cVar = new c();
        }
        return companion.invoke(state2, cVar);
    }

    private final Out<SberId.State, SberId.Action> handleOpenSberDialogState(SberId.State.OpenSberDialog state, SberId.Action action) {
        return action instanceof SberId.Action.Cancel ? Out.INSTANCE.invoke(state, new e()) : action instanceof SberId.Action.Open ? Out.INSTANCE.invoke(SberId.State.Empty.INSTANCE, new f()) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<SberId.State, SberId.Action> handleWaitingState(SberId.State.Waiting state, SberId.Action action) {
        return action instanceof SberId.Action.Open ? Out.INSTANCE.invoke(SberId.State.Empty.INSTANCE, new g()) : action instanceof SberId.Action.Cancel ? Out.INSTANCE.invoke(state, new h()) : action instanceof SberId.Action.DeeplinkReceived ? Out.INSTANCE.invoke(state, new i(action)) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<SberId.State, SberId.Action> invoke(SberId.State state, SberId.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof SberId.State.Empty) {
            return handleEmptyState((SberId.State.Empty) state, action);
        }
        if (state instanceof SberId.State.OpenSberDialog) {
            return handleOpenSberDialogState((SberId.State.OpenSberDialog) state, action);
        }
        if (state instanceof SberId.State.Waiting) {
            return handleWaitingState((SberId.State.Waiting) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
