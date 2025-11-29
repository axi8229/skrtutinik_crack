package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BlockedFragmentBinding implements ViewBinding {
    public final TextView buttonExit;
    public final ImageView ivLock;
    private final ConstraintLayout rootView;
    public final TextView tvReason;
    public final TextView tvTitle;

    private BlockedFragmentBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonExit = textView;
        this.ivLock = imageView;
        this.tvReason = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlockedFragmentBinding bind(View view) {
        int i = R.id.button_exit;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.button_exit);
        if (textView != null) {
            i = R.id.iv_lock;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_lock);
            if (imageView != null) {
                i = R.id.tv_reason;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reason);
                if (textView2 != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView3 != null) {
                        return new BlockedFragmentBinding((ConstraintLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
