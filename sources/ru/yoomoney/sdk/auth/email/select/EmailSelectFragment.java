package ru.yoomoney.sdk.auth.email.select;

import android.content.Context;
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
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthSelectEmailBinding;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020EH\u0016J$\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020AH\u0016J\u001a\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020G2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020;H\u0002J\u0010\u0010S\u001a\u00020A2\u0006\u0010T\u001a\u000209H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b%\u0010&R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R)\u0010,\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010.0.0-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R1\u00107\u001a\u0018\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;08j\u0002`<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0018\u001a\u0004\b=\u0010>R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelectFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthSelectEmailBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthSelectEmailBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "phone", "", "getPhone", "()Ljava/lang/String;", "phone$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "suggestions", "", "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "kotlin.jvm.PlatformType", "getSuggestions", "()Ljava/util/List;", "suggestions$delegate", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "Lru/yoomoney/sdk/auth/email/select/EmailSelectViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "handleDialogClose", "", "initViews", "itemClick", "itemId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailSelectFragment extends BaseFragment implements YmBottomSheetDialog.DialogListener {
    private AuthSelectEmailBinding _binding;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final Router router;

    /* renamed from: suggestions$delegate, reason: from kotlin metadata */
    private final Lazy suggestions;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = EmailSelectFragmentArgs.fromBundle(EmailSelectFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<EmailSelect.State, Unit> {
        public b(Object obj) {
            super(1, obj, EmailSelectFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailSelect.State state) {
            EmailSelect.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailSelectFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<EmailSelect.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, EmailSelectFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailSelect.Effect effect) throws Resources.NotFoundException {
            EmailSelect.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailSelectFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = EmailSelectFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = EmailSelectFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String phone = EmailSelectFragment.this.resultData.getPhone();
            return phone == null ? "" : phone;
        }
    }

    public static final class f extends Lambda implements Function0<String> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = EmailSelectFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = EmailSelectFragmentArgs.fromBundle(arguments).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class g extends Lambda implements Function0<ProcessType> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = EmailSelectFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = EmailSelectFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class h extends Lambda implements Function1<Bundle, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            it.putString(Scopes.EMAIL, String.valueOf(EmailSelectFragment.this.getBinding().selector.getValue()));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function0<List<? extends Suggestion>> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Suggestion> invoke() {
            Bundle arguments = EmailSelectFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Suggestion[] suggestions = EmailSelectFragmentArgs.fromBundle(arguments).getSuggestions();
            Intrinsics.checkNotNullExpressionValue(suggestions, "getSuggestions(...)");
            return ArraysKt.toList(suggestions);
        }
    }

    public static final class j extends Lambda implements Function0<ViewModelProvider.Factory> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return EmailSelectFragment.this.viewModelFactory;
        }
    }

    public EmailSelectFragment(ViewModelProvider.Factory viewModelFactory, ResultData resultData, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.resultData = resultData;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        j jVar = new j();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$special$$inlined$viewModels$default$4
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
        }, jVar);
        this.phone = LazyKt.lazy(new e());
        this.processId = LazyKt.lazy(new f());
        this.processType = LazyKt.lazy(new g());
        this.expireAt = LazyKt.lazy(new a());
        this.suggestions = LazyKt.lazy(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthSelectEmailBinding getBinding() {
        AuthSelectEmailBinding authSelectEmailBinding = this._binding;
        Intrinsics.checkNotNull(authSelectEmailBinding);
        return authSelectEmailBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final String getPhone() {
        return (String) this.phone.getValue();
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final List<Suggestion> getSuggestions() {
        return (List) this.suggestions.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<EmailSelect.State, EmailSelect.Action, EmailSelect.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initViews() {
        getBinding().subtitle.setText(getString(R.string.auth_select_email_screen_subtitle, getPhone()));
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailSelectFragment.initViews$lambda$0(this.f$0, view);
            }
        });
        getBinding().selector.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailSelectFragment.initViews$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(EmailSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailSelect.Action.CheckExpiration(this$0.getProcessId(), this$0.getExpireAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(EmailSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(EmailSelect.Action.OpenEmailSelectorDialog.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(EmailSelect.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof EmailSelect.Effect.ShowNextStep) {
            navigate$auth_release(((EmailSelect.Effect.ShowNextStep) effect).getProcess(), new h());
            return;
        }
        if (effect instanceof EmailSelect.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((EmailSelect.Effect.ShowFailure) effect).getFailure()));
        } else {
            if (!(effect instanceof EmailSelect.Effect.ShowExpireDialog)) {
                if (effect instanceof EmailSelect.Effect.ResetProcess) {
                    FragmentKt.findNavController(this).navigate(getRouter().reset());
                    return;
                }
                return;
            }
            YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
            AlertDialog.Companion companion = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
            alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.email.select.EmailSelectFragment$showEffect$2$1
                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onDismiss() {
                    YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
                }

                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onNegativeClick() {
                    YmAlertDialog.DialogListener.DefaultImpls.onNegativeClick(this);
                }

                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onPositiveClick() {
                    this.this$0.getViewModel().handleAction(EmailSelect.Action.RestartProcess.INSTANCE);
                }
            });
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            alertDialogCreate.show(childFragmentManager2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(EmailSelect.State state) {
        YmBottomSheetDialog.RightElement.Icon icon;
        if (state instanceof EmailSelect.State.Content) {
            EmailSelect.State.Content content = (EmailSelect.State.Content) state;
            getBinding().selector.setValue(content.getSelectedSuggestion().getTitle());
            getBinding().selector.setClickable(true);
            TextCaption1View error = getBinding().error;
            Intrinsics.checkNotNullExpressionValue(error, "error");
            error.setVisibility(content.getError() != null ? 0 : 8);
            TextCaption1View textCaption1View = getBinding().error;
            ProcessError error2 = content.getError();
            textCaption1View.setText(error2 != null ? getResourceMapper().map(ProcessErrorExtensionsKt.toFailure(error2)) : null);
            getBinding().action.showProgress(false);
            return;
        }
        if (!(state instanceof EmailSelect.State.SelectionDialog)) {
            if (state instanceof EmailSelect.State.Progress) {
                getBinding().selector.setClickable(false);
                TextCaption1View error3 = getBinding().error;
                Intrinsics.checkNotNullExpressionValue(error3, "error");
                ViewExtensions.hide(error3);
                getBinding().action.showProgress(true);
                return;
            }
            return;
        }
        EmailSelect.State.SelectionDialog selectionDialog = (EmailSelect.State.SelectionDialog) state;
        List<Suggestion> suggestions = selectionDialog.getSuggestions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(suggestions, 10));
        for (Suggestion suggestion : suggestions) {
            String title = suggestion.getTitle();
            if (Intrinsics.areEqual(selectionDialog.getSelectedSuggestion().getId(), suggestion.getId())) {
                int i2 = R.drawable.ic_apply_m;
                ColorScheme colorScheme = ColorScheme.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                icon = new YmBottomSheetDialog.RightElement.Icon(i2, Integer.valueOf(colorScheme.getAccentColor(contextRequireContext)));
            } else {
                icon = null;
            }
            arrayList.add(new YmBottomSheetDialog.ContentItem.MenuItem(suggestion, title, null, icon, false, false, 52, null));
        }
        YmBottomSheetDialog.Content content2 = new YmBottomSheetDialog.Content(arrayList);
        YmBottomSheetDialog.Companion companion = YmBottomSheetDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        YmBottomSheetDialog dialog = companion.getDialog(childFragmentManager, content2);
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        dialog.show(childFragmentManager2);
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
        getViewModel().handleAction(EmailSelect.Action.CloseSelectorDialog.INSTANCE);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void itemClick(Object itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        getViewModel().handleAction(new EmailSelect.Action.SelectEmail((Suggestion) itemId));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthSelectEmailBinding.inflate(inflater, container, false);
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
        initViews();
        RuntimeViewModel<EmailSelect.State, EmailSelect.Action, EmailSelect.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
        getViewModel().handleAction(new EmailSelect.Action.InitData(getSuggestions()));
    }
}
