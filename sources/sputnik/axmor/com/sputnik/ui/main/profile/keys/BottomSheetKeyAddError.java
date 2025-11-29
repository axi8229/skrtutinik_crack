package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetKeyAddErrorBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetKeyAddError.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/BottomSheetKeyAddError;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetKeyAddErrorBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetKeyAddError extends BaseBottomSheetDialogFragment<BottomSheetKeyAddErrorBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    public static final /* synthetic */ BottomSheetKeyAddErrorBinding access$getBinding(BottomSheetKeyAddError bottomSheetKeyAddError) {
        return bottomSheetKeyAddError.getBinding();
    }

    /* compiled from: BottomSheetKeyAddError.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetKeyAddErrorBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetKeyAddErrorBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetKeyAddErrorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetKeyAddErrorBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetKeyAddErrorBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetKeyAddErrorBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetKeyAddError() {
        super(AnonymousClass1.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$navController$2
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
        final Function0 function0 = null;
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$keysViewModel$2
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

    private final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
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
        setStyle(0, R.style.BottomSheet);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        KeysViewModel keysViewModel = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        keysViewModel.observeState(viewLifecycleOwner, new Function1<KeysViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
                invoke2(keysViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeysViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TextView tvSubtitle = BottomSheetKeyAddError.access$getBinding(BottomSheetKeyAddError.this).tvSubtitle;
                Intrinsics.checkNotNullExpressionValue(tvSubtitle, "tvSubtitle");
                ViewBindingUtilsKt.visibilityBasedOn(tvSubtitle, Boolean.valueOf(!StringsKt.isBlank(it.getCreateKeyServerResponse())));
                BottomSheetKeyAddError.access$getBinding(BottomSheetKeyAddError.this).tvSubtitle.setText(it.getCreateKeyServerResponse());
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton btnApply = getBinding().btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError$initViews$1$1
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
                FragmentKt.findNavController(this.this$0).navigateUp();
            }
        }, 1, null);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        LocalizationLocalModel data;
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.ErrorPopup errorPopup;
        BottomSheetKeyAddErrorBinding binding = getBinding();
        LocalizationStorage localizationStorage = getLocalizationStorage();
        if (localizationStorage == null || (data = localizationStorage.getData()) == null || (physicalKeys = data.getPhysicalKeys()) == null || (errorPopup = physicalKeys.getErrorPopup()) == null) {
            return;
        }
        binding.tvTitle.setText(StringUtilsKt.orEmpty(errorPopup.getTitle()));
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle backButton = errorPopup.getBackButton();
        appCompatButton.setText(StringUtilsKt.orEmpty(backButton != null ? backButton.getTitle() : null));
        AppCompatButton appCompatButton2 = binding.btnSupport;
        TextTitle supportButton = errorPopup.getSupportButton();
        appCompatButton2.setText(StringUtilsKt.orEmpty(supportButton != null ? supportButton.getTitle() : null));
    }
}
