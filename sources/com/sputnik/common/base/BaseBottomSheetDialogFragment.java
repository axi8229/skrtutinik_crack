package com.sputnik.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.R$id;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B)\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R.\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Landroidx/viewbinding/ViewBinding;", "T", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/sputnik/common/base/IBaseMethods;", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "inflater", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "()V", "Lkotlin/jvm/functions/Function3;", "_binding", "Landroidx/viewbinding/ViewBinding;", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "binding", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseBottomSheetDialogFragment<T extends ViewBinding> extends BottomSheetDialogFragment implements IBaseMethods {
    private ViewBinding _binding;
    private final Function3<LayoutInflater, ViewGroup, Boolean, T> inflater;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseBottomSheetDialogFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.inflater = inflater;
    }

    protected final T getBinding() {
        T t = (T) this._binding;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.sputnik.common.base.BaseBottomSheetDialogFragment");
        return t;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Function3<LayoutInflater, ViewGroup, Boolean, T> function3 = this.inflater;
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        this._binding = function3.invoke(layoutInflater, container, Boolean.FALSE);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sputnik.common.base.BaseBottomSheetDialogFragment.onViewCreated.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) this.getDialog();
                FrameLayout frameLayout = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(R$id.design_bottom_sheet) : null;
                Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
                BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
                bottomSheetBehaviorFrom.setState(3);
                bottomSheetBehaviorFrom.setPeekHeight(0);
                final BaseBottomSheetDialogFragment<T> baseBottomSheetDialogFragment = this;
                bottomSheetBehaviorFrom.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.sputnik.common.base.BaseBottomSheetDialogFragment$onViewCreated$1$onGlobalLayout$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onStateChanged(View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState == 4) {
                            baseBottomSheetDialogFragment.dismiss();
                        }
                    }
                });
            }
        });
        initViews();
        localize();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this._binding = null;
        super.onDestroy();
    }
}
