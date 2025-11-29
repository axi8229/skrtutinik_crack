package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui;

import android.content.res.Resources;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.google.android.gms.common.Scopes;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;
import ru.yoomoney.sdk.guiCompose.views.form.TextInputViewKt;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmUiState;
import ru.yoomoney.sdk.two_fa.utils.DefaultStateKt;
import ru.yoomoney.sdk.two_fa.utils.ResendTimerButtonKt;
import ru.yoomoney.sdk.two_fa.utils.TopBarHelpItemKt;

/* compiled from: EmailConfirmScreen.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001aE\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0013\u001ao\u0010\u0014\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u001b\u001a;\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010 \u001a\r\u0010!\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\"\u001a1\u0010#\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"ConfirmButton", "", "isEnabled", "", "isProgress", "onClick", "Lkotlin/Function0;", "(ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ContentState", "state", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Content;", "onCodeChanged", "Lkotlin/Function1;", "", "onCodeResend", "onConfirm", "(Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Content;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DescriptionText", Scopes.EMAIL, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "EmailConfirmScreen", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "notices", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "onHelp", "onBack", "(Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InputView", "currentCode", "error", "onTextChange", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TitleText", "(Landroidx/compose/runtime/Composer;I)V", "TopBar", "onNavigationClick", "onItemClick", "(Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "two-fa_release", "code"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirmScreenKt {
    public static final void EmailConfirmScreen(final EmailConfirmUiState state, final ReceiveChannel<Notice> notices, final Function1<? super String, Unit> onCodeChanged, final Function0<Unit> onCodeResend, final Function0<Unit> onConfirm, final Function0<Unit> onHelp, final Function0<Unit> onBack, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(notices, "notices");
        Intrinsics.checkNotNullParameter(onCodeChanged, "onCodeChanged");
        Intrinsics.checkNotNullParameter(onCodeResend, "onCodeResend");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onHelp, "onHelp");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1429911372);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1429911372, i, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreen (EmailConfirmScreen.kt:55)");
        }
        composerStartRestartGroup.startReplaceableGroup(878018552);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SnackbarHostState();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        final NoticeService noticeServiceRememberNoticeService = NoticeCommonKt.rememberNoticeService(snackbarHostState, composerStartRestartGroup, 6);
        ObservingExtensionsKt.observe(notices, new C25931(noticeServiceRememberNoticeService, null), composerStartRestartGroup, 72);
        ScaffoldKt.m658Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2014062137, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.EmailConfirmScreen.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2014062137, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreen.<anonymous> (EmailConfirmScreen.kt:64)");
                    }
                    EmailConfirmScreenKt.TopBar(state, onBack, onHelp, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 568334381, true, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.EmailConfirmScreen.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SnackbarHostState snackbarHostState2, Composer composer2, Integer num) {
                invoke(snackbarHostState2, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SnackbarHostState it, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(it, "it");
                if ((i2 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(568334381, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreen.<anonymous> (EmailConfirmScreen.kt:71)");
                    }
                    NoticeCommonKt.NoticeHost(snackbarHostState, noticeServiceRememberNoticeService, null, composer2, (NoticeService.$stable << 3) | 6, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTintBg(), 0L, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1501148658, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.EmailConfirmScreen.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) throws Resources.NotFoundException {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues it, Composer composer2, int i2) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                if ((i2 & 14) == 0) {
                    i2 |= composer2.changed(it) ? 4 : 2;
                }
                if ((i2 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1501148658, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreen.<anonymous> (EmailConfirmScreen.kt:78)");
                }
                Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), it);
                Alignment center = Alignment.INSTANCE.getCenter();
                EmailConfirmUiState emailConfirmUiState = state;
                Function1<String, Unit> function1 = onCodeChanged;
                Function0<Unit> function0 = onCodeResend;
                Function0<Unit> function02 = onConfirm;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierPadding);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM727constructorimpl = Updater.m727constructorimpl(composer2);
                Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (emailConfirmUiState instanceof EmailConfirmUiState.Init) {
                    composer2.startReplaceableGroup(1718046174);
                    DefaultStateKt.InitState(composer2, 0);
                    composer2.endReplaceableGroup();
                } else if (emailConfirmUiState instanceof EmailConfirmUiState.Content) {
                    composer2.startReplaceableGroup(1718046276);
                    EmailConfirmScreenKt.ContentState((EmailConfirmUiState.Content) emailConfirmUiState, function1, function0, function02, composer2, 8);
                    composer2.endReplaceableGroup();
                } else if (emailConfirmUiState instanceof EmailConfirmUiState.InitialError) {
                    composer2.startReplaceableGroup(1718046601);
                    EmailConfirmUiState.InitialError initialError = (EmailConfirmUiState.InitialError) emailConfirmUiState;
                    DefaultStateKt.InitialErrorState(initialError.getSubtitleText(), initialError.getActionText(), initialError.getTitleText(), initialError.getOnAction(), composer2, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1718046899);
                    composer2.endReplaceableGroup();
                }
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 24960, 12582912, 98283);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.EmailConfirmScreen.5
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
                    EmailConfirmScreenKt.EmailConfirmScreen(state, notices, onCodeChanged, onCodeResend, onConfirm, onHelp, onBack, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* compiled from: EmailConfirmScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "notice", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt$EmailConfirmScreen$1", f = "EmailConfirmScreen.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt$EmailConfirmScreen$1, reason: invalid class name and case insensitive filesystem */
    static final class C25931 extends SuspendLambda implements Function2<Notice, Continuation<? super Unit>, Object> {
        final /* synthetic */ NoticeService $noticeService;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C25931(NoticeService noticeService, Continuation<? super C25931> continuation) {
            super(2, continuation);
            this.$noticeService = noticeService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C25931 c25931 = new C25931(this.$noticeService, continuation);
            c25931.L$0 = obj;
            return c25931;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Notice notice, Continuation<? super Unit> continuation) {
            return ((C25931) create(notice, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Notice) this.L$0).show(this.$noticeService);
            return Unit.INSTANCE;
        }
    }

    private static final String InputView$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopBar(final EmailConfirmUiState emailConfirmUiState, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-439893361);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(emailConfirmUiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-439893361, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.TopBar (EmailConfirmScreen.kt:113)");
            }
            composer2 = composerStartRestartGroup;
            TopBarKt.m3460TopBarDefaultwqdebIU("", (Modifier) null, (Painter) null, (String) null, function0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1884823236, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.TopBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TopBarDefault, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(TopBarDefault, "$this$TopBarDefault");
                    if ((i3 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1884823236, i3, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.TopBar.<anonymous> (EmailConfirmScreen.kt:118)");
                    }
                    if (emailConfirmUiState instanceof EmailConfirmUiState.Content) {
                        TopBarHelpItemKt.TopBarHelpItem(function02, !((EmailConfirmUiState.Content) r3).isEnabledProgressIndicator(), composer3, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 0L, 0L, false, composerStartRestartGroup, ((i2 << 9) & 57344) | 196614, 462);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.TopBar.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    EmailConfirmScreenKt.TopBar(emailConfirmUiState, function0, function02, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TitleText(Composer composer, final int i) throws Resources.NotFoundException {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1784407637);
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1784407637, i, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.TitleText (EmailConfirmScreen.kt:124)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i2 = YooTheme.$stable;
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m311paddingVpY3zN4$default(modifierFillMaxWidth$default, yooTheme.getDimens(composerStartRestartGroup, i2).getSpaceM(), 0.0f, 2, null), EmailConfirmTestTags.titleText);
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(StringResources_androidKt.stringResource(R.string.two_fa_email_confirm_title, composerStartRestartGroup, 0), modifierTestTag, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i2).getTitle1(), composer2, 0, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.TitleText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) throws Resources.NotFoundException {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) throws Resources.NotFoundException {
                    EmailConfirmScreenKt.TitleText(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DescriptionText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1364518024);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364518024, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.DescriptionText (EmailConfirmScreen.kt:138)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(StringResources_androidKt.stringResource(R.string.two_fa_sms_confirm_description, new Object[]{str}, composerStartRestartGroup, 64), TestTagKt.testTag(PaddingKt.m311paddingVpY3zN4$default(PaddingKt.m313paddingqDBjuR0$default(modifierFillMaxWidth$default, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceXL(), 0.0f, 0.0f, 13, null), yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceM(), 0.0f, 2, null), EmailConfirmTestTags.descriptionText), yooTheme.getColors(composerStartRestartGroup, i3).getType().getSecondary(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBody(), composer2, 0, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.DescriptionText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    EmailConfirmScreenKt.DescriptionText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InputView(final String str, final String str2, final boolean z, final Function1<? super String, Unit> function1, Composer composer, final int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(417231048);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(417231048, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.InputView (EmailConfirmScreen.kt:157)");
            }
            composerStartRestartGroup.startReplaceableGroup(-1450884314);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m311paddingVpY3zN4$default(PaddingKt.m313paddingqDBjuR0$default(companion2, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceXL(), 0.0f, 0.0f, 13, null), yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceM(), 0.0f, 2, null), EmailConfirmTestTags.emailCodeInput);
            String strInputView$lambda$2 = InputView$lambda$2(mutableState);
            String strStringResource = StringResources_androidKt.stringResource(R.string.two_fa_email_confirm_input_label, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1450883915);
            boolean z2 = (i2 & 7168) == 2048;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt$InputView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                        invoke2(str3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        mutableState.setValue(it);
                        function1.invoke(it);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextInputViewKt.TextInputView(strInputView$lambda$2, (Function1) objRememberedValue2, modifierTestTag, null, strStringResource, str2, null, null, z, false, null, null, null, null, true, 0, composerStartRestartGroup, ((i2 << 12) & 458752) | ((i2 << 18) & 234881024), 24576, 48840);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.InputView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) throws Resources.NotFoundException {
                    EmailConfirmScreenKt.InputView(str, str2, z, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ConfirmButton(final boolean z, final boolean z2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(180076102);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(180076102, i2, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.ConfirmButton (EmailConfirmScreen.kt:181)");
            }
            ButtonsKt.PrimaryButtonView(StringResources_androidKt.stringResource(R.string.two_fa_email_confirm_confirm_text, composerStartRestartGroup, 0), TestTagKt.testTag(PaddingKt.m309padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), YooTheme.INSTANCE.getDimens(composerStartRestartGroup, YooTheme.$stable).getSpaceM()), EmailConfirmTestTags.nextButton), z2, z, function0, composerStartRestartGroup, ((i2 << 3) & 896) | ((i2 << 9) & 7168) | ((i2 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.ConfirmButton.1
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
                    EmailConfirmScreenKt.ConfirmButton(z, z2, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ContentState(final EmailConfirmUiState.Content content, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) throws Resources.NotFoundException {
        Composer composerStartRestartGroup = composer.startRestartGroup(923729078);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923729078, i, -1, "ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.ContentState (EmailConfirmScreen.kt:200)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean z = true;
        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, companion2.getStart(), composerStartRestartGroup, 6);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierVerticalScroll$default);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM727constructorimpl = Updater.m727constructorimpl(composerStartRestartGroup);
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor2);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM727constructorimpl2 = Updater.m727constructorimpl(composerStartRestartGroup);
        Updater.m728setimpl(composerM727constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        TitleText(composerStartRestartGroup, 0);
        DescriptionText(content.getEmail(), composerStartRestartGroup, 0);
        InputView(content.getConfirmCode(), content.getFailure(), !content.isEnabledProgressIndicator(), function1, composerStartRestartGroup, (i << 6) & 7168);
        ResendTimerButtonKt.ResendTimerButton(PaddingKt.m311paddingVpY3zN4$default(companion, YooTheme.INSTANCE.getDimens(composerStartRestartGroup, YooTheme.$stable).getSpaceXS(), 0.0f, 2, null), R.string.two_fa_email_confirm_retry_action_text, R.string.two_fa_email_confirm_retry_timer_text, content.getNextAvailableFrom(), !content.isEnabledProgressIndicator(), function0, composerStartRestartGroup, ((i << 9) & 458752) | 4096);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        boolean zIsConfirmEnabled = content.isConfirmEnabled();
        boolean zIsEnabledProgressIndicator = content.isEnabledProgressIndicator();
        composerStartRestartGroup.startReplaceableGroup(1321196742);
        if ((((i & 7168) ^ 3072) <= 2048 || !composerStartRestartGroup.changedInstance(function02)) && (i & 3072) != 2048) {
            z = false;
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt$ContentState$1$2$1
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
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        ConfirmButton(zIsConfirmEnabled, zIsEnabledProgressIndicator, (Function0) objRememberedValue, composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmScreenKt.ContentState.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) throws Resources.NotFoundException {
                    EmailConfirmScreenKt.ContentState(content, function1, function0, function02, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
