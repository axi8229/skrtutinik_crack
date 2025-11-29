package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithSubtitle;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.entities.market.items.ItemsIds;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentKeysBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: KeysFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/KeysViewState;", "state", "", "renderUi", "(Lcom/sputnik/common/viewmodels/KeysViewState;)V", "setOverlayPaddingForRecyclerView", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "Lsputnik/axmor/com/databinding/FragmentKeysBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentKeysBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localization", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalization", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalization", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "Lkotlin/Lazy;", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysAdapter;", "keysAdapter", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysAdapter;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeysFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KeysFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentKeysBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    private final KeysAdapter keysAdapter;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localization;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentKeysBinding getBinding() {
        return (FragmentKeysBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalization() {
        LocalizationStorage localizationStorage = this.localization;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localization");
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

    private final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
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
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        KeysViewModel keysViewModel = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        keysViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        getAnalytics().trackLogEvent(new KeysEvents.ShowMyKeys());
        KeysViewModel keysViewModel2 = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        keysViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment.onViewCreated.2
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
                KeysFragment keysFragment = KeysFragment.this;
                ConstraintLayout root = keysFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(keysFragment, root, it);
            }
        });
        getKeysViewModel().getKeysIfNeeded();
    }

    /* compiled from: KeysFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KeysViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, KeysFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/KeysViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
            invoke2(keysViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KeysViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((KeysFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(KeysViewState state) {
        ProgressBar pb = getBinding().pb;
        Intrinsics.checkNotNullExpressionValue(pb, "pb");
        ViewBindingUtilsKt.visibilityBasedOn(pb, Boolean.valueOf(state.getServerState() == Resource.Status.LOADING));
        LinearLayout layoutViews = getBinding().layoutViews;
        Intrinsics.checkNotNullExpressionValue(layoutViews, "layoutViews");
        Resource.Status serverState = state.getServerState();
        Resource.Status status = Resource.Status.SUCCESS;
        ViewBindingUtilsKt.visibilityBasedOn(layoutViews, Boolean.valueOf(serverState == status));
        RecyclerView rvKeys = getBinding().rvKeys;
        Intrinsics.checkNotNullExpressionValue(rvKeys, "rvKeys");
        ViewBindingUtilsKt.visibilityBasedOn(rvKeys, Boolean.valueOf(!state.getKeys().peekContent().isEmpty()));
        TextView tvEmptyTitle = getBinding().tvEmptyTitle;
        Intrinsics.checkNotNullExpressionValue(tvEmptyTitle, "tvEmptyTitle");
        List<PhysicalKey> listPeekContent = state.getKeys().peekContent();
        ViewBindingUtilsKt.visibilityBasedOn(tvEmptyTitle, Boolean.valueOf(listPeekContent == null || listPeekContent.isEmpty()));
        if (state.getServerState() == status) {
            this.keysAdapter.submitList(state.getKeys().peekContent());
            this.keysAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.Main main;
        TextTitle registerButton;
        FragmentKeysBinding binding = getBinding();
        LocalizationLocalModel data = getLocalization().getData();
        if (data != null && (physicalKeys = data.getPhysicalKeys()) != null && (main = physicalKeys.getMain()) != null) {
            Toolbar toolbar = binding.toolbar;
            TextTitle navigation = main.getNavigation();
            toolbar.setTitle(StringUtilsKt.orEmpty(navigation != null ? navigation.getTitle() : null));
            binding.tvTitle.setText(StringUtilsKt.orEmpty(main.getTitle()));
            TextView textView = binding.tvKeyTitle;
            TitleWithSubtitle buyView = main.getBuyView();
            textView.setText(StringUtilsKt.orEmpty(buyView != null ? buyView.getTitle() : null));
            TextView textView2 = binding.tvKeySubtitle;
            TitleWithSubtitle buyView2 = main.getBuyView();
            textView2.setText(StringUtilsKt.orEmpty(buyView2 != null ? buyView2.getSubtitle() : null));
            TextView textView3 = binding.tvRegisterKey;
            PhysicalKeysLocale.Main.RegisterView registerView = main.getRegisterView();
            textView3.setText(StringUtilsKt.orEmpty(registerView != null ? registerView.getTitle() : null));
            AppCompatButton appCompatButton = binding.btnRegisterKey;
            PhysicalKeysLocale.Main.RegisterView registerView2 = main.getRegisterView();
            appCompatButton.setText(StringUtilsKt.orEmpty((registerView2 == null || (registerButton = registerView2.getRegisterButton()) == null) ? null : registerButton.getTitle()));
            TextView textView4 = binding.tvEmptyTitle;
            PhysicalKeysLocale.Main.EmptyView emptyView = main.getEmptyView();
            textView4.setText(StringUtilsKt.orEmpty(emptyView != null ? emptyView.getTitle() : null));
        }
        setOverlayPaddingForRecyclerView();
    }

    private final void setOverlayPaddingForRecyclerView() {
        getBinding().layoutRegisterKey.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeysFragment.setOverlayPaddingForRecyclerView$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOverlayPaddingForRecyclerView$lambda$3(KeysFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().layoutViews.setPadding(0, 0, 0, (int) (this$0.getBinding().layoutRegisterKey.getHeight() * 1.1d));
        this$0.getBinding().layoutViews.requestLayout();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentKeysBinding binding = getBinding();
        binding.rvKeys.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        this.keysAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        binding.rvKeys.setAdapter(this.keysAdapter);
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
        AppCompatButton btnRegisterKey = binding.btnRegisterKey;
        Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
        SafeClickListenerKt.setSafeOnClickListener$default(btnRegisterKey, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$initViews$1$1
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
                if (this.this$0.getSubscriptionsViewModel().hasSubscription()) {
                    this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickKeyRegister());
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_keys_to_key_register, null, null, 6, null);
                } else {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_keys_to_subscription_needed, null, null, 6, null);
                }
            }
        }, 1, null);
        ConstraintLayout layoutKeyPromo = binding.layoutKeyPromo;
        Intrinsics.checkNotNullExpressionValue(layoutKeyPromo, "layoutKeyPromo");
        SafeClickListenerKt.setSafeOnClickListener$default(layoutKeyPromo, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$initViews$1$2
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
                this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickKeyBanner());
                NavController navControllerFindNavController = FragmentKt.findNavController(this.this$0);
                if (navControllerFindNavController != null) {
                    NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.action_global_to_marketItemDetailsFragment, BundleKt.bundleOf(TuplesKt.to("id", ItemsIds.licensed_keys.toString())), null, 4, null);
                }
            }
        }, 1, null);
    }

    public KeysFragment() {
        super(R.layout.fragment_keys);
        this.binding = new ViewBindingFragmentDelegate(this, KeysFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$keysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.keysAdapter = new KeysAdapter(new Function1<PhysicalKey, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment$keysAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PhysicalKey physicalKey) {
                invoke2(physicalKey);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PhysicalKey it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_keys_to_key_manage, BundleKt.bundleOf(TuplesKt.to("item", it)), null, 4, null);
            }
        });
    }
}
