package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.faq.FaqItem;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemFaqCategoryBindingImpl extends ItemFaqCategoryBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_tv, 2);
        sparseIntArray.put(R.id.iv_arrow, 3);
        sparseIntArray.put(R.id.v_divider_cameras, 4);
    }

    public ItemFaqCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, null, sViewsWithIds));
    }

    private ItemFaqCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[0], (TextView) objArr[1], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        this.relativeLayout2.setTag(null);
        this.tvQuestion.setTag(null);
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
        setItem((FaqItem) obj);
        return true;
    }

    public void setItem(FaqItem faqItem) {
        this.mItem = faqItem;
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
        FaqItem faqItem = this.mItem;
        long j2 = j & 3;
        String title = (j2 == 0 || faqItem == null) ? null : faqItem.getTitle();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvQuestion, title);
        }
    }
}
