package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R$string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* compiled from: Strings.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Strings_androidKt {
    /* renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m678getString4foXLRw(int i, Composer composer, int i2) {
        String string;
        composer.startReplaceableGroup(-726638443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.INSTANCE;
        if (Strings.m670equalsimpl0(i, companion.m675getNavigationMenuUdPEhr4())) {
            string = resources.getString(R$string.navigation_menu);
        } else if (Strings.m670equalsimpl0(i, companion.m671getCloseDrawerUdPEhr4())) {
            string = resources.getString(R$string.close_drawer);
        } else if (Strings.m670equalsimpl0(i, companion.m672getCloseSheetUdPEhr4())) {
            string = resources.getString(R$string.close_sheet);
        } else if (Strings.m670equalsimpl0(i, companion.m673getDefaultErrorMessageUdPEhr4())) {
            string = resources.getString(R$string.default_error_message);
        } else if (Strings.m670equalsimpl0(i, companion.m674getExposedDropdownMenuUdPEhr4())) {
            string = resources.getString(R$string.dropdown_menu);
        } else if (Strings.m670equalsimpl0(i, companion.m677getSliderRangeStartUdPEhr4())) {
            string = resources.getString(R$string.range_start);
        } else {
            string = Strings.m670equalsimpl0(i, companion.m676getSliderRangeEndUdPEhr4()) ? resources.getString(R$string.range_end) : "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return string;
    }
}
