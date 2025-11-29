package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetSelectAddressBinding implements ViewBinding {
    public final ConstraintLayout btnAcceptInvites;
    public final ConstraintLayout btnAddAddress;
    public final AppCompatButton btnDone;
    public final ImageView btnEditorMode;
    public final Button btnSubscribe;
    public final ImageView ivInviteStatus;
    public final ImageView ivStatus;
    public final LinearLayout llSubscriptionNeeded;
    private final LinearLayout rootView;
    public final RecyclerView rvAddresses;
    public final TextView tvAddress;
    public final TextView tvInvitesAddress;
    public final TextView tvSelectAddress;
    public final View view5;
    public final View viewDivider;

    private BottomSheetSelectAddressBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatButton appCompatButton, ImageView imageView, Button button, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view, View view2) {
        this.rootView = linearLayout;
        this.btnAcceptInvites = constraintLayout;
        this.btnAddAddress = constraintLayout2;
        this.btnDone = appCompatButton;
        this.btnEditorMode = imageView;
        this.btnSubscribe = button;
        this.ivInviteStatus = imageView2;
        this.ivStatus = imageView3;
        this.llSubscriptionNeeded = linearLayout2;
        this.rvAddresses = recyclerView;
        this.tvAddress = textView;
        this.tvInvitesAddress = textView2;
        this.tvSelectAddress = textView3;
        this.view5 = view;
        this.viewDivider = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetSelectAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_select_address, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetSelectAddressBinding bind(View view) {
        int i = R.id.btn_accept_invites;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.btn_accept_invites);
        if (constraintLayout != null) {
            i = R.id.btn_add_address;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.btn_add_address);
            if (constraintLayout2 != null) {
                i = R.id.btn_done;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_done);
                if (appCompatButton != null) {
                    i = R.id.btn_editor_mode;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_editor_mode);
                    if (imageView != null) {
                        i = R.id.btn_subscribe;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
                        if (button != null) {
                            i = R.id.iv_invite_status;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_invite_status);
                            if (imageView2 != null) {
                                i = R.id.iv_status;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_status);
                                if (imageView3 != null) {
                                    i = R.id.ll_subscription_needed;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_subscription_needed);
                                    if (linearLayout != null) {
                                        i = R.id.rv_addresses;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_addresses);
                                        if (recyclerView != null) {
                                            i = R.id.tv_address;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_address);
                                            if (textView != null) {
                                                i = R.id.tv_invites_address;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_invites_address);
                                                if (textView2 != null) {
                                                    i = R.id.tv_select_address;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_select_address);
                                                    if (textView3 != null) {
                                                        i = R.id.view5;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view5);
                                                        if (viewFindChildViewById != null) {
                                                            i = R.id.view_divider;
                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.view_divider);
                                                            if (viewFindChildViewById2 != null) {
                                                                return new BottomSheetSelectAddressBinding((LinearLayout) view, constraintLayout, constraintLayout2, appCompatButton, imageView, button, imageView2, imageView3, linearLayout, recyclerView, textView, textView2, textView3, viewFindChildViewById, viewFindChildViewById2);
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
