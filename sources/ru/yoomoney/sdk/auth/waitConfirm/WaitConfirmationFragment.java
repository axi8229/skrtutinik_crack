package ru.yoomoney.sdk.auth.waitConfirm;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.threeten.bp.Duration;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.databinding.AuthWaitConfirmationBinding;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.YmCountDownTimer;
import ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmation;
import ru.yoomoney.sdk.auth.waitConfirm.impl.WaitConfirmationViewModelFactory;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.gui.widgetV2.dialog.BottomSheetDialogExtentionsKt;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u0014H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR1\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011j\u0002`\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmationFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthWaitConfirmationBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthWaitConfirmationBinding;", "counter", "Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "initialEstimation", "Lorg/threeten/bp/OffsetDateTime;", "getInitialEstimation", "()Lorg/threeten/bp/OffsetDateTime;", "initialEstimation$delegate", "Lkotlin/Lazy;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmation$State;", "Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmation$Action;", "Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmation$Effect;", "Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmationViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "viewModelFactory", "Lru/yoomoney/sdk/auth/waitConfirm/impl/WaitConfirmationViewModelFactory;", "getViewModelFactory", "()Lru/yoomoney/sdk/auth/waitConfirm/impl/WaitConfirmationViewModelFactory;", "viewModelFactory$delegate", "onCounterFinish", "", "onCounterTick", "millisUntilDone", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showEffect", "effect", "showState", "state", "startTimer", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lorg/threeten/bp/Duration;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WaitConfirmationFragment extends YmBaseBottomSheetDialogFragment {
    private static final String KEY_DATE_TIME = "dateTime";
    private AuthWaitConfirmationBinding _binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = WaitConfirmationFragment.class.getName();

    /* renamed from: initialEstimation$delegate, reason: from kotlin metadata */
    private final Lazy initialEstimation = LazyKt.lazy(new c());
    private final YmCountDownTimer counter = new YmCountDownTimer(new a(this), new b(this));

    /* renamed from: viewModelFactory$delegate, reason: from kotlin metadata */
    private final Lazy viewModelFactory = LazyKt.lazy(new i());

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmationFragment$Companion;", "", "()V", "KEY_DATE_TIME", "", "TAG", "kotlin.jvm.PlatformType", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", WaitConfirmationFragment.KEY_DATE_TIME, "Lorg/threeten/bp/OffsetDateTime;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(FragmentManager manager, OffsetDateTime dateTime) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(dateTime, "dateTime");
            Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(WaitConfirmationFragment.TAG);
            WaitConfirmationFragment waitConfirmationFragment = fragmentFindFragmentByTag instanceof WaitConfirmationFragment ? (WaitConfirmationFragment) fragmentFindFragmentByTag : null;
            if (waitConfirmationFragment == null) {
                waitConfirmationFragment = new WaitConfirmationFragment();
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(WaitConfirmationFragment.KEY_DATE_TIME, dateTime);
            waitConfirmationFragment.setArguments(bundle);
            waitConfirmationFragment.show(manager, WaitConfirmationFragment.TAG);
        }
    }

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public a(Object obj) {
            super(1, obj, WaitConfirmationFragment.class, "onCounterTick", "onCounterTick(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Long l) {
            ((WaitConfirmationFragment) this.receiver).onCounterTick(l.longValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, WaitConfirmationFragment.class, "onCounterFinish", "onCounterFinish()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((WaitConfirmationFragment) this.receiver).onCounterFinish();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<OffsetDateTime> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            Bundle arguments = WaitConfirmationFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable(WaitConfirmationFragment.KEY_DATE_TIME) : null;
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type org.threeten.bp.OffsetDateTime");
            return (OffsetDateTime) serializable;
        }
    }

    public static final class d extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View a;
        public final /* synthetic */ WaitConfirmationFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WaitConfirmationFragment waitConfirmationFragment, View view) {
            super(1);
            this.a = view;
            this.b = waitConfirmationFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) throws Resources.NotFoundException {
            int i = this.a.getResources().getDisplayMetrics().heightPixels;
            Context context = this.a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            final int iCoerceAtMost = RangesKt.coerceAtMost(this.a.getMeasuredHeight(), i - GuiContextExtensions.getStatusBarHeight(context));
            BottomSheetDialogExtentionsKt.getBehavior(this.b).setPeekHeight(iCoerceAtMost);
            Resources resources = this.b.getResources();
            int i2 = R.dimen.ym_spaceM;
            final float measuredHeight = ((iCoerceAtMost - this.b.getBinding().confirmation.getMeasuredHeight()) - resources.getDimension(i2)) - this.b.getResources().getDimension(i2);
            this.b.getBinding().confirmation.setTranslationY(measuredHeight);
            final View view = this.a;
            final WaitConfirmationFragment waitConfirmationFragment = this.b;
            BottomSheetDialogExtentionsKt.getBehavior(this.b).addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$onViewCreated$2$callback$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    int height = view.getHeight() - iCoerceAtMost;
                    if (slideOffset >= 0.0f) {
                        waitConfirmationFragment.getBinding().confirmation.setTranslationY((slideOffset * height) + measuredHeight);
                    }
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(View bottomSheet, int newState) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }
            });
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<WaitConfirmation.State, Unit> {
        public e(Object obj) {
            super(1, obj, WaitConfirmationFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmation$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(WaitConfirmation.State state) {
            WaitConfirmation.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WaitConfirmationFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<WaitConfirmation.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, WaitConfirmationFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/waitConfirm/WaitConfirmation$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(WaitConfirmation.Effect effect) {
            WaitConfirmation.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WaitConfirmationFragment) this.receiver).showEffect(p0);
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
            FrameLayout root = WaitConfirmationFragment.this.getBinding().root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            String string = WaitConfirmationFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(root, string);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return WaitConfirmationFragment.this.getViewModelFactory();
        }
    }

    public static final class i extends Lambda implements Function0<WaitConfirmationViewModelFactory> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final WaitConfirmationViewModelFactory invoke() {
            Duration durationBetween = Duration.between(OffsetDateTime.now(), WaitConfirmationFragment.this.getInitialEstimation());
            Intrinsics.checkNotNull(durationBetween);
            return new WaitConfirmationViewModelFactory(durationBetween);
        }
    }

    public WaitConfirmationFragment() {
        h hVar = new h();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$special$$inlined$viewModels$default$4
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthWaitConfirmationBinding getBinding() {
        AuthWaitConfirmationBinding authWaitConfirmationBinding = this._binding;
        Intrinsics.checkNotNull(authWaitConfirmationBinding);
        return authWaitConfirmationBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OffsetDateTime getInitialEstimation() {
        return (OffsetDateTime) this.initialEstimation.getValue();
    }

    private final RuntimeViewModel<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WaitConfirmationViewModelFactory getViewModelFactory() {
        return (WaitConfirmationViewModelFactory) this.viewModelFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCounterFinish() {
        getViewModel().handleAction(WaitConfirmation.Action.StopTimer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCounterTick(long millisUntilDone) {
        long j = millisUntilDone / 1000;
        long j2 = 60;
        long j3 = j / j2;
        long j4 = j % j2;
        String string = j3 != 0 ? getString(R.string.auth_wait_confirmation_timer_minutes_seconds, Long.valueOf(j3), Long.valueOf(j4)) : getString(R.string.auth_wait_confirmation_timer_seconds, Long.valueOf(j4));
        Intrinsics.checkNotNull(string);
        getBinding().timer.setText(getString(R.string.auth_wait_confirmation_timer, string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(WaitConfirmationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(WaitConfirmation.Effect effect) {
        if (effect instanceof WaitConfirmation.Effect.Close) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(WaitConfirmation.State state) {
        if (state instanceof WaitConfirmation.State.Content) {
            startTimer(((WaitConfirmation.State.Content) state).getDuration());
        }
    }

    private final void startTimer(Duration duration) {
        YmCountDownTimer ymCountDownTimer = this.counter;
        long millis = duration.toMillis();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        YmCountDownTimer.startTimer$default(ymCountDownTimer, millis, LifecycleKt.getCoroutineScope(lifecycle), 0L, null, 12, null);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthWaitConfirmationBinding.inflate(inflater, container, false);
        FrameLayout root = getBinding().root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().confirmation.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WaitConfirmationFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        YmBaseBottomSheetDialogFragment.attachListener$default(this, new d(this, view), null, 2, null);
        RuntimeViewModel<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new e(this), new f(this), new g());
    }
}
