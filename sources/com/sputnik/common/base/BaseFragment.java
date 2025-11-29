package com.sputnik.common.base;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.R$id;
import com.sputnik.common.di.CommonComponentKt;
import com.sputnik.common.extensions.ActivityExtensionsKt;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.support.SupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewState;
import com.sputnik.data.local.PrefManager;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BaseFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0016\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00107\u001a\u0002068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020;8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/sputnik/common/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sputnik/common/base/IBaseMethods;", "<init>", "()V", "", "contentLayoutId", "(I)V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/common/viewmodels/NavigationAction;", "action", "onNeedCustomNavigate", "(Lcom/sputnik/common/viewmodels/NavigationAction;)V", "Lcom/sputnik/common/viewmodels/NavigationScenario;", "scenario", "addNavigationAction", "(Lcom/sputnik/common/viewmodels/NavigationScenario;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "baseFactory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getBaseFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setBaseFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "Lkotlin/Lazy;", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/data/local/PrefManager;", "_prefManager", "Lcom/sputnik/data/local/PrefManager;", "get_prefManager", "()Lcom/sputnik/data/local/PrefManager;", "set_prefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/support/ISupportManager;", "ssupportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSsupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSsupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "baseCoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getBaseCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment implements IBaseMethods {
    public PrefManager _prefManager;
    private final CoroutineExceptionHandler baseCoroutineExceptionHandler;
    public MultiViewModelFactory baseFactory;
    private final CoroutineScope mainCoroutineScope;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private ISupportManager ssupportManager;

    public void onNeedCustomNavigate(NavigationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    public final MultiViewModelFactory getBaseFactory() {
        MultiViewModelFactory multiViewModelFactory = this.baseFactory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    public final PrefManager get_prefManager() {
        PrefManager prefManager = this._prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_prefManager");
        return null;
    }

    public final ISupportManager getSsupportManager() {
        return this.ssupportManager;
    }

    protected final CoroutineScope getMainCoroutineScope() {
        return this.mainCoroutineScope;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        CommonComponentKt.commonComponent(this).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initViews();
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        Intrinsics.checkNotNull(application);
        this.ssupportManager = new SupportManager(application);
        NavigationViewModel navigationViewModel = getNavigationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        navigationViewModel.observeState(viewLifecycleOwner, new Function1<NavigationViewState, Unit>() { // from class: com.sputnik.common.base.BaseFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationViewState navigationViewState) {
                invoke2(navigationViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavigationViewState it) {
                Queue<NavigationAction> navigationActions;
                NavigationAction navigationActionPeek;
                int i;
                FragmentActivity activity2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getNeedClearActivityIntent() && (activity2 = BaseFragment.this.getActivity()) != null) {
                    ActivityExtensionsKt.clearIntentExtras(activity2);
                }
                NavigationScenario action = it.getAction();
                if (action != null && action.getNeedToPopBackStack()) {
                    NavController navControllerFindNavController = FragmentKt.findNavController(BaseFragment.this);
                    if (BaseFragment.this.get_prefManager().getIsNoDomofon()) {
                        i = R$id.mainNoIntercomFragment;
                    } else {
                        i = R$id.mainHostFragment;
                    }
                    navControllerFindNavController.popBackStack(i, false);
                    BaseFragment.this.getNavigationViewModel().clearPopBackStack();
                }
                NavigationScenario action2 = it.getAction();
                if (action2 == null || (navigationActions = action2.getNavigationActions()) == null || (navigationActionPeek = navigationActions.peek()) == null) {
                    return;
                }
                BaseFragment baseFragment = BaseFragment.this;
                if (navigationActionPeek.getDst() == -1) {
                    FragmentKt.findNavController(baseFragment).navigateUp();
                    baseFragment.getNavigationViewModel().removeAction();
                    return;
                }
                if (navigationActionPeek.getType() == NavigationTypes.f25default) {
                    if (navigationActionPeek.getDst() == 666) {
                        ISupportManager ssupportManager = baseFragment.getSsupportManager();
                        if (ssupportManager != null) {
                            ISupportManager.DefaultImpls.displayMessenger$default(ssupportManager, null, 1, null);
                        }
                        baseFragment.getNavigationViewModel().removeAction();
                        return;
                    }
                    Bundle bundle = navigationActionPeek.getBundle();
                    if (bundle == null) {
                        bundle = BundleKt.bundleOf();
                    }
                    Bundle bundle2 = bundle;
                    if (navigationActionPeek.getParam() != null) {
                        bundle2.putString("product_id", navigationActionPeek.getParam());
                        bundle2.putString("code", navigationActionPeek.getParam());
                    }
                    if (NavControllerKt.safeNavigate$default(FragmentKt.findNavController(baseFragment), navigationActionPeek.getDst(), bundle2, null, 4, null)) {
                        baseFragment.getNavigationViewModel().removeAction();
                        return;
                    }
                    return;
                }
                baseFragment.onNeedCustomNavigate(navigationActionPeek);
            }
        });
    }

    protected final void addNavigationAction(NavigationScenario scenario) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        getNavigationViewModel().addAction(scenario);
    }

    public BaseFragment() {
        final Function0 function0 = null;
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.common.base.BaseFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.common.base.BaseFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.common.base.BaseFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getBaseFactory();
            }
        });
        BaseFragment$special$$inlined$CoroutineExceptionHandler$1 baseFragment$special$$inlined$CoroutineExceptionHandler$1 = new BaseFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.baseCoroutineExceptionHandler = baseFragment$special$$inlined$CoroutineExceptionHandler$1;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(baseFragment$special$$inlined$CoroutineExceptionHandler$1));
    }

    public BaseFragment(int i) {
        super(i);
        final Function0 function0 = null;
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.common.base.BaseFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.common.base.BaseFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.common.base.BaseFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getBaseFactory();
            }
        });
        BaseFragment$special$$inlined$CoroutineExceptionHandler$2 baseFragment$special$$inlined$CoroutineExceptionHandler$2 = new BaseFragment$special$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.INSTANCE);
        this.baseCoroutineExceptionHandler = baseFragment$special$$inlined$CoroutineExceptionHandler$2;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(baseFragment$special$$inlined$CoroutineExceptionHandler$2));
    }
}
