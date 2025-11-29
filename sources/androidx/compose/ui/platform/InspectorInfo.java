package androidx.compose.ui.platform;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: InspectableValue.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/InspectorInfo;", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Landroidx/compose/ui/platform/ValueElementSequence;", "properties", "Landroidx/compose/ui/platform/ValueElementSequence;", "getProperties", "()Landroidx/compose/ui/platform/ValueElementSequence;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InspectorInfo {
    private String name;
    private final ValueElementSequence properties = new ValueElementSequence();
    private Object value;

    public final void setName(String str) {
        this.name = str;
    }

    public final void setValue(Object obj) {
        this.value = obj;
    }

    public final ValueElementSequence getProperties() {
        return this.properties;
    }
}
