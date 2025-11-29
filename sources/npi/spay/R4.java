package npi.spay;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R4 extends DiffUtil.Callback {
    public final C1804o1 a;
    public final C1804o1 b;

    public R4(C1804o1 oldState, C1804o1 newState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.a = oldState;
        this.b = newState;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int i, int i2) {
        C1804o1 c1804o1 = this.a;
        Dk dk = (Dk) c1804o1.a.get(c1804o1.a(i));
        Object item = c1804o1.b.get(i);
        dk.getClass();
        Intrinsics.checkNotNullParameter(item, "item");
        C1804o1 c1804o12 = this.b;
        Dk dk2 = (Dk) c1804o12.a.get(c1804o12.a(i2));
        Object item2 = c1804o12.b.get(i2);
        dk2.getClass();
        Intrinsics.checkNotNullParameter(item2, "item");
        return Intrinsics.areEqual(item, item2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int i, int i2) {
        C1804o1 c1804o1 = this.a;
        Dk dk = (Dk) c1804o1.a.get(c1804o1.a(i));
        Object item = c1804o1.b.get(i);
        dk.getClass();
        Intrinsics.checkNotNullParameter(item, "item");
        Integer numA = dk.a(item);
        C1804o1 c1804o12 = this.b;
        Dk dk2 = (Dk) c1804o12.a.get(c1804o12.a(i2));
        Object item2 = c1804o12.b.get(i2);
        dk2.getClass();
        Intrinsics.checkNotNullParameter(item2, "item");
        return Intrinsics.areEqual(numA, dk2.a(item2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.b.b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.a.b.size();
    }
}
