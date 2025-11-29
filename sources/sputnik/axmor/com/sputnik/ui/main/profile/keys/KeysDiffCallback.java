package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import androidx.recyclerview.widget.DiffUtil;
import com.sputnik.common.entities.keys.PhysicalKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeysAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeysDiffCallback extends DiffUtil.ItemCallback<PhysicalKey> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(PhysicalKey oldItem, PhysicalKey newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getUuid(), newItem.getUuid());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(PhysicalKey oldItem, PhysicalKey newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getUuid(), newItem.getUuid());
    }
}
