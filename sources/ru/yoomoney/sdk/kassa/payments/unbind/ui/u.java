package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;
import ru.yoomoney.sdk.guiCompose.views.informers.InformersKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.ui.color.Colors;
import ru.yoomoney.sdk.kassa.payments.utils.compose.BottomSheetCornersKt;

/* loaded from: classes5.dex */
public abstract class u {
    public static final void a(F f, Q q, Function0 function0, Function1 function1, SnackbarHostState snackbarHostState, NoticeService noticeService, boolean z, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1314335586);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(q) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(noticeService) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((2995931 & i2) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1314335586, i2, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.ContentLinkedBankCard (UnbindCardScreen.kt:218)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            String str = q.c() + "••••••" + q.d();
            String strStringResource = StringResources_androidKt.stringResource(R$string.ym_informer_unbind_text, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(640508259);
            boolean z2 = ((i2 & 7168) == 2048) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new h(function1, q);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            i iVar = new i(context, f);
            int i3 = ((i2 >> 15) & 112) | 24576 | ((i2 << 3) & 7168);
            int i4 = i2 << 9;
            a(strStringResource, z, str, function0, false, (Function0) objRememberedValue, iVar, snackbarHostState, noticeService, composerStartRestartGroup, i3 | (29360128 & i4) | (NoticeService.$stable << 24) | (i4 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new j(f, q, function0, function1, snackbarHostState, noticeService, z, i));
        }
    }

    public static final void a(F f, w wVar, Function0 function0, Function1 function1, SnackbarHostState snackbarHostState, NoticeService noticeService, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1346186475);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1346186475, i, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.ContentLinkedWallet (UnbindCardScreen.kt:247)");
        }
        int i2 = i << 9;
        a(StringResources_androidKt.stringResource(R$string.ym_informer_unbind_card_wallet, composerStartRestartGroup, 0), false, wVar.a.getPan(), function0, true, new k(function1, wVar), new l((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), f), snackbarHostState, noticeService, composerStartRestartGroup, ((i << 3) & 7168) | 24624 | (29360128 & i2) | (NoticeService.$stable << 24) | (i2 & 234881024));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new m(f, wVar, function0, function1, snackbarHostState, noticeService, i));
        }
    }

    public static final void a(boolean z, String str, Composer composer, int i) {
        int i2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1550096929);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1550096929, i2, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.FilledBankCard (UnbindCardScreen.kt:156)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(1168845603);
                i3 = R$string.ym_linked_wallet_card;
            } else {
                composerStartRestartGroup.startReplaceableGroup(1168845676);
                i3 = R$string.ym_linked_card;
            }
            String strStringResource = StringResources_androidKt.stringResource(i3, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM311paddingVpY3zN4$default = PaddingKt.m311paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), YooTheme.INSTANCE.getDimens(composerStartRestartGroup, YooTheme.$stable).getSpaceM(), 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(1168845878);
            boolean zChanged = ((i2 & 112) == 32) | composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new n(str, strStringResource);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierM311paddingVpY3zN4$default, null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new o(i, str, z));
        }
    }

    public static final void a(F f, Function0 function0, SnackbarHostState snackbarHostState, NoticeService noticeService, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1347106394);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(noticeService) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1347106394, i2, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.Initial (UnbindCardScreen.kt:189)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            String strStringResource = StringResources_androidKt.stringResource(R$string.ym_informer_unbind_text, composerStartRestartGroup, 0);
            p pVar = p.a;
            q qVar = new q(context, f);
            int i3 = ((i2 << 6) & 7168) | 221616;
            int i4 = i2 << 15;
            a(strStringResource, true, "", function0, false, pVar, qVar, snackbarHostState, noticeService, composerStartRestartGroup, i3 | (29360128 & i4) | (NoticeService.$stable << 24) | (i4 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new r(f, function0, snackbarHostState, noticeService, i));
        }
    }

    public static final void a(String str, boolean z, String str2, Function0 function0, boolean z2, Function0 function02, Function0 function03, SnackbarHostState snackbarHostState, NoticeService noticeService, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1090961927);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(noticeService) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090961927, i2, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.UnbindCardForm (UnbindCardScreen.kt:106)");
            }
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierRoundBottomSheetCorners = BottomSheetCornersKt.roundBottomSheetCorners(companion, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierRoundBottomSheetCorners);
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
            Updater.m728setimpl(composerM727constructorimpl2, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = i2 << 3;
            TopBarKt.m3460TopBarDefaultwqdebIU("•••• " + StringsKt.takeLast(str2, 4), (Modifier) null, (Painter) null, (String) null, (Function0<Unit>) function0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, false, composerStartRestartGroup, i3 & 57344, pjsip_status_code.PJSIP_SC_SECURITY_AGREEMENT_NEEDED);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i4 = YooTheme.$stable;
            Modifier modifierM166backgroundbw27NRU$default = BackgroundKt.m166backgroundbw27NRU$default(companion, yooTheme.getColors(composerStartRestartGroup, i4).getTheme().getTintBg(), null, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM166backgroundbw27NRU$default);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM727constructorimpl3 = Updater.m727constructorimpl(composerStartRestartGroup);
            Updater.m728setimpl(composerM727constructorimpl3, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM727constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM727constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            function3ModifierMaterializerOf3.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            int i5 = i2 >> 3;
            a(z2, str2, composerStartRestartGroup, ((i2 >> 12) & 14) | (i5 & 112));
            InformersKt.InformerAlertView(str, PaddingKt.m313paddingqDBjuR0$default(companion, yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), 0.0f, yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), 2, null), StringResources_androidKt.stringResource(R$string.ym_informer_unbind_action, composerStartRestartGroup, 0), PainterResources_androidKt.painterResource(R$drawable.ym_ic_warning_red, composerStartRestartGroup, 0), false, function03, composerStartRestartGroup, (i2 & 14) | 4096 | (i5 & 458752), 16);
            composerStartRestartGroup.startReplaceableGroup(-541850230);
            if (!z2) {
                Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), 0.0f, yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceL(), 2, null);
                String strStringResource = StringResources_androidKt.stringResource(R$string.ym_unbind_card_action, composerStartRestartGroup, 0);
                Colors colors = Colors.INSTANCE;
                ButtonsKt.m3429PrimaryColoredButtonViewWMdw5o4(strStringResource, modifierM313paddingqDBjuR0$default, z, false, function02, Color.m975copywmQWz5c$default(colors.m3468getAlert0d7_KjU$library_metricaRealRelease(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), colors.m3468getAlert0d7_KjU$library_metricaRealRelease(), composerStartRestartGroup, (i3 & 896) | 1769472 | (i5 & 57344), 8);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getBottomCenter());
            int i6 = i2 >> 21;
            NoticeCommonKt.NoticeHost(snackbarHostState, noticeService, modifierAlign, composerStartRestartGroup, (i6 & 14) | (NoticeService.$stable << 3) | (i6 & 112), 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new s(str, z, str2, function0, z2, function02, function03, snackbarHostState, noticeService, i));
        }
    }

    public static final void a(F reporter, Function0 onCloseScreen, Function1 onClickUnbind, y state, SnackbarHostState hostState, NoticeService noticeService, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(onCloseScreen, "onCloseScreen");
        Intrinsics.checkNotNullParameter(onClickUnbind, "onClickUnbind");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(hostState, "hostState");
        Intrinsics.checkNotNullParameter(noticeService, "noticeService");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1742823464);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(reporter) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCloseScreen) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClickUnbind) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(state) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(hostState) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i2 |= composerStartRestartGroup.changed(noticeService) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1742823464, i2, -1, "ru.yoomoney.sdk.kassa.payments.unbind.ui.UnbindCardScreen (UnbindCardScreen.kt:65)");
            }
            if (state instanceof x) {
                composerStartRestartGroup.startReplaceableGroup(1141552129);
                int i3 = i2 & 126;
                int i4 = i2 >> 6;
                a(reporter, onCloseScreen, hostState, noticeService, composerStartRestartGroup, i3 | (i4 & 896) | (NoticeService.$stable << 9) | (i4 & 7168));
                composerStartRestartGroup.endReplaceableGroup();
            } else if (state instanceof v) {
                composerStartRestartGroup.startReplaceableGroup(1141552362);
                v vVar = (v) state;
                int i5 = i2 << 3;
                a(reporter, vVar.b, onCloseScreen, onClickUnbind, hostState, noticeService, vVar.a, composerStartRestartGroup, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i2) | (NoticeService.$stable << 15) | (i2 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                if (state instanceof w) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceableGroup(1141552649);
                    int i6 = i2 << 3;
                    a(reporter, (w) state, onCloseScreen, onClickUnbind, hostState, noticeService, composerStartRestartGroup, (i2 & 14) | 64 | (i6 & 896) | (i6 & 7168) | (57344 & i2) | (NoticeService.$stable << 15) | (i2 & 458752));
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceableGroup(1141552829);
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new t(reporter, onCloseScreen, onClickUnbind, state, hostState, noticeService, i));
        }
    }
}
