package sputnik.axmor.com.sputnik.ui.nointercom;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.databinding.LayoutCompleteRegistrationBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.demo.DemoModeLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SettingsBody;
import com.sputnik.common.entities.localization.SettingsLocale;
import com.sputnik.common.entities.localization.SettingsNavigation;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdatePlate;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentProfileNoIntercomBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel;
import sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState;

/* compiled from: ProfileNoIntercom.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010I\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010I\u001a\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010I\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010I\u001a\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/nointercom/ProfileNoIntercom;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "initView", "navigateToNotifications", "Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "state", "renderNavigation", "(Lcom/sputnik/domain/common/Event;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentProfileNoIntercomBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentProfileNoIntercomBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "allCameraFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getAllCameraFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setAllCameraFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewModel;", "addressViewModel$delegate", "getAddressViewModel", "()Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewModel;", "addressViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileNoIntercom extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ProfileNoIntercom.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentProfileNoIntercomBinding;", 0))};

    /* renamed from: addressViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addressViewModel;
    public AllCamerasViewModel.Factory.AssistFactory allCameraFactory;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentProfileNoIntercomBinding getBinding() {
        return (FragmentProfileNoIntercomBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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

    public final AllCamerasViewModel.Factory.AssistFactory getAllCameraFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.allCameraFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("allCameraFactory");
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

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    private final AddressViewModel getAddressViewModel() {
        return (AddressViewModel) this.addressViewModel.getValue();
    }

    private final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAddressViewModel().loadCustomAddress();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NotificationsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NotificationsViewState notificationsViewState) {
                invoke2(notificationsViewState);
                return Unit.INSTANCE;
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner3, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom.onViewCreated.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AllCamerasViewState allCamerasViewState) {
                invoke2(allCamerasViewState);
                return Unit.INSTANCE;
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner4, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new AnonymousClass5(this));
        AddressViewModel addressViewModel = getAddressViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        addressViewModel.observeState(viewLifecycleOwner5, new Function1<AddressViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddressViewState addressViewState) {
                invoke2(addressViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddressViewState it) {
                SettingsLocale settings;
                SettingsBody body;
                TextTitle addAddressButton;
                SettingsLocale settings2;
                SettingsBody body2;
                SettingsLocale settings3;
                SettingsBody body3;
                Intrinsics.checkNotNullParameter(it, "it");
                DomainCustomAddress customAddress = it.getCustomAddress();
                AppCompatButton appCompatButton = ProfileNoIntercom.this.getBinding().btnServiceUpdate;
                String noAddressTitle = null;
                LocalizationLocalModel data = ProfileNoIntercom.this.getLocalizationScreen().getData();
                appCompatButton.setText((customAddress == null ? data == null || (settings = data.getSettings()) == null || (body = settings.getBody()) == null || (addAddressButton = body.getAddAddressButton()) == null : data == null || (settings3 = data.getSettings()) == null || (body3 = settings3.getBody()) == null || (addAddressButton = body3.getChangeAddressButton()) == null) ? null : addAddressButton.getTitle());
                if (customAddress != null) {
                    ProfileNoIntercom.this.getBinding().settingsAddress.setText(customAddress.toStringAddress());
                    return;
                }
                TextView textView = ProfileNoIntercom.this.getBinding().settingsAddress;
                LocalizationLocalModel data2 = ProfileNoIntercom.this.getLocalizationScreen().getData();
                if (data2 != null && (settings2 = data2.getSettings()) != null && (body2 = settings2.getBody()) != null) {
                    noAddressTitle = body2.getNoAddressTitle();
                }
                textView.setText(noAddressTitle);
            }
        });
    }

    /* compiled from: ProfileNoIntercom.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, ProfileNoIntercom.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileNoIntercom) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: ProfileNoIntercom.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Event<? extends ProfileNavigationState>, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, ProfileNoIntercom.class, "renderNavigation", "renderNavigation(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends ProfileNavigationState> event) throws Resources.NotFoundException {
            invoke2(event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<? extends ProfileNavigationState> p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileNoIntercom) this.receiver).renderNavigation(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(ProfileViewState data) {
        Profile profile = data.getProfile();
        if (profile != null) {
            FragmentProfileNoIntercomBinding binding = getBinding();
            binding.settingsFio.setText(String.valueOf(profile.getFirstName()));
            Glide.with(this).load(profile.getAvatar()).circleCrop().placeholder(R.drawable.ic_group_image).into(binding.settingsPhoto);
        }
    }

    private final void initView() {
        getBinding().layoutAboutOurHome.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileNoIntercom.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().buttonNotifications.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNoIntercom.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().imageButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNoIntercom.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().btnServiceUpdate.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileNoIntercom.initView$lambda$5(this.f$0, view);
            }
        });
        getBinding().buttonExit.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileNoIntercom.initView$lambda$6(this.f$0, view);
            }
        });
        getBinding().settingsLanguage.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileNoIntercom.initView$lambda$7(this.f$0, view);
            }
        });
        getBinding().layoutCompleteRegistration.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileNoIntercom.initView$lambda$8(this.f$0, view);
            }
        });
        ConstraintLayout toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView profileScroll = getBinding().profileScroll;
        Intrinsics.checkNotNullExpressionValue(profileScroll, "profileScroll");
        ViewKt.addSystemWindowInsetToPadding$default(profileScroll, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ProfileNoIntercom this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getNavController().navigate(R.id.action_to_our_home_update);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ProfileNoIntercom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateToNotifications();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(ProfileNoIntercom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateToNotifications();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(ProfileNoIntercom this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "address_enter", null, 4, null);
        Camera camera = (Camera) CollectionsKt.firstOrNull((List) this$0.getCamerasViewModel().getCurrentState().getMainCameras());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainNoIntercomFragment, R.id.action_mainNoIntercomFragment_to_addressFragment, BundleKt.bundleOf(TuplesKt.to("uuid", camera != null ? camera.getUuid() : null)), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ProfileNoIntercom this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "profile_open", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainNoIntercomFragment, R.id.action_mainNoIntercomFragment_to_profileSettingsFragment, BundleKt.bundleOf(TuplesKt.to(Scopes.PROFILE, this$0.getProfileViewModel().getCurrentState().getProfile())), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(ProfileNoIntercom this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainNoIntercomFragment, R.id.action_noIntercomHostFragment_to_localization_navigation, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(ProfileNoIntercom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getProfileViewModel().cleanNavigationState();
        this$0.getInvitesViewModel().clearInvites();
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_mainNoIntercomFragment_to_connectIntercomFragment, null, null, 6, null);
    }

    public ProfileNoIntercom() {
        super(R.layout.fragment_profile_no_intercom);
        this.binding = new ViewBindingFragmentDelegate(this, ProfileNoIntercom$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.addressViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddressViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$addressViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory allCameraFactory = this.this$0.getAllCameraFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return allCameraFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom$navController$2
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
    }

    private final void navigateToNotifications() {
        getNotificationsViewModel().loadNotifications();
        getAnalytics().trackLogEvent(new GeneralEvents.ClickProfileNotifications());
        NavControllerKt.safeNavigate$default(getNavController(), R.id.action_mainHostNoIntercomFragment_to_notifications, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderNavigation(Event<? extends ProfileNavigationState> state) throws Resources.NotFoundException {
        ProfileNavigationState contentIfNotHandled = state.getContentIfNotHandled();
        if (contentIfNotHandled == null || !(contentIfNotHandled instanceof ProfileNavigationState.ToLoginState)) {
            return;
        }
        getPrefManager().clearPrefs();
        requireActivity().getViewModelStore().clear();
        NavControllerKt.safeNavigate$default(getNavController(), R.id.mainNoIntercomFragment, R.id.action_mainNoIntercomFragment_to_auth_navigation, null, null, 12, null);
    }

    private final void localize() {
        DemoModeLocale demo;
        TextTitle endRegistrationButton;
        DemoModeLocale demo2;
        SettingsLocale settings;
        SettingsBody body;
        SettingsLocale settings2;
        SettingsBody body2;
        List<String> sectionTitles;
        SettingsLocale settings3;
        SettingsBody body3;
        List<String> settingsItems;
        SettingsLocale settings4;
        SettingsBody body4;
        SettingsLocale settings5;
        SettingsNavigation navigation;
        FragmentProfileNoIntercomBinding binding = getBinding();
        TextView textView = binding.toolbarTitle;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (settings5 = data.getSettings()) == null || (navigation = settings5.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView2 = binding.tvCurrentAddress;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView2.setText((data2 == null || (settings4 = data2.getSettings()) == null || (body4 = settings4.getBody()) == null) ? null : body4.getAddressLabel());
        TextView textView3 = binding.settingsLanguageTitle;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView3.setText((data3 == null || (settings3 = data3.getSettings()) == null || (body3 = settings3.getBody()) == null || (settingsItems = body3.getSettingsItems()) == null) ? null : settingsItems.get(3));
        TextView textView4 = binding.settingsLabel;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        textView4.setText((data4 == null || (settings2 = data4.getSettings()) == null || (body2 = settings2.getBody()) == null || (sectionTitles = body2.getSectionTitles()) == null) ? null : (String) CollectionsKt.first((List) sectionTitles));
        TextView textView5 = binding.settingsAddress;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        textView5.setText((data5 == null || (settings = data5.getSettings()) == null || (body = settings.getBody()) == null) ? null : body.getNoAddressTitle());
        LayoutCompleteRegistrationBinding layoutCompleteRegistrationBinding = binding.layoutCompleteRegistration;
        TextView textView6 = layoutCompleteRegistrationBinding.tvTitle;
        LocalizationLocalModel data6 = getLocalizationScreen().getData();
        textView6.setText((data6 == null || (demo2 = data6.getDemo()) == null) ? null : demo2.getNotice());
        AppCompatButton appCompatButton = layoutCompleteRegistrationBinding.btnApply;
        LocalizationLocalModel data7 = getLocalizationScreen().getData();
        appCompatButton.setText((data7 == null || (demo = data7.getDemo()) == null || (endRegistrationButton = demo.getEndRegistrationButton()) == null) ? null : endRegistrationButton.getTitle());
        LocalizationLocalModel data8 = getLocalizationScreen().getData();
        OurHomeUpdatePlate ourHomeUpdatePlate = data8 != null ? data8.getOurHomeUpdatePlate() : null;
        binding.tvOurHomeTitle.setText(ourHomeUpdatePlate != null ? ourHomeUpdatePlate.getTitle() : null);
        binding.tvOurHomeDescription.setText(ourHomeUpdatePlate != null ? ourHomeUpdatePlate.getBody() : null);
    }
}
