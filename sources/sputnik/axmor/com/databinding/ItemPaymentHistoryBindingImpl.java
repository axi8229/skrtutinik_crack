package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemPaymentHistoryBindingImpl extends ItemPaymentHistoryBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final MaterialCardView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.payment_intercom, 1);
        sparseIntArray.put(R.id.price_payment, 2);
        sparseIntArray.put(R.id.divider_horizontal, 3);
        sparseIntArray.put(R.id.tv_account_bill, 4);
        sparseIntArray.put(R.id.tv_account_number, 5);
    }

    public ItemPaymentHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, null, sViewsWithIds));
    }

    private ItemPaymentHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[3], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        MaterialCardView materialCardView = (MaterialCardView) objArr[0];
        this.mboundView0 = materialCardView;
        materialCardView.setTag(null);
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
