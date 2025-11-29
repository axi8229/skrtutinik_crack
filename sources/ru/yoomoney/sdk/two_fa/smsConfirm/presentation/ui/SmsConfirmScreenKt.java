package ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui;

import android.content.res.Resources;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
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
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.form.ConfirmCodeInputViewKt;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmUiState;
import ru.yoomoney.sdk.two_fa.utils.DefaultStateKt;
import ru.yoomoney.sdk.two_fa.utils.ResendTimerButtonKt;
import ru.yoomoney.sdk.two_fa.utils.TopBarHelpItemKt;

/* compiled from: SmsConfirmScreen.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a?\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0015\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CodeErrorText", "", YooMoneyAuth.KEY_FAILURE, "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ContentState", "listState", "Landroidx/compose/foundation/ScrollState;", "state", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Content;", "onValueChange", "Lkotlin/Function1;", "onReload", "Lkotlin/Function0;", "(Landroidx/compose/foundation/ScrollState;Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Content;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DescriptionText", "text", "ProgressIndicator", "isEnabledProgressIndicator", "", "(ZLandroidx/compose/runtime/Composer;I)V", "SmsConfirmScreen", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "notices", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "onBack", "onHelpClick", "(Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TitleText", "two-fa_release", "isElevated"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsConfirmScreenKt {
    public static final void SmsConfirmScreen(final SmsConfirmUiState state, final ReceiveChannel<Notice> notices, final Function0<Unit> onBack, final Function0<Unit> onReload, final Function1<? super String, Unit> onValueChange, final Function0<Unit> onHelpClick, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(notices, "notices");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(onHelpClick, "onHelpClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-731003518);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-731003518, i, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreen (SmsConfirmScreen.kt:57)");
        }
        composerStartRestartGroup.startReplaceableGroup(1682624094);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new SnackbarHostState();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        final NoticeService noticeServiceRememberNoticeService = NoticeCommonKt.rememberNoticeService(snackbarHostState, composerStartRestartGroup, 6);
        final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
        composerStartRestartGroup.startReplaceableGroup(1682624261);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt$SmsConfirmScreen$isElevated$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(scrollStateRememberScrollState.getValue() > 0);
                }
            });
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        final State state2 = (State) objRememberedValue2;
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(notices, new C26321(noticeServiceRememberNoticeService, null), composerStartRestartGroup, 72);
        ScaffoldKt.m658Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1518835129, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.SmsConfirmScreen.2
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
                        ComposerKt.traceEventStart(-1518835129, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreen.<anonymous> (SmsConfirmScreen.kt:70)");
                    }
                    boolean zSmsConfirmScreen$lambda$2 = SmsConfirmScreenKt.SmsConfirmScreen$lambda$2(state2);
                    Function0<Unit> function0 = onBack;
                    final SmsConfirmUiState smsConfirmUiState = state;
                    final Function0<Unit> function02 = onHelpClick;
                    TopBarKt.m3459TopBarDefaultwqdebIU((Modifier) null, (Painter) null, (String) null, function0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(composer2, 2043053746, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.SmsConfirmScreen.2.1
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
                            if ((i3 & 81) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2043053746, i3, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreen.<anonymous>.<anonymous> (SmsConfirmScreen.kt:74)");
                                }
                                if (smsConfirmUiState instanceof SmsConfirmUiState.Content) {
                                    TopBarHelpItemKt.TopBarHelpItem(function02, !((SmsConfirmUiState.Content) r3).isEnabledProgressIndicator(), composer3, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), 0L, 0L, zSmsConfirmScreen$lambda$2, composer2, 196608, 215);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 925675835, true, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.SmsConfirmScreen.3
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
                        ComposerKt.traceEventStart(925675835, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreen.<anonymous> (SmsConfirmScreen.kt:82)");
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
        }), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTintBg(), 0L, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1491445312, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.SmsConfirmScreen.4
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
                if ((i2 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1491445312, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreen.<anonymous> (SmsConfirmScreen.kt:89)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), it);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    SmsConfirmUiState smsConfirmUiState = state;
                    ScrollState scrollState = scrollStateRememberScrollState;
                    Function1<String, Unit> function1 = onValueChange;
                    Function0<Unit> function0 = onReload;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                    Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (smsConfirmUiState instanceof SmsConfirmUiState.Init) {
                        composer2.startReplaceableGroup(2026438059);
                        DefaultStateKt.InitState(composer2, 0);
                        composer2.endReplaceableGroup();
                    } else if (smsConfirmUiState instanceof SmsConfirmUiState.InitialError) {
                        composer2.startReplaceableGroup(2026438124);
                        SmsConfirmUiState.InitialError initialError = (SmsConfirmUiState.InitialError) smsConfirmUiState;
                        DefaultStateKt.InitialErrorState(initialError.getFailureDescription(), initialError.getActionText(), initialError.getFailureTitle(), initialError.getOnAction(), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else if (smsConfirmUiState instanceof SmsConfirmUiState.Content) {
                        composer2.startReplaceableGroup(2026438406);
                        SmsConfirmScreenKt.ContentState(scrollState, (SmsConfirmUiState.Content) smsConfirmUiState, function1, function0, composer2, 64);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(2026438620);
                        composer2.endReplaceableGroup();
                    }
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), composerStartRestartGroup, 24960, 12582912, 98283);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.SmsConfirmScreen.5
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
                    SmsConfirmScreenKt.SmsConfirmScreen(state, notices, onBack, onReload, onValueChange, onHelpClick, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* compiled from: SmsConfirmScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "notice", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt$SmsConfirmScreen$1", f = "SmsConfirmScreen.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt$SmsConfirmScreen$1, reason: invalid class name and case insensitive filesystem */
    static final class C26321 extends SuspendLambda implements Function2<Notice, Continuation<? super Unit>, Object> {
        final /* synthetic */ NoticeService $noticeService;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26321(NoticeService noticeService, Continuation<? super C26321> continuation) {
            super(2, continuation);
            this.$noticeService = noticeService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C26321 c26321 = new C26321(this.$noticeService, continuation);
            c26321.L$0 = obj;
            return c26321;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Notice notice, Continuation<? super Unit> continuation) {
            return ((C26321) create(notice, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SmsConfirmScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ContentState(final ScrollState scrollState, final SmsConfirmUiState.Content content, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Composer composer, final int i) throws Resources.NotFoundException {
        Composer composerStartRestartGroup = composer.startRestartGroup(-305619940);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-305619940, i, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.ContentState (SmsConfirmScreen.kt:120)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), scrollState, false, null, false, 14, null);
        YooTheme yooTheme = YooTheme.INSTANCE;
        int i2 = YooTheme.$stable;
        Modifier modifierM311paddingVpY3zN4$default = PaddingKt.m311paddingVpY3zN4$default(modifierVerticalScroll$default, yooTheme.getDimens(composerStartRestartGroup, i2).getSpaceM(), 0.0f, 2, null);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM311paddingVpY3zN4$default);
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
        TitleText(StringResources_androidKt.stringResource(R.string.two_fa_sms_confirm_title, composerStartRestartGroup, 0), composerStartRestartGroup, 0);
        String confirmCode = content.getConfirmCode();
        int codeLength = content.getCodeLength();
        boolean z = !content.isEnabledProgressIndicator();
        Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m313paddingqDBjuR0$default(companion, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i2).getSpace3XL(), 0.0f, 0.0f, 13, null), SmsConfirmTestTags.smsCodeInput);
        composerStartRestartGroup.startReplaceableGroup(-1496540504);
        boolean z2 = (((i & 896) ^ 384) > 256 && composerStartRestartGroup.changedInstance(function1)) || (i & 384) == 256;
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt$ContentState$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    function1.invoke(it);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        ConfirmCodeInputViewKt.ConfirmCodeInputView(confirmCode, modifierTestTag, codeLength, z, (Function1) objRememberedValue, composerStartRestartGroup, 0, 0);
        DescriptionText(StringResources_androidKt.stringResource(R.string.two_fa_sms_confirm_description, new Object[]{content.getPhone()}, composerStartRestartGroup, 64), composerStartRestartGroup, 0);
        CodeErrorText(content.getFailure(), composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ResendTimerButtonKt.ResendTimerButton(TestTagKt.testTag(PaddingKt.m313paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i2).getSpaceM(), 7, null), SmsConfirmTestTags.resendSmsButton), R.string.two_fa_sms_confirm_retry_action_text, R.string.two_fa_sms_confirm_retry_timer_text, content.getNextAvailableFrom(), !content.isEnabledProgressIndicator(), function0, composerStartRestartGroup, ((i << 6) & 458752) | 4096);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ProgressIndicator(content.isEnabledProgressIndicator(), composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.ContentState.2
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

                public final void invoke(Composer composer2, int i3) throws Resources.NotFoundException {
                    SmsConfirmScreenKt.ContentState(scrollState, content, function1, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TitleText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(763955222);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(763955222, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.TitleText (SmsConfirmScreen.kt:158)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), SmsConfirmTestTags.titleText);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, modifierTestTag, yooTheme.getColors(composerStartRestartGroup, i3).getType().getPrimary(), 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getTitle1(), composer2, (i2 & 14) | 48, 0, 65016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.TitleText.1
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
                    SmsConfirmScreenKt.TitleText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DescriptionText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-187787406);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-187787406, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.DescriptionText (SmsConfirmScreen.kt:171)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, TestTagKt.testTag(PaddingKt.m313paddingqDBjuR0$default(modifierFillMaxWidth$default, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpace2XL(), 0.0f, 0.0f, 13, null), SmsConfirmTestTags.descriptionText), yooTheme.getColors(composerStartRestartGroup, i3).getType().getSecondary(), 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8(), false, 2, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBody(), composer2, i2 & 14, 3120, 54776);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.DescriptionText.1
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
                    SmsConfirmScreenKt.DescriptionText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CodeErrorText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-880450829);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880450829, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.CodeErrorText (SmsConfirmScreen.kt:187)");
            }
            if (str == null) {
                composer2 = composerStartRestartGroup;
            } else {
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                YooTheme yooTheme = YooTheme.INSTANCE;
                int i3 = YooTheme.$stable;
                composer2 = composerStartRestartGroup;
                TextKt.m685Text4IGK_g(str, TestTagKt.testTag(PaddingKt.m313paddingqDBjuR0$default(modifierFillMaxWidth$default, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceXL(), 0.0f, 0.0f, 13, null), SmsConfirmTestTags.codeErrorText), yooTheme.getColors(composerStartRestartGroup, i3).getType().getAlert(), 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8(), false, 2, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBody(), composer2, i2 & 14, 3120, 54776);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.CodeErrorText.2
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
                    SmsConfirmScreenKt.CodeErrorText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProgressIndicator(final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1907597736);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907597736, i2, -1, "ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.ProgressIndicator (SmsConfirmScreen.kt:205)");
            }
            if (z) {
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierFillMaxSize$default);
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
                Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ProgressIndicatorKt.m651CircularProgressIndicatorLxG7B9w(companion, YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTint(), 0.0f, 0L, 0, composerStartRestartGroup, 6, 28);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmScreenKt.ProgressIndicator.2
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
                    SmsConfirmScreenKt.ProgressIndicator(z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
