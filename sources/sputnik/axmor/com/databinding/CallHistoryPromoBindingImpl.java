package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class CallHistoryPromoBindingImpl extends CallHistoryPromoBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_visits_info, 1);
        sparseIntArray.put(R.id.imageView16, 2);
        sparseIntArray.put(R.id.imageView17, 3);
        sparseIntArray.put(R.id.imageView18, 4);
        sparseIntArray.put(R.id.imageView19, 5);
        sparseIntArray.put(R.id.imageView20, 6);
        sparseIntArray.put(R.id.imageView21, 7);
        sparseIntArray.put(R.id.tv_promo_1, 8);
        sparseIntArray.put(R.id.tv_promo_2, 9);
        sparseIntArray.put(R.id.btn_subscribe, 10);
    }

    public CallHistoryPromoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, null, sViewsWithIds));
    }

    private CallHistoryPromoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[10], (ImageView) objArr[2], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[6], (ImageView) objArr[7], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
