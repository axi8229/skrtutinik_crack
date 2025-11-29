package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.sputnik.ui.polls.adapters.ReasonItem;

/* loaded from: classes5.dex */
public abstract class ItemPollReasonBinding extends ViewDataBinding {
    public final CheckBox cbChecked;
    public final ConstraintLayout layoutContent;
    protected ReasonItem mItem;
    public final TextView tvSelectedCategoryTitle;

    protected ItemPollReasonBinding(Object obj, View view, int i, CheckBox checkBox, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.cbChecked = checkBox;
        this.layoutContent = constraintLayout;
        this.tvSelectedCategoryTitle = textView;
    }
}
