package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.invites.FamilyInvite;
import com.sputnik.common.entities.invites.FamilyInvites;
import com.sputnik.common.entities.localization.FamilyListBody;
import com.sputnik.common.entities.localization.FamilyListLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import java.util.ArrayList;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSettingsFamilyBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2;
import sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.FamilyInvitesAdapter;
import sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.FamilyListAdapter;
import sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.MyButton;
import sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.SwipeHelper;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;

/* compiled from: FamilyListFragment.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R#\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00106\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00106\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyListFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/InvitesViewState;", RemoteMessageConst.DATA, "", "renderInvites", "(Lcom/sputnik/common/viewmodels/InvitesViewState;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSettingsFamilyBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSettingsFamilyBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "Lkotlin/Lazy;", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/SwipeHelper;", "swiper$delegate", "getSwiper", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/SwipeHelper;", "swiper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "swipeHelper$delegate", "getSwipeHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "swipeHelper", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyListFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FamilyListFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSettingsFamilyBinding;", 0))};
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

    /* renamed from: swipeHelper$delegate, reason: from kotlin metadata */
    private final Lazy swipeHelper;

    /* renamed from: swiper$delegate, reason: from kotlin metadata */
    private final Lazy swiper;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSettingsFamilyBinding getBinding() {
        return (FragmentSettingsFamilyBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwipeHelper getSwiper() {
        return (SwipeHelper) this.swiper.getValue();
    }

    private final ItemTouchHelper getSwipeHelper() {
        return (ItemTouchHelper) this.swipeHelper.getValue();
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
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, getNavController(), null, 2, null);
        getFamilyViewModel().loadFamilyIfNeeded();
        getInvitesViewModel().loadFamilyInvitesIfNeeded();
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        InvitesViewModel invitesViewModel2 = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        invitesViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment.onViewCreated.3
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
                FamilyListFragment familyListFragment = FamilyListFragment.this;
                View root = familyListFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(familyListFragment, root, it);
            }
        });
    }

    /* compiled from: FamilyListFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FamilyViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, FamilyListFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FamilyViewState familyViewState) {
            invoke2(familyViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FamilyViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FamilyListFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: FamilyListFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<InvitesViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, FamilyListFragment.class, "renderInvites", "renderInvites(Lcom/sputnik/common/viewmodels/InvitesViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InvitesViewState invitesViewState) {
            invoke2(invitesViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InvitesViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FamilyListFragment) this.receiver).renderInvites(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018b  */
    /* JADX WARN: Type inference failed for: r4v14, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderInvites(com.sputnik.common.viewmodels.InvitesViewState r21) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment.renderInvites(com.sputnik.common.viewmodels.InvitesViewState):void");
    }

    public FamilyListFragment() {
        super(R.layout.fragment_settings_family);
        this.binding = new ViewBindingFragmentDelegate(this, FamilyListFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                return FragmentKt.findNavController(this.this$0);
            }
        });
        this.swiper = LazyKt.lazy(new Function0<FamilyListFragment$swiper$2.AnonymousClass1>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new SwipeHelper(this.this$0.requireContext(), this.this$0.getBinding().rvInvites) { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2.1
                    {
                        Intrinsics.checkNotNull(recyclerView);
                    }

                    @Override // sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.SwipeHelper
                    public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer, FamilyInvite item) {
                        Intrinsics.checkNotNullParameter(buffer, "buffer");
                        Intrinsics.checkNotNullParameter(item, "item");
                        if (item.getState() != FamilyInvite.FamilyInviteState.accepted) {
                            Context contextRequireContext = this.this$0.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                            int color = Color.parseColor("#FF3D71");
                            final FamilyListFragment familyListFragment = this.this$0;
                            buffer.add(new MyButton("delete", contextRequireContext, R.drawable.ic_delete, color, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2$1$instantiateMyButton$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i) {
                                    List<FamilyInvite> invites;
                                    FamilyInvites familyInvites = familyListFragment.getInvitesViewModel().getCurrentState().getFamilyInvites();
                                    FamilyInvite familyInvite = (familyInvites == null || (invites = familyInvites.getInvites()) == null) ? null : invites.get(i);
                                    if (familyInvite != null) {
                                        FamilyListFragment familyListFragment2 = familyListFragment;
                                        Integer id = familyInvite.getId();
                                        if (id != null) {
                                            int iIntValue = id.intValue();
                                            familyListFragment2.getAnalytics().trackLogEvent(new FamilyEvents.ClickInviteToTheFamilyDelete());
                                            familyListFragment2.getInvitesViewModel().deleteFamilyInvite(String.valueOf(iIntValue));
                                        }
                                    }
                                }
                            }));
                            if (item.getState() == FamilyInvite.FamilyInviteState.sent) {
                                return;
                            }
                            Context contextRequireContext2 = this.this$0.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                            int color2 = Color.parseColor("#0EA7FF");
                            final FamilyListFragment familyListFragment2 = this.this$0;
                            buffer.add(new MyButton("resend", contextRequireContext2, R.drawable.ic_refresh_white, color2, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swiper$2$1$instantiateMyButton$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i) {
                                    FamilyInvites familyInvites;
                                    List<FamilyInvite> invites;
                                    familyListFragment2.getAnalytics().trackLogEvent(new FamilyEvents.ClickInviteToTheFamilyAgain());
                                    NavController navControllerFindNavController = FragmentKt.findNavController(familyListFragment2);
                                    InvitesViewState currentState = familyListFragment2.getInvitesViewModel().getCurrentState();
                                    NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.action_familyFragment_to_resendFamilyInviteDialog, BundleKt.bundleOf(TuplesKt.to("item", (currentState == null || (familyInvites = currentState.getFamilyInvites()) == null || (invites = familyInvites.getInvites()) == null) ? null : invites.get(i))), null, 4, null);
                                }
                            }));
                        }
                    }
                };
            }
        });
        this.swipeHelper = LazyKt.lazy(new Function0<ItemTouchHelper>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$swipeHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ItemTouchHelper invoke() {
                return new ItemTouchHelper(this.this$0.getSwiper());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(FamilyViewState data) {
        Object next;
        LinearLayout loader = getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader, "loader");
        ViewBindingUtilsKt.visibilityBasedOn(loader, Boolean.valueOf(data.getServerState() == Resource.Status.LOADING));
        if (data.getServerState() == Resource.Status.SUCCESS) {
            if (data.getFamilyList().isEmpty()) {
                getFamilyViewModel().loadFamily();
                return;
            }
            Iterator<T> it = data.getFamilyList().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((Family) next).getIsMe()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            Family family = (Family) next;
            Boolean boolValueOf = family != null ? Boolean.valueOf(family.getIsAdmin()) : null;
            LinearLayout layoutFamilyActions = getBinding().layoutFamilyActions;
            Intrinsics.checkNotNullExpressionValue(layoutFamilyActions, "layoutFamilyActions");
            ViewBindingUtilsKt.visibilityBasedOn(layoutFamilyActions, Boolean.valueOf(Intrinsics.areEqual(boolValueOf, Boolean.FALSE)));
            LinearLayout layoutInvitesActions = getBinding().layoutInvitesActions;
            Intrinsics.checkNotNullExpressionValue(layoutInvitesActions, "layoutInvitesActions");
            ViewBindingUtilsKt.visibilityBasedOn(layoutInvitesActions, Boolean.valueOf(Intrinsics.areEqual(boolValueOf, Boolean.TRUE)));
            RecyclerView.Adapter adapter = getBinding().familyList.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.FamilyListAdapter");
            FamilyListAdapter familyListAdapter = (FamilyListAdapter) adapter;
            List<Family> familyList = data.getFamilyList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(familyList, 10));
            for (Family family2 : familyList) {
                arrayList.add(Family.copy$default(family2, null, null, null, false, false, (family != null ? family.getIsAdmin() : false) && !family2.getIsMe(), null, 95, null));
            }
            familyListAdapter.submitList(arrayList);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FamilyListLocale familyList;
        FamilyListBody body;
        FamilyListLocale familyList2;
        FamilyListBody body2;
        getBinding().layoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FamilyListFragment.initViews$lambda$7(this.f$0);
            }
        });
        RecyclerView recyclerView = getBinding().familyList;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String admin = null;
        String self = (data == null || (familyList2 = data.getFamilyList()) == null || (body2 = familyList2.getBody()) == null) ? null : body2.getSelf();
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (familyList = data2.getFamilyList()) != null && (body = familyList.getBody()) != null) {
            admin = body.getAdmin();
        }
        recyclerView.setAdapter(new FamilyListAdapter(self, admin, new Function1<Family, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$initViews$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Family family) throws Resources.NotFoundException {
                invoke2(family);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Family item) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(item, "item");
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.familyFragment, R.id.action_familyFragment_to_familyInfoFragment, BundleKt.bundleOf(TuplesKt.to("item", item)), null, 8, null);
            }
        }));
        Intrinsics.checkNotNull(recyclerView);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView, true, false, true, true, 2, null);
        getSwipeHelper().attachToRecyclerView(getBinding().rvInvites);
        RecyclerView recyclerView2 = getBinding().rvInvites;
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        recyclerView2.setAdapter(new FamilyInvitesAdapter(new Function1<FamilyInvite, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$initViews$3$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FamilyInvite familyInvite) {
                invoke2(familyInvite);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FamilyInvite item) {
                Intrinsics.checkNotNullParameter(item, "item");
                BundleKt.bundleOf(TuplesKt.to("item", item));
            }
        }));
        Intrinsics.checkNotNull(recyclerView2);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView2, true, false, true, true, 2, null);
        getBinding().btnInvite.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyListFragment.initViews$lambda$10(this.f$0, view);
            }
        });
        getBinding().btnLeaveFromFamily.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyListFragment.initViews$lambda$11(this.f$0, view);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ConstraintLayout layoutRoot = getBinding().layoutRoot;
        Intrinsics.checkNotNullExpressionValue(layoutRoot, "layoutRoot");
        ViewKt.addSystemWindowInsetToPadding$default(layoutRoot, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(FamilyListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInvitesViewModel().loadFamilyInvites();
        this$0.getFamilyViewModel().loadFamily();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10(FamilyListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new FamilyEvents.ClickInviteToTheFamily());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_familyFragment_to_bottomSheetInviteToFamily, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11(FamilyListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_familyFragment_to_leaveFromFamilyDialog, null, null, 6, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FamilyListLocale familyList;
        TextTitle navigation;
        FamilyListLocale familyList2;
        FragmentSettingsFamilyBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        if (data != null && (familyList2 = data.getFamilyList()) != null) {
            TextView textView = binding.tvInvitesTitle;
            TextTitle navigation2 = familyList2.getNavigation();
            String title2 = navigation2 != null ? navigation2.getTitle() : null;
            if (title2 == null) {
                title2 = "";
            }
            textView.setText(title2);
            AppCompatButton appCompatButton = binding.btnInvite;
            FamilyListBody body = familyList2.getBody();
            String inviteButton = body != null ? body.getInviteButton() : null;
            if (inviteButton == null) {
                inviteButton = "";
            }
            appCompatButton.setText(inviteButton);
            AppCompatButton appCompatButton2 = binding.btnLeaveFromFamily;
            FamilyListBody body2 = familyList2.getBody();
            String leaveButton = body2 != null ? body2.getLeaveButton() : null;
            if (leaveButton == null) {
                leaveButton = "";
            }
            appCompatButton2.setText(leaveButton);
            TextView textView2 = binding.tvInvitesEmpty;
            FamilyListBody body3 = familyList2.getBody();
            String noInvites = body3 != null ? body3.getNoInvites() : null;
            textView2.setText(noInvites != null ? noInvites : "");
        }
        Toolbar toolbar = getBinding().toolbar;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (familyList = data2.getFamilyList()) != null && (navigation = familyList.getNavigation()) != null) {
            title = navigation.getTitle();
        }
        toolbar.setTitle(title);
    }
}
