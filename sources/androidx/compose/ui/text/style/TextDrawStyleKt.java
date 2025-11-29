package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TextForegroundStyle.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\b\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "alpha", "modulate-DxMtmZc", "(JF)J", "modulate", "Lkotlin/Function0;", "block", "takeOrElse", "(FLkotlin/jvm/functions/Function0;)F", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextDrawStyleKt {
    /* renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m2054modulateDxMtmZc(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : Color.m975copywmQWz5c$default(j, Color.m978getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float f, Function0<Float> function0) {
        return Float.isNaN(f) ? function0.invoke().floatValue() : f;
    }
}
