package ru.yoomoney.sdk.auth.phone.select;

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
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPhoneSelectBinding;
import ru.yoomoney.sdk.auth.phone.select.PhoneSelect;
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

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0016J$\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020;H\u0016J\u001a\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010J\u001a\u00020;H\u0002J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u000205H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u000203H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R!\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R1\u00101\u001a\u0018\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020502j\u0002`68BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0016\u001a\u0004\b7\u00108R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lru/yoomoney/sdk/auth/phone/select/PhoneSelectFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPhoneSelectBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPhoneSelectBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "suggestions", "", "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "getSuggestions", "()Ljava/util/List;", "suggestions$delegate", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Effect;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelectViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "handleDialogClose", "", "itemClick", "itemId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupViews", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneSelectFragment extends BaseFragment implements YmBottomSheetDialog.DialogListener {
    private AuthPhoneSelectBinding _binding;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
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
            OffsetDateTime expireAt = PhoneSelectFragmentArgs.fromBundle(PhoneSelectFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<PhoneSelect.State, Unit> {
        public b(Object obj) {
            super(1, obj, PhoneSelectFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneSelect.State state) {
            PhoneSelect.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneSelectFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<PhoneSelect.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, PhoneSelectFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneSelect.Effect effect) throws Resources.NotFoundException {
            PhoneSelect.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneSelectFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = PhoneSelectFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PhoneSelectFragment.this.getString(R.string.auth_default_error);
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
            String processId = PhoneSelectFragmentArgs.fromBundle(PhoneSelectFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class f extends Lambda implements Function0<ProcessType> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            ProcessType processType = PhoneSelectFragmentArgs.fromBundle(PhoneSelectFragment.this.requireArguments()).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class g extends Lambda implements Function0<List<? extends Suggestion>> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Suggestion> invoke() {
            Suggestion[] suggestions = PhoneSelectFragmentArgs.fromBundle(PhoneSelectFragment.this.requireArguments()).getSuggestions();
            Intrinsics.checkNotNullExpressionValue(suggestions, "getSuggestions(...)");
            return ArraysKt.toList(suggestions);
        }
    }

    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PhoneSelectFragment.this.viewModelFactory;
        }
    }

    public PhoneSelectFragment(ViewModelProvider.Factory viewModelFactory, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        h hVar = new h();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$special$$inlined$viewModels$default$4
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
        }, hVar);
        this.suggestions = LazyKt.lazy(new g());
        this.processId = LazyKt.lazy(new e());
        this.processType = LazyKt.lazy(new f());
        this.expireAt = LazyKt.lazy(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPhoneSelectBinding getBinding() {
        AuthPhoneSelectBinding authPhoneSelectBinding = this._binding;
        Intrinsics.checkNotNull(authPhoneSelectBinding);
        return authPhoneSelectBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
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
    public final RuntimeViewModel<PhoneSelect.State, PhoneSelect.Action, PhoneSelect.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupViews() {
        getBinding().select.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneSelectFragment.setupViews$lambda$0(this.f$0, view);
            }
        });
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneSelectFragment.setupViews$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$0(PhoneSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PhoneSelect.Action.OpenSuggestions.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(PhoneSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new PhoneSelect.Action.CheckExpiration(this$0.getProcessId(), this$0.getExpireAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PhoneSelect.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof PhoneSelect.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((PhoneSelect.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof PhoneSelect.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((PhoneSelect.Effect.ShowFailure) effect).getFailure()));
        } else {
            if (!(effect instanceof PhoneSelect.Effect.ShowExpireDialog)) {
                if (effect instanceof PhoneSelect.Effect.ResetProcess) {
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
            alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment$showEffect$1$1
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
                    this.this$0.getViewModel().handleAction(PhoneSelect.Action.RestartProcess.INSTANCE);
                }
            });
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            alertDialogCreate.show(childFragmentManager2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PhoneSelect.State state) {
        YmBottomSheetDialog.RightElement.Icon icon;
        Unit unit = null;
        if (state instanceof PhoneSelect.State.Content) {
            PhoneSelect.State.Content content = (PhoneSelect.State.Content) state;
            getBinding().select.setValue(content.getSelected().getTitle());
            getBinding().select.setEnabled(true);
            getBinding().action.showProgress(false);
            Failure error = content.getError();
            if (error != null) {
                TextCaption1View error2 = getBinding().error;
                Intrinsics.checkNotNullExpressionValue(error2, "error");
                ViewExtensions.show(error2);
                getBinding().error.setText(getResourceMapper().map(error));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                TextCaption1View error3 = getBinding().error;
                Intrinsics.checkNotNullExpressionValue(error3, "error");
                ViewExtensions.hide(error3);
                return;
            }
            return;
        }
        if (!(state instanceof PhoneSelect.State.Suggestions)) {
            if (state instanceof PhoneSelect.State.Progress) {
                TextCaption1View error4 = getBinding().error;
                Intrinsics.checkNotNullExpressionValue(error4, "error");
                ViewExtensions.hide(error4);
                getBinding().action.showProgress(true);
                getBinding().select.setEnabled(false);
                return;
            }
            return;
        }
        getBinding().select.setEnabled(true);
        getBinding().action.showProgress(false);
        PhoneSelect.State.Suggestions suggestions = (PhoneSelect.State.Suggestions) state;
        List<Suggestion> suggestions2 = suggestions.getSuggestions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(suggestions2, 10));
        for (Suggestion suggestion : suggestions2) {
            String title = suggestion.getTitle();
            if (Intrinsics.areEqual(suggestions.getSelected().getId(), suggestion.getId())) {
                int i = R.drawable.ic_apply_m;
                ColorScheme colorScheme = ColorScheme.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                icon = new YmBottomSheetDialog.RightElement.Icon(i, Integer.valueOf(colorScheme.getAccentColor(contextRequireContext)));
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
        getViewModel().handleAction(PhoneSelect.Action.DialogClosed.INSTANCE);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener
    public void itemClick(Object itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        getViewModel().handleAction(new PhoneSelect.Action.SelectPhone((Suggestion) itemId));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPhoneSelectBinding.inflate(inflater, container, false);
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
        getViewModel().handleAction(new PhoneSelect.Action.InitData(getSuggestions()));
        RuntimeViewModel<PhoneSelect.State, PhoneSelect.Action, PhoneSelect.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
    }
}
