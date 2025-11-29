package ru.yoomoney.sdk.auth.qrAuth.failure;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcherKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.RulesViolationFailure;
import ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureContract;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010%\u001a\u00020$2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020'H\u0002J\u0012\u0010-\u001a\u00020'2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001eH\u0002J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u001cH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R1\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001bj\u0002`\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureFragment;", "Landroidx/fragment/app/Fragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "close", "Landroid/widget/ImageView;", "getClose", "()Landroid/widget/ImageView;", "close$delegate", "Lkotlin/Lazy;", "errorContainer", "Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "getErrorContainer", "()Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "errorContainer$delegate", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "failure$delegate", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "parent$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "mapFailureSubtitle", "", "mapFailureTitle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpClose", "setUpError", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthFailureFragment extends Fragment {

    /* renamed from: close$delegate, reason: from kotlin metadata */
    private final Lazy close;

    /* renamed from: errorContainer$delegate, reason: from kotlin metadata */
    private final Lazy errorContainer;

    /* renamed from: failure$delegate, reason: from kotlin metadata */
    private final Lazy failure;

    /* renamed from: parent$delegate, reason: from kotlin metadata */
    private final Lazy parent;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<ImageView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            View viewFindViewById = QrAuthFailureFragment.this.requireView().findViewById(R.id.close);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
            return (ImageView) viewFindViewById;
        }
    }

    public static final class b extends Lambda implements Function0<EmptyStateLargeView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EmptyStateLargeView invoke() {
            View viewFindViewById = QrAuthFailureFragment.this.requireView().findViewById(R.id.error_container);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.ui.EmptyStateLargeView");
            return (EmptyStateLargeView) viewFindViewById;
        }
    }

    public static final class c extends Lambda implements Function0<Failure> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Failure invoke() {
            Bundle arguments = QrAuthFailureFragment.this.getArguments();
            if (arguments != null) {
                return QrAuthFailureFragmentArgs.fromBundle(arguments).getFailure();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class d extends Lambda implements Function1<OnBackPressedCallback, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OnBackPressedCallback onBackPressedCallback) {
            OnBackPressedCallback addCallback = onBackPressedCallback;
            Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            QrAuthFailureFragment.this.getViewModel().handleAction(QrAuthFailureContract.Action.Close.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<QrAuthFailureContract.State, Unit> {
        public e(Object obj) {
            super(1, obj, QrAuthFailureFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthFailureContract.State state) {
            QrAuthFailureContract.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((QrAuthFailureFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<QrAuthFailureContract.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, QrAuthFailureFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthFailureContract.Effect effect) {
            QrAuthFailureContract.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((QrAuthFailureFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            View parent = QrAuthFailureFragment.this.getParent();
            String string = QrAuthFailureFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<View> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View viewFindViewById = QrAuthFailureFragment.this.requireView().findViewById(R.id.parent);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            QrAuthFailureFragment.this.getViewModel().handleAction(QrAuthFailureContract.Action.RetryScan.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<ViewModelProvider.Factory> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return QrAuthFailureFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrAuthFailureFragment(ViewModelProvider.Factory viewModelFactory) {
        super(R.layout.auth_qr_failure);
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        this.viewModelFactory = viewModelFactory;
        j jVar = new j();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment$special$$inlined$viewModels$default$4
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
        this.failure = LazyKt.lazy(new c());
        this.parent = LazyKt.lazy(new h());
        this.errorContainer = LazyKt.lazy(new b());
        this.close = LazyKt.lazy(new a());
    }

    private final ImageView getClose() {
        return (ImageView) this.close.getValue();
    }

    private final EmptyStateLargeView getErrorContainer() {
        return (EmptyStateLargeView) this.errorContainer.getValue();
    }

    private final Failure getFailure() {
        return (Failure) this.failure.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getParent() {
        return (View) this.parent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<QrAuthFailureContract.State, QrAuthFailureContract.Action, QrAuthFailureContract.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final String mapFailureSubtitle(Failure failure) {
        String string = getString((failure == null || (failure instanceof RulesViolationFailure)) ? R.string.auth_qr_failure_subtitle_refresh : R.string.auth_qr_failure_subtitle_fail);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String mapFailureTitle(Failure failure) {
        String string = getString(failure == null ? R.string.auth_qr_failure_title_canceled : failure instanceof RulesViolationFailure ? R.string.auth_qr_failure_title_time_out : R.string.auth_qr_failure_title_fail);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void setUpClose() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageView close = getClose();
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_close);
        close.setImageDrawable(drawable != null ? DrawableExtensions.tint(drawable, ColorScheme.INSTANCE.getAccentColor(contextRequireContext)) : null);
        getClose().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrAuthFailureFragment.setUpClose$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpClose$lambda$2(QrAuthFailureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(QrAuthFailureContract.Action.Close.INSTANCE);
    }

    private final void setUpError(Failure failure) {
        EmptyStateLargeView errorContainer = getErrorContainer();
        errorContainer.setTitle(mapFailureTitle(failure));
        errorContainer.setSubtitle(mapFailureSubtitle(failure));
        errorContainer.setActionListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(QrAuthFailureContract.Effect effect) {
        FragmentActivity fragmentActivityRequireActivity;
        int i2;
        if (Intrinsics.areEqual(effect, QrAuthFailureContract.Effect.CloseScreen.INSTANCE)) {
            fragmentActivityRequireActivity = requireActivity();
            i2 = 0;
        } else {
            if (!Intrinsics.areEqual(effect, QrAuthFailureContract.Effect.ShowScanScreen.INSTANCE)) {
                return;
            }
            fragmentActivityRequireActivity = requireActivity();
            i2 = 200;
        }
        fragmentActivityRequireActivity.setResult(i2);
        fragmentActivityRequireActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(QrAuthFailureContract.State state) {
        if (state instanceof QrAuthFailureContract.State.Content) {
            setUpError(getFailure());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), this, false, new d(), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUpClose();
        RuntimeViewModel<QrAuthFailureContract.State, QrAuthFailureContract.Action, QrAuthFailureContract.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new e(this), new f(this), new g());
    }
}
