package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.databinding.LayoutCompleteRegistrationBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentProfileNoIntercomBindingImpl extends FragmentProfileNoIntercomBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_complete_registration, 2);
        sparseIntArray.put(R.id.linearLayout3, 3);
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.toolbar_title, 5);
        sparseIntArray.put(R.id.button_notifications, 6);
        sparseIntArray.put(R.id.imageButton, 7);
        sparseIntArray.put(R.id.view_onboarding_notifications, 8);
        sparseIntArray.put(R.id.button_exit, 9);
        sparseIntArray.put(R.id.container, 10);
        sparseIntArray.put(R.id.user_layout, 11);
        sparseIntArray.put(R.id.settings_photo, 12);
        sparseIntArray.put(R.id.settings_fio, 13);
        sparseIntArray.put(R.id.tv_current_address, 14);
        sparseIntArray.put(R.id.settings_address, 15);
        sparseIntArray.put(R.id.l_add_address, 16);
        sparseIntArray.put(R.id.btnServiceUpdate, 17);
        sparseIntArray.put(R.id.layout_about_our_home, 18);
        sparseIntArray.put(R.id.tv_our_home_title, 19);
        sparseIntArray.put(R.id.tv_our_home_description, 20);
        sparseIntArray.put(R.id.imageView8, 21);
        sparseIntArray.put(R.id.settings_language, 22);
        sparseIntArray.put(R.id.settings_label, 23);
        sparseIntArray.put(R.id.settings_language_title, 24);
    }

    public FragmentProfileNoIntercomBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 25, null, sViewsWithIds));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private FragmentProfileNoIntercomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        AppCompatButton appCompatButton = (AppCompatButton) objArr[17];
        ImageButton imageButton = (ImageButton) objArr[9];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[6];
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        ImageButton imageButton2 = (ImageButton) objArr[7];
        ImageView imageView = (ImageView) objArr[21];
        LinearLayout linearLayout2 = (LinearLayout) objArr[16];
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[18];
        Object obj = objArr[2];
        super(dataBindingComponent, view, 0, appCompatButton, imageButton, constraintLayout, linearLayout, imageButton2, imageView, linearLayout2, constraintLayout2, obj != null ? LayoutCompleteRegistrationBinding.bind((View) obj) : null, (LinearLayout) objArr[3], (ScrollView) objArr[0], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[23], (LinearLayout) objArr[22], (TextView) objArr[24], (ImageView) objArr[12], (ConstraintLayout) objArr[4], (TextView) objArr[5], (TextView) objArr[14], (TextView) objArr[20], (TextView) objArr[19], (LinearLayout) objArr[11], (View) objArr[8]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout3;
        constraintLayout3.setTag(null);
        this.profileScroll.setTag(null);
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
