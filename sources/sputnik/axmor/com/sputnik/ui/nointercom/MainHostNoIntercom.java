package sputnik.axmor.com.sputnik.ui.nointercom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.analytics.SupportEvents;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.popup.Appearance;
import com.sputnik.common.entities.popup.Image;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.popup.PopupTriggers;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.BottomNavigationAction;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewState;
import com.sputnik.common.viewmodels.PopupStoriesDataState;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.MainHostNoIntercomFragmentBinding;
import sputnik.axmor.com.sputnik.core.push.PushTokenManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.MainHostFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;

/* compiled from: MainHostNoIntercom.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u0019\u0010!\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010N\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010N\u001a\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010N\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010N\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010N\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010N\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010N\u001a\u0004\br\u0010sR\"\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020v0u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010x¨\u0006y"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/nointercom/MainHostNoIntercom;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "id", "", "hideBadge", "(I)V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", "state", "updateLocalization", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "updateToken", "hideBottomMenu", "showBottomMenu", "addMarketItem", "setupWhiteBottomBar", "setupBottomNavigationBar", "destination", "trackNavigationAnalytics", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "onViewStateRestored", "(Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/MainHostNoIntercomFragmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/MainHostNoIntercomFragmentBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel$delegate", "getPopupStoriesViewModel", "()Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "", "navigationAnalyticsMap", "Ljava/util/Map;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainHostNoIntercom extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MainHostNoIntercom.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/MainHostNoIntercomFragmentBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasViewModelFactory;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    private Map<Integer, Long> navigationAnalyticsMap;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: popupStoriesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy popupStoriesViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* compiled from: MainHostNoIntercom.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockingLevel.values().length];
            try {
                iArr[BlockingLevel.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainHostNoIntercomFragmentBinding getBinding() {
        return (MainHostNoIntercomFragmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasViewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    private final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupStoriesViewModel getPopupStoriesViewModel() {
        return (PopupStoriesViewModel) this.popupStoriesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        requireActivity().getWindow().setSoftInputMode(16);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(512);
    }

    private final void hideBadge(int id) {
        BadgeDrawable orCreateBadge = getBinding().bottomNavigation.getOrCreateBadge(id);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        NavigationViewModel navigationViewModel = getNavigationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        navigationViewModel.observeState(viewLifecycleOwner, new Function1<NavigationViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationViewState navigationViewState) {
                invoke2(navigationViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavigationViewState it) {
                BottomNavigationAction bottomAction;
                Integer deeplinkInt;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getNeedToHideBottomMenu()) {
                    MainHostNoIntercom.this.hideBottomMenu();
                } else {
                    MainHostNoIntercom.this.showBottomMenu();
                }
                NavigationScenario action = it.getAction();
                if (action == null || (bottomAction = action.getBottomAction()) == null || (deeplinkInt = bottomAction.getDeeplinkInt()) == null) {
                    return;
                }
                MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                try {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainHostNoIntercom), null, null, new MainHostNoIntercom$onViewCreated$1$1$1$1(deeplinkInt.intValue(), mainHostNoIntercom, null), 3, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (savedInstanceState == null) {
            setupBottomNavigationBar();
        }
        getPrefManager().updateIsNoDomofon(true);
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        camerasViewModel.observeSubState(viewLifecycleOwner2, new Function1<AllCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.3
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
                    MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostNoIntercom.getCamerasViewModel().loadDemoCameras();
                    }
                }
            }
        });
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner3, new Function1<FamilyViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FamilyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FamilyViewState familyViewState) {
                invoke2(familyViewState);
                return Unit.INSTANCE;
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner4, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.6
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
                    MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(mainHostNoIntercom.getProfileViewModel(), false, 1, null);
                    }
                }
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner5, new Function1<MarketViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.8
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
                    MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostNoIntercom.getMarketViewModel().updateAllMarket();
                    }
                }
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel2.observeState(viewLifecycleOwner6, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getUserLocale() == null || Intrinsics.areEqual(it.getUserLocale(), MainHostNoIntercom.this.getPrefManager().getCurLocale())) {
                    return;
                }
                LocalizationViewModel localizationViewModel = MainHostNoIntercom.this.getLocalizationViewModel();
                String userLocale = it.getUserLocale();
                Intrinsics.checkNotNull(userLocale);
                localizationViewModel.loadLocalization(userLocale);
                PrefManager prefManager = MainHostNoIntercom.this.getPrefManager();
                String userLocale2 = it.getUserLocale();
                Intrinsics.checkNotNull(userLocale2);
                prefManager.updateUserLocale(userLocale2);
            }
        });
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        localizationViewModel.observeSubState(viewLifecycleOwner7, new Function1<LocalizationViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.10
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.11
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
                    MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostNoIntercom.requireActivity().recreate();
                    }
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner8, new Function1<ProfileViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.12
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getIsShowLoader());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                LinearLayout mainLoader = MainHostNoIntercom.this.getBinding().mainLoader;
                Intrinsics.checkNotNullExpressionValue(mainLoader, "mainLoader");
                ViewBindingUtilsKt.visibilityBasedOn(mainLoader, Boolean.valueOf(z));
            }
        });
        ProfileViewModel profileViewModel4 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        profileViewModel4.observeState(viewLifecycleOwner9, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.14
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getProfileServerState() == Resource.Status.SUCCESS) {
                    MainHostNoIntercom.this.updateLocalization(it);
                }
            }
        });
        ProfileViewModel profileViewModel5 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        profileViewModel5.observeState(viewLifecycleOwner10, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.15
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getProfileServerState() == Resource.Status.SUCCESS) {
                    MainHostNoIntercom.this.updateToken(it);
                }
            }
        });
        IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
        PopupStoriesViewModel popupStoriesViewModel = getPopupStoriesViewModel();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "getViewLifecycleOwner(...)");
        popupStoriesViewModel.observeState(viewLifecycleOwner11, new Function1<PopupStoriesDataState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.onViewCreated.16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PopupStoriesDataState popupStoriesDataState) {
                invoke2(popupStoriesDataState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopupStoriesDataState state) {
                List<PopupStoryStructure> stories;
                PopupStoryStructure popupStoryStructure;
                String url;
                Image image;
                Intrinsics.checkNotNullParameter(state, "state");
                if (state.getStories() == null || !(!r0.isEmpty()) || (stories = state.getStories()) == null || (popupStoryStructure = (PopupStoryStructure) CollectionsKt.firstOrNull((List) stories)) == null) {
                    return;
                }
                final MainHostNoIntercom mainHostNoIntercom = MainHostNoIntercom.this;
                for (final PopupStory popupStory : popupStoryStructure.getPopupStories()) {
                    final String url2 = popupStory.getAppearance().getBackground().getUrl();
                    String url3 = null;
                    if (url2 != null) {
                        if (StringsKt.isBlank(url2)) {
                            url2 = null;
                        }
                        if (url2 != null) {
                            PopupStoriesViewModel popupStoriesViewModel2 = mainHostNoIntercom.getPopupStoriesViewModel();
                            if ((popupStoriesViewModel2 != null ? popupStoriesViewModel2.getCachedImage(url2) : null) == null) {
                                Glide.with(mainHostNoIntercom).asBitmap().load(url2).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$onViewCreated$16$1$1$2$1
                                    @Override // com.bumptech.glide.request.target.Target
                                    public void onLoadCleared(Drawable placeholder) {
                                    }

                                    @Override // com.bumptech.glide.request.target.Target
                                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                    }

                                    public void onResourceReady(Bitmap p0, Transition<? super Bitmap> p1) {
                                        Intrinsics.checkNotNullParameter(p0, "p0");
                                        mainHostNoIntercom.getPopupStoriesViewModel().cacheImage(url2, p0);
                                    }
                                });
                            }
                        }
                    }
                    Image image2 = popupStory.getAppearance().getImage();
                    if (image2 != null && (url = image2.getUrl()) != null) {
                        PopupStoriesViewModel popupStoriesViewModel3 = mainHostNoIntercom.getPopupStoriesViewModel();
                        if ((popupStoriesViewModel3 != null ? popupStoriesViewModel3.getCachedImage(url) : null) == null) {
                            RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(mainHostNoIntercom).asBitmap();
                            Appearance appearance = popupStory.getAppearance();
                            if (appearance != null && (image = appearance.getImage()) != null) {
                                url3 = image.getUrl();
                            }
                            requestBuilderAsBitmap.load(url3).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$onViewCreated$16$1$1$3$1
                                @Override // com.bumptech.glide.request.target.Target
                                public void onLoadCleared(Drawable placeholder) {
                                }

                                @Override // com.bumptech.glide.request.target.Target
                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                }

                                public void onResourceReady(Bitmap p0, Transition<? super Bitmap> p1) {
                                    Image image3;
                                    Intrinsics.checkNotNullParameter(p0, "p0");
                                    PopupStoriesViewModel popupStoriesViewModel4 = mainHostNoIntercom.getPopupStoriesViewModel();
                                    Appearance appearance2 = popupStory.getAppearance();
                                    popupStoriesViewModel4.cacheImage((appearance2 == null || (image3 = appearance2.getImage()) == null) ? null : image3.getUrl(), p0);
                                }
                            });
                        }
                    }
                }
                if (state.getIsStoriesShowed() || !Intrinsics.areEqual(popupStoryStructure.getTrigger(), PopupTriggers.main.toString())) {
                    return;
                }
                mainHostNoIntercom.getPopupStoriesViewModel().markStoriesAsShowed();
                NavController navController = mainHostNoIntercom.getNavController();
                if (navController != null) {
                    NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_popupStories, null, null, 6, null);
                }
            }
        });
        getPopupStoriesViewModel().loadPopupStoriesIfNeeded();
        getProfileViewModel().setIsAppLoaded();
    }

    public MainHostNoIntercom() {
        super(R.layout.main_host_no_intercom_fragment);
        this.binding = new ViewBindingFragmentDelegate(this, MainHostNoIntercom$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory camerasViewModelFactory = this.this$0.getCamerasViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                return camerasViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.popupStoriesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PopupStoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$special$$inlined$activityViewModels$default$20
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$popupStoriesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment);
            }
        });
        this.navigationAnalyticsMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocalization(ProfileViewState state) {
        String userLocale = state.getUserLocale();
        MainHostFragment.Companion companion = MainHostFragment.INSTANCE;
        if (companion.isLocaleSent()) {
            return;
        }
        if (userLocale != null && !StringsKt.isBlank(userLocale)) {
            getProfileViewModel().setLocalization(userLocale);
        }
        companion.setLocaleSent(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToken(final ProfileViewState state) {
        PushTokenManager.INSTANCE.requestToken(new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom.updateToken.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                String contentIfNotHandled = state.getPushTokenServerState().getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostNoIntercom mainHostNoIntercom = this;
                    if (Intrinsics.areEqual(token, contentIfNotHandled)) {
                        return;
                    }
                    MainHostFragment.Companion companion = MainHostFragment.INSTANCE;
                    if (companion.isPushTokenSent()) {
                        return;
                    }
                    mainHostNoIntercom.getProfileViewModel().sendPushToken(token);
                    companion.setPushTokenSent(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBottomMenu() {
        try {
            BottomNavigationView bottomNavigation = getBinding().bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(bottomNavigation, "bottomNavigation");
            ViewKt.gone(bottomNavigation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomMenu() {
        try {
            BottomNavigationView bottomNavigation = getBinding().bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(bottomNavigation, "bottomNavigation");
            ViewKt.visible(bottomNavigation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void addMarketItem() {
        if (getBinding().bottomNavigation.getMenu().size() < 4) {
            Menu menu = getBinding().bottomNavigation.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            menu.removeItem(R.id.navigation_help);
            menu.add(0, R.id.navigation_market, 0, getString(R.string.nav_market)).setIcon(R.drawable.ic_nav_market);
            menu.add(0, R.id.navigation_help, 0, getString(R.string.nav_help)).setIcon(R.drawable.ic_nav_help);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getCamerasViewModel().handleNeedUpdate(true);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        setupBottomNavigationBar();
    }

    private final void setupWhiteBottomBar() {
        getBinding().bottomNavigation.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.sputnik_header_black)));
        getBinding().bottomNavigation.setBackground(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.white)));
    }

    private final void setupBottomNavigationBar() {
        addMarketItem();
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.main_host_fragment);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavController navController = ((NavHostFragment) fragmentFindFragmentById).getNavController();
        GlobalVariables globalVariables = GlobalVariables.INSTANCE;
        globalVariables.setBottomNavigationView(getBinding().bottomNavigation);
        globalVariables.setBottomController(navController);
        BottomNavigationView bottomNavigationView = getBinding().bottomNavigation;
        Intrinsics.checkNotNull(bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setBackground(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.black_800)));
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$$ExternalSyntheticLambda0
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener
            public final void onNavigationItemReselected(MenuItem menuItem) {
                Intrinsics.checkNotNullParameter(menuItem, "it");
            }
        });
        ViewKt.addSystemWindowInsetToPadding$default(bottomNavigationView, true, false, true, true, 2, null);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$$ExternalSyntheticLambda1
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController2, NavDestination navDestination, Bundle bundle) {
                MainHostNoIntercom.setupBottomNavigationBar$lambda$5$lambda$4(this.f$0, navController2, navDestination, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomNavigationBar$lambda$5$lambda$4(MainHostNoIntercom this$0, NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this$0.trackNavigationAnalytics(destination.getId());
        if (destination.getId() == R.id.navigation_help) {
            this$0.hideBadge(R.id.navigation_help);
            this$0.setupWhiteBottomBar();
        }
        if (destination.getId() == R.id.navigation_camera) {
            int color = ContextCompat.getColor(this$0.requireContext(), WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1 ? R.color.black_bottom_nav : R.color.black_bottom_nav_transparent);
            this$0.getBinding().bottomNavigation.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.white)));
            this$0.getBinding().bottomNavigation.setBackground(new ColorDrawable(color));
        } else {
            this$0.getBinding().bottomNavigation.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this$0.requireContext(), R.color.sputnik_header_black)));
            this$0.getBinding().bottomNavigation.setBackground(new ColorDrawable(ContextCompat.getColor(this$0.requireContext(), R.color.white)));
        }
    }

    private final void trackNavigationAnalytics(int destination) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.navigationAnalyticsMap.getOrDefault(Integer.valueOf(destination), 0L).longValue() > 300) {
            this.navigationAnalyticsMap.put(Integer.valueOf(destination), Long.valueOf(jCurrentTimeMillis));
            if (destination == R.id.navigation_help) {
                getAnalytics().trackLogEvent(new SupportEvents.ClickOpenSupport());
            } else {
                if (destination != R.id.navigation_profile) {
                    return;
                }
                getAnalytics().trackLogEvent(new GeneralEvents.ClickProfile());
            }
        }
    }
}
