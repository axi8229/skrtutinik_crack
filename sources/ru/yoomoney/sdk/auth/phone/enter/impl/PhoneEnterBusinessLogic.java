package ru.yoomoney.sdk.auth.phone.enter.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\"\u0010#R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/impl/PhoneEnterBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractor;", "interactor", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractor;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$PreLoad;", "state", "action", "handlePreLoadState", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$PreLoad;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Content;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Loading;", "handleLoadingState", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Loading;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Dialog;", "handleDialogState", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State$Dialog;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/phone/enter/impl/BasePhoneEnterInteractor;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneEnterBusinessLogic implements Function2<PhoneEnter.State, PhoneEnter.Action, Out<? extends PhoneEnter.State, ? extends PhoneEnter.Action>> {
    private final PhoneEnter.AnalyticsLogger analyticsLogger;
    private final BasePhoneEnterInteractor interactor;
    private final Function2<PhoneEnter.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PhoneEnter.State, Continuation<? super PhoneEnter.Action>, Object> showState;
    private final Function1<Continuation<? super PhoneEnter.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new C2170a(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Dialog, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.State.Content b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PhoneEnter.State.Content content) {
            super(1);
            this.b = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Dialog, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Dialog, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new C2171b(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.c(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, PhoneEnterBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.d(PhoneEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;
        public final /* synthetic */ PhoneEnter.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PhoneEnter.Action action, PhoneEnter.State.Content content) {
            super(1);
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.e(PhoneEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.f(PhoneEnterBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Loading, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.g(PhoneEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.h(PhoneEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.i(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.j(PhoneEnterBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.k(PhoneEnterBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.l(PhoneEnterBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.m(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.n(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.o(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.p(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.q(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.enter.impl.r(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new s(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new t(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new u(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new v(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class p extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.PreLoad, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, PhoneEnterBusinessLogic.this.source);
            CoreKt.input(invoke, new w(PhoneEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public final /* synthetic */ PhoneEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PhoneEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new x(PhoneEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new y(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action>, Unit> {
        public r() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> builder) {
            Out.Builder<? extends PhoneEnter.State.Content, PhoneEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new z(PhoneEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneEnterBusinessLogic(Function2<? super PhoneEnter.State, ? super Continuation<? super PhoneEnter.Action>, ? extends Object> showState, Function2<? super PhoneEnter.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PhoneEnter.Action>, ? extends Object> source, BasePhoneEnterInteractor interactor, PhoneEnter.AnalyticsLogger analyticsLogger) {
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

    private final Out<PhoneEnter.State, PhoneEnter.Action> handleContentState(PhoneEnter.State.Content state, PhoneEnter.Action action) {
        Out.Companion companion;
        Function iVar;
        Out.Companion companion2;
        PhoneEnter.State.Content contentCopy$default;
        Function fVar;
        if (action instanceof PhoneEnter.Action.PhoneValidated) {
            companion2 = Out.INSTANCE;
            contentCopy$default = PhoneEnter.State.Content.copy$default(state, null, ((PhoneEnter.Action.PhoneValidated) action).isValid(), false, 5, null);
            fVar = new a();
        } else {
            if (action instanceof PhoneEnter.Action.ShowCountries) {
                return Out.INSTANCE.invoke(new PhoneEnter.State.Dialog(state), new b(state));
            }
            if (action instanceof PhoneEnter.Action.CheckExpiration) {
                return Out.INSTANCE.invoke(state, new c(action));
            }
            if (action instanceof PhoneEnter.Action.SetPhone) {
                return Out.INSTANCE.invoke(new PhoneEnter.State.Loading(state.getSelectedCountry(), state.getOffersIsChecked()), new d(action, state));
            }
            if (action instanceof PhoneEnter.Action.ConfirmPhone) {
                return Out.INSTANCE.invoke(new PhoneEnter.State.Loading(state.getSelectedCountry(), state.getOffersIsChecked()), new e(action));
            }
            if (!(action instanceof PhoneEnter.Action.SelectCountry)) {
                if (action instanceof PhoneEnter.Action.RestartProcess) {
                    companion = Out.INSTANCE;
                    iVar = new g();
                } else if (action instanceof PhoneEnter.Action.OpenIdentificationInfo) {
                    companion = Out.INSTANCE;
                    iVar = new h();
                } else {
                    if (!(action instanceof PhoneEnter.Action.Expired)) {
                        return Out.INSTANCE.skip(state, this.source);
                    }
                    companion = Out.INSTANCE;
                    iVar = new i();
                }
                return companion.invoke(state, iVar);
            }
            companion2 = Out.INSTANCE;
            contentCopy$default = PhoneEnter.State.Content.copy$default(state, ((PhoneEnter.Action.SelectCountry) action).getSelectedCountry(), false, false, 6, null);
            fVar = new f();
        }
        return companion2.invoke(contentCopy$default, fVar);
    }

    private final Out<PhoneEnter.State, PhoneEnter.Action> handleDialogState(PhoneEnter.State.Dialog state, PhoneEnter.Action action) {
        return action instanceof PhoneEnter.Action.SelectCountry ? Out.INSTANCE.invoke(PhoneEnter.State.Content.copy$default(state.getContent(), ((PhoneEnter.Action.SelectCountry) action).getSelectedCountry(), false, false, 4, null), new j()) : action instanceof PhoneEnter.Action.CloseDialog ? Out.INSTANCE.invoke(state.getContent(), new k()) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PhoneEnter.State, PhoneEnter.Action> handleLoadingState(PhoneEnter.State.Loading state, PhoneEnter.Action action) {
        Out.Companion companion;
        PhoneEnter.State.Content content;
        Function oVar;
        if (action instanceof PhoneEnter.Action.PhoneSetSuccess) {
            companion = Out.INSTANCE;
            content = new PhoneEnter.State.Content(state.getSelectedCountry(), true, state.getOffersIsChecked());
            oVar = new l(action);
        } else if (action instanceof PhoneEnter.Action.RegistrationPhoneSetSuccess) {
            companion = Out.INSTANCE;
            content = new PhoneEnter.State.Content(state.getSelectedCountry(), true, state.getOffersIsChecked());
            oVar = new m(action);
        } else {
            if (action instanceof PhoneEnter.Action.PhoneConfirmSuccess) {
                return Out.INSTANCE.invoke(new PhoneEnter.State.Content(state.getSelectedCountry(), false, state.getOffersIsChecked(), 2, null), new n(action));
            }
            if (!(action instanceof PhoneEnter.Action.ShowFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = new PhoneEnter.State.Content(state.getSelectedCountry(), true, state.getOffersIsChecked());
            oVar = new o(action);
        }
        return companion.invoke(content, oVar);
    }

    private final Out<PhoneEnter.State, PhoneEnter.Action> handlePreLoadState(PhoneEnter.State.PreLoad state, PhoneEnter.Action action) {
        return action instanceof PhoneEnter.Action.LoadData ? Out.INSTANCE.invoke(state, new p(action)) : action instanceof PhoneEnter.Action.ShowContentWithPreloadedData ? Out.INSTANCE.invoke(new PhoneEnter.State.Content(((PhoneEnter.Action.ShowContentWithPreloadedData) action).getSelectedCountry(), false, false, 6, null), new q(action)) : action instanceof PhoneEnter.Action.ShowContent ? Out.INSTANCE.invoke(new PhoneEnter.State.Content(((PhoneEnter.Action.ShowContent) action).getSelectedCountry(), false, false, 6, null), new r()) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PhoneEnter.State, PhoneEnter.Action> invoke(PhoneEnter.State state, PhoneEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PhoneEnter.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PhoneEnter.State.PreLoad) {
            return handlePreLoadState((PhoneEnter.State.PreLoad) state, action);
        }
        if (state instanceof PhoneEnter.State.Content) {
            return handleContentState((PhoneEnter.State.Content) state, action);
        }
        if (state instanceof PhoneEnter.State.Loading) {
            return handleLoadingState((PhoneEnter.State.Loading) state, action);
        }
        if (state instanceof PhoneEnter.State.Dialog) {
            return handleDialogState((PhoneEnter.State.Dialog) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
