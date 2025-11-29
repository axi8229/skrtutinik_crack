package com.sputnik.oboarding.ui.invites;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.invites.InviteSources;
import com.sputnik.common.entities.invites.InviteStatus;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.invites.InvitesBodyLocale;
import com.sputnik.common.entities.localization.entities.invites.InvitesLocale;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.databinding.FragmentInviteBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: InviteFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00105\u001a\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006T"}, d2 = {"Lcom/sputnik/oboarding/ui/invites/InviteFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/invites/Invite;", "newInvites", "", "updateInvitesQueue", "(Ljava/util/List;)V", "showCurrentInvite", "processNextInvite", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "Lcom/sputnik/oboarding/databinding/FragmentInviteBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentInviteBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "Lkotlin/Lazy;", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "invite", "Lcom/sputnik/common/entities/invites/Invite;", "Ljava/util/Queue;", "invites", "Ljava/util/Queue;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InviteFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(InviteFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentInviteBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;
    private Invite invite;
    private Queue<Invite> invites;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentInviteBinding getBinding() {
        return (FragmentInviteBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner, new Function1<InvitesViewState, Unit>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment.onViewCreated.1

            /* compiled from: InviteFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.oboarding.ui.invites.InviteFragment$onViewCreated$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;
                public static final /* synthetic */ int[] $EnumSwitchMapping$2;

                static {
                    int[] iArr = new int[InviteSources.values().length];
                    try {
                        iArr[InviteSources.mobile.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InviteSources.partner.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[InviteStatus.values().length];
                    try {
                        iArr2[InviteStatus.accepted.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[InviteStatus.denied.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                    int[] iArr3 = new int[Resource.Status.values().length];
                    try {
                        iArr3[Resource.Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$2 = iArr3;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InvitesViewState invitesViewState) {
                invoke2(invitesViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InvitesViewState it) {
                List<Invite> listEmptyList;
                InviteSources source;
                InvitesBodyLocale invites;
                InvitesLocale body;
                TextTitle btnDecline;
                InvitesBodyLocale invites2;
                InvitesLocale body2;
                TextTitle btnAccept;
                Intrinsics.checkNotNullParameter(it, "it");
                Event<List<Invite>> invites3 = it.getInvites();
                if (invites3 == null || (listEmptyList = invites3.peekContent()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                InviteFragment.this.updateInvitesQueue(listEmptyList);
                InviteFragment.this.showCurrentInvite();
                AppCompatButton btnAccept2 = InviteFragment.this.getBinding().btnAccept;
                Intrinsics.checkNotNullExpressionValue(btnAccept2, "btnAccept");
                Resource.Status acceptInviteServerState = it.getAcceptInviteServerState();
                Resource.Status status = Resource.Status.LOADING;
                boolean z = acceptInviteServerState == status;
                LocalizationLocalModel data = InviteFragment.this.getLocalizationScreen().getData();
                String title = null;
                ViewBindingUtilsKt.showProgressBasedOn$default(btnAccept2, z, String.valueOf((data == null || (invites2 = data.getInvites()) == null || (body2 = invites2.getBody()) == null || (btnAccept = body2.getBtnAccept()) == null) ? null : btnAccept.getTitle()), 0, false, 12, null);
                AppCompatButton btnReject = InviteFragment.this.getBinding().btnReject;
                Intrinsics.checkNotNullExpressionValue(btnReject, "btnReject");
                boolean z2 = it.getDeclineInviteServerState() == status;
                LocalizationLocalModel data2 = InviteFragment.this.getLocalizationScreen().getData();
                if (data2 != null && (invites = data2.getInvites()) != null && (body = invites.getBody()) != null && (btnDecline = body.getBtnDecline()) != null) {
                    title = btnDecline.getTitle();
                }
                ViewBindingUtilsKt.showProgressBasedOn$default(btnReject, z2, String.valueOf(title), -16776961, false, 8, null);
                Resource.Status acceptInviteServerState2 = it.getAcceptInviteServerState();
                int[] iArr = WhenMappings.$EnumSwitchMapping$2;
                if (iArr[acceptInviteServerState2.ordinal()] == 1) {
                    Invite invite = InviteFragment.this.invite;
                    if (invite != null && (source = invite.getSource()) != null) {
                        InviteFragment inviteFragment = InviteFragment.this;
                        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
                        if (i == 1) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.StateAcceptFromAdminSuccess());
                        } else if (i == 2) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.StateAcceptFromPartnerSuccess());
                        }
                    }
                    InviteStatus manageInviteStatus = it.getManageInviteStatus();
                    if ((manageInviteStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[manageInviteStatus.ordinal()]) == 1) {
                        InviteFragment.this.processNextInvite();
                    } else {
                        InviteFragment.this.processNextInvite();
                    }
                }
                if (iArr[it.getDeclineInviteServerState().ordinal()] == 1) {
                    InviteStatus manageInviteStatus2 = it.getManageInviteStatus();
                    if ((manageInviteStatus2 != null ? WhenMappings.$EnumSwitchMapping$1[manageInviteStatus2.ordinal()] : -1) == 2) {
                        InviteFragment.this.processNextInvite();
                    } else {
                        InviteFragment.this.processNextInvite();
                    }
                }
            }
        });
        InvitesViewModel invitesViewModel2 = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        invitesViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment.onViewCreated.2
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
                InviteFragment inviteFragment = InviteFragment.this;
                NestedScrollView root = inviteFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(inviteFragment, root, it);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner3, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment.onViewCreated.4
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
                    InviteFragment inviteFragment = InviteFragment.this;
                    inviteFragment.getLoginViewModel().clearToRequestCode();
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        Uri uri = Uri.parse(inviteFragment.getString(R$string.deeplink_main));
                        inviteFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        FragmentKt.findNavController(inviteFragment).popBackStack(R$id.startRegistrationFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(inviteFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                        return;
                    }
                    FragmentKt.findNavController(inviteFragment).navigateUp();
                }
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        InvitesBodyLocale invites;
        InvitesLocale body;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (invites = data.getInvites()) == null || (body = invites.getBody()) == null) {
            return;
        }
        FragmentInviteBinding binding = getBinding();
        binding.tvTitle.setText(String.valueOf(body.getToolbar()));
        AppCompatButton appCompatButton = binding.btnAccept;
        TextTitle btnAccept = body.getBtnAccept();
        appCompatButton.setText(String.valueOf(btnAccept != null ? btnAccept.getTitle() : null));
        AppCompatButton appCompatButton2 = binding.btnReject;
        TextTitle btnDecline = body.getBtnDecline();
        appCompatButton2.setText(String.valueOf(btnDecline != null ? btnDecline.getTitle() : null));
    }

    public InviteFragment() {
        super(R$layout.fragment_invite);
        this.binding = new ViewBindingFragmentDelegate(this, InviteFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$10
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.invites = new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateInvitesQueue(List<Invite> newInvites) {
        this.invites.clear();
        this.invites.addAll(newInvites);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCurrentInvite() {
        InvitesBodyLocale invites;
        InvitesLocale body;
        Invite invitePeek = this.invites.peek();
        this.invite = invitePeek;
        if (invitePeek != null) {
            TextView textView = getBinding().tvNotice;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            textView.setText(StringUtilsKt.formatSafe(String.valueOf((data == null || (invites = data.getInvites()) == null || (body = invites.getBody()) == null) ? null : body.getTitle()), String.valueOf(invitePeek.getFlatNumber())));
            getBinding().tvAddress.setText(String.valueOf(invitePeek.getFullAddress()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processNextInvite() {
        this.invites.poll();
        if (this.invites.isEmpty()) {
            IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
        } else {
            showCurrentInvite();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentInviteBinding binding = getBinding();
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$initViews$1$1

            /* compiled from: InviteFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[InviteSources.values().length];
                    try {
                        iArr[InviteSources.mobile.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InviteSources.partner.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                Invite invite = this.this$0.invite;
                if (invite != null) {
                    InviteFragment inviteFragment = this.this$0;
                    InviteSources source = invite.getSource();
                    if (source != null) {
                        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
                        if (i == 1) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.ClickAcceptToTheFamily());
                        } else if (i == 2) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.ClickAcceptToTheFamilyPartner());
                        }
                    }
                    inviteFragment.getInvitesViewModel().acceptInvite(invite);
                }
            }
        }, 1, null);
        AppCompatButton btnReject = binding.btnReject;
        Intrinsics.checkNotNullExpressionValue(btnReject, "btnReject");
        SafeClickListenerKt.setSafeOnClickListener$default(btnReject, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.invites.InviteFragment$initViews$1$2

            /* compiled from: InviteFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[InviteSources.values().length];
                    try {
                        iArr[InviteSources.mobile.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InviteSources.partner.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                Uri.parse(this.this$0.getString(R$string.deeplink_main_no_intercom));
                Invite invite = this.this$0.invite;
                if (invite != null) {
                    InviteFragment inviteFragment = this.this$0;
                    InviteSources source = invite.getSource();
                    if (source != null) {
                        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
                        if (i == 1) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.ClickRejectToTheFamily());
                        } else if (i == 2) {
                            inviteFragment.getAnalytics().trackLogEvent(new FamilyEvents.ClickRejectToTheFamilyPartner());
                        }
                    }
                    inviteFragment.getInvitesViewModel().declineInvite(invite);
                }
            }
        }, 1, null);
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }
}
