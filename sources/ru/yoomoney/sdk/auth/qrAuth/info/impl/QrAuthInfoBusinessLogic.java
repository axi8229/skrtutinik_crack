package ru.yoomoney.sdk.auth.qrAuth.info.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bu\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b \u0010!R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;", "interactor", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;)V", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$Loading;", "state", "action", "handleStateLoading", "(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$Loading;Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$Content;", "handStateContent", "(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$Content;Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$ErrorInfo;", "handStateErrorInfo", "(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$ErrorInfo;Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$ErrorAccept;", "handStateErrorAccept", "(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State$ErrorAccept;Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State;Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthInfoBusinessLogic implements Function2<QrAuthInfo.State, QrAuthInfo.Action, Out<? extends QrAuthInfo.State, ? extends QrAuthInfo.Action>> {
    private final QrAuthInfoInteractor interactor;
    private final Function2<QrAuthInfo.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<QrAuthInfo.State, Continuation<? super QrAuthInfo.Action>, Object> showState;
    private final Function1<Continuation<? super QrAuthInfo.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.a(QrAuthInfoBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.b(QrAuthInfoBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.c(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.d(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.e(QrAuthInfoBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.f(QrAuthInfoBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.g(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.h(QrAuthInfoBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.i(QrAuthInfoBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.j(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.k(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.ErrorAccept, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.l(QrAuthInfoBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.m(QrAuthInfoBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.n(QrAuthInfoBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.qrAuth.info.impl.o(QrAuthInfoBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action>, Unit> {
        public m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.ErrorInfo, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new p(QrAuthInfoBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action>, Unit> {
        public final /* synthetic */ QrAuthInfo.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(QrAuthInfo.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Loading, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new q(QrAuthInfoBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, QrAuthInfoBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action>, Unit> {
        public o() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> builder) {
            Out.Builder<? extends QrAuthInfo.State.Content, QrAuthInfo.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new r(QrAuthInfoBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QrAuthInfoBusinessLogic(Function2<? super QrAuthInfo.State, ? super Continuation<? super QrAuthInfo.Action>, ? extends Object> showState, Function2<? super QrAuthInfo.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super QrAuthInfo.Action>, ? extends Object> source, QrAuthInfoInteractor interactor) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
    }

    private final Out<QrAuthInfo.State, QrAuthInfo.Action> handStateContent(QrAuthInfo.State.Content state, QrAuthInfo.Action action) {
        Out.Companion companion;
        Function cVar;
        if (action instanceof QrAuthInfo.Action.Accept) {
            return Out.INSTANCE.invoke(QrAuthInfo.State.Loading.INSTANCE, new a(action));
        }
        if (action instanceof QrAuthInfo.Action.Deny) {
            companion = Out.INSTANCE;
            cVar = new b();
        } else {
            if (!(action instanceof QrAuthInfo.Action.Close)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            cVar = new c();
        }
        return companion.invoke(state, cVar);
    }

    private final Out<QrAuthInfo.State, QrAuthInfo.Action> handStateErrorAccept(QrAuthInfo.State.ErrorAccept state, QrAuthInfo.Action action) {
        return action instanceof QrAuthInfo.Action.Accept ? Out.INSTANCE.invoke(QrAuthInfo.State.Loading.INSTANCE, new d(action)) : action instanceof QrAuthInfo.Action.Close ? Out.INSTANCE.invoke(state, new e()) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<QrAuthInfo.State, QrAuthInfo.Action> handStateErrorInfo(QrAuthInfo.State.ErrorInfo state, QrAuthInfo.Action action) {
        return action instanceof QrAuthInfo.Action.LoadInfo ? Out.INSTANCE.invoke(QrAuthInfo.State.Loading.INSTANCE, new f(action)) : action instanceof QrAuthInfo.Action.Close ? Out.INSTANCE.invoke(state, new g()) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<QrAuthInfo.State, QrAuthInfo.Action> handleStateLoading(QrAuthInfo.State.Loading state, QrAuthInfo.Action action) {
        Out.Companion companion;
        Object content;
        Function oVar;
        Out.Companion companion2;
        Function nVar;
        Out.Companion companion3;
        Function kVar;
        if (!(action instanceof QrAuthInfo.Action.Close)) {
            if (!(action instanceof QrAuthInfo.Action.AcceptError)) {
                if (action instanceof QrAuthInfo.Action.AcceptFailure) {
                    companion2 = Out.INSTANCE;
                    nVar = new j(action);
                } else if (action instanceof QrAuthInfo.Action.AcceptSuccess) {
                    companion3 = Out.INSTANCE;
                    kVar = new k();
                } else if (action instanceof QrAuthInfo.Action.LoadInfo) {
                    companion2 = Out.INSTANCE;
                    nVar = new l(action);
                } else if (action instanceof QrAuthInfo.Action.LoadInfoError) {
                    companion = Out.INSTANCE;
                    content = new QrAuthInfo.State.ErrorInfo(((QrAuthInfo.Action.LoadInfoError) action).getFailure());
                    oVar = new m();
                } else if (action instanceof QrAuthInfo.Action.LoadInfoFailure) {
                    companion2 = Out.INSTANCE;
                    nVar = new n(action);
                } else {
                    if (!(action instanceof QrAuthInfo.Action.LoadInfoSuccess)) {
                        return Out.INSTANCE.skip(state, this.source);
                    }
                    companion = Out.INSTANCE;
                    content = new QrAuthInfo.State.Content(((QrAuthInfo.Action.LoadInfoSuccess) action).getInfo());
                    oVar = new o();
                }
                return companion2.invoke(state, nVar);
            }
            companion = Out.INSTANCE;
            content = new QrAuthInfo.State.ErrorAccept(((QrAuthInfo.Action.AcceptError) action).getFailure());
            oVar = new i();
            return companion.invoke(content, oVar);
        }
        companion3 = Out.INSTANCE;
        kVar = new h();
        return companion3.invoke(state, kVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<QrAuthInfo.State, QrAuthInfo.Action> invoke(QrAuthInfo.State state, QrAuthInfo.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof QrAuthInfo.State.Loading) {
            return handleStateLoading((QrAuthInfo.State.Loading) state, action);
        }
        if (state instanceof QrAuthInfo.State.Content) {
            return handStateContent((QrAuthInfo.State.Content) state, action);
        }
        if (state instanceof QrAuthInfo.State.ErrorInfo) {
            return handStateErrorInfo((QrAuthInfo.State.ErrorInfo) state, action);
        }
        if (state instanceof QrAuthInfo.State.ErrorAccept) {
            return handStateErrorAccept((QrAuthInfo.State.ErrorAccept) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
