package ru.yoomoney.sdk.auth.password.finish.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010 ¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/password/finish/impl/PasswordFinishBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$BusinessLogicEventsSender;", "businessLogicEventsSender", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$BusinessLogicEventsSender;Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State$Login;", "state", "action", "handleLogin", "(Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State$Login;Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State$Content;", "handleContent", "(Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State$Content;Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State;Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordFinishBusinessLogic implements Function2<PasswordFinish.State, PasswordFinish.Action, Out<? extends PasswordFinish.State, ? extends PasswordFinish.Action>> {
    private final PasswordFinish.AnalyticsLogger analyticsLogger;
    private final Function2<PasswordFinish.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PasswordFinish.State, Continuation<? super PasswordFinish.Action>, Object> showState;
    private final Function1<Continuation<? super PasswordFinish.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> builder) {
            Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.finish.impl.a(PasswordFinishBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action> builder) {
            Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.finish.impl.b(PasswordFinishBusinessLogic.this, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.password.finish.impl.c(PasswordFinishBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action>, Unit> {
        public final /* synthetic */ PasswordFinish.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PasswordFinish.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action> builder) {
            Out.Builder<? extends PasswordFinish.State.Login, PasswordFinish.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.password.finish.impl.d(PasswordFinishBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PasswordFinishBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> builder) {
            Out.Builder<? extends PasswordFinish.State.Content, PasswordFinish.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new e(PasswordFinishBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PasswordFinishBusinessLogic(Function2<? super PasswordFinish.State, ? super Continuation<? super PasswordFinish.Action>, ? extends Object> showState, Function2<? super PasswordFinish.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PasswordFinish.Action>, ? extends Object> source, PasswordFinish.BusinessLogicEventsSender businessLogicEventsSender, PasswordFinish.AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(businessLogicEventsSender, "businessLogicEventsSender");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.analyticsLogger = analyticsLogger;
        businessLogicEventsSender.send();
    }

    private final Out<PasswordFinish.State, PasswordFinish.Action> handleContent(PasswordFinish.State.Content state, PasswordFinish.Action action) {
        Out.Companion companion;
        Object obj;
        Function bVar;
        if (action instanceof PasswordFinish.Action.ShowContent) {
            companion = Out.INSTANCE;
            obj = PasswordFinish.State.Content.INSTANCE;
            bVar = new a();
        } else {
            if (!(action instanceof PasswordFinish.Action.Login)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            obj = PasswordFinish.State.Login.INSTANCE;
            bVar = new b();
        }
        return companion.invoke(obj, bVar);
    }

    private final Out<PasswordFinish.State, PasswordFinish.Action> handleLogin(PasswordFinish.State.Login state, PasswordFinish.Action action) {
        return action instanceof PasswordFinish.Action.CloseWithResult ? Out.INSTANCE.invoke(state, new c(action)) : Intrinsics.areEqual(action, PasswordFinish.Action.CancelLogin.INSTANCE) ? Out.INSTANCE.invoke(PasswordFinish.State.Content.INSTANCE, new d()) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PasswordFinish.State, PasswordFinish.Action> invoke(PasswordFinish.State state, PasswordFinish.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PasswordFinish.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PasswordFinish.State.Login) {
            return handleLogin((PasswordFinish.State.Login) state, action);
        }
        if (state instanceof PasswordFinish.State.Content) {
            return handleContent((PasswordFinish.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
