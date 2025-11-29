package com.sputnik.oboarding.ui.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.StartLanguageLocale;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.StoriesDataState;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentFinishSplashBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: FinishSplashFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/sputnik/oboarding/ui/splash/FinishSplashFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/StoriesDataState;", "serverData", "", "renderUi", "(Lcom/sputnik/common/viewmodels/StoriesDataState;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentFinishSplashBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentFinishSplashBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel$delegate", "Lkotlin/Lazy;", "getStoriesViewModel", "()Lcom/sputnik/common/viewmodels/StoriesViewModel;", "storiesViewModel", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FinishSplashFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FinishSplashFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentFinishSplashBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;
    public PrefManager prefManager;

    /* renamed from: storiesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy storiesViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentFinishSplashBinding getBinding() {
        return (FragmentFinishSplashBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoriesViewModel getStoriesViewModel() {
        return (StoriesViewModel) this.storiesViewModel.getValue();
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
        localize();
        getStoriesViewModel().loadOnboardingStories();
        StoriesViewModel storiesViewModel = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        storiesViewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FinishSplashFragment finishSplashFragment = FinishSplashFragment.this;
                ConstraintLayout root = finishSplashFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(finishSplashFragment, root, it);
            }
        });
        StoriesViewModel storiesViewModel2 = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        storiesViewModel2.observeSubState(viewLifecycleOwner2, new Function1<StoriesDataState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(StoriesDataState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getOnBoardingIsLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    FinishSplashFragment finishSplashFragment = FinishSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        finishSplashFragment.renderUi(finishSplashFragment.getStoriesViewModel().getCurrentState());
                    }
                }
            }
        });
        StoriesViewModel storiesViewModel3 = getStoriesViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        storiesViewModel3.observeState(viewLifecycleOwner3, new Function1<StoriesDataState, Unit>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoriesDataState storiesDataState) throws Resources.NotFoundException {
                invoke2(storiesDataState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoriesDataState serverData) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                if (serverData.getServerState() == Resource.Status.SUCCESS) {
                    Log.e("cacheSize", String.valueOf(serverData.getCacheSize()));
                    List<Story> stories = serverData.getStories();
                    if (stories != null && stories.isEmpty()) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(FinishSplashFragment.this), R$id.finishSplashFragment, R$id.action_finishSplashFragment_to_registration_navigation, null, null, 12, null);
                        return;
                    }
                    int cacheSize = serverData.getCacheSize();
                    List<Story> stories2 = serverData.getStories();
                    if (cacheSize >= (stories2 != null ? stories2.size() : 0) / 2) {
                        FinishSplashFragment.this.getAnalytics().trackLogEvent(new OnBoardingEvents.StartStoryEvent());
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(FinishSplashFragment.this), R$id.finishSplashFragment, R$id.action_finishSplashFragment_to_onboarding_navigation, null, null, 12, null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(StoriesDataState serverData) {
        if (serverData.getStories() == null) {
            return;
        }
        List<Story> stories = serverData.getStories();
        Intrinsics.checkNotNull(stories);
        List<Story> stories2 = serverData.getStories();
        Intrinsics.checkNotNull(stories2);
        for (final Story story : stories.subList(0, stories2.size() / 2)) {
            Glide.with(this).asBitmap().load(story.getScreenshot()).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment$renderUi$1$1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    this.this$0.getStoriesViewModel().cacheImage(story.getScreenshot(), resource);
                }
            });
        }
    }

    private final void localize() {
        StartLanguageLocale startLanguageLocale;
        TextTitle body;
        TextView textView = getBinding().title;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        textView.setText((data == null || (startLanguageLocale = data.getStartLanguageLocale()) == null || (body = startLanguageLocale.getBody()) == null) ? null : body.getTitle());
    }

    public FinishSplashFragment() {
        super(R$layout.fragment_finish_splash);
        this.binding = new ViewBindingFragmentDelegate(this, FinishSplashFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.storiesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(StoriesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.splash.FinishSplashFragment$storiesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
