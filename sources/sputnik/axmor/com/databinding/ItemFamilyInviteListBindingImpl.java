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
import com.sputnik.common.entities.invites.FamilyInvite;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemFamilyInviteListBindingImpl extends ItemFamilyInviteListBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.relativeLayout3, 3);
        sparseIntArray.put(R.id.entryPhoto, 4);
    }

    public ItemFamilyInviteListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, null, sViewsWithIds));
    }

    private ItemFamilyInviteListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (ImageView) objArr[4], (ConstraintLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        this.entryName.setTag(null);
        this.entryPhone.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
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
        setItem((FamilyInvite) obj);
        return true;
    }

    public void setItem(FamilyInvite familyInvite) {
        this.mItem = familyInvite;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String string;
        String phone;
        String stateHuman;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FamilyInvite familyInvite = this.mItem;
        long j2 = j & 3;
        if (j2 != 0) {
            if (familyInvite != null) {
                phone = familyInvite.getPhone();
                stateHuman = familyInvite.getStateHuman();
            } else {
                phone = null;
                stateHuman = null;
            }
            String str = phone;
            string = stateHuman != null ? stateHuman.toString() : null;
            str = str;
        } else {
            string = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.entryName, str);
            TextViewBindingAdapter.setText(this.entryPhone, string);
        }
    }
}
