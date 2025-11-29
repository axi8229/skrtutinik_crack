package sputnik.axmor.com.sputnik.ui.our_home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdate;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.data.local.PrefManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentOurHomeBinding;
import sputnik.axmor.com.databinding.LayoutOurHomeDetailsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: OurHomeUpdateFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010'\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/our_home/OurHomeUpdateFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentOurHomeBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentOurHomeBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OurHomeUpdateFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(OurHomeUpdateFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentOurHomeBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;
    public PrefManager prefManager;

    private final FragmentOurHomeBinding getBinding() {
        return (FragmentOurHomeBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    private final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
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
        getOnboardingViewModel().lockOnboardingToOurHome();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentOurHomeBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar, true, true, true, false, 8, null);
        ConstraintLayout root = binding.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        ViewKt.addSystemWindowInsetToPadding$default(root, true, false, true, true, 2, null);
        ScrollView layoutContent = binding.layout.layoutContent;
        Intrinsics.checkNotNullExpressionValue(layoutContent, "layoutContent");
        ViewKt.addSystemWindowInsetToPadding$default(layoutContent, true, false, true, true, 2, null);
        binding.btnSubscribe.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OurHomeUpdateFragment.initViews$lambda$1$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1$lambda$0(OurHomeUpdateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavController navController = this$0.getNavController();
        if (navController != null) {
            navController.navigateUp();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle okButton;
        OurHomeUpdate.OurHomeUpdateAdditions additions;
        OurHomeUpdate.OurHomeUpdateAdditions additions2;
        OurHomeUpdate.OurHomeUpdateAdditions additions3;
        TitleWithParam description;
        TitleWithParam description2;
        TitleWithParam update;
        TitleWithParam update2;
        FragmentOurHomeBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        OurHomeUpdate ourHomeUpdate = data != null ? data.getOurHomeUpdate() : null;
        OurHomeUpdate.OurHomeUpdateBody body = ourHomeUpdate != null ? ourHomeUpdate.getBody() : null;
        binding.toolbarTitle.setText(ourHomeUpdate != null ? ourHomeUpdate.getTitle() : null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LayoutOurHomeDetailsBinding layoutOurHomeDetailsBinding = binding.layout;
        TextView tvText1 = layoutOurHomeDetailsBinding.tvText1;
        Intrinsics.checkNotNullExpressionValue(tvText1, "tvText1");
        ViewUtilsKt.highlightText(tvText1, String.valueOf((body == null || (update2 = body.getUpdate()) == null) ? null : update2.getTitle()), new HighlightedText(String.valueOf((body == null || (update = body.getUpdate()) == null) ? null : update.getParam1()), ContextCompat.getColor(contextRequireContext, R.color.sputnik_red), null, null, 0, 0, 60, null));
        TextView tvText2 = layoutOurHomeDetailsBinding.tvText2;
        Intrinsics.checkNotNullExpressionValue(tvText2, "tvText2");
        ViewUtilsKt.highlightText(tvText2, String.valueOf((ourHomeUpdate == null || (description2 = ourHomeUpdate.getDescription()) == null) ? null : description2.getTitle()), new HighlightedText(String.valueOf((ourHomeUpdate == null || (description = ourHomeUpdate.getDescription()) == null) ? null : description.getParam1()), ContextCompat.getColor(contextRequireContext, R.color.sputnik_red), null, null, 0, 0, 60, null));
        layoutOurHomeDetailsBinding.tvSputnikTitle.setText(ourHomeUpdate != null ? ourHomeUpdate.getSputnik() : null);
        layoutOurHomeDetailsBinding.tvOurHomeTitle.setText(ourHomeUpdate != null ? ourHomeUpdate.getOurHome() : null);
        layoutOurHomeDetailsBinding.tvService1.setText((ourHomeUpdate == null || (additions3 = ourHomeUpdate.getAdditions()) == null) ? null : additions3.getManagementCompanyServices());
        layoutOurHomeDetailsBinding.tvService2.setText((ourHomeUpdate == null || (additions2 = ourHomeUpdate.getAdditions()) == null) ? null : additions2.getCommunalServicesPayment());
        layoutOurHomeDetailsBinding.tvService3.setText((ourHomeUpdate == null || (additions = ourHomeUpdate.getAdditions()) == null) ? null : additions.getMastersServices());
        layoutOurHomeDetailsBinding.tvDescription.setText(ourHomeUpdate != null ? ourHomeUpdate.getBottomText() : null);
        AppCompatButton appCompatButton = binding.btnSubscribe;
        if (ourHomeUpdate != null && (okButton = ourHomeUpdate.getOkButton()) != null) {
            title = okButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    public OurHomeUpdateFragment() {
        super(R.layout.fragment_our_home);
        this.binding = new ViewBindingFragmentDelegate(this, OurHomeUpdateFragment$binding$2.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    return ActivityKt.findNavController(activity, R.id.root_nav_host_fragment);
                }
                return null;
            }
        });
        final Function0 function0 = null;
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
