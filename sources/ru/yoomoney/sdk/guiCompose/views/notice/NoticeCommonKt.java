package ru.yoomoney.sdk.guiCompose.views.notice;

import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarHostKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;

/* compiled from: NoticeCommon.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"NoticeHost", "", "hostState", "Landroidx/compose/material/SnackbarHostState;", "noticeService", "Lru/yoomoney/sdk/guiCompose/views/notice/NoticeService;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material/SnackbarHostState;Lru/yoomoney/sdk/guiCompose/views/notice/NoticeService;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "rememberNoticeService", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;I)Lru/yoomoney/sdk/guiCompose/views/notice/NoticeService;", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoticeCommonKt {
    public static final NoticeService rememberNoticeService(SnackbarHostState hostState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(hostState, "hostState");
        composer.startReplaceableGroup(-1070658735);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1070658735, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.rememberNoticeService (NoticeCommon.kt:17)");
        }
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(1819294608);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new NoticeService(hostState, coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        NoticeService noticeService = (NoticeService) objRememberedValue2;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return noticeService;
    }

    public static final void NoticeHost(final SnackbarHostState hostState, final NoticeService noticeService, Modifier modifier, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(hostState, "hostState");
        Intrinsics.checkNotNullParameter(noticeService, "noticeService");
        Composer composerStartRestartGroup = composer.startRestartGroup(-559682658);
        if ((i2 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-559682658, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.NoticeHost (NoticeCommon.kt:32)");
        }
        SnackbarHostKt.SnackbarHost(hostState, modifier, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1231018155, true, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt.NoticeHost.1

            /* compiled from: NoticeCommon.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt$NoticeHost$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Notice.Type.values().length];
                    try {
                        iArr[Notice.Type.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Notice.Type.ALERT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Notice.Type.NORMAL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer2, Integer num) {
                invoke(snackbarData, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SnackbarData data, Composer composer2, int i3) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1231018155, i3, -1, "ru.yoomoney.sdk.guiCompose.views.notice.NoticeHost.<anonymous> (NoticeCommon.kt:36)");
                }
                int i4 = WhenMappings.$EnumSwitchMapping$0[noticeService.getNoticeType$guiCompose_release().getValue().ordinal()];
                if (i4 == 1) {
                    composer2.startReplaceableGroup(-366773751);
                    NoticeKt.NoticeSuccessView(data, composer2, 8);
                    composer2.endReplaceableGroup();
                } else if (i4 == 2) {
                    composer2.startReplaceableGroup(-366773694);
                    NoticeKt.NoticeAlertView(data, composer2, 8);
                    composer2.endReplaceableGroup();
                } else if (i4 == 3) {
                    composer2.startReplaceableGroup(-366773638);
                    NoticeKt.NoticeNormalView(data, composer2, 8);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-366773606);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, (i & 14) | 384 | ((i >> 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt.NoticeHost.2
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
                    NoticeCommonKt.NoticeHost(hostState, noticeService, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
