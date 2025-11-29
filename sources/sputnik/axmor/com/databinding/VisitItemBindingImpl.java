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
import com.sputnik.common.utils.ViewBindingUtilsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;

/* loaded from: classes5.dex */
public class VisitItemBindingImpl extends VisitItemBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_archive, 5);
        sparseIntArray.put(R.id.divider_h, 6);
    }

    public VisitItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, null, sViewsWithIds));
    }

    private VisitItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[6], (ImageView) objArr[5], (ImageView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.ivPhoneCall.setTag(null);
        this.ivVisitorItem.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvAdressVisitItem.setTag(null);
        this.tvTimeVisitItem.setTag(null);
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
        setItem((CallHistory) obj);
        return true;
    }

    public void setItem(CallHistory callHistory) {
        this.mItem = callHistory;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String imageUrl;
        boolean zIsCallDeclined;
        String address;
        String creationDate;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        CallHistory callHistory = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || callHistory == null) {
            imageUrl = null;
            zIsCallDeclined = false;
            address = null;
            creationDate = null;
        } else {
            imageUrl = callHistory.getImageUrl();
            address = callHistory.getAddress();
            zIsCallDeclined = callHistory.isCallDeclined();
            creationDate = callHistory.getCreationDate();
        }
        if (j2 != 0) {
            ViewBindingUtilsKt.visibilityBasedOn(this.ivPhoneCall, Boolean.valueOf(zIsCallDeclined));
            ImageView imageView = this.ivVisitorItem;
            sputnik.axmor.com.sputnik.utils.ViewBindingUtilsKt.setRectangleImageUrlWithPlaceHolder(imageView, imageUrl, AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_group_image));
            TextViewBindingAdapter.setText(this.tvAdressVisitItem, address);
            TextViewBindingAdapter.setText(this.tvTimeVisitItem, creationDate);
            if (ViewDataBinding.getBuildSdkInt() >= 21) {
                this.ivVisitorItem.setTransitionName(imageUrl);
            }
        }
    }
}
