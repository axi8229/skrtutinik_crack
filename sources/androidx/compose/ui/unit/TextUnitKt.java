package androidx.compose.ui.unit;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u0012\u001a\u00020\r*\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0017\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"\u001e\u0010\u0017\u001a\u00020\u0004*\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0013\u0010\u0019\"\u001e\u0010\u0017\u001a\u00020\u0004*\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u0013\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/ui/unit/TextUnitType;", "type", "Landroidx/compose/ui/unit/TextUnit;", "TextUnit-anM5pPY", "(FJ)J", "TextUnit", "", "unitType", "v", "pack", "(JF)J", "", "isUnspecified--R2X_6o", "(J)Z", "isUnspecified--R2X_6o$annotations", "(J)V", "isUnspecified", "getSp", "(F)J", "getSp$annotations", "(F)V", "sp", "", "(D)J", "(D)V", "", "(I)J", "(I)V", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextUnitKt {
    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m2174TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m2175isUnspecifiedR2X_6o(long j) {
        return TextUnit.m2167getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(4294967296L, f);
    }

    public static final long getSp(double d) {
        return pack(4294967296L, (float) d);
    }

    public static final long getSp(int i) {
        return pack(4294967296L, i);
    }

    public static final long pack(long j, float f) {
        return TextUnit.m2164constructorimpl(j | (Float.floatToIntBits(f) & 4294967295L));
    }
}
