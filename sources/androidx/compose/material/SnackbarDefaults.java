package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/material/SnackbarDefaults;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "backgroundColor", "getPrimaryActionColor", "primaryActionColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarDefaults {
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    public final long getBackgroundColor(Composer composer, int i) {
        composer.startReplaceableGroup(1630911716);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630911716, i, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:202)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        long jM994compositeOverOWjLjI = ColorKt.m994compositeOverOWjLjI(Color.m975copywmQWz5c$default(materialTheme.getColors(composer, 6).m607getOnSurface0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m612getSurface0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM994compositeOverOWjLjI;
    }

    public final long getPrimaryActionColor(Composer composer, int i) {
        long jM609getPrimaryVariant0d7_KjU;
        composer.startReplaceableGroup(-810329402);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810329402, i, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:222)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (colors.isLight()) {
            jM609getPrimaryVariant0d7_KjU = ColorKt.m994compositeOverOWjLjI(Color.m975copywmQWz5c$default(colors.m612getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colors.m608getPrimary0d7_KjU());
        } else {
            jM609getPrimaryVariant0d7_KjU = colors.m609getPrimaryVariant0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM609getPrimaryVariant0d7_KjU;
    }
}
