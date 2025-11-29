package ru.yoomoney.sdk.auth.qrAuth.success;

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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.QrAuthConfig;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccess;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020!H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u0018R1\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001ej\u0002`\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccessFragment;", "Landroidx/fragment/app/Fragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "close", "Landroid/widget/ImageView;", "getClose", "()Landroid/widget/ImageView;", "close$delegate", "Lkotlin/Lazy;", "config", "Lru/yoomoney/sdk/auth/Config;", "getConfig", "()Lru/yoomoney/sdk/auth/Config;", "config$delegate", "content", "Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "getContent", "()Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "content$delegate", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "parent$delegate", "primaryButton", "getPrimaryButton", "primaryButton$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$State;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Action;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Effect;", "Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpClose", "showEffect", "effect", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthSuccessFragment extends Fragment {

    /* renamed from: close$delegate, reason: from kotlin metadata */
    private final Lazy close;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config;

    /* renamed from: content$delegate, reason: from kotlin metadata */
    private final Lazy content;

    /* renamed from: parent$delegate, reason: from kotlin metadata */
    private final Lazy parent;

    /* renamed from: primaryButton$delegate, reason: from kotlin metadata */
    private final Lazy primaryButton;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<ImageView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            View viewFindViewById = QrAuthSuccessFragment.this.requireView().findViewById(R.id.close);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
            return (ImageView) viewFindViewById;
        }
    }

    public static final class b extends Lambda implements Function0<Config> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            return QrAuthSuccessFragmentArgs.fromBundle(QrAuthSuccessFragment.this.requireArguments()).getConfig();
        }
    }

    public static final class c extends Lambda implements Function0<EmptyStateLargeView> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EmptyStateLargeView invoke() {
            View viewFindViewById = QrAuthSuccessFragment.this.requireView().findViewById(R.id.content);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.ui.EmptyStateLargeView");
            return (EmptyStateLargeView) viewFindViewById;
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
            QrAuthSuccessFragment.this.getViewModel().handleAction(QrAuthSuccess.Action.Close.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<QrAuthSuccess.State, Unit> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthSuccess.State state) {
            QrAuthSuccess.State it = state;
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<QrAuthSuccess.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, QrAuthSuccessFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/qrAuth/success/QrAuthSuccess$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthSuccess.Effect effect) {
            QrAuthSuccess.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((QrAuthSuccessFragment) this.receiver).showEffect(p0);
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
            View parent = QrAuthSuccessFragment.this.getParent();
            String string = QrAuthSuccessFragment.this.getString(R.string.auth_default_error);
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
            View viewFindViewById = QrAuthSuccessFragment.this.requireView().findViewById(R.id.parent);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class i extends Lambda implements Function0<View> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View viewFindViewById = QrAuthSuccessFragment.this.requireView().findViewById(R.id.primaryAction);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class j extends Lambda implements Function0<ViewModelProvider.Factory> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return QrAuthSuccessFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrAuthSuccessFragment(ViewModelProvider.Factory viewModelFactory) {
        super(R.layout.auth_qr_success);
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        this.viewModelFactory = viewModelFactory;
        j jVar = new j();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$special$$inlined$viewModels$default$4
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
        this.config = LazyKt.lazy(new b());
        this.parent = LazyKt.lazy(new h());
        this.primaryButton = LazyKt.lazy(new i());
        this.content = LazyKt.lazy(new c());
        this.close = LazyKt.lazy(new a());
    }

    private final ImageView getClose() {
        return (ImageView) this.close.getValue();
    }

    private final Config getConfig() {
        return (Config) this.config.getValue();
    }

    private final EmptyStateLargeView getContent() {
        return (EmptyStateLargeView) this.content.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getParent() {
        return (View) this.parent.getValue();
    }

    private final View getPrimaryButton() {
        return (View) this.primaryButton.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(QrAuthSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(QrAuthSuccess.Action.Close.INSTANCE);
    }

    private final void setUpClose() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageView close = getClose();
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_close);
        close.setImageDrawable(drawable != null ? DrawableExtensions.tint(drawable, ColorScheme.INSTANCE.getAccentColor(contextRequireContext)) : null);
        getClose().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrAuthSuccessFragment.setUpClose$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpClose$lambda$1(QrAuthSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(QrAuthSuccess.Action.Close.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(QrAuthSuccess.Effect effect) {
        if (Intrinsics.areEqual(effect, QrAuthSuccess.Effect.CloseScreen.INSTANCE)) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.setResult(-1);
            fragmentActivityRequireActivity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), this, false, new d(), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EmptyStateLargeView content = getContent();
        QrAuthConfig qrAuthConfig = getConfig().getQrAuthConfig();
        if (qrAuthConfig == null || (string = qrAuthConfig.getAuthQrSuccessSubtitle()) == null) {
            string = getString(R.string.auth_qr_success_subtitle);
        }
        content.setSubtitle(string);
        setUpClose();
        getPrimaryButton().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrAuthSuccessFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        RuntimeViewModel<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, e.a, new f(this), new g());
    }
}
