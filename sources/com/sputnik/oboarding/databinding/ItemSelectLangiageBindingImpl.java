package com.sputnik.oboarding.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.oboarding.BR;

/* loaded from: classes3.dex */
public class ItemSelectLangiageBindingImpl extends ItemSelectLangiageBinding {
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemSelectLangiageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, null, sViewsWithIds));
    }

    private ItemSelectLangiageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (ImageView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.choosingLanguage.setTag(null);
        this.ivSelected.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        setItem((Localization) obj);
        return true;
    }

    public void setItem(Localization localization) {
        this.mItem = localization;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean current;
        String name;
        int flag;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Localization localization = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || localization == null) {
            current = false;
            name = null;
            flag = 0;
        } else {
            name = localization.getName();
            current = localization.getCurrent();
            flag = localization.getFlag();
        }
        if (j2 != 0) {
            ViewBindingUtilsKt.startImage(this.choosingLanguage, flag);
            TextViewBindingAdapter.setText(this.choosingLanguage, name);
            ViewBindingUtilsKt.visibilityHideBasedOn(this.ivSelected, current);
        }
    }
}
