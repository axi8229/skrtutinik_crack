package ru.yoomoney.sdk.auth.oauth.failure.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.oauth.failure.OauthFailure;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005BI\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R0\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R*\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/failure/impl/OauthFailureBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$State;", "Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$Effect;", "Lkotlin/coroutines/Continuation;", "", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$State$Content;Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$State;Lru/yoomoney/sdk/auth/oauth/failure/OauthFailure$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthFailureBusinessLogic implements Function2<OauthFailure.State, OauthFailure.Action, Out<? extends OauthFailure.State, ? extends OauthFailure.Action>> {
    private final Function2<OauthFailure.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function1<Continuation<? super OauthFailure.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends OauthFailure.State.Content, OauthFailure.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthFailure.State.Content, OauthFailure.Action> builder) {
            Out.Builder<? extends OauthFailure.State.Content, OauthFailure.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.oauth.failure.impl.a(OauthFailureBusinessLogic.this, null));
            CoreKt.input(invoke, OauthFailureBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OauthFailureBusinessLogic(Function2<? super OauthFailure.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super OauthFailure.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<OauthFailure.State, OauthFailure.Action> handleContentState(OauthFailure.State.Content state, OauthFailure.Action action) {
        if (action instanceof OauthFailure.Action.Exit) {
            return Out.INSTANCE.invoke(state, new a());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<OauthFailure.State, OauthFailure.Action> invoke(OauthFailure.State state, OauthFailure.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof OauthFailure.State.Content) {
            return handleContentState((OauthFailure.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
