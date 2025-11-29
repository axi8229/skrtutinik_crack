package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class InsuranceServiceItemBindingImpl extends InsuranceServiceItemBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_label, 1);
        sparseIntArray.put(R.id.tv_partner_label, 2);
        sparseIntArray.put(R.id.iv_partner, 3);
        sparseIntArray.put(R.id.serviceName, 4);
        sparseIntArray.put(R.id.serviceDescription, 5);
        sparseIntArray.put(R.id.l_addition, 6);
        sparseIntArray.put(R.id.serviceAction, 7);
        sparseIntArray.put(R.id.serviceExpire, 8);
    }

    public InsuranceServiceItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, null, sViewsWithIds));
    }

    private InsuranceServiceItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (ImageView) objArr[3], (LinearLayout) objArr[6], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.cardRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
