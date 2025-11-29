package ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import java.util.List;
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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.EntryPointActivity;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointViewModelFactory;
import ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: EntryPointController.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\r\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000e*0\b\u0000\u0010\u0013\"\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000f2\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000f¨\u0006\u0016²\u0006\f\u0010\u0015\u001a\u00020\u00148\nX\u008a\u0084\u0002"}, d2 = {"Lru/yoomoney/sdk/two_fa/Config;", "config", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "interactor", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "resourceMapper", "Lkotlin/Function1;", "", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "", "onNavigateToConfirm", "Lkotlin/Function0;", "onBack", "EntryPointController", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;", "EntryPointViewModel", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointViewModelFactory;", "viewModelFactory", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointControllerKt {
    public static final void EntryPointController(final Config config, final EntryPointInteractor interactor, final ResourceMapper resourceMapper, final Function1<? super List<? extends SessionType>, Unit> onNavigateToConfirm, final Function0<Unit> onBack, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(onNavigateToConfirm, "onNavigateToConfirm");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-86874231);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-86874231, i, -1, "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointController (EntryPointController.kt:29)");
        }
        final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Lazy lazy = LazyKt.lazy(new Function0<EntryPointViewModelFactory>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt$EntryPointController$viewModelFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final EntryPointViewModelFactory invoke() {
                Config config2 = config;
                EntryPointInteractor entryPointInteractor = interactor;
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.EntryPointActivity");
                return new EntryPointViewModelFactory(config2, entryPointInteractor, (EntryPointActivity) context2, null, 8, null);
            }
        });
        composerStartRestartGroup.startReplaceableGroup(-276432130);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModel viewModel = new ViewModelProvider(current.getViewModelStore(), EntryPointController$lambda$0(lazy), null, 4, null).get("EntryPoint", (Class<ViewModel>) RuntimeViewModel.class);
        composerStartRestartGroup.endReplaceableGroup();
        final RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
        composerStartRestartGroup.startReplaceableGroup(-1461837198);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        Channel channel = (Channel) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new AnonymousClass1(channel, resourceMapper, onNavigateToConfirm, null), composerStartRestartGroup, 72);
        EntryPointUiState entryPointUiState = (EntryPointUiState) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), EntryPointUiState.Init.INSTANCE, new Function1<EntryPoint.State, EntryPointUiState>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt.EntryPointController.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final EntryPointUiState invoke(EntryPoint.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ResourceMapper resourceMapper2 = resourceMapper;
                Context context2 = context;
                final RuntimeViewModel<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> runtimeViewModel2 = runtimeViewModel;
                return EntryPointUiStateMapperKt.mapToUiState(it, resourceMapper2, context2, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt.EntryPointController.2.1
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
                        EntryPointControllerKt.EntryPointController$restartLoadingContext(runtimeViewModel2);
                    }
                });
            }
        }, composerStartRestartGroup, 56).getValue();
        composerStartRestartGroup.startReplaceableGroup(-1461836343);
        boolean z = (((57344 & i) ^ 24576) > 16384 && composerStartRestartGroup.changedInstance(onBack)) || (i & 24576) == 16384;
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt$EntryPointController$3$1
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
        EntryPointScreenKt.EntryPointScreen(entryPointUiState, channel, (Function0) objRememberedValue2, composerStartRestartGroup, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt.EntryPointController.4
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
                    EntryPointControllerKt.EntryPointController(config, interactor, resourceMapper, onNavigateToConfirm, onBack, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final EntryPointViewModelFactory EntryPointController$lambda$0(Lazy<EntryPointViewModelFactory> lazy) {
        return lazy.getValue();
    }

    /* compiled from: EntryPointController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "effect", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt$EntryPointController$1", f = "EntryPointController.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt$EntryPointController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<EntryPoint.Effect, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Notice> $notices;
        final /* synthetic */ Function1<List<? extends SessionType>, Unit> $onNavigateToConfirm;
        final /* synthetic */ ResourceMapper $resourceMapper;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Channel<Notice> channel, ResourceMapper resourceMapper, Function1<? super List<? extends SessionType>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$notices = channel;
            this.$resourceMapper = resourceMapper;
            this.$onNavigateToConfirm = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$notices, this.$resourceMapper, this.$onNavigateToConfirm, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(EntryPoint.Effect effect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EntryPoint.Effect effect = (EntryPoint.Effect) this.L$0;
                if (effect instanceof EntryPoint.Effect.ShowFailure) {
                    Channel<Notice> channel = this.$notices;
                    Notice noticeAlert$default = Notice.Companion.alert$default(Notice.INSTANCE, ResourceMapper.map$default(this.$resourceMapper, ((EntryPoint.Effect.ShowFailure) effect).getFailure(), null, 2, null), null, null, 6, null);
                    this.label = 1;
                    if (channel.send(noticeAlert$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (effect instanceof EntryPoint.Effect.NavigateToConfirmation) {
                    this.$onNavigateToConfirm.invoke(((EntryPoint.Effect.NavigateToConfirmation) effect).getAvailableSessionOptions());
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
    public static final void EntryPointController$restartLoadingContext(RuntimeViewModel<EntryPoint.State, EntryPoint.Action, EntryPoint.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(EntryPoint.Action.RestartLoadingContext.INSTANCE);
    }
}
