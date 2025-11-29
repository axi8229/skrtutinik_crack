package com.sputnik.common.extensions;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.snackbar.Snackbar;
import com.sputnik.common.R$color;
import com.sputnik.common.base.Notify;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a2\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005\u001a2\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u001a\u0010\u0015\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0002¨\u0006\u001d"}, d2 = {"activate", "", "Landroid/view/View;", "addSystemWindowInsetToMargin", "left", "", "top", "right", "bottom", "addSystemWindowInsetToPadding", "toAllSides", "disable", "disactivate", "enable", "getDpFromPx", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "gone", "hideKeyboard", "invisible", "renderNotifications", "Landroid/app/Activity;", "root", "notify", "Lcom/sputnik/common/base/Notify;", "Landroidx/fragment/app/Fragment;", "showKeyboard", "visible", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewKt {
    public static final void hideKeyboard(final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.hideKeyboard$lambda$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideKeyboard$lambda$0(View this_hideKeyboard) {
        Intrinsics.checkNotNullParameter(this_hideKeyboard, "$this_hideKeyboard");
        InputMethodManager inputMethodManager = (InputMethodManager) this_hideKeyboard.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this_hideKeyboard.getApplicationWindowToken(), 0);
        }
    }

    public static final void showKeyboard(final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.showKeyboard$lambda$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showKeyboard$lambda$1(View this_showKeyboard) {
        Intrinsics.checkNotNullParameter(this_showKeyboard, "$this_showKeyboard");
        Object systemService = this_showKeyboard.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this_showKeyboard, 1);
    }

    public static final int getDpFromPx(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (int) TypedValue.applyDimension(1, f, view.getContext().getResources().getDisplayMetrics());
    }

    public static final void visible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void invisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
    }

    public static final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void activate(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setActivated(true);
    }

    public static final void disactivate(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setActivated(false);
    }

    public static final void enable(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(true);
    }

    public static final void disable(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(false);
    }

    public static final void renderNotifications(Fragment fragment, View root, final Notify notify) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(notify, "notify");
        if (notify instanceof Notify.TextMessage) {
            View view = fragment.getView();
            Intrinsics.checkNotNull(view);
            final Snackbar snackbarMake = Snackbar.make(view, notify.getMessage(), 0);
            Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
            SnackbarUtilsKt.setBackgroundColor(snackbarMake, ContextCompat.getColor(fragment.requireContext(), R$color.sputnik_green));
            SnackbarUtilsKt.setGravity(snackbarMake, 49);
            SnackbarUtilsKt.setSystemInsetsMargin(snackbarMake);
            SnackbarUtilsKt.setTextSize(snackbarMake, 14.0f, true);
            snackbarMake.getView().setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ViewKt.renderNotifications$lambda$2(snackbarMake, view2);
                }
            });
            snackbarMake.show();
            return;
        }
        if (notify instanceof Notify.ActionMessage) {
            Snackbar actionTextColor = Snackbar.make(root, notify.getMessage(), 0).setActionTextColor(ContextCompat.getColor(fragment.requireContext(), R$color.sputnik_green));
            Intrinsics.checkNotNullExpressionValue(actionTextColor, "setActionTextColor(...)");
            SnackbarUtilsKt.setSystemInsetsMargin(actionTextColor);
            actionTextColor.setAction(((Notify.ActionMessage) notify).getActionLabel(), new View.OnClickListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ViewKt.renderNotifications$lambda$3(notify, view2);
                }
            });
            actionTextColor.show();
            return;
        }
        if (notify instanceof Notify.ErrorMessage) {
            String message = notify.getMessage();
            FragmentActivity activity = fragment.getActivity();
            View rootView = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            com.sputnik.common.ui.utils.SnackbarUtilsKt.showSnackbarMessage(message, (ViewGroup) rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderNotifications$lambda$2(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderNotifications$lambda$3(Notify notify, View view) {
        Intrinsics.checkNotNullParameter(notify, "$notify");
        ((Notify.ActionMessage) notify).getActionHandler().invoke();
    }

    public static final void renderNotifications(Activity activity, View root, final Notify notify) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(notify, "notify");
        final Snackbar actionTextColor = Snackbar.make(root, notify.getMessage(), 0).setActionTextColor(ContextCompat.getColor(activity, R$color.sputnik_green));
        Intrinsics.checkNotNullExpressionValue(actionTextColor, "setActionTextColor(...)");
        if (!(notify instanceof Notify.TextMessage)) {
            if (notify instanceof Notify.ActionMessage) {
                actionTextColor.setAction(((Notify.ActionMessage) notify).getActionLabel(), new View.OnClickListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewKt.renderNotifications$lambda$4(notify, view);
                    }
                });
            } else if (notify instanceof Notify.ErrorMessage) {
                actionTextColor.setBackgroundTint(ContextCompat.getColor(actionTextColor.getContext(), R.color.transparent));
                actionTextColor.getView().setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewKt.renderNotifications$lambda$7$lambda$5(actionTextColor, view);
                    }
                });
                ViewGroup.LayoutParams layoutParams = actionTextColor.getView().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams) layoutParams).gravity = 48;
                SnackbarUtilsKt.setSystemInsetsMargin(actionTextColor);
                Context context = actionTextColor.getContext();
                int i = R$color.white;
                actionTextColor.setTextColor(ContextCompat.getColor(context, i));
                actionTextColor.setActionTextColor(ContextCompat.getColor(actionTextColor.getContext(), i));
                actionTextColor.setAction(((Notify.ErrorMessage) notify).getErrLabel(), new View.OnClickListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewKt.renderNotifications$lambda$7$lambda$6(notify, view);
                    }
                });
            }
        }
        actionTextColor.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderNotifications$lambda$4(Notify notify, View view) {
        Intrinsics.checkNotNullParameter(notify, "$notify");
        ((Notify.ActionMessage) notify).getActionHandler().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderNotifications$lambda$7$lambda$5(Snackbar this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderNotifications$lambda$7$lambda$6(Notify notify, View view) {
        Intrinsics.checkNotNullParameter(notify, "$notify");
        Function0<Unit> errHandler = ((Notify.ErrorMessage) notify).getErrHandler();
        if (errHandler != null) {
            errHandler.invoke();
        }
    }

    public static final void addSystemWindowInsetToPadding(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        addSystemWindowInsetToPadding(view, z, z, z, z);
    }

    public static /* synthetic */ void addSystemWindowInsetToPadding$default(View view, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        addSystemWindowInsetToPadding(view, z, z2, z3, z4);
    }

    public static final void addSystemWindowInsetToPadding(View view, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(view.getPaddingLeft()), Integer.valueOf(view.getPaddingTop()), Integer.valueOf(view.getPaddingRight()), Integer.valueOf(view.getPaddingBottom())});
        final int iIntValue = ((Number) listListOf.get(0)).intValue();
        final int iIntValue2 = ((Number) listListOf.get(1)).intValue();
        final int iIntValue3 = ((Number) listListOf.get(2)).intValue();
        final int iIntValue4 = ((Number) listListOf.get(3)).intValue();
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ViewKt.addSystemWindowInsetToPadding$lambda$8(iIntValue, z, iIntValue2, z2, iIntValue3, z3, iIntValue4, z4, view2, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat addSystemWindowInsetToPadding$lambda$8(int i, boolean z, int i2, boolean z2, int i3, boolean z3, int i4, boolean z4, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        view.setPadding(i + (z ? insets.getSystemWindowInsetLeft() : 0), i2 + (z2 ? insets.getSystemWindowInsetTop() : 0), i3 + (z3 ? insets.getSystemWindowInsetRight() : 0), i4 + (z4 ? insets.getSystemWindowInsetBottom() : 0));
        return insets;
    }

    public static /* synthetic */ void addSystemWindowInsetToMargin$default(View view, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        addSystemWindowInsetToMargin(view, z, z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat addSystemWindowInsetToMargin$lambda$11(int i, boolean z, int i2, boolean z2, int i3, boolean z3, int i4, boolean z4, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(i + (z ? insets.getSystemWindowInsetLeft() : 0), i2 + (z2 ? insets.getSystemWindowInsetTop() : 0), i3 + (z3 ? insets.getSystemWindowInsetRight() : 0), i4 + (z4 ? insets.getSystemWindowInsetBottom() : 0));
            }
            view.setLayoutParams(layoutParams);
            return insets;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void addSystemWindowInsetToMargin(View view, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        Integer numValueOf = Integer.valueOf(marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        Integer numValueOf2 = Integer.valueOf(marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0);
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
        Integer numValueOf3 = Integer.valueOf(marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0);
        ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, numValueOf2, numValueOf3, Integer.valueOf(marginLayoutParams4 != null ? marginLayoutParams4.bottomMargin : 0)});
        final int iIntValue = ((Number) listListOf.get(0)).intValue();
        final int iIntValue2 = ((Number) listListOf.get(1)).intValue();
        final int iIntValue3 = ((Number) listListOf.get(2)).intValue();
        final int iIntValue4 = ((Number) listListOf.get(3)).intValue();
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.sputnik.common.extensions.ViewKt$$ExternalSyntheticLambda5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ViewKt.addSystemWindowInsetToMargin$lambda$11(iIntValue, z, iIntValue2, z2, iIntValue3, z3, iIntValue4, z4, view2, windowInsetsCompat);
            }
        });
    }
}
