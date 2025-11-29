package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.FormSelectView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.gui.widget.headline.HeadlineSecondaryLargeView;

/* loaded from: classes4.dex */
public final class AuthPassportProfileBinding implements ViewBinding {
    public final TopBarDefault appBar;
    public final ImageView avatar;
    public final NestedScrollView contentContainer;
    public final FormSelectView email;
    public final EmptyStateLargeView errorContainer;
    public final FormSelectView name;
    public final LinearLayout parent;
    public final FormSelectView password;
    public final HeadlineSecondaryLargeView personalData;
    public final FormSelectView phone;
    public final ProgressBar progressContainer;
    private final LinearLayout rootView;
    public final HeadlineSecondaryLargeView security;
    public final RecyclerView socialAccountRecyclerView;
    public final HeadlineSecondaryLargeView socialAccountsTitle;
    public final StateFlipViewGroup stateFlipper;

    private AuthPassportProfileBinding(LinearLayout linearLayout, TopBarDefault topBarDefault, ImageView imageView, NestedScrollView nestedScrollView, FormSelectView formSelectView, EmptyStateLargeView emptyStateLargeView, FormSelectView formSelectView2, LinearLayout linearLayout2, FormSelectView formSelectView3, HeadlineSecondaryLargeView headlineSecondaryLargeView, FormSelectView formSelectView4, ProgressBar progressBar, HeadlineSecondaryLargeView headlineSecondaryLargeView2, RecyclerView recyclerView, HeadlineSecondaryLargeView headlineSecondaryLargeView3, StateFlipViewGroup stateFlipViewGroup) {
        this.rootView = linearLayout;
        this.appBar = topBarDefault;
        this.avatar = imageView;
        this.contentContainer = nestedScrollView;
        this.email = formSelectView;
        this.errorContainer = emptyStateLargeView;
        this.name = formSelectView2;
        this.parent = linearLayout2;
        this.password = formSelectView3;
        this.personalData = headlineSecondaryLargeView;
        this.phone = formSelectView4;
        this.progressContainer = progressBar;
        this.security = headlineSecondaryLargeView2;
        this.socialAccountRecyclerView = recyclerView;
        this.socialAccountsTitle = headlineSecondaryLargeView3;
        this.stateFlipper = stateFlipViewGroup;
    }

    public static AuthPassportProfileBinding bind(View view) {
        int i = R.id.appBar;
        TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
        if (topBarDefault != null) {
            i = R.id.avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.content_container;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                if (nestedScrollView != null) {
                    i = R.id.email;
                    FormSelectView formSelectView = (FormSelectView) ViewBindings.findChildViewById(view, i);
                    if (formSelectView != null) {
                        i = R.id.error_container;
                        EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                        if (emptyStateLargeView != null) {
                            i = R.id.name;
                            FormSelectView formSelectView2 = (FormSelectView) ViewBindings.findChildViewById(view, i);
                            if (formSelectView2 != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                i = R.id.password;
                                FormSelectView formSelectView3 = (FormSelectView) ViewBindings.findChildViewById(view, i);
                                if (formSelectView3 != null) {
                                    i = R.id.personal_data;
                                    HeadlineSecondaryLargeView headlineSecondaryLargeView = (HeadlineSecondaryLargeView) ViewBindings.findChildViewById(view, i);
                                    if (headlineSecondaryLargeView != null) {
                                        i = R.id.phone;
                                        FormSelectView formSelectView4 = (FormSelectView) ViewBindings.findChildViewById(view, i);
                                        if (formSelectView4 != null) {
                                            i = R.id.progress_container;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                            if (progressBar != null) {
                                                i = R.id.security;
                                                HeadlineSecondaryLargeView headlineSecondaryLargeView2 = (HeadlineSecondaryLargeView) ViewBindings.findChildViewById(view, i);
                                                if (headlineSecondaryLargeView2 != null) {
                                                    i = R.id.social_account_recycler_view;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.socialAccountsTitle;
                                                        HeadlineSecondaryLargeView headlineSecondaryLargeView3 = (HeadlineSecondaryLargeView) ViewBindings.findChildViewById(view, i);
                                                        if (headlineSecondaryLargeView3 != null) {
                                                            i = R.id.stateFlipper;
                                                            StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) ViewBindings.findChildViewById(view, i);
                                                            if (stateFlipViewGroup != null) {
                                                                return new AuthPassportProfileBinding(linearLayout, topBarDefault, imageView, nestedScrollView, formSelectView, emptyStateLargeView, formSelectView2, linearLayout, formSelectView3, headlineSecondaryLargeView, formSelectView4, progressBar, headlineSecondaryLargeView2, recyclerView, headlineSecondaryLargeView3, stateFlipViewGroup);
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

    public static AuthPassportProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthPassportProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_passport_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
