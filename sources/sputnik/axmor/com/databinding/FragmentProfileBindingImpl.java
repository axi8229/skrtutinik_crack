package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentProfileBindingImpl extends FragmentProfileBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.button_exit, 2);
        sparseIntArray.put(R.id.scroll_view, 3);
        sparseIntArray.put(R.id.main_layout, 4);
        sparseIntArray.put(R.id.ivPhoto, 5);
        sparseIntArray.put(R.id.tv_change_avatar_description, 6);
        sparseIntArray.put(R.id.et_name_title, 7);
        sparseIntArray.put(R.id.tvName, 8);
        sparseIntArray.put(R.id.et_phone_title, 9);
        sparseIntArray.put(R.id.tvPhone, 10);
        sparseIntArray.put(R.id.layout_sub, 11);
        sparseIntArray.put(R.id.tv_sub_title, 12);
        sparseIntArray.put(R.id.card_root, 13);
        sparseIntArray.put(R.id.l_addition, 14);
        sparseIntArray.put(R.id.tv_subscription_title, 15);
        sparseIntArray.put(R.id.tv_subscription_payed_until, 16);
        sparseIntArray.put(R.id.tv_subscription_price, 17);
        sparseIntArray.put(R.id.divider, 18);
        sparseIntArray.put(R.id.linearLayout2, 19);
        sparseIntArray.put(R.id.btnApply, 20);
        sparseIntArray.put(R.id.btnDelete, 21);
        sparseIntArray.put(R.id.profileLoader, 22);
    }

    public FragmentProfileBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, null, sViewsWithIds));
    }

    private FragmentProfileBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[20], (AppCompatButton) objArr[21], (TextView) objArr[2], (ConstraintLayout) objArr[13], (View) objArr[18], (TextView) objArr[7], (TextView) objArr[9], (ImageView) objArr[5], (LinearLayout) objArr[14], (ConstraintLayout) objArr[11], (LinearLayout) objArr[19], (LinearLayout) objArr[4], (LinearLayout) objArr[22], (ScrollView) objArr[3], (Toolbar) objArr[1], (TextView) objArr[6], (EditText) objArr[8], (EditText) objArr[10], (TextView) objArr[12], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
