package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.market.items.MarketItem;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemMarketKeyBindingImpl extends ItemMarketKeyBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.tv_subtitle, 2);
        sparseIntArray.put(R.id.imageView23, 3);
        sparseIntArray.put(R.id.tv_open_catalog, 4);
    }

    public ItemMarketKeyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, null, sViewsWithIds));
    }

    private ItemMarketKeyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.cardRoot.setTag(null);
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
        setItem((MarketItem) obj);
        return true;
    }

    public void setItem(MarketItem marketItem) {
        this.mItem = marketItem;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
