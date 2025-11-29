package com.sputnik.oboarding.ui.onboarding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.adapters.ChildFragmentStateAdapter;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.stories.StoriesProgressView;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.StoriesDataState;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentOnboardingBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: OnBoardingFragment.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001E\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/sputnik/oboarding/ui/onboarding/OnBoardingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/StoriesDataState;", "state", "renderUi", "(Lcom/sputnik/common/viewmodels/StoriesDataState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Lcom/sputnik/oboarding/databinding/FragmentOnboardingBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentOnboardingBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel$delegate", "Lkotlin/Lazy;", "getStoriesViewModel", "()Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel", "", "pressTime", "J", "Landroid/view/View$OnTouchListener;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "com/sputnik/oboarding/ui/onboarding/OnBoardingFragment$storiesListener$1", "storiesListener", "Lcom/sputnik/oboarding/ui/onboarding/OnBoardingFragment$storiesListener$1;", "Companion", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBoardingFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(OnBoardingFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentOnboardingBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener onTouchListener;
    public PrefManager prefManager;
    private long pressTime;
    private final OnBoardingFragment$storiesListener$1 storiesListener;

    /* renamed from: storiesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storiesViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentOnboardingBinding getBinding() {
        return (FragmentOnboardingBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    private final StoriesViewModel getStoriesViewModel() {
        return (StoriesViewModel) this.storiesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTouchListener$lambda$2(OnBoardingFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.pressTime = System.currentTimeMillis();
            if (this$0.getView() != null) {
                this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.StoryPressedEvent());
                this$0.getBinding().stories.pause();
            }
            return false;
        }
        if (action != 1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this$0.getView() != null) {
            this$0.getBinding().stories.resume();
        }
        return 500 < jCurrentTimeMillis - this$0.pressTime;
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
        storiesViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
    }

    /* compiled from: OnBoardingFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoriesDataState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, OnBoardingFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/StoriesDataState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoriesDataState storiesDataState) {
            invoke2(storiesDataState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoriesDataState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((OnBoardingFragment) this.receiver).renderUi(p0);
        }
    }

    private final void initView() {
        final FragmentOnboardingBinding binding = getBinding();
        ViewPager2 viewPager2 = binding.onboardingViewpager2;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager2.setAdapter(new ChildFragmentStateAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle(), null, 4, null));
        getBinding().onboardingViewpager2.setUserInputEnabled(false);
        getBinding().stories.setStoriesListener(this.storiesListener);
        View view = binding.skip;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnBoardingFragment.initView$lambda$7$lambda$4$lambda$3(binding, view2);
            }
        });
        view.setOnTouchListener(this.onTouchListener);
        View view2 = binding.reverse;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OnBoardingFragment.initView$lambda$7$lambda$6$lambda$5(binding, view3);
            }
        });
        view2.setOnTouchListener(this.onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$4$lambda$3(FragmentOnboardingBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.stories.skip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6$lambda$5(FragmentOnboardingBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.stories.reverse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(StoriesDataState state) {
        if (state.getServerState() == Resource.Status.SUCCESS) {
            RecyclerView.Adapter adapter = getBinding().onboardingViewpager2.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.sputnik.common.base.adapters.ChildFragmentStateAdapter");
            ChildFragmentStateAdapter childFragmentStateAdapter = (ChildFragmentStateAdapter) adapter;
            List<Story> stories = state.getStories();
            if (stories != null) {
                Iterator<T> it = stories.iterator();
                while (it.hasNext()) {
                    childFragmentStateAdapter.addFragment(StoryFragment.INSTANCE.newInstance((Story) it.next()));
                }
            }
            ViewPager2 viewPager2 = getBinding().onboardingViewpager2;
            List<Story> stories2 = state.getStories();
            viewPager2.setOffscreenPageLimit(stories2 != null ? stories2.size() : 1);
            StoriesProgressView storiesProgressView = getBinding().stories;
            List<Story> stories3 = state.getStories();
            storiesProgressView.setStoriesCount(stories3 != null ? stories3.size() : 1);
            List<Story> stories4 = state.getStories();
            if (stories4 != null) {
                List<Story> list = stories4;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Long.valueOf((((Story) it2.next()).getDuration() != null ? r3.intValue() : 0) * 1000));
                }
                long[] longArray = CollectionsKt.toLongArray(arrayList);
                if (longArray != null) {
                    storiesProgressView.setStoriesCountWithDurations(longArray);
                }
            }
            storiesProgressView.startStories(state.getCurrentStory());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$storiesListener$1] */
    public OnBoardingFragment() {
        super(R$layout.fragment_onboarding);
        this.binding = new ViewBindingFragmentDelegate(this, OnBoardingFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.storiesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(StoriesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$storiesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.onTouchListener = new View.OnTouchListener() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return OnBoardingFragment.onTouchListener$lambda$2(this.f$0, view, motionEvent);
            }
        };
        this.storiesListener = new StoriesProgressView.StoriesListener() { // from class: com.sputnik.oboarding.ui.onboarding.OnBoardingFragment$storiesListener$1
            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onNext() {
                if (this.this$0.getView() != null) {
                    OnBoardingFragment onBoardingFragment = this.this$0;
                    FragmentOnboardingBinding binding = onBoardingFragment.getBinding();
                    RecyclerView.Adapter adapter = binding.onboardingViewpager2.getAdapter();
                    if (adapter == null || binding.onboardingViewpager2.getCurrentItem() + 1 != adapter.getItemCount()) {
                        ViewPager2 viewPager2 = onBoardingFragment.getBinding().onboardingViewpager2;
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                        onBoardingFragment.getAnalytics().trackLogEvent(new OnBoardingEvents.StoryTapRightEvent());
                    }
                }
            }

            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onPrev() {
                if (this.this$0.getView() != null) {
                    OnBoardingFragment onBoardingFragment = this.this$0;
                    if (onBoardingFragment.getBinding().onboardingViewpager2.getCurrentItem() - 1 < 0) {
                        return;
                    }
                    onBoardingFragment.getBinding().onboardingViewpager2.setCurrentItem(r1.getCurrentItem() - 1);
                    onBoardingFragment.getAnalytics().trackLogEvent(new OnBoardingEvents.StoryTapLeftEvent());
                }
            }

            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onComplete() throws Resources.NotFoundException {
                if (StringsKt.isBlank(this.this$0.getPrefManager().getJwtToken())) {
                    return;
                }
                if (this.this$0.getPrefManager().getIsNoDomofon()) {
                    Uri uri = Uri.parse(this.this$0.getString(R$string.deeplink_main_no_intercom));
                    FragmentKt.findNavController(this.this$0).popBackStack(R$id.onboardingFragment, true);
                    NavController navControllerFindNavController = FragmentKt.findNavController(this.this$0);
                    Intrinsics.checkNotNull(uri);
                    navControllerFindNavController.navigate(uri);
                    return;
                }
                Uri uri2 = Uri.parse(this.this$0.getString(R$string.deeplink_main));
                FragmentKt.findNavController(this.this$0).popBackStack(R$id.onboardingFragment, true);
                NavController navControllerFindNavController2 = FragmentKt.findNavController(this.this$0);
                Intrinsics.checkNotNull(uri2);
                navControllerFindNavController2.navigate(uri2);
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().stories.resume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().stories.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (getView() != null) {
            getBinding().stories.destroy();
        }
        super.onDestroy();
    }
}
