package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import sputnik.axmor.com.sputnik.ui.polls.adapters.ReasonItem;

/* loaded from: classes5.dex */
public class ItemPollReasonBindingImpl extends ItemPollReasonBinding {
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemPollReasonBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, null, sViewsWithIds));
    }

    private ItemPollReasonBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[2], (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.cbChecked.setTag(null);
        this.layoutContent.setTag(null);
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
        if (1 != i) {
            return false;
        }
        setItem((ReasonItem) obj);
        return true;
    }

    public void setItem(ReasonItem reasonItem) {
        this.mItem = reasonItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String title;
        boolean isChecked;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ReasonItem reasonItem = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || reasonItem == null) {
            title = null;
            isChecked = false;
        } else {
            title = reasonItem.getTitle();
            isChecked = reasonItem.getIsChecked();
        }
        if (j2 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.cbChecked, isChecked);
            TextViewBindingAdapter.setText(this.tvSelectedCategoryTitle, title);
        }
    }
}
