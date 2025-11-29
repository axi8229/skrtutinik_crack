package ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.ContextCompat;
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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.Routes;
import ru.yoomoney.sdk.two_fa.confirmationHelp.ConfirmationHelp;
import ru.yoomoney.sdk.two_fa.confirmationHelp.impl.ConfirmationHelpViewModelFactory;
import ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpUiState;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.utils.Base64UtilsKt;

/* compiled from: ConfirmationHelpController.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a+\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0001¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0000\u0010\u0011\"\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00122\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"BASE_HOST_ENCODED_BASE64", "", "baseHost", "getBaseHost", "()Ljava/lang/String;", "baseHost$delegate", "Lkotlin/Lazy;", "feedbackUrl", "ConfirmationHelpController", "", Routes.sessionTypeArg, "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "isActionVisible", "", "onBack", "Lkotlin/Function0;", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ConfirmationHelpViewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect;", "two-fa_release", "viewModelFactory", "Lru/yoomoney/sdk/two_fa/confirmationHelp/impl/ConfirmationHelpViewModelFactory;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelpControllerKt {
    private static final String BASE_HOST_ENCODED_BASE64 = "eW9vbW9uZXkucnU=";
    private static final Lazy baseHost$delegate = LazyKt.lazy(new Function0<String>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$baseHost$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return Base64UtilsKt.decodeBase64("eW9vbW9uZXkucnU=");
        }
    });
    private static final String feedbackUrl = "https://" + getBaseHost() + "/page?id=536016#feedback";

    private static final String getBaseHost() {
        return (String) baseHost$delegate.getValue();
    }

    public static final void ConfirmationHelpController(final SessionType sessionType, final boolean z, final Function0<Unit> onBack, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(249472406);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(sessionType) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBack) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(249472406, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpController (ConfirmationHelpController.kt:35)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composerStartRestartGroup.startReplaceableGroup(-725964926);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Channel channel = (Channel) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-725964828);
            boolean z2 = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function0<ConfirmationHelpViewModelFactory>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$ConfirmationHelpController$viewModelFactory$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final ConfirmationHelpViewModelFactory invoke() {
                        return new ConfirmationHelpViewModelFactory(sessionType, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Lazy lazy = LazyKt.lazy((Function0) objRememberedValue2);
            composerStartRestartGroup.startReplaceableGroup(-276432130);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
            }
            ViewModel viewModel = new ViewModelProvider(current.getViewModelStore(), ConfirmationHelpController$lambda$2(lazy), null, 4, null).get("ConfirmationHelp", (Class<ViewModel>) RuntimeViewModel.class);
            composerStartRestartGroup.endReplaceableGroup();
            RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
            ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new AnonymousClass1(context, channel, null), composerStartRestartGroup, 72);
            ConfirmationHelpUiState confirmationHelpUiState = (ConfirmationHelpUiState) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), ConfirmationHelpUiState.Init.INSTANCE, new Function1<ConfirmationHelp.State, ConfirmationHelpUiState>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt.ConfirmationHelpController.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ConfirmationHelpUiState invoke(ConfirmationHelp.State it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ConfirmationHelpUiStateMapperKt.mapToUiState(it, context);
                }
            }, composerStartRestartGroup, 56).getValue();
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(runtimeViewModel);
            composerStartRestartGroup.startReplaceableGroup(-725963703);
            boolean z3 = (i2 & 896) == 256;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$ConfirmationHelpController$4$1
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
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ConfirmationHelpScreenKt.ConfirmationHelpScreen(confirmationHelpUiState, anonymousClass3, (Function0) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt.ConfirmationHelpController.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ConfirmationHelpControllerKt.ConfirmationHelpController(sessionType, z, onBack, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final ConfirmationHelpViewModelFactory ConfirmationHelpController$lambda$2(Lazy<ConfirmationHelpViewModelFactory> lazy) {
        return lazy.getValue();
    }

    /* compiled from: ConfirmationHelpController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "effect", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$ConfirmationHelpController$1", f = "ConfirmationHelpController.kt", l = {56}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$ConfirmationHelpController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ConfirmationHelp.Effect, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Channel<Notice> $notices;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Channel<Notice> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$notices = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$notices, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ConfirmationHelp.Effect effect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (((ConfirmationHelp.Effect) this.L$0) instanceof ConfirmationHelp.Effect.OpenBrowser) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(ConfirmationHelpControllerKt.feedbackUrl));
                        ContextCompat.startActivity(this.$context, intent, null);
                    } catch (ActivityNotFoundException unused) {
                        Channel<Notice> channel = this.$notices;
                        Notice.Companion companion = Notice.INSTANCE;
                        String string = this.$context.getString(R.string.two_fa_error_no_browser);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        Notice noticeAlert$default = Notice.Companion.alert$default(companion, string, null, null, 6, null);
                        this.label = 1;
                        if (channel.send(noticeAlert$default, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
    public static final void ConfirmationHelpController$onHelpClick(RuntimeViewModel<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> runtimeViewModel) {
        runtimeViewModel.handleAction(ConfirmationHelp.Action.ShowSupport.INSTANCE);
    }

    /* compiled from: ConfirmationHelpController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt$ConfirmationHelpController$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ RuntimeViewModel<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RuntimeViewModel<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> runtimeViewModel) {
            super(0, Intrinsics.Kotlin.class, "onHelpClick", "ConfirmationHelpController$onHelpClick(Lru/yoomoney/sdk/march/RuntimeViewModel;)V", 0);
            this.$viewModel = runtimeViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ConfirmationHelpControllerKt.ConfirmationHelpController$onHelpClick(this.$viewModel);
        }
    }
}
