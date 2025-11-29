package ru.yoomoney.sdk.auth.qrAuth.success.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccess;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005BI\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0012R0\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R*\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/success/impl/QrAuthSuccessBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$State;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Effect;", "Lkotlin/coroutines/Continuation;", "", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$State;Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthSuccessBusinessLogic implements Function2<QrAuthSuccess.State, QrAuthSuccess.Action, Out<? extends QrAuthSuccess.State, ? extends QrAuthSuccess.Action>> {
    private final Function2<QrAuthSuccess.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function1<Continuation<? super QrAuthSuccess.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends QrAuthSuccess.State, QrAuthSuccess.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends QrAuthSuccess.State, QrAuthSuccess.Action> builder) {
            Out.Builder<? extends QrAuthSuccess.State, QrAuthSuccess.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.qrAuth.success.impl.a(QrAuthSuccessBusinessLogic.this, null));
            CoreKt.input(invoke, QrAuthSuccessBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QrAuthSuccessBusinessLogic(Function2<? super QrAuthSuccess.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super QrAuthSuccess.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<QrAuthSuccess.State, QrAuthSuccess.Action> handleContentState(QrAuthSuccess.State state, QrAuthSuccess.Action action) {
        if (action instanceof QrAuthSuccess.Action.Close) {
            return Out.INSTANCE.invoke(state, new a());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<QrAuthSuccess.State, QrAuthSuccess.Action> invoke(QrAuthSuccess.State state, QrAuthSuccess.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof QrAuthSuccess.State.Content) {
            return handleContentState(state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
