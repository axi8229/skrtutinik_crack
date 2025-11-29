package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.camera.Camera;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemCameraPreviewBindingImpl extends ItemCameraPreviewBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_camera_image, 2);
        sparseIntArray.put(R.id.linearLayout10, 3);
        sparseIntArray.put(R.id.view_dim, 4);
        sparseIntArray.put(R.id.iv_locked, 5);
        sparseIntArray.put(R.id.layout_error, 6);
        sparseIntArray.put(R.id.iv_no_image, 7);
    }

    public ItemCameraPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, null, sViewsWithIds));
    }

    private ItemCameraPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[5], (ImageView) objArr[7], (LinearLayout) objArr[6], (LinearLayout) objArr[3], (TextView) objArr[1], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        this.tvCameraName.setTag(null);
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Camera camera = this.mItem;
        long j2 = j & 3;
        String title = (j2 == 0 || camera == null) ? null : camera.getTitle();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvCameraName, title);
        }
    }
}
