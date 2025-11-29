package androidx.compose.ui.input.pointer;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/ProcessResult;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "getDispatchedToAPointerInputModifier-impl", "(I)Z", "dispatchedToAPointerInputModifier", "getAnyMovementConsumed-impl", "anyMovementConsumed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ProcessResult {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1386constructorimpl(int i) {
        return i;
    }

    /* renamed from: getAnyMovementConsumed-impl, reason: not valid java name */
    public static final boolean m1387getAnyMovementConsumedimpl(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: getDispatchedToAPointerInputModifier-impl, reason: not valid java name */
    public static final boolean m1388getDispatchedToAPointerInputModifierimpl(int i) {
        return (i & 1) != 0;
    }
}
