package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.slider.Slider;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentBleServiceBindingImpl extends FragmentBleServiceBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final LinearLayout mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.service_waiting, 3);
        sparseIntArray.put(R.id.layout_info, 4);
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.layout_loader, 6);
        sparseIntArray.put(R.id.view_main, 7);
        sparseIntArray.put(R.id.layout_beta, 8);
        sparseIntArray.put(R.id.tv_beta, 9);
        sparseIntArray.put(R.id.imageView8, 10);
        sparseIntArray.put(R.id.imageView9, 11);
        sparseIntArray.put(R.id.imageView15, 12);
        sparseIntArray.put(R.id.tv_title, 13);
        sparseIntArray.put(R.id.layout_card, 14);
        sparseIntArray.put(R.id.tv_ble_enabled_title, 15);
        sparseIntArray.put(R.id.switch_ble, 16);
        sparseIntArray.put(R.id.layout_permissions, 17);
        sparseIntArray.put(R.id.constraintLayout3, 18);
        sparseIntArray.put(R.id.imageView2, 19);
        sparseIntArray.put(R.id.tv_attention, 20);
        sparseIntArray.put(R.id.btn_setup_permissions, 21);
        sparseIntArray.put(R.id.tv_rssi_title, 22);
        sparseIntArray.put(R.id.tv_rssi_description, 23);
        sparseIntArray.put(R.id.btn_setup_rssi, 24);
        sparseIntArray.put(R.id.tv_distance_title, 25);
        sparseIntArray.put(R.id.tv_distance_description, 26);
        sparseIntArray.put(R.id.slider, 27);
        sparseIntArray.put(R.id.layout_slider_hints, 28);
        sparseIntArray.put(R.id.tv_distance_near, 29);
        sparseIntArray.put(R.id.tv_distance_long, 30);
        sparseIntArray.put(R.id.tv_ble_promo_title, 31);
        sparseIntArray.put(R.id.switch_ble_promo, 32);
        sparseIntArray.put(R.id.subsSettingsButton, 33);
    }

    public FragmentBleServiceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 34, null, sViewsWithIds));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private FragmentBleServiceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        AppCompatButton appCompatButton = (AppCompatButton) objArr[21];
        AppCompatButton appCompatButton2 = (AppCompatButton) objArr[24];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[18];
        ImageView imageView = (ImageView) objArr[12];
        ImageView imageView2 = (ImageView) objArr[19];
        ImageView imageView3 = (ImageView) objArr[10];
        ImageView imageView4 = (ImageView) objArr[11];
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[8];
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[14];
        Object obj = objArr[4];
        LayoutInfoServiceBinding layoutInfoServiceBindingBind = obj != null ? LayoutInfoServiceBinding.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) objArr[6];
        ConstraintLayout constraintLayout4 = (ConstraintLayout) objArr[17];
        LinearLayout linearLayout2 = (LinearLayout) objArr[28];
        LinearLayout linearLayout3 = (LinearLayout) objArr[2];
        Object obj2 = objArr[3];
        super(dataBindingComponent, view, 0, appCompatButton, appCompatButton2, constraintLayout, imageView, imageView2, imageView3, imageView4, constraintLayout2, constraintLayout3, layoutInfoServiceBindingBind, linearLayout, constraintLayout4, linearLayout2, linearLayout3, obj2 != null ? WaintingSubscriptionScreenBinding.bind((View) obj2) : null, (Slider) objArr[27], (AppCompatButton) objArr[33], (SwitchCompat) objArr[16], (SwitchCompat) objArr[32], (Toolbar) objArr[5], (TextView) objArr[20], (TextView) objArr[9], (TextView) objArr[15], (TextView) objArr[31], (TextView) objArr[26], (TextView) objArr[30], (TextView) objArr[29], (TextView) objArr[25], (TextView) objArr[23], (TextView) objArr[22], (TextView) objArr[13], (ScrollView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.linearLayout8.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout4;
        linearLayout4.setTag(null);
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
