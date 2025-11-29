package ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;
import ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointUiState;
import ru.yoomoney.sdk.two_fa.utils.DefaultStateKt;

/* compiled from: EntryPointScreen.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"EntryPointScreen", "", "state", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;", "notices", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "onBack", "Lkotlin/Function0;", "(Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointScreenKt {
    public static final void EntryPointScreen(final EntryPointUiState state, final ReceiveChannel<Notice> notices, final Function0<Unit> onBack, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(notices, "notices");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(1099826895);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1099826895, i, -1, "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreen (EntryPointScreen.kt:26)");
        }
        composerStartRestartGroup.startReplaceableGroup(865774410);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SnackbarHostState();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        final NoticeService noticeServiceRememberNoticeService = NoticeCommonKt.rememberNoticeService(snackbarHostState, composerStartRestartGroup, 6);
        ObservingExtensionsKt.observe(notices, new AnonymousClass1(noticeServiceRememberNoticeService, null), composerStartRestartGroup, 72);
        ScaffoldKt.m658Scaffold27mzLpw(null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -140909996, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt.EntryPointScreen.2
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
                        ComposerKt.traceEventStart(-140909996, i2, -1, "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreen.<anonymous> (EntryPointScreen.kt:36)");
                    }
                    TopBarKt.m3459TopBarDefaultwqdebIU((Modifier) null, (Painter) null, (String) null, onBack, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, false, composer2, 0, 503);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 983370824, true, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt.EntryPointScreen.3
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
                        ComposerKt.traceEventStart(983370824, i2, -1, "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreen.<anonymous> (EntryPointScreen.kt:41)");
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
        }), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTintBg(), 0L, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 437594125, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt.EntryPointScreen.4
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues it, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(it, "it");
                if ((i2 & 14) == 0) {
                    i2 |= composer2.changed(it) ? 4 : 2;
                }
                if ((i2 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(437594125, i2, -1, "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreen.<anonymous> (EntryPointScreen.kt:48)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), it);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    EntryPointUiState entryPointUiState = state;
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
                    if (entryPointUiState instanceof EntryPointUiState.Init) {
                        composer2.startReplaceableGroup(1093646602);
                        DefaultStateKt.InitState(composer2, 0);
                        composer2.endReplaceableGroup();
                    } else if (entryPointUiState instanceof EntryPointUiState.InitialError) {
                        composer2.startReplaceableGroup(1093646667);
                        EntryPointUiState.InitialError initialError = (EntryPointUiState.InitialError) entryPointUiState;
                        DefaultStateKt.InitialErrorState(initialError.getFailureDescription(), initialError.getActionText(), initialError.getFailureTitle(), initialError.getOnAction(), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1093646914);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt.EntryPointScreen.5
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
                    EntryPointScreenKt.EntryPointScreen(state, notices, onBack, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* compiled from: EntryPointScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "notice", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt$EntryPointScreen$1", f = "EntryPointScreen.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointScreenKt$EntryPointScreen$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Notice, Continuation<? super Unit>, Object> {
        final /* synthetic */ NoticeService $noticeService;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NoticeService noticeService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$noticeService = noticeService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$noticeService, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Notice notice, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(notice, continuation)).invokeSuspend(Unit.INSTANCE);
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
}
