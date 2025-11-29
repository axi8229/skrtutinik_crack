package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ee, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1568ee extends AbstractC2035x8 {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object obj, Object obj2) {
        C2012wa oldItem = (C2012wa) obj;
        C2012wa newItem = (C2012wa) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.b, newItem.b);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object obj, Object obj2) {
        C2012wa oldItem = (C2012wa) obj;
        C2012wa newItem = (C2012wa) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.b, newItem.b);
    }
}
