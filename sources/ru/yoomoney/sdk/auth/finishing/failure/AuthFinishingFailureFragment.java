package ru.yoomoney.sdk.auth.finishing.failure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import java.io.UnsupportedEncodingException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.AuthEntryActivity;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.model.ErrorContactTechnicalSupport;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthFinishingFailureBinding;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailure;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PhoneUtilsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u000206H\u0016J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u000202H\u0016J\u001a\u0010@\u001a\u0002022\u0006\u0010A\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010B\u001a\u000202H\u0002J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020,H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020*H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R1\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0)j\u0002`-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b.\u0010/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailureFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthFinishingFailureBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthFinishingFailureBinding;", "contactsDialogContent", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "getContactsDialogContent", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "contactsDialogContent$delegate", "Lkotlin/Lazy;", "processError", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "getProcessError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "processError$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailureViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "back", "", "getContactsContent", "itemClick", "itemId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupIconClose", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingFailureFragment extends BaseFragment implements YmBottomSheetDialog.DialogListener {
    private AuthFinishingFailureBinding _binding;
    private final Config config;

    /* renamed from: contactsDialogContent$delegate, reason: from kotlin metadata */
    private final Lazy contactsDialogContent;

    /* renamed from: processError$delegate, reason: from kotlin metadata */
    private final Lazy processError;
    private final ProcessMapper processMapper;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<YmBottomSheetDialog.Content> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final YmBottomSheetDialog.Content invoke() {
            return AuthFinishingFailureFragment.this.getContactsContent();
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<AuthFinishingFailure.State, Unit> {
        public b(Object obj) {
            super(1, obj, AuthFinishingFailureFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthFinishingFailure.State state) {
            AuthFinishingFailure.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthFinishingFailureFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<AuthFinishingFailure.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, AuthFinishingFailureFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthFinishingFailure.Effect effect) throws UnsupportedEncodingException {
            AuthFinishingFailure.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthFinishingFailureFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = AuthFinishingFailureFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = AuthFinishingFailureFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<ProcessError> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessError invoke() {
            Bundle arguments = AuthFinishingFailureFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessError processError = AuthFinishingFailureFragmentArgs.fromBundle(arguments).getProcessError();
            Intrinsics.checkNotNullExpressionValue(processError, "getProcessError(...)");
            return processError;
        }
    }

    public static final class f extends Lambda implements Function0<ViewModelProvider.Factory> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return AuthFinishingFailureFragment.this.viewModelFactory;
        }
    }

    public AuthFinishingFailureFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        f fVar = new f();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, fVar);
        this.contactsDialogContent = LazyKt.lazy(new a());
        this.processError = LazyKt.lazy(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthFinishingFailureBinding getBinding() {
        AuthFinishingFailureBinding authFinishingFailureBinding = this._binding;
        Intrinsics.checkNotNull(authFinishingFailureBinding);
        return authFinishingFailureBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YmBottomSheetDialog.Content getContactsContent() {
        String string = getString(R.string.auth_yandex_acquire_registration_support);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        YmBottomSheetDialog.ContentItem.Headline headline = new YmBottomSheetDialog.ContentItem.Headline(string);
        String string2 = getString(R.string.auth_contact_dialog_email);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        YmBottomSheetDialog.ContentItem.MenuItem menuItem = new YmBottomSheetDialog.ContentItem.MenuItem(0, string2, null, null, false, false, 60, null);
        String string3 = getString(R.string.auth_contact_dialog_phone, PhoneUtilsKt.formatAndMaskNumber$default(this.config.getSupportPhone(), null, 2, null));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return new YmBottomSheetDialog.Content(CollectionsKt.listOf((Object[]) new YmBottomSheetDialog.ContentItem[]{headline, menuItem, new YmBottomSheetDialog.ContentItem.MenuItem(1, string3, null, null, false, false, 60, null)}));
    }

    private final YmBottomSheetDialog.Content getContactsDialogContent() {
        return (YmBottomSheetDialog.Content) this.contactsDialogContent.getValue();
    }

    private final ProcessError getProcessError() {
        return (ProcessError) this.processError.getValue();
    }

    private final RuntimeViewModel<AuthFinishingFailure.State, AuthFinishingFailure.Action, AuthFinishingFailure.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(AuthFinishingFailureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(AuthFinishingFailure.Action.Confirm.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AuthFinishingFailureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(AuthFinishingFailure.Action.OpenContacts.INSTANCE);
    }

    private final void setupIconClose() {
        ActionBar supportActionBar;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        AppCompatActivity appCompatActivity = fragmentActivityRequireActivity instanceof AppCompatActivity ? (AppCompatActivity) fragmentActivityRequireActivity : null;
        if (appCompatActivity == null || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_close_m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(AuthFinishingFailure.Effect effect) throws UnsupportedEncodingException {
        if (effect instanceof AuthFinishingFailure.Effect.Finish) {
            back();
            return;
        }
        if (!Intrinsics.areEqual(effect, AuthFinishingFailure.Effect.ShowContactsDialog.INSTANCE)) {
            if (Intrinsics.areEqual(effect, AuthFinishingFailure.Effect.CallPhone.INSTANCE)) {
                CoreFragmentExtensions.callPhone(this, this.config.getSupportPhone());
                return;
            } else {
                if (Intrinsics.areEqual(effect, AuthFinishingFailure.Effect.SendEmail.INSTANCE)) {
                    CoreFragmentExtensions.sendEmail$default(this, this.config.getSupportEmail(), null, null, 6, null);
                    return;
                }
                return;
            }
        }
        YmBottomSheetDialog.Companion companion = YmBottomSheetDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        YmBottomSheetDialog dialog = companion.getDialog(childFragmentManager, getContactsDialogContent());
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        dialog.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(AuthFinishingFailure.State state) {
        if (state instanceof AuthFinishingFailure.State.Content) {
            SecondaryButtonView secondaryAction = getBinding().secondaryAction;
            Intrinsics.checkNotNullExpressionValue(secondaryAction, "secondaryAction");
            secondaryAction.setVisibility(((AuthFinishingFailure.State.Content) state).getShowSupportButton() ? 0 : 8);
        }
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        if (getActivity() instanceof AuthEntryActivity) {
            cancelProcess$auth_release();
        } else {
            FragmentKt.findNavController(this).popBackStack(R.id.passportProfileFragment, false);
        }
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ProcessMapper getProcessMapper() {
        return this.processMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ResourceMapper getResourceMapper() {
        return this.resourceMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public Router getRouter() {
        return this.router;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public TopBarDefault getTopBar() {
        TopBarDefault appBar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        return appBar;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void handleDialogClose() {
        YmBottomSheetDialog.DialogListener.DefaultImpls.handleDialogClose(this);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void itemClick(Object itemId) {
        RuntimeViewModel<AuthFinishingFailure.State, AuthFinishingFailure.Action, AuthFinishingFailure.Effect> viewModel;
        AuthFinishingFailure.Action action;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        int iIntValue = ((Integer) itemId).intValue();
        if (iIntValue == 0) {
            viewModel = getViewModel();
            action = AuthFinishingFailure.Action.OpenEmail.INSTANCE;
        } else {
            if (iIntValue != 1) {
                return;
            }
            viewModel = getViewModel();
            action = AuthFinishingFailure.Action.OpenPhone.INSTANCE;
        }
        viewModel.handleAction(action);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthFinishingFailureBinding.inflate(inflater, container, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupIconClose();
        getBinding().text.setText(getResourceMapper().map(ProcessErrorExtensionsKt.toFailure(getProcessError())));
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AuthFinishingFailureFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        getBinding().secondaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AuthFinishingFailureFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        RuntimeViewModel<AuthFinishingFailure.State, AuthFinishingFailure.Action, AuthFinishingFailure.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
        getViewModel().handleAction(new AuthFinishingFailure.Action.Load(getProcessError() instanceof ErrorContactTechnicalSupport));
    }
}
