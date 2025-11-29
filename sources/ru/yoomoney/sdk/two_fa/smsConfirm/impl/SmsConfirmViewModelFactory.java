package ru.yoomoney.sdk.two_fa.smsConfirm.impl;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.domain.SessionSms;
import ru.yoomoney.sdk.two_fa.exception.Failure;
import ru.yoomoney.sdk.two_fa.smsConfirm.SmsConfirm;

/* compiled from: SmsConfirmViewModelFactory.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014¢\u0006\u0002\u0010\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmAnalyticsLogger;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmAnalyticsLogger;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsConfirmViewModelFactory extends AbstractSavedStateViewModelFactory {
    public static final String SMS_CONFIRM = "SmsConfirm";
    private final SmsConfirmAnalyticsLogger analyticsLogger;
    private final Config config;
    private final SmsConfirmInteractor interactor;
    public static final int $stable = 8;
    private static final String SESSION = SmsConfirmViewModelFactory.class.getName() + ".session";
    private static final String CONFIRM_CODE = SmsConfirmViewModelFactory.class.getName() + ".confirm_code";
    private static final String FAILURE = SmsConfirmViewModelFactory.class.getName() + ".failure";
    private static final String IS_ENABLED_PROGRESS = SmsConfirmViewModelFactory.class.getName() + ".is_enabled_progress";

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public /* synthetic */ SmsConfirmViewModelFactory(Config config, SmsConfirmInteractor smsConfirmInteractor, SmsConfirmAnalyticsLogger smsConfirmAnalyticsLogger, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, smsConfirmInteractor, smsConfirmAnalyticsLogger, savedStateRegistryOwner, (i & 16) != 0 ? null : bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsConfirmViewModelFactory(Config config, SmsConfirmInteractor interactor, SmsConfirmAnalyticsLogger smsConfirmAnalyticsLogger, SavedStateRegistryOwner owner, Bundle bundle) {
        super(owner, bundle);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.config = config;
        this.interactor = interactor;
        this.analyticsLogger = smsConfirmAnalyticsLogger;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, final SavedStateHandle handle) {
        final SmsConfirm.State init;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        SessionSms sessionSms = (SessionSms) handle.get(SESSION);
        String str = (String) handle.get(CONFIRM_CODE);
        Failure failure = (Failure) handle.get(FAILURE);
        Boolean bool = (Boolean) handle.get(IS_ENABLED_PROGRESS);
        if (failure != null && sessionSms != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            init = new SmsConfirm.State.Error(this.config.getProcessId(), sessionSms, str, failure, bool.booleanValue());
        } else if (sessionSms != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            init = new SmsConfirm.State.Content(this.config.getProcessId(), sessionSms, str, bool.booleanValue());
        } else if (sessionSms != null && str != null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            init = new SmsConfirm.State.Confirm(this.config.getProcessId(), sessionSms, str, bool.booleanValue());
        } else if (failure != null) {
            init = new SmsConfirm.State.InitialError(this.config.getProcessId(), failure);
        } else {
            init = new SmsConfirm.State.Init(this.config.getProcessId());
        }
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("SmsConfirm", new Function1<RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect>, Out<? extends SmsConfirm.State, ? extends SmsConfirm.Action>>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory.create.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Out<SmsConfirm.State, SmsConfirm.Action> invoke(final RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                Out.Companion companion = Out.INSTANCE;
                final SmsConfirm.State state = init;
                final SmsConfirmViewModelFactory smsConfirmViewModelFactory = this;
                return companion.invoke(state, new Function1<Out.Builder<? extends SmsConfirm.State, SmsConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory.create.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: SmsConfirmViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$1", f = "SmsConfirmViewModelFactory.kt", l = {67}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03531 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                        final /* synthetic */ RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> $this_RuntimeViewModel;
                        final /* synthetic */ Out.Builder<SmsConfirm.State, SmsConfirm.Action> $this_invoke;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C03531(RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> runtimeViewModelDependencies, Out.Builder<? extends SmsConfirm.State, SmsConfirm.Action> builder, Continuation<? super C03531> continuation) {
                            super(1, continuation);
                            this.$this_RuntimeViewModel = runtimeViewModelDependencies;
                            this.$this_invoke = builder;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C03531(this.$this_RuntimeViewModel, this.$this_invoke, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                            return ((C03531) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<SmsConfirm.State, Continuation<? super SmsConfirm.Action>, Object> showState = this.$this_RuntimeViewModel.getShowState();
                                SmsConfirm.State state = this.$this_invoke.getState();
                                this.label = 1;
                                obj = showState.invoke(state, this);
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
                    public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends SmsConfirm.State, SmsConfirm.Action> builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Out.Builder<? extends SmsConfirm.State, SmsConfirm.Action> invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        CoreKt.input(invoke, new C03531(RuntimeViewModel, invoke, null));
                        if (state instanceof SmsConfirm.State.Init) {
                            CoreKt.input(invoke, new AnonymousClass2(smsConfirmViewModelFactory, null));
                        }
                        SmsConfirm.State state2 = state;
                        if (state2 instanceof SmsConfirm.State.Confirm) {
                            CoreKt.input(invoke, new AnonymousClass3(smsConfirmViewModelFactory, state2, null));
                        }
                    }

                    /* compiled from: SmsConfirmViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$2", f = "SmsConfirmViewModelFactory.kt", l = {69}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                        int label;
                        final /* synthetic */ SmsConfirmViewModelFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(SmsConfirmViewModelFactory smsConfirmViewModelFactory, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.this$0 = smsConfirmViewModelFactory;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
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
                                String processId = this.this$0.config.getProcessId();
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

                    /* compiled from: SmsConfirmViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$3", f = "SmsConfirmViewModelFactory.kt", l = {73}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$1$1$3, reason: invalid class name */
                    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super SmsConfirm.Action>, Object> {
                        final /* synthetic */ SmsConfirm.State $currentState;
                        int label;
                        final /* synthetic */ SmsConfirmViewModelFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(SmsConfirmViewModelFactory smsConfirmViewModelFactory, SmsConfirm.State state, Continuation<? super AnonymousClass3> continuation) {
                            super(1, continuation);
                            this.this$0 = smsConfirmViewModelFactory;
                            this.$currentState = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass3(this.this$0, this.$currentState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super SmsConfirm.Action> continuation) {
                            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                SmsConfirmInteractor smsConfirmInteractor = this.this$0.interactor;
                                String processId = ((SmsConfirm.State.Confirm) this.$currentState).getProcessId();
                                String confirmCode = ((SmsConfirm.State.Confirm) this.$currentState).getConfirmCode();
                                int attemptsLeft = ((SmsConfirm.State.Confirm) this.$currentState).getSession().getAttemptsLeft();
                                this.label = 1;
                                obj = smsConfirmInteractor.confirmCode(processId, confirmCode, attemptsLeft, this);
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
                });
            }
        }, new Function1<RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect>, Function2<? super SmsConfirm.State, ? super SmsConfirm.Action, ? extends Out<? extends SmsConfirm.State, ? extends SmsConfirm.Action>>>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory.create.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function2<SmsConfirm.State, SmsConfirm.Action, Out<SmsConfirm.State, SmsConfirm.Action>> invoke(RuntimeViewModelDependencies<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return new SmsConfirmBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), SmsConfirmViewModelFactory.this.interactor, SmsConfirmViewModelFactory.this.analyticsLogger);
            }
        }, null, null, null, null, null, null, null, null, 2040, null);
        runtimeViewModelRuntimeViewModel$default.getStates().observeForever(new SmsConfirmViewModelFactory$sam$androidx_lifecycle_Observer$0(new Function1<SmsConfirm.State, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory$create$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SmsConfirm.State state) {
                invoke2(state);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SmsConfirm.State state) {
                handle.set(SmsConfirmViewModelFactory.SESSION, null);
                handle.set(SmsConfirmViewModelFactory.CONFIRM_CODE, null);
                handle.set(SmsConfirmViewModelFactory.FAILURE, null);
                handle.set(SmsConfirmViewModelFactory.IS_ENABLED_PROGRESS, null);
                if (state instanceof SmsConfirm.State.Content) {
                    SmsConfirm.State.Content content = (SmsConfirm.State.Content) state;
                    handle.set(SmsConfirmViewModelFactory.SESSION, content.getSession());
                    handle.set(SmsConfirmViewModelFactory.CONFIRM_CODE, content.getConfirmCode());
                    handle.set(SmsConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(content.isEnabledProgressIndicator()));
                    return;
                }
                if (state instanceof SmsConfirm.State.Error) {
                    SmsConfirm.State.Error error = (SmsConfirm.State.Error) state;
                    handle.set(SmsConfirmViewModelFactory.SESSION, error.getSession());
                    handle.set(SmsConfirmViewModelFactory.CONFIRM_CODE, error.getConfirmCode());
                    handle.set(SmsConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(error.isEnabledProgressIndicator()));
                    handle.set(SmsConfirmViewModelFactory.FAILURE, error.getFailure());
                    return;
                }
                if (state instanceof SmsConfirm.State.Confirm) {
                    SmsConfirm.State.Confirm confirm = (SmsConfirm.State.Confirm) state;
                    handle.set(SmsConfirmViewModelFactory.SESSION, confirm.getSession());
                    handle.set(SmsConfirmViewModelFactory.CONFIRM_CODE, confirm.getConfirmCode());
                    handle.set(SmsConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(confirm.isEnabledProgressIndicator()));
                    return;
                }
                if (state instanceof SmsConfirm.State.InitialError) {
                    handle.set(SmsConfirmViewModelFactory.FAILURE, ((SmsConfirm.State.InitialError) state).getFailure());
                } else {
                    boolean z = state instanceof SmsConfirm.State.Init;
                }
            }
        }));
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
