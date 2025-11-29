package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentCancelAutoPaymentBindingImpl extends FragmentCancelAutoPaymentBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 1);
        sparseIntArray.put(R.id.radio_group, 2);
        sparseIntArray.put(R.id.rb_no_props, 3);
        sparseIntArray.put(R.id.rb_no_confident, 4);
        sparseIntArray.put(R.id.rb_no_error, 5);
        sparseIntArray.put(R.id.rb_no_other_reason, 6);
        sparseIntArray.put(R.id.l_other_reason, 7);
        sparseIntArray.put(R.id.et_reason, 8);
        sparseIntArray.put(R.id.btn_no_cancel, 9);
        sparseIntArray.put(R.id.btn_cancel, 10);
    }

    public FragmentCancelAutoPaymentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, null, sViewsWithIds));
    }

    private FragmentCancelAutoPaymentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[10], (Button) objArr[9], (EditText) objArr[8], (TextView) objArr[1], (LinearLayout) objArr[7], (RadioGroup) objArr[2], (RadioButton) objArr[4], (RadioButton) objArr[5], (RadioButton) objArr[6], (RadioButton) objArr[3]);
        this.mDirtyFlags = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
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
