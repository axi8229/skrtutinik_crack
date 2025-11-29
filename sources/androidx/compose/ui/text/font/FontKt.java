package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* compiled from: Font.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"", "resId", "Landroidx/compose/ui/text/font/FontWeight;", "weight", "Landroidx/compose/ui/text/font/FontStyle;", "style", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "loadingStrategy", "Landroidx/compose/ui/text/font/Font;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "Font", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontKt {
    /* renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m1835FontYpTlLL0$default(int i, FontWeight fontWeight, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.INSTANCE.m1852getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.INSTANCE.m1841getBlockingPKNRLFQ();
        }
        return m1834FontYpTlLL0(i, fontWeight, i2, i3);
    }

    /* renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m1834FontYpTlLL0(int i, FontWeight fontWeight, int i2, int i3) {
        return new ResourceFont(i, fontWeight, i2, new FontVariation$Settings(new FontVariation$Setting[0]), i3, null);
    }
}
