package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.login.ApartmentTextField;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressBodyLocale;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressLocale;
import com.sputnik.common.entities.localization.entities.login.EnterApartmentPopup;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegEnterAppartmentBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.entities.entry.Entry;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewModel;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

/* compiled from: EnterFlatNumberFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010/\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/EnterFlatNumberFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegEnterAppartmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegEnterAppartmentBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewModel;", "entryViewModel$delegate", "getEntryViewModel", "()Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewModel;", "entryViewModel", "", "isFromAddingAddress$delegate", "isFromAddingAddress", "()Z", "Lcom/sputnik/common/entities/addresses/UserAddress;", "address$delegate", "getAddress", "()Lcom/sputnik/common/entities/addresses/UserAddress;", "address", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnterFlatNumberFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterFlatNumberFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegEnterAppartmentBinding;", 0))};

    /* renamed from: address$delegate, reason: from kotlin metadata */
    private final Lazy address;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: entryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy entryViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: isFromAddingAddress$delegate, reason: from kotlin metadata */
    private final Lazy isFromAddingAddress;
    public LocalizationStorage localizationStorage;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegEnterAppartmentBinding getBinding() {
        return (FragmentRegEnterAppartmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final EntryViewModel getEntryViewModel() {
        return (EntryViewModel) this.entryViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFromAddingAddress() {
        return ((Boolean) this.isFromAddingAddress.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserAddress getAddress() {
        return (UserAddress) this.address.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireActivity().getWindow().setSoftInputMode(16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        if (isFromAddingAddress()) {
            UserAddress address = getAddress();
            if (address != null) {
                address.getNavigationStateForAddress();
            }
            TextView textView = getBinding().tvAddress;
            UserAddress address2 = getAddress();
            textView.setText(address2 != null ? address2.getFullAddressWithApartment() : null);
        }
        if (!isFromAddingAddress()) {
            ProfileViewModel profileViewModel = getProfileViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.2
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
                        TextView textView2 = EnterFlatNumberFragment.this.getBinding().tvAddress;
                        Profile profile = it.getProfile();
                        Intrinsics.checkNotNull(profile);
                        textView2.setText(profile.getAddress());
                    }
                }
            });
        }
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner2, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFlatError();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    EnterFlatNumberFragment enterFlatNumberFragment = EnterFlatNumberFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterFlatNumberFragment), R$id.enterFlatNumberFragment, R$id.action_enterFlatNumberFragment_to_somethingWentWrongFragmnet, BundleKt.bundleOf(TuplesKt.to("apartment", enterFlatNumberFragment.getBinding().etEnterApartment.getText().toString()), TuplesKt.to("is_adding_address", Boolean.valueOf(enterFlatNumberFragment.isFromAddingAddress()))), null, 8, null);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner3, new Function1<ProfileViewState, Resource.Status>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFlatServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.6

            /* compiled from: EnterFlatNumberFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$onViewCreated$6$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) throws Resources.NotFoundException {
                invoke2(status);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource.Status it) throws Resources.NotFoundException {
                ConfirmAddressLocale confirmAddress;
                ConfirmAddressBodyLocale body;
                EnterApartmentPopup enterApartmentPopup;
                TextTitle doneButton;
                Intrinsics.checkNotNullParameter(it, "it");
                int i = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                String title = null;
                if (i == 1) {
                    AppCompatButton btnAccept = EnterFlatNumberFragment.this.getBinding().btnAccept;
                    Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
                    ButtonsExtensionsKt.showProgress$default(btnAccept, 0, 1, null);
                    return;
                }
                if (i != 2) {
                    AppCompatButton btnAccept2 = EnterFlatNumberFragment.this.getBinding().btnAccept;
                    Intrinsics.checkNotNullExpressionValue(btnAccept2, "btnAccept");
                    LocalizationLocalModel data = EnterFlatNumberFragment.this.getLocalizationStorage().getData();
                    if (data != null && (confirmAddress = data.getConfirmAddress()) != null && (body = confirmAddress.getBody()) != null && (enterApartmentPopup = body.getEnterApartmentPopup()) != null && (doneButton = enterApartmentPopup.getDoneButton()) != null) {
                        title = doneButton.getTitle();
                    }
                    ButtonsExtensionsKt.hideProgress(btnAccept2, String.valueOf(title));
                    return;
                }
                if (EnterFlatNumberFragment.this.isFromAddingAddress()) {
                    EnterFlatNumberFragment.this.getAnalytics().trackLogEvent(new MultiAddressEvents.StateAddressDeferredAddComplete());
                }
                String string = EnterFlatNumberFragment.this.getString(R$string.deeplink_main);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Uri uri = Uri.parse(string);
                FragmentKt.findNavController(EnterFlatNumberFragment.this).popBackStack(R$id.mainHostFragment, true);
                FragmentKt.findNavController(EnterFlatNumberFragment.this).navigate(uri);
            }
        });
        EntryViewModel entryViewModel = getEntryViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        entryViewModel.observeState(viewLifecycleOwner4, new Function1<EntryViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EntryViewState entryViewState) {
                invoke2(entryViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EntryViewState serverData) {
                ConfirmAddressLocale confirmAddress;
                ConfirmAddressBodyLocale body;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                if (serverData.getServerState() == Resource.Status.SUCCESS) {
                    LocalizationLocalModel data = EnterFlatNumberFragment.this.getLocalizationStorage().getData();
                    EnterApartmentPopup enterApartmentPopup = (data == null || (confirmAddress = data.getConfirmAddress()) == null || (body = confirmAddress.getBody()) == null) ? null : body.getEnterApartmentPopup();
                    Intrinsics.checkNotNull(enterApartmentPopup);
                    TextView textView2 = EnterFlatNumberFragment.this.getBinding().tvNumbers;
                    String bottomLabel = enterApartmentPopup.getApartmentTextField().getBottomLabel();
                    Entry entry = serverData.getEntry();
                    Integer numValueOf = entry != null ? Integer.valueOf(entry.getFirstFlat()) : null;
                    Entry entry2 = serverData.getEntry();
                    textView2.setText(Util.format(bottomLabel, numValueOf + " - " + (entry2 != null ? Integer.valueOf(entry2.getLastFlat()) : null)));
                }
            }
        });
        ProfileViewModel profileViewModel4 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        profileViewModel4.observeSubState(viewLifecycleOwner5, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.9
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
                    EnterFlatNumberFragment enterFlatNumberFragment = EnterFlatNumberFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        ConstraintLayout rootView = enterFlatNumberFragment.getBinding().rootView;
                        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                        ViewKt.hideKeyboard(rootView);
                        Uri uri = Uri.parse(enterFlatNumberFragment.getString(R$string.deeplink_main));
                        FragmentKt.findNavController(enterFlatNumberFragment).popBackStack(R$id.new_registration_navigation, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(enterFlatNumberFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel5 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel5.observeNotifications(viewLifecycleOwner6, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.onViewCreated.10
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
                EnterFlatNumberFragment enterFlatNumberFragment = EnterFlatNumberFragment.this;
                NestedScrollView root = enterFlatNumberFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterFlatNumberFragment, root, it);
            }
        });
        EntryViewModel entryViewModel2 = getEntryViewModel();
        UserAddress address3 = getAddress();
        entryViewModel2.loadEntry(address3 != null ? address3.getEntryUUID() : null);
    }

    public EnterFlatNumberFragment() {
        super(R$layout.fragment_reg_enter_appartment);
        this.binding = new ViewBindingFragmentDelegate(this, EnterFlatNumberFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$entryViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.entryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EntryViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$special$$inlined$viewModels$default$4
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
        this.isFromAddingAddress = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment.isFromAddingAddress.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = EnterFlatNumberFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("is_adding_address", false) : false);
            }
        });
        this.address = LazyKt.lazy(new Function0<UserAddress>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$address$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserAddress invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (UserAddress) (arguments != null ? arguments.get("item") : null);
            }
        });
    }

    private final void initView() {
        FragmentRegEnterAppartmentBinding binding = getBinding();
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener(btnAccept, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$initView$1$1
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
                Integer id;
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationFinishEvent());
                ProfileViewModel profileViewModel = this.this$0.getProfileViewModel();
                String string = this.this$0.getBinding().etEnterApartment.getText().toString();
                UserAddress address = this.this$0.getAddress();
                profileViewModel.saveFlatNumber(string, (address == null || (id = address.getId()) == null) ? -1 : id.intValue());
            }
        });
        binding.tvChangeAddress.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                EnterFlatNumberFragment.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(EnterFlatNumberFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationWrongAddressEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.enterFlatNumberFragment, R$id.action_enterFlatNumberFragment_to_notMyAddressFragment, BundleKt.bundleOf(TuplesKt.to("apartment", this$0.getBinding().etEnterApartment.getText().toString()), TuplesKt.to("is_adding_address", Boolean.valueOf(this$0.isFromAddingAddress()))), null, 8, null);
    }

    private final void localize() {
        TextTitle cancelButton;
        TextTitle doneButton;
        ApartmentTextField apartmentTextField;
        ApartmentTextField apartmentTextField2;
        ConfirmAddressLocale confirmAddress;
        ConfirmAddressBodyLocale body;
        FragmentRegEnterAppartmentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        EnterApartmentPopup enterApartmentPopup = (data == null || (confirmAddress = data.getConfirmAddress()) == null || (body = confirmAddress.getBody()) == null) ? null : body.getEnterApartmentPopup();
        binding.title.setText(enterApartmentPopup != null ? enterApartmentPopup.getTitle() : null);
        binding.tvNotice.setText(enterApartmentPopup != null ? enterApartmentPopup.getBody() : null);
        binding.tvAddressTitle.setText(enterApartmentPopup != null ? enterApartmentPopup.getAddressTitle() : null);
        binding.tvApartmentNumber.setText((enterApartmentPopup == null || (apartmentTextField2 = enterApartmentPopup.getApartmentTextField()) == null) ? null : apartmentTextField2.getTitle());
        binding.etEnterApartment.setHint((enterApartmentPopup == null || (apartmentTextField = enterApartmentPopup.getApartmentTextField()) == null) ? null : apartmentTextField.getPlaceholder());
        binding.btnAccept.setText((enterApartmentPopup == null || (doneButton = enterApartmentPopup.getDoneButton()) == null) ? null : doneButton.getTitle());
        AppCompatButton appCompatButton = binding.tvChangeAddress;
        if (enterApartmentPopup != null && (cancelButton = enterApartmentPopup.getCancelButton()) != null) {
            title = cancelButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
