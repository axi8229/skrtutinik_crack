package ru.yoomoney.sdk.two_fa.entryPoint.impl;

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
import ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint;

/* compiled from: EntryPointBusinessLogic.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bu\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "interactor", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;)V", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$Init;", "state", "action", "handleInit", "(Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$Init;Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$InitialError;", "handleInitialError", "(Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$InitialError;Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointBusinessLogic implements Function2<EntryPoint.State, EntryPoint.Action, Out<? extends EntryPoint.State, ? extends EntryPoint.Action>> {
    public static final int $stable = 8;
    private final EntryPointInteractor interactor;
    private final Function2<EntryPoint.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<EntryPoint.State, Continuation<? super EntryPoint.Action>, Object> showState;
    private final Function1<Continuation<? super EntryPoint.Action>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public EntryPointBusinessLogic(Function2<? super EntryPoint.State, ? super Continuation<? super EntryPoint.Action>, ? extends Object> showState, Function2<? super EntryPoint.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super EntryPoint.Action>, ? extends Object> source, EntryPointInteractor interactor) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<EntryPoint.State, EntryPoint.Action> invoke(EntryPoint.State state, EntryPoint.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof EntryPoint.State.Init) {
            return handleInit((EntryPoint.State.Init) state, action);
        }
        if (state instanceof EntryPoint.State.InitialError) {
            return handleInitialError((EntryPoint.State.InitialError) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Out<EntryPoint.State, EntryPoint.Action> handleInit(final EntryPoint.State.Init state, final EntryPoint.Action action) {
        if (action instanceof EntryPoint.Action.LoadingContext) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic.handleInit.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: EntryPointBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$1$1", f = "EntryPointBusinessLogic.kt", l = {29}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03311 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                    final /* synthetic */ EntryPoint.State.Init $state;
                    int label;
                    final /* synthetic */ EntryPointBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03311(EntryPointBusinessLogic entryPointBusinessLogic, EntryPoint.State.Init init, Continuation<? super C03311> continuation) {
                        super(1, continuation);
                        this.this$0 = entryPointBusinessLogic;
                        this.$state = init;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03311(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EntryPoint.Action> continuation) {
                        return ((C03311) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EntryPointInteractor entryPointInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = entryPointInteractor.getContent(processId, this);
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action> builder) {
                    invoke2((Out.Builder<EntryPoint.State.Init, EntryPoint.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EntryPoint.State.Init, EntryPoint.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03311(EntryPointBusinessLogic.this, state, null));
                    CoreKt.input(invoke, EntryPointBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EntryPoint.Action.LoadingContextSuccess) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic.handleInit.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: EntryPointBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$2$1", f = "EntryPointBusinessLogic.kt", l = {33}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ EntryPoint.Action $action;
                    int label;
                    final /* synthetic */ EntryPointBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EntryPointBusinessLogic entryPointBusinessLogic, EntryPoint.Action action, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = entryPointBusinessLogic;
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
                            EntryPoint.Effect.NavigateToConfirmation navigateToConfirmation = new EntryPoint.Effect.NavigateToConfirmation(((EntryPoint.Action.LoadingContextSuccess) this.$action).getContext().getAvailableSessionOptions());
                            this.label = 1;
                            if (function2.invoke(navigateToConfirmation, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action> builder) {
                    invoke2((Out.Builder<EntryPoint.State.Init, EntryPoint.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EntryPoint.State.Init, EntryPoint.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(EntryPointBusinessLogic.this, action, null));
                    CoreKt.input(invoke, EntryPointBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EntryPoint.Action.LoadingContextFailed) {
            return Out.INSTANCE.invoke(new EntryPoint.State.InitialError(state.getProcessId(), ((EntryPoint.Action.LoadingContextFailed) action).getFailure()), new Function1<Out.Builder<? extends EntryPoint.State.InitialError, EntryPoint.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic.handleInit.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EntryPoint.State.InitialError, EntryPoint.Action> builder) {
                    invoke2((Out.Builder<EntryPoint.State.InitialError, EntryPoint.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EntryPointBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$3$1", f = "EntryPointBusinessLogic.kt", l = {42}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInit$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                    final /* synthetic */ Out.Builder<EntryPoint.State.InitialError, EntryPoint.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EntryPointBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EntryPointBusinessLogic entryPointBusinessLogic, Out.Builder<EntryPoint.State.InitialError, EntryPoint.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = entryPointBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EntryPoint.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EntryPoint.State.InitialError state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EntryPoint.State.InitialError, EntryPoint.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EntryPointBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<EntryPoint.State, EntryPoint.Action> handleInitialError(final EntryPoint.State.InitialError state, EntryPoint.Action action) {
        return action instanceof EntryPoint.Action.RestartLoadingContext ? Out.INSTANCE.invoke(new EntryPoint.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic.handleInitialError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: EntryPointBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInitialError$1$1", f = "EntryPointBusinessLogic.kt", l = {52}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInitialError$1$1, reason: invalid class name and collision with other inner class name */
            static final class C03321 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                final /* synthetic */ Out.Builder<EntryPoint.State.Init, EntryPoint.Action> $this_invoke;
                int label;
                final /* synthetic */ EntryPointBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03321(EntryPointBusinessLogic entryPointBusinessLogic, Out.Builder<EntryPoint.State.Init, EntryPoint.Action> builder, Continuation<? super C03321> continuation) {
                    super(1, continuation);
                    this.this$0 = entryPointBusinessLogic;
                    this.$this_invoke = builder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C03321(this.this$0, this.$this_invoke, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super EntryPoint.Action> continuation) {
                    return ((C03321) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function2 function2 = this.this$0.showState;
                        EntryPoint.State.Init state = this.$this_invoke.getState();
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
            public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EntryPoint.State.Init, EntryPoint.Action> builder) {
                invoke2((Out.Builder<EntryPoint.State.Init, EntryPoint.Action>) builder);
                return Unit.INSTANCE;
            }

            /* compiled from: EntryPointBusinessLogic.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInitialError$1$2", f = "EntryPointBusinessLogic.kt", l = {53}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointBusinessLogic$handleInitialError$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                final /* synthetic */ EntryPoint.State.InitialError $state;
                int label;
                final /* synthetic */ EntryPointBusinessLogic this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(EntryPointBusinessLogic entryPointBusinessLogic, EntryPoint.State.InitialError initialError, Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                    this.this$0 = entryPointBusinessLogic;
                    this.$state = initialError;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super EntryPoint.Action> continuation) {
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        EntryPointInteractor entryPointInteractor = this.this$0.interactor;
                        String processId = this.$state.getProcessId();
                        this.label = 1;
                        obj = entryPointInteractor.getContent(processId, this);
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
            public final void invoke2(Out.Builder<EntryPoint.State.Init, EntryPoint.Action> invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                CoreKt.input(invoke, new C03321(EntryPointBusinessLogic.this, invoke, null));
                CoreKt.input(invoke, new AnonymousClass2(EntryPointBusinessLogic.this, state, null));
            }
        }) : Out.INSTANCE.skip(state, this.source);
    }
}
