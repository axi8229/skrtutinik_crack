package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.IconButton;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentKeyManageBinding implements ViewBinding {
    public final IconButton btnBlockUnblock;
    public final IconButton btnDelete;
    public final AppCompatButton btnSave;
    public final EditText etKeyComment;
    public final ImageView ivKeyStatus;
    public final LinearLayout layoutRegisterKey;
    public final LinearLayout layoutViews;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final Toolbar toolbar;
    public final TextView tvKeyComment;
    public final TextView tvKeyCommentHint;
    public final TextView tvKeyHex;

    private FragmentKeyManageBinding(ConstraintLayout constraintLayout, IconButton iconButton, IconButton iconButton2, AppCompatButton appCompatButton, EditText editText, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView_ = constraintLayout;
        this.btnBlockUnblock = iconButton;
        this.btnDelete = iconButton2;
        this.btnSave = appCompatButton;
        this.etKeyComment = editText;
        this.ivKeyStatus = imageView;
        this.layoutRegisterKey = linearLayout;
        this.layoutViews = linearLayout2;
        this.rootView = constraintLayout2;
        this.toolbar = toolbar;
        this.tvKeyComment = textView;
        this.tvKeyCommentHint = textView2;
        this.tvKeyHex = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentKeyManageBinding bind(View view) {
        int i = R.id.btn_block_unblock;
        IconButton iconButton = (IconButton) ViewBindings.findChildViewById(view, R.id.btn_block_unblock);
        if (iconButton != null) {
            i = R.id.btn_delete;
            IconButton iconButton2 = (IconButton) ViewBindings.findChildViewById(view, R.id.btn_delete);
            if (iconButton2 != null) {
                i = R.id.btn_save;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_save);
                if (appCompatButton != null) {
                    i = R.id.et_key_comment;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_key_comment);
                    if (editText != null) {
                        i = R.id.iv_key_status;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_key_status);
                        if (imageView != null) {
                            i = R.id.layout_register_key;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_register_key);
                            if (linearLayout != null) {
                                i = R.id.layout_views;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_views);
                                if (linearLayout2 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i = R.id.tv_key_comment;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_comment);
                                        if (textView != null) {
                                            i = R.id.tv_key_comment_hint;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_comment_hint);
                                            if (textView2 != null) {
                                                i = R.id.tv_key_hex;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_hex);
                                                if (textView3 != null) {
                                                    return new FragmentKeyManageBinding(constraintLayout, iconButton, iconButton2, appCompatButton, editText, imageView, linearLayout, linearLayout2, constraintLayout, toolbar, textView, textView2, textView3);
                                                }
                                            }
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
