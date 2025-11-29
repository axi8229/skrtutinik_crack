package ru.yoomoney.sdk.two_fa.confirmationHelp.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;
import ru.yoomoney.sdk.two_fa.Routes;
import ru.yoomoney.sdk.two_fa.confirmationHelp.ConfirmationHelp;
import ru.yoomoney.sdk.two_fa.domain.SessionType;

/* compiled from: ConfirmationHelpViewModelFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/impl/ConfirmationHelpViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", Routes.sessionTypeArg, "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "isActionVisible", "", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Z)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelpViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 0;
    public static final String CONFIRMATION_HELP = "ConfirmationHelp";
    private final boolean isActionVisible;
    private final SessionType sessionType;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public ConfirmationHelpViewModelFactory(SessionType sessionType, boolean z) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        this.sessionType = sessionType;
        this.isActionVisible = z;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("ConfirmationHelp", new Function1<RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect>, Out<? extends ConfirmationHelp.State, ? extends ConfirmationHelp.Action>>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory.create.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Out<ConfirmationHelp.State, ConfirmationHelp.Action> invoke(final RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return Out.INSTANCE.invoke(new ConfirmationHelp.State.Content(ConfirmationHelpViewModelFactory.this.sessionType, ConfirmationHelpViewModelFactory.this.isActionVisible), new Function1<Out.Builder<? extends ConfirmationHelp.State.Content, ConfirmationHelp.Action>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory.create.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: ConfirmationHelpViewModelFactory.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory$create$1$1$1", f = "ConfirmationHelpViewModelFactory.kt", l = {24}, m = "invokeSuspend")
                    /* renamed from: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory$create$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03221 extends SuspendLambda implements Function1<Continuation<? super ConfirmationHelp.Action>, Object> {
                        final /* synthetic */ RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> $this_RuntimeViewModel;
                        final /* synthetic */ Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> $this_invoke;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C03221(RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> runtimeViewModelDependencies, Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> builder, Continuation<? super C03221> continuation) {
                            super(1, continuation);
                            this.$this_RuntimeViewModel = runtimeViewModelDependencies;
                            this.$this_invoke = builder;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new C03221(this.$this_RuntimeViewModel, this.$this_invoke, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Continuation<? super ConfirmationHelp.Action> continuation) {
                            return ((C03221) create(continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<ConfirmationHelp.State, Continuation<? super ConfirmationHelp.Action>, Object> showState = this.$this_RuntimeViewModel.getShowState();
                                ConfirmationHelp.State.Content state = this.$this_invoke.getState();
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
                    public /* bridge */ /* synthetic */ Unit invoke(Out.Builder<? extends ConfirmationHelp.State.Content, ConfirmationHelp.Action> builder) {
                        invoke2((Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action>) builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Out.Builder<ConfirmationHelp.State.Content, ConfirmationHelp.Action> invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        CoreKt.input(invoke, new C03221(RuntimeViewModel, invoke, null));
                    }
                });
            }
        }, new Function1<RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect>, Function2<? super ConfirmationHelp.State, ? super ConfirmationHelp.Action, ? extends Out<? extends ConfirmationHelp.State, ? extends ConfirmationHelp.Action>>>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory.create.2
            @Override // kotlin.jvm.functions.Function1
            public final Function2<ConfirmationHelp.State, ConfirmationHelp.Action, Out<ConfirmationHelp.State, ConfirmationHelp.Action>> invoke(RuntimeViewModelDependencies<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> RuntimeViewModel) {
                Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
                return new ConfirmationHelpBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource());
            }
        }, null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
