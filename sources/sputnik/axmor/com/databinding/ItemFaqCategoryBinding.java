package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.faq.FaqItem;

/* loaded from: classes5.dex */
public abstract class ItemFaqCategoryBinding extends ViewDataBinding {
    public final ImageView ivArrow;
    public final ConstraintLayout layoutTv;
    protected FaqItem mItem;
    public final ConstraintLayout relativeLayout2;
    public final TextView tvQuestion;
    public final View vDividerCameras;

    protected ItemFaqCategoryBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, View view2) {
        super(obj, view, i);
        this.ivArrow = imageView;
        this.layoutTv = constraintLayout;
        this.relativeLayout2 = constraintLayout2;
        this.tvQuestion = textView;
        this.vDividerCameras = view2;
    }
}
