package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogNoPermissionsBinding implements ViewBinding {
    public final TextView btnAccept;
    public final TextView btnDecline;
    public final LinearLayout layoutButtons;
    private final FrameLayout rootView;
    public final TextView tvMessage;
    public final TextView tvTitle;

    private DialogNoPermissionsBinding(FrameLayout frameLayout, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.btnAccept = textView;
        this.btnDecline = textView2;
        this.layoutButtons = linearLayout;
        this.tvMessage = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogNoPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_no_permissions, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogNoPermissionsBinding bind(View view) {
        int i = R.id.btn_accept;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btn_accept);
        if (textView != null) {
            i = R.id.btn_decline;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.btn_decline);
            if (textView2 != null) {
                i = R.id.layout_buttons;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_buttons);
                if (linearLayout != null) {
                    i = R.id.tv_message;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_message);
                    if (textView3 != null) {
                        i = R.id.tv_title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView4 != null) {
                            return new DialogNoPermissionsBinding((FrameLayout) view, textView, textView2, linearLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
