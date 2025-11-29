package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/EmailConfirmBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractor;", "interactor", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractor;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Invalid;", "state", "action", "handleInvalidState", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Invalid;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Valid;", "handleValidState", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Valid;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Progress;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractor;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailConfirmBusinessLogic implements Function2<EmailConfirm.State, EmailConfirm.Action, Out<? extends EmailConfirm.State, ? extends EmailConfirm.Action>> {
    private final EmailConfirm.AnalyticsLogger analyticsLogger;
    private final BaseEmailConfirmInteractor interactor;
    private final Function2<EmailConfirm.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<EmailConfirm.State, Continuation<? super EmailConfirm.Action>, Object> showState;
    private final Function1<Continuation<? super EmailConfirm.Action>, Object> source;

    public static final class A extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public A() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new G(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class B extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new H(EmailConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new I(EmailConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class C extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public C() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new J(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class D extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new K(EmailConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new L(EmailConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$a, reason: case insensitive filesystem */
    public static final class C2108a extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2108a(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2112a(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$b, reason: case insensitive filesystem */
    public static final class C2109b extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public C2109b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2113b(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$c, reason: case insensitive filesystem */
    public static final class C2110c extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public C2110c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2114c(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ru.yoomoney.sdk.auth.email.confirm.impl.EmailConfirmBusinessLogic$d, reason: case insensitive filesystem */
    public static final class C2111d extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2111d(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2115d(EmailConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2116e(EmailConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2117f(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2118g(EmailConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new C2119h(EmailConfirmBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2120i(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2121j(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2122k(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2123l(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new C2124m(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2125n(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;
        public final /* synthetic */ EmailConfirm.State.Progress c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(EmailConfirm.Action action, EmailConfirm.State.Progress progress) {
            super(1);
            this.b = action;
            this.c = progress;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.o(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.p(EmailConfirmBusinessLogic.this, this.c, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.q(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public n() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.r(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.s(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.t(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class p extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public p() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.u(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public q() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.v(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public r() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.x(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public s() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.y(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class t extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public t() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.z(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class u extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public u() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.A(EmailConfirmBusinessLogic.this, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class v extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.w(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class w extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public w() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.B(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class x extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action>, Unit> {
        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Invalid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.C(EmailConfirmBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class y extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(EmailConfirm.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Valid, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.confirm.impl.D(EmailConfirmBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class z extends Lambda implements Function1<Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action>, Unit> {
        public final /* synthetic */ EmailConfirm.State.Valid b;
        public final /* synthetic */ EmailConfirm.Action c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(EmailConfirm.State.Valid valid, EmailConfirm.Action action) {
            super(1);
            this.b = valid;
            this.c = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> builder) {
            Out.Builder<? extends EmailConfirm.State.Progress, EmailConfirm.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new E(EmailConfirmBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new F(EmailConfirmBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmailConfirmBusinessLogic(Function2<? super EmailConfirm.State, ? super Continuation<? super EmailConfirm.Action>, ? extends Object> showState, Function2<? super EmailConfirm.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super EmailConfirm.Action>, ? extends Object> source, BaseEmailConfirmInteractor interactor, EmailConfirm.AnalyticsLogger analyticsLogger) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Progress] */
    /* JADX WARN: Type inference failed for: r11v7, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Progress] */
    private final Out<EmailConfirm.State, EmailConfirm.Action> handleInvalidState(EmailConfirm.State.Invalid state, EmailConfirm.Action action) {
        Out.Companion companion;
        Function iVar;
        Out.Companion companion2;
        EmailConfirm.State stateCopy$default;
        Function hVar;
        Out.Companion companion3;
        Function fVar;
        EmailConfirm.State.Invalid invalid;
        EmailConfirm.State.Invalid invalid2;
        if (!(action instanceof EmailConfirm.Action.CodeChanged)) {
            if (action instanceof EmailConfirm.Action.CodeValid) {
                companion2 = Out.INSTANCE;
                EmailConfirm.Action.CodeValid codeValid = (EmailConfirm.Action.CodeValid) action;
                stateCopy$default = new EmailConfirm.State.Valid(codeValid.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), codeValid.getSecretLength());
                hVar = new C2109b();
            } else if (action instanceof EmailConfirm.Action.CodeInvalid) {
                companion2 = Out.INSTANCE;
                stateCopy$default = EmailConfirm.State.Invalid.copy$default(state, ((EmailConfirm.Action.CodeInvalid) action).getCode(), null, null, false, false, 0, 60, null);
                hVar = new C2110c();
            } else {
                if (!(action instanceof EmailConfirm.Action.Retry)) {
                    if (action instanceof EmailConfirm.Action.StopTimer) {
                        companion = Out.INSTANCE;
                        EmailConfirm.State.Invalid invalidCopy$default = EmailConfirm.State.Invalid.copy$default(state, null, null, null, true, false, 0, 55, null);
                        iVar = new e();
                        invalid = invalidCopy$default;
                    } else if (action instanceof EmailConfirm.Action.Forgot) {
                        companion3 = Out.INSTANCE;
                        ?? progress = new EmailConfirm.State.Progress(state.getCode(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength());
                        fVar = new f(action);
                        invalid2 = progress;
                    } else if (action instanceof EmailConfirm.Action.ShowHelp) {
                        companion = Out.INSTANCE;
                        iVar = new g();
                        invalid = state;
                    } else if (action instanceof EmailConfirm.Action.OffersChecked) {
                        companion2 = Out.INSTANCE;
                        stateCopy$default = EmailConfirm.State.Invalid.copy$default(state, null, null, null, false, ((EmailConfirm.Action.OffersChecked) action).isChecked(), 0, 47, null);
                        hVar = new h();
                    } else {
                        if (!(action instanceof EmailConfirm.Action.ToEmailEntered)) {
                            return Out.INSTANCE.skip(state, this.source);
                        }
                        companion = Out.INSTANCE;
                        iVar = new i();
                        invalid = state;
                    }
                    return companion.invoke(invalid, iVar);
                }
                companion3 = Out.INSTANCE;
                ?? progress2 = new EmailConfirm.State.Progress(state.getCode(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength());
                fVar = new C2111d(action);
                invalid2 = progress2;
            }
            return companion2.invoke(stateCopy$default, hVar);
        }
        companion3 = Out.INSTANCE;
        fVar = new C2108a(action);
        invalid2 = state;
        return companion3.invoke(invalid2, fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Valid] */
    /* JADX WARN: Type inference failed for: r12v5, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Invalid] */
    /* JADX WARN: Type inference failed for: r12v8, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Valid] */
    private final Out<EmailConfirm.State, EmailConfirm.Action> handleProgressState(EmailConfirm.State.Progress state, EmailConfirm.Action action) {
        Out.Companion companion;
        EmailConfirm.State stateCopy$default;
        Function qVar;
        Out.Companion companion2;
        Function pVar;
        EmailConfirm.State.Progress progress;
        Out.Companion companion3;
        Function lVar;
        EmailConfirm.State.Progress progress2;
        if (!(action instanceof EmailConfirm.Action.ConfirmEmailSuccess)) {
            if (action instanceof EmailConfirm.Action.ConfirmEmailFail) {
                companion = Out.INSTANCE;
                stateCopy$default = new EmailConfirm.State.Invalid(state.getCode(), ((EmailConfirm.Action.ConfirmEmailFail) action).getError(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength());
                qVar = new k();
            } else {
                if (!(action instanceof EmailConfirm.Action.ConfirmEmailTechnicalError)) {
                    if (action instanceof EmailConfirm.Action.CodeValid) {
                        companion2 = Out.INSTANCE;
                        ?? valid = new EmailConfirm.State.Valid(state.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength(), 2, null);
                        pVar = new m();
                        progress = valid;
                    } else if (action instanceof EmailConfirm.Action.CodeInvalid) {
                        companion2 = Out.INSTANCE;
                        ?? invalid = new EmailConfirm.State.Invalid(state.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength(), 2, null);
                        pVar = new n();
                        progress = invalid;
                    } else {
                        if (action instanceof EmailConfirm.Action.ForgotEmailSuccess) {
                            return Out.INSTANCE.invoke(new EmailConfirm.State.Valid(state.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), 0, 34, null), new o(action));
                        }
                        if (action instanceof EmailConfirm.Action.ShowHelp) {
                            companion2 = Out.INSTANCE;
                            pVar = new p();
                            progress = state;
                        } else {
                            if (!(action instanceof EmailConfirm.Action.OffersChecked)) {
                                return Out.INSTANCE.skip(state, this.source);
                            }
                            companion = Out.INSTANCE;
                            stateCopy$default = EmailConfirm.State.Progress.copy$default(state, null, null, false, ((EmailConfirm.Action.OffersChecked) action).isChecked(), 0, 23, null);
                            qVar = new q();
                        }
                    }
                    return companion2.invoke(progress, pVar);
                }
                companion3 = Out.INSTANCE;
                lVar = new l(action, state);
                progress2 = state;
            }
            return companion.invoke(stateCopy$default, qVar);
        }
        companion3 = Out.INSTANCE;
        ?? valid2 = new EmailConfirm.State.Valid(state.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength(), 2, null);
        lVar = new j(action);
        progress2 = valid2;
        return companion3.invoke(progress2, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Progress] */
    /* JADX WARN: Type inference failed for: r11v5, types: [ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$State$Progress] */
    private final Out<EmailConfirm.State, EmailConfirm.Action> handleValidState(EmailConfirm.State.Valid state, EmailConfirm.Action action) {
        Out.Companion companion;
        Function uVar;
        Out.Companion companion2;
        EmailConfirm.State stateCopy$default;
        Function tVar;
        Out.Companion companion3;
        Function d;
        EmailConfirm.State.Valid valid;
        EmailConfirm.State.Valid valid2;
        if (!(action instanceof EmailConfirm.Action.CodeChanged)) {
            if (action instanceof EmailConfirm.Action.CodeValid) {
                companion2 = Out.INSTANCE;
                stateCopy$default = EmailConfirm.State.Valid.copy$default(state, ((EmailConfirm.Action.CodeValid) action).getCode(), null, null, false, false, 0, 60, null);
                tVar = new w();
            } else if (action instanceof EmailConfirm.Action.CodeInvalid) {
                companion2 = Out.INSTANCE;
                EmailConfirm.Action.CodeInvalid codeInvalid = (EmailConfirm.Action.CodeInvalid) action;
                stateCopy$default = new EmailConfirm.State.Invalid(codeInvalid.getCode(), null, state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), codeInvalid.getSecretLength());
                tVar = new x();
            } else {
                if (!(action instanceof EmailConfirm.Action.CheckExpiration)) {
                    if (action instanceof EmailConfirm.Action.Submit) {
                        return Out.INSTANCE.invoke(new EmailConfirm.State.Progress(state.getCode(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength()), new z(state, action));
                    }
                    if (action instanceof EmailConfirm.Action.RestartProcess) {
                        companion = Out.INSTANCE;
                        uVar = new A();
                        valid = state;
                    } else if (action instanceof EmailConfirm.Action.Retry) {
                        companion3 = Out.INSTANCE;
                        ?? progress = new EmailConfirm.State.Progress(state.getCode(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength());
                        d = new B(action);
                        valid2 = progress;
                    } else if (action instanceof EmailConfirm.Action.StopTimer) {
                        companion = Out.INSTANCE;
                        EmailConfirm.State.Valid validCopy$default = EmailConfirm.State.Valid.copy$default(state, null, null, null, true, false, 0, 55, null);
                        uVar = new C();
                        valid = validCopy$default;
                    } else if (action instanceof EmailConfirm.Action.Forgot) {
                        companion3 = Out.INSTANCE;
                        ?? progress2 = new EmailConfirm.State.Progress(state.getCode(), state.getNextResendFrom(), state.isEnabledRetry(), state.getOffersIsChecked(), state.getSecretLength());
                        d = new D(action);
                        valid2 = progress2;
                    } else if (action instanceof EmailConfirm.Action.Expired) {
                        companion = Out.INSTANCE;
                        uVar = new r();
                        valid = state;
                    } else if (action instanceof EmailConfirm.Action.ShowHelp) {
                        companion = Out.INSTANCE;
                        uVar = new s();
                        valid = state;
                    } else if (action instanceof EmailConfirm.Action.OffersChecked) {
                        companion2 = Out.INSTANCE;
                        stateCopy$default = EmailConfirm.State.Valid.copy$default(state, null, null, null, false, ((EmailConfirm.Action.OffersChecked) action).isChecked(), 0, 47, null);
                        tVar = new t();
                    } else {
                        if (!(action instanceof EmailConfirm.Action.ToEmailEntered)) {
                            return Out.INSTANCE.skip(state, this.source);
                        }
                        companion = Out.INSTANCE;
                        uVar = new u();
                        valid = state;
                    }
                    return companion.invoke(valid, uVar);
                }
                companion3 = Out.INSTANCE;
                d = new y(action);
                valid2 = state;
            }
            return companion2.invoke(stateCopy$default, tVar);
        }
        companion3 = Out.INSTANCE;
        d = new v(action);
        valid2 = state;
        return companion3.invoke(valid2, d);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<EmailConfirm.State, EmailConfirm.Action> invoke(EmailConfirm.State state, EmailConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        EmailConfirm.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof EmailConfirm.State.Invalid) {
            return handleInvalidState((EmailConfirm.State.Invalid) state, action);
        }
        if (state instanceof EmailConfirm.State.Valid) {
            return handleValidState((EmailConfirm.State.Valid) state, action);
        }
        if (state instanceof EmailConfirm.State.Progress) {
            return handleProgressState((EmailConfirm.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
