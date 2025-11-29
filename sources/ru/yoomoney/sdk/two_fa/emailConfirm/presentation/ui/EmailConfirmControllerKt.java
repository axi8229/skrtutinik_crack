package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui;

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
import kotlin.jvm.internal.FunctionReferenceImpl;
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
import ru.yoomoney.sdk.two_fa.emailConfirm.EmailConfirm;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmViewModelFactory;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: EmailConfirmController.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0001¢\u0006\u0002\u0010\u0010*0\b\u0000\u0010\u0011\"\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00122\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"EmailConfirmController", "", "config", "Lru/yoomoney/sdk/two_fa/Config;", "interactor", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmAnalyticsLogger;", "onShowHelp", "Lkotlin/Function1;", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "onBack", "Lkotlin/Function0;", "onSuccessConfirm", "(Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmAnalyticsLogger;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EmailConfirmViewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", "two-fa_release", "viewModelFactory", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmViewModelFactory;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirmControllerKt {
    public static final void EmailConfirmController(final Config config, final EmailConfirmInteractor interactor, final ResourceMapper resourceMapper, final EmailConfirmAnalyticsLogger emailConfirmAnalyticsLogger, final Function1<? super SessionType, Unit> onShowHelp, final Function0<Unit> onBack, final Function0<Unit> onSuccessConfirm, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(onShowHelp, "onShowHelp");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onSuccessConfirm, "onSuccessConfirm");
        Composer composerStartRestartGroup = composer.startRestartGroup(73212675);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(73212675, i, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmController (EmailConfirmController.kt:34)");
        }
        final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Lazy lazy = LazyKt.lazy(new Function0<EmailConfirmViewModelFactory>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$viewModelFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final EmailConfirmViewModelFactory invoke() {
                Context context2 = context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.EntryPointActivity");
                return new EmailConfirmViewModelFactory(config, interactor, emailConfirmAnalyticsLogger, (EntryPointActivity) context2, null, 16, null);
            }
        });
        composerStartRestartGroup.startReplaceableGroup(-276432130);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModel viewModel = new ViewModelProvider(current.getViewModelStore(), EmailConfirmController$lambda$0(lazy), null, 4, null).get("EmailConfirm", (Class<ViewModel>) RuntimeViewModel.class);
        composerStartRestartGroup.endReplaceableGroup();
        final RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
        composerStartRestartGroup.startReplaceableGroup(741020563);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        Channel channel = (Channel) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new AnonymousClass1(onSuccessConfirm, channel, resourceMapper, onShowHelp, null), composerStartRestartGroup, 72);
        EmailConfirmUiState emailConfirmUiState = (EmailConfirmUiState) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), EmailConfirmUiState.Init.INSTANCE, new Function1<EmailConfirm.State, EmailConfirmUiState>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt.EmailConfirmController.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final EmailConfirmUiState invoke(EmailConfirm.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ResourceMapper resourceMapper2 = resourceMapper;
                Context context2 = context;
                final RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel2 = runtimeViewModel;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt.EmailConfirmController.2.1
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
                        EmailConfirmControllerKt.EmailConfirmController$restartSession(runtimeViewModel2);
                    }
                };
                final Function0<Unit> function02 = onBack;
                return EmailConfirmUiStateMapperKt.mapToUiState(it, resourceMapper2, context2, function0, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt.EmailConfirmController.2.2
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
                        function02.invoke();
                    }
                });
            }
        }, composerStartRestartGroup, 56).getValue();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(runtimeViewModel);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(runtimeViewModel);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(runtimeViewModel);
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(runtimeViewModel);
        composerStartRestartGroup.startReplaceableGroup(741021965);
        boolean z = (((458752 & i) ^ 196608) > 131072 && composerStartRestartGroup.changedInstance(onBack)) || (i & 196608) == 131072;
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$7$1
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
        EmailConfirmScreenKt.EmailConfirmScreen(emailConfirmUiState, channel, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, (Function0) objRememberedValue2, composerStartRestartGroup, 64);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass8(runtimeViewModel, null), composerStartRestartGroup, 70);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt.EmailConfirmController.9
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
                    EmailConfirmControllerKt.EmailConfirmController(config, interactor, resourceMapper, emailConfirmAnalyticsLogger, onShowHelp, onBack, onSuccessConfirm, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final EmailConfirmViewModelFactory EmailConfirmController$lambda$0(Lazy<EmailConfirmViewModelFactory> lazy) {
        return lazy.getValue();
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "effect", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$1", f = "EmailConfirmController.kt", l = {55}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<EmailConfirm.Effect, Continuation<? super Unit>, Object> {
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
        public final Object invoke(EmailConfirm.Effect effect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EmailConfirm.Effect effect = (EmailConfirm.Effect) this.L$0;
                if (effect instanceof EmailConfirm.Effect.FinishWithSuccess) {
                    this.$onSuccessConfirm.invoke();
                } else if (effect instanceof EmailConfirm.Effect.ShowFailure) {
                    Channel<Notice> channel = this.$notices;
                    Notice noticeAlert$default = Notice.Companion.alert$default(Notice.INSTANCE, ResourceMapper.map$default(this.$resourceMapper, ((EmailConfirm.Effect.ShowFailure) effect).getFailure(), null, 2, null), null, null, 6, null);
                    this.label = 1;
                    if (channel.send(noticeAlert$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (effect instanceof EmailConfirm.Effect.NavigateToHelp) {
                    this.$onShowHelp.invoke(SessionType.EMAIL);
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
    public static final void EmailConfirmController$changeCode(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel, String str) {
        runtimeViewModel.handleAction(new EmailConfirm.Action.CodeChanged(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmailConfirmController$restartSession(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(EmailConfirm.Action.RestartSession.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmailConfirmController$confirmCode(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(EmailConfirm.Action.ConfirmCode.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmailConfirmController$showHelp(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(EmailConfirm.Action.ShowHelp.INSTANCE);
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, Unit> {
        final /* synthetic */ RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
            super(1, Intrinsics.Kotlin.class, "changeCode", "EmailConfirmController$changeCode(Lru/yoomoney/sdk/march/RuntimeViewModel;Ljava/lang/String;)V", 0);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            EmailConfirmControllerKt.EmailConfirmController$changeCode(this.$viewModel, p0);
        }
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
            super(0, Intrinsics.Kotlin.class, "restartSession", "EmailConfirmController$restartSession(Lru/yoomoney/sdk/march/RuntimeViewModel;)V", 0);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmailConfirmControllerKt.EmailConfirmController$restartSession(this.$viewModel);
        }
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
            super(0, Intrinsics.Kotlin.class, "confirmCode", "EmailConfirmController$confirmCode(Lru/yoomoney/sdk/march/RuntimeViewModel;)V", 0);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmailConfirmControllerKt.EmailConfirmController$confirmCode(this.$viewModel);
        }
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel) {
            super(0, Intrinsics.Kotlin.class, "showHelp", "EmailConfirmController$showHelp(Lru/yoomoney/sdk/march/RuntimeViewModel;)V", 0);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmailConfirmControllerKt.EmailConfirmController$showHelp(this.$viewModel);
        }
    }

    /* compiled from: EmailConfirmController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$8", f = "EmailConfirmController.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt$EmailConfirmController$8, reason: invalid class name */
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> runtimeViewModel, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.$viewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$viewModel.handleAction(new EmailConfirm.Action.SendAnalyticsForScreen(ProcessType.REGISTRATION));
            return Unit.INSTANCE;
        }
    }
}
