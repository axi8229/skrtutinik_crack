package sputnik.axmor.com.sputnik.ui.popups;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bumptech.glide.Glide;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.PopupEvents;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.popup.Appearance;
import com.sputnik.common.entities.popup.Background;
import com.sputnik.common.entities.popup.Button;
import com.sputnik.common.entities.popup.Image;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.Subtitle;
import com.sputnik.common.entities.popup.Title;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.PopupStoriesDataState;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.data.local.PrefManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentPopupStoryBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: PopupStoryFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u00100\u001a\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/popups/PopupStoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onStart", "onStop", "Lsputnik/axmor/com/databinding/FragmentPopupStoryBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentPopupStoryBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel$delegate", "Lkotlin/Lazy;", "getPopupStoriesViewModel", "()Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "", "popupId$delegate", "getPopupId", "()Ljava/lang/String;", "popupId", "Lcom/sputnik/common/entities/popup/PopupStory;", "story$delegate", "getStory", "()Lcom/sputnik/common/entities/popup/PopupStory;", "story", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopupStoryFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PopupStoryFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentPopupStoryBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: popupId$delegate, reason: from kotlin metadata */
    private final Lazy popupId;

    /* renamed from: popupStoriesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy popupStoriesViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: story$delegate, reason: from kotlin metadata */
    private final Lazy story;

    private final void initView() {
    }

    private final FragmentPopupStoryBinding getBinding() {
        return (FragmentPopupStoryBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    private final PopupStoriesViewModel getPopupStoriesViewModel() {
        return (PopupStoriesViewModel) this.popupStoriesViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final String getPopupId() {
        return (String) this.popupId.getValue();
    }

    private final PopupStory getStory() {
        return (PopupStory) this.story.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Appearance appearance;
        int i;
        LinearLayout linearLayout;
        TextView textView;
        String text;
        FragmentPopupStoryBinding binding;
        TextView textView2;
        TextView textView3;
        Appearance appearance2;
        Background background;
        String url;
        String color;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout9 = getBinding().linearLayout9;
        Intrinsics.checkNotNullExpressionValue(linearLayout9, "linearLayout9");
        ViewKt.addSystemWindowInsetToMargin$default(linearLayout9, false, true, false, false, 13, null);
        PopupStory story = getStory();
        if (story != null && (appearance = story.getAppearance()) != null) {
            Background background2 = appearance.getBackground();
            if (background2 != null && (color = background2.getColor()) != null) {
                if (StringsKt.isBlank(color)) {
                    color = null;
                }
                if (color != null) {
                    getBinding().root.setBackgroundColor(Color.parseColor("#" + background2.getColor()));
                }
            }
            PopupStory story2 = getStory();
            if (story2 != null && (appearance2 = story2.getAppearance()) != null && (background = appearance2.getBackground()) != null && (url = background.getUrl()) != null) {
                if (StringsKt.isBlank(url)) {
                    url = null;
                }
                if (url != null) {
                    Bitmap cachedImage = getPopupStoriesViewModel().getCachedImage(url);
                    if (cachedImage != null && !cachedImage.isRecycled()) {
                        getBinding().ivBackground.setImageBitmap(cachedImage);
                    } else {
                        Intrinsics.checkNotNull(Glide.with(this).load(url).into(getBinding().ivBackground));
                    }
                }
            }
            Title title = appearance.getTitle();
            FragmentPopupStoryBinding binding2 = getBinding();
            TextView textView4 = binding2 != null ? binding2.title : null;
            if (textView4 != null) {
                textView4.setText(title.getText());
            }
            FragmentPopupStoryBinding binding3 = getBinding();
            if (binding3 != null && (textView3 = binding3.title) != null) {
                textView3.setTextColor(Color.parseColor("#" + title.getTextColor()));
            }
            if (title.getParam() != null && (binding = getBinding()) != null && (textView2 = binding.title) != null) {
                Intrinsics.checkNotNull(textView2);
                ViewUtilsKt.highlightText(textView2, String.valueOf(title.getText()), new HighlightedText(String.valueOf(title.getParam()), Color.parseColor("#" + title.getParamColor()), null, null, 0, 0, 60, null));
            }
            Subtitle subtitle = appearance.getSubtitle();
            if (subtitle != null && (text = subtitle.getText()) != null) {
                FragmentPopupStoryBinding binding4 = getBinding();
                TextView textView5 = binding4 != null ? binding4.subtitle : null;
                if (textView5 != null) {
                    textView5.setText(text);
                }
            }
            FragmentPopupStoryBinding binding5 = getBinding();
            if (binding5 != null && (textView = binding5.subtitle) != null) {
                textView.setTextColor(Color.parseColor("#" + subtitle.getTextColor()));
            }
            final int i2 = 0;
            for (Object obj : appearance.getButtons()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final Button button = (Button) obj;
                if (Intrinsics.areEqual(button.getBackgroundColor(), "clear")) {
                    i = R.layout.layout_button_transparent;
                } else {
                    Intrinsics.areEqual(button.getBackgroundColor(), "gradient");
                    i = R.layout.layout_button_gradient;
                }
                View viewInflate = getLayoutInflater().inflate(i, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatButton");
                final AppCompatButton appCompatButton = (AppCompatButton) viewInflate;
                if (!Intrinsics.areEqual(button.getBackgroundColor(), "clear") && !Intrinsics.areEqual(button.getBackgroundColor(), "gradient")) {
                    ShapeAppearanceModel shapeAppearanceModelBuild = new ShapeAppearanceModel().toBuilder().setAllCorners(0, getResources().getDimension(R.dimen.radius_button)).build();
                    Intrinsics.checkNotNullExpressionValue(shapeAppearanceModelBuild, "build(...)");
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelBuild);
                    materialShapeDrawable.setFillColor(ColorStateList.valueOf(Color.parseColor("#" + button.getBackgroundColor())));
                    ViewCompat.setBackground(appCompatButton, materialShapeDrawable);
                }
                appCompatButton.setText(button.getText());
                appCompatButton.setTextColor(Color.parseColor("#" + button.getTextColor()));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                Resources resources = appCompatButton.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                layoutParams.setMargins(0, DpUtilsKt.convertPxToDb(16.0f, resources), 0, 0);
                appCompatButton.setLayoutParams(layoutParams);
                appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PopupStoryFragment.onViewCreated$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(this.f$0, i2, button, appCompatButton, view2);
                    }
                });
                FragmentPopupStoryBinding binding6 = getBinding();
                if (binding6 != null && (linearLayout = binding6.layoutButtons) != null) {
                    linearLayout.addView(appCompatButton);
                }
                i2 = i3;
            }
        }
        initView();
        PopupStoriesViewModel popupStoriesViewModel = getPopupStoriesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        popupStoriesViewModel.observeState(viewLifecycleOwner, new Function1<PopupStoriesDataState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopupStoriesDataState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PopupStoriesDataState popupStoriesDataState) {
                invoke2(popupStoriesDataState);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(PopupStoryFragment this$0, int i, Button button, AppCompatButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.getAnalytics().trackLogEvent(new PopupEvents.ClickScreenBtnN(i + 1, this$0.getPopupId()));
        PopupStoriesViewModel popupStoriesViewModel = this$0.getPopupStoriesViewModel();
        String strValueOf = String.valueOf(this$0.getPopupId());
        PopupStory story = this$0.getStory();
        popupStoriesViewModel.sendStoryAction(strValueOf, String.valueOf(story != null ? Long.valueOf(story.getId()) : null), String.valueOf(button.getAction()));
        IntentProcessingUtilsKt.handleDeeplink(button.getDeeplink(), BundleKt.bundleOf(), this$0.getActivity(), this$0.getNavigationViewModel(), this$0.getProfileViewModel(), this$0.getAnalytics(), androidx.navigation.ViewKt.findNavController(this_apply));
        androidx.navigation.ViewKt.findNavController(this_apply).popBackStack(R.id.popupStoriesFragment, true);
    }

    public PopupStoryFragment() {
        super(R.layout.fragment_popup_story);
        this.binding = new ViewBindingFragmentDelegate(this, PopupStoryFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.popupStoriesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PopupStoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$popupStoriesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.popupId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$popupId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("id");
                }
                return null;
            }
        });
        this.story = LazyKt.lazy(new Function0<PopupStory>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment$story$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PopupStory invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return (PopupStory) arguments.getParcelable("sputnik.popup_story");
                }
                return null;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PopupStoriesFragment.Companion companion = PopupStoriesFragment.INSTANCE;
        PopupStory story = getStory();
        companion.setStoryId(String.valueOf(story != null ? Long.valueOf(story.getId()) : null));
        PopupStoriesViewModel popupStoriesViewModel = getPopupStoriesViewModel();
        String strValueOf = String.valueOf(getPopupId());
        PopupStory story2 = getStory();
        if (popupStoriesViewModel.isStoryShowed(strValueOf, String.valueOf(story2 != null ? Long.valueOf(story2.getId()) : null))) {
            return;
        }
        PopupStoriesViewModel popupStoriesViewModel2 = getPopupStoriesViewModel();
        String strValueOf2 = String.valueOf(getPopupId());
        PopupStory story3 = getStory();
        popupStoriesViewModel2.updateStoryPosition(strValueOf2, String.valueOf(story3 != null ? Long.valueOf(story3.getId()) : null));
        Integer storyPosition = getPopupStoriesViewModel().getStoryPosition();
        if (storyPosition != null) {
            getAnalytics().trackLogEvent(new PopupEvents.ShowScreenSeeN(storyPosition.intValue(), getPopupId()));
        }
        PopupStoriesViewModel popupStoriesViewModel3 = getPopupStoriesViewModel();
        String strValueOf3 = String.valueOf(getPopupId());
        PopupStory story4 = getStory();
        popupStoriesViewModel3.markStoryAsShowed(strValueOf3, String.valueOf(story4 != null ? Long.valueOf(story4.getId()) : null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Appearance appearance;
        Image image;
        String url;
        super.onStart();
        PopupStory story = getStory();
        if (story == null || (appearance = story.getAppearance()) == null || (image = appearance.getImage()) == null || (url = image.getUrl()) == null) {
            return;
        }
        Bitmap cachedImage = getPopupStoriesViewModel().getCachedImage(url);
        if (cachedImage != null && !cachedImage.isRecycled()) {
            getBinding().ivOnboarding.setImageBitmap(cachedImage);
        } else {
            Intrinsics.checkNotNull(Glide.with(this).load(url).into(getBinding().ivOnboarding));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getBinding().ivOnboarding.setImageBitmap(null);
    }

    /* compiled from: PopupStoryFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/popups/PopupStoryFragment$Companion;", "", "()V", "STORY_KEY", "", "newInstance", "Lsputnik/axmor/com/sputnik/ui/popups/PopupStoryFragment;", "story", "Lcom/sputnik/common/entities/popup/PopupStory;", "popupId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PopupStoryFragment newInstance(PopupStory story, String popupId) {
            Intrinsics.checkNotNullParameter(story, "story");
            Intrinsics.checkNotNullParameter(popupId, "popupId");
            PopupStoryFragment popupStoryFragment = new PopupStoryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("sputnik.popup_story", story);
            bundle.putString("id", popupId);
            popupStoryFragment.setArguments(bundle);
            return popupStoryFragment;
        }
    }
}
