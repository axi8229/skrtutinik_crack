package ru.yoomoney.sdk.two_fa.phoneCall.impl;

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
import ru.yoomoney.sdk.two_fa.domain.SessionPhoneCall;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.exception.Failure;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;

/* compiled from: PhoneCallViewModelFactory.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014¢\u0006\u0002\u0010\u0018R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "nextSessionType", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallAnalyticsLogger;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;Lru/yoomoney/sdk/two_fa/domain/SessionType;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallAnalyticsLogger;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallViewModelFactory extends AbstractSavedStateViewModelFactory {
    public static final String PHONE_CALL = "PhoneCall";
    private final PhoneCallAnalyticsLogger analyticsLogger;
    private final Config config;
    private final PhoneCallInteractor interactor;
    private final SessionType nextSessionType;
    public static final int $stable = 8;
    private static final String SESSION = PhoneCallViewModelFactory.class.getName() + ".session";
    private static final String CONFIRM_CODE = PhoneCallViewModelFactory.class.getName() + ".confirm_code";
    private static final String FAILURE = PhoneCallViewModelFactory.class.getName() + ".failure";
    private static final String IS_ENABLED_PROGRESS = PhoneCallViewModelFactory.class.getName() + ".is_enabled_progress";

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public /* synthetic */ PhoneCallViewModelFactory(Config config, PhoneCallInteractor phoneCallInteractor, SessionType sessionType, PhoneCallAnalyticsLogger phoneCallAnalyticsLogger, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, phoneCallInteractor, sessionType, phoneCallAnalyticsLogger, savedStateRegistryOwner, (i & 32) != 0 ? null : bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCallViewModelFactory(Config config, PhoneCallInteractor interactor, SessionType sessionType, PhoneCallAnalyticsLogger phoneCallAnalyticsLogger, SavedStateRegistryOwner owner, Bundle bundle) {
        super(owner, bundle);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.config = config;
        this.interactor = interactor;
        this.nextSessionType = sessionType;
        this.analyticsLogger = phoneCallAnalyticsLogger;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, final SavedStateHandle handle) {
        final PhoneCall.State init;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        SessionPhoneCall sessionPhoneCall = (SessionPhoneCall) handle.get(SESSION);
        String str = (String) handle.get(CONFIRM_CODE);
        Failure failure = (Failure) handle.get(FAILURE);
        Boolean bool = (Boolean) handle.get(IS_ENABLED_PROGRESS);
        if (failure != null && sessionPhoneCall != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            init = new PhoneCall.State.Error(this.config.getProcessId(), sessionPhoneCall, str, failure, this.nextSessionType, bool.booleanValue());
        } else if (sessionPhoneCall != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            init = new PhoneCall.State.Content(this.config.getProcessId(), sessionPhoneCall, str, this.nextSessionType, bool.booleanValue());
        } else if (sessionPhoneCall != null && str != null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            init = new PhoneCall.State.Confirm(this.config.getProcessId(), sessionPhoneCall, str, this.nextSessionType, bool.booleanValue());
        } else if (failure != null) {
            init = new PhoneCall.State.InitialError(this.config.getProcessId(), failure, this.nextSessionType);
        } else {
            init = new PhoneCall.State.Init(this.config.getProcessId(), this.nextSessionType);
        }
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("PhoneCall", new Function1<RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect>, Out<? extends PhoneCall.State, ? extends PhoneCall.Action>>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory.create.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Out<PhoneCall.State, PhoneCall.Action> invoke(final RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                Out.Companion companion = Out.INSTANCE;
                final PhoneCall.State state = init;
                final PhoneCallViewModelFactory phoneCallViewModelFactory = this;
                return companion.invoke(state, new Function1<Out.Builder<? extends PhoneCall.State, PhoneCall.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory.create.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: PhoneCallViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory$create$1$1$1", f = "PhoneCallViewModelFactory.kt", l = {74}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory$create$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03431 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                        final /* synthetic */ RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> $this_RuntimeViewModel;
                        final /* synthetic */ Out.Builder<PhoneCall.State, PhoneCall.Action> $this_invoke;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C03431(RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModelDependencies, Out.Builder<? extends PhoneCall.State, PhoneCall.Action> builder, Continuation<? super C03431> continuation) {
                            super(1, continuation);
                            this.$this_RuntimeViewModel = runtimeViewModelDependencies;
                            this.$this_invoke = builder;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C03431(this.$this_RuntimeViewModel, this.$this_invoke, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super PhoneCall.Action> continuation) {
                            return ((C03431) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<PhoneCall.State, Continuation<? super PhoneCall.Action>, Object> showState = this.$this_RuntimeViewModel.getShowState();
                                PhoneCall.State state = this.$this_invoke.getState();
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
                    public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends PhoneCall.State, PhoneCall.Action> builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Out.Builder<? extends PhoneCall.State, PhoneCall.Action> invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        CoreKt.input(invoke, new C03431(RuntimeViewModel, invoke, null));
                        if (state instanceof PhoneCall.State.Init) {
                            CoreKt.input(invoke, new AnonymousClass2(phoneCallViewModelFactory, null));
                        }
                    }

                    /* compiled from: PhoneCallViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory$create$1$1$2", f = "PhoneCallViewModelFactory.kt", l = {76}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory$create$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PhoneCall.Action>, Object> {
                        int label;
                        final /* synthetic */ PhoneCallViewModelFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(PhoneCallViewModelFactory phoneCallViewModelFactory, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.this$0 = phoneCallViewModelFactory;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
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
                                String processId = this.this$0.config.getProcessId();
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
                });
            }
        }, new Function1<RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect>, Function2<? super PhoneCall.State, ? super PhoneCall.Action, ? extends Out<? extends PhoneCall.State, ? extends PhoneCall.Action>>>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory.create.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function2<PhoneCall.State, PhoneCall.Action, Out<PhoneCall.State, PhoneCall.Action>> invoke(RuntimeViewModelDependencies<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return new PhoneCallBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), PhoneCallViewModelFactory.this.interactor, PhoneCallViewModelFactory.this.analyticsLogger);
            }
        }, null, null, null, null, null, null, null, null, 2040, null);
        runtimeViewModelRuntimeViewModel$default.getStates().observeForever(new PhoneCallViewModelFactory$sam$androidx_lifecycle_Observer$0(new Function1<PhoneCall.State, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory$create$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PhoneCall.State state) {
                invoke2(state);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PhoneCall.State state) {
                handle.set(PhoneCallViewModelFactory.SESSION, null);
                handle.set(PhoneCallViewModelFactory.CONFIRM_CODE, null);
                handle.set(PhoneCallViewModelFactory.FAILURE, null);
                handle.set(PhoneCallViewModelFactory.IS_ENABLED_PROGRESS, null);
                if (state instanceof PhoneCall.State.Content) {
                    PhoneCall.State.Content content = (PhoneCall.State.Content) state;
                    handle.set(PhoneCallViewModelFactory.SESSION, content.getSession());
                    handle.set(PhoneCallViewModelFactory.CONFIRM_CODE, content.getConfirmCode());
                    handle.set(PhoneCallViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(content.isEnabledProgressIndicator()));
                    return;
                }
                if (state instanceof PhoneCall.State.Error) {
                    PhoneCall.State.Error error = (PhoneCall.State.Error) state;
                    handle.set(PhoneCallViewModelFactory.SESSION, error.getSession());
                    handle.set(PhoneCallViewModelFactory.CONFIRM_CODE, error.getConfirmCode());
                    handle.set(PhoneCallViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(error.isEnabledProgressIndicator()));
                    handle.set(PhoneCallViewModelFactory.FAILURE, error.getFailure());
                    return;
                }
                if (state instanceof PhoneCall.State.Confirm) {
                    PhoneCall.State.Confirm confirm = (PhoneCall.State.Confirm) state;
                    handle.set(PhoneCallViewModelFactory.SESSION, confirm.getSession());
                    handle.set(PhoneCallViewModelFactory.CONFIRM_CODE, confirm.getConfirmCode());
                    handle.set(PhoneCallViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(confirm.isEnabledProgressIndicator()));
                    return;
                }
                if (state instanceof PhoneCall.State.InitialError) {
                    handle.set(PhoneCallViewModelFactory.FAILURE, ((PhoneCall.State.InitialError) state).getFailure());
                } else {
                    boolean z = state instanceof PhoneCall.State.Init;
                }
            }
        }));
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
