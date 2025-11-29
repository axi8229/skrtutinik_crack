package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl;

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
import ru.yoomoney.sdk.two_fa.domain.SessionEmail;
import ru.yoomoney.sdk.two_fa.emailConfirm.EmailConfirm;
import ru.yoomoney.sdk.two_fa.exception.Failure;

/* compiled from: EmailConfirmViewModelFactory.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014¢\u0006\u0002\u0010\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmAnalyticsLogger;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmAnalyticsLogger;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirmViewModelFactory extends AbstractSavedStateViewModelFactory {
    public static final String EMAIL_CONFIRM = "EmailConfirm";
    private final EmailConfirmAnalyticsLogger analyticsLogger;
    private final Config config;
    private final EmailConfirmInteractor interactor;
    public static final int $stable = 8;
    private static final String SESSION = EmailConfirmViewModelFactory.class.getName() + ".session";
    private static final String CONFIRM_CODE = EmailConfirmViewModelFactory.class.getName() + ".confirm_code";
    private static final String FAILURE = EmailConfirmViewModelFactory.class.getName() + ".failure";
    private static final String IS_ENABLED_PROGRESS = EmailConfirmViewModelFactory.class.getName() + ".is_enabled_progress";
    private static final String IS_ENABLED_CONFIRM_ACTION = EmailConfirmViewModelFactory.class.getName() + ".is_enabled_confirm_action";

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public /* synthetic */ EmailConfirmViewModelFactory(Config config, EmailConfirmInteractor emailConfirmInteractor, EmailConfirmAnalyticsLogger emailConfirmAnalyticsLogger, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, emailConfirmInteractor, emailConfirmAnalyticsLogger, savedStateRegistryOwner, (i & 16) != 0 ? null : bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmailConfirmViewModelFactory(Config config, EmailConfirmInteractor interactor, EmailConfirmAnalyticsLogger emailConfirmAnalyticsLogger, SavedStateRegistryOwner owner, Bundle bundle) {
        super(owner, bundle);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.config = config;
        this.interactor = interactor;
        this.analyticsLogger = emailConfirmAnalyticsLogger;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, final SavedStateHandle handle) {
        final EmailConfirm.State init;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        SessionEmail sessionEmail = (SessionEmail) handle.get(SESSION);
        String str = (String) handle.get(CONFIRM_CODE);
        Failure failure = (Failure) handle.get(FAILURE);
        Boolean bool = (Boolean) handle.get(IS_ENABLED_PROGRESS);
        Boolean bool2 = (Boolean) handle.get(IS_ENABLED_CONFIRM_ACTION);
        if (failure != null && sessionEmail != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE)) {
            init = new EmailConfirm.State.Error(this.config.getProcessId(), sessionEmail, str, failure, bool.booleanValue());
        } else if (sessionEmail != null && str != null && Intrinsics.areEqual(bool, Boolean.FALSE) && bool2 != null) {
            init = new EmailConfirm.State.Content(this.config.getProcessId(), sessionEmail, str, bool2.booleanValue(), bool.booleanValue());
        } else if (sessionEmail != null && str != null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            init = new EmailConfirm.State.Confirm(this.config.getProcessId(), sessionEmail, str, bool.booleanValue());
        } else if (failure != null) {
            init = new EmailConfirm.State.InitialError(this.config.getProcessId(), failure);
        } else {
            init = new EmailConfirm.State.Init(this.config.getProcessId());
        }
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("EmailConfirm", new Function1<RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect>, Out<? extends EmailConfirm.State, ? extends EmailConfirm.Action>>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory.create.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Out<EmailConfirm.State, EmailConfirm.Action> invoke(final RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                Out.Companion companion = Out.INSTANCE;
                final EmailConfirm.State state = init;
                final EmailConfirmViewModelFactory emailConfirmViewModelFactory = this;
                return companion.invoke(state, new Function1<Out.Builder<? extends EmailConfirm.State, EmailConfirm.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory.create.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: EmailConfirmViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory$create$1$1$1", f = "EmailConfirmViewModelFactory.kt", l = {70}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory$create$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03291 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                        final /* synthetic */ RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $this_RuntimeViewModel;
                        final /* synthetic */ Out.Builder<EmailConfirm.State, EmailConfirm.Action> $this_invoke;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C03291(RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModelDependencies, Out.Builder<? extends EmailConfirm.State, EmailConfirm.Action> builder, Continuation<? super C03291> continuation) {
                            super(1, continuation);
                            this.$this_RuntimeViewModel = runtimeViewModelDependencies;
                            this.$this_invoke = builder;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C03291(this.$this_RuntimeViewModel, this.$this_invoke, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super EmailConfirm.Action> continuation) {
                            return ((C03291) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<EmailConfirm.State, Continuation<? super EmailConfirm.Action>, Object> showState = this.$this_RuntimeViewModel.getShowState();
                                EmailConfirm.State state = this.$this_invoke.getState();
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
                    public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EmailConfirm.State, EmailConfirm.Action> builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Out.Builder<? extends EmailConfirm.State, EmailConfirm.Action> invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        CoreKt.input(invoke, new C03291(RuntimeViewModel, invoke, null));
                        if (state instanceof EmailConfirm.State.Init) {
                            CoreKt.input(invoke, new AnonymousClass2(emailConfirmViewModelFactory, null));
                        }
                    }

                    /* compiled from: EmailConfirmViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory$create$1$1$2", f = "EmailConfirmViewModelFactory.kt", l = {72}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory$create$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EmailConfirm.Action>, Object> {
                        int label;
                        final /* synthetic */ EmailConfirmViewModelFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(EmailConfirmViewModelFactory emailConfirmViewModelFactory, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.this$0 = emailConfirmViewModelFactory;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
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
                                String processId = this.this$0.config.getProcessId();
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
                });
            }
        }, new Function1<RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect>, Function2<? super EmailConfirm.State, ? super EmailConfirm.Action, ? extends Out<? extends EmailConfirm.State, ? extends EmailConfirm.Action>>>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory.create.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function2<EmailConfirm.State, EmailConfirm.Action, Out<EmailConfirm.State, EmailConfirm.Action>> invoke(RuntimeViewModelDependencies<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return new EmailConfirmBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), EmailConfirmViewModelFactory.this.interactor, EmailConfirmViewModelFactory.this.analyticsLogger);
            }
        }, null, null, null, null, null, null, null, null, 2040, null);
        runtimeViewModelRuntimeViewModel$default.getStates().observeForever(new EmailConfirmViewModelFactory$sam$androidx_lifecycle_Observer$0(new Function1<EmailConfirm.State, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory$create$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmailConfirm.State state) {
                invoke2(state);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EmailConfirm.State state) {
                handle.set(EmailConfirmViewModelFactory.SESSION, null);
                handle.set(EmailConfirmViewModelFactory.CONFIRM_CODE, null);
                handle.set(EmailConfirmViewModelFactory.FAILURE, null);
                handle.set(EmailConfirmViewModelFactory.IS_ENABLED_PROGRESS, null);
                handle.set(EmailConfirmViewModelFactory.IS_ENABLED_CONFIRM_ACTION, null);
                if (state instanceof EmailConfirm.State.Content) {
                    EmailConfirm.State.Content content = (EmailConfirm.State.Content) state;
                    handle.set(EmailConfirmViewModelFactory.SESSION, content.getSession());
                    handle.set(EmailConfirmViewModelFactory.CONFIRM_CODE, content.getConfirmCode());
                    handle.set(EmailConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(content.isEnabledProgressIndicator()));
                    handle.set(EmailConfirmViewModelFactory.IS_ENABLED_CONFIRM_ACTION, Boolean.valueOf(content.getEnabledConfirmAction()));
                    return;
                }
                if (state instanceof EmailConfirm.State.Error) {
                    EmailConfirm.State.Error error = (EmailConfirm.State.Error) state;
                    handle.set(EmailConfirmViewModelFactory.SESSION, error.getSession());
                    handle.set(EmailConfirmViewModelFactory.CONFIRM_CODE, error.getConfirmCode());
                    handle.set(EmailConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(error.isEnabledProgressIndicator()));
                    handle.set(EmailConfirmViewModelFactory.FAILURE, error.getFailure());
                    return;
                }
                if (state instanceof EmailConfirm.State.Confirm) {
                    EmailConfirm.State.Confirm confirm = (EmailConfirm.State.Confirm) state;
                    handle.set(EmailConfirmViewModelFactory.SESSION, confirm.getSession());
                    handle.set(EmailConfirmViewModelFactory.CONFIRM_CODE, confirm.getConfirmCode());
                    handle.set(EmailConfirmViewModelFactory.IS_ENABLED_PROGRESS, Boolean.valueOf(confirm.isEnabledProgressIndicator()));
                    return;
                }
                if (state instanceof EmailConfirm.State.InitialError) {
                    handle.set(EmailConfirmViewModelFactory.FAILURE, ((EmailConfirm.State.InitialError) state).getFailure());
                } else {
                    boolean z = state instanceof EmailConfirm.State.Init;
                }
            }
        }));
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
