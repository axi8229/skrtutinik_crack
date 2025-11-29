package ru.yoomoney.sdk.two_fa.phoneCall.impl;

import flussonic.watcher.sdk.presentation.timeline.animation.TimelineAnimator;
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
import ru.yoomoney.sdk.two_fa.domain.SessionPhoneCall;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;

/* compiled from: PhoneCallBusinessLogic.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$J,\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b%\u0010&R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010*¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "interactor", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$AnalyticsLogger;)V", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Init;", "state", "action", "handleInit", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Init;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$InitialError;", "handleInitialError", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$InitialError;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Confirm;", "handleConfirm", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Confirm;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Content;", "handleContent", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Content;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Error;", "handleError", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State$Error;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State;Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$AnalyticsLogger;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallBusinessLogic implements Function2<PhoneCall.State, PhoneCall.Action, Out<? extends PhoneCall.State, ? extends PhoneCall.Action>> {
    public static final int $stable = 8;
    private final PhoneCall.AnalyticsLogger analyticsLogger;
    private final PhoneCallInteractor interactor;
    private final Function2<PhoneCall.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PhoneCall.State, Continuation<? super PhoneCall.Action>, Object> showState;
    private final Function1<Continuation<? super PhoneCall.Action>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneCallBusinessLogic(Function2<? super PhoneCall.State, ? super Continuation<? super PhoneCall.Action>, ? extends Object> showState, Function2<? super PhoneCall.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PhoneCall.Action>, ? extends Object> source, PhoneCallInteractor interactor, PhoneCall.AnalyticsLogger analyticsLogger) {
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
    public Out<PhoneCall.State, PhoneCall.Action> invoke(PhoneCall.State state, PhoneCall.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PhoneCall.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof PhoneCall.State.Init) {
            return handleInit((PhoneCall.State.Init) state, action);
        }
        if (state instanceof PhoneCall.State.InitialError) {
            return handleInitialError((PhoneCall.State.InitialError) state, action);
        }
        if (state instanceof PhoneCall.State.Confirm) {
            return handleConfirm((PhoneCall.State.Confirm) state, action);
        }
        if (state instanceof PhoneCall.State.Content) {
            return handleContent((PhoneCall.State.Content) state, action);
        }
        if (state instanceof PhoneCall.State.Error) {
            return handleError((PhoneCall.State.Error) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Out<PhoneCall.State, PhoneCall.Action> handleInit(PhoneCall.State.Init state, PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.SessionStartSuccess) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Content(state.getProcessId(), ((PhoneCall.Action.SessionStartSuccess) action).getSession(), "", state.getNextSessionType(), false, 16, null), new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleInit.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInit$1$1", f = "PhoneCallBusinessLogic.kt", l = {42}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInit$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03401 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Content, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03401(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Content, PhoneCall.Action> builder, Continuation<? super C03401> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03401(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03401) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03401(PhoneCallBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof PhoneCall.Action.SessionStartFail) {
            return Out.INSTANCE.invoke(new PhoneCall.State.InitialError(state.getProcessId(), ((PhoneCall.Action.SessionStartFail) action).getFailure(), state.getNextSessionType()), new Function1<Out.Builder<? extends PhoneCall.State.InitialError, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleInit.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.InitialError, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.InitialError, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInit$2$1", f = "PhoneCallBusinessLogic.kt", l = {51}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInit$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.InitialError, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.InitialError, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.InitialError state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<PhoneCall.State.InitialError, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PhoneCall.State, PhoneCall.Action> handleInitialError(final PhoneCall.State.InitialError state, PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.RestartSession) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Init(state.getProcessId(), state.getNextSessionType()), new Function1<Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleInitialError.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Init, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInitialError$1$1", f = "PhoneCallBusinessLogic.kt", l = {66}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInitialError$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03411 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Init, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03411(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Init, PhoneCall.Action> builder, Continuation<? super C03411> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03411(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03411) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInitialError$1$2", f = "PhoneCallBusinessLogic.kt", l = {67}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleInitialError$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.State.InitialError $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.InitialError initialError, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$state = initialError;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = phoneCallInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<PhoneCall.State.Init, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03411(PhoneCallBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(PhoneCallBusinessLogic.this, state, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PhoneCall.State, PhoneCall.Action> handleConfirm(final PhoneCall.State.Confirm state, final PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.ConfirmCode) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleConfirm.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$1$1", f = "PhoneCallBusinessLogic.kt", l = {78}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03351 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.Action $action;
                    final /* synthetic */ PhoneCall.State.Confirm $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03351(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Confirm confirm, PhoneCall.Action action, Continuation<? super C03351> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$state = confirm;
                        this.$action = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03351(this.this$0, this.$state, this.$action, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03351) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            String code = ((PhoneCall.Action.ConfirmCode) this.$action).getCode();
                            int attemptsLeft = this.$state.getSession().getAttemptsLeft();
                            this.label = 1;
                            obj = phoneCallInteractor.confirmCode(processId, code, attemptsLeft, this);
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03351(PhoneCallBusinessLogic.this, state, action, null));
                    CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof PhoneCall.Action.ConfirmSuccess) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleConfirm.2
                {
                    super(1);
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$2$1", f = "PhoneCallBusinessLogic.kt", l = {87}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
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
                            PhoneCall.Effect.ConfirmPhoneCallSuccess confirmPhoneCallSuccess = PhoneCall.Effect.ConfirmPhoneCallSuccess.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(confirmPhoneCallSuccess, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, null));
                    CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof PhoneCall.Action.ConfirmFail) {
            PhoneCall.Action.ConfirmFail confirmFail = (PhoneCall.Action.ConfirmFail) action;
            return Out.INSTANCE.invoke(new PhoneCall.State.Error(state.getProcessId(), SessionPhoneCall.copy$default(state.getSession(), null, null, null, null, 0, confirmFail.getAttemptsLeft(), 31, null), "", confirmFail.getFailure(), state.getNextSessionType(), false, 32, null), new Function1<Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleConfirm.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Error, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$3$1", f = "PhoneCallBusinessLogic.kt", l = {99}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Error, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Error, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Error state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<PhoneCall.State.Error, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof PhoneCall.Action.TechnicalFail) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Content(state.getProcessId(), state.getSession(), "", state.getNextSessionType(), false, 16, null), new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleConfirm.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$4$1", f = "PhoneCallBusinessLogic.kt", l = {109}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$4$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ PhoneCall.Action $action;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.Action action, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
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
                            PhoneCall.Effect.ShowFailure showFailure = new PhoneCall.Effect.ShowFailure(((PhoneCall.Action.TechnicalFail) this.$action).getFailure());
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$4$2", f = "PhoneCallBusinessLogic.kt", l = {110}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleConfirm$4$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Content, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Content, PhoneCall.Action> builder, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, action, null));
                    CoreKt.input(invoke, new AnonymousClass2(PhoneCallBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PhoneCall.State, PhoneCall.Action> handleContent(final PhoneCall.State.Content state, final PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.CodeChanged) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$1$1", f = "PhoneCallBusinessLogic.kt", l = {120}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03361 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.Action $action;
                    final /* synthetic */ PhoneCall.State.Content $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03361(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.Action action, PhoneCall.State.Content content, Continuation<? super C03361> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$action = action;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03361(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03361) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String code = ((PhoneCall.Action.CodeChanged) this.$action).getCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = phoneCallInteractor.checkCode(code, codeLength, this);
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03361(PhoneCallBusinessLogic.this, action, state, null));
                    CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof PhoneCall.Action.ConfirmCode) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Confirm(state.getProcessId(), state.getSession(), ((PhoneCall.Action.ConfirmCode) action).getCode(), state.getNextSessionType(), false, 16, null), new Function1<Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Confirm, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$2$1", f = "PhoneCallBusinessLogic.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Confirm state = this.$this_invoke.getState();
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$2$2", f = "PhoneCallBusinessLogic.kt", l = {133}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$2$2, reason: invalid class name and collision with other inner class name */
                static final class C03372 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.Action $action;
                    final /* synthetic */ PhoneCall.State.Content $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03372(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Content content, PhoneCall.Action action, Continuation<? super C03372> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$state = content;
                        this.$action = action;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03372(this.this$0, this.$state, this.$action, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03372) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            String code = ((PhoneCall.Action.ConfirmCode) this.$action).getCode();
                            int attemptsLeft = this.$state.getSession().getAttemptsLeft();
                            this.label = 1;
                            obj = phoneCallInteractor.confirmCode(processId, code, attemptsLeft, this);
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
                public final void invoke2(Out.Builder<PhoneCall.State.Confirm, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new C03372(PhoneCallBusinessLogic.this, state, action, null));
                }
            });
        }
        if (action instanceof PhoneCall.Action.RestartSession) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Init(state.getProcessId(), state.getNextSessionType()), new Function1<Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Init, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$3$1", f = "PhoneCallBusinessLogic.kt", l = {146}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Init, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Init, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$3$2", f = "PhoneCallBusinessLogic.kt", l = {147}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$3$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.State.Content $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Content content, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = phoneCallInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<PhoneCall.State.Init, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(PhoneCallBusinessLogic.this, state, null));
                }
            });
        }
        return action instanceof PhoneCall.Action.UpdateCode ? Out.INSTANCE.invoke(PhoneCall.State.Content.copy$default(state, null, null, ((PhoneCall.Action.UpdateCode) action).getCode(), null, false, 27, null), new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.4
            {
                super(1);
            }

            /* compiled from: PhoneCallBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$4$1", f = "PhoneCallBusinessLogic.kt", l = {TimelineAnimator.DURATION}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$4$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                final /* synthetic */ Out.Builder<PhoneCall.State.Content, PhoneCall.Action> $this_invoke;
                int label;
                final /* synthetic */ PhoneCallBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Content, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = phoneCallBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        PhoneCall.State.Content state = this.$this_invoke.getState();
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
            }
        }) : action instanceof PhoneCall.Action.NextAvailableSession ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: PhoneCallBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$5$1", f = "PhoneCallBusinessLogic.kt", l = {153}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$5$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                final /* synthetic */ PhoneCall.State.Content $state;
                int label;
                final /* synthetic */ PhoneCallBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Content content, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = phoneCallBusinessLogic;
                    this.$state = content;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                        SessionType nextSessionType = this.$state.getNextSessionType();
                        this.label = 1;
                        obj = phoneCallInteractor.nextAvailableSessionOption(nextSessionType, this);
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, state, null));
                CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
            }
        }) : action instanceof PhoneCall.Action.ForwardToNextAvailableSession ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleContent.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: PhoneCallBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$6$1", f = "PhoneCallBusinessLogic.kt", l = {157}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleContent$6$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ PhoneCall.State.Content $state;
                int label;
                final /* synthetic */ PhoneCallBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Content content, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = phoneCallBusinessLogic;
                    this.$state = content;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$state, continuation);
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
                        PhoneCall.Effect.OpenNextAvailableSession openNextAvailableSession = new PhoneCall.Effect.OpenNextAvailableSession(this.$state.getNextSessionType());
                        this.label = 1;
                        if (function2.invoke(openNextAvailableSession, this) == coroutine_suspended) {
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.output(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, state, null));
                CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }

    private final Out<PhoneCall.State, PhoneCall.Action> handleError(final PhoneCall.State.Error state, final PhoneCall.Action action) {
        if (action instanceof PhoneCall.Action.CodeChanged) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Content(state.getProcessId(), state.getSession(), ((PhoneCall.Action.CodeChanged) action).getCode(), state.getNextSessionType(), false, 16, null), new Function1<Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleError.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Content, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Content, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$1$1", f = "PhoneCallBusinessLogic.kt", l = {175}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03381 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Content, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03381(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Content, PhoneCall.Action> builder, Continuation<? super C03381> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03381(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03381) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Content state = this.$this_invoke.getState();
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$1$2", f = "PhoneCallBusinessLogic.kt", l = {177}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.Action $action;
                    final /* synthetic */ PhoneCall.State.Error $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.Action action, PhoneCall.State.Error error, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$action = action;
                        this.$state = error;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String code = ((PhoneCall.Action.CodeChanged) this.$action).getCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = phoneCallInteractor.checkCode(code, codeLength, this);
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
                public final void invoke2(Out.Builder<PhoneCall.State.Content, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03381(PhoneCallBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(PhoneCallBusinessLogic.this, action, state, null));
                }
            });
        }
        if (action instanceof PhoneCall.Action.RestartSession) {
            return Out.INSTANCE.invoke(new PhoneCall.State.Init(state.getProcessId(), state.getNextSessionType()), new Function1<Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleError.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Init, PhoneCall.Action> builder) {
                    invoke2((Out.Builder<PhoneCall.State.Init, PhoneCall.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$2$1", f = "PhoneCallBusinessLogic.kt", l = {189}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ Out.Builder<PhoneCall.State.Init, PhoneCall.Action> $this_invoke;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, Out.Builder<PhoneCall.State.Init, PhoneCall.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            PhoneCall.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: PhoneCallBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$2$2", f = "PhoneCallBusinessLogic.kt", l = {190}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$2$2, reason: invalid class name and collision with other inner class name */
                static final class C03392 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                    final /* synthetic */ PhoneCall.State.Error $state;
                    int label;
                    final /* synthetic */ PhoneCallBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03392(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Error error, Continuation<? super C03392> continuation) {
                        super(1, continuation);
                        this.this$0 = phoneCallBusinessLogic;
                        this.$state = error;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03392(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                        return ((C03392) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = phoneCallInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<PhoneCall.State.Init, PhoneCall.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new C03392(PhoneCallBusinessLogic.this, state, null));
                }
            });
        }
        return action instanceof PhoneCall.Action.NextAvailableSession ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleError.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: PhoneCallBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$3$1", f = "PhoneCallBusinessLogic.kt", l = {193}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$3$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                final /* synthetic */ PhoneCall.State.Error $state;
                int label;
                final /* synthetic */ PhoneCallBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Error error, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = phoneCallBusinessLogic;
                    this.$state = error;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PhoneCallInteractor phoneCallInteractor = this.this$0.interactor;
                        SessionType nextSessionType = this.$state.getNextSessionType();
                        this.label = 1;
                        obj = phoneCallInteractor.nextAvailableSessionOption(nextSessionType, this);
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action> builder) {
                invoke2((Out.Builder<PhoneCall.State.Error, PhoneCall.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<PhoneCall.State.Error, PhoneCall.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, state, null));
                CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
            }
        }) : action instanceof PhoneCall.Action.ForwardToNextAvailableSession ? Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic.handleError.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: PhoneCallBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$4$1", f = "PhoneCallBusinessLogic.kt", l = {197}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallBusinessLogic$handleError$4$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ PhoneCall.State.Error $state;
                int label;
                final /* synthetic */ PhoneCallBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PhoneCallBusinessLogic phoneCallBusinessLogic, PhoneCall.State.Error error, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = phoneCallBusinessLogic;
                    this.$state = error;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$state, continuation);
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
                        PhoneCall.Effect.OpenNextAvailableSession openNextAvailableSession = new PhoneCall.Effect.OpenNextAvailableSession(this.$state.getNextSessionType());
                        this.label = 1;
                        if (function2.invoke(openNextAvailableSession, this) == coroutine_suspended) {
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State.Error, PhoneCall.Action> builder) {
                invoke2((Out.Builder<PhoneCall.State.Error, PhoneCall.Action>) builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Out.Builder<PhoneCall.State.Error, PhoneCall.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.output(invoke, new AnonymousClass1(PhoneCallBusinessLogic.this, state, null));
                CoreKt.input(invoke, PhoneCallBusinessLogic.this.source);
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }
}
