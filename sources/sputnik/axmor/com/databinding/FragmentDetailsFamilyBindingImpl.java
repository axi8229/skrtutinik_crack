package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.utils.ViewBindingUtilsKt;

/* loaded from: classes5.dex */
public class FragmentDetailsFamilyBindingImpl extends FragmentDetailsFamilyBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.viewMain, 6);
        sparseIntArray.put(R.id.l_family_details, 7);
        sparseIntArray.put(R.id.btnMakeAdmin, 8);
        sparseIntArray.put(R.id.btnDelete, 9);
    }

    public FragmentDetailsFamilyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, null, sViewsWithIds));
    }

    private FragmentDetailsFamilyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[9], (AppCompatButton) objArr[8], (TextView) objArr[2], (TextView) objArr[3], (ImageView) objArr[1], (LinearLayout) objArr[4], (LinearLayout) objArr[7], (Toolbar) objArr[5], (ScrollView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.entryName.setTag(null);
        this.entryPhone.setTag(null);
        this.ivPhoto.setTag(null);
        this.lButtons.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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

    @Override // sputnik.axmor.com.databinding.FragmentDetailsFamilyBinding
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
        String avatar;
        boolean controlled;
        String phone;
        String fullName;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Family family = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || family == null) {
            avatar = null;
            controlled = false;
            phone = null;
            fullName = null;
        } else {
            avatar = family.getAvatar();
            controlled = family.getControlled();
            phone = family.getPhone();
            fullName = family.getFullName();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.entryName, fullName);
            TextViewBindingAdapter.setText(this.entryPhone, phone);
            ImageView imageView = this.ivPhoto;
            ViewBindingUtilsKt.setCircleImageUrlWithPlaceHolder(imageView, avatar, AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_group_image));
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityHideBasedOn(this.lButtons, controlled);
        }
    }
}
