package sputnik.axmor.com.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.sputnik.common.entities.faq.FaqQuestion;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public class ItemFaqBindingImpl extends ItemFaqBinding {
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_tv, 4);
        sparseIntArray.put(R.id.iv_arrow, 5);
        sparseIntArray.put(R.id.layout_expand, 6);
        sparseIntArray.put(R.id.v_divider_cameras, 7);
    }

    public ItemFaqBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, null, sViewsWithIds));
    }

    private ItemFaqBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatButton) objArr[3], (ImageView) objArr[5], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[0], (TextView) objArr[2], (TextView) objArr[1], (View) objArr[7]);
        this.mDirtyFlags = -1L;
        this.btnAnswer.setTag(null);
        this.relativeLayout2.setTag(null);
        this.tvAnswer.setTag(null);
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
        setItem((FaqQuestion) obj);
        return true;
    }

    public void setItem(FaqQuestion faqQuestion) {
        this.mItem = faqQuestion;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String question;
        String answer;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FaqQuestion faqQuestion = this.mItem;
        long j2 = j & 3;
        if (j2 == 0 || faqQuestion == null) {
            question = null;
            answer = null;
        } else {
            question = faqQuestion.getQuestion();
            answer = faqQuestion.getAnswer();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.btnAnswer, answer);
            TextViewBindingAdapter.setText(this.tvAnswer, answer);
            TextViewBindingAdapter.setText(this.tvQuestion, question);
        }
    }
}
