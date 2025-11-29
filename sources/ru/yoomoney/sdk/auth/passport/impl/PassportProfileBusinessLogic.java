package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u0087\u0001\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010#J+\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010&J,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b'\u0010(R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010)R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010*R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010-¨\u0006."}, d2 = {"Lru/yoomoney/sdk/auth/passport/impl/PassportProfileBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "interactor", "Lru/yoomoney/sdk/auth/ResultData;", "resultData", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Init;", "state", "action", "handleInitState", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Init;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Content;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Loading;", "handleLoadingState", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Loading;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$BindingProcess;", "handleBindingProcessState", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State$BindingProcess;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Error;", "handleErrorState", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Error;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$State;Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "Lru/yoomoney/sdk/auth/ResultData;", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileBusinessLogic implements Function2<PassportProfile.State, PassportProfile.Action, Out<? extends PassportProfile.State, ? extends PassportProfile.Action>> {
    private final PassportProfileAnalyticsLogger analyticsLogger;
    private final PassportProfileInteractor interactor;
    private final ResultData resultData;
    private final Function2<PassportProfile.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PassportProfile.State, Continuation<? super PassportProfile.Action>, Object> showState;
    private final Function1<Continuation<? super PassportProfile.Action>, Object> source;

    public static final class A extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.J(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class B extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.K(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class C extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.L(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.M(PassportProfileBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class D extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.passport.impl.N(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.O(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class E extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public E() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.P(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new Q(PassportProfileBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    public static final class F extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action>, Unit> {
        public F() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new S(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class G extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action>, Unit> {
        public G() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new T(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class H extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action>, Unit> {
        public H() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new U(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class I extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public I(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new V(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new W(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class J extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public J(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new X(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new Y(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class K extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public K(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new Z(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new a0(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class L extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public L(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new b0(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new c0(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class M extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public M(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new d0(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new e0(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class N extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public N() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new f0(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class O extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public O(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new g0(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new h0(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class P extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public P() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new i0(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$a, reason: case insensitive filesystem */
    public static final class C2129a extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public C2129a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2145a(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$b, reason: case insensitive filesystem */
    public static final class C2130b extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2130b(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2146b(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new C2147c(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$c, reason: case insensitive filesystem */
    public static final class C2131c extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfileBusinessLogic a;
        public final /* synthetic */ PassportProfile.Action b;
        public final /* synthetic */ PassportProfile.State.BindingProcess c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2131c(PassportProfile.Action action, PassportProfile.State.BindingProcess bindingProcess, PassportProfileBusinessLogic passportProfileBusinessLogic) {
            super(1);
            this.a = passportProfileBusinessLogic;
            this.b = action;
            this.c = bindingProcess;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2148d(null, this.b, this.c, this.a));
            CoreKt.input(invoke, this.a.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$d, reason: case insensitive filesystem */
    public static final class C2132d extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfileBusinessLogic a;
        public final /* synthetic */ PassportProfile.State.BindingProcess b;
        public final /* synthetic */ PassportProfile.Action c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2132d(PassportProfile.Action action, PassportProfile.State.BindingProcess bindingProcess, PassportProfileBusinessLogic passportProfileBusinessLogic) {
            super(1);
            this.a = passportProfileBusinessLogic;
            this.b = bindingProcess;
            this.c = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            PassportProfileBusinessLogic passportProfileBusinessLogic = this.a;
            CoreKt.input(invoke, new C2149e(null, this.c, this.b, passportProfileBusinessLogic));
            CoreKt.input(invoke, this.a.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$e, reason: case insensitive filesystem */
    public static final class C2133e extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfileBusinessLogic a;
        public final /* synthetic */ PassportProfile.Action b;
        public final /* synthetic */ PassportProfile.State.BindingProcess c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2133e(PassportProfile.Action action, PassportProfile.State.BindingProcess bindingProcess, PassportProfileBusinessLogic passportProfileBusinessLogic) {
            super(1);
            this.a = passportProfileBusinessLogic;
            this.b = action;
            this.c = bindingProcess;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2150f(null, this.b, this.c, this.a));
            CoreKt.input(invoke, this.a.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$f, reason: case insensitive filesystem */
    public static final class C2134f extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2134f(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2151g(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new C2152h(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$g, reason: case insensitive filesystem */
    public static final class C2135g extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2135g(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2153i(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new C2154j(PassportProfileBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$h, reason: case insensitive filesystem */
    public static final class C2136h extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action>, Unit> {
        public C2136h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.BindingProcess, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2155k(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$i, reason: case insensitive filesystem */
    public static final class C2137i extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public C2137i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2157m(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2158n(PassportProfileBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$j, reason: case insensitive filesystem */
    public static final class C2138j extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.State.Content b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2138j(PassportProfile.State.Content content) {
            super(1);
            this.b = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2159o(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$k, reason: case insensitive filesystem */
    public static final class C2139k extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2139k(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2160p(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2161q(PassportProfileBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$l, reason: case insensitive filesystem */
    public static final class C2140l extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2140l(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.passport.impl.r(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$m, reason: case insensitive filesystem */
    public static final class C2141m extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2141m(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2162s(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2163t(PassportProfileBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$n, reason: case insensitive filesystem */
    public static final class C2142n extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public C2142n() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2164u(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$o, reason: case insensitive filesystem */
    public static final class C2143o extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2143o(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2165v(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$p, reason: case insensitive filesystem */
    public static final class C2144p extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2144p(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2156l(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2166w(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.State.Content b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PassportProfile.State.Content content) {
            super(1);
            this.b = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2167x(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public s() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2168y(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class t extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public t() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2169z(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.A(PassportProfileBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    public static final class u extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.State.Content b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PassportProfile.State.Content content) {
            super(1);
            this.b = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.B(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class v extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public v() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.passport.impl.C(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class w extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action>, Unit> {
        public w() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Loading, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.D(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.E(PassportProfileBusinessLogic.this, null));
            return Unit.INSTANCE;
        }
    }

    public static final class x extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action>, Unit> {
        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Content, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.passport.impl.F(PassportProfileBusinessLogic.this, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class y extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(PassportProfile.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Init, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.G(PassportProfileBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.passport.impl.H(PassportProfileBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class z extends Lambda implements Function1<Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action>, Unit> {
        public final /* synthetic */ PassportProfile.State.Error b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PassportProfile.State.Error error) {
            super(1);
            this.b = error;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action> builder) {
            Out.Builder<? extends PassportProfile.State.Error, PassportProfile.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.passport.impl.I(PassportProfileBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PassportProfileBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassportProfileBusinessLogic(Function2<? super PassportProfile.State, ? super Continuation<? super PassportProfile.Action>, ? extends Object> showState, Function2<? super PassportProfile.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PassportProfile.Action>, ? extends Object> source, PassportProfileInteractor interactor, ResultData resultData, PassportProfileAnalyticsLogger passportProfileAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.resultData = resultData;
        this.analyticsLogger = passportProfileAnalyticsLogger;
    }

    private final Out<PassportProfile.State, PassportProfile.Action> handleBindingProcessState(PassportProfile.State.BindingProcess state, PassportProfile.Action action) {
        Out.Companion companion;
        PassportProfile.State.Content content;
        Function c2135g;
        Out.Companion companion2;
        Function c2133e;
        if (action instanceof PassportProfile.Action.CancelBinding) {
            return Out.INSTANCE.invoke(new PassportProfile.State.Content(state.getAccount()), new C2129a());
        }
        if (action instanceof PassportProfile.Action.BindSocialAccountSuccess) {
            return Out.INSTANCE.invoke(new PassportProfile.State.Content(((PassportProfile.Action.BindSocialAccountSuccess) action).getAccount()), new C2130b(action));
        }
        if (action instanceof PassportProfile.Action.HandleBindSberIdResponse) {
            companion2 = Out.INSTANCE;
            c2133e = new C2131c(action, state, this);
        } else if (action instanceof PassportProfile.Action.HandleBindVkIdResponse) {
            companion2 = Out.INSTANCE;
            c2133e = new C2132d(action, state, this);
        } else {
            if (!(action instanceof PassportProfile.Action.HandleBindEsiaResponse)) {
                if (action instanceof PassportProfile.Action.BindingSocialAccountFailed) {
                    companion = Out.INSTANCE;
                    content = new PassportProfile.State.Content(state.getAccount());
                    c2135g = new C2134f(action);
                } else {
                    if (!(action instanceof PassportProfile.Action.BindSocialAccountError)) {
                        return action instanceof PassportProfile.Action.FinishWithCancel ? Out.INSTANCE.invoke(state, new C2136h()) : Out.INSTANCE.skip(state, this.source);
                    }
                    companion = Out.INSTANCE;
                    content = new PassportProfile.State.Content(state.getAccount());
                    c2135g = new C2135g(action);
                }
                return companion.invoke(content, c2135g);
            }
            companion2 = Out.INSTANCE;
            c2133e = new C2133e(action, state, this);
        }
        return companion2.invoke(state, c2133e);
    }

    private final Out<PassportProfile.State, PassportProfile.Action> handleContentState(PassportProfile.State.Content state, PassportProfile.Action action) {
        Out.Companion companion;
        Function c2143o;
        Out.Companion companion2;
        Function c2142n;
        Out.Companion companion3;
        PassportProfile.State.Loading loading;
        Function c2141m;
        Out.Companion companion4;
        PassportProfile.State.Loading loading2;
        Function c2137i;
        if (action instanceof PassportProfile.Action.ChangePhoneSuccess) {
            companion = Out.INSTANCE;
            c2143o = new C2144p(action);
        } else {
            if (!(action instanceof PassportProfile.Action.ChangeEmailSuccess)) {
                if (action instanceof PassportProfile.Action.ChangeEmail) {
                    companion2 = Out.INSTANCE;
                    c2142n = new r(state);
                } else {
                    if (!(action instanceof PassportProfile.Action.ShowChangeEmailDialog)) {
                        if (action instanceof PassportProfile.Action.ConfirmChangeEmail) {
                            companion4 = Out.INSTANCE;
                            loading2 = new PassportProfile.State.Loading(state.getAccount());
                            c2137i = new t();
                        } else if (action instanceof PassportProfile.Action.ChangePhone) {
                            companion2 = Out.INSTANCE;
                            c2142n = new u(state);
                        } else if (action instanceof PassportProfile.Action.ShowChangePhoneDialog) {
                            companion2 = Out.INSTANCE;
                            c2142n = new v();
                        } else if (action instanceof PassportProfile.Action.ConfirmChangePhone) {
                            companion4 = Out.INSTANCE;
                            loading2 = new PassportProfile.State.Loading(state.getAccount());
                            c2137i = new w();
                        } else if (action instanceof PassportProfile.Action.ChangePassword) {
                            companion2 = Out.INSTANCE;
                            c2142n = new x();
                        } else if (action instanceof PassportProfile.Action.ConfirmChangePassword) {
                            companion4 = Out.INSTANCE;
                            loading2 = new PassportProfile.State.Loading(state.getAccount());
                            c2137i = new C2137i();
                        } else {
                            if (!(action instanceof PassportProfile.Action.ChangeName)) {
                                if (action instanceof PassportProfile.Action.StartBindingSocialAccount) {
                                    companion3 = Out.INSTANCE;
                                    loading = new PassportProfile.State.Loading(state.getAccount());
                                    c2141m = new C2139k(action);
                                } else if (action instanceof PassportProfile.Action.StartUnbindSocialAccount) {
                                    companion = Out.INSTANCE;
                                    c2143o = new C2140l(action);
                                } else if (action instanceof PassportProfile.Action.UnbindSocialAccount) {
                                    companion3 = Out.INSTANCE;
                                    loading = new PassportProfile.State.Loading(state.getAccount());
                                    c2141m = new C2141m(action);
                                } else if (action instanceof PassportProfile.Action.FinishWithCancel) {
                                    companion2 = Out.INSTANCE;
                                    c2142n = new C2142n();
                                } else {
                                    if (!(action instanceof PassportProfile.Action.OpenSocialAccountDialog)) {
                                        return Out.INSTANCE.skip(state, this.source);
                                    }
                                    companion = Out.INSTANCE;
                                    c2143o = new C2143o(action);
                                }
                                return companion3.invoke(loading, c2141m);
                            }
                            companion2 = Out.INSTANCE;
                            c2142n = new C2138j(state);
                        }
                        return companion4.invoke(loading2, c2137i);
                    }
                    companion2 = Out.INSTANCE;
                    c2142n = new s();
                }
                return companion2.invoke(state, c2142n);
            }
            companion = Out.INSTANCE;
            c2143o = new q(action);
        }
        return companion.invoke(state, c2143o);
    }

    private final Out<PassportProfile.State, PassportProfile.Action> handleErrorState(PassportProfile.State.Error state, PassportProfile.Action action) {
        return action instanceof PassportProfile.Action.Init ? Out.INSTANCE.invoke(PassportProfile.State.Init.INSTANCE, new y(action)) : action instanceof PassportProfile.Action.FinishWithCancel ? Out.INSTANCE.invoke(state, new z(state)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PassportProfile.State, PassportProfile.Action> handleInitState(PassportProfile.State.Init state, PassportProfile.Action action) {
        Out.Companion companion;
        Function a;
        Out.Companion companion2;
        Function h;
        Out.Companion companion3;
        PassportProfile.State error;
        Function f;
        Out.Companion companion4;
        PassportProfile.State.Content content;
        Function d;
        if ((action instanceof PassportProfile.Action.InitEmailProcess) || (action instanceof PassportProfile.Action.Init)) {
            companion = Out.INSTANCE;
            a = new A(action);
        } else {
            if (!(action instanceof PassportProfile.Action.AccountSuccess)) {
                if (action instanceof PassportProfile.Action.HandleAccountSuccess) {
                    companion4 = Out.INSTANCE;
                    content = new PassportProfile.State.Content(((PassportProfile.Action.HandleAccountSuccess) action).getAccount());
                    d = new C(action);
                } else {
                    if (!(action instanceof PassportProfile.Action.AccountWithMessage)) {
                        if (action instanceof PassportProfile.Action.StartEmailProcess) {
                            companion3 = Out.INSTANCE;
                            error = new PassportProfile.State.Loading(((PassportProfile.Action.StartEmailProcess) action).getAccount());
                            f = new E();
                        } else {
                            if (!(action instanceof PassportProfile.Action.AccountFailed)) {
                                if (action instanceof PassportProfile.Action.FinishWithCancel) {
                                    companion2 = Out.INSTANCE;
                                    h = new G();
                                } else {
                                    if (!(action instanceof PassportProfile.Action.Finish)) {
                                        return Out.INSTANCE.skip(state, this.source);
                                    }
                                    companion2 = Out.INSTANCE;
                                    h = new H();
                                }
                                return companion2.invoke(state, h);
                            }
                            companion3 = Out.INSTANCE;
                            error = new PassportProfile.State.Error(((PassportProfile.Action.AccountFailed) action).getFailure());
                            f = new F();
                        }
                        return companion3.invoke(error, f);
                    }
                    companion4 = Out.INSTANCE;
                    content = new PassportProfile.State.Content(((PassportProfile.Action.AccountWithMessage) action).getAccount());
                    d = new D(action);
                }
                return companion4.invoke(content, d);
            }
            companion = Out.INSTANCE;
            a = new B(action);
        }
        return companion.invoke(state, a);
    }

    private final Out<PassportProfile.State, PassportProfile.Action> handleLoadingState(PassportProfile.State.Loading state, PassportProfile.Action action) {
        Out.Companion companion;
        PassportProfile.State content;
        Function o;
        if (action instanceof PassportProfile.Action.StartChangeSuccess) {
            companion = Out.INSTANCE;
            content = new PassportProfile.State.Content(state.getAccount());
            o = new I(action);
        } else if (action instanceof PassportProfile.Action.StartChangeFailed) {
            companion = Out.INSTANCE;
            content = new PassportProfile.State.Content(state.getAccount());
            o = new J(action);
        } else if (action instanceof PassportProfile.Action.StartBindingSocialAccountSuccess) {
            companion = Out.INSTANCE;
            content = new PassportProfile.State.BindingProcess(state.getAccount(), ((PassportProfile.Action.StartBindingSocialAccountSuccess) action).getProcess());
            o = new K(action);
        } else if (action instanceof PassportProfile.Action.BindingSocialAccountFailed) {
            companion = Out.INSTANCE;
            content = new PassportProfile.State.Content(state.getAccount());
            o = new L(action);
        } else if (action instanceof PassportProfile.Action.BindSocialAccountError) {
            companion = Out.INSTANCE;
            content = new PassportProfile.State.Content(state.getAccount());
            o = new M(action);
        } else {
            if (action instanceof PassportProfile.Action.UnbindSocialAccountSuccess) {
                return Out.INSTANCE.invoke(new PassportProfile.State.Content(((PassportProfile.Action.UnbindSocialAccountSuccess) action).getAccount()), new N());
            }
            if (!(action instanceof PassportProfile.Action.UnbindSocialAccountFailed)) {
                return action instanceof PassportProfile.Action.FinishWithCancel ? Out.INSTANCE.invoke(state, new P()) : Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = new PassportProfile.State.Content(state.getAccount());
            o = new O(action);
        }
        return companion.invoke(content, o);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PassportProfile.State, PassportProfile.Action> invoke(PassportProfile.State state, PassportProfile.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PassportProfileAnalyticsLogger passportProfileAnalyticsLogger = this.analyticsLogger;
        if (passportProfileAnalyticsLogger != null) {
            passportProfileAnalyticsLogger.invoke(state, action);
        }
        if (state instanceof PassportProfile.State.Init) {
            return handleInitState((PassportProfile.State.Init) state, action);
        }
        if (state instanceof PassportProfile.State.Content) {
            return handleContentState((PassportProfile.State.Content) state, action);
        }
        if (state instanceof PassportProfile.State.Loading) {
            return handleLoadingState((PassportProfile.State.Loading) state, action);
        }
        if (state instanceof PassportProfile.State.BindingProcess) {
            return handleBindingProcessState((PassportProfile.State.BindingProcess) state, action);
        }
        if (state instanceof PassportProfile.State.Error) {
            return handleErrorState((PassportProfile.State.Error) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
