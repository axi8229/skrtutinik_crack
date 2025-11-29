package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.family_invites.FamilyInvitesLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import flussonic.media.FFmpegMediaMetadataRetriever;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import me.ibrahimsn.lib.PhoneNumberKit;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetInviteToFamilyBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView;

/* compiled from: BottomSheetInviteToFamily.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010(\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b>\u0010;R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010(\u001a\u0004\bB\u0010CR#\u0010J\u001a\n F*\u0004\u0018\u00010E0E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010(\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010(\u001a\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/BottomSheetInviteToFamily;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetInviteToFamilyBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "Lkotlin/Lazy;", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "", "needToOpenMarket$delegate", "getNeedToOpenMarket", "()Z", "needToOpenMarket", "needNavigateToCallHistory$delegate", "getNeedNavigateToCallHistory", "needNavigateToCallHistory", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "kotlin.jvm.PlatformType", "phoneNumberUtil$delegate", "getPhoneNumberUtil", "()Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "phoneNumberUtil", "Lme/ibrahimsn/lib/PhoneNumberKit;", "phoneNumberKit$delegate", "getPhoneNumberKit", "()Lme/ibrahimsn/lib/PhoneNumberKit;", "phoneNumberKit", "", "phone", "Ljava/lang/String;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetInviteToFamily extends BaseBottomSheetDialogFragment<BottomSheetInviteToFamilyBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: needNavigateToCallHistory$delegate, reason: from kotlin metadata */
    private final Lazy needNavigateToCallHistory;

    /* renamed from: needToOpenMarket$delegate, reason: from kotlin metadata */
    private final Lazy needToOpenMarket;
    private String phone;

    /* renamed from: phoneNumberKit$delegate, reason: from kotlin metadata */
    private final Lazy phoneNumberKit;

    /* renamed from: phoneNumberUtil$delegate, reason: from kotlin metadata */
    private final Lazy phoneNumberUtil;

    public static final /* synthetic */ BottomSheetInviteToFamilyBinding access$getBinding(BottomSheetInviteToFamily bottomSheetInviteToFamily) {
        return bottomSheetInviteToFamily.getBinding();
    }

    /* compiled from: BottomSheetInviteToFamily.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetInviteToFamilyBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetInviteToFamilyBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetInviteToFamilyBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetInviteToFamilyBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetInviteToFamilyBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetInviteToFamilyBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetInviteToFamily() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.needToOpenMarket = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$needToOpenMarket$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                Boolean bool = (Boolean) (arguments != null ? arguments.get("need_to_open_market") : null);
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        this.needNavigateToCallHistory = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$needNavigateToCallHistory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                Boolean bool = (Boolean) (arguments != null ? arguments.get("is_from_review") : null);
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$navController$2
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
        this.phoneNumberUtil = LazyKt.lazy(new Function0<PhoneNumberUtil>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$phoneNumberUtil$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PhoneNumberUtil invoke() {
                return PhoneNumberUtil.createInstance(this.this$0.requireContext());
            }
        });
        this.phoneNumberKit = LazyKt.lazy(new Function0<PhoneNumberKit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$phoneNumberKit$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PhoneNumberKit invoke() {
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                return new PhoneNumberKit.Builder(contextRequireContext).build();
            }
        });
        this.phone = "";
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

    /* JADX INFO: Access modifiers changed from: private */
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    private final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.DialogStyle);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner, new Function1<InvitesViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.onViewCreated.1

            /* compiled from: BottomSheetInviteToFamily.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$onViewCreated$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
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
                AlertLocale alert;
                AlertData commonError;
                TextTitle okButton;
                AlertLocale alert2;
                AlertData commonError2;
                FamilyInvitesLocale familyInvites;
                FamilyInvitesLocale.SendFamilyInviteLocale sendInvite;
                TextTitle sendButton;
                FamilyInvitesLocale familyInvites2;
                FamilyInvitesLocale.SendFamilyInviteLocale sendInvite2;
                Intrinsics.checkNotNullParameter(it, "it");
                AppCompatButton btnApply = BottomSheetInviteToFamily.access$getBinding(BottomSheetInviteToFamily.this).btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                Resource.Status sendFamilyInviteServerState = it.getSendFamilyInviteServerState();
                Resource.Status status = Resource.Status.LOADING;
                boolean z = sendFamilyInviteServerState == status;
                LocalizationLocalModel data = BottomSheetInviteToFamily.this.getLocalizationStorage().getData();
                String title = null;
                String title2 = (data == null || (familyInvites2 = data.getFamilyInvites()) == null || (sendInvite2 = familyInvites2.getSendInvite()) == null) ? null : sendInvite2.getTitle();
                if (title2 == null) {
                    title2 = "";
                }
                ViewBindingUtilsKt.showProgressBasedOn$default(btnApply, z, title2, 0, false, 12, null);
                AppCompatButton btnApply2 = BottomSheetInviteToFamily.access$getBinding(BottomSheetInviteToFamily.this).btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                boolean z2 = it.getSendFamilyInviteServerState() == status;
                LocalizationLocalModel data2 = BottomSheetInviteToFamily.this.getLocalizationStorage().getData();
                String title3 = (data2 == null || (familyInvites = data2.getFamilyInvites()) == null || (sendInvite = familyInvites.getSendInvite()) == null || (sendButton = sendInvite.getSendButton()) == null) ? null : sendButton.getTitle();
                ViewBindingUtilsKt.showProgressBasedOn$default(btnApply2, z2, title3 == null ? "" : title3, 0, false, 12, null);
                BottomSheetInviteToFamily.access$getBinding(BottomSheetInviteToFamily.this).btnApply.setEnabled(BottomSheetInviteToFamily.access$getBinding(BottomSheetInviteToFamily.this).etPhone.isCorrectPhone());
                int i = WhenMappings.$EnumSwitchMapping$0[it.getSendFamilyInviteServerState().ordinal()];
                if (i == 1) {
                    BottomSheetInviteToFamily.this.dismiss();
                    return;
                }
                if (i != 2) {
                    return;
                }
                NavController navController = BottomSheetInviteToFamily.this.getNavController();
                LocalizationLocalModel data3 = BottomSheetInviteToFamily.this.getLocalizationStorage().getData();
                String title4 = (data3 == null || (alert2 = data3.getAlert()) == null || (commonError2 = alert2.getCommonError()) == null) ? null : commonError2.getTitle();
                if (title4 == null) {
                    title4 = "";
                }
                Pair pair = TuplesKt.to(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, title4);
                Pair pair2 = TuplesKt.to("subtitle", it.getSendFamilyInviteErrorMessage());
                LocalizationLocalModel data4 = BottomSheetInviteToFamily.this.getLocalizationStorage().getData();
                if (data4 != null && (alert = data4.getAlert()) != null && (commonError = alert.getCommonError()) != null && (okButton = commonError.getOkButton()) != null) {
                    title = okButton.getTitle();
                }
                NavControllerKt.safeNavigate$default(navController, R.id.action_bottomSheetInviteToFamily_to_sendFamilyInviteErrorDialog, BundleKt.bundleOf(pair, pair2, TuplesKt.to("button_text", title != null ? title : "")), null, 4, null);
                BottomSheetInviteToFamily.this.getInvitesViewModel().clearOperationalState();
            }
        });
        InvitesViewModel invitesViewModel2 = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        invitesViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.onViewCreated.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BottomSheetInviteToFamily bottomSheetInviteToFamily = BottomSheetInviteToFamily.this;
                View rootView = view.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                ViewKt.renderNotifications(bottomSheetInviteToFamily, rootView, it);
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Object next;
        String strReplace$default;
        String code;
        final BottomSheetInviteToFamilyBinding binding = getBinding();
        List<DomainCountryCode> countryCodes = getInvitesViewModel().getCountryCodes();
        binding.etPhone.setCountryCodesList(countryCodes);
        PhoneEditTextView phoneEditTextView = binding.etPhone;
        Iterator<T> it = countryCodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((DomainCountryCode) next).getIsoCode(), AndroidConstants.INSTANCE.getPhoneCountry())) {
                    break;
                }
            }
        }
        DomainCountryCode domainCountryCode = (DomainCountryCode) next;
        if (domainCountryCode == null || (code = domainCountryCode.getCode()) == null || (strReplace$default = StringsKt.replace$default(code, "+", "", false, 4, (Object) null)) == null) {
            strReplace$default = "7";
        }
        phoneEditTextView.setCountryCode(strReplace$default);
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$initViews$1$2
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
            public final void invoke2(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                this.this$0.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilySendAnInvitation());
                InvitesViewModel invitesViewModel = this.this$0.getInvitesViewModel();
                EditText countryCodeEditText = binding.etPhone.getCountryCodeEditText();
                Editable text = countryCodeEditText != null ? countryCodeEditText.getText() : null;
                EditText phoneEditText = binding.etPhone.getPhoneEditText();
                Editable text2 = phoneEditText != null ? phoneEditText.getText() : null;
                StringBuilder sb = new StringBuilder();
                sb.append((Object) text);
                sb.append((Object) text2);
                invitesViewModel.sendFamilyInvite(sb.toString());
            }
        }, 1, null);
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetInviteToFamily.initViews$lambda$2$lambda$1(this.f$0, view);
            }
        });
        final List<Family> familyList = getFamilyViewModel().getCurrentState().getFamilyList();
        getBinding().etPhone.setListener(new PhoneEditTextView.PhoneEditTextListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$initViews$1$4
            /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
            @Override // sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView.PhoneEditTextListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPhoneChanged(java.lang.String r8, boolean r9) {
                /*
                    r7 = this;
                    java.lang.String r0 = "phone"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r0 = r7.this$0
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.access$setPhone$p(r0, r8)
                    java.util.List<sputnik.axmor.com.sputnik.entities.family.Family> r0 = r2
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.Iterator r0 = r0.iterator()
                L12:
                    boolean r1 = r0.hasNext()
                    r2 = 0
                    if (r1 == 0) goto L37
                    java.lang.Object r1 = r0.next()
                    r3 = r1
                    sputnik.axmor.com.sputnik.entities.family.Family r3 = (sputnik.axmor.com.sputnik.entities.family.Family) r3
                    java.lang.String r3 = r3.getPhone()
                    if (r3 == 0) goto L2b
                    java.lang.String r3 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r3)
                    goto L2c
                L2b:
                    r3 = r2
                L2c:
                    java.lang.String r4 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r8)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                    if (r3 == 0) goto L12
                    goto L38
                L37:
                    r1 = r2
                L38:
                    r0 = 1
                    r3 = 0
                    if (r1 != 0) goto L88
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r1 = r7.this$0
                    com.sputnik.common.viewmodels.InvitesViewModel r1 = sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.access$getInvitesViewModel(r1)
                    com.sputnik.common.base.VMState r1 = r1.getCurrentState()
                    com.sputnik.common.viewmodels.InvitesViewState r1 = (com.sputnik.common.viewmodels.InvitesViewState) r1
                    com.sputnik.common.entities.invites.FamilyInvites r1 = r1.getFamilyInvites()
                    if (r1 == 0) goto L82
                    java.util.List r1 = r1.getInvites()
                    if (r1 == 0) goto L82
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    java.util.Iterator r1 = r1.iterator()
                L5a:
                    boolean r4 = r1.hasNext()
                    if (r4 == 0) goto L7e
                    java.lang.Object r4 = r1.next()
                    r5 = r4
                    com.sputnik.common.entities.invites.FamilyInvite r5 = (com.sputnik.common.entities.invites.FamilyInvite) r5
                    java.lang.String r5 = r5.getPhone()
                    if (r5 == 0) goto L72
                    java.lang.String r5 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r5)
                    goto L73
                L72:
                    r5 = r2
                L73:
                    java.lang.String r6 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r8)
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
                    if (r5 == 0) goto L5a
                    goto L7f
                L7e:
                    r4 = r2
                L7f:
                    com.sputnik.common.entities.invites.FamilyInvite r4 = (com.sputnik.common.entities.invites.FamilyInvite) r4
                    goto L83
                L82:
                    r4 = r2
                L83:
                    if (r4 == 0) goto L86
                    goto L88
                L86:
                    r1 = r3
                    goto L89
                L88:
                    r1 = r0
                L89:
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r4 = r7.this$0
                    sputnik.axmor.com.databinding.BottomSheetInviteToFamilyBinding r4 = sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.access$getBinding(r4)
                    androidx.appcompat.widget.AppCompatButton r4 = r4.btnApply
                    if (r9 == 0) goto L9c
                    if (r1 != 0) goto L9c
                    boolean r8 = kotlin.text.StringsKt.isBlank(r8)
                    if (r8 != 0) goto L9c
                    goto L9d
                L9c:
                    r0 = r3
                L9d:
                    r4.setEnabled(r0)
                    if (r1 == 0) goto Lce
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r8 = r7.this$0
                    sputnik.axmor.com.databinding.BottomSheetInviteToFamilyBinding r8 = sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.access$getBinding(r8)
                    sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView r8 = r8.etPhone
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r9 = r7.this$0
                    com.sputnik.common.localization.LocalizationStorage r9 = r9.getLocalizationStorage()
                    com.sputnik.common.entities.localization.LocalizationLocalModel r9 = r9.getData()
                    if (r9 == 0) goto Lc6
                    com.sputnik.common.entities.localization.entities.family_invites.FamilyInvitesLocale r9 = r9.getFamilyInvites()
                    if (r9 == 0) goto Lc6
                    com.sputnik.common.entities.localization.entities.family_invites.FamilyInvitesLocale$SendFamilyInviteLocale r9 = r9.getSendInvite()
                    if (r9 == 0) goto Lc6
                    java.lang.String r2 = r9.getErrorAlreadyExists()
                Lc6:
                    if (r2 != 0) goto Lca
                    java.lang.String r2 = ""
                Lca:
                    r8.showError(r2)
                    goto Ld9
                Lce:
                    sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily r8 = r7.this$0
                    sputnik.axmor.com.databinding.BottomSheetInviteToFamilyBinding r8 = sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily.access$getBinding(r8)
                    sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView r8 = r8.etPhone
                    r8.hideError()
                Ld9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily$initViews$1$4.onPhoneChanged(java.lang.String, boolean):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(BottomSheetInviteToFamily this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilyCancel());
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getInvitesViewModel().loadFamilyInvites();
        getInvitesViewModel().clearOperationalState();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FamilyInvitesLocale familyInvites;
        FamilyInvitesLocale.SendFamilyInviteLocale sendInvite;
        BottomSheetInviteToFamilyBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (familyInvites = data.getFamilyInvites()) == null || (sendInvite = familyInvites.getSendInvite()) == null) {
            return;
        }
        TextView textView = binding.tvTitle;
        String title = sendInvite.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        TextView textView2 = binding.tvSubtitle;
        String subtitle = sendInvite.getSubtitle();
        if (subtitle == null) {
            subtitle = "";
        }
        textView2.setText(subtitle);
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle sendButton = sendInvite.getSendButton();
        String title2 = sendButton != null ? sendButton.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        appCompatButton.setText(title2);
        TextView textView3 = binding.tvPhoneLabel;
        String phoneLabel = sendInvite.getPhoneLabel();
        if (phoneLabel == null) {
            phoneLabel = "";
        }
        textView3.setText(phoneLabel);
        AppCompatButton appCompatButton2 = binding.btnBack;
        TextTitle cancelButton = sendInvite.getCancelButton();
        String title3 = cancelButton != null ? cancelButton.getTitle() : null;
        appCompatButton2.setText(title3 != null ? title3 : "");
    }
}
