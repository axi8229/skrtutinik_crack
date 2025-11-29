package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class FragmentSettingsFamilyBindingImpl extends FragmentSettingsFamilyBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.layoutSwipeRefresh, 2);
        sparseIntArray.put(R.id.nestedScrollView3, 3);
        sparseIntArray.put(R.id.familyList, 4);
        sparseIntArray.put(R.id.layout_invites, 5);
        sparseIntArray.put(R.id.tv_invites_title, 6);
        sparseIntArray.put(R.id.tv_invites_empty, 7);
        sparseIntArray.put(R.id.rv_invites, 8);
        sparseIntArray.put(R.id.layout_actions, 9);
        sparseIntArray.put(R.id.layout_invites_actions, 10);
        sparseIntArray.put(R.id.tv_invites_count, 11);
        sparseIntArray.put(R.id.btn_invite, 12);
        sparseIntArray.put(R.id.layout_family_actions, 13);
        sparseIntArray.put(R.id.btn_leave_from_family, 14);
        sparseIntArray.put(R.id.loader, 15);
    }

    public FragmentSettingsFamilyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, null, sViewsWithIds));
    }

    private FragmentSettingsFamilyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[12], (AppCompatButton) objArr[14], (RecyclerView) objArr[4], (LinearLayout) objArr[9], (LinearLayout) objArr[13], (LinearLayout) objArr[5], (LinearLayout) objArr[10], (ConstraintLayout) objArr[0], (SwipeRefreshLayout) objArr[2], (LinearLayout) objArr[15], (NestedScrollView) objArr[3], (RecyclerView) objArr[8], (Toolbar) objArr[1], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.layoutRoot.setTag(null);
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
