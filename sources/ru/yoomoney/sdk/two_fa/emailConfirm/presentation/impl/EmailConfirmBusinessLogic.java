package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl;

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
import ru.yoomoney.sdk.two_fa.domain.SessionEmail;
import ru.yoomoney.sdk.two_fa.emailConfirm.EmailConfirm;

/* compiled from: EmailConfirmBusinessLogic.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$J,\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b%\u0010&R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010*¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "interactor", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$AnalyticsLogger;)V", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Init;", "state", "action", "handleInitState", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Init;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$InitialError;", "handleInitialErrorState", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$InitialError;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Content;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Error;", "handleErrorState", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Error;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Confirm;", "handleConfirmState", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Confirm;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$AnalyticsLogger;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirmBusinessLogic implements Function2<EmailConfirm.State, EmailConfirm.Action, Out<? extends EmailConfirm.State, ? extends EmailConfirm.Action>> {
    public static final int $stable = 8;
    private final EmailConfirm.AnalyticsLogger analyticsLogger;
    private final EmailConfirmInteractor interactor;
    private final Function2<EmailConfirm.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<EmailConfirm.State, Continuation<? super EmailConfirm.Action>, Object> showState;
    private final Function1<Continuation<? super EmailConfirm.Action>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public EmailConfirmBusinessLogic(Function2<? super EmailConfirm.State, ? super Continuation<? super EmailConfirm.Action>, ? extends Object> showState, Function2<? super EmailConfirm.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super EmailConfirm.Action>, ? extends Object> source, EmailConfirmInteractor interactor, EmailConfirm.AnalyticsLogger analyticsLogger) {
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
    public Out<EmailConfirm.State, EmailConfirm.Action> invoke(EmailConfirm.State state, EmailConfirm.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        EmailConfirm.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof EmailConfirm.State.Init) {
            return handleInitState((EmailConfirm.State.Init) state, action);
        }
        if (state instanceof EmailConfirm.State.InitialError) {
            return handleInitialErrorState((EmailConfirm.State.InitialError) state, action);
        }
        if (state instanceof EmailConfirm.State.Content) {
            return handleContentState((EmailConfirm.State.Content) state, action);
        }
        if (state instanceof EmailConfirm.State.Error) {
            return handleErrorState((EmailConfirm.State.Error) state, action);
        }
        if (state instanceof EmailConfirm.State.Confirm) {
            return handleConfirmState((EmailConfirm.State.Confirm) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Out<EmailConfirm.State, EmailConfirm.Action> handleInitState(EmailConfirm.State.Init state, EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.SessionStartSuccess) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Content(state.getProcessId(), ((EmailConfirm.Action.SessionStartSuccess) action).getSession(), "", false, false, 16, null), new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleInitState.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitState$1$1", f = "EmailConfirmBusinessLogic.kt", l = {43}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitState$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03261 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03261(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> builder, Continuation<? super C03261> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03261(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((C03261) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03261(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof EmailConfirm.Action.SessionStartFail) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.InitialError(state.getProcessId(), ((EmailConfirm.Action.SessionStartFail) action).getFailure()), new Function1<Out.Builder<? extends EmailConfirm.State.InitialError, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleInitState.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.InitialError, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.InitialError, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitState$2$1", f = "EmailConfirmBusinessLogic.kt", l = {51}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitState$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.InitialError, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.InitialError, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.InitialError state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.InitialError, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<EmailConfirm.State, EmailConfirm.Action> handleInitialErrorState(final EmailConfirm.State.InitialError state, EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.RestartSession) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleInitialErrorState.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitialErrorState$1$1", f = "EmailConfirmBusinessLogic.kt", l = {63}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitialErrorState$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03271 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03271(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> builder, Continuation<? super C03271> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03271(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((C03271) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitialErrorState$1$2", f = "EmailConfirmBusinessLogic.kt", l = {64}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleInitialErrorState$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.State.InitialError $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.State.InitialError initialError, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$state = initialError;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = emailConfirmInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03271(EmailConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(EmailConfirmBusinessLogic.this, state, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<EmailConfirm.State, EmailConfirm.Action> handleContentState(final EmailConfirm.State.Content state, final EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.CodeChanged) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleContentState.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$1$1", f = "EmailConfirmBusinessLogic.kt", l = {75}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03241 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.Action $action;
                    final /* synthetic */ EmailConfirm.State.Content $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03241(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.Action action, EmailConfirm.State.Content content, Continuation<? super C03241> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$action = action;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03241(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((C03241) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String confirmCode = ((EmailConfirm.Action.CodeChanged) this.$action).getConfirmCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = emailConfirmInteractor.validateCode(confirmCode, codeLength, this);
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03241(EmailConfirmBusinessLogic.this, action, state, null));
                    CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EmailConfirm.Action.UpdateCode) {
            EmailConfirm.Action.UpdateCode updateCode = (EmailConfirm.Action.UpdateCode) action;
            return Out.INSTANCE.invoke(EmailConfirm.State.Content.copy$default(state, null, null, updateCode.getConfirmCode(), updateCode.getEnableConfirmAction(), false, 19, null), new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleContentState.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$2$1", f = "EmailConfirmBusinessLogic.kt", l = {88}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof EmailConfirm.Action.ConfirmCode) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Confirm(state.getProcessId(), state.getSession(), state.getConfirmCode(), false, 8, null), new Function1<Out.Builder<? extends EmailConfirm.State.Confirm, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleContentState.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Confirm, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$3$1", f = "EmailConfirmBusinessLogic.kt", l = {97}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Confirm state = this.$this_invoke.getState();
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

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$3$2", f = "EmailConfirmBusinessLogic.kt", l = {99}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$3$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.State.Content $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.State.Content content, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            String confirmCode = this.$state.getConfirmCode();
                            int attemptsLeft = this.$state.getSession().getAttemptsLeft();
                            this.label = 1;
                            obj = emailConfirmInteractor.confirmCode(processId, confirmCode, attemptsLeft, this);
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(EmailConfirmBusinessLogic.this, state, null));
                }
            });
        }
        if (action instanceof EmailConfirm.Action.ShowHelp) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleContentState.4
                {
                    super(1);
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$4$1", f = "EmailConfirmBusinessLogic.kt", l = {107}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$4$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
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
                            EmailConfirm.Effect.NavigateToHelp navigateToHelp = EmailConfirm.Effect.NavigateToHelp.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(navigateToHelp, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, null));
                    CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EmailConfirm.Action.RestartSession) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleContentState.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$5$1", f = "EmailConfirmBusinessLogic.kt", l = {115}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$5$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$5$2", f = "EmailConfirmBusinessLogic.kt", l = {116}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleContentState$5$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.State.Content $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.State.Content content, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$state = content;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = emailConfirmInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(EmailConfirmBusinessLogic.this, state, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<EmailConfirm.State, EmailConfirm.Action> handleErrorState(final EmailConfirm.State.Error state, final EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.CodeChanged) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleErrorState.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$1$1", f = "EmailConfirmBusinessLogic.kt", l = {127}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03251 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.Action $action;
                    final /* synthetic */ EmailConfirm.State.Error $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03251(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.Action action, EmailConfirm.State.Error error, Continuation<? super C03251> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$action = action;
                        this.$state = error;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03251(this.this$0, this.$action, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((C03251) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String confirmCode = ((EmailConfirm.Action.CodeChanged) this.$action).getConfirmCode();
                            int codeLength = this.$state.getSession().getCodeLength();
                            this.label = 1;
                            obj = emailConfirmInteractor.validateCode(confirmCode, codeLength, this);
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new C03251(EmailConfirmBusinessLogic.this, action, state, null));
                    CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EmailConfirm.Action.UpdateCode) {
            EmailConfirm.Action.UpdateCode updateCode = (EmailConfirm.Action.UpdateCode) action;
            return Out.INSTANCE.invoke(new EmailConfirm.State.Content(state.getProcessId(), state.getSession(), updateCode.getConfirmCode(), updateCode.getEnableConfirmAction(), false, 16, null), new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleErrorState.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$2$1", f = "EmailConfirmBusinessLogic.kt", l = {142}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof EmailConfirm.Action.ShowHelp) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleErrorState.3
                {
                    super(1);
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$3$1", f = "EmailConfirmBusinessLogic.kt", l = {145}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
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
                            EmailConfirm.Effect.NavigateToHelp navigateToHelp = EmailConfirm.Effect.NavigateToHelp.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(navigateToHelp, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, null));
                    CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EmailConfirm.Action.RestartSession) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Init(state.getProcessId()), new Function1<Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleErrorState.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Init, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$4$1", f = "EmailConfirmBusinessLogic.kt", l = {153}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$4$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Init state = this.$this_invoke.getState();
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

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$4$2", f = "EmailConfirmBusinessLogic.kt", l = {154}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleErrorState$4$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ EmailConfirm.State.Error $state;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.State.Error error, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$state = error;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$state, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            EmailConfirmInteractor emailConfirmInteractor = this.this$0.interactor;
                            String processId = this.$state.getProcessId();
                            this.label = 1;
                            obj = emailConfirmInteractor.startAuthSession(processId, this);
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Init, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                    CoreKt.input(invoke, new AnonymousClass2(EmailConfirmBusinessLogic.this, state, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }

    private final Out<EmailConfirm.State, EmailConfirm.Action> handleConfirmState(EmailConfirm.State.Confirm state, final EmailConfirm.Action action) {
        if (action instanceof EmailConfirm.Action.ConfirmSuccess) {
            return Out.INSTANCE.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State.Confirm, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleConfirmState.1
                {
                    super(1);
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$1$1", f = "EmailConfirmBusinessLogic.kt", l = {164}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$1$1, reason: invalid class name and collision with other inner class name */
                static final class C03231 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03231(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Continuation<? super C03231> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C03231(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((C03231) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showEffect;
                            EmailConfirm.Effect.FinishWithSuccess finishWithSuccess = EmailConfirm.Effect.FinishWithSuccess.INSTANCE;
                            this.label = 1;
                            if (function2.invoke(finishWithSuccess, this) == coroutine_suspended) {
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
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Confirm, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Out.Builder<EmailConfirm.State.Confirm, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new C03231(EmailConfirmBusinessLogic.this, null));
                    CoreKt.input(invoke, EmailConfirmBusinessLogic.this.source);
                }
            });
        }
        if (action instanceof EmailConfirm.Action.ConfirmFail) {
            EmailConfirm.Action.ConfirmFail confirmFail = (EmailConfirm.Action.ConfirmFail) action;
            return Out.INSTANCE.invoke(new EmailConfirm.State.Error(state.getProcessId(), SessionEmail.copy$default(state.getSession(), null, null, null, null, 0, confirmFail.getAttemptsLeft(), 31, null), state.getConfirmCode(), confirmFail.getFailure(), false, 16, null), new Function1<Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleConfirmState.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Error, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$2$1", f = "EmailConfirmBusinessLogic.kt", l = {175}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action> builder, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Error state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Error, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.input(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        if (action instanceof EmailConfirm.Action.TechnicalFailure) {
            return Out.INSTANCE.invoke(new EmailConfirm.State.Content(state.getProcessId(), state.getSession(), state.getConfirmCode(), true, false, 16, null), new Function1<Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic.handleConfirmState.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State.Content, EmailConfirm.Action> builder) {
                    invoke2((Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action>) builder);
                    return Unit.INSTANCE;
                }

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$3$1", f = "EmailConfirmBusinessLogic.kt", l = {185}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ EmailConfirm.Action $action;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(EmailConfirmBusinessLogic emailConfirmBusinessLogic, EmailConfirm.Action action, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
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
                            EmailConfirm.Effect.ShowFailure showFailure = new EmailConfirm.Effect.ShowFailure(((EmailConfirm.Action.TechnicalFailure) this.$action).getFailure());
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

                /* compiled from: EmailConfirmBusinessLogic.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$3$2", f = "EmailConfirmBusinessLogic.kt", l = {186}, m = "invokeSuspend")
                /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmBusinessLogic$handleConfirmState$3$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                    final /* synthetic */ Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> $this_invoke;
                    int label;
                    final /* synthetic */ EmailConfirmBusinessLogic this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(EmailConfirmBusinessLogic emailConfirmBusinessLogic, Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> builder, Continuation<? super AnonymousClass2> continuation) {
                        super(1, continuation);
                        this.this$0 = emailConfirmBusinessLogic;
                        this.$this_invoke = builder;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$this_invoke, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Function2 function2 = this.this$0.showState;
                            EmailConfirm.State.Content state = this.$this_invoke.getState();
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
                public final void invoke2(Out.Builder<EmailConfirm.State.Content, EmailConfirm.Action> invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                    CoreKt.output(invoke, new AnonymousClass1(EmailConfirmBusinessLogic.this, action, null));
                    CoreKt.input(invoke, new AnonymousClass2(EmailConfirmBusinessLogic.this, invoke, null));
                }
            });
        }
        return Out.INSTANCE.skip(state, this.source);
    }
}
