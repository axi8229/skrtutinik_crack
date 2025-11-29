package sputnik.axmor.com.sputnik.ui.gorserv;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GorservEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.gorserv.GorservCatalog;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.WebViewUtils;
import com.sputnik.common.viewmodels.FaqViewModel;
import com.sputnik.common.viewmodels.GorservViewModel;
import com.sputnik.common.viewmodels.GorservViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSelectGorservCategoryBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: SelectGorservCategoryFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00105\u001a\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/gorserv/SelectGorservCategoryFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSelectGorservCategoryBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSelectGorservCategoryBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel$delegate", "getFaqViewModel", "()Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel", "Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel$delegate", "getGorservViewModel", "()Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel", "Lsputnik/axmor/com/sputnik/ui/gorserv/GorservCategoriesAdapter;", "gorservCategoriesAdapter", "Lsputnik/axmor/com/sputnik/ui/gorserv/GorservCategoriesAdapter;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectGorservCategoryFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SelectGorservCategoryFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSelectGorservCategoryBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: faqViewModel$delegate, reason: from kotlin metadata */
    private final Lazy faqViewModel;
    private GorservCategoriesAdapter gorservCategoriesAdapter;

    /* renamed from: gorservViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gorservViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSelectGorservCategoryBinding getBinding() {
        return (FragmentSelectGorservCategoryBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final GorservViewModel getGorservViewModel() {
        return (GorservViewModel) this.gorservViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
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
        getGorservViewModel().loadCatalogs();
        GorservViewModel gorservViewModel = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        gorservViewModel.observeState(viewLifecycleOwner, new Function1<GorservViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GorservViewState gorservViewState) {
                invoke2(gorservViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GorservViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SelectGorservCategoryFragment.this.gorservCategoriesAdapter.submitList(it.getCatalogs());
            }
        });
        GorservViewModel gorservViewModel2 = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        gorservViewModel2.observeSubState(viewLifecycleOwner2, new Function1<GorservViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(GorservViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) {
                invoke2(status);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource.Status it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LinearLayout layoutLoader = SelectGorservCategoryFragment.this.getBinding().layoutLoader;
                Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
                ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(it == Resource.Status.LOADING));
                ConstraintLayout layoutMain = SelectGorservCategoryFragment.this.getBinding().layoutMain;
                Intrinsics.checkNotNullExpressionValue(layoutMain, "layoutMain");
                ViewBindingUtilsKt.visibilityBasedOn(layoutMain, Boolean.valueOf(it == Resource.Status.SUCCESS || it == Resource.Status.ERROR));
            }
        });
        GorservViewModel gorservViewModel3 = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        gorservViewModel3.observeSubState(viewLifecycleOwner3, new Function1<GorservViewState, OnboardingSettings.GorservOnboardingSettings>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final OnboardingSettings.GorservOnboardingSettings invoke(GorservViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getGorservOnboardingSettings();
            }
        }, new Function1<OnboardingSettings.GorservOnboardingSettings, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings) {
                invoke2(gorservOnboardingSettings);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings) {
                if (gorservOnboardingSettings != null) {
                    ConstraintLayout layoutHowItWorks = SelectGorservCategoryFragment.this.getBinding().layoutHowItWorks;
                    Intrinsics.checkNotNullExpressionValue(layoutHowItWorks, "layoutHowItWorks");
                    ViewBindingUtilsKt.visibilityBasedOn(layoutHowItWorks, Boolean.valueOf(gorservOnboardingSettings.getNeedToShowInstruction()));
                }
            }
        });
        getGorservViewModel().loadNotificationsEmpty();
        ConstraintLayout toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ConstraintLayout toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar2, true, true, true, false, 8, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final FragmentSelectGorservCategoryBinding binding = getBinding();
        binding.layoutHowItWorks.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGorservCategoryFragment.initViews$lambda$6$lambda$0(this.f$0, view);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGorservCategoryFragment.initViews$lambda$6$lambda$1(this.f$0, view);
            }
        });
        binding.btnAbout.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGorservCategoryFragment.initViews$lambda$6$lambda$2(this.f$0, view);
            }
        });
        binding.tvPhone.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGorservCategoryFragment.initViews$lambda$6$lambda$3(this.f$0, binding, view);
            }
        });
        RecyclerView recyclerView = binding.rvCategories;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.gorservCategoriesAdapter);
        binding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectGorservCategoryFragment.initViews$lambda$6$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$0(SelectGorservCategoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickInformationVideo());
        WebViewUtils.INSTANCE.openWebPage(this$0.requireActivity(), "https://youtu.be/XwB_yftD6SY");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$1(SelectGorservCategoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$2(SelectGorservCategoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickAboutGorserv());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_selectGorservCategoryFragment_to_aboutGorservFragment, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$3(SelectGorservCategoryFragment this$0, FragmentSelectGorservCategoryBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickPhoneNumber());
        String string = this_with.tvPhone.getText().toString();
        try {
            this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", string, null)));
        } catch (Exception unused) {
            this$0.getGorservViewModel().notifyErrorMessage("Попробуйте позвонить вручную, номер скопирован в буфер обмена");
            try {
                Object systemService = this$0.requireActivity().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipData clipDataNewPlainText = ClipData.newPlainText("Phone", string);
                Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$5(SelectGorservCategoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGorservViewModel().closeHowItWorks();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FragmentSelectGorservCategoryBinding binding = getBinding();
        binding.tvToolbarTitle.setText("Бытовые услуги");
        binding.tvGorservTitle.setText("Вызвать мастера на дом");
        binding.tvHowItWorksTitle.setText("Как это работает?");
        binding.tvHowItWorksSubtitle.setText("Нажмите, чтобы посмотреть видео");
        binding.tvCallHint.setText("Позвоните по бесплатному номеру");
        binding.tvPhone.setText("8 (800) 333-10-37");
        binding.tvUserPhone.setText("Или выберите интересующую вас категорию услуг");
    }

    public SelectGorservCategoryFragment() {
        super(R.layout.fragment_select_gorserv_category);
        this.binding = new ViewBindingFragmentDelegate(this, SelectGorservCategoryFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.faqViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FaqViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$faqViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.gorservViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GorservViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$gorservViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.gorservCategoriesAdapter = new GorservCategoriesAdapter(new Function1<GorservCatalog, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$gorservCategoriesAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GorservCatalog gorservCatalog) {
                invoke2(gorservCatalog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GorservCatalog it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickCreateRequest());
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_selectGorservCategoryFragment_to_sendGorservRequestFragment, BundleKt.bundleOf(TuplesKt.to("item", it.getId())), null, 4, null);
            }
        }, null, 2, null);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment$navController$2
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
}
