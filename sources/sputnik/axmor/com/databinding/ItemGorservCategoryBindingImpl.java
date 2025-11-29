package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.gorserv.GorservCatalog;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemGorservCategoryBindingImpl extends ItemGorservCategoryBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 2);
        sparseIntArray.put(R.id.imageView13, 3);
    }

    public ItemGorservCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, null, sViewsWithIds));
    }

    private ItemGorservCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[2], (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
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
        setItem((GorservCatalog) obj);
        return true;
    }

    public void setItem(GorservCatalog gorservCatalog) {
        this.mItem = gorservCatalog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        GorservCatalog gorservCatalog = this.mItem;
        long j2 = j & 3;
        String title = (j2 == 0 || gorservCatalog == null) ? null : gorservCatalog.getTitle();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvSelectedCategoryTitle, title);
        }
    }
}
