package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.DividerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.unit.Dp;
import androidx.view.compose.BackHandlerKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.emptystates.EmptyStateLargeViewKt;
import ru.yoomoney.sdk.guiCompose.views.form.TextInputViewKt;
import ru.yoomoney.sdk.guiCompose.views.listItems.action.ActionItemsKt;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.ui.compose.CustomDimens;
import ru.yoomoney.sdk.kassa.payments.ui.compose.LoadingStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.utils.compose.BottomSheetCornersKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public abstract class O {
    public static final void a(a0 a0Var, Function1 function1, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-318362581);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(a0Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-318362581, i2, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankItem (BankListScreen.kt:267)");
            }
            String str = a0Var.b;
            composerStartRestartGroup.startReplaceableGroup(-2096768793);
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new C2383n(function1, a0Var);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ActionItemsKt.ItemVectorPrimaryActionView(str, null, null, false, false, false, (Function0) objRememberedValue, composerStartRestartGroup, 3072, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2384o(a0Var, function1, i));
        }
    }

    public static final void b(Composer composer, int i) throws Resources.NotFoundException {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1489860924);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1489860924, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.EmptyStateItem (BankListScreen.kt:293)");
            }
            EmptyStateLargeViewKt.EmptyStateLargeView(PaddingKt.m313paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2102constructorimpl(12), 7, null), PainterResources_androidKt.painterResource(R$drawable.ym_search_not_found, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R$string.ym_title_not_found, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R$string.ym_subtitle_sbp_not_found, composerStartRestartGroup, 0), null, false, null, composerStartRestartGroup, 70, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new G(i));
        }
    }

    public static final void c(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-600997383);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-600997383, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.LoadingScreen (BankListScreen.kt:228)");
            }
            Modifier modifierM323height3ABfNKs = SizeKt.m323height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomDimens.INSTANCE.m3494getBottomDialogMaxHeightD9Ej5fM());
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM323height3ABfNKs);
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
            LoadingStateScreenKt.LoadingStateScreen(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new H(i));
        }
    }

    public static final void a(Modifier modifier, List list, Function1 function1, Function0 function0, Composer composer, int i, int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1947041435);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1947041435, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankList (BankListScreen.kt:244)");
        }
        LazyDslKt.LazyColumn(modifier2, null, null, false, null, null, null, false, new C2387s(list, function1, function0), composerStartRestartGroup, i & 14, 254);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2388t(modifier2, list, function1, function0, i, i2));
        }
    }

    public static final void a(Z state, ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter, RuntimeViewModel viewModel, Composer composer, int i) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(1839009678);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1839009678, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankListScreen (BankListScreen.kt:76)");
        }
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
        D d = new D(viewModel);
        E e = new E(viewModel);
        Modifier modifierRoundBottomSheetCorners = BottomSheetCornersKt.roundBottomSheetCorners(NestedScrollModifierKt.nestedScroll$default(AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), NestedScrollInteropConnectionKt.rememberNestedScrollInteropConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierRoundBottomSheetCorners);
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
        if ((state instanceof W) || (state instanceof Y) || (state instanceof T)) {
            composerStartRestartGroup.startReplaceableGroup(1164961768);
            c(composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (state instanceof Q) {
            composerStartRestartGroup.startReplaceableGroup(1164961825);
            a(errorFormatter.a(((Q) state).a).toString(), null, new C2390v(viewModel), composerStartRestartGroup, 0, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (state instanceof V) {
            composerStartRestartGroup.startReplaceableGroup(1164962083);
            a(errorFormatter.a(((V) state).a).toString(), null, new C2391w(viewModel), composerStartRestartGroup, 0, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (state instanceof U) {
            composerStartRestartGroup.startReplaceableGroup(1164962345);
            a(errorFormatter.a(((U) state).a).toString(), null, new C2392x(viewModel), composerStartRestartGroup, 0, 2);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (state instanceof P) {
                composerStartRestartGroup.startReplaceableGroup(1164962598);
                String string = errorFormatter.a(((P) state).a).toString();
                String string2 = ((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getString(R$string.ym_understand_button);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                a(string, string2, new C2393y(viewModel), composerStartRestartGroup, 0, 0);
            } else if (state instanceof X) {
                composerStartRestartGroup.startReplaceableGroup(1164962939);
                a((X) state, d, e, composerStartRestartGroup, 8);
            } else if (state instanceof S) {
                composerStartRestartGroup.startReplaceableGroup(1164963145);
                a((S) state, d, e, new C2394z(viewModel, softwareKeyboardController), new A(viewModel), composerStartRestartGroup, 8);
            } else {
                composerStartRestartGroup.startReplaceableGroup(1164963676);
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        BackHandlerKt.BackHandler(false, new B(viewModel, softwareKeyboardController), composerStartRestartGroup, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C(state, errorFormatter, viewModel, i));
        }
    }

    public static final void a(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-420278403);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-420278403, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.DividerItem (BankListScreen.kt:283)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int i2 = R$dimen.ym_spaceM;
            DividerKt.m628DivideroMI9zvI(PaddingKt.m313paddingqDBjuR0$default(companion, PrimitiveResources_androidKt.dimensionResource(i2, composerStartRestartGroup, 0), 0.0f, PrimitiveResources_androidKt.dimensionResource(i2, composerStartRestartGroup, 0), 0.0f, 10, null), 0L, 0.0f, 0.0f, composerStartRestartGroup, 0, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new F(i));
        }
    }

    public static final void a(d0 d0Var, Function0 function0, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1928309584);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(d0Var) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(1928309584, i2, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.SelectAnotherBankItem (BankListScreen.kt:278)");
            }
            ActionItemsKt.ItemVectorPrimaryActionView(d0Var.a, null, null, false, false, false, function0, composerStartRestartGroup, (i2 << 15) & 3670016, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new I(d0Var, function0, i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(java.lang.String r10, java.lang.String r11, kotlin.jvm.functions.Function0 r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.O.a(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(S s, Function1 function1, Function0 function0, Function0 function02, Function1 function12, Composer composer, int i) throws Resources.NotFoundException {
        List list;
        String str;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2110136);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2110136, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.ShowFullBankListContent (BankListScreen.kt:181)");
        }
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        String strStringResource = StringResources_androidKt.stringResource(R$string.ym_sbp_select_bank_title, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(1246787917);
        Painter painterPainterResource = s.b ? PainterResources_androidKt.painterResource(ru.yoomoney.sdk.guiCompose.R$drawable.ic_back_m, composerStartRestartGroup, 0) : null;
        composerStartRestartGroup.endReplaceableGroup();
        int i2 = i << 3;
        TopBarKt.m3460TopBarDefaultwqdebIU(strStringResource, (Modifier) null, painterPainterResource, (String) null, (Function0<Unit>) function02, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, false, composerStartRestartGroup, (i2 & 57344) | 512, pjsip_status_code.PJSIP_SC_REQUEST_UPDATED);
        boolean z = true;
        if (!(s.c.length() == 0)) {
            list = s.d;
        } else {
            list = s.a;
        }
        List<ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a> items = list;
        composerStartRestartGroup.startReplaceableGroup(1246788369);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion3 = Composer.INSTANCE;
        if (objRememberedValue == companion3.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s.c, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        FocusManager focusManager = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        String str2 = (String) mutableState.getValue();
        String strStringResource2 = StringResources_androidKt.stringResource(R$string.ym_bank_list_sbp_search_hint, composerStartRestartGroup, 0);
        YooTheme yooTheme = YooTheme.INSTANCE;
        int i3 = YooTheme.$stable;
        Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(companion, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceS(), 0.0f, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceS(), 0.0f, 10, null);
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, ImeAction.INSTANCE.m1891getDoneeUduSuo(), (PlatformImeOptions) null, 23, (DefaultConstructorMarker) null);
        KeyboardActions keyboardActions = new KeyboardActions(new K(focusManager), null, null, null, null, null, 62, null);
        composerStartRestartGroup.startReplaceableGroup(1246788563);
        if ((((i & 57344) ^ 24576) <= 16384 || !composerStartRestartGroup.changed(function12)) && (i & 24576) != 16384) {
            z = false;
        }
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue2 == companion3.getEmpty()) {
            objRememberedValue2 = new L(function12, mutableState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        TextInputViewKt.TextInputView(str2, (Function1) objRememberedValue2, modifierM313paddingqDBjuR0$default, strStringResource2, null, null, null, null, false, false, null, null, keyboardOptions, keyboardActions, false, 0, composerStartRestartGroup, 0, 384, 53232);
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        for (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a aVar : items) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            if (Intrinsics.areEqual(ru.yoomoney.sdk.kassa.payments.utils.f.a(), "ru")) {
                str = aVar.b;
            } else {
                str = aVar.c;
            }
            arrayList.add(new a0(aVar.a, str, aVar.d));
            if (!Intrinsics.areEqual(aVar, CollectionsKt.last(items))) {
                arrayList.add(b0.a);
            }
        }
        if (items.isEmpty()) {
            arrayList.add(c0.a);
        }
        a((Modifier) null, arrayList, function1, function0, composerStartRestartGroup, (i2 & 896) | 64 | (i2 & 7168), 1);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new M(s, function1, function0, function02, function12, i));
        }
    }

    public static final void a(X x, Function1 function1, Function0 function0, Composer composer, int i) {
        String str;
        Composer composerStartRestartGroup = composer.startRestartGroup(1075693937);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075693937, i, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.ShowShortBankListContent (BankListScreen.kt:163)");
        }
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TopBarKt.m3460TopBarDefaultwqdebIU(StringResources_androidKt.stringResource(R$string.ym_sbp_select_bank_title, composerStartRestartGroup, 0), (Modifier) null, (Painter) null, (String) null, (Function0<Unit>) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, false, composerStartRestartGroup, 384, 506);
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        List<ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a> items = x.a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        for (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a aVar : items) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            if (Intrinsics.areEqual(ru.yoomoney.sdk.kassa.payments.utils.f.a(), "ru")) {
                str = aVar.b;
            } else {
                str = aVar.c;
            }
            arrayList.add(new a0(aVar.a, str, aVar.d));
            arrayList.add(b0.a);
        }
        String string = context.getString(R$string.ym_sbp_select_other_bank_button_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new d0(string));
        int i2 = i << 3;
        a((Modifier) null, arrayList, function1, function0, composerStartRestartGroup, (i2 & 896) | 64 | (i2 & 7168), 1);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new N(x, function1, function0, i));
        }
    }

    public static final void a(e0 e0Var, Function1 function1, Function0 function0, Composer composer, int i) throws Resources.NotFoundException {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-851737889);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(e0Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-851737889, i2, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankListItem (BankListScreen.kt:257)");
            }
            if (e0Var instanceof a0) {
                composerStartRestartGroup.startReplaceableGroup(1264186212);
                a((a0) e0Var, function1, composerStartRestartGroup, i2 & 112);
            } else if (e0Var instanceof d0) {
                composerStartRestartGroup.startReplaceableGroup(1264186301);
                a((d0) e0Var, function0, composerStartRestartGroup, (i2 >> 3) & 112);
            } else if (e0Var instanceof b0) {
                composerStartRestartGroup.startReplaceableGroup(1264186396);
                a(composerStartRestartGroup, 0);
            } else if (e0Var instanceof c0) {
                composerStartRestartGroup.startReplaceableGroup(1264186454);
                b(composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceableGroup(1264186476);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2389u(e0Var, function1, function0, i));
        }
    }
}
