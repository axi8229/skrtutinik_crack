package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentYandexHomeBinding implements ViewBinding {
    public final ImageView btnBack;
    public final AppCompatButton btnConnectAlice;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ConstraintLayout layoutBeta;
    public final LinearLayout linearLayout11;
    public final LinearLayout linearLayout12;
    private final ConstraintLayout rootView;
    public final ConstraintLayout toolbar;
    public final TextView tvAliceCommands1;
    public final TextView tvAliceCommands2;
    public final TextView tvAliceCommands3;
    public final TextView tvAliceDelayedCommands;
    public final TextView tvBeta;
    public final TextView tvHowToConnectAlice;
    public final TextView tvSubtitle;
    public final TextView tvToolbarTitle;

    private FragmentYandexHomeBinding(ConstraintLayout constraintLayout, ImageView imageView, AppCompatButton appCompatButton, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.btnConnectAlice = appCompatButton;
        this.imageView8 = imageView2;
        this.imageView9 = imageView3;
        this.layoutBeta = constraintLayout2;
        this.linearLayout11 = linearLayout;
        this.linearLayout12 = linearLayout2;
        this.toolbar = constraintLayout3;
        this.tvAliceCommands1 = textView;
        this.tvAliceCommands2 = textView2;
        this.tvAliceCommands3 = textView3;
        this.tvAliceDelayedCommands = textView4;
        this.tvBeta = textView5;
        this.tvHowToConnectAlice = textView6;
        this.tvSubtitle = textView7;
        this.tvToolbarTitle = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYandexHomeBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i = R.id.btn_connect_alice;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_connect_alice);
            if (appCompatButton != null) {
                i = R.id.imageView8;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView8);
                if (imageView2 != null) {
                    i = R.id.imageView9;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView9);
                    if (imageView3 != null) {
                        i = R.id.layout_beta;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_beta);
                        if (constraintLayout != null) {
                            i = R.id.linearLayout11;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout11);
                            if (linearLayout != null) {
                                i = R.id.linearLayout12;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout12);
                                if (linearLayout2 != null) {
                                    i = R.id.toolbar;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (constraintLayout2 != null) {
                                        i = R.id.tv_alice_commands1;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_alice_commands1);
                                        if (textView != null) {
                                            i = R.id.tv_alice_commands2;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_alice_commands2);
                                            if (textView2 != null) {
                                                i = R.id.tv_alice_commands3;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_alice_commands3);
                                                if (textView3 != null) {
                                                    i = R.id.tv_alice_delayed_commands;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_alice_delayed_commands);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_beta;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_beta);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_how_to_connect_alice;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_how_to_connect_alice);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_subtitle;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_toolbar_title;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title);
                                                                    if (textView8 != null) {
                                                                        return new FragmentYandexHomeBinding((ConstraintLayout) view, imageView, appCompatButton, imageView2, imageView3, constraintLayout, linearLayout, linearLayout2, constraintLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
