package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSplashCustomScreenBinding implements ViewBinding {
    public final TextView btnPromote1;
    public final ImageView btnPromote2;
    public final ImageView btnPromote3;
    public final ImageView imageView5;
    public final ImageView ivBackground;
    public final ImageView ivOurHome;
    public final ImageView ivPromote2Background;
    public final ImageView ivPromotionBackground;
    public final ImageView ivTimerBackground;
    public final ConstraintLayout layoutActions;
    public final ConstraintLayout layoutVideo;
    public final LinearLayout linearLayout4;
    public final ProgressBar progress;
    private final ConstraintLayout rootView;
    public final TextSwitcher tvSplash;
    public final TextView tvSubtitle;
    public final TextView tvTimer;
    public final TextView tvTitle;
    public final ConstraintLayout viewRoot;
    public final SimpleExoPlayerView viewVideo;

    private FragmentSplashCustomScreenBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ProgressBar progressBar, TextSwitcher textSwitcher, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout4, SimpleExoPlayerView simpleExoPlayerView) {
        this.rootView = constraintLayout;
        this.btnPromote1 = textView;
        this.btnPromote2 = imageView;
        this.btnPromote3 = imageView2;
        this.imageView5 = imageView3;
        this.ivBackground = imageView4;
        this.ivOurHome = imageView5;
        this.ivPromote2Background = imageView6;
        this.ivPromotionBackground = imageView7;
        this.ivTimerBackground = imageView8;
        this.layoutActions = constraintLayout2;
        this.layoutVideo = constraintLayout3;
        this.linearLayout4 = linearLayout;
        this.progress = progressBar;
        this.tvSplash = textSwitcher;
        this.tvSubtitle = textView2;
        this.tvTimer = textView3;
        this.tvTitle = textView4;
        this.viewRoot = constraintLayout4;
        this.viewVideo = simpleExoPlayerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSplashCustomScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSplashCustomScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_splash_custom_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSplashCustomScreenBinding bind(View view) {
        int i = R.id.btn_promote1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btn_promote1);
        if (textView != null) {
            i = R.id.btn_promote2;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_promote2);
            if (imageView != null) {
                i = R.id.btn_promote3;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_promote3);
                if (imageView2 != null) {
                    i = R.id.imageView5;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView5);
                    if (imageView3 != null) {
                        i = R.id.iv_background;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background);
                        if (imageView4 != null) {
                            i = R.id.iv_our_home;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_our_home);
                            if (imageView5 != null) {
                                i = R.id.iv_promote2_background;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_promote2_background);
                                if (imageView6 != null) {
                                    i = R.id.iv_promotion_background;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_promotion_background);
                                    if (imageView7 != null) {
                                        i = R.id.iv_timer_background;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_timer_background);
                                        if (imageView8 != null) {
                                            i = R.id.layout_actions;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_actions);
                                            if (constraintLayout != null) {
                                                i = R.id.layout_video;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_video);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.linearLayout4;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout4);
                                                    if (linearLayout != null) {
                                                        i = R.id.progress;
                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress);
                                                        if (progressBar != null) {
                                                            i = R.id.tv_splash;
                                                            TextSwitcher textSwitcher = (TextSwitcher) ViewBindings.findChildViewById(view, R.id.tv_splash);
                                                            if (textSwitcher != null) {
                                                                i = R.id.tv_subtitle;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                                                if (textView2 != null) {
                                                                    i = R.id.tv_timer;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_timer);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_title;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                                        if (textView4 != null) {
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                                                            i = R.id.view_video;
                                                                            SimpleExoPlayerView simpleExoPlayerView = (SimpleExoPlayerView) ViewBindings.findChildViewById(view, R.id.view_video);
                                                                            if (simpleExoPlayerView != null) {
                                                                                return new FragmentSplashCustomScreenBinding(constraintLayout3, textView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, constraintLayout, constraintLayout2, linearLayout, progressBar, textSwitcher, textView2, textView3, textView4, constraintLayout3, simpleExoPlayerView);
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
