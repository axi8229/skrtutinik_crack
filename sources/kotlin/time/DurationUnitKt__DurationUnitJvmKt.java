package kotlin.time;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DurationUnitJvm.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convertDurationUnit", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "convertDurationUnitOverflow", "(JLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes4.dex */
class DurationUnitKt__DurationUnitJvmKt {
    public static final double convertDurationUnit(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        long jConvert = targetUnit.getTimeUnit().convert(1L, sourceUnit.getTimeUnit());
        return jConvert > 0 ? d * jConvert : d / sourceUnit.getTimeUnit().convert(1L, targetUnit.getTimeUnit());
    }

    public static final long convertDurationUnitOverflow(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }

    public static final long convertDurationUnit(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }
}
