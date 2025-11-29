package ru.yoomoney.sdk.auth.loading.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.loading.AuthLoading;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B}\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;", "interactor", "Lru/yoomoney/sdk/auth/Config;", "config", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;Lru/yoomoney/sdk/auth/Config;)V", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Progress;", "state", "action", "handleProgressState", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Progress;Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Error;", "handleErrorState", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Error;Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$SocialAccountAuth;", "handleSocialAccountAuthState", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$State$SocialAccountAuth;Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$State;Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthLoadingBusinessLogic implements Function2<AuthLoading.State, AuthLoading.Action, Out<? extends AuthLoading.State, ? extends AuthLoading.Action>> {
    private final Config config;
    private final AuthLoadingInteractor interactor;
    private final Function2<AuthLoading.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<AuthLoading.State, Continuation<? super AuthLoading.Action>, Object> showState;
    private final Function1<Continuation<? super AuthLoading.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2126a(AuthLoadingBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2127b(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2128c(AuthLoadingBusinessLogic.this, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.e(AuthLoadingBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.f(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.g(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.h(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.i(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Error, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.j(AuthLoadingBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.k(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.l(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.m(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.d(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.n(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.o(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.p(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.SocialAccountAuth, AuthLoading.Action>, Unit> {
        public o() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.SocialAccountAuth, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.SocialAccountAuth, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.q(AuthLoadingBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class p extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.r(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.loading.impl.s(AuthLoadingBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.t(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuthLoadingBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.u(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class t extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.loading.impl.v(AuthLoadingBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new w(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class u extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new x(AuthLoadingBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new y(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class v extends Lambda implements Function1<Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action>, Unit> {
        public final /* synthetic */ AuthLoading.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(AuthLoading.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> builder) {
            Out.Builder<? extends AuthLoading.State.Progress, AuthLoading.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new z(AuthLoadingBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new A(AuthLoadingBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthLoadingBusinessLogic(Function2<? super AuthLoading.State, ? super Continuation<? super AuthLoading.Action>, ? extends Object> showState, Function2<? super AuthLoading.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super AuthLoading.Action>, ? extends Object> source, AuthLoadingInteractor interactor, Config config) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(config, "config");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.config = config;
    }

    private final Out<AuthLoading.State, AuthLoading.Action> handleErrorState(AuthLoading.State.Error state, AuthLoading.Action action) {
        return action instanceof AuthLoading.Action.Load ? Out.INSTANCE.invoke(AuthLoading.State.Progress.INSTANCE, new a(action)) : action instanceof AuthLoading.Action.Finish ? Out.INSTANCE.invoke(state, new b()) : Out.INSTANCE.skip(state, this.source);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [ru.yoomoney.sdk.auth.loading.AuthLoading$State$Error] */
    /* JADX WARN: Type inference failed for: r3v5, types: [ru.yoomoney.sdk.auth.loading.AuthLoading$State$SocialAccountAuth] */
    private final Out<AuthLoading.State, AuthLoading.Action> handleProgressState(AuthLoading.State.Progress state, AuthLoading.Action action) {
        Out.Companion companion;
        Function jVar;
        AuthLoading.State.Progress progress;
        if (action instanceof AuthLoading.Action.Load) {
            companion = Out.INSTANCE;
            jVar = new k(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.EnrollmentSuccess) {
            companion = Out.INSTANCE;
            jVar = new l(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.RegistrationSuccess) {
            companion = Out.INSTANCE;
            jVar = new m(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.LoginSuccess) {
            companion = Out.INSTANCE;
            jVar = new n(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.LoginSocialAccount) {
            companion = Out.INSTANCE;
            ?? socialAccountAuth = new AuthLoading.State.SocialAccountAuth(((AuthLoading.Action.LoginSocialAccount) action).getProcess());
            jVar = new o();
            progress = socialAccountAuth;
        } else if (action instanceof AuthLoading.Action.LoginDefault) {
            companion = Out.INSTANCE;
            jVar = new p(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.MigrationSuccess) {
            companion = Out.INSTANCE;
            jVar = new q(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.ExecuteEnrollmentSetPhone) {
            companion = Out.INSTANCE;
            jVar = new r(action);
            progress = state;
        } else if (action instanceof AuthLoading.Action.ExecuteRegistrationSetPhone) {
            companion = Out.INSTANCE;
            jVar = new s(action);
            progress = state;
        } else {
            if (action instanceof AuthLoading.Action.ExecuteEnterIdentifier) {
                return Out.INSTANCE.invoke(AuthLoading.State.Progress.INSTANCE, new c(action));
            }
            if (action instanceof AuthLoading.Action.EnterIdentifierSuccess) {
                companion = Out.INSTANCE;
                jVar = new d(action);
                progress = state;
            } else if (action instanceof AuthLoading.Action.EnrollmentSetPhoneSuccess) {
                companion = Out.INSTANCE;
                jVar = new e(action);
                progress = state;
            } else if (action instanceof AuthLoading.Action.RegistrationSetPhoneSuccess) {
                companion = Out.INSTANCE;
                jVar = new f(action);
                progress = state;
            } else if (action instanceof AuthLoading.Action.Fail) {
                companion = Out.INSTANCE;
                ?? error = new AuthLoading.State.Error(((AuthLoading.Action.Fail) action).getFailure());
                jVar = new g();
                progress = error;
            } else if (action instanceof AuthLoading.Action.HandleSberIdResponse) {
                companion = Out.INSTANCE;
                jVar = new h(action);
                progress = state;
            } else if (action instanceof AuthLoading.Action.HandleVkIdResponse) {
                companion = Out.INSTANCE;
                jVar = new i(action);
                progress = state;
            } else {
                if (!(action instanceof AuthLoading.Action.HandleEsiaResponse)) {
                    return Out.INSTANCE.skip(state, this.source);
                }
                companion = Out.INSTANCE;
                jVar = new j(action);
                progress = state;
            }
        }
        return companion.invoke(progress, jVar);
    }

    private final Out<AuthLoading.State, AuthLoading.Action> handleSocialAccountAuthState(AuthLoading.State.SocialAccountAuth state, AuthLoading.Action action) {
        Out.Companion companion;
        AuthLoading.State.Progress progress;
        Function vVar;
        if (action instanceof AuthLoading.Action.HandleSberIdResponse) {
            companion = Out.INSTANCE;
            progress = AuthLoading.State.Progress.INSTANCE;
            vVar = new t(action);
        } else if (action instanceof AuthLoading.Action.HandleVkIdResponse) {
            companion = Out.INSTANCE;
            progress = AuthLoading.State.Progress.INSTANCE;
            vVar = new u(action);
        } else {
            if (!(action instanceof AuthLoading.Action.HandleEsiaResponse)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            progress = AuthLoading.State.Progress.INSTANCE;
            vVar = new v(action);
        }
        return companion.invoke(progress, vVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<AuthLoading.State, AuthLoading.Action> invoke(AuthLoading.State state, AuthLoading.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof AuthLoading.State.Progress) {
            return handleProgressState((AuthLoading.State.Progress) state, action);
        }
        if (state instanceof AuthLoading.State.Error) {
            return handleErrorState((AuthLoading.State.Error) state, action);
        }
        if (state instanceof AuthLoading.State.SocialAccountAuth) {
            return handleSocialAccountAuthState((AuthLoading.State.SocialAccountAuth) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
