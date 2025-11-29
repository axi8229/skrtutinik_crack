package com.sputnik.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.sputnik.common.R$id;

/* loaded from: classes3.dex */
public class DialogErrorSplashBindingImpl extends DialogErrorSplashBinding {
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
        sparseIntArray.put(R$id.error_name, 1);
        sparseIntArray.put(R$id.error_advice, 2);
        sparseIntArray.put(R$id.btn_repeat, 3);
    }

    public DialogErrorSplashBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, null, sViewsWithIds));
    }

    private DialogErrorSplashBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
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
