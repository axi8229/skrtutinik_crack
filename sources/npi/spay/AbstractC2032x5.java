package npi.spay;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1810o7;
import ru.yoomoney.sdk.kassa.payments.R$style;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnpi/spay/x5;", "Lnpi/spay/o7;", "VM", "Landroidx/viewbinding/ViewBinding;", "B", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.x5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2032x5<VM extends AbstractC1810o7, B extends ViewBinding> extends BottomSheetDialogFragment {
    public Ql a;
    public AbstractC1810o7 b;
    public BottomSheetBehavior c;
    public final int d = 3;
    public ViewBinding e;

    public ViewBinding a() {
        return null;
    }

    public final AbstractC1810o7 b() {
        AbstractC1810o7 abstractC1810o7 = this.b;
        if (abstractC1810o7 != null) {
            return abstractC1810o7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public abstract void c();

    public void d() {
    }

    public void e() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R$style.SpayBaseBottomSheetDialog);
        if (getArguments() == null) {
            setArguments(new Bundle());
        }
        Ql ql = this.a;
        if (ql == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
            ql = null;
        }
        AbstractC1810o7 abstractC1810o7 = (AbstractC1810o7) new ViewModelProvider(this, ql).get(A2.class);
        Intrinsics.checkNotNullParameter(abstractC1810o7, "<set-?>");
        this.b = abstractC1810o7;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        AbstractC1810o7 abstractC1810o7B = b();
        C1982v5 action = new C1982v5(this);
        abstractC1810o7B.getClass();
        Intrinsics.checkNotNullParameter(action, "action");
        abstractC1810o7B.c = action;
        C2007w5 action2 = new C2007w5(this);
        Intrinsics.checkNotNullParameter(action2, "action");
        abstractC1810o7B.d = action2;
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewBinding viewBindingA = a();
        this.e = viewBindingA;
        if (viewBindingA == null) {
            throw C2040xd.a;
        }
        ConstraintLayout constraintLayout = ((Dd) viewBindingA).a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.root");
        d();
        return constraintLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        this.c = bottomSheetDialog != null ? bottomSheetDialog.getBehavior() : null;
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: npi.spay.x5$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    AbstractC2032x5.a(this.f$0, dialogInterface);
                }
            });
        }
        e();
    }

    public static final void a(AbstractC2032x5 this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomSheetBehavior bottomSheetBehavior = this$0.c;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(this$0.d);
        }
    }
}
