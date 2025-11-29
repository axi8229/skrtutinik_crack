package sputnik.axmor.com.sputnik.ui.main.help;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.SupportEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.help.Announce;
import com.sputnik.common.entities.localization.HelpLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.help.HelpBody;
import com.sputnik.common.entities.localization.entities.help.ViewFaq;
import com.sputnik.common.entities.localization.entities.help.ViewIntercomQuestions;
import com.sputnik.common.entities.localization.entities.help.ViewSupport;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.FaqViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentHelpBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.di.AppComponent;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewState;

/* compiled from: HelpFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010B\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/help/HelpFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;)V", "checkUnreadCount", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentHelpBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentHelpBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel$delegate", "Lkotlin/Lazy;", "getHelpViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel", "Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel$delegate", "getFaqViewModel", "()Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HelpFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HelpFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentHelpBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: faqViewModel$delegate, reason: from kotlin metadata */
    private final Lazy faqViewModel;

    /* renamed from: helpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy helpViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;
    public ISupportManager supportManager;

    /* compiled from: HelpFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Announce.AnnounceType.values().length];
            try {
                iArr[Announce.AnnounceType.CRITICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Announce.AnnounceType.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Announce.AnnounceType.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkUnreadCount() {
    }

    private final FragmentHelpBinding getBinding() {
        return (FragmentHelpBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
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

    private final HelpViewModel getHelpViewModel() {
        return (HelpViewModel) this.helpViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppComponent appComponent = ContextKt.getAppComponent(context);
        if (appComponent != null) {
            appComponent.inject(this);
        }
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        HelpViewModel helpViewModel = getHelpViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        helpViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        getHelpViewModel().loadAnnounce();
    }

    /* compiled from: HelpFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<HelpViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, HelpFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HelpViewState helpViewState) {
            invoke2(helpViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HelpViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((HelpFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(HelpViewState data) {
        String message;
        FragmentHelpBinding binding = getBinding();
        Announce announce = data.getAnnounce();
        if (announce != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[announce.getType().ordinal()];
            int color = ContextCompat.getColor(requireContext(), i != 1 ? i != 2 ? R.color.sputnik_green : R.color.sputnik_yellow : R.color.sputnik_red);
            Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.background_card_without_borders);
            if (drawable != null) {
                drawable.setTint(color);
            }
            binding.viewAnnounceBackground.setBackground(drawable);
            binding.ivAnnounce.setImageTintList(ColorStateList.valueOf(color));
            binding.tvAnnounce.setText(announce.getMessage());
        }
        ConstraintLayout layoutAnnounce = binding.layoutAnnounce;
        Intrinsics.checkNotNullExpressionValue(layoutAnnounce, "layoutAnnounce");
        Announce announce2 = data.getAnnounce();
        ViewBindingUtilsKt.visibilityBasedOn(layoutAnnounce, Boolean.valueOf((announce2 == null || (message = announce2.getMessage()) == null || StringsKt.isBlank(message) || data.getAnnounce().getType() == Announce.AnnounceType.UNKNOWN) ? false : true));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkUnreadCount();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentHelpBinding binding = getBinding();
        binding.layoutFaq.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpFragment.initViews$lambda$10$lambda$2(this.f$0, view);
            }
        });
        binding.layoutSupport.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpFragment.initViews$lambda$10$lambda$3(this.f$0, view);
            }
        });
        binding.settingsFeedback.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpFragment.initViews$lambda$10$lambda$4(this.f$0, view);
            }
        });
        binding.settingsAbout.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                HelpFragment.initViews$lambda$10$lambda$6(this.f$0, view);
            }
        });
        ConstraintLayout layoutCompanyContacts = binding.layoutCompanyContacts;
        Intrinsics.checkNotNullExpressionValue(layoutCompanyContacts, "layoutCompanyContacts");
        SafeClickListenerKt.setSafeOnClickListener$default(layoutCompanyContacts, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$initViews$1$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new SupportEvents.ClickHardwareQuestions());
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_aboutCompanyFragment, null, null, 12, null);
            }
        }, 1, null);
        binding.settingsAboutCompanyLayout.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                HelpFragment.initViews$lambda$10$lambda$8(this.f$0, view);
            }
        });
        binding.tvExperimental.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                HelpFragment.initViews$lambda$10$lambda$9(this.f$0, view);
            }
        });
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$2(HelpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new SupportEvents.ClickReadyAnswers());
        NavController navController = this$0.getNavController();
        if (navController != null) {
            NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_faqCategoriesFragment, null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$3(HelpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new SupportEvents.ClickApplicationQuestions());
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "help_open", null, 4, null);
        ISupportManager.DefaultImpls.displayMessenger$default(this$0.getSupportManager(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$4(HelpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "help_open", null, 4, null);
        ISupportManager.DefaultImpls.displayMessenger$default(this$0.getSupportManager(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$6(HelpFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "about_open", null, 4, null);
        if (this$0.getPrefManager().getIsNoDomofon()) {
            NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainNoIntercomFragment, R.id.action_mainNoIntercomFragment_to_aboutAppFragment, null, null, 12, null);
        } else {
            NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_aboutAppFragment, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$8(HelpFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_aboutCompanyFragment, null, null, 12, null);
    }

    public HelpFragment() {
        super(R.layout.fragment_help);
        this.binding = new ViewBindingFragmentDelegate(this, HelpFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.helpViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HelpViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$helpViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.faqViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FaqViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$faqViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.HelpFragment$navController$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10$lambda$9(HelpFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_global_to_experimental, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        HelpLocale help;
        HelpBody body;
        List<String> titles;
        HelpBody body2;
        ViewIntercomQuestions viewIntercomQuestions;
        HelpBody body3;
        ViewIntercomQuestions viewIntercomQuestions2;
        HelpBody body4;
        ViewIntercomQuestions viewIntercomQuestions3;
        HelpBody body5;
        ViewSupport viewSupport;
        HelpBody body6;
        ViewSupport viewSupport2;
        HelpBody body7;
        ViewSupport viewSupport3;
        HelpBody body8;
        ViewFaq viewFaq;
        HelpBody body9;
        ViewFaq viewFaq2;
        HelpBody body10;
        ViewFaq viewFaq3;
        HelpLocale help2;
        TextTitle navigation;
        FragmentHelpBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String action = null;
        HelpLocale help3 = data != null ? data.getHelp() : null;
        TextView textView = binding.toolbarTitle;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText((data2 == null || (help2 = data2.getHelp()) == null || (navigation = help2.getNavigation()) == null) ? null : navigation.getTitle());
        binding.tvTitleFaq.setText((help3 == null || (body10 = help3.getBody()) == null || (viewFaq3 = body10.getViewFaq()) == null) ? null : viewFaq3.getTitle());
        binding.tvFaqSubtitle.setText((help3 == null || (body9 = help3.getBody()) == null || (viewFaq2 = body9.getViewFaq()) == null) ? null : viewFaq2.getSubtitle());
        binding.tvFaqAction.setText((help3 == null || (body8 = help3.getBody()) == null || (viewFaq = body8.getViewFaq()) == null) ? null : viewFaq.getAction());
        binding.tvTitleSupport.setText((help3 == null || (body7 = help3.getBody()) == null || (viewSupport3 = body7.getViewSupport()) == null) ? null : viewSupport3.getTitle());
        binding.tvSupportSubtitle.setText((help3 == null || (body6 = help3.getBody()) == null || (viewSupport2 = body6.getViewSupport()) == null) ? null : viewSupport2.getSubtitle());
        binding.tvSupportAction.setText((help3 == null || (body5 = help3.getBody()) == null || (viewSupport = body5.getViewSupport()) == null) ? null : viewSupport.getAction());
        binding.tvContactsTitle.setText((help3 == null || (body4 = help3.getBody()) == null || (viewIntercomQuestions3 = body4.getViewIntercomQuestions()) == null) ? null : viewIntercomQuestions3.getTitle());
        binding.tvContactsSubtitle.setText((help3 == null || (body3 = help3.getBody()) == null || (viewIntercomQuestions2 = body3.getViewIntercomQuestions()) == null) ? null : viewIntercomQuestions2.getSubtitle());
        TextView textView2 = binding.tvContactsAction;
        if (help3 != null && (body2 = help3.getBody()) != null && (viewIntercomQuestions = body2.getViewIntercomQuestions()) != null) {
            action = viewIntercomQuestions.getAction();
        }
        textView2.setText(action);
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 == null || (help = data3.getHelp()) == null || (body = help.getBody()) == null || (titles = body.getTitles()) == null) {
            return;
        }
        binding.settingsFeedback.setText((CharSequence) CollectionsKt.first((List) titles));
        binding.settingsAbout.setText(titles.get(1));
        binding.settingsAboutCompany.setText((CharSequence) CollectionsKt.last((List) titles));
    }
}
