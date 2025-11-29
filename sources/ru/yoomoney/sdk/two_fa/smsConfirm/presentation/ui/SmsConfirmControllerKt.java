package ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui;

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
import ru.yoomoney.sdk.two_fa.smsConfirm.SmsConfirm;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmViewModelFactory;
import ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: SmsConfirmController.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0001¢\u0006\u0002\u0010\u0010*0\b\u0000\u0010\u0011\"\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00122\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"SmsConfirmController", "", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmAnalyticsLogger;", "onBack", "Lkotlin/Function0;", "onSuccessConfirm", "onShowHelp", "Lkotlin/Function1;", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmAnalyticsLogger;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SmsConfirmViewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Action;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Effect;", "two-fa_release", "viewModelFactory", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmViewModelFactory;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsConfirmControllerKt {
    public static final void SmsConfirmController(final Config config, final SmsConfirmInteractor interactor, final ResourceMapper resourceMapper, final SmsConfirmAnalyticsLogger smsConfirmAnalyticsLogger, final Function0<Unit> onBack, final Function0<Unit> onSuccessConfirm, final Function1<? super SessionType, Unit> onShowHelp, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onSuccessConfirm, "onSuccessConfirm");
        Intrinsics.checkNotNullParameter(onShowHelp, "onShowHelp");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1668187340);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1668187340, i, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmController (SmsConfirmController.kt:34)");
        }
        final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Lazy lazy = LazyKt.lazy(new Function0<SmsConfirmViewModelFactory>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$viewModelFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SmsConfirmViewModelFactory invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.EntryPointActivity");
                return new SmsConfirmViewModelFactory(config, interactor, smsConfirmAnalyticsLogger, (EntryPointActivity) context2, null, 16, null);
            }
        });
        composerStartRestartGroup.startReplaceableGroup(-276432130);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModel viewModel = new ViewModelProvider(current.getViewModelStore(), SmsConfirmController$lambda$0(lazy), null, 4, null).get("SmsConfirm", (Class<ViewModel>) RuntimeViewModel.class);
        composerStartRestartGroup.endReplaceableGroup();
        final RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
        composerStartRestartGroup.startReplaceableGroup(-1559858928);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        Channel channel = (Channel) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new AnonymousClass1(onSuccessConfirm, channel, resourceMapper, onShowHelp, null), composerStartRestartGroup, 72);
        SmsConfirmUiState smsConfirmUiState = (SmsConfirmUiState) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), SmsConfirmUiState.Init.INSTANCE, new Function1<SmsConfirm.State, SmsConfirmUiState>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SmsConfirmUiState invoke(SmsConfirm.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ResourceMapper resourceMapper2 = resourceMapper;
                Context context2 = context;
                final Function0<Unit> function0 = onBack;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.2.1
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
                final RuntimeViewModel<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> runtimeViewModel2 = runtimeViewModel;
                return SmsConfirmUiStateMapperKt.mapToUiState(it, resourceMapper2, context2, function02, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.2.2
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
                        SmsConfirmControllerKt.SmsConfirmController$restartSession(runtimeViewModel2);
                    }
                });
            }
        }, composerStartRestartGroup, 56).getValue();
        composerStartRestartGroup.startReplaceableGroup(-1559857866);
        boolean z = (((57344 & i) ^ 24576) > 16384 && composerStartRestartGroup.changedInstance(onBack)) || (i & 24576) == 16384;
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$3$1
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
        SmsConfirmScreenKt.SmsConfirmScreen(smsConfirmUiState, channel, (Function0) objRememberedValue2, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.4
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
                SmsConfirmControllerKt.SmsConfirmController$restartSession(runtimeViewModel);
            }
        }, new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.5
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
                SmsConfirmControllerKt.SmsConfirmController$codeChange(runtimeViewModel, value);
            }
        }, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.6
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
                runtimeViewModel.handleAction(SmsConfirm.Action.ShowHelp.INSTANCE);
            }
        }, composerStartRestartGroup, 64);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass7(runtimeViewModel, null), composerStartRestartGroup, 70);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt.SmsConfirmController.8
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
                    SmsConfirmControllerKt.SmsConfirmController(config, interactor, resourceMapper, smsConfirmAnalyticsLogger, onBack, onSuccessConfirm, onShowHelp, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final SmsConfirmViewModelFactory SmsConfirmController$lambda$0(Lazy<SmsConfirmViewModelFactory> lazy) {
        return lazy.getValue();
    }

    /* compiled from: SmsConfirmController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "effect", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$Effect;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$1", f = "SmsConfirmController.kt", l = {54}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<SmsConfirm.Effect, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Notice> $notices;
        final /* synthetic */ Function1<SessionType, Unit> $onShowHelp;
        final /* synthetic */ Function0<Unit> $onSuccessConfirm;
        final /* synthetic */ ResourceMapper $resourceMapper;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<Unit> function0, Channel<Notice> channel, ResourceMapper resourceMapper, Function1<? super SessionType, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onSuccessConfirm = function0;
            this.$notices = channel;
            this.$resourceMapper = resourceMapper;
            this.$onShowHelp = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onSuccessConfirm, this.$notices, this.$resourceMapper, this.$onShowHelp, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SmsConfirm.Effect effect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SmsConfirm.Effect effect = (SmsConfirm.Effect) this.L$0;
                if (effect instanceof SmsConfirm.Effect.ConfirmSmsSuccess) {
                    this.$onSuccessConfirm.invoke();
                } else if (effect instanceof SmsConfirm.Effect.ShowFailure) {
                    Channel<Notice> channel = this.$notices;
                    Notice noticeAlert$default = Notice.Companion.alert$default(Notice.INSTANCE, ResourceMapper.map$default(this.$resourceMapper, ((SmsConfirm.Effect.ShowFailure) effect).getFailure(), null, 2, null), null, null, 6, null);
                    this.label = 1;
                    if (channel.send(noticeAlert$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (effect instanceof SmsConfirm.Effect.ShowHelp) {
                    this.$onShowHelp.invoke(SessionType.SMS);
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
    public static final void SmsConfirmController$codeChange(RuntimeViewModel<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> runtimeViewModel, String str) {
        runtimeViewModel.handleAction(new SmsConfirm.Action.CodeChanged(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SmsConfirmController$restartSession(RuntimeViewModel<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(SmsConfirm.Action.RestartSession.INSTANCE);
    }

    /* compiled from: SmsConfirmController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$7", f = "SmsConfirmController.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt$SmsConfirmController$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RuntimeViewModel<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(RuntimeViewModel<SmsConfirm.State, SmsConfirm.Action, SmsConfirm.Effect> runtimeViewModel, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$viewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$viewModel.handleAction(new SmsConfirm.Action.SendAnalyticsForScreen(ProcessType.REGISTRATION));
            return Unit.INSTANCE;
        }
    }
}
