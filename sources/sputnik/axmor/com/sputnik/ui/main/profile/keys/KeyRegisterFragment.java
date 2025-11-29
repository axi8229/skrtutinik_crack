package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.domain.common.Resource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentKeyRegisterBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.textWatchers.HexSymbolsMinMaxRestrictTextWatcher;
import sputnik.axmor.com.sputnik.utils.textWatchers.SymbolsMinMaxRestrictTextWatcher;

/* compiled from: KeyRegisterFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>¨\u0006@"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyRegisterFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/KeysViewState;", "state", "", "renderUi", "(Lcom/sputnik/common/viewmodels/KeysViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "localize", "initViews", "Lsputnik/axmor/com/databinding/FragmentKeyRegisterBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentKeyRegisterBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "Lkotlin/Lazy;", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "", "hexRestrictionPassed", "Z", "commentRestrictionPassed", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeyRegisterFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KeyRegisterFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentKeyRegisterBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    private boolean commentRestrictionPassed;
    public MultiViewModelFactory factory;
    private boolean hexRestrictionPassed;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentKeyRegisterBinding getBinding() {
        return (FragmentKeyRegisterBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
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
        KeysViewModel keysViewModel2 = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        keysViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment.onViewCreated.2
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
                KeyRegisterFragment keyRegisterFragment = KeyRegisterFragment.this;
                ConstraintLayout root = keyRegisterFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(keyRegisterFragment, root, it);
            }
        });
    }

    /* compiled from: KeyRegisterFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KeysViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, KeyRegisterFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/KeysViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
            invoke2(keysViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KeysViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((KeyRegisterFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(KeysViewState state) {
        String strOrEmpty;
        LocalizationLocalModel data;
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.AddKey addKey;
        TextTitle registerButton;
        String title;
        AppCompatButton btnRegisterKey = getBinding().btnRegisterKey;
        Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
        boolean z = state.getCreateKeyServerState() == Resource.Status.LOADING;
        LocalizationStorage localizationScreen = getLocalizationScreen();
        if (localizationScreen == null || (data = localizationScreen.getData()) == null || (physicalKeys = data.getPhysicalKeys()) == null || (addKey = physicalKeys.getAddKey()) == null || (registerButton = addKey.getRegisterButton()) == null || (title = registerButton.getTitle()) == null || (strOrEmpty = StringUtilsKt.orEmpty(title)) == null) {
            strOrEmpty = "";
        }
        ViewBindingUtilsKt.showProgressBasedOn$default(btnRegisterKey, z, strOrEmpty, 0, this.commentRestrictionPassed && this.hexRestrictionPassed, 4, null);
        if (state.getCreateKeyServerState() == Resource.Status.SUCCESS) {
            getAnalytics().trackLogEvent(new KeysEvents.StateKeyRegisterSuccessfull());
            FragmentKt.findNavController(this).navigateUp();
        }
        if (state.getCreateKeyServerState() == Resource.Status.ERROR) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.action_key_register_to_key_add_error, null, null, 6, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getKeysViewModel().clearKeyManageState();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.AddKey addKey;
        String title;
        FragmentKeyRegisterBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (physicalKeys = data.getPhysicalKeys()) == null || (addKey = physicalKeys.getAddKey()) == null) {
            return;
        }
        Toolbar toolbar = binding.toolbar;
        TextTitle navigation = addKey.getNavigation();
        toolbar.setTitle((navigation == null || (title = navigation.getTitle()) == null) ? null : StringUtilsKt.orEmpty(title));
        TextView textView = binding.tvKeyHex;
        TextPlaceHolder numberView = addKey.getNumberView();
        textView.setText(StringUtilsKt.orEmpty(numberView != null ? numberView.getTitle() : null));
        EditText editText = binding.etKeyHex;
        TextPlaceHolder numberView2 = addKey.getNumberView();
        editText.setHint(StringUtilsKt.orEmpty(numberView2 != null ? numberView2.getPlaceholder() : null));
        TextView textView2 = binding.tvKeyComment;
        TextPlaceHolder nameView = addKey.getNameView();
        textView2.setText(StringUtilsKt.orEmpty(nameView != null ? nameView.getTitle() : null));
        EditText editText2 = binding.etKeyComment;
        TextPlaceHolder nameView2 = addKey.getNameView();
        editText2.setHint(StringUtilsKt.orEmpty(nameView2 != null ? nameView2.getPlaceholder() : null));
        TextView textView3 = binding.tvTitle;
        String title2 = addKey.getTitle();
        textView3.setText(title2 != null ? StringUtilsKt.orEmpty(title2) : null);
        AppCompatButton appCompatButton = binding.btnRegisterKey;
        TextTitle registerButton = addKey.getRegisterButton();
        appCompatButton.setText(StringUtilsKt.orEmpty(registerButton != null ? registerButton.getTitle() : null));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final FragmentKeyRegisterBinding binding = getBinding();
        binding.etKeyHex.addTextChangedListener(new HexSymbolsMinMaxRestrictTextWatcher(8, 16, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.hexRestrictionPassed = true;
                if (this.this$0.commentRestrictionPassed) {
                    AppCompatButton btnRegisterKey = binding.btnRegisterKey;
                    Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
                    ViewKt.enable(btnRegisterKey);
                }
            }
        }, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                this.this$0.hexRestrictionPassed = false;
                AppCompatButton btnRegisterKey = binding.btnRegisterKey;
                Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
                ViewKt.disable(btnRegisterKey);
            }
        }, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }));
        binding.etKeyComment.addTextChangedListener(new SymbolsMinMaxRestrictTextWatcher(1, 50, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.commentRestrictionPassed = true;
                if (this.this$0.hexRestrictionPassed) {
                    AppCompatButton btnRegisterKey = binding.btnRegisterKey;
                    Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
                    ViewKt.enable(btnRegisterKey);
                }
            }
        }, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                this.this$0.commentRestrictionPassed = false;
                AppCompatButton btnRegisterKey = binding.btnRegisterKey;
                Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
                ViewKt.disable(btnRegisterKey);
            }
        }, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }));
        AppCompatButton btnRegisterKey = binding.btnRegisterKey;
        Intrinsics.checkNotNullExpressionValue(btnRegisterKey, "btnRegisterKey");
        SafeClickListenerKt.setSafeOnClickListener$default(btnRegisterKey, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$initViews$1$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.this$0.getKeysViewModel().addKey(new PhysicalKey(null, null, binding.etKeyHex.getText().toString(), null, binding.etKeyComment.getText().toString()));
            }
        }, 1, null);
        AppCompatButton btnRegisterKey2 = binding.btnRegisterKey;
        Intrinsics.checkNotNullExpressionValue(btnRegisterKey2, "btnRegisterKey");
        ViewKt.disable(btnRegisterKey2);
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    public KeyRegisterFragment() {
        super(R.layout.fragment_key_register);
        this.binding = new ViewBindingFragmentDelegate(this, KeyRegisterFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$keysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment$profileViewModel$2
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
