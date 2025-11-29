package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.keys.PhysicalKey;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemKeyBindingImpl extends ItemKeyBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.relativeLayout3, 3);
        sparseIntArray.put(R.id.iv_status, 4);
    }

    public ItemKeyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, null, sViewsWithIds));
    }

    private ItemKeyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ConstraintLayout) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        this.tvAddress.setTag(null);
        this.tvKeyHex.setTag(null);
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
        setItem((PhysicalKey) obj);
        return true;
    }

    public void setItem(PhysicalKey physicalKey) {
        this.mItem = physicalKey;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String formattedHex;
        String comment;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PhysicalKey physicalKey = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || physicalKey == null) {
            formattedHex = null;
            comment = null;
        } else {
            formattedHex = physicalKey.getFormattedHex();
            comment = physicalKey.getComment();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvAddress, comment);
            TextViewBindingAdapter.setText(this.tvKeyHex, formattedHex);
        }
    }
}
