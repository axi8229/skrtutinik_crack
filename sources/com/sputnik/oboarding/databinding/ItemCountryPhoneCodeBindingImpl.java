package com.sputnik.oboarding.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.oboarding.BR;

/* loaded from: classes3.dex */
public class ItemCountryPhoneCodeBindingImpl extends ItemCountryPhoneCodeBinding {
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemCountryPhoneCodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, null, sViewsWithIds));
    }

    private ItemCountryPhoneCodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvCountryNameItem.setTag(null);
        this.tvSelectedCategoryTitle.setTag(null);
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
        if (BR.item != i) {
            return false;
        }
        setItem((CountryCode) obj);
        return true;
    }

    public void setItem(CountryCode countryCode) {
        this.mItem = countryCode;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String name;
        String code;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        CountryCode countryCode = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || countryCode == null) {
            name = null;
            code = null;
        } else {
            name = countryCode.getName();
            code = countryCode.getCode();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvCountryNameItem, name);
            TextViewBindingAdapter.setText(this.tvSelectedCategoryTitle, code);
        }
    }
}
