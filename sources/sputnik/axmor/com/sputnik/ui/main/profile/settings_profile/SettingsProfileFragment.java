package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContract;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileNavigationBody;
import com.sputnik.common.entities.localization.ProfileSettingsBody;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.entities.localization.ProfileSubscriptionBody;
import com.sputnik.common.entities.localization.entities.common.TextErrorPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.login.RegisterBody;
import com.sputnik.common.entities.localization.entities.login.RegisterLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionBody;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionInfoView;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionStopBody;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.subscription.ActivePlan;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.EditModeData;
import com.sputnik.common.viewmodels.MainProfileData;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.services.ServiceState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentProfileBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;

/* compiled from: SettingsProfileFragment.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J!\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0003R#\u0010&\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u001b\u0010R\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010E\u001a\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010E\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010E\u001a\u0004\bZ\u0010[R\"\u0010_\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010^0^0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006a"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/SettingsProfileFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/MainProfileData;", RemoteMessageConst.DATA, "", "renderUi", "(Lcom/sputnik/common/viewmodels/MainProfileData;)V", "", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "renderSubscriptionUi", "(Ljava/util/List;)V", "renderSubscriptionInfo", "", "isEditMode", "renderEditMode", "(Z)V", "selectImageFromGallery", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentProfileBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentProfileBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "settingsProfileFactoryBuilder", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "getSettingsProfileFactoryBuilder", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "setSettingsProfileFactoryBuilder", "(Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "Lkotlin/Lazy;", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel;", "settingsProfileViewModel$delegate", "getSettingsProfileViewModel", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel;", "settingsProfileViewModel", "Landroidx/activity/result/ActivityResultLauncher;", "", "selectImageFromGalleryResult", "Landroidx/activity/result/ActivityResultLauncher;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsProfileFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SettingsProfileFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentProfileBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<String> selectImageFromGalleryResult;
    public SettingsProfileViewModel.Factory.AssistFactory settingsProfileFactoryBuilder;

    /* renamed from: settingsProfileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsProfileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderSubscriptionUi(List<Subscription> data) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentProfileBinding getBinding() {
        return (FragmentProfileBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final SettingsProfileViewModel.Factory.AssistFactory getSettingsProfileFactoryBuilder() {
        SettingsProfileViewModel.Factory.AssistFactory assistFactory = this.settingsProfileFactoryBuilder;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsProfileFactoryBuilder");
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

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsProfileViewModel getSettingsProfileViewModel() {
        return (SettingsProfileViewModel) this.settingsProfileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectImageFromGalleryResult$lambda$1(SettingsProfileFragment this$0, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SettingsProfileFragment$selectImageFromGalleryResult$1$1(null), 3, null);
        if (uri != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SettingsProfileFragment$selectImageFromGalleryResult$1$2$1(this$0.requireActivity().getContentResolver().openInputStream(uri), this$0, null), 3, null);
        }
    }

    public SettingsProfileFragment() {
        super(R.layout.fragment_profile);
        this.binding = new ViewBindingFragmentDelegate(this, SettingsProfileFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$navController$2
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
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$settingsProfileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                RegisterLocale register;
                RegisterBody body;
                TextErrorPlaceHolder firstNameTextField;
                SettingsProfileViewModel.Factory.AssistFactory settingsProfileFactoryBuilder = this.this$0.getSettingsProfileFactoryBuilder();
                Bundle arguments = this.this$0.getArguments();
                String error = null;
                Profile profile = arguments != null ? (Profile) arguments.getParcelable(Scopes.PROFILE) : null;
                String firstName = profile != null ? profile.getFirstName() : null;
                Bundle arguments2 = this.this$0.getArguments();
                Profile profile2 = arguments2 != null ? (Profile) arguments2.getParcelable(Scopes.PROFILE) : null;
                String avatar = profile2 != null ? profile2.getAvatar() : null;
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                if (data != null && (register = data.getRegister()) != null && (body = register.getBody()) != null && (firstNameTextField = body.getFirstNameTextField()) != null) {
                    error = firstNameTextField.getError();
                }
                return settingsProfileFactoryBuilder.create(firstName, avatar, error);
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.settingsProfileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContract<String, Uri>() { // from class: androidx.activity.result.contract.ActivityResultContracts$GetContent
            @Override // androidx.view.result.contract.ActivityResultContract
            public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                return null;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
                Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_GET…          .setType(input)");
                return type;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.view.result.contract.ActivityResultContract
            public final Uri parseResult(int resultCode, Intent intent) {
                if (resultCode != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            }
        }, new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws FileNotFoundException {
                SettingsProfileFragment.selectImageFromGalleryResult$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectImageFromGalleryResult = activityResultLauncherRegisterForActivityResult;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireActivity().getWindow().setSoftInputMode(16);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Scopes.PROFILE, "show", null, 4, null);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends ProfileNavigationState> event) throws Resources.NotFoundException {
                invoke2(event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<? extends ProfileNavigationState> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    SettingsProfileFragment settingsProfileFragment = SettingsProfileFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToLoginState) {
                        if (settingsProfileFragment.getPrefManager().getIsNoDomofon()) {
                            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(settingsProfileFragment), R.id.profileSettingsFragment, R.id.action_profileNoIntercomSettingsFragment_to_auth_navigation, null, null, 12, null);
                        } else {
                            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(settingsProfileFragment), R.id.profileSettingsFragment, R.id.action_profileSettingsFragment_to_auth_navigation, null, null, 12, null);
                        }
                    }
                }
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.3
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
                SettingsProfileFragment settingsProfileFragment = SettingsProfileFragment.this;
                View root = settingsProfileFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(settingsProfileFragment, root, it);
            }
        });
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner3, new Function1<FamilyViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.4
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
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner4, new Function1<MarketViewState, List<? extends Subscription>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final List<Subscription> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSubscriptions();
            }
        }, new AnonymousClass6(this));
        MarketViewModel marketViewModel2 = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        marketViewModel2.observeSubState(viewLifecycleOwner5, new Function1<MarketViewState, List<? extends Subscription>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final List<Subscription> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSubscriptions();
            }
        }, new AnonymousClass8(this));
        SettingsProfileViewModel settingsProfileViewModel = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        settingsProfileViewModel.observeSubState(viewLifecycleOwner6, new AnonymousClass9(MainProfileData.INSTANCE), new AnonymousClass10(this));
        SettingsProfileViewModel settingsProfileViewModel2 = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        settingsProfileViewModel2.observeSubState(viewLifecycleOwner7, new Function1<SettingsProfileViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.11
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SettingsProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getEditMode().isEditMode());
            }
        }, new AnonymousClass12(this));
        SettingsProfileViewModel settingsProfileViewModel3 = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        settingsProfileViewModel3.observeNotifications(viewLifecycleOwner8, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.13
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
                SettingsProfileFragment settingsProfileFragment = SettingsProfileFragment.this;
                View root = settingsProfileFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(settingsProfileFragment, root, it);
            }
        });
        SettingsProfileViewModel settingsProfileViewModel4 = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        settingsProfileViewModel4.observeSubState(viewLifecycleOwner9, new Function1<SettingsProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.14
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SettingsProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedData();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.15
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
                ProfileSettingsLocale profileSettings;
                List<String> messages;
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    SettingsProfileFragment settingsProfileFragment = SettingsProfileFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(settingsProfileFragment.getProfileViewModel(), false, 1, null);
                        settingsProfileFragment.getFamilyViewModel().handleNeedUpdate();
                        LocalizationLocalModel data = settingsProfileFragment.getLocalizationScreen().getData();
                        if (data == null || (profileSettings = data.getProfileSettings()) == null || (messages = profileSettings.getMessages()) == null || (str = (String) CollectionsKt.first((List) messages)) == null) {
                            return;
                        }
                        settingsProfileFragment.getSettingsProfileViewModel().notifySuccessMessage(str);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        profileViewModel3.observeState(viewLifecycleOwner10, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment.onViewCreated.16
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
                Profile profile = it.getProfile();
                if (profile != null) {
                    SettingsProfileFragment settingsProfileFragment = SettingsProfileFragment.this;
                    Glide.with(settingsProfileFragment).load(profile.getAvatar()).circleCrop().placeholder(R.drawable.ic_group_image).into(settingsProfileFragment.getBinding().ivPhoto);
                }
                LinearLayout profileLoader = SettingsProfileFragment.this.getBinding().profileLoader;
                Intrinsics.checkNotNullExpressionValue(profileLoader, "profileLoader");
                ViewBindingUtilsKt.visibilityBasedOn(profileLoader, Boolean.valueOf(it.getServerState() == Resource.Status.LOADING));
            }
        });
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<List<? extends Subscription>, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, SettingsProfileFragment.class, "renderSubscriptionUi", "renderSubscriptionUi(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subscription> list) {
            invoke2((List<Subscription>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Subscription> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SettingsProfileFragment) this.receiver).renderSubscriptionUi(p0);
        }
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$onViewCreated$8, reason: invalid class name */
    /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<List<? extends Subscription>, Unit> {
        AnonymousClass8(Object obj) {
            super(1, obj, SettingsProfileFragment.class, "renderSubscriptionInfo", "renderSubscriptionInfo(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subscription> list) {
            invoke2((List<Subscription>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Subscription> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SettingsProfileFragment) this.receiver).renderSubscriptionInfo(p0);
        }
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$onViewCreated$9, reason: invalid class name */
    /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<SettingsProfileViewState, MainProfileData> {
        AnonymousClass9(Object obj) {
            super(1, obj, MainProfileData.Companion.class, "toMainProfileData", "toMainProfileData(Lcom/sputnik/common/viewmodels/SettingsProfileViewState;)Lcom/sputnik/common/viewmodels/MainProfileData;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MainProfileData invoke(SettingsProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((MainProfileData.Companion) this.receiver).toMainProfileData(p0);
        }
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$onViewCreated$10, reason: invalid class name */
    /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<MainProfileData, Unit> {
        AnonymousClass10(Object obj) {
            super(1, obj, SettingsProfileFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/MainProfileData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MainProfileData mainProfileData) {
            invoke2(mainProfileData);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MainProfileData p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SettingsProfileFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$onViewCreated$12, reason: invalid class name */
    /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        AnonymousClass12(Object obj) {
            super(1, obj, SettingsProfileFragment.class, "renderEditMode", "renderEditMode(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((SettingsProfileFragment) this.receiver).renderEditMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(MainProfileData data) {
        FragmentProfileBinding binding = getBinding();
        if (!Intrinsics.areEqual(binding.tvName.getText().toString(), data.getName())) {
            binding.tvName.setText(data.getName());
        }
        binding.tvPhone.setText(getPrefManager().getPhone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionInfo(List<Subscription> data) {
        Object next;
        Object next2;
        String str;
        int i;
        SubscriptionStopBody subscriptionStopBody;
        SettingsSubscriptionLocale subscriptionSettings;
        SettingsSubscriptionBody body;
        SettingsSubscriptionInfoView subscriptionInfoView;
        List<Subscription> list = data;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Subscription subscription = (Subscription) next;
            if (subscription.getState() != ServiceState.deactivated || Intrinsics.areEqual(subscription.getPrimeSubscription(), Boolean.TRUE)) {
                break;
            }
        }
        Subscription subscription2 = (Subscription) next;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it2.next();
                if (((Subscription) next2).getState() == ServiceState.activated) {
                    break;
                }
            }
        }
        Subscription subscription3 = (Subscription) next2;
        ConstraintLayout layoutSub = getBinding().layoutSub;
        Intrinsics.checkNotNullExpressionValue(layoutSub, "layoutSub");
        ViewBindingUtilsKt.visibilityBasedOn(layoutSub, Boolean.valueOf(subscription3 != null));
        if (subscription3 != null) {
            TextView tvSubTitle = getBinding().tvSubTitle;
            Intrinsics.checkNotNullExpressionValue(tvSubTitle, "tvSubTitle");
            ViewKt.visible(tvSubTitle);
            ConstraintLayout cardRoot = getBinding().cardRoot;
            Intrinsics.checkNotNullExpressionValue(cardRoot, "cardRoot");
            ViewKt.visible(cardRoot);
        } else {
            TextView tvSubTitle2 = getBinding().tvSubTitle;
            Intrinsics.checkNotNullExpressionValue(tvSubTitle2, "tvSubTitle");
            ViewKt.gone(tvSubTitle2);
            ConstraintLayout cardRoot2 = getBinding().cardRoot;
            Intrinsics.checkNotNullExpressionValue(cardRoot2, "cardRoot");
            ViewKt.gone(cardRoot2);
        }
        if (subscription2 != null) {
            FragmentProfileBinding binding = getBinding();
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            List<String> subtitles = (data2 == null || (subscriptionSettings = data2.getSubscriptionSettings()) == null || (body = subscriptionSettings.getBody()) == null || (subscriptionInfoView = body.getSubscriptionInfoView()) == null) ? null : subscriptionInfoView.getSubtitles();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int color = ContextCompat.getColor(contextRequireContext, R.color.sputnik_header_black);
            TextView textView = binding.tvSubscriptionPayedUntil;
            String str2 = subtitles != null ? (String) CollectionsKt.first((List) subtitles) : null;
            String str3 = str2 + ": " + subscription2.getExpiresDate();
            String strValueOf = String.valueOf(subtitles != null ? (String) CollectionsKt.first((List) subtitles) : null);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            textView.setText(ViewUtilsKt.highlightText(str3, strValueOf, color, contextRequireContext2, R.style.TextView_Body2_Selection));
            TextView textView2 = binding.tvSubscriptionPrice;
            String str4 = subtitles != null ? (String) CollectionsKt.last((List) subtitles) : null;
            ActivePlan activePlan = subscription2.getActivePlan();
            String priceVerbose = activePlan != null ? activePlan.getPriceVerbose() : null;
            if (Intrinsics.areEqual(subscription2.getAutoRenewStatus(), Boolean.FALSE)) {
                LocalizationLocalModel data3 = getLocalizationScreen().getData();
                str = "\n" + ((data3 == null || (subscriptionStopBody = data3.getSubscriptionStopBody()) == null) ? null : subscriptionStopBody.getAutoRenewDisabled());
            } else {
                str = "";
            }
            String str5 = str4 + ": " + priceVerbose + str;
            String strValueOf2 = String.valueOf(subtitles != null ? (String) CollectionsKt.last((List) subtitles) : null);
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            textView2.setText(ViewUtilsKt.highlightText(str5, strValueOf2, color, contextRequireContext3, R.style.TextView_Body2_Selection));
            Badge badge = subscription2.getBadge();
            String color2 = badge != null ? badge.getColor() : null;
            if (Intrinsics.areEqual(color2, "blue")) {
                i = R.color.sputnik_blue;
            } else {
                Intrinsics.areEqual(color2, "green");
                i = R.color.sputnik_green;
            }
            ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, i);
            TextView textView3 = binding.tvSubscriptionTitle;
            Badge badge2 = subscription2.getBadge();
            textView3.setText(badge2 != null ? badge2.getTitle() : null);
            textView3.setBackgroundTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderEditMode(boolean isEditMode) {
        getBinding().btnApply.setEnabled(isEditMode);
    }

    private final void selectImageFromGallery() {
        this.selectImageFromGalleryResult.launch("image/*");
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final FragmentProfileBinding binding = getBinding();
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$initViews$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String string = binding.tvName.getText().toString();
                ViewKt.hideKeyboard(it);
                SputnikApp.Companion companion = SputnikApp.INSTANCE;
                companion.getAnalyticsService().send(Scopes.PROFILE, "save_change", "first_name");
                companion.getAnalyticsService().send(Scopes.PROFILE, "save_change", "last_name");
                this.getSettingsProfileViewModel().saveProfileData(string);
            }
        }, 1, null);
        binding.btnDelete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SettingsProfileFragment.initViews$lambda$14$lambda$8(this.f$0, view);
            }
        });
        binding.cardRoot.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SettingsProfileFragment.initViews$lambda$14$lambda$9(this.f$0, view);
            }
        });
        EditText tvName = binding.tvName;
        Intrinsics.checkNotNullExpressionValue(tvName, "tvName");
        tvName.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$initViews$lambda$14$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Profile profile = this.this$0.getProfileViewModel().getCurrentState().getProfile();
                boolean z = !Intrinsics.areEqual(profile != null ? profile.getFirstName() : null, String.valueOf(s));
                SettingsProfileViewModel settingsProfileViewModel = this.this$0.getSettingsProfileViewModel();
                settingsProfileViewModel.handleEditMode(EditModeData.copy$default(settingsProfileViewModel.getCurrentState().getEditMode(), z, false, 2, null));
                this.this$0.getSettingsProfileViewModel().handleName(String.valueOf(s));
            }
        });
        binding.ivPhoto.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsProfileFragment.initViews$lambda$14$lambda$12(this.f$0, view);
            }
        });
        binding.buttonExit.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SettingsProfileFragment.initViews$lambda$14$lambda$13(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14$lambda$8(SettingsProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.profileSettingsFragment, R.id.action_profileSettingsFragment_to_deleteAccount, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14$lambda$9(SettingsProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.profileSettingsFragment, R.id.action_profileSettingsFragment_to_servicesInfoFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14$lambda$12(SettingsProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SputnikRootActivity.INSTANCE.setSplashInAppEnabled(false);
        this$0.selectImageFromGallery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$14$lambda$13(SettingsProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.profileSettingsFragment, R.id.action_profileNoIntercomSettingsFragment_to_logoutDialog, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        ProfileSettingsLocale profileSettings;
        ProfileSettingsBody body;
        ProfileSettingsLocale profileSettings2;
        ProfileSubscriptionBody subscription;
        ProfileSettingsLocale profileSettings3;
        ProfileNavigationBody navigation;
        TextTitle exitButton;
        ProfileSettingsLocale profileSettings4;
        ProfileNavigationBody navigation2;
        FragmentProfileBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data == null || (profileSettings4 = data.getProfileSettings()) == null || (navigation2 = profileSettings4.getNavigation()) == null) ? null : navigation2.getTitle());
        TextView textView = binding.buttonExit;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText(String.valueOf((data2 == null || (profileSettings3 = data2.getProfileSettings()) == null || (navigation = profileSettings3.getNavigation()) == null || (exitButton = navigation.getExitButton()) == null) ? null : exitButton.getTitle()));
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 == null || (profileSettings = data3.getProfileSettings()) == null || (body = profileSettings.getBody()) == null) {
            return;
        }
        TextView textView2 = binding.etNameTitle;
        TextTitle nameField = body.getNameField();
        textView2.setText(nameField != null ? nameField.getTitle() : null);
        TextView textView3 = binding.etPhoneTitle;
        TextTitle phoneField = body.getPhoneField();
        textView3.setText(phoneField != null ? phoneField.getTitle() : null);
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle saveButton = body.getSaveButton();
        appCompatButton.setText(saveButton != null ? saveButton.getTitle() : null);
        AppCompatButton appCompatButton2 = binding.btnDelete;
        TextTitle deleteButton = body.getDeleteButton();
        appCompatButton2.setText(deleteButton != null ? deleteButton.getTitle() : null);
        binding.tvChangeAvatarDescription.setText(body.getAvatar());
        TextView textView4 = binding.tvSubTitle;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (profileSettings2 = data4.getProfileSettings()) != null && (subscription = profileSettings2.getSubscription()) != null) {
            title = subscription.getTitle();
        }
        textView4.setText(title);
    }
}
