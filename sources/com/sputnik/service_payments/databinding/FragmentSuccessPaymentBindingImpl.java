package com.sputnik.service_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public class FragmentSuccessPaymentBindingImpl extends FragmentSuccessPaymentBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.pb_loader, 1);
        sparseIntArray.put(R$id.iv_success_payment, 2);
        sparseIntArray.put(R$id.tv_success_payment, 3);
        sparseIntArray.put(R$id.btn_share_or_save, 4);
        sparseIntArray.put(R$id.btn_divider, 5);
        sparseIntArray.put(R$id.btn_add_sub, 6);
        sparseIntArray.put(R$id.btn_cancel, 7);
        sparseIntArray.put(R$id.btn_go_to_profile, 8);
        sparseIntArray.put(R$id.gr_new_subscription, 9);
    }

    public FragmentSuccessPaymentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, null, sViewsWithIds));
    }

    private FragmentSuccessPaymentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[6], (AppCompatButton) objArr[7], (View) objArr[5], (AppCompatButton) objArr[8], (TextView) objArr[4], (Group) objArr[9], (ImageView) objArr[2], (ProgressBar) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
