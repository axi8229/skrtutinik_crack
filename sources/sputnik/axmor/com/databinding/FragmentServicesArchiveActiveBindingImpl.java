package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentServicesArchiveActiveBindingImpl extends FragmentServicesArchiveActiveBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ConstraintLayout mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.service_waiting, 3);
        sparseIntArray.put(R.id.info_layout, 4);
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.serviceLoader, 6);
        sparseIntArray.put(R.id.viewMain, 7);
        sparseIntArray.put(R.id.l_main_info_service, 8);
        sparseIntArray.put(R.id.tvMainInfoService, 9);
        sparseIntArray.put(R.id.btnServiceUpdate, 10);
        sparseIntArray.put(R.id.subsSettingsButton, 11);
    }

    public FragmentServicesArchiveActiveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, null, sViewsWithIds));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private FragmentServicesArchiveActiveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        AppCompatButton appCompatButton = (AppCompatButton) objArr[10];
        Object obj = objArr[4];
        LayoutInfoServiceBinding layoutInfoServiceBindingBind = obj != null ? LayoutInfoServiceBinding.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        LinearLayout linearLayout2 = (LinearLayout) objArr[6];
        Object obj2 = objArr[3];
        super(dataBindingComponent, view, 0, appCompatButton, layoutInfoServiceBindingBind, linearLayout, linearLayout2, obj2 != null ? WaintingSubscriptionScreenBinding.bind((View) obj2) : null, (AppCompatButton) objArr[11], (Toolbar) objArr[5], (TextView) objArr[9], (ScrollView) objArr[7]);
        this.mDirtyFlags = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout3;
        linearLayout3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[2];
        this.mboundView2 = constraintLayout;
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
