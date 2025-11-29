package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.instructions.Instruction;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import dagger.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentInstructionBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.views.ViewsParser;
import sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: InstructionFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001d\u0010G\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\"\u001a\u0004\bE\u0010FR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\"\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/InstructionFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentInstructionBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentInstructionBinding;", "binding", "Ldagger/Lazy;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Ldagger/Lazy;", "getFactory", "()Ldagger/Lazy;", "setFactory", "(Ldagger/Lazy;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel$delegate", "getInstructionsViewModel", "()Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "", "instructionId$delegate", "getInstructionId", "()Ljava/lang/String;", "instructionId", "", "position$delegate", "getPosition", "()Ljava/lang/Integer;", "position", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstructionFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(InstructionFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentInstructionBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public Lazy<MultiViewModelFactory> factory;

    /* renamed from: instructionId$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy instructionId;

    /* renamed from: instructionsViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy instructionsViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy navigationViewModel;

    /* renamed from: position$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy position;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy profileViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy settingsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentInstructionBinding getBinding() {
        return (FragmentInstructionBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Lazy<MultiViewModelFactory> getFactory() {
        Lazy<MultiViewModelFactory> lazy = this.factory;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InstructionsViewModel getInstructionsViewModel() {
        return (InstructionsViewModel) this.instructionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    private final String getInstructionId() {
        return (String) this.instructionId.getValue();
    }

    private final Integer getPosition() {
        return (Integer) this.position.getValue();
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
        SettingsViewModel settingsViewModel = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        settingsViewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment.onViewCreated.1
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
                InstructionFragment instructionFragment = InstructionFragment.this;
                ConstraintLayout root = instructionFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(instructionFragment, root, it);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().layoutViews.requestLayout();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        getBinding();
        Instruction instructionById = getInstructionsViewModel().getInstructionById(String.valueOf(getInstructionId()));
        if (instructionById != null) {
            String toolbarTitle = instructionById.getToolbarTitle();
            Integer position = getPosition();
            instructionById.setToolbarTitle(StringUtilsKt.formatSafe(toolbarTitle, Integer.valueOf(position != null ? position.intValue() : 1)));
            ViewsParser viewsParser = new ViewsParser();
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            TextView tvToolbar = getBinding().tvToolbar;
            Intrinsics.checkNotNullExpressionValue(tvToolbar, "tvToolbar");
            LinearLayout layoutViews = getBinding().layoutViews;
            Intrinsics.checkNotNullExpressionValue(layoutViews, "layoutViews");
            LinearLayout layoutBottomButtons2 = getBinding().layoutBottomButtons2;
            Intrinsics.checkNotNullExpressionValue(layoutBottomButtons2, "layoutBottomButtons2");
            viewsParser.attachViews(layoutInflater, root, instructionById, tvToolbar, layoutViews, layoutBottomButtons2, new Function1<ClickActions, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$initViews$1$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClickActions clickActions) {
                    invoke2(clickActions);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClickActions it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it instanceof ClickActions.NextAction) {
                        this.this$0.getInstructionsViewModel().navigateToNext();
                        return;
                    }
                    if (it instanceof ClickActions.PreviousAction) {
                        this.this$0.getInstructionsViewModel().navigateToPrevious();
                    } else if (it instanceof ClickActions.CloseAction) {
                        this.this$0.getInstructionsViewModel().closeInstructions();
                    } else if (it instanceof ClickActions.DeeplinkAction) {
                        IntentProcessingUtilsKt.handleDeeplink(((ClickActions.DeeplinkAction) it).getDeeplink(), BundleKt.bundleOf(), this.this$0.getActivity(), this.this$0.getNavigationViewModel(), this.this$0.getProfileViewModel(), (64 & 32) != 0 ? null : this.this$0.getAnalytics(), (64 & 64) != 0 ? null : null);
                    }
                }
            });
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    /* compiled from: InstructionFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/InstructionFragment$Companion;", "", "()V", "KEY", "", "newInstance", "Lsputnik/axmor/com/sputnik/ui/main/permissions/InstructionFragment;", "instructionId", "position", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InstructionFragment newInstance(String instructionId, int position) {
            Intrinsics.checkNotNullParameter(instructionId, "instructionId");
            InstructionFragment instructionFragment = new InstructionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("product_id", instructionId);
            bundle.putInt("start_position", position);
            instructionFragment.setArguments(bundle);
            return instructionFragment;
        }
    }

    public InstructionFragment() {
        super(R.layout.fragment_instruction);
        this.binding = new ViewBindingFragmentDelegate(this, InstructionFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.instructionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InstructionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$instructionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.instructionId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$instructionId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("product_id");
                }
                return null;
            }
        });
        this.position = LazyKt.lazy(new Function0<Integer>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment$position$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return Integer.valueOf(arguments.getInt("start_position"));
                }
                return null;
            }
        });
    }
}
