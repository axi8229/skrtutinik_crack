package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FamilyMemberBody;
import com.sputnik.common.entities.localization.FamilyMemberLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
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
import sputnik.axmor.com.databinding.FragmentDetailsFamilyBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;

/* compiled from: FamilyInfoFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0003R#\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010,\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010,\u001a\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyInfoFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", "Lcom/sputnik/domain/common/Event;", "", "isDeleted", "processDelete", "(Lcom/sputnik/domain/common/Event;)V", "isMadeAdmin", "processAdmin", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentDetailsFamilyBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentDetailsFamilyBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "Lkotlin/Lazy;", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "person$delegate", "getPerson", "()Lsputnik/axmor/com/sputnik/entities/family/Family;", "person", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyInfoFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FamilyInfoFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentDetailsFamilyBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: person$delegate, reason: from kotlin metadata */
    private final Lazy person;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDetailsFamilyBinding getBinding() {
        return (FragmentDetailsFamilyBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Family getPerson() {
        return (Family) this.person.getValue();
    }

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().setItem(getPerson());
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner, new C26841(this));
        FamilyViewModel familyViewModel2 = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        familyViewModel2.observeSubState(viewLifecycleOwner2, new Function1<FamilyViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(FamilyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isDeleted();
            }
        }, new AnonymousClass3(this));
        FamilyViewModel familyViewModel3 = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        familyViewModel3.observeSubState(viewLifecycleOwner3, new Function1<FamilyViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(FamilyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isMadeAdmin();
            }
        }, new AnonymousClass5(this));
        FamilyViewModel familyViewModel4 = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        familyViewModel4.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment.onViewCreated.6
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
                FamilyInfoFragment familyInfoFragment = FamilyInfoFragment.this;
                View root = familyInfoFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(familyInfoFragment, root, it);
            }
        });
    }

    /* compiled from: FamilyInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26841 extends FunctionReferenceImpl implements Function1<FamilyViewState, Unit> {
        C26841(Object obj) {
            super(1, obj, FamilyInfoFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FamilyViewState familyViewState) {
            invoke2(familyViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FamilyViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FamilyInfoFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: FamilyInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, FamilyInfoFragment.class, "processDelete", "processDelete(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FamilyInfoFragment) this.receiver).processDelete(p0);
        }
    }

    /* compiled from: FamilyInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, FamilyInfoFragment.class, "processAdmin", "processAdmin(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FamilyInfoFragment) this.receiver).processAdmin(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(FamilyViewState data) {
        data.getServerState();
        Resource.Status status = Resource.Status.SUCCESS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processDelete(Event<Boolean> isDeleted) {
        FamilyMemberLocale familyMember;
        FamilyMemberBody body;
        String deleteMessage;
        Boolean contentIfNotHandled = isDeleted.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data != null && (familyMember = data.getFamilyMember()) != null && (body = familyMember.getBody()) != null && (deleteMessage = body.getDeleteMessage()) != null) {
            String str = String.format(deleteMessage, getPerson().getFullName());
            FamilyViewModel familyViewModel = getFamilyViewModel();
            Intrinsics.checkNotNull(str);
            familyViewModel.notifySuccessMessage(str);
        }
        getFamilyViewModel().loadFamily();
        getNavController().popBackStack(R.id.familyFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processAdmin(Event<Boolean> isMadeAdmin) {
        ProfileSettingsLocale profileSettings;
        List<String> messages;
        String str;
        Boolean contentIfNotHandled = isMadeAdmin.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data != null && (profileSettings = data.getProfileSettings()) != null && (messages = profileSettings.getMessages()) != null && (str = (String) CollectionsKt.first((List) messages)) != null) {
            getFamilyViewModel().notifySuccessMessage(str);
        }
        getFamilyViewModel().loadFamily();
        getInvitesViewModel().loadFamilyInvites();
        NavController navController = getNavController();
        if (navController != null) {
            navController.navigateUp();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton btnMakeAdmin = getBinding().btnMakeAdmin;
        Intrinsics.checkNotNullExpressionValue(btnMakeAdmin, "btnMakeAdmin");
        SafeClickListenerKt.setSafeOnClickListener$default(btnMakeAdmin, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment.initViews.1
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
                FamilyInfoFragment.this.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilyMakeAnAdmin());
                FamilyViewModel familyViewModel = FamilyInfoFragment.this.getFamilyViewModel();
                Integer id = FamilyInfoFragment.this.getPerson().getId();
                Intrinsics.checkNotNull(id);
                familyViewModel.makeAdmin(id.intValue());
            }
        }, 1, null);
        getBinding().btnDelete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyInfoFragment.initViews$lambda$4(this.f$0, view);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = getBinding().viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(FamilyInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilyRemoveFromTheFamily());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_familyInfoFragment_to_removeFromFamilyDialog, BundleKt.bundleOf(TuplesKt.to("item", this$0.getPerson())), null, 4, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FamilyMemberLocale familyMember;
        FamilyMemberBody body;
        TextTitle deleteButton;
        FamilyMemberLocale familyMember2;
        FamilyMemberBody body2;
        TextTitle adminButton;
        FamilyMemberLocale familyMember3;
        TextTitle navigation;
        FragmentDetailsFamilyBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data == null || (familyMember3 = data.getFamilyMember()) == null || (navigation = familyMember3.getNavigation()) == null) ? null : navigation.getTitle());
        AppCompatButton appCompatButton = binding.btnMakeAdmin;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        appCompatButton.setText((data2 == null || (familyMember2 = data2.getFamilyMember()) == null || (body2 = familyMember2.getBody()) == null || (adminButton = body2.getAdminButton()) == null) ? null : adminButton.getTitle());
        AppCompatButton appCompatButton2 = binding.btnDelete;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 != null && (familyMember = data3.getFamilyMember()) != null && (body = familyMember.getBody()) != null && (deleteButton = body.getDeleteButton()) != null) {
            title = deleteButton.getTitle();
        }
        appCompatButton2.setText(title);
    }

    public FamilyInfoFragment() {
        super(R.layout.fragment_details_family);
        this.binding = new ViewBindingFragmentDelegate(this, FamilyInfoFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.person = LazyKt.lazy(new Function0<Family>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$person$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Family invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("item") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.entities.family.Family");
                return (Family) obj;
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                return FragmentKt.findNavController(this.this$0);
            }
        });
    }
}
