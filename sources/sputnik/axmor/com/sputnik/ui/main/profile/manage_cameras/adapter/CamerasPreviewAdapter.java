package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemCameraPreviewBinding;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;

/* compiled from: CamerasPreviewAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB!\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter$ItemViewHolder;", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/sputnik/common/entities/camera/Camera;", "", "onItemClicked", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter$ItemViewHolder;", "holder", "position", "onBindViewHolder", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter$ItemViewHolder;I)V", "Lkotlin/jvm/functions/Function2;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "Ljava/util/ArrayList;", "ItemViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamerasPreviewAdapter extends ListAdapter<ManageCamerasItem, ItemViewHolder> {
    private ArrayList<ManageCamerasItem> list;
    private final Function2<View, Camera, Unit> onItemClicked;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateViewHolder$lambda$3$lambda$2$lambda$0(View view) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CamerasPreviewAdapter(Function2<? super View, ? super Camera, Unit> onItemClicked) {
        super(new CamerasPreviewDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        this.list = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_camera_preview, parent, false);
        Intrinsics.checkNotNull(viewDataBindingInflate);
        final ItemViewHolder itemViewHolder = new ItemViewHolder(viewDataBindingInflate);
        final ItemCameraPreviewBinding itemCameraPreviewBinding = (ItemCameraPreviewBinding) viewDataBindingInflate;
        itemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.CamerasPreviewAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return CamerasPreviewAdapter.onCreateViewHolder$lambda$3$lambda$2$lambda$0(view);
            }
        });
        itemCameraPreviewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.CamerasPreviewAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CamerasPreviewAdapter.onCreateViewHolder$lambda$3$lambda$2$lambda$1(this.f$0, itemCameraPreviewBinding, itemViewHolder, view);
            }
        });
        return itemViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$3$lambda$2$lambda$1(CamerasPreviewAdapter this$0, ItemCameraPreviewBinding this_run, ItemViewHolder this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Function2<View, Camera, Unit> function2 = this$0.onItemClicked;
        ImageView ivCameraImage = this_run.ivCameraImage;
        Intrinsics.checkNotNullExpressionValue(ivCameraImage, "ivCameraImage");
        ManageCamerasItem item = this$0.getItem(this_apply.getBindingAdapterPosition());
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem.ManageCamera");
        function2.invoke(ivCameraImage, ((ManageCamerasItem.ManageCamera) item).getItem());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ManageCamerasItem item = getItem(position);
        if (item != null) {
            holder.bindTo(item);
        }
    }

    /* compiled from: CamerasPreviewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "bindTo", "", "item", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ViewDataBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(final ManageCamerasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ManageCamerasItem.ManageCamera manageCamera = (ManageCamerasItem.ManageCamera) item;
            this.binding.setVariable(1, manageCamera.getItem());
            this.binding.executePendingBindings();
            ViewDataBinding viewDataBinding = this.binding;
            Intrinsics.checkNotNull(viewDataBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemCameraPreviewBinding");
            ItemCameraPreviewBinding itemCameraPreviewBinding = (ItemCameraPreviewBinding) viewDataBinding;
            View viewDim = itemCameraPreviewBinding.viewDim;
            Intrinsics.checkNotNullExpressionValue(viewDim, "viewDim");
            Boolean subscriptionRequried = manageCamera.getItem().getSubscriptionRequried();
            Boolean bool = Boolean.TRUE;
            ViewBindingUtilsKt.visibilityBasedOn(viewDim, Boolean.valueOf(Intrinsics.areEqual(subscriptionRequried, bool)));
            ImageView ivLocked = itemCameraPreviewBinding.ivLocked;
            Intrinsics.checkNotNullExpressionValue(ivLocked, "ivLocked");
            ViewBindingUtilsKt.visibilityBasedOn(ivLocked, Boolean.valueOf(Intrinsics.areEqual(manageCamera.getItem().getSubscriptionRequried(), bool)));
            Glide.with(this.itemView.getContext()).asBitmap().load(manageCamera.getItem().getPreviewUrl()).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.CamerasPreviewAdapter$ItemViewHolder$bindTo$2
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap p0, Transition<? super Bitmap> p1) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    ((ItemCameraPreviewBinding) this.this$0.getBinding()).ivCameraImage.setImageBitmap(p0);
                }

                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    ((ItemCameraPreviewBinding) this.this$0.getBinding()).viewDim.setAlpha(1.0f);
                    ((ItemCameraPreviewBinding) this.this$0.getBinding()).viewDim.setBackgroundColor(ContextCompat.getColor(((ItemCameraPreviewBinding) this.this$0.getBinding()).getRoot().getContext(), R.color.black_bottom_nav));
                    View viewDim2 = ((ItemCameraPreviewBinding) this.this$0.getBinding()).viewDim;
                    Intrinsics.checkNotNullExpressionValue(viewDim2, "viewDim");
                    ViewKt.visible(viewDim2);
                    if (((ManageCamerasItem.ManageCamera) item).getItem().getSubscriptionRequried() == null || Intrinsics.areEqual(((ManageCamerasItem.ManageCamera) item).getItem().getSubscriptionRequried(), Boolean.FALSE)) {
                        LinearLayout layoutError = ((ItemCameraPreviewBinding) this.this$0.getBinding()).layoutError;
                        Intrinsics.checkNotNullExpressionValue(layoutError, "layoutError");
                        ViewKt.visible(layoutError);
                    }
                }
            });
        }
    }
}
