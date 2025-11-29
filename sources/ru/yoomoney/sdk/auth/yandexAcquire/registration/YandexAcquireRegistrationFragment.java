package ru.yoomoney.sdk.auth.yandexAcquire.registration;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthYandexAcquireNotRegisteredBinding;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PhoneUtilsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistration;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020.H\u0016J\u001a\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010<\u001a\u00020.H\u0002J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020'H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020%H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R1\u0010#\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0$j\u0002`(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistrationFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireNotRegisteredBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireNotRegisteredBinding;", "contactsDialogContent", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "getContactsDialogContent", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "contactsDialogContent$delegate", "Lkotlin/Lazy;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistrationViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "getContactsContent", "itemClick", "", "itemId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupViews", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireRegistrationFragment extends BaseFragment implements YmBottomSheetDialog.DialogListener {
    private AuthYandexAcquireNotRegisteredBinding _binding;
    private final Config config;

    /* renamed from: contactsDialogContent$delegate, reason: from kotlin metadata */
    private final Lazy contactsDialogContent;
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
            return YandexAcquireRegistrationFragment.this.getContactsContent();
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<YandexAcquireRegistration.State, Unit> {
        public b(Object obj) {
            super(1, obj, YandexAcquireRegistrationFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireRegistration.State state) {
            YandexAcquireRegistration.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireRegistrationFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<YandexAcquireRegistration.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, YandexAcquireRegistrationFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireRegistration.Effect effect) throws Resources.NotFoundException, UnsupportedEncodingException {
            YandexAcquireRegistration.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireRegistrationFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = YandexAcquireRegistrationFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = YandexAcquireRegistrationFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return YandexAcquireRegistrationFragment.this.viewModelFactory;
        }
    }

    public YandexAcquireRegistrationFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
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
        e eVar = new e();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$special$$inlined$viewModels$default$4
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
        }, eVar);
        this.contactsDialogContent = LazyKt.lazy(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthYandexAcquireNotRegisteredBinding getBinding() {
        AuthYandexAcquireNotRegisteredBinding authYandexAcquireNotRegisteredBinding = this._binding;
        Intrinsics.checkNotNull(authYandexAcquireNotRegisteredBinding);
        return authYandexAcquireNotRegisteredBinding;
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

    private final RuntimeViewModel<YandexAcquireRegistration.State, YandexAcquireRegistration.Action, YandexAcquireRegistration.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupViews() {
        getBinding().faq.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YandexAcquireRegistrationFragment.setupViews$lambda$0(this.f$0, view);
            }
        });
        getBinding().contacts.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YandexAcquireRegistrationFragment.setupViews$lambda$1(this.f$0, view);
            }
        });
        getBinding().actionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YandexAcquireRegistrationFragment.setupViews$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$0(YandexAcquireRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(YandexAcquireRegistration.Action.OpenFaq.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(YandexAcquireRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(YandexAcquireRegistration.Action.OpenContacts.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(YandexAcquireRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(YandexAcquireRegistration.Action.Confirm.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(YandexAcquireRegistration.Effect effect) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (effect instanceof YandexAcquireRegistration.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((YandexAcquireRegistration.Effect.ShowFailure) effect).getFailure()));
            return;
        }
        if (effect instanceof YandexAcquireRegistration.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((YandexAcquireRegistration.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (Intrinsics.areEqual(effect, YandexAcquireRegistration.Effect.ShowContactsDialog.INSTANCE)) {
            YmBottomSheetDialog.Companion companion = YmBottomSheetDialog.INSTANCE;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            YmBottomSheetDialog dialog = companion.getDialog(childFragmentManager, getContactsDialogContent());
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            dialog.show(childFragmentManager2);
            return;
        }
        if (Intrinsics.areEqual(effect, YandexAcquireRegistration.Effect.ShowFAQ.INSTANCE)) {
            ConstraintLayout parent2 = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent2, "parent");
            CoreFragmentExtensions.openLinkInBrowser(this, parent2, this.config.getSupportHelpUrl());
        } else if (Intrinsics.areEqual(effect, YandexAcquireRegistration.Effect.CallPhone.INSTANCE)) {
            CoreFragmentExtensions.callPhone(this, this.config.getSupportPhone());
        } else if (Intrinsics.areEqual(effect, YandexAcquireRegistration.Effect.SendEmail.INSTANCE)) {
            CoreFragmentExtensions.sendEmail$default(this, this.config.getSupportEmail(), null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(YandexAcquireRegistration.State state) {
        PrimaryButtonView primaryButtonView;
        boolean z;
        if (Intrinsics.areEqual(state, YandexAcquireRegistration.State.Content.INSTANCE)) {
            primaryButtonView = getBinding().actionButton;
            z = false;
        } else {
            if (!Intrinsics.areEqual(state, YandexAcquireRegistration.State.Progress.INSTANCE)) {
                return;
            }
            primaryButtonView = getBinding().actionButton;
            z = true;
        }
        primaryButtonView.showProgress(z);
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
        ru.yoomoney.sdk.auth.ui.TopBarDefault appBar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        return appBar;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void handleDialogClose() {
        YmBottomSheetDialog.DialogListener.DefaultImpls.handleDialogClose(this);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void itemClick(Object itemId) {
        RuntimeViewModel<YandexAcquireRegistration.State, YandexAcquireRegistration.Action, YandexAcquireRegistration.Effect> viewModel;
        YandexAcquireRegistration.Action action;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        int iIntValue = ((Integer) itemId).intValue();
        if (iIntValue == 0) {
            viewModel = getViewModel();
            action = YandexAcquireRegistration.Action.OpenEmail.INSTANCE;
        } else {
            if (iIntValue != 1) {
                return;
            }
            viewModel = getViewModel();
            action = YandexAcquireRegistration.Action.OpenPhone.INSTANCE;
        }
        viewModel.handleAction(action);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthYandexAcquireNotRegisteredBinding.inflate(inflater, container, false);
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
        setupViews();
        RuntimeViewModel<YandexAcquireRegistration.State, YandexAcquireRegistration.Action, YandexAcquireRegistration.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
    }
}
