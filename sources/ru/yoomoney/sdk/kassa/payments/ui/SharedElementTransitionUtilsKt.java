package ru.yoomoney.sdk.kassa.payments.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0000\u001a\"\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0000\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\r"}, d2 = {"changeHeightWithMobileAnimation", "", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/ViewGroup;", "heightBefore", "", "heightAfter", "changeViewWithAnimation", "changeView", "Lkotlin/Function0;", "changeViewWithMobileAnimation", "resumePostponedTransition", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedElementTransitionUtilsKt {
    public static final void changeHeightWithMobileAnimation(Fragment fragment, ViewGroup view, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (fragment.isResumed() && !ContextExtensionsKt.isTablet(fragment)) {
            AnimateContentChangeKt.getHeightValueAnimator(view, i, i2).start();
        }
    }

    public static final void changeViewWithAnimation(Fragment fragment, ViewGroup view, Function0<Unit> changeView) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(changeView, "changeView");
        if (fragment.isResumed()) {
            AnimateContentChangeKt.animateHeightChange(view, changeView).start();
        } else {
            changeView.invoke();
        }
    }

    public static final void changeViewWithMobileAnimation(Fragment fragment, ViewGroup view, Function0<Unit> changeView) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(changeView, "changeView");
        if (!fragment.isResumed()) {
            changeView.invoke();
        } else {
            if (ContextExtensionsKt.isTablet(fragment)) {
                return;
            }
            AnimateContentChangeKt.animateHeightChange(view, changeView).start();
        }
    }

    public static final void resumePostponedTransition(final Fragment fragment, final ViewGroup view) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt$resumePostponedTransition$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view2.removeOnLayoutChangeListener(this);
                final Fragment fragment2 = fragment;
                final ViewGroup viewGroup = view;
                view2.postDelayed(new Runnable() { // from class: ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt$resumePostponedTransition$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        fragment2.startPostponedEnterTransition();
                        ViewGroup viewGroup2 = viewGroup;
                        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        layoutParams.height = -2;
                        viewGroup2.setLayoutParams(layoutParams);
                    }
                }, 50L);
            }
        });
    }
}
