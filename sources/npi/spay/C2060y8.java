package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.y8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2060y8 extends AbstractC2035x8 {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object obj, Object obj2) {
        C1462a8 oldItem = (C1462a8) obj;
        C1462a8 newItem = (C1462a8) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.a == newItem.a;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object obj, Object obj2) {
        C1462a8 oldItem = (C1462a8) obj;
        C1462a8 newItem = (C1462a8) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.a == newItem.a;
    }
}
