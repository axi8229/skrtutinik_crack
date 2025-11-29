package ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpUiState;

/* compiled from: ConfirmationHelpScreen.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0007\u001a#\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e\u001a#\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"ConfirmationHelpScreen", "", "state", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;", "onHelpClick", "Lkotlin/Function0;", "onBack", "(Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ContentState", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Content;", "(Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState$Content;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DescriptionText", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "HelpButton", "isVisible", "", "onClick", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TitleText", "two-fa_release", "isElevated"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelpScreenKt {
    public static final void ConfirmationHelpScreen(final ConfirmationHelpUiState state, final Function0<Unit> onHelpClick, final Function0<Unit> onBack, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onHelpClick, "onHelpClick");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-818110659);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onHelpClick) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBack) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818110659, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreen (ConfirmationHelpScreen.kt:39)");
            }
            composerStartRestartGroup.startReplaceableGroup(26604249);
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
            composerStartRestartGroup.startReplaceableGroup(26604415);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt$ConfirmationHelpScreen$isElevated$2$1
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
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m658Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1489585048, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.ConfirmationHelpScreen.1
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
                    if ((i3 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1489585048, i3, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreen.<anonymous> (ConfirmationHelpScreen.kt:47)");
                        }
                        TopBarKt.m3459TopBarDefaultwqdebIU((Modifier) null, PainterResources_androidKt.painterResource(R.drawable.ic_close_m, composer3, 0), (String) null, onBack, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, ConfirmationHelpScreenKt.ConfirmationHelpScreen$lambda$2(state2), composer3, 64, 245);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1786498340, true, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.ConfirmationHelpScreen.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SnackbarHostState snackbarHostState2, Composer composer3, Integer num) {
                    invoke(snackbarHostState2, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SnackbarHostState it, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i3 & 81) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1786498340, i3, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreen.<anonymous> (ConfirmationHelpScreen.kt:54)");
                        }
                        NoticeCommonKt.NoticeHost(snackbarHostState, noticeServiceRememberNoticeService, null, composer3, (NoticeService.$stable << 3) | 6, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTintBg(), 0L, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -114702017, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.ConfirmationHelpScreen.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                    invoke(paddingValues, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                    if ((i3 & 14) == 0) {
                        i3 |= composer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((i3 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114702017, i3, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreen.<anonymous> (ConfirmationHelpScreen.kt:61)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        ConfirmationHelpUiState confirmationHelpUiState = state;
                        Function0<Unit> function0 = onHelpClick;
                        composer3.startReplaceableGroup(-483455358);
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierPadding);
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM727constructorimpl = Updater.m727constructorimpl(composer3);
                        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(643682442);
                        if (confirmationHelpUiState instanceof ConfirmationHelpUiState.Content) {
                            ConfirmationHelpScreenKt.ContentState((ConfirmationHelpUiState.Content) confirmationHelpUiState, function0, composer3, 0);
                        }
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 24960, 12582912, 98283);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.ConfirmationHelpScreen.4
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
                    ConfirmationHelpScreenKt.ConfirmationHelpScreen(state, onHelpClick, onBack, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ConfirmationHelpScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ContentState(final ConfirmationHelpUiState.Content content, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(267859065);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267859065, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ContentState (ConfirmationHelpScreen.kt:82)");
            }
            Modifier modifierM311paddingVpY3zN4$default = PaddingKt.m311paddingVpY3zN4$default(Modifier.INSTANCE, YooTheme.INSTANCE.getDimens(composerStartRestartGroup, YooTheme.$stable).getSpaceM(), 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TitleText(content.getTitle(), composerStartRestartGroup, 0);
            DescriptionText(content.getDescription(), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            HelpButton(content.isActionVisible(), function0, composerStartRestartGroup, i2 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.ContentState.2
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
                    ConfirmationHelpScreenKt.ContentState(content, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TitleText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1844135928);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844135928, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.TitleText (ConfirmationHelpScreen.kt:94)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), HelpScreenTestTags.titleText);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, modifierTestTag, yooTheme.getColors(composerStartRestartGroup, i3).getType().getPrimary(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getTitle1(), composer2, (i2 & 14) | 48, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.TitleText.1
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
                    ConfirmationHelpScreenKt.TitleText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DescriptionText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1567141204);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1567141204, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.DescriptionText (ConfirmationHelpScreen.kt:106)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, TestTagKt.testTag(PaddingKt.m311paddingVpY3zN4$default(modifierFillMaxWidth$default, 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceM(), 1, null), HelpScreenTestTags.descriptionText), yooTheme.getColors(composerStartRestartGroup, i3).getType().getSecondary(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBody(), composer2, i2 & 14, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.DescriptionText.1
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
                    ConfirmationHelpScreenKt.DescriptionText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HelpButton(final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(655444579);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(655444579, i2, -1, "ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.HelpButton (ConfirmationHelpScreen.kt:122)");
            }
            if (z) {
                ButtonsKt.PrimaryButtonView(StringResources_androidKt.stringResource(R.string.two_fa_confirmation_help_action, composerStartRestartGroup, 0), TestTagKt.testTag(PaddingKt.m309padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), YooTheme.INSTANCE.getDimens(composerStartRestartGroup, YooTheme.$stable).getSpaceM()), HelpScreenTestTags.supportButton), false, true, function0, composerStartRestartGroup, ((i2 << 9) & 57344) | 3456, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpScreenKt.HelpButton.1
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
                    ConfirmationHelpScreenKt.HelpButton(z, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
