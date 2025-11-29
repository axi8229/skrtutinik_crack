package androidx.compose.runtime;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: SnapshotFloatState.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/runtime/MutableFloatState;", "mutableFloatStateOf", "(F)Landroidx/compose/runtime/MutableFloatState;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/PrimitiveSnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class PrimitiveSnapshotStateKt__SnapshotFloatStateKt {
    public static final MutableFloatState mutableFloatStateOf(float f) {
        return ActualAndroid_androidKt.createSnapshotMutableFloatState(f);
    }
}
