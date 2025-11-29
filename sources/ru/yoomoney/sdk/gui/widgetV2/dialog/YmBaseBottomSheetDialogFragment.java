package ru.yoomoney.sdk.gui.widgetV2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;

/* compiled from: YmBaseBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u001aJ=\u0010\u001e\u001a\u00020\u00062\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00060\u001b2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onDetach", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "Lkotlin/Function1;", "", "onShow", "attachListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Lru/yoomoney/sdk/gui/widgetV2/dialog/DialogVisibleListener;", "visibleListener", "Ljava/util/List;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class YmBaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    private List<DialogVisibleListener> visibleListener = new ArrayList();

    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container);

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof DialogVisibleListener) {
            this.visibleListener.add(context);
        } else if (getParentFragment() instanceof DialogVisibleListener) {
            List<DialogVisibleListener> list = this.visibleListener;
            LifecycleOwner parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener");
            list.add((DialogVisibleListener) parentFragment);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.ym_gui_base_bottom_sheet, container, false);
        ((ViewGroup) viewInflate.findViewById(R$id.base_container)).addView(onCreateView(inflater, container));
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    YmBaseBottomSheetDialogFragment.onViewCreated$lambda$2(this.f$0, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(YmBaseBottomSheetDialogFragment this$0, DialogInterface dialogInterface) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.getDialog();
        if (dialog == null || (viewFindViewById = dialog.findViewById(R$id.design_bottom_sheet)) == null) {
            return;
        }
        viewFindViewById.setBackground(null);
        Iterator<T> it = this$0.visibleListener.iterator();
        while (it.hasNext()) {
            ((DialogVisibleListener) it.next()).onShow(this$0.getTag());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Iterator<T> it = this.visibleListener.iterator();
        while (it.hasNext()) {
            ((DialogVisibleListener) it.next()).onDismiss(getTag());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.visibleListener.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void attachListener$default(YmBaseBottomSheetDialogFragment ymBaseBottomSheetDialogFragment, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachListener");
        }
        if ((i & 1) != 0) {
            function1 = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment.attachListener.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function12 = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment.attachListener.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            };
        }
        ymBaseBottomSheetDialogFragment.attachListener(function1, function12);
    }

    public final void attachListener(final Function1<? super String, Unit> onShow, final Function1<? super String, Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(onShow, "onShow");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.visibleListener.add(new DialogVisibleListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment$attachListener$listener$1
            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener
            public void onShow(String tag) {
                onShow.invoke(tag);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener
            public void onDismiss(String tag) {
                onDismiss.invoke(tag);
            }
        });
    }
}
