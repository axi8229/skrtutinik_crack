package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSendGorservRequestBinding implements ViewBinding {
    public final ImageView btnAbout;
    public final ImageView btnBack;
    public final ImageView btnEditPhone;
    public final AppCompatButton btnSendRequest;
    public final ConstraintLayout constraintLayout7;
    public final EditText etComment;
    public final ImageView imageView14;
    public final ImageView ivIcon;
    public final ConstraintLayout layoutContent;
    public final LinearLayout layoutLoader;
    public final NestedScrollView nestedScrollView2;
    private final NestedScrollView rootView;
    public final ConstraintLayout toolbar;
    public final TextView tvCallHint;
    public final TextView tvCommentHint;
    public final TextView tvGorservTitle;
    public final TextView tvPhoneDetails;
    public final TextView tvSelectedCategoryTitle;
    public final TextView tvToolbarTitle;
    public final TextView tvUserPhone;
    public final View view2;
    public final View view3;

    private FragmentSendGorservRequestBinding(NestedScrollView nestedScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, AppCompatButton appCompatButton, ConstraintLayout constraintLayout, EditText editText, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout2, LinearLayout linearLayout, NestedScrollView nestedScrollView2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view, View view2) {
        this.rootView = nestedScrollView;
        this.btnAbout = imageView;
        this.btnBack = imageView2;
        this.btnEditPhone = imageView3;
        this.btnSendRequest = appCompatButton;
        this.constraintLayout7 = constraintLayout;
        this.etComment = editText;
        this.imageView14 = imageView4;
        this.ivIcon = imageView5;
        this.layoutContent = constraintLayout2;
        this.layoutLoader = linearLayout;
        this.nestedScrollView2 = nestedScrollView2;
        this.toolbar = constraintLayout3;
        this.tvCallHint = textView;
        this.tvCommentHint = textView2;
        this.tvGorservTitle = textView3;
        this.tvPhoneDetails = textView4;
        this.tvSelectedCategoryTitle = textView5;
        this.tvToolbarTitle = textView6;
        this.tvUserPhone = textView7;
        this.view2 = view;
        this.view3 = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSendGorservRequestBinding bind(View view) {
        int i = R.id.btn_about;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_about);
        if (imageView != null) {
            i = R.id.btn_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (imageView2 != null) {
                i = R.id.btn_edit_phone;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_edit_phone);
                if (imageView3 != null) {
                    i = R.id.btn_send_request;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_send_request);
                    if (appCompatButton != null) {
                        i = R.id.constraintLayout7;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout7);
                        if (constraintLayout != null) {
                            i = R.id.et_comment;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_comment);
                            if (editText != null) {
                                i = R.id.imageView14;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView14);
                                if (imageView4 != null) {
                                    i = R.id.iv_icon;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon);
                                    if (imageView5 != null) {
                                        i = R.id.layout_content;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_content);
                                        if (constraintLayout2 != null) {
                                            i = R.id.layout_loader;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_loader);
                                            if (linearLayout != null) {
                                                i = R.id.nestedScrollView2;
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nestedScrollView2);
                                                if (nestedScrollView != null) {
                                                    i = R.id.toolbar;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.tv_call_hint;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_call_hint);
                                                        if (textView != null) {
                                                            i = R.id.tv_comment_hint;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_comment_hint);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_gorserv_title;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_title);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_phone_details;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_phone_details);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_selected_category_title;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_selected_category_title);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_toolbar_title;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_user_phone;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_user_phone);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.view2;
                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view2);
                                                                                    if (viewFindChildViewById != null) {
                                                                                        i = R.id.view3;
                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.view3);
                                                                                        if (viewFindChildViewById2 != null) {
                                                                                            return new FragmentSendGorservRequestBinding((NestedScrollView) view, imageView, imageView2, imageView3, appCompatButton, constraintLayout, editText, imageView4, imageView5, constraintLayout2, linearLayout, nestedScrollView, constraintLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, viewFindChildViewById, viewFindChildViewById2);
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
