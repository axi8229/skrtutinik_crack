package androidx.compose.runtime;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "", "", "list", "<init>", "(Ljava/util/List;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "add", "(I)V", "", "isNotEmpty", "()Z", "peek", "()I", "takeMax", "Ljava/util/List;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrioritySet {
    private final List<Integer> list;

    public PrioritySet(List<Integer> list) {
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final void add(int value) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() == value) {
                return;
            }
            if (this.list.get(r0.size() - 1).intValue() == value) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(value));
        while (size > 0) {
            int i = ((size + 1) >>> 1) - 1;
            int iIntValue = this.list.get(i).intValue();
            if (value <= iIntValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(iIntValue));
            size = i;
        }
        this.list.set(size, Integer.valueOf(value));
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt.first((List) this.list)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int takeMax() {
        int iIntValue;
        if (!(this.list.size() > 0)) {
            ComposerKt.composeImmediateRuntimeError("Set is empty");
        }
        int iIntValue2 = this.list.get(0).intValue();
        while (!this.list.isEmpty() && this.list.get(0).intValue() == iIntValue2) {
            List<Integer> list = this.list;
            list.set(0, CollectionsKt.last((List) list));
            List<Integer> list2 = this.list;
            list2.remove(list2.size() - 1);
            int size = this.list.size();
            int size2 = this.list.size() >>> 1;
            int i = 0;
            while (i < size2) {
                int iIntValue3 = this.list.get(i).intValue();
                int i2 = (i + 1) * 2;
                int i3 = i2 - 1;
                int iIntValue4 = this.list.get(i3).intValue();
                if (i2 >= size || (iIntValue = this.list.get(i2).intValue()) <= iIntValue4) {
                    if (iIntValue4 > iIntValue3) {
                        this.list.set(i, Integer.valueOf(iIntValue4));
                        this.list.set(i3, Integer.valueOf(iIntValue3));
                        i = i3;
                    }
                } else if (iIntValue > iIntValue3) {
                    this.list.set(i, Integer.valueOf(iIntValue));
                    this.list.set(i2, Integer.valueOf(iIntValue3));
                    i = i2;
                }
            }
        }
        return iIntValue2;
    }
}
