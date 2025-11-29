package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.ui.CustomDimens;
import ru.yoomoney.sdk.kassa.payments.ui.compose.ErrorStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.ui.compose.LoadingStateScreenKt;

/* loaded from: classes5.dex */
public abstract class p1 {
    public static final void a(String str, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-234045772);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-234045772, i2, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.ErrorText (PaymentAuthScreen.kt:406)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, PaddingKt.m309padding3ABfNKs(modifierFillMaxWidth$default, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceM()), ColorResources_androidKt.colorResource(R$color.color_type_alert, composerStartRestartGroup, 0), 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getCaption2(), composer2, i2 & 14, 0, 65016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Q0(str, i));
        }
    }

    public static final void a(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1795037116);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1795037116, i, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.Loading (PaymentAuthScreen.kt:221)");
            }
            LoadingStateScreenKt.LoadingStateScreen(SizeKt.fillMaxWidth$default(SizeKt.m322defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, CustomDimens.INSTANCE.m3464getBottomDialogMinHeightD9Ej5fM(), 1, null), 0.0f, 1, null), composerStartRestartGroup, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new R0(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0298 A[PHI: r0
  0x0298: PHI (r0v27 int) = (r0v23 int), (r0v28 int) binds: [B:66:0x0296, B:62:0x0290] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.ui.Alignment$Vertical, java.lang.Object, kotlin.coroutines.Continuation] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(ru.yoomoney.sdk.kassa.payments.errorFormatter.b r18, boolean r19, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r20, androidx.lifecycle.ViewModelProvider.Factory r21, kotlin.jvm.functions.Function0 r22, kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, int r25) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.p1.a(ru.yoomoney.sdk.kassa.payments.errorFormatter.b, boolean, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, androidx.lifecycle.ViewModelProvider$Factory, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    public static final void a(Modifier modifier, boolean z, String str, boolean z2, Function0 function0, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(617147883);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((46811 & i3) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(617147883, i3, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.RetryContent (PaymentAuthScreen.kt:377)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(1903536332);
                LoadingStateScreenKt.LoadingStateScreen(null, composerStartRestartGroup, 0, 1);
            } else {
                composerStartRestartGroup.startReplaceableGroup(1903536382);
                if (z2) {
                    composerStartRestartGroup.startReplaceableGroup(1903536419);
                    String strStringResource = StringResources_androidKt.stringResource(R$string.ym_payment_auth_retry_text, composerStartRestartGroup, 0);
                    YooTheme yooTheme = YooTheme.INSTANCE;
                    int i4 = YooTheme.$stable;
                    Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(modifier, yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), 0.0f, yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), yooTheme.getDimens(composerStartRestartGroup, i4).getSpaceM(), 2, null);
                    composerStartRestartGroup.startReplaceableGroup(1903536748);
                    boolean z3 = (i3 & 57344) == 16384;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new C2403c1(function0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ButtonsKt.FlatButtonView(strStringResource, modifierM313paddingqDBjuR0$default, false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 4);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(1903536841);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    YooTheme yooTheme2 = YooTheme.INSTANCE;
                    int i5 = YooTheme.$stable;
                    TextKt.m685Text4IGK_g(str, PaddingKt.m309padding3ABfNKs(modifierFillMaxWidth$default, yooTheme2.getDimens(composerStartRestartGroup, i5).getSpaceM()), 0L, 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme2.getTypography(composerStartRestartGroup, i5).getBody(), composerStartRestartGroup, (i3 >> 6) & 14, 0, 65020);
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new C2406d1(modifier, z, str, z2, function0, i));
        }
    }

    public static final void a(String str, Function0 function0, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2099484854);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099484854, i2, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.ShowError (PaymentAuthScreen.kt:229)");
            }
            ErrorStateScreenKt.ErrorStateScreen(SizeKt.m323height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ru.yoomoney.sdk.kassa.payments.ui.compose.CustomDimens.INSTANCE.m3494getBottomDialogMaxHeightD9Ej5fM()), 0, StringResources_androidKt.stringResource(R$string.ym_retry, composerStartRestartGroup, 0), str, null, function0, composerStartRestartGroup, ((i2 << 9) & 7168) | 6 | ((i2 << 12) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2409e1(str, function0, i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(ru.yoomoney.sdk.kassa.payments.model.C2326j r43, java.lang.String r44, kotlin.jvm.functions.Function1 r45, kotlin.jvm.functions.Function0 r46, java.lang.String r47, boolean r48, kotlin.jvm.functions.Function0 r49, boolean r50, androidx.compose.runtime.Composer r51, int r52, int r53) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.p1.a(ru.yoomoney.sdk.kassa.payments.model.j, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, java.lang.String, boolean, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void a(t1 t1Var, Function1 function1, Function0 function0, Function0 function02, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1362918398);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(t1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1362918398, i2, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.ShowInputCode (PaymentAuthScreen.kt:246)");
            }
            int i3 = i2 << 3;
            a(t1Var.a, null, function1, function0, "", false, function02, false, composerStartRestartGroup, (i3 & 7168) | (i3 & 896) | 221232 | ((i2 << 9) & 3670016), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2412f1(t1Var, function1, function0, function02, i));
        }
    }

    public static final void a(u1 u1Var, Function1 function1, Function0 function0, Function0 function02, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(188256740);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(u1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(188256740, i2, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.ShowInputCodeProcess (PaymentAuthScreen.kt:264)");
            }
            int i3 = i2 << 3;
            a(u1Var.b, u1Var.a, function1, function0, "", true, function02, false, composerStartRestartGroup, (i3 & 7168) | (i3 & 896) | 221184 | ((i2 << 9) & 3670016), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2424j1(u1Var, function1, function0, function02, i));
        }
    }

    public static final void a(v1 v1Var, Function1 function1, Function0 function0, Function0 function02, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1360052698);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(v1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1360052698, i2, -1, "ru.yoomoney.sdk.kassa.payments.paymentAuth.ShowInputCodeVerifyExceeded (PaymentAuthScreen.kt:281)");
            }
            int i3 = i2 << 3;
            a(v1Var.b, v1Var.a, function1, function0, StringResources_androidKt.stringResource(R$string.ym_payment_auth_no_attempts, composerStartRestartGroup, 0), false, function02, false, composerStartRestartGroup, (i3 & 7168) | (i3 & 896) | 12779520 | ((i2 << 9) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2427k1(v1Var, function1, function0, function02, i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(ru.yoomoney.sdk.kassa.payments.model.C2326j r19, java.lang.Integer r20, java.lang.Integer r21, kotlin.jvm.functions.Function0 r22, kotlin.jvm.functions.Function0 r23, kotlin.jvm.functions.Function1 r24, androidx.compose.runtime.Composer r25, int r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.p1.a(ru.yoomoney.sdk.kassa.payments.model.j, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    public static final String a(Context context, long j) {
        long j2 = j / 1000;
        long j3 = 60;
        String strA = P0.a(j2 / j3);
        String strA2 = P0.a(j2 % j3);
        String string = context.getString(R$string.ym_confirm_retry_timer_text, strA + ":" + strA2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
