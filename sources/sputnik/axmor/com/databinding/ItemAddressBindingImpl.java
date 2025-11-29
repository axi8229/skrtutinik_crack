package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.addresses.UserAddress;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemAddressBindingImpl extends ItemAddressBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_item, 2);
        sparseIntArray.put(R.id.iv_status, 3);
        sparseIntArray.put(R.id.iv_checked, 4);
        sparseIntArray.put(R.id.btn_unbind, 5);
    }

    public ItemAddressBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, null, sViewsWithIds));
    }

    private ItemAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[4], (ImageView) objArr[3], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.relativeLayout3.setTag(null);
        this.tvAddress.setTag(null);
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
        setItem((UserAddress) obj);
        return true;
    }

    public void setItem(UserAddress userAddress) {
        this.mItem = userAddress;
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
        UserAddress userAddress = this.mItem;
        long j2 = j & 3;
        String fullAddressWithApartment = (j2 == 0 || userAddress == null) ? null : userAddress.getFullAddressWithApartment();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvAddress, fullAddressWithApartment);
        }
    }
}
