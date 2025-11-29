package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0084\u0002\u0010(\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aü\u0001\u0010(\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001av\u00101\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001av\u00103\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00100\u001av\u00105\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00100\"1\u0010?\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00158G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b7\u00108\u0012\u0004\b=\u0010>\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\"\"\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0@8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0014\u0010F\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/material/DrawerState;", "drawerState", "Landroidx/compose/material/SnackbarHostState;", "snackbarHostState", "Landroidx/compose/material/ScaffoldState;", "rememberScaffoldState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "Landroidx/compose/foundation/layout/WindowInsets;", "contentWindowInsets", "Landroidx/compose/ui/Modifier;", "modifier", "scaffoldState", "Lkotlin/Function0;", "", "topBar", "bottomBar", "Lkotlin/Function1;", "snackbarHost", "floatingActionButton", "Landroidx/compose/material/FabPosition;", "floatingActionButtonPosition", "", "isFloatingActionButtonDocked", "Landroidx/compose/foundation/layout/ColumnScope;", "drawerContent", "drawerGesturesEnabled", "Landroidx/compose/ui/graphics/Shape;", "drawerShape", "Landroidx/compose/ui/unit/Dp;", "drawerElevation", "Landroidx/compose/ui/graphics/Color;", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isFabDocked", "fabPosition", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScaffoldLayout", "ScaffoldLayoutWithMeasureFix-i1QSOvI", "ScaffoldLayoutWithMeasureFix", "LegacyScaffoldLayout-i1QSOvI", "LegacyScaffoldLayout", "<set-?>", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "ScaffoldSubcomposeInMeasureFix", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "FabSpacing", "F", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m2102constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:76)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:314:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0130  */
    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m659Scaffoldu4IkXBM(final androidx.compose.foundation.layout.WindowInsets r39, androidx.compose.ui.Modifier r40, androidx.compose.material.ScaffoldState r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, int r46, boolean r47, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, boolean r49, androidx.compose.ui.graphics.Shape r50, float r51, long r52, long r54, long r56, long r58, long r60, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, androidx.compose.runtime.Composer r63, final int r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m659Scaffoldu4IkXBM(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:296:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0136  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m658Scaffold27mzLpw(androidx.compose.ui.Modifier r58, androidx.compose.material.ScaffoldState r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, int r64, boolean r65, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, boolean r67, androidx.compose.ui.graphics.Shape r68, float r69, long r70, long r72, long r74, long r76, long r78, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, androidx.compose.runtime.Composer r81, final int r82, final int r83, final int r84) {
        /*
            Method dump skipped, instructions count: 1223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m658Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        return ((Boolean) ScaffoldSubcomposeInMeasureFix$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m660ScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-468424875);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, i3, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:409)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                composerStartRestartGroup.startReplaceableGroup(-2103098080);
                m661ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composerStartRestartGroup, i3 & 33554430);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2103097736);
                m657LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composerStartRestartGroup, i3 & 33554430);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1
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

                public final void invoke(Composer composer2, int i4) {
                    ScaffoldKt.m660ScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-i1QSOvI, reason: not valid java name */
    public static final void m661ScaffoldLayoutWithMeasureFixi1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1285900760);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285900760, i3, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix (Scaffold.kt:449)");
            }
            composerStartRestartGroup.startReplaceableGroup(-757560492);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changed(windowInsets) | composerStartRestartGroup.changedInstance(function23) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(z) | composerStartRestartGroup.changedInstance(function24) | composerStartRestartGroup.changedInstance(function3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m666invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:93:0x022d  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.ui.layout.MeasureResult m666invoke0kLqBqw(final androidx.compose.ui.layout.SubcomposeMeasureScope r33, long r34) {
                        /*
                            Method dump skipped, instructions count: 903
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.m666invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                composer2.updateRememberedValue(function25);
                objRememberedValue = function25;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ScaffoldKt.m661ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m657LegacyScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(141059468);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(141059468, i3, -1, "androidx.compose.material.LegacyScaffoldLayout (Scaffold.kt:627)");
            }
            composerStartRestartGroup.startReplaceableGroup(-757553268);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changed(windowInsets) | composerStartRestartGroup.changedInstance(function23) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(z) | composerStartRestartGroup.changedInstance(function24) | composerStartRestartGroup.changedInstance(function3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m665invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m665invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final int iM2084getMaxWidthimpl = Constraints.m2084getMaxWidthimpl(j);
                        final int iM2083getMaxHeightimpl = Constraints.m2083getMaxHeightimpl(j);
                        final long jM2076copyZbe2FdA$default = Constraints.m2076copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i4 = i;
                        final boolean z2 = z;
                        final WindowInsets windowInsets2 = windowInsets;
                        final Function2<Composer, Integer, Unit> function29 = function24;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(subcomposeMeasureScope, iM2084getMaxWidthimpl, iM2083getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:90:0x0229  */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r30) {
                                /*
                                    Method dump skipped, instructions count: 1059
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.AnonymousClass1.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }, 4, null);
                    }
                };
                composer2.updateRememberedValue(function25);
                objRememberedValue = function25;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ScaffoldKt.m657LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
