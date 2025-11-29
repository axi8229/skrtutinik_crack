package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/AppBarDefaults;", "", "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "TopAppBarElevation", "F", "getTopAppBarElevation-D9Ej5fM", "()F", "BottomAppBarElevation", "getBottomAppBarElevation-D9Ej5fM", "Landroidx/compose/foundation/layout/PaddingValues;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarDefaults {
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m2102constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m2102constructorimpl(8);
    private static final PaddingValues ContentPadding = PaddingKt.m308PaddingValuesa9UjIt4$default(AppBarKt.AppBarHorizontalPadding, 0.0f, AppBarKt.AppBarHorizontalPadding, 0.0f, 10, null);

    private AppBarDefaults() {
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m592getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }
}
