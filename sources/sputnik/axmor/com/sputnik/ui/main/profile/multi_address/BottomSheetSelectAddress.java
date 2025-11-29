package sputnik.axmor.com.sputnik.ui.main.profile.multi_address;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.PopupStoriesDataState;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetSelectAddressBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: BottomSheetSelectAddress.kt */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010:\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010:\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010:\u001a\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010:\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010:\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010:\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010:\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010:\u001a\u0004\br\u0010sR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010z¨\u0006{"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/BottomSheetSelectAddress;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetSelectAddressBinding;", "<init>", "()V", "Lcom/sputnik/common/entities/addresses/UserAddress;", "item", "", "onSelect", "(Lcom/sputnik/common/entities/addresses/UserAddress;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "serviceViewModel$delegate", "getServiceViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "serviceViewModel", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupsViewModel$delegate", "getPopupsViewModel", "()Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupsViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "", "isLocked", "Z", "Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/AddressesAdapter;", "addressesAdapter", "Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/AddressesAdapter;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetSelectAddress extends BaseBottomSheetDialogFragment<BottomSheetSelectAddressBinding> {
    private final AddressesAdapter addressesAdapter;
    public Analytics analytics;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    private boolean isLocked;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;

    /* renamed from: popupsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy popupsViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: serviceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy serviceViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    public static final /* synthetic */ BottomSheetSelectAddressBinding access$getBinding(BottomSheetSelectAddress bottomSheetSelectAddress) {
        return bottomSheetSelectAddress.getBinding();
    }

    /* compiled from: BottomSheetSelectAddress.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetSelectAddressBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetSelectAddressBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetSelectAddressBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetSelectAddressBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetSelectAddressBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetSelectAddressBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetSelectAddress() {
        super(AnonymousClass1.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$navController$2
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
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.serviceViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$serviceViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$keysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$20
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$22
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$23
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.popupsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PopupStoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$25
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$26
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$popupsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$28
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$29
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$31
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$special$$inlined$activityViewModels$default$32
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.addressesAdapter = new AddressesAdapter(new Function1<UserAddress, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$addressesAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserAddress userAddress) {
                invoke2(userAddress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserAddress it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.onSelect(it);
            }
        }, new Function1<UserAddress, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$addressesAdapter$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserAddress userAddress) {
                invoke2(userAddress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserAddress it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_global_to_unbind_address, BundleKt.bundleOf(TuplesKt.to("item", it)), null, 4, null);
            }
        });
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

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
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
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
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
    public final ServicePaymentsViewModel getServiceViewModel() {
        return (ServicePaymentsViewModel) this.serviceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupStoriesViewModel getPopupsViewModel() {
        return (PopupStoriesViewModel) this.popupsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    public final void onSelect(UserAddress item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.isLocked || this.addressesAdapter.getInEditorMode()) {
            return;
        }
        if (!item.isFullyValidated()) {
            NavControllerKt.safeNavigate$default(getNavController(), R.id.action_global_to_add_address, BundleKt.bundleOf(TuplesKt.to("is_adding_address", Boolean.TRUE), TuplesKt.to("item", item)), null, 4, null);
        } else {
            this.addressesAdapter.select(item);
            ProfileViewModel.selectCurrentAddress$default(getProfileViewModel(), item, false, 2, null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheet);
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        this.isLocked = profile != null ? Intrinsics.areEqual(profile.getRichFunctionalityAvailable(), Boolean.FALSE) : false;
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.isLocked) {
            getAnalytics().trackLogEvent(new MultiAddressEvents.ShowBlockedAddressSelect());
            LinearLayout llSubscriptionNeeded = getBinding().llSubscriptionNeeded;
            Intrinsics.checkNotNullExpressionValue(llSubscriptionNeeded, "llSubscriptionNeeded");
            ViewKt.visible(llSubscriptionNeeded);
            this.addressesAdapter.lockAddresses();
            getBinding().ivStatus.setImageResource(R.drawable.ic_item_locked);
        } else {
            LinearLayout llSubscriptionNeeded2 = getBinding().llSubscriptionNeeded;
            Intrinsics.checkNotNullExpressionValue(llSubscriptionNeeded2, "llSubscriptionNeeded");
            ViewKt.gone(llSubscriptionNeeded2);
            this.addressesAdapter.unlockAddresses();
        }
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.1
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
                BottomSheetSelectAddress.this.addressesAdapter.submitList(it.getCurrentAddresses());
                if (!it.getNeedReloadForNewAddress().peekContent().booleanValue() || it.getNeedReloadForNewAddress().getContentIfNotHandled() == null) {
                    return;
                }
                BottomSheetSelectAddress bottomSheetSelectAddress = BottomSheetSelectAddress.this;
                bottomSheetSelectAddress.getMarketViewModel().loadMarket();
                bottomSheetSelectAddress.getMarketViewModel().loadServices();
                bottomSheetSelectAddress.getMarketViewModel().loadSubscriptions();
                bottomSheetSelectAddress.getCamerasViewModel().handleNeedUpdate(true);
                bottomSheetSelectAddress.getKeysViewModel().getKeys();
                bottomSheetSelectAddress.getNotificationsViewModel().loadUnviewedNotifications();
                bottomSheetSelectAddress.getPopupsViewModel().loadPopupStories();
                bottomSheetSelectAddress.getFamilyViewModel().loadFamily();
                bottomSheetSelectAddress.getServiceViewModel().getServicePayments();
                bottomSheetSelectAddress.getServiceViewModel().getServiceAccountInfo();
                bottomSheetSelectAddress.dismiss();
            }
        });
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner2, new Function1<SubscriptionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
                invoke2(subscriptionsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubscriptionsViewState it) {
                BaseSubscription baseSubscription;
                SubscriptionAppearance appearance;
                SubscriptionBuyLocale subscriptionBuy;
                SubscriptionBuyBody body;
                TextTitle buyButton;
                SubscriptionBuyLocale subscriptionBuy2;
                SubscriptionBuyBody body2;
                TextTitle buyButton2;
                SubscriptionDetails subscriptionDetails;
                List<Plan> plans;
                Plan plan;
                SubscriptionDetails subscriptionDetails2;
                List<Plan> plans2;
                Plan plan2;
                Plan.Promo promo;
                Object next;
                Intrinsics.checkNotNullParameter(it, "it");
                List<BaseSubscription> subscriptions = it.getSubscriptions();
                if (subscriptions != null) {
                    Iterator<T> it2 = subscriptions.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it2.next();
                            if (Intrinsics.areEqual(((BaseSubscription) next).getIdentifier(), Subscriptions.standard.toString())) {
                                break;
                            }
                        }
                    }
                    baseSubscription = (BaseSubscription) next;
                } else {
                    baseSubscription = null;
                }
                Integer discountPrice = (baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null || (promo = plan2.getPromo()) == null) ? null : promo.getDiscountPrice();
                Integer price = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans)) == null) ? null : plan.getPrice();
                if (discountPrice != null) {
                    LocalizationLocalModel data = BottomSheetSelectAddress.this.getLocalizationStorage().getData();
                    String strValueOf = String.valueOf((data == null || (subscriptionBuy2 = data.getSubscriptionBuy()) == null || (body2 = subscriptionBuy2.getBody()) == null || (buyButton2 = body2.getBuyButton()) == null) ? null : buyButton2.getTitle());
                    String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
                    String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
                    SubscriptionAppearance appearance2 = baseSubscription.getAppearance();
                    String safe = StringUtilsKt.formatSafe(strValueOf, strOrEmpty + " " + strOrEmpty2 + " " + (appearance2 != null ? appearance2.getPriceText() : null));
                    Button btnSubscribe = BottomSheetSelectAddress.access$getBinding(BottomSheetSelectAddress.this).btnSubscribe;
                    Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
                    ViewUtilsKt.strikeThrouth(btnSubscribe, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(BottomSheetSelectAddress.this.requireContext(), R.color.track_gray)));
                    return;
                }
                Button button = BottomSheetSelectAddress.access$getBinding(BottomSheetSelectAddress.this).btnSubscribe;
                LocalizationLocalModel data2 = BottomSheetSelectAddress.this.getLocalizationStorage().getData();
                String strValueOf2 = String.valueOf((data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
                String strOrEmpty3 = price != null ? StringUtilsKt.orEmpty(price) : null;
                if (baseSubscription != null && (appearance = baseSubscription.getAppearance()) != null) {
                    priceText = appearance.getPriceText();
                }
                button.setText(StringUtilsKt.formatSafe(strValueOf2, strOrEmpty3 + " " + priceText));
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        marketViewModel.observeState(viewLifecycleOwner3, new Function1<MarketViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
                invoke2(marketViewState);
                return Unit.INSTANCE;
            }
        });
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner4, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.4
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
        KeysViewModel keysViewModel = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        keysViewModel.observeState(viewLifecycleOwner5, new Function1<KeysViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.5
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeysViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
                invoke2(keysViewState);
                return Unit.INSTANCE;
            }
        });
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner6, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.6
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
        PopupStoriesViewModel popupsViewModel = getPopupsViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        popupsViewModel.observeState(viewLifecycleOwner7, new Function1<PopupStoriesDataState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.7
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
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner8, new Function1<FamilyViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.8
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
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner9, new Function1<InvitesViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress.onViewCreated.9
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
                List<Invite> listPeekContent;
                Intrinsics.checkNotNullParameter(it, "it");
                Event<List<Invite>> invites = it.getInvites();
                if (invites == null || (listPeekContent = invites.peekContent()) == null) {
                    return;
                }
                BottomSheetSelectAddress bottomSheetSelectAddress = BottomSheetSelectAddress.this;
                if (!listPeekContent.isEmpty() && !bottomSheetSelectAddress.isLocked) {
                    BottomSheetSelectAddress.access$getBinding(bottomSheetSelectAddress).tvInvitesAddress.setText("Вас приглашают на " + listPeekContent.size() + " адрес");
                    ConstraintLayout btnAcceptInvites = BottomSheetSelectAddress.access$getBinding(bottomSheetSelectAddress).btnAcceptInvites;
                    Intrinsics.checkNotNullExpressionValue(btnAcceptInvites, "btnAcceptInvites");
                    ViewKt.visible(btnAcceptInvites);
                    return;
                }
                ConstraintLayout btnAcceptInvites2 = BottomSheetSelectAddress.access$getBinding(bottomSheetSelectAddress).btnAcceptInvites;
                Intrinsics.checkNotNullExpressionValue(btnAcceptInvites2, "btnAcceptInvites");
                ViewKt.gone(btnAcceptInvites2);
            }
        });
        getInvitesViewModel().loadInvites();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final BottomSheetSelectAddressBinding binding = getBinding();
        binding.rvAddresses.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        this.addressesAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        binding.rvAddresses.setAdapter(this.addressesAdapter);
        if (this.isLocked) {
            ImageView btnEditorMode = binding.btnEditorMode;
            Intrinsics.checkNotNullExpressionValue(btnEditorMode, "btnEditorMode");
            ViewKt.gone(btnEditorMode);
        } else {
            ImageView btnEditorMode2 = binding.btnEditorMode;
            Intrinsics.checkNotNullExpressionValue(btnEditorMode2, "btnEditorMode");
            ViewKt.visible(btnEditorMode2);
        }
        Button btnSubscribe = binding.btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSubscribe, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$initViews$1$1
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
                IntentProcessingUtilsKt.handleDeeplink("market/standard", BundleKt.bundleOf(), this.this$0.getActivity(), this.this$0.getNavigationViewModel(), this.this$0.getProfileViewModel(), this.this$0.getAnalytics(), this.this$0.getNavController());
            }
        }, 1, null);
        ImageView btnEditorMode3 = binding.btnEditorMode;
        Intrinsics.checkNotNullExpressionValue(btnEditorMode3, "btnEditorMode");
        SafeClickListenerKt.setSafeOnClickListener$default(btnEditorMode3, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$initViews$1$2
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
                this.this$0.addressesAdapter.switchEditorMode();
                AppCompatButton btnDone = binding.btnDone;
                Intrinsics.checkNotNullExpressionValue(btnDone, "btnDone");
                ViewBindingUtilsKt.visibilityBasedOn(btnDone, Boolean.valueOf(this.this$0.addressesAdapter.getInEditorMode()));
                ConstraintLayout btnAddAddress = binding.btnAddAddress;
                Intrinsics.checkNotNullExpressionValue(btnAddAddress, "btnAddAddress");
                ViewBindingUtilsKt.visibilityBasedOn(btnAddAddress, Boolean.valueOf(!this.this$0.addressesAdapter.getInEditorMode()));
                ConstraintLayout btnAcceptInvites = binding.btnAcceptInvites;
                Intrinsics.checkNotNullExpressionValue(btnAcceptInvites, "btnAcceptInvites");
                ViewBindingUtilsKt.visibilityBasedOn(btnAcceptInvites, Boolean.valueOf((this.this$0.addressesAdapter.getInEditorMode() || this.this$0.isLocked) ? false : true));
                ImageView btnEditorMode4 = binding.btnEditorMode;
                Intrinsics.checkNotNullExpressionValue(btnEditorMode4, "btnEditorMode");
                ViewBindingUtilsKt.visibilityBasedOn(btnEditorMode4, Boolean.valueOf(!this.this$0.addressesAdapter.getInEditorMode()));
            }
        }, 1, null);
        binding.btnDone.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetSelectAddress.initViews$lambda$2$lambda$0(this.f$0, binding, view);
            }
        });
        binding.btnAddAddress.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetSelectAddress.initViews$lambda$2$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$0(BottomSheetSelectAddress this$0, BottomSheetSelectAddressBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this$0.addressesAdapter.switchEditorMode();
        AppCompatButton btnDone = this_with.btnDone;
        Intrinsics.checkNotNullExpressionValue(btnDone, "btnDone");
        ViewBindingUtilsKt.visibilityBasedOn(btnDone, Boolean.valueOf(this$0.addressesAdapter.getInEditorMode()));
        ConstraintLayout btnAddAddress = this_with.btnAddAddress;
        Intrinsics.checkNotNullExpressionValue(btnAddAddress, "btnAddAddress");
        ViewBindingUtilsKt.visibilityBasedOn(btnAddAddress, Boolean.valueOf(!this$0.addressesAdapter.getInEditorMode()));
        ConstraintLayout btnAcceptInvites = this_with.btnAcceptInvites;
        Intrinsics.checkNotNullExpressionValue(btnAcceptInvites, "btnAcceptInvites");
        ViewBindingUtilsKt.visibilityBasedOn(btnAcceptInvites, Boolean.valueOf((this$0.addressesAdapter.getInEditorMode() || this$0.getInvitesViewModel().getCurrentState().getInvites().peekContent().isEmpty() || this$0.isLocked) ? false : true));
        ImageView btnEditorMode = this_with.btnEditorMode;
        Intrinsics.checkNotNullExpressionValue(btnEditorMode, "btnEditorMode");
        ViewBindingUtilsKt.visibilityBasedOn(btnEditorMode, Boolean.valueOf(!this$0.addressesAdapter.getInEditorMode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(BottomSheetSelectAddress this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isLocked) {
            return;
        }
        this$0.getAnalytics().trackLogEvent(new MultiAddressEvents.ClickAddAddress());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_add_address, BundleKt.bundleOf(TuplesKt.to("is_adding_address", Boolean.TRUE)), null, 4, null);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        LocalizationLocalModel data;
        PhysicalKeysLocale physicalKeys;
        getBinding().btnDone.setText("Готово");
        LocalizationStorage localizationStorage = getLocalizationStorage();
        if (localizationStorage == null || (data = localizationStorage.getData()) == null || (physicalKeys = data.getPhysicalKeys()) == null) {
            return;
        }
        physicalKeys.getErrorPopup();
    }
}
