package ru.yoomoney.sdk.kassa.payments.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$style;
import ru.yoomoney.sdk.kassa.payments.di.a;
import ru.yoomoney.sdk.kassa.payments.extensions.l;
import ru.yoomoney.sdk.kassa.payments.metrics.N;
import ru.yoomoney.sdk.kassa.payments.metrics.j0;
import ru.yoomoney.sdk.kassa.payments.payment.c;
import ru.yoomoney.sdk.kassa.payments.ui.model.StartScreenData;
import ru.yoomoney.sdk.kassa.payments.ui.view.BackPressedAppCompatDialog;
import ru.yoomoney.sdk.kassa.payments.ui.view.BackPressedBottomSheetDialog;
import ru.yoomoney.sdk.kassa.payments.ui.view.WithBackPressedListener;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/MainDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lru/yoomoney/sdk/kassa/payments/metrics/N;", "sessionReporter", "Lru/yoomoney/sdk/kassa/payments/metrics/N;", "getSessionReporter", "()Lru/yoomoney/sdk/kassa/payments/metrics/N;", "setSessionReporter", "(Lru/yoomoney/sdk/kassa/payments/metrics/N;)V", "Lru/yoomoney/sdk/kassa/payments/navigation/c;", "router", "Lru/yoomoney/sdk/kassa/payments/navigation/c;", "getRouter", "()Lru/yoomoney/sdk/kassa/payments/navigation/c;", "setRouter", "(Lru/yoomoney/sdk/kassa/payments/navigation/c;)V", "Lru/yoomoney/sdk/kassa/payments/payment/c;", "loadedPaymentOptionListRepository", "Lru/yoomoney/sdk/kassa/payments/payment/c;", "getLoadedPaymentOptionListRepository", "()Lru/yoomoney/sdk/kassa/payments/payment/c;", "setLoadedPaymentOptionListRepository", "(Lru/yoomoney/sdk/kassa/payments/payment/c;)V", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "startScreenData$delegate", "Lkotlin/Lazy;", "getStartScreenData", "()Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "startScreenData", "<init>", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class MainDialogFragment extends BottomSheetDialogFragment {
    private static final String START_SCREEN_DATA_INFO = "ru.yoomoney.sdk.kassa.payments.ui.START_SCREEN_DATA_INFO";
    public c loadedPaymentOptionListRepository;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    public ru.yoomoney.sdk.kassa.payments.navigation.c router;
    public N sessionReporter;

    /* renamed from: startScreenData$delegate, reason: from kotlin metadata */
    private final Lazy startScreenData = LazyKt.lazy(new Function0<StartScreenData>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment$startScreenData$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final StartScreenData invoke() {
            Bundle arguments = this.this$0.getArguments();
            StartScreenData startScreenData = arguments != null ? (StartScreenData) arguments.getParcelable("ru.yoomoney.sdk.kassa.payments.ui.START_SCREEN_DATA_INFO") : null;
            if (startScreenData != null) {
                return startScreenData;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    });

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/MainDialogFragment$Companion;", "", "()V", "START_SCREEN_DATA_INFO", "", "createFragment", "Lru/yoomoney/sdk/kassa/payments/ui/MainDialogFragment;", "startScreenData", "Lru/yoomoney/sdk/kassa/payments/ui/model/StartScreenData;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainDialogFragment createFragment(StartScreenData startScreenData) {
            Intrinsics.checkNotNullParameter(startScreenData, "startScreenData");
            MainDialogFragment mainDialogFragment = new MainDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(MainDialogFragment.START_SCREEN_DATA_INFO, startScreenData);
            mainDialogFragment.setArguments(bundle);
            return mainDialogFragment;
        }
    }

    public MainDialogFragment() {
        setStyle(2, R$style.ym_MainDialogTheme);
    }

    private final StartScreenData getStartScreenData() {
        return (StartScreenData) this.startScreenData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(MainDialogFragment this$0, DialogInterface dialogInterface) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.getDialog();
        if (dialog == null || (viewFindViewById = dialog.findViewById(R$id.design_bottom_sheet)) == null) {
            return;
        }
        viewFindViewById.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(MainDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Dialog dialog = this$0.getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog != null) {
            View viewFindViewById = bottomSheetDialog.findViewById(R$id.design_bottom_sheet);
            Intrinsics.checkNotNull(viewFindViewById);
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((FrameLayout) viewFindViewById);
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setHideable(true);
            bottomSheetBehaviorFrom.setPeekHeight(0);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this$0.onGlobalLayoutListener);
        }
    }

    public final c getLoadedPaymentOptionListRepository() {
        c cVar = this.loadedPaymentOptionListRepository;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadedPaymentOptionListRepository");
        return null;
    }

    public final ru.yoomoney.sdk.kassa.payments.navigation.c getRouter() {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.router;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("router");
        return null;
    }

    public final N getSessionReporter() {
        N n = this.sessionReporter;
        if (n != null) {
            return n;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionReporter");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.c cVar = a.a;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
            cVar = null;
        }
        MainDialogFragment_MembersInjector.injectSessionReporter(this, (N) cVar.f.get());
        MainDialogFragment_MembersInjector.injectRouter(this, (ru.yoomoney.sdk.kassa.payments.navigation.c) cVar.h.get());
        MainDialogFragment_MembersInjector.injectLoadedPaymentOptionListRepository(this, (c) cVar.j.get());
        ru.yoomoney.sdk.kassa.payments.navigation.a aVar = (ru.yoomoney.sdk.kassa.payments.navigation.a) getRouter();
        aVar.getClass();
        Intrinsics.checkNotNullParameter(this, "fragment");
        aVar.b = getChildFragmentManager();
        aVar.c = requireActivity();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog backPressedBottomSheetDialog;
        Window window;
        int i;
        Context contextRequireContext = requireContext();
        if (ContextExtensionsKt.isTablet(this)) {
            Intrinsics.checkNotNull(contextRequireContext);
            backPressedBottomSheetDialog = new BackPressedAppCompatDialog(contextRequireContext, getTheme());
            window = backPressedBottomSheetDialog.getWindow();
            if (window != null) {
                i = 32;
                window.setSoftInputMode(i);
            }
        } else {
            Intrinsics.checkNotNull(contextRequireContext);
            backPressedBottomSheetDialog = new BackPressedBottomSheetDialog(contextRequireContext, getTheme());
            window = backPressedBottomSheetDialog.getWindow();
            if (window != null) {
                i = 19;
                window.setSoftInputMode(i);
            }
        }
        return backPressedBottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R$layout.ym_fragment_bottom_sheet, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyEvent.Callback dialog = getDialog();
        WithBackPressedListener withBackPressedListener = dialog instanceof WithBackPressedListener ? (WithBackPressedListener) dialog : null;
        if (withBackPressedListener != null) {
            withBackPressedListener.setOnBackPressed(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        ru.yoomoney.sdk.kassa.payments.navigation.a aVar = (ru.yoomoney.sdk.kassa.payments.navigation.a) getRouter();
        aVar.b = null;
        aVar.c = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View view = getView();
        if (view != null) {
            l.a(view);
        }
        super.onDismiss(dialog);
        if (isStateSaved() || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ((j0) getSessionReporter()).a.pauseSession();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((j0) getSessionReporter()).a.resumeSession();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(final android.view.View r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void setLoadedPaymentOptionListRepository(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.loadedPaymentOptionListRepository = cVar;
    }

    public final void setRouter(ru.yoomoney.sdk.kassa.payments.navigation.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.router = cVar;
    }

    public final void setSessionReporter(N n) {
        Intrinsics.checkNotNullParameter(n, "<set-?>");
        this.sessionReporter = n;
    }
}
