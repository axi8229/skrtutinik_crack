package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.notifications.Notification;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemNotificationBindingImpl extends ItemNotificationBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_tv, 3);
        sparseIntArray.put(R.id.view, 4);
        sparseIntArray.put(R.id.constraintLayout6, 5);
        sparseIntArray.put(R.id.linearLayout6, 6);
        sparseIntArray.put(R.id.entryPhone, 7);
        sparseIntArray.put(R.id.v_divider_cameras, 8);
    }

    public ItemNotificationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, null, sViewsWithIds));
    }

    private ItemNotificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[5], (TextView) objArr[2], (TextView) objArr[7], (ConstraintLayout) objArr[3], (LinearLayout) objArr[6], (ConstraintLayout) objArr[0], (TextView) objArr[1], (View) objArr[8], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        this.entryName.setTag(null);
        this.relativeLayout2.setTag(null);
        this.tvType.setTag(null);
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
        setItem((Notification) obj);
        return true;
    }

    public void setItem(Notification notification) {
        this.mItem = notification;
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
        String identifierHuman;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Notification notification = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || notification == null) {
            title = null;
            identifierHuman = null;
        } else {
            title = notification.getTitle();
            identifierHuman = notification.getIdentifierHuman();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.entryName, title);
            TextViewBindingAdapter.setText(this.tvType, identifierHuman);
        }
    }
}
