package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentDigitalKeysActiveBinding implements ViewBinding {
    public final TextView addCodeButton;
    public final TextView addPermCodeButton;
    public final LinearLayout codeLayout;
    public final ConstraintLayout constraintLayout2;
    public final ConstraintLayout constraintLayout3;
    public final ImageView deleteButtonTemp;
    public final ImageView imageView2;
    public final LayoutInfoServiceBinding infoLayout;
    public final CardView permCardLayout;
    public final ImageView refreshButton;
    public final ImageView refreshButtonTemp;
    private final LinearLayout rootView;
    public final LinearLayout serviceLoader;
    public final WaintingSubscriptionScreenBinding serviceWaiting;
    public final ImageView shareButtonTemp;
    public final AppCompatButton subsSettingsButton;
    public final CardView tempCardLayout;
    public final TextView textView2;
    public final TextView textViewTemp;
    public final Toolbar toolbar;
    public final TextView tvAttention;
    public final TextView tvExpireTimePerm;
    public final TextView tvExpireTimeTemp;
    public final TextView tvPerm;
    public final TextView tvTemp;
    public final ScrollView viewMain;

    private FragmentDigitalKeysActiveBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, LayoutInfoServiceBinding layoutInfoServiceBinding, CardView cardView, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout3, WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding, ImageView imageView5, AppCompatButton appCompatButton, CardView cardView2, TextView textView3, TextView textView4, Toolbar toolbar, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ScrollView scrollView) {
        this.rootView = linearLayout;
        this.addCodeButton = textView;
        this.addPermCodeButton = textView2;
        this.codeLayout = linearLayout2;
        this.constraintLayout2 = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.deleteButtonTemp = imageView;
        this.imageView2 = imageView2;
        this.infoLayout = layoutInfoServiceBinding;
        this.permCardLayout = cardView;
        this.refreshButton = imageView3;
        this.refreshButtonTemp = imageView4;
        this.serviceLoader = linearLayout3;
        this.serviceWaiting = waintingSubscriptionScreenBinding;
        this.shareButtonTemp = imageView5;
        this.subsSettingsButton = appCompatButton;
        this.tempCardLayout = cardView2;
        this.textView2 = textView3;
        this.textViewTemp = textView4;
        this.toolbar = toolbar;
        this.tvAttention = textView5;
        this.tvExpireTimePerm = textView6;
        this.tvExpireTimeTemp = textView7;
        this.tvPerm = textView8;
        this.tvTemp = textView9;
        this.viewMain = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDigitalKeysActiveBinding bind(View view) {
        int i = R.id.addCodeButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.addCodeButton);
        if (textView != null) {
            i = R.id.addPermCodeButton;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.addPermCodeButton);
            if (textView2 != null) {
                i = R.id.code_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.code_layout);
                if (linearLayout != null) {
                    i = R.id.constraintLayout2;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout2);
                    if (constraintLayout != null) {
                        i = R.id.constraintLayout3;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout3);
                        if (constraintLayout2 != null) {
                            i = R.id.delete_button_temp;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delete_button_temp);
                            if (imageView != null) {
                                i = R.id.imageView2;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView2);
                                if (imageView2 != null) {
                                    i = R.id.info_layout;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.info_layout);
                                    if (viewFindChildViewById != null) {
                                        LayoutInfoServiceBinding layoutInfoServiceBindingBind = LayoutInfoServiceBinding.bind(viewFindChildViewById);
                                        i = R.id.perm_card_layout;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.perm_card_layout);
                                        if (cardView != null) {
                                            i = R.id.refresh_button;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.refresh_button);
                                            if (imageView3 != null) {
                                                i = R.id.refresh_button_temp;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.refresh_button_temp);
                                                if (imageView4 != null) {
                                                    i = R.id.serviceLoader;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.service_waiting;
                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.service_waiting);
                                                        if (viewFindChildViewById2 != null) {
                                                            WaintingSubscriptionScreenBinding waintingSubscriptionScreenBindingBind = WaintingSubscriptionScreenBinding.bind(viewFindChildViewById2);
                                                            i = R.id.share_button_temp;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.share_button_temp);
                                                            if (imageView5 != null) {
                                                                i = R.id.subsSettingsButton;
                                                                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.subsSettingsButton);
                                                                if (appCompatButton != null) {
                                                                    i = R.id.temp_card_layout;
                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, R.id.temp_card_layout);
                                                                    if (cardView2 != null) {
                                                                        i = R.id.textView2;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.textView2);
                                                                        if (textView3 != null) {
                                                                            i = R.id.textViewTemp;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.textViewTemp);
                                                                            if (textView4 != null) {
                                                                                i = R.id.toolbar;
                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                if (toolbar != null) {
                                                                                    i = R.id.tv_attention;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_attention);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tv_expire_time_perm;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_expire_time_perm);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tv_expire_time_temp;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_expire_time_temp);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.tv_perm;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_perm);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.tv_temp;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_temp);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.viewMain;
                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.viewMain);
                                                                                                        if (scrollView != null) {
                                                                                                            return new FragmentDigitalKeysActiveBinding((LinearLayout) view, textView, textView2, linearLayout, constraintLayout, constraintLayout2, imageView, imageView2, layoutInfoServiceBindingBind, cardView, imageView3, imageView4, linearLayout2, waintingSubscriptionScreenBindingBind, imageView5, appCompatButton, cardView2, textView3, textView4, toolbar, textView5, textView6, textView7, textView8, textView9, scrollView);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
