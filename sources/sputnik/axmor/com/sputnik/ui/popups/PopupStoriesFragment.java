package sputnik.axmor.com.sputnik.ui.popups;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.PopupEvents;
import com.sputnik.common.base.adapters.ChildFragmentStateAdapter;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.stories.StoriesProgressView;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.PopupStoriesDataState;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentPopupStoriesBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment;

/* compiled from: PopupStoriesFragment.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001E\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/PopupStoriesDataState;", "state", "renderUi", "(Lcom/sputnik/common/viewmodels/PopupStoriesDataState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Lsputnik/axmor/com/databinding/FragmentPopupStoriesBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentPopupStoriesBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel$delegate", "Lkotlin/Lazy;", "getPopupStoriesViewModel", "()Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel", "", "pressTime", "J", "Landroid/view/View$OnTouchListener;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "sputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment$storiesListener$1", "storiesListener", "Lsputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment$storiesListener$1;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopupStoriesFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PopupStoriesFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentPopupStoriesBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String popupId = "";
    private static String storyId = "";
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener onTouchListener;

    /* renamed from: popupStoriesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy popupStoriesViewModel;
    public PrefManager prefManager;
    private long pressTime;
    private final PopupStoriesFragment$storiesListener$1 storiesListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentPopupStoriesBinding getBinding() {
        return (FragmentPopupStoriesBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupStoriesViewModel getPopupStoriesViewModel() {
        return (PopupStoriesViewModel) this.popupStoriesViewModel.getValue();
    }

    /* compiled from: PopupStoriesFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment$Companion;", "", "<init>", "()V", "", "popupId", "Ljava/lang/String;", "getPopupId", "()Ljava/lang/String;", "setPopupId", "(Ljava/lang/String;)V", "storyId", "getStoryId", "setStoryId", "", "LIMIT", "J", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getPopupId() {
            return PopupStoriesFragment.popupId;
        }

        public final String getStoryId() {
            return PopupStoriesFragment.storyId;
        }

        public final void setStoryId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PopupStoriesFragment.storyId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTouchListener$lambda$2(PopupStoriesFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.pressTime = System.currentTimeMillis();
            if (this$0.getView() != null) {
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
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewPager2 onboardingViewpager2 = getBinding().onboardingViewpager2;
        Intrinsics.checkNotNullExpressionValue(onboardingViewpager2, "onboardingViewpager2");
        ViewKt.addSystemWindowInsetToMargin$default(onboardingViewpager2, false, false, false, true, 7, null);
        FrameLayout storiesContainer = getBinding().storiesContainer;
        Intrinsics.checkNotNullExpressionValue(storiesContainer, "storiesContainer");
        ViewKt.addSystemWindowInsetToMargin$default(storiesContainer, false, true, false, false, 13, null);
        getAnalytics().trackLogEvent(new PopupEvents.ShowScreenOpen(popupId));
        initView();
        PopupStoriesViewModel popupStoriesViewModel = getPopupStoriesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        popupStoriesViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
    }

    /* compiled from: PopupStoriesFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PopupStoriesDataState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, PopupStoriesFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/PopupStoriesDataState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PopupStoriesDataState popupStoriesDataState) {
            invoke2(popupStoriesDataState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PopupStoriesDataState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PopupStoriesFragment) this.receiver).renderUi(p0);
        }
    }

    private final void initView() {
        final FragmentPopupStoriesBinding binding = getBinding();
        ViewPager2 viewPager2 = binding.onboardingViewpager2;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager2.setAdapter(new ChildFragmentStateAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle(), null, 4, null));
        getBinding().onboardingViewpager2.setUserInputEnabled(false);
        getBinding().stories.setStoriesListener(this.storiesListener);
        View view = binding.skip;
        view.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PopupStoriesFragment.initView$lambda$8$lambda$4$lambda$3(binding, view2);
            }
        });
        view.setOnTouchListener(this.onTouchListener);
        View view2 = binding.reverse;
        view2.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PopupStoriesFragment.initView$lambda$8$lambda$6$lambda$5(binding, view3);
            }
        });
        view2.setOnTouchListener(this.onTouchListener);
        binding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PopupStoriesFragment.initView$lambda$8$lambda$7(this.f$0, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$4$lambda$3(FragmentPopupStoriesBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.stories.skip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$6$lambda$5(FragmentPopupStoriesBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.stories.reverse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7(PopupStoriesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new PopupEvents.ClickScreenBtnClose(popupId));
        this$0.getPopupStoriesViewModel().sendStoryAction(popupId, storyId, "close");
        FragmentKt.findNavController(this$0).popBackStack(R.id.popupStoriesFragment, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(PopupStoriesDataState state) {
        if (state.getServerState() == Resource.Status.SUCCESS) {
            List<PopupStoryStructure> stories = state.getStories();
            PopupStoryStructure popupStoryStructure = stories != null ? (PopupStoryStructure) CollectionsKt.firstOrNull((List) stories) : null;
            if (popupStoryStructure != null) {
                popupId = String.valueOf(popupStoryStructure.getId());
                List<PopupStory> popupStories = popupStoryStructure.getPopupStories();
                int size = popupStories != null ? popupStories.size() : 0;
                StoriesProgressView storiesProgressView = getBinding().stories;
                storiesProgressView.setStoriesCount(size);
                List<PopupStory> popupStories2 = popupStoryStructure.getPopupStories();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(popupStories2, 10));
                for (PopupStory popupStory : popupStories2) {
                    arrayList.add(4000L);
                }
                storiesProgressView.setStoriesCountWithDurations(CollectionsKt.toLongArray(arrayList));
                if (popupStoryStructure.getPopupStories().size() > 1) {
                    List<PopupStory> popupStories3 = popupStoryStructure.getPopupStories();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(popupStories3, 10));
                    for (PopupStory popupStory2 : popupStories3) {
                        arrayList2.add(new StoriesProgressView.ProgressBarColor("#" + popupStory2.getAppearance().getBar().getTrackColor(), "#" + popupStory2.getAppearance().getBar().getProgressColor()));
                    }
                    storiesProgressView.setStoriesProgressColors(arrayList2);
                    StoriesProgressView stories2 = getBinding().stories;
                    Intrinsics.checkNotNullExpressionValue(stories2, "stories");
                    ViewKt.visible(stories2);
                    Integer storyPosition = getPopupStoriesViewModel().getStoryPosition();
                    storiesProgressView.startStories(storyPosition != null ? storyPosition.intValue() : 0);
                } else {
                    StoriesProgressView stories3 = getBinding().stories;
                    Intrinsics.checkNotNullExpressionValue(stories3, "stories");
                    ViewKt.gone(stories3);
                }
                RecyclerView.Adapter adapter = getBinding().onboardingViewpager2.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.sputnik.common.base.adapters.ChildFragmentStateAdapter");
                ChildFragmentStateAdapter childFragmentStateAdapter = (ChildFragmentStateAdapter) adapter;
                Iterator<T> it = popupStoryStructure.getPopupStories().iterator();
                while (it.hasNext()) {
                    childFragmentStateAdapter.addFragment(PopupStoryFragment.INSTANCE.newInstance((PopupStory) it.next(), String.valueOf(popupStoryStructure.getId())));
                }
                getBinding().onboardingViewpager2.setOffscreenPageLimit(size);
                getPopupStoriesViewModel().clearServerStatus();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$storiesListener$1] */
    public PopupStoriesFragment() {
        super(R.layout.fragment_popup_stories);
        this.binding = new ViewBindingFragmentDelegate(this, PopupStoriesFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.popupStoriesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PopupStoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$popupStoriesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.onTouchListener = new View.OnTouchListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PopupStoriesFragment.onTouchListener$lambda$2(this.f$0, view, motionEvent);
            }
        };
        this.storiesListener = new StoriesProgressView.StoriesListener() { // from class: sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment$storiesListener$1
            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onNext() {
                if (this.this$0.getView() != null) {
                    PopupStoriesFragment popupStoriesFragment = this.this$0;
                    FragmentPopupStoriesBinding binding = popupStoriesFragment.getBinding();
                    RecyclerView.Adapter adapter = binding.onboardingViewpager2.getAdapter();
                    if (adapter == null || binding.onboardingViewpager2.getCurrentItem() + 1 != adapter.getItemCount()) {
                        ViewPager2 viewPager2 = popupStoriesFragment.getBinding().onboardingViewpager2;
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                    }
                }
            }

            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onPrev() {
                if (this.this$0.getView() != null) {
                    PopupStoriesFragment popupStoriesFragment = this.this$0;
                    if (popupStoriesFragment.getBinding().onboardingViewpager2.getCurrentItem() - 1 < 0) {
                        return;
                    }
                    popupStoriesFragment.getBinding().onboardingViewpager2.setCurrentItem(r0.getCurrentItem() - 1);
                }
            }

            @Override // com.sputnik.common.ui.view.stories.StoriesProgressView.StoriesListener
            public void onComplete() {
                PopupStoriesViewModel popupStoriesViewModel = this.this$0.getPopupStoriesViewModel();
                PopupStoriesFragment.Companion companion = PopupStoriesFragment.INSTANCE;
                popupStoriesViewModel.sendStoryAction(companion.getPopupId(), companion.getStoryId(), "close");
                if (StringsKt.isBlank(this.this$0.getPrefManager().getJwtToken())) {
                    return;
                }
                if (this.this$0.getPrefManager().getIsNoDomofon()) {
                    FragmentKt.findNavController(this.this$0).popBackStack(R.id.popupStoriesFragment, true);
                } else {
                    FragmentKt.findNavController(this.this$0).popBackStack(R.id.popupStoriesFragment, true);
                }
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
