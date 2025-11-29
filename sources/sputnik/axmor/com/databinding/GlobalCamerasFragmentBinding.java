package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.sputnik.common.ui.view.VerticalTabLayout;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.ui.views.OpenDoorButtonView;
import sputnik.axmor.com.sputnik.ui.views.SecondaryOpenDoorButtonView;

/* loaded from: classes5.dex */
public final class GlobalCamerasFragmentBinding implements ViewBinding {
    public final ImageView btnAccessCodes;
    public final ImageView btnChangeAddress;
    public final AppCompatButton btnComplete;
    public final ImageView btnVideoArchive;
    public final ImageView btnVisitsHistory;
    public final FragmentContainerView callNavHostFragment2;
    public final FrameLayout fButton;
    public final View guideline;
    public final Guideline guideline2;
    public final View guideline3;
    public final ImageView historyButton;
    public final ImageView ivFullscreen;
    public final ImageView ivGallery;
    public final ImageView ivGalleryOnboarding;
    public final LinearLayout layoutActions;
    public final ConstraintLayout layoutMain;
    public final HorizontalScrollView layoutTiles;
    public final LinearLayout layoutTilesList;
    public final OpenDoorButtonView mainOpenDoorBtn;
    public final TextView mainTextButton;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView secondTextButton;
    public final SecondaryOpenDoorButtonView secondaryOpenDoorBtn;
    public final VerticalTabLayout tabs;
    public final TextView tvGalleryOnboarding;
    public final TextView tvLoader;
    public final TextView tvTitleCamera;
    public final TextView tvTitleSecondCamera;
    public final LinearLayout videoLoader;
    public final View view6;
    public final View viewLocked;
    public final ImageView viewVpn;
    public final ViewPager2 viewpager2;

    private GlobalCamerasFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, AppCompatButton appCompatButton, ImageView imageView3, ImageView imageView4, FragmentContainerView fragmentContainerView, FrameLayout frameLayout, View view, Guideline guideline, View view2, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout, ConstraintLayout constraintLayout2, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout2, OpenDoorButtonView openDoorButtonView, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, SecondaryOpenDoorButtonView secondaryOpenDoorButtonView, VerticalTabLayout verticalTabLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout3, View view3, View view4, ImageView imageView9, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.btnAccessCodes = imageView;
        this.btnChangeAddress = imageView2;
        this.btnComplete = appCompatButton;
        this.btnVideoArchive = imageView3;
        this.btnVisitsHistory = imageView4;
        this.callNavHostFragment2 = fragmentContainerView;
        this.fButton = frameLayout;
        this.guideline = view;
        this.guideline2 = guideline;
        this.guideline3 = view2;
        this.historyButton = imageView5;
        this.ivFullscreen = imageView6;
        this.ivGallery = imageView7;
        this.ivGalleryOnboarding = imageView8;
        this.layoutActions = linearLayout;
        this.layoutMain = constraintLayout2;
        this.layoutTiles = horizontalScrollView;
        this.layoutTilesList = linearLayout2;
        this.mainOpenDoorBtn = openDoorButtonView;
        this.mainTextButton = textView;
        this.rootLayout = constraintLayout3;
        this.secondTextButton = textView2;
        this.secondaryOpenDoorBtn = secondaryOpenDoorButtonView;
        this.tabs = verticalTabLayout;
        this.tvGalleryOnboarding = textView3;
        this.tvLoader = textView4;
        this.tvTitleCamera = textView5;
        this.tvTitleSecondCamera = textView6;
        this.videoLoader = linearLayout3;
        this.view6 = view3;
        this.viewLocked = view4;
        this.viewVpn = imageView9;
        this.viewpager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GlobalCamerasFragmentBinding bind(View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_access_codes);
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_change_address);
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_complete);
        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_video_archive);
        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_visits_history);
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.call_nav_host_fragment2);
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f_button);
        int i = R.id.guideline;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.guideline);
        if (viewFindChildViewById != null) {
            i = R.id.guideline2;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline2);
            if (guideline != null) {
                i = R.id.guideline3;
                View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.guideline3);
                if (viewFindChildViewById2 != null) {
                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.historyButton);
                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_fullscreen);
                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_gallery);
                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_gallery_onboarding);
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_actions);
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_main);
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.layout_tiles);
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_tiles_list);
                    i = R.id.mainOpenDoorBtn;
                    OpenDoorButtonView openDoorButtonView = (OpenDoorButtonView) ViewBindings.findChildViewById(view, R.id.mainOpenDoorBtn);
                    if (openDoorButtonView != null) {
                        i = R.id.mainTextButton;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.mainTextButton);
                        if (textView != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.secondTextButton);
                            i = R.id.secondaryOpenDoorBtn;
                            SecondaryOpenDoorButtonView secondaryOpenDoorButtonView = (SecondaryOpenDoorButtonView) ViewBindings.findChildViewById(view, R.id.secondaryOpenDoorBtn);
                            if (secondaryOpenDoorButtonView != null) {
                                i = R.id.tabs;
                                VerticalTabLayout verticalTabLayout = (VerticalTabLayout) ViewBindings.findChildViewById(view, R.id.tabs);
                                if (verticalTabLayout != null) {
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gallery_onboarding);
                                    i = R.id.tv_loader;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_loader);
                                    if (textView4 != null) {
                                        i = R.id.tv_title_camera;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_camera);
                                        if (textView5 != null) {
                                            i = R.id.tv_title_second_camera;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_second_camera);
                                            if (textView6 != null) {
                                                i = R.id.videoLoader;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.videoLoader);
                                                if (linearLayout3 != null) {
                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(view, R.id.view6);
                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(view, R.id.view_locked);
                                                    i = R.id.view_vpn;
                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.view_vpn);
                                                    if (imageView9 != null) {
                                                        i = R.id.viewpager2;
                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.viewpager2);
                                                        if (viewPager2 != null) {
                                                            return new GlobalCamerasFragmentBinding(constraintLayout2, imageView, imageView2, appCompatButton, imageView3, imageView4, fragmentContainerView, frameLayout, viewFindChildViewById, guideline, viewFindChildViewById2, imageView5, imageView6, imageView7, imageView8, linearLayout, constraintLayout, horizontalScrollView, linearLayout2, openDoorButtonView, textView, constraintLayout2, textView2, secondaryOpenDoorButtonView, verticalTabLayout, textView3, textView4, textView5, textView6, linearLayout3, viewFindChildViewById3, viewFindChildViewById4, imageView9, viewPager2);
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
