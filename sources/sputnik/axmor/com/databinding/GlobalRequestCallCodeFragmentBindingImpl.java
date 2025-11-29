package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.CallCodeViewState;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class GlobalRequestCallCodeFragmentBindingImpl extends GlobalRequestCallCodeFragmentBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.login_input_container, 3);
        sparseIntArray.put(R.id.tvTitle, 4);
        sparseIntArray.put(R.id.tvInfo, 5);
        sparseIntArray.put(R.id.tvErrorCode, 6);
        sparseIntArray.put(R.id.loader, 7);
    }

    public GlobalRequestCallCodeFragmentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, null, sViewsWithIds));
    }

    private GlobalRequestCallCodeFragmentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (LinearLayout) objArr[7], (LinearLayout) objArr[3], (Toolbar) objArr[2], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.btnLoginBySMS.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        setItem((CallCodeViewState) obj);
        return true;
    }

    public void setItem(CallCodeViewState callCodeViewState) {
        this.mItem = callCodeViewState;
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
        CallCodeViewState callCodeViewState = this.mItem;
        long j2 = j & 3;
        boolean needSendSms = (j2 == 0 || callCodeViewState == null) ? false : callCodeViewState.getNeedSendSms();
        if (j2 != 0) {
            ViewBindingUtilsKt.visibilityBasedOn(this.btnLoginBySMS, Boolean.valueOf(needSendSms));
        }
    }
}
