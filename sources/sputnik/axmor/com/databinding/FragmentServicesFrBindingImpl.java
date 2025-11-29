package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentServicesFrBindingImpl extends FragmentServicesFrBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.service_waiting, 2);
        sparseIntArray.put(R.id.info_layout, 3);
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.serviceLoader, 5);
        sparseIntArray.put(R.id.viewMain, 6);
        sparseIntArray.put(R.id.l_main_info_service, 7);
        sparseIntArray.put(R.id.tvMainInfoService, 8);
        sparseIntArray.put(R.id.btnServiceUpdate, 9);
        sparseIntArray.put(R.id.btnServiceDelete, 10);
        sparseIntArray.put(R.id.subsSettingsButton, 11);
    }

    public FragmentServicesFrBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, null, sViewsWithIds));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private FragmentServicesFrBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        AppCompatButton appCompatButton = (AppCompatButton) objArr[10];
        AppCompatButton appCompatButton2 = (AppCompatButton) objArr[9];
        Object obj = objArr[3];
        LayoutInfoServiceBinding layoutInfoServiceBindingBind = obj != null ? LayoutInfoServiceBinding.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) objArr[7];
        LinearLayout linearLayout2 = (LinearLayout) objArr[5];
        Object obj2 = objArr[2];
        super(dataBindingComponent, view, 0, appCompatButton, appCompatButton2, layoutInfoServiceBindingBind, linearLayout, linearLayout2, obj2 != null ? WaintingSubscriptionScreenBinding.bind((View) obj2) : null, (AppCompatButton) objArr[11], (Toolbar) objArr[4], (TextView) objArr[8], (ScrollView) objArr[6]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout3 = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout3;
        linearLayout3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
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
