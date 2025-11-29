package ru.yoomoney.sdk.two_fa.confirmationHelp.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.two_fa.confirmationHelp.ConfirmationHelp;

/* compiled from: ConfirmationHelpBusinessLogic.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bm\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/impl/ConfirmationHelpBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State$Content;", "state", "action", "handleContent", "(Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State$Content;Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelpBusinessLogic implements Function2<ConfirmationHelp.State, ConfirmationHelp.Action, Out<? extends ConfirmationHelp.State, ? extends ConfirmationHelp.Action>> {
    public static final int $stable = 8;
    private final Function2<ConfirmationHelp.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<ConfirmationHelp.State, Continuation<? super ConfirmationHelp.Action>, Object> showState;
    private final Function1<Continuation<? super ConfirmationHelp.Action>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public ConfirmationHelpBusinessLogic(Function2<? super ConfirmationHelp.State, ? super Continuation<? super ConfirmationHelp.Action>, ? extends Object> showState, Function2<? super ConfirmationHelp.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super ConfirmationHelp.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<ConfirmationHelp.State, ConfirmationHelp.Action> invoke(ConfirmationHelp.State state, ConfirmationHelp.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof ConfirmationHelp.State.Content) {
            return handleContent((ConfirmationHelp.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Out<ConfirmationHelp.State, ConfirmationHelp.Action> handleContent(ConfirmationHelp.State.Content state, ConfirmationHelp.Action action) {
        if (action instanceof ConfirmationHelp.Action.ShowSupport) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends ConfirmationHelp.State.Content, ConfirmationHelp.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpBusinessLogic.handleContent.1
                {
                    super(1);
                }

                /* compiled from: ConfirmationHelpBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpBusinessLogic$handleContent$1$1", f = "ConfirmationHelpBusinessLogic.kt", l = {27}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpBusinessLogic$handleContent$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03201 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ ConfirmationHelpBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03201(ConfirmationHelpBusinessLogic confirmationHelpBusinessLogic, Continuation<? super C03201> continuation) {
                        super(1, continuation);
                        this.this$0 = confirmationHelpBusinessLogic;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03201(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((C03201) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showEffect;
                            ConfirmationHelp.Effect.OpenBrowser openBrowser = ConfirmationHelp.Effect.OpenBrowser.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(openBrowser, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends ConfirmationHelp.State.Content, ConfirmationHelp.Action> builder) {
                    invoke2((Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new C03201(ConfirmationHelpBusinessLogic.this, null));
                    CoreKt.input(invoke, ConfirmationHelpBusinessLogic.this.source);
                }
            });
        }
        throw new NoWhenBranchMatchedException();
    }
}
