package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.camera.Camera;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.utils.ViewBindingUtilsKt;

/* loaded from: classes5.dex */
public class RecyclerViewCameraItemBindingImpl extends RecyclerViewCameraItemBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_hamburger, 6);
        sparseIntArray.put(R.id.divider_h, 7);
    }

    public RecyclerViewCameraItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, null, sViewsWithIds));
    }

    private RecyclerViewCameraItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[7], (ImageView) objArr[1], (ImageView) objArr[6], (ImageView) objArr[4], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.ivCameraImage.setTag(null);
        this.ivLocked.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvCameraAddress.setTag(null);
        this.tvCameraName.setTag(null);
        this.tvOrderNumber.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        setItem((Camera) obj);
        return true;
    }

    public void setItem(Camera camera) {
        this.mItem = camera;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String title;
        String address;
        String string;
        Boolean bool;
        String previewUrl;
        Boolean subscriptionRequried;
        String transitionName;
        Integer order;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Camera camera = this.mItem;
        long j2 = j & 3;
        if (j2 != 0) {
            if (camera != null) {
                title = camera.getTitle();
                address = camera.getAddress();
                transitionName = camera.getTransitionName();
                order = camera.getOrder();
                previewUrl = camera.getPreviewUrl();
                subscriptionRequried = camera.getSubscriptionRequried();
            } else {
                title = null;
                address = null;
                subscriptionRequried = null;
                transitionName = null;
                order = null;
                previewUrl = null;
            }
            Boolean bool2 = subscriptionRequried;
            string = order != null ? order.toString() : null;
            str = transitionName;
            bool = bool2;
        } else {
            title = null;
            address = null;
            string = null;
            bool = null;
            previewUrl = null;
        }
        if (j2 != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 21) {
                this.ivCameraImage.setTransitionName(str);
            }
            ImageView imageView = this.ivCameraImage;
            ViewBindingUtilsKt.setCircleImageUrlSquareWithPlaceHolder(imageView, previewUrl, AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_camera_placeholder_solid));
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(this.ivLocked, bool);
            TextViewBindingAdapter.setText(this.tvCameraAddress, address);
            TextViewBindingAdapter.setText(this.tvCameraName, title);
            TextViewBindingAdapter.setText(this.tvOrderNumber, string);
        }
    }
}
