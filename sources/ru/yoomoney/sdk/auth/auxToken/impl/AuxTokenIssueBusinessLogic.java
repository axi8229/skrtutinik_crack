package ru.yoomoney.sdk.auth.auxToken.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bu\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b \u0010!R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "interactor", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;)V", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$LoadingAuxAuthorizationInfo;", "state", "action", "handleLoadingAuxAuthorizationInfoState", "(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$LoadingAuxAuthorizationInfo;Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfo;", "handleAuxAuthorizationInfoState", "(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfo;Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfoError;", "handleAuxAuthorizationInfoErrorState", "(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfoError;Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$IssuingToken;", "handleIssuingTokenState", "(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$IssuingToken;Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssueBusinessLogic implements Function2<AuxTokenIssue.State, AuxTokenIssue.Action, Out<? extends AuxTokenIssue.State, ? extends AuxTokenIssue.Action>> {
    private final AuxTokenIssueInteractor interactor;
    private final Function2<AuxTokenIssue.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<AuxTokenIssue.State, Continuation<? super AuxTokenIssue.Action>, Object> showState;
    private final Function1<Continuation<? super AuxTokenIssue.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action>, Unit> {
        public final /* synthetic */ AuxTokenIssue.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AuxTokenIssue.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.a(AuxTokenIssueBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.b(AuxTokenIssueBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action>, Unit> {
        public final /* synthetic */ AuxTokenIssue.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AuxTokenIssue.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.c(AuxTokenIssueBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.d(AuxTokenIssueBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action>, Unit> {
        public final /* synthetic */ AuxTokenIssue.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AuxTokenIssue.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.IssuingToken, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.e(AuxTokenIssueBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, AuxTokenIssueBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action>, Unit> {
        public final /* synthetic */ AuxTokenIssue.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AuxTokenIssue.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.f(AuxTokenIssueBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.auxToken.impl.g(AuxTokenIssueBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action>, Unit> {
        public final /* synthetic */ AuxTokenIssue.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AuxTokenIssue.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.LoadingAuxAuthorizationInfo, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, AuxTokenIssueBusinessLogic.this.source);
            CoreKt.input(invoke, new h(AuxTokenIssueBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfo, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new i(AuxTokenIssueBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfoError, AuxTokenIssue.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfoError, AuxTokenIssue.Action> builder) {
            Out.Builder<? extends AuxTokenIssue.State.AuxAuthorizationInfoError, AuxTokenIssue.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new j(AuxTokenIssueBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuxTokenIssueBusinessLogic(Function2<? super AuxTokenIssue.State, ? super Continuation<? super AuxTokenIssue.Action>, ? extends Object> showState, Function2<? super AuxTokenIssue.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super AuxTokenIssue.Action>, ? extends Object> source, AuxTokenIssueInteractor interactor) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
    }

    private final Out<AuxTokenIssue.State, AuxTokenIssue.Action> handleAuxAuthorizationInfoErrorState(AuxTokenIssue.State.AuxAuthorizationInfoError state, AuxTokenIssue.Action action) {
        return action instanceof AuxTokenIssue.Action.LoadAuxAuthorizationInfo ? Out.INSTANCE.invoke(AuxTokenIssue.State.LoadingAuxAuthorizationInfo.INSTANCE, new a(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuxTokenIssue.State, AuxTokenIssue.Action> handleAuxAuthorizationInfoState(AuxTokenIssue.State.AuxAuthorizationInfo state, AuxTokenIssue.Action action) {
        return action instanceof AuxTokenIssue.Action.IssueAuxToken ? Out.INSTANCE.invoke(new AuxTokenIssue.State.IssuingToken(state.getAccount(), state.getApplicationInfo()), new b(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuxTokenIssue.State, AuxTokenIssue.Action> handleIssuingTokenState(AuxTokenIssue.State.IssuingToken state, AuxTokenIssue.Action action) {
        return action instanceof AuxTokenIssue.Action.AuxTokenIssued ? Out.INSTANCE.invoke(state, new c(action)) : action instanceof AuxTokenIssue.Action.AuxTokenIssueFailed ? Out.INSTANCE.invoke(new AuxTokenIssue.State.AuxAuthorizationInfo(state.getAccount(), state.getApplicationInfo()), new d(action)) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<AuxTokenIssue.State, AuxTokenIssue.Action> handleLoadingAuxAuthorizationInfoState(AuxTokenIssue.State.LoadingAuxAuthorizationInfo state, AuxTokenIssue.Action action) {
        Out.Companion companion;
        AuxTokenIssue.State auxAuthorizationInfoError;
        Function gVar;
        if (action instanceof AuxTokenIssue.Action.LoadAuxAuthorizationInfo) {
            return Out.INSTANCE.invoke(state, new e(action));
        }
        if (action instanceof AuxTokenIssue.Action.LoadAuxAuthorizationInfoSuccess) {
            companion = Out.INSTANCE;
            AuxTokenIssue.Action.LoadAuxAuthorizationInfoSuccess loadAuxAuthorizationInfoSuccess = (AuxTokenIssue.Action.LoadAuxAuthorizationInfoSuccess) action;
            auxAuthorizationInfoError = new AuxTokenIssue.State.AuxAuthorizationInfo(loadAuxAuthorizationInfoSuccess.getAccount(), loadAuxAuthorizationInfoSuccess.getApplicationInfo());
            gVar = new f();
        } else {
            if (!(action instanceof AuxTokenIssue.Action.LoadAuxAuthorizationInfoFailed)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            auxAuthorizationInfoError = new AuxTokenIssue.State.AuxAuthorizationInfoError(((AuxTokenIssue.Action.LoadAuxAuthorizationInfoFailed) action).getFailure());
            gVar = new g();
        }
        return companion.invoke(auxAuthorizationInfoError, gVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<AuxTokenIssue.State, AuxTokenIssue.Action> invoke(AuxTokenIssue.State state, AuxTokenIssue.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof AuxTokenIssue.State.LoadingAuxAuthorizationInfo) {
            return handleLoadingAuxAuthorizationInfoState((AuxTokenIssue.State.LoadingAuxAuthorizationInfo) state, action);
        }
        if (state instanceof AuxTokenIssue.State.AuxAuthorizationInfo) {
            return handleAuxAuthorizationInfoState((AuxTokenIssue.State.AuxAuthorizationInfo) state, action);
        }
        if (state instanceof AuxTokenIssue.State.AuxAuthorizationInfoError) {
            return handleAuxAuthorizationInfoErrorState((AuxTokenIssue.State.AuxAuthorizationInfoError) state, action);
        }
        if (state instanceof AuxTokenIssue.State.IssuingToken) {
            return handleIssuingTokenState((AuxTokenIssue.State.IssuingToken) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
