package com.sputnik.oboarding.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import com.bumptech.glide.Glide;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.stories.ColorsButton;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.extensions.FragmentKt;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.StoriesDataState;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.stories.ButtonStoryType;
import com.sputnik.domain.entities.stories.DeepLinks;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentBaseOnboardingBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: StoryFragment.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/sputnik/oboarding/ui/onboarding/StoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/entities/stories/StoryButton;", "storyButton", "setUpPinkButton", "(Lcom/sputnik/common/entities/stories/StoryButton;)V", "setUpBlueButton", "setUpShareButton", "Lcom/sputnik/domain/entities/stories/DeepLinks;", "deepLinks", "", "getActionDestination", "(Lcom/sputnik/domain/entities/stories/DeepLinks;)I", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "Lcom/sputnik/oboarding/databinding/FragmentBaseOnboardingBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentBaseOnboardingBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel$delegate", "Lkotlin/Lazy;", "getStoriesViewModel", "()Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel", "Lcom/sputnik/common/entities/stories/Story;", "story$delegate", "getStory", "()Lcom/sputnik/common/entities/stories/Story;", "story", "Companion", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoryFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(StoryFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentBaseOnboardingBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public PrefManager prefManager;

    /* renamed from: storiesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storiesViewModel;

    /* renamed from: story$delegate, reason: from kotlin metadata */
    private final Lazy story;

    /* compiled from: StoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ColorsButton.values().length];
            try {
                iArr[ColorsButton.pink.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorsButton.blue.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DeepLinks.values().length];
            try {
                iArr2[DeepLinks.subscription.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DeepLinks.registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentBaseOnboardingBinding getBinding() {
        return (FragmentBaseOnboardingBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    private final StoriesViewModel getStoriesViewModel() {
        return (StoriesViewModel) this.storiesViewModel.getValue();
    }

    private final Story getStory() {
        return (Story) this.story.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        StoriesViewModel storiesViewModel = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        storiesViewModel.observeState(viewLifecycleOwner, new Function1<StoriesDataState, Unit>() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoriesDataState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoriesDataState storiesDataState) {
                invoke2(storiesDataState);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Story story = getStory();
        Intrinsics.checkNotNull(story);
        String screenshot = story.getScreenshot();
        if (screenshot != null) {
            Bitmap cachedImage = getStoriesViewModel().getCachedImage(screenshot);
            if (cachedImage != null && !cachedImage.isRecycled()) {
                Log.e("stories", "load from cache");
                getBinding().ivOnboarding.setImageBitmap(cachedImage);
            } else {
                Glide.with(this).load(screenshot).into(getBinding().ivOnboarding);
                Log.e("stories", "load from server");
            }
            ImageView ivOnboarding = getBinding().ivOnboarding;
            Intrinsics.checkNotNullExpressionValue(ivOnboarding, "ivOnboarding");
            ViewKt.visible(ivOnboarding);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Log.e("STORIES", "onStop");
        getBinding().ivOnboarding.setImageBitmap(null);
    }

    private final void initView() {
        if (getStory() == null) {
            return;
        }
        Story story = getStory();
        Intrinsics.checkNotNull(story);
        String background = story.getBackground();
        if (background != null) {
        }
        Story story2 = getStory();
        Intrinsics.checkNotNull(story2);
        String title = story2.getTitle();
        if (title != null) {
            getBinding().title.setText(title);
            TextView title2 = getBinding().title;
            Intrinsics.checkNotNullExpressionValue(title2, "title");
            ViewKt.visible(title2);
        }
        Story story3 = getStory();
        Intrinsics.checkNotNull(story3);
        String desc = story3.getDesc();
        if (desc != null) {
            getBinding().notice.setText(desc);
            TextView notice = getBinding().notice;
            Intrinsics.checkNotNullExpressionValue(notice, "notice");
            ViewKt.visible(notice);
        }
        Story story4 = getStory();
        Intrinsics.checkNotNull(story4);
        List<StoryButton> buttons = story4.getButtons();
        if (buttons != null) {
            for (StoryButton storyButton : buttons) {
                if (storyButton.getType() == ButtonStoryType.share_btn) {
                    setUpShareButton(storyButton);
                } else {
                    ColorsButton color = storyButton.getColor();
                    int i = color == null ? -1 : WhenMappings.$EnumSwitchMapping$0[color.ordinal()];
                    if (i == 1) {
                        setUpPinkButton(storyButton);
                    } else if (i == 2) {
                        setUpBlueButton(storyButton);
                    }
                }
            }
        }
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewKt.addSystemWindowInsetToPadding(root, true);
    }

    private final void setUpPinkButton(final StoryButton storyButton) {
        final AppCompatButton appCompatButton = getBinding().btnRedAction;
        appCompatButton.setText(storyButton.getTitle());
        Intrinsics.checkNotNull(appCompatButton);
        ViewKt.visible(appCompatButton);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                StoryFragment.setUpPinkButton$lambda$7$lambda$6(storyButton, appCompatButton, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpPinkButton$lambda$7$lambda$6(StoryButton storyButton, AppCompatButton this_apply, StoryFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(storyButton, "$storyButton");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DeepLinks deeplink = storyButton.getDeeplink();
        if (deeplink != null) {
            NavControllerKt.safeNavigate$default(androidx.navigation.ViewKt.findNavController(this_apply), R$id.onboardingFragment, this$0.getActionDestination(deeplink), null, null, 12, null);
        }
    }

    private final void setUpBlueButton(final StoryButton storyButton) {
        final AppCompatButton appCompatButton = getBinding().btnBlueAction;
        appCompatButton.setText(storyButton.getTitle());
        Intrinsics.checkNotNull(appCompatButton);
        ViewKt.visible(appCompatButton);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                StoryFragment.setUpBlueButton$lambda$10$lambda$9(storyButton, this, appCompatButton, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpBlueButton$lambda$10$lambda$9(StoryButton storyButton, StoryFragment this$0, AppCompatButton this_apply, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(storyButton, "$storyButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        DeepLinks deeplink = storyButton.getDeeplink();
        if (deeplink != null) {
            this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.StoryFinishEvent());
            if (StringsKt.isBlank(this$0.getPrefManager().getJwtToken())) {
                NavControllerKt.safeNavigate$default(androidx.navigation.ViewKt.findNavController(this_apply), R$id.onboardingFragment, this$0.getActionDestination(deeplink), null, null, 12, null);
                return;
            }
            Uri uri = Uri.parse(this$0.getString(R$string.deeplink_main));
            androidx.navigation.ViewKt.findNavController(this_apply).popBackStack(R$id.onboardingFragment, true);
            NavController navControllerFindNavController = androidx.navigation.ViewKt.findNavController(this_apply);
            Intrinsics.checkNotNull(uri);
            navControllerFindNavController.navigate(uri);
        }
    }

    private final void setUpShareButton(StoryButton storyButton) {
        final TextView textView = getBinding().btnShare;
        Intrinsics.checkNotNull(textView);
        ViewKt.visible(textView);
        textView.setText(storyButton.getTitle());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryFragment.setUpShareButton$lambda$12$lambda$11(this.f$0, textView, view);
            }
        });
    }

    public StoryFragment() {
        super(R$layout.fragment_base_onboarding);
        this.binding = new ViewBindingFragmentDelegate(this, StoryFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.storiesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(StoriesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$storiesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.story = LazyKt.lazy(new Function0<Story>() { // from class: com.sputnik.oboarding.ui.onboarding.StoryFragment$story$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Story invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return (Story) arguments.getParcelable("com.sputnik.oboarding.ui.onboarding.story_key");
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpShareButton$lambda$12$lambda$11(StoryFragment this$0, TextView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.StoryShareEvent());
        Context context = this_apply.getContext();
        String packageName = context != null ? context.getPackageName() : null;
        Intrinsics.checkNotNull(packageName);
        String str = "https://play.google.com/store/apps/details?id=" + packageName;
        Story story = this$0.getStory();
        String title = story != null ? story.getTitle() : null;
        Intrinsics.checkNotNull(title);
        FragmentKt.share(this$0, str, title);
    }

    private final int getActionDestination(DeepLinks deepLinks) {
        int i = WhenMappings.$EnumSwitchMapping$1[deepLinks.ordinal()];
        if (i == 1) {
            return R$id.action_onboardingFragment_to_new_registration_navigation;
        }
        if (i == 2) {
            return R$id.action_onboardingFragment_to_new_registration_navigation;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: StoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/oboarding/ui/onboarding/StoryFragment$Companion;", "", "()V", "STORY_KEY", "", "newInstance", "Lcom/sputnik/oboarding/ui/onboarding/StoryFragment;", "story", "Lcom/sputnik/common/entities/stories/Story;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StoryFragment newInstance(Story story) {
            Intrinsics.checkNotNullParameter(story, "story");
            StoryFragment storyFragment = new StoryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.sputnik.oboarding.ui.onboarding.story_key", story);
            storyFragment.setArguments(bundle);
            return storyFragment;
        }
    }
}
