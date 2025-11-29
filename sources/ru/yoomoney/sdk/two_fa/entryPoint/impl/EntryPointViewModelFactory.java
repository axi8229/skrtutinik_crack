package ru.yoomoney.sdk.two_fa.entryPoint.impl;

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
import ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint;
import ru.yoomoney.sdk.two_fa.exception.Failure;

/* compiled from: EntryPointViewModelFactory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointViewModelFactory extends AbstractSavedStateViewModelFactory {
    public static final String ENTRY_POINT = "EntryPoint";
    private final Config config;
    private final EntryPointInteractor interactor;
    public static final int $stable = 8;
    private static final String FAILURE = EntryPointViewModelFactory.class.getName() + ".failure";

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public /* synthetic */ EntryPointViewModelFactory(Config config, EntryPointInteractor entryPointInteractor, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, entryPointInteractor, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryPointViewModelFactory(Config config, EntryPointInteractor interactor, SavedStateRegistryOwner owner, Bundle bundle) {
        super(owner, bundle);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.config = config;
        this.interactor = interactor;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected <T extends ViewModel> T create(String key, Class<T> modelClass, final SavedStateHandle handle) {
        final EntryPoint.State init;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        Failure failure = (Failure) handle.get(FAILURE);
        if (failure != null) {
            init = new EntryPoint.State.InitialError(this.config.getProcessId(), failure);
        } else {
            init = new EntryPoint.State.Init(this.config.getProcessId());
        }
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("EntryPoint", new Function1<RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect>, Out<? extends EntryPoint.State, ? extends EntryPoint.Action>>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory.create.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Out<EntryPoint.State, EntryPoint.Action> invoke(final RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                Out.Companion companion = Out.INSTANCE;
                final EntryPoint.State state = init;
                final EntryPointViewModelFactory entryPointViewModelFactory = this;
                return companion.invoke(state, new Function1<Out.Builder<? extends EntryPoint.State, EntryPoint.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory.create.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: EntryPointViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory$create$1$1$1", f = "EntryPointViewModelFactory.kt", l = {41}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory$create$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03341 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                        final /* synthetic */ RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> $this_RuntimeViewModel;
                        final /* synthetic */ Out.Builder<EntryPoint.State, EntryPoint.Action> $this_invoke;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C03341(RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> runtimeViewModelDependencies, Out.Builder<? extends EntryPoint.State, EntryPoint.Action> builder, Continuation<? super C03341> continuation) {
                            super(1, continuation);
                            this.$this_RuntimeViewModel = runtimeViewModelDependencies;
                            this.$this_invoke = builder;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C03341(this.$this_RuntimeViewModel, this.$this_invoke, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super EntryPoint.Action> continuation) {
                            return ((C03341) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<EntryPoint.State, Continuation<? super EntryPoint.Action>, Object> showState = this.$this_RuntimeViewModel.getShowState();
                                EntryPoint.State state = this.$this_invoke.getState();
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
                    public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends EntryPoint.State, EntryPoint.Action> builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Out.Builder<? extends EntryPoint.State, EntryPoint.Action> invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        CoreKt.input(invoke, new C03341(RuntimeViewModel, invoke, null));
                        if (state instanceof EntryPoint.State.Init) {
                            CoreKt.input(invoke, new AnonymousClass2(entryPointViewModelFactory, null));
                        }
                    }

                    /* compiled from: EntryPointViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory$create$1$1$2", f = "EntryPointViewModelFactory.kt", l = {43}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory$create$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super EntryPoint.Action>, Object> {
                        int label;
                        final /* synthetic */ EntryPointViewModelFactory this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(EntryPointViewModelFactory entryPointViewModelFactory, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.this$0 = entryPointViewModelFactory;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
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
                                String processId = this.this$0.config.getProcessId();
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
                });
            }
        }, new Function1<RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect>, Function2<? super EntryPoint.State, ? super EntryPoint.Action, ? extends Out<? extends EntryPoint.State, ? extends EntryPoint.Action>>>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory.create.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function2<EntryPoint.State, EntryPoint.Action, Out<EntryPoint.State, EntryPoint.Action>> invoke(RuntimeViewModelDependencies<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return new EntryPointBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), EntryPointViewModelFactory.this.interactor);
            }
        }, null, null, null, null, null, null, null, null, 2040, null);
        runtimeViewModelRuntimeViewModel$default.getStates().observeForever(new EntryPointViewModelFactory$sam$androidx_lifecycle_Observer$0(new Function1<EntryPoint.State, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory$create$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EntryPoint.State state) {
                invoke2(state);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EntryPoint.State state) {
                if (state instanceof EntryPoint.State.InitialError) {
                    handle.set(EntryPointViewModelFactory.FAILURE, ((EntryPoint.State.InitialError) state).getFailure());
                } else {
                    boolean z = state instanceof EntryPoint.State.Init;
                }
            }
        }));
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
