package ru.yoomoney.sdk.auth.finishing.failure.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailure;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bm\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/impl/AuthFinishingFailureBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Init;", "state", "action", "handleInitState", "(Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Init;Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Content;Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingFailureBusinessLogic implements Function2<AuthFinishingFailure.State, AuthFinishingFailure.Action, Out<? extends AuthFinishingFailure.State, ? extends AuthFinishingFailure.Action>> {
    private final Function2<AuthFinishingFailure.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<AuthFinishingFailure.State, Continuation<? super AuthFinishingFailure.Action>, Object> showState;
    private final Function1<Continuation<? super AuthFinishingFailure.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder) {
            Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.finishing.failure.impl.a(AuthFinishingFailureBusinessLogic.this, null));
            CoreKt.input(invoke, AuthFinishingFailureBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder) {
            Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.finishing.failure.impl.b(AuthFinishingFailureBusinessLogic.this, null));
            CoreKt.input(invoke, AuthFinishingFailureBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder) {
            Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.finishing.failure.impl.c(AuthFinishingFailureBusinessLogic.this, null));
            CoreKt.input(invoke, AuthFinishingFailureBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder) {
            Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.finishing.failure.impl.d(AuthFinishingFailureBusinessLogic.this, null));
            CoreKt.input(invoke, AuthFinishingFailureBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> builder) {
            Out.Builder<? extends AuthFinishingFailure.State.Content, AuthFinishingFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.finishing.failure.impl.e(AuthFinishingFailureBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthFinishingFailureBusinessLogic(Function2<? super AuthFinishingFailure.State, ? super Continuation<? super AuthFinishingFailure.Action>, ? extends Object> showState, Function2<? super AuthFinishingFailure.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super AuthFinishingFailure.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<AuthFinishingFailure.State, AuthFinishingFailure.Action> handleContentState(AuthFinishingFailure.State.Content state, AuthFinishingFailure.Action action) {
        Out.Companion companion;
        Function dVar;
        if (Intrinsics.areEqual(action, AuthFinishingFailure.Action.Confirm.INSTANCE)) {
            companion = Out.INSTANCE;
            dVar = new a();
        } else if (Intrinsics.areEqual(action, AuthFinishingFailure.Action.OpenContacts.INSTANCE)) {
            companion = Out.INSTANCE;
            dVar = new b();
        } else if (Intrinsics.areEqual(action, AuthFinishingFailure.Action.OpenPhone.INSTANCE)) {
            companion = Out.INSTANCE;
            dVar = new c();
        } else {
            if (!Intrinsics.areEqual(action, AuthFinishingFailure.Action.OpenEmail.INSTANCE)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            dVar = new d();
        }
        return companion.invoke(state, dVar);
    }

    private final Out<AuthFinishingFailure.State, AuthFinishingFailure.Action> handleInitState(AuthFinishingFailure.State.Init state, AuthFinishingFailure.Action action) {
        return action instanceof AuthFinishingFailure.Action.Load ? Out.INSTANCE.invoke(new AuthFinishingFailure.State.Content(((AuthFinishingFailure.Action.Load) action).getShowSupportButton()), new e()) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<AuthFinishingFailure.State, AuthFinishingFailure.Action> invoke(AuthFinishingFailure.State state, AuthFinishingFailure.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof AuthFinishingFailure.State.Init) {
            return handleInitState((AuthFinishingFailure.State.Init) state, action);
        }
        if (state instanceof AuthFinishingFailure.State.Content) {
            return handleContentState((AuthFinishingFailure.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
