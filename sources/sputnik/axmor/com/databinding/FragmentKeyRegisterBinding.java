package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentKeyRegisterBinding implements ViewBinding {
    public final AppCompatButton btnRegisterKey;
    public final EditText etKeyComment;
    public final EditText etKeyHex;
    public final ConstraintLayout layoutRegisterKey;
    public final LinearLayout layoutViews;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final Toolbar toolbar;
    public final TextView tvKeyComment;
    public final TextView tvKeyHex;
    public final TextView tvTitle;

    private FragmentKeyRegisterBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, EditText editText, EditText editText2, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView_ = constraintLayout;
        this.btnRegisterKey = appCompatButton;
        this.etKeyComment = editText;
        this.etKeyHex = editText2;
        this.layoutRegisterKey = constraintLayout2;
        this.layoutViews = linearLayout;
        this.rootView = constraintLayout3;
        this.toolbar = toolbar;
        this.tvKeyComment = textView;
        this.tvKeyHex = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentKeyRegisterBinding bind(View view) {
        int i = R.id.btn_register_key;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_register_key);
        if (appCompatButton != null) {
            i = R.id.et_key_comment;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_key_comment);
            if (editText != null) {
                i = R.id.et_key_hex;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_key_hex);
                if (editText2 != null) {
                    i = R.id.layout_register_key;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_register_key);
                    if (constraintLayout != null) {
                        i = R.id.layout_views;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_views);
                        if (linearLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                            if (toolbar != null) {
                                i = R.id.tv_key_comment;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_comment);
                                if (textView != null) {
                                    i = R.id.tv_key_hex;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_hex);
                                    if (textView2 != null) {
                                        i = R.id.tv_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                        if (textView3 != null) {
                                            return new FragmentKeyRegisterBinding(constraintLayout2, appCompatButton, editText, editText2, constraintLayout, linearLayout, constraintLayout2, toolbar, textView, textView2, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
