package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;

/* compiled from: CamerasPreviewAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamerasPreviewDiffCallback extends DiffUtil.ItemCallback<ManageCamerasItem> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(ManageCamerasItem oldItem, ManageCamerasItem newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(ManageCamerasItem oldItem, ManageCamerasItem newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return ((oldItem instanceof ManageCamerasItem.ManageCamera) && (newItem instanceof ManageCamerasItem.ManageCamera) && Intrinsics.areEqual(((ManageCamerasItem.ManageCamera) oldItem).getItem().getUuid(), ((ManageCamerasItem.ManageCamera) newItem).getItem().getUuid())) || ((oldItem instanceof ManageCamerasItem.ManageTitle) && (newItem instanceof ManageCamerasItem.ManageTitle) && Intrinsics.areEqual(((ManageCamerasItem.ManageTitle) oldItem).getTitle(), ((ManageCamerasItem.ManageTitle) newItem).getTitle()));
    }
}
