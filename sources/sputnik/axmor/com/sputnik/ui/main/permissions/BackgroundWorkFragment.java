package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.adapters.ChildFragmentStateAdapter;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.instructions.Instruction;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.InstructionsViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentBackgroundWorkBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BackgroundWorkFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/BackgroundWorkFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "navigateToNextPage", "navigateToPreviousPage", "closeScreen", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentBackgroundWorkBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentBackgroundWorkBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel$delegate", "Lkotlin/Lazy;", "getInstructionsViewModel", "()Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackgroundWorkFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BackgroundWorkFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentBackgroundWorkBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: instructionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy instructionsViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    private final FragmentBackgroundWorkBinding getBinding() {
        return (FragmentBackgroundWorkBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final InstructionsViewModel getInstructionsViewModel() {
        return (InstructionsViewModel) this.instructionsViewModel.getValue();
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
        InstructionsViewModel instructionsViewModel = getInstructionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        instructionsViewModel.observeState(viewLifecycleOwner, new Function1<InstructionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InstructionsViewState instructionsViewState) {
                invoke2(instructionsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InstructionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getNeedToBeClosed()) {
                    FragmentKt.findNavController(BackgroundWorkFragment.this).navigateUp();
                    BackgroundWorkFragment.this.getInstructionsViewModel().clearNavigation();
                }
                if (it.getNeedNavigateToNext()) {
                    BackgroundWorkFragment.this.navigateToNextPage();
                    BackgroundWorkFragment.this.getInstructionsViewModel().clearNavigation();
                }
                if (it.getNeedNavigateToPrevious()) {
                    BackgroundWorkFragment.this.navigateToPreviousPage();
                    BackgroundWorkFragment.this.getInstructionsViewModel().clearNavigation();
                }
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentBackgroundWorkBinding binding = getBinding();
        binding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackgroundWorkFragment.initViews$lambda$5$lambda$0(this.f$0, view);
            }
        });
        ConstraintLayout layoutRoot = binding.layoutRoot;
        Intrinsics.checkNotNullExpressionValue(layoutRoot, "layoutRoot");
        ViewKt.addSystemWindowInsetToPadding(layoutRoot, true);
        View childAt = binding.instructionsViewpager.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) childAt).setNestedScrollingEnabled(false);
        ViewPager2 viewPager2 = binding.instructionsViewpager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager2.setAdapter(new ChildFragmentStateAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle(), null, 4, null));
        RecyclerView.Adapter adapter = getBinding().instructionsViewpager.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.sputnik.common.base.adapters.ChildFragmentStateAdapter");
        ChildFragmentStateAdapter childFragmentStateAdapter = (ChildFragmentStateAdapter) adapter;
        int i = 0;
        for (Object obj : getInstructionsViewModel().getInstructions()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            childFragmentStateAdapter.addFragment(InstructionFragment.INSTANCE.newInstance(((Instruction) obj).getId(), i2));
            i = i2;
        }
        new TabLayoutMediator(binding.tabLayout, binding.instructionsViewpager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$$ExternalSyntheticLambda1
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i3) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }
        }).attach();
        ViewPager2 viewPager22 = getBinding().instructionsViewpager;
        if (getInstructionsViewModel().getInstructions().size() > 0) {
            viewPager22.setOffscreenPageLimit(getInstructionsViewModel().getInstructions().size());
        }
        View childAt2 = binding.instructionsViewpager.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) childAt2).setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$0(BackgroundWorkFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToNextPage() {
        FragmentBackgroundWorkBinding binding = getBinding();
        RecyclerView.Adapter adapter = binding.instructionsViewpager.getAdapter();
        if (adapter != null && binding.instructionsViewpager.getCurrentItem() + 1 == adapter.getItemCount()) {
            closeScreen();
        } else {
            ViewPager2 viewPager2 = getBinding().instructionsViewpager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToPreviousPage() {
        if (getBinding().instructionsViewpager.getCurrentItem() - 1 < 0) {
            closeScreen();
        } else {
            getBinding().instructionsViewpager.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    private final void closeScreen() {
        FragmentKt.findNavController(this).navigateUp();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    public BackgroundWorkFragment() {
        super(R.layout.fragment_background_work);
        this.binding = new ViewBindingFragmentDelegate(this, BackgroundWorkFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.instructionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InstructionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$instructionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment$navController$2
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
