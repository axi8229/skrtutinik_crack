package ru.yoomoney.sdk.two_fa.smsConfirm.impl;

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
import org.pjsip.pjsua2.pjsip_transport_type_e;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.two_fa.domain.SessionSms;
import ru.yoomoney.sdk.two_fa.smsConfirm.SmsConfirm;

/* compiled from: SmsConfirmBusinessLogic.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$J,\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b%\u0010&R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010*¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "interactor", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$AnalyticsLogger;)V", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Init;", "state", "action", "handleInit", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Init;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$InitialError;", "handleInitialError", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$InitialError;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Confirm;", "handleConfirm", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Confirm;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Content;", "handleContent", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Content;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Error;", "handleError", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$Error;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State;Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$AnalyticsLogger;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsConfirmBusinessLogic implements Function2<SmsConfirm.State, SmsConfirm.Action, Out<? extends SmsConfirm.State, ? extends SmsConfirm.Action>> {
    public static final int $stable = 8;
    private final SmsConfirm.AnalyticsLogger analyticsLogger;
    private final SmsConfirmInteractor interactor;
    private final Function2<SmsConfirm.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<SmsConfirm.State, Continuation<? super SmsConfirm.Action>, Object> showState;
    private final Function1<Continuation<? super SmsConfirm.Action>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public SmsConfirmBusinessLogic(Function2<? super SmsConfirm.State, ? super Continuation<? super SmsConfirm.Action>, ? extends Object> showState, Function2<? super SmsConfirm.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super SmsConfirm.Action>, ? extends Object> source, SmsConfirmInteractor interactor, SmsConfirm.AnalyticsLogger analyticsLogger) {
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

    @Override // kotlin.jvm.functions.Function2
    public Out<SmsConfirm.State, SmsConfirm.Action> invoke(SmsConfirm.State state, SmsConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        SmsConfirm.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof SmsConfirm.State.Init) {
            return handleInit((SmsConfirm.State.Init) state, action);
        }
        if (state instanceof SmsConfirm.State.InitialError) {
            return handleInitialError((SmsConfirm.State.InitialError) state, action);
        }
        if (state instanceof SmsConfirm.State.Confirm) {
            return handleConfirm((SmsConfirm.State.Confirm) state, action);
        }
        if (state instanceof SmsConfirm.State.Content) {
            return handleContent((SmsConfirm.State.Content) state, action);
        }
        if (state instanceof SmsConfirm.State.Error) {
            return handleError((SmsConfirm.State.Error) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Out<SmsConfirm.State, SmsConfirm.Action> handleInit(SmsConfirm.State.Init state, SmsConfirm.Action action) {
        if (action instanceof SmsConfirm.Action.SessionStartSuccess) {
            return Out.INSTANCE.invoke(new SmsConfirm.State.Content(state.getProcessId(), ((SmsConfirm.Action.SessionStartSuccess) action).getSession(), "", false, 8, null), new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleInit.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInit$1$1", f = "SmsConfirmBusinessLogic.kt", l = {42}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInit$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03501 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03501(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> builder, Continuation<? super C03501> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03501(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((C03501) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.Content state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03501(SmsConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof SmsConfirm.Action.SessionStartFail) {
            return Out.INSTANCE.invoke(new SmsConfirm.State.InitialError(state.getProcessId(), ((SmsConfirm.Action.SessionStartFail) action).getFailure()), new Function1<Out.Builder<? extends SmsConfirm.State.InitialError, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleInit.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.InitialError, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.InitialError, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInit$2$1", f = "SmsConfirmBusinessLogic.kt", l = {50}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInit$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.InitialError, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.InitialError, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.InitialError state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.InitialError, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<SmsConfirm.State, SmsConfirm.Action> handleInitialError(final SmsConfirm.State.InitialError state, SmsConfirm.Action action) {
        return action instanceof SmsConfirm.Action.RestartSession ? Out.INSTANCE.invoke(new SmsConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleInitialError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInitialError$1$1", f = "SmsConfirmBusinessLogic.kt", l = {60}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInitialError$1$1, reason: invalid class name and collision with other inner class name */
            static final class C03511 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> $this_invoke;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03511(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> builder, Continuation<? super C03511> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C03511(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((C03511) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        SmsConfirm.State.Init state = this.$this_invoke.getState();
                        this.label = 1;
                        obj = function2.invoke(state, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInitialError$1$2", f = "SmsConfirmBusinessLogic.kt", l = {61}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleInitialError$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ SmsConfirm.State.InitialError $state;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.State.InitialError initialError, Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$state = initialError;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                        String processId = this.$state.getProcessId();
                        this.label = 1;
                        obj = smsConfirmInteractor.startAuthSession(processId, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new C03511(SmsConfirmBusinessLogic.this, invoke, null));
                CoreKt.input(invoke, new AnonymousClass2(SmsConfirmBusinessLogic.this, state, null));
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<SmsConfirm.State, SmsConfirm.Action> handleConfirm(final SmsConfirm.State.Confirm state, final SmsConfirm.Action action) {
        if (action instanceof SmsConfirm.Action.ConfirmCode) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleConfirm.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$1$1", f = "SmsConfirmBusinessLogic.kt", l = {72}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03451 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ SmsConfirm.Action $action;
                    final /* synthetic */ SmsConfirm.State.Confirm $state;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03451(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.State.Confirm confirm, SmsConfirm.Action action, Continuation<? super C03451> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$state = confirm;
                        this.$action = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03451(this.this$0, this.$state, this.$action, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((C03451) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            String code = ((SmsConfirm.Action.ConfirmCode) this.$action).getCode();
                            int attemptsLeft = this.$state.getSession().getAttemptsLeft();
                            this.label = 1;
                            obj = smsConfirmInteractor.confirmCode(processId, code, attemptsLeft, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03451(SmsConfirmBusinessLogic.this, state, action, null));
                    CoreKt.input(invoke, SmsConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof SmsConfirm.Action.ConfirmSuccess) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleConfirm.2
                {
                    super(1);
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$2$1", f = "SmsConfirmBusinessLogic.kt", l = {81}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showEffect;
                            SmsConfirm.Effect.ConfirmSmsSuccess confirmSmsSuccess = SmsConfirm.Effect.ConfirmSmsSuccess.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(confirmSmsSuccess, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, null));
                    CoreKt.input(invoke, SmsConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof SmsConfirm.Action.ConfirmFail) {
            SmsConfirm.Action.ConfirmFail confirmFail = (SmsConfirm.Action.ConfirmFail) action;
            return Out.INSTANCE.invoke(new SmsConfirm.State.Error(state.getProcessId(), SessionSms.copy$default(state.getSession(), null, null, null, null, 0, confirmFail.getAttemptsLeft(), 31, null), "", confirmFail.getFailure(), false, 16, null), new Function1<Out.Builder<? extends SmsConfirm.State.Error, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleConfirm.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Error, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$3$1", f = "SmsConfirmBusinessLogic.kt", l = {92}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.Error state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof SmsConfirm.Action.TechnicalFail) {
            return Out.INSTANCE.invoke(new SmsConfirm.State.Content(state.getProcessId(), state.getSession(), "", false, 8, null), new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleConfirm.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$4$1", f = "SmsConfirmBusinessLogic.kt", l = {101}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$4$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ SmsConfirm.Action $action;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.Action action, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$action = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$action, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showEffect;
                            SmsConfirm.Effect.ShowFailure showFailure = new SmsConfirm.Effect.ShowFailure(((SmsConfirm.Action.TechnicalFail) this.$action).getFailure());
                            this.label = 1;
                            if (function2.invoke(showFailure, this) == coroutine_suspended) {
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

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$4$2", f = "SmsConfirmBusinessLogic.kt", l = {102}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleConfirm$4$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> builder, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.Content state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, action, null));
                    CoreKt.input(invoke, new AnonymousClass2(SmsConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<SmsConfirm.State, SmsConfirm.Action> handleContent(final SmsConfirm.State.Content state, final SmsConfirm.Action action) {
        if (action instanceof SmsConfirm.Action.CodeChanged) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleContent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$1$1", f = "SmsConfirmBusinessLogic.kt", l = {112}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03461 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ SmsConfirm.Action $action;
                    final /* synthetic */ SmsConfirm.State.Content $state;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03461(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.Action action, SmsConfirm.State.Content content, Continuation<? super C03461> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$action = action;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03461(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((C03461) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                            String code = ((SmsConfirm.Action.CodeChanged) this.$action).getCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = smsConfirmInteractor.checkCode(code, codeLength, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03461(SmsConfirmBusinessLogic.this, action, state, null));
                    CoreKt.input(invoke, SmsConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof SmsConfirm.Action.ConfirmCode) {
            return Out.INSTANCE.invoke(new SmsConfirm.State.Confirm(state.getProcessId(), state.getSession(), ((SmsConfirm.Action.ConfirmCode) action).getCode(), false, 8, null), new Function1<Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Confirm, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$2$1", f = "SmsConfirmBusinessLogic.kt", l = {122}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.Confirm state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$2$2", f = "SmsConfirmBusinessLogic.kt", l = {124}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$2$2, reason: invalid class name and collision with other inner class name */
                static final class C03472 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ SmsConfirm.Action $action;
                    final /* synthetic */ SmsConfirm.State.Content $state;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03472(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.State.Content content, SmsConfirm.Action action, Continuation<? super C03472> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$state = content;
                        this.$action = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03472(this.this$0, this.$state, this.$action, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((C03472) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            String code = ((SmsConfirm.Action.ConfirmCode) this.$action).getCode();
                            int attemptsLeft = this.$state.getSession().getAttemptsLeft();
                            this.label = 1;
                            obj = smsConfirmInteractor.confirmCode(processId, code, attemptsLeft, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Confirm, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new C03472(SmsConfirmBusinessLogic.this, state, action, null));
                }
            });
        }
        return action instanceof SmsConfirm.Action.RestartSession ? Out.INSTANCE.invoke(new SmsConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleContent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$3$1", f = "SmsConfirmBusinessLogic.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_DTLS6}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$3$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> $this_invoke;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        SmsConfirm.State.Init state = this.$this_invoke.getState();
                        this.label = 1;
                        obj = function2.invoke(state, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$3$2", f = "SmsConfirmBusinessLogic.kt", l = {133}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$3$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ SmsConfirm.State.Content $state;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.State.Content content, Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$state = content;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                        String processId = this.$state.getProcessId();
                        this.label = 1;
                        obj = smsConfirmInteractor.startAuthSession(processId, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
                CoreKt.input(invoke, new AnonymousClass2(SmsConfirmBusinessLogic.this, state, null));
            }
        }) : action instanceof SmsConfirm.Action.UpdateCode ? Out.INSTANCE.invoke(SmsConfirm.State.Content.copy$default(state, null, null, ((SmsConfirm.Action.UpdateCode) action).getCode(), false, 11, null), new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleContent.4
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$4$1", f = "SmsConfirmBusinessLogic.kt", l = {136}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$4$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> $this_invoke;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        SmsConfirm.State.Content state = this.$this_invoke.getState();
                        this.label = 1;
                        obj = function2.invoke(state, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
            }
        }) : action instanceof SmsConfirm.Action.ShowHelp ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleContent.5
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$5$1", f = "SmsConfirmBusinessLogic.kt", l = {139}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleContent$5$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showEffect;
                        SmsConfirm.Effect.ShowHelp showHelp = SmsConfirm.Effect.ShowHelp.INSTANCE;
                        this.label = 1;
                        if (function2.invoke(showHelp, this) == coroutine_suspended) {
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.output(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, null));
                CoreKt.input(invoke, SmsConfirmBusinessLogic.this.source);
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<SmsConfirm.State, SmsConfirm.Action> handleError(final SmsConfirm.State.Error state, final SmsConfirm.Action action) {
        if (action instanceof SmsConfirm.Action.CodeChanged) {
            return Out.INSTANCE.invoke(new SmsConfirm.State.Content(state.getProcessId(), state.getSession(), ((SmsConfirm.Action.CodeChanged) action).getCode(), false, 8, null), new Function1<Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleError.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Content, SmsConfirm.Action> builder) {
                    invoke2((Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$1$1", f = "SmsConfirmBusinessLogic.kt", l = {156}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03481 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03481(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> builder, Continuation<? super C03481> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03481(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((C03481) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            SmsConfirm.State.Content state = this.$this_invoke.getState();
                            this.label = 1;
                            obj = function2.invoke(state, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* compiled from: SmsConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$1$2", f = "SmsConfirmBusinessLogic.kt", l = {158}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                    final /* synthetic */ SmsConfirm.Action $action;
                    final /* synthetic */ SmsConfirm.State.Error $state;
                    int label;
                    final /* synthetic */ SmsConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.Action action, SmsConfirm.State.Error error, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = smsConfirmBusinessLogic;
                        this.$action = action;
                        this.$state = error;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                            String code = ((SmsConfirm.Action.CodeChanged) this.$action).getCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = smsConfirmInteractor.checkCode(code, codeLength, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<SmsConfirm.State.Content, SmsConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03481(SmsConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(SmsConfirmBusinessLogic.this, action, state, null));
                }
            });
        }
        return action instanceof SmsConfirm.Action.RestartSession ? Out.INSTANCE.invoke(new SmsConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleError.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$2$1", f = "SmsConfirmBusinessLogic.kt", l = {165}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$2$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> $this_invoke;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        SmsConfirm.State.Init state = this.$this_invoke.getState();
                        this.label = 1;
                        obj = function2.invoke(state, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Init, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$2$2", f = "SmsConfirmBusinessLogic.kt", l = {166}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$2$2, reason: invalid class name and collision with other inner class name */
            static final class C03492 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                final /* synthetic */ SmsConfirm.State.Error $state;
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03492(SmsConfirmBusinessLogic smsConfirmBusinessLogic, SmsConfirm.State.Error error, Continuation<? super C03492> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                    this.$state = error;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C03492(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                    return ((C03492) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                        String processId = this.$state.getProcessId();
                        this.label = 1;
                        obj = smsConfirmInteractor.startAuthSession(processId, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Init, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, invoke, null));
                CoreKt.input(invoke, new C03492(SmsConfirmBusinessLogic.this, state, null));
            }
        }) : action instanceof SmsConfirm.Action.ShowHelp ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State.Error, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic.handleError.3
            {
                super(1);
            }

            /* compiled from: SmsConfirmBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$3$1", f = "SmsConfirmBusinessLogic.kt", l = {169}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmBusinessLogic$handleError$3$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SmsConfirmBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SmsConfirmBusinessLogic smsConfirmBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = smsConfirmBusinessLogic;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showEffect;
                        SmsConfirm.Effect.ShowHelp showHelp = SmsConfirm.Effect.ShowHelp.INSTANCE;
                        this.label = 1;
                        if (function2.invoke(showHelp, this) == coroutine_suspended) {
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State.Error, SmsConfirm.Action> builder) {
                invoke2((Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<SmsConfirm.State.Error, SmsConfirm.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.output(invoke, new AnonymousClass1(SmsConfirmBusinessLogic.this, null));
                CoreKt.input(invoke, SmsConfirmBusinessLogic.this.source);
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }
}
