package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;", "interactor", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State$Progress;", "state", "action", "handleProgressState", "(Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State$Progress;Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State$Content;Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State;Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptTermsBusinessLogic implements Function2<AcceptTerms.State, AcceptTerms.Action, Out<? extends AcceptTerms.State, ? extends AcceptTerms.Action>> {
    private final AcceptTerms.AnalyticsLogger analyticsLogger;
    private final AcceptTermsInteractor interactor;
    private final Function2<AcceptTerms.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<AcceptTerms.State, Continuation<? super AcceptTerms.Action>, Object> showState;
    private final Function1<Continuation<? super AcceptTerms.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends AcceptTerms.State.Progress, AcceptTerms.Action>, Unit> {
        public final /* synthetic */ AcceptTerms.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AcceptTerms.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AcceptTerms.State.Progress, AcceptTerms.Action> builder) {
            Out.Builder<? extends AcceptTerms.State.Progress, AcceptTerms.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.acceptTerms.impl.a(AcceptTermsBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.acceptTerms.impl.b(AcceptTermsBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action>, Unit> {
        public final /* synthetic */ AcceptTerms.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AcceptTerms.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> builder) {
            Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.acceptTerms.impl.c(AcceptTermsBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new d(AcceptTermsBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action>, Unit> {
        public final /* synthetic */ AcceptTerms.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AcceptTerms.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> builder) {
            Out.Builder<? extends AcceptTerms.State.Content, AcceptTerms.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new e(AcceptTermsBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new f(AcceptTermsBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptTermsBusinessLogic(Function2<? super AcceptTerms.State, ? super Continuation<? super AcceptTerms.Action>, ? extends Object> showState, Function2<? super AcceptTerms.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super AcceptTerms.Action>, ? extends Object> source, AcceptTermsInteractor interactor, AcceptTerms.AnalyticsLogger analyticsLogger) {
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

    private final Out<AcceptTerms.State, AcceptTerms.Action> handleContentState(AcceptTerms.State.Content state, AcceptTerms.Action action) {
        return action instanceof AcceptTerms.Action.Accept ? Out.INSTANCE.invoke(AcceptTerms.State.Progress.INSTANCE, new a(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AcceptTerms.State, AcceptTerms.Action> handleProgressState(AcceptTerms.State.Progress state, AcceptTerms.Action action) {
        Out.Companion companion;
        AcceptTerms.State.Content content;
        Function cVar;
        if (action instanceof AcceptTerms.Action.EnrollmentSuccess) {
            companion = Out.INSTANCE;
            content = AcceptTerms.State.Content.INSTANCE;
            cVar = new b(action);
        } else {
            if (!(action instanceof AcceptTerms.Action.Fail)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = AcceptTerms.State.Content.INSTANCE;
            cVar = new c(action);
        }
        return companion.invoke(content, cVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<AcceptTerms.State, AcceptTerms.Action> invoke(AcceptTerms.State state, AcceptTerms.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        AcceptTerms.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof AcceptTerms.State.Progress) {
            return handleProgressState((AcceptTerms.State.Progress) state, action);
        }
        if (state instanceof AcceptTerms.State.Content) {
            return handleContentState((AcceptTerms.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
