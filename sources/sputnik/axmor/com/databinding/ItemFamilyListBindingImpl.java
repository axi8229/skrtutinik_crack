package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.utils.ViewBindingUtilsKt;

/* loaded from: classes5.dex */
public class ItemFamilyListBindingImpl extends ItemFamilyListBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.relativeLayout8, 6);
        sparseIntArray.put(R.id.layout_tv, 7);
    }

    public ItemFamilyListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, null, sViewsWithIds));
    }

    private ItemFamilyListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[5], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3], (LinearLayout) objArr[7], (ConstraintLayout) objArr[6]);
        this.mDirtyFlags = -1L;
        this.entryName.setTag(null);
        this.entryPhone.setTag(null);
        this.entryPhoto.setTag(null);
        this.isAdmin.setTag(null);
        this.isSelf.setTag(null);
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
        setItem((Family) obj);
        return true;
    }

    public void setItem(Family family) {
        this.mItem = family;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean isMe;
        String avatar;
        String phone;
        String fullName;
        boolean isAdmin;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Family family = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || family == null) {
            isMe = false;
            avatar = null;
            phone = null;
            fullName = null;
            isAdmin = false;
        } else {
            avatar = family.getAvatar();
            phone = family.getPhone();
            isMe = family.getIsMe();
            fullName = family.getFullName();
            isAdmin = family.getIsAdmin();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.entryName, fullName);
            TextViewBindingAdapter.setText(this.entryPhone, phone);
            ImageView imageView = this.entryPhoto;
            ViewBindingUtilsKt.setCircleImageUrlWithPlaceHolder(imageView, avatar, AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_group_image));
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(this.isAdmin, Boolean.valueOf(isAdmin));
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(this.isSelf, Boolean.valueOf(isMe));
        }
    }
}
