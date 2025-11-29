package ru.yoomoney.sdk.two_fa.phoneCall.presentation;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.EntryPointActivity;
import ru.yoomoney.sdk.two_fa.api.ProcessType;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallViewModelFactory;
import ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: PhoneCallController.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0011*0\b\u0000\u0010\u0012\"\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00132\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0013¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002"}, d2 = {"PhoneCallController", "", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "nextSessionType", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallAnalyticsLogger;", "onBack", "Lkotlin/Function0;", "onSuccessConfirm", "onOpenNextAvailableSession", "Lkotlin/Function1;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;Lru/yoomoney/sdk/two_fa/domain/SessionType;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallAnalyticsLogger;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PhoneCallViewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Effect;", "two-fa_release", "viewModelFactory", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallViewModelFactory;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallControllerKt {
    public static final void PhoneCallController(final Config config, final PhoneCallInteractor interactor, final ResourceMapper resourceMapper, final SessionType sessionType, final PhoneCallAnalyticsLogger phoneCallAnalyticsLogger, final Function0<Unit> onBack, final Function0<Unit> onSuccessConfirm, final Function1<? super SessionType, Unit> onOpenNextAvailableSession, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onSuccessConfirm, "onSuccessConfirm");
        Intrinsics.checkNotNullParameter(onOpenNextAvailableSession, "onOpenNextAvailableSession");
        Composer composerStartRestartGroup = composer.startRestartGroup(1276475381);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1276475381, i, -1, "ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallController (PhoneCallController.kt:35)");
        }
        final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Lazy lazy = LazyKt.lazy(new Function0<PhoneCallViewModelFactory>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$viewModelFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PhoneCallViewModelFactory invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.EntryPointActivity");
                return new PhoneCallViewModelFactory(config, interactor, sessionType, phoneCallAnalyticsLogger, (EntryPointActivity) context2, null, 32, null);
            }
        });
        composerStartRestartGroup.startReplaceableGroup(-276432130);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModel viewModel = new ViewModelProvider(current.getViewModelStore(), PhoneCallController$lambda$0(lazy), null, 4, null).get("PhoneCall", (Class<ViewModel>) RuntimeViewModel.class);
        composerStartRestartGroup.endReplaceableGroup();
        final RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
        composerStartRestartGroup.startReplaceableGroup(-301153549);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        Channel channel = (Channel) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new AnonymousClass1(onSuccessConfirm, onOpenNextAvailableSession, channel, resourceMapper, null), composerStartRestartGroup, 72);
        PhoneCallUiState phoneCallUiState = (PhoneCallUiState) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), PhoneCallUiState.Init.INSTANCE, new Function1<PhoneCall.State, PhoneCallUiState>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PhoneCallUiState invoke(PhoneCall.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                ResourceMapper resourceMapper2 = resourceMapper;
                Context context2 = context;
                final Function0<Unit> function0 = onBack;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function0.invoke();
                    }
                };
                final RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModel2 = runtimeViewModel;
                return PhoneCallUiStateMapperKt.mapToUiState(state, resourceMapper2, context2, function02, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PhoneCallControllerKt.PhoneCallController$restartSession(runtimeViewModel2);
                    }
                });
            }
        }, composerStartRestartGroup, 56).getValue();
        composerStartRestartGroup.startReplaceableGroup(-301152331);
        boolean z = (((458752 & i) ^ 196608) > 131072 && composerStartRestartGroup.changedInstance(onBack)) || (i & 196608) == 131072;
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onBack.invoke();
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        PhoneCallScreenKt.PhoneCallScreen(phoneCallUiState, channel, (Function0) objRememberedValue2, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PhoneCallControllerKt.PhoneCallController$nextAvailableSession(runtimeViewModel);
            }
        }, new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                PhoneCallControllerKt.PhoneCallController$codeChange(runtimeViewModel, value);
            }
        }, composerStartRestartGroup, 64);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass6(runtimeViewModel, null), composerStartRestartGroup, 70);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt.PhoneCallController.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    PhoneCallControllerKt.PhoneCallController(config, interactor, resourceMapper, sessionType, phoneCallAnalyticsLogger, onBack, onSuccessConfirm, onOpenNextAvailableSession, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final PhoneCallViewModelFactory PhoneCallController$lambda$0(Lazy<PhoneCallViewModelFactory> lazy) {
        return lazy.getValue();
    }

    /* compiled from: PhoneCallController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "effect", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Effect;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$1", f = "PhoneCallController.kt", l = {59}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PhoneCall.Effect, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Notice> $notices;
        final /* synthetic */ Function1<SessionType, Unit> $onOpenNextAvailableSession;
        final /* synthetic */ Function0<Unit> $onSuccessConfirm;
        final /* synthetic */ ResourceMapper $resourceMapper;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<Unit> function0, Function1<? super SessionType, Unit> function1, Channel<Notice> channel, ResourceMapper resourceMapper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onSuccessConfirm = function0;
            this.$onOpenNextAvailableSession = function1;
            this.$notices = channel;
            this.$resourceMapper = resourceMapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onSuccessConfirm, this.$onOpenNextAvailableSession, this.$notices, this.$resourceMapper, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PhoneCall.Effect effect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneCall.Effect effect = (PhoneCall.Effect) this.L$0;
                if (effect instanceof PhoneCall.Effect.ConfirmPhoneCallSuccess) {
                    this.$onSuccessConfirm.invoke();
                } else if (effect instanceof PhoneCall.Effect.OpenNextAvailableSession) {
                    this.$onOpenNextAvailableSession.invoke(((PhoneCall.Effect.OpenNextAvailableSession) effect).getSessionType());
                } else if (effect instanceof PhoneCall.Effect.ShowFailure) {
                    Channel<Notice> channel = this.$notices;
                    Notice noticeAlert$default = Notice.Companion.alert$default(Notice.INSTANCE, ResourceMapper.map$default(this.$resourceMapper, ((PhoneCall.Effect.ShowFailure) effect).getFailure(), null, 2, null), null, null, 6, null);
                    this.label = 1;
                    if (channel.send(noticeAlert$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PhoneCallController$codeChange(RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModel, String str) {
        runtimeViewModel.handleAction(new PhoneCall.Action.CodeChanged(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PhoneCallController$restartSession(RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(PhoneCall.Action.RestartSession.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PhoneCallController$nextAvailableSession(RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(PhoneCall.Action.NextAvailableSession.INSTANCE);
    }

    /* compiled from: PhoneCallController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$6", f = "PhoneCallController.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt$PhoneCallController$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(RuntimeViewModel<PhoneCall.State, PhoneCall.Action, PhoneCall.Effect> runtimeViewModel, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$viewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$viewModel.handleAction(new PhoneCall.Action.SendAnalyticsForScreen(ProcessType.REGISTRATION));
            return Unit.INSTANCE;
        }
    }
}
