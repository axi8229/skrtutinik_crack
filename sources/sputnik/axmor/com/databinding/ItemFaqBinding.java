package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.faq.FaqQuestion;

/* loaded from: classes5.dex */
public abstract class ItemFaqBinding extends ViewDataBinding {
    public final AppCompatButton btnAnswer;
    public final ImageView ivArrow;
    public final ConstraintLayout layoutExpand;
    public final ConstraintLayout layoutTv;
    protected FaqQuestion mItem;
    public final ConstraintLayout relativeLayout2;
    public final TextView tvAnswer;
    public final TextView tvQuestion;
    public final View vDividerCameras;

    protected ItemFaqBinding(Object obj, View view, int i, AppCompatButton appCompatButton, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.btnAnswer = appCompatButton;
        this.ivArrow = imageView;
        this.layoutExpand = constraintLayout;
        this.layoutTv = constraintLayout2;
        this.relativeLayout2 = constraintLayout3;
        this.tvAnswer = textView;
        this.tvQuestion = textView2;
        this.vDividerCameras = view2;
    }
}
