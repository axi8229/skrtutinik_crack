package npi.spay;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.internal.Preconditions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$style;
import spay.sdk.b;
import spay.sdk.domain.model.BiometricSuggestionModel;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/mo;", "Lnpi/spay/x5;", "Lnpi/spay/A2;", "Lnpi/spay/Dd;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class mo extends AbstractC2032x5<A2, Dd> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public C2009w7 f;

    public static final void b(mo this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Ec) ((A2) this$0.b()).g).a(true);
        ((Jh) ((A2) this$0.b()).f).a(Fn.a);
    }

    @Override // npi.spay.AbstractC2032x5
    public final ViewBinding a() {
        View viewFindChildViewById;
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_bottom_sheet_sdk, (ViewGroup) null, false);
        int i = R$id.sbss_aciv_background;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatImageView != null) {
            i = R$id.sbss_fcv_content;
            if (((FragmentContainerView) ViewBindings.findChildViewById(viewInflate, i)) != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i = R$id.sbss_include_indicator))) != null) {
                Dd dd = new Dd((ConstraintLayout) viewInflate, appCompatImageView);
                Intrinsics.checkNotNullExpressionValue(dd, "inflate(layoutInflater)");
                return dd;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.AbstractC2032x5
    public final void c() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.c0.get();
            pj.a.getClass();
            this.f = (C2009w7) Preconditions.checkNotNullFromProvides(new C2009w7());
            pj.b.getClass();
        }
    }

    @Override // npi.spay.AbstractC2032x5
    public final void d() {
        StateFlow stateFlow = ((A2) b()).q;
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new lo(this, state, stateFlow, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new fo(this, state, ((A2) b()).r, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new io(this, state, FlowKt.filterNotNull(((A2) b()).s), null, this), 3, null);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        ((A2) b()).a(C1883r6.a);
        super.dismiss();
    }

    @Override // npi.spay.AbstractC2032x5
    public final void e() {
        getChildFragmentManager().beginTransaction().add(R$id.sbss_fcv_content, new D8()).addToBackStack("EmptyFragment").commit();
    }

    @Override // npi.spay.AbstractC2032x5, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // npi.spay.AbstractC2032x5, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: npi.spay.mo$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                mo.a(dialogOnCreateDialog, this, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        ((A2) b()).a(C1883r6.a);
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    public static final void a(Dialog dialog, mo this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(dialog.findViewById(com.google.android.material.R$id.design_bottom_sheet));
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from<View>(\n            …et)\n                    )");
        this$0.getClass();
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setHideable(true);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
    }

    public final void a(Z7 z7, String str) {
        if (Intrinsics.areEqual(getChildFragmentManager().getFragments().get(0).getTag(), str)) {
            return;
        }
        View viewRequireView = getChildFragmentManager().getFragments().get(0).requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "childFragmentManager.fragments[0].requireView()");
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.addSharedElement(viewRequireView, viewRequireView.getTransitionName());
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        z7.setSharedElementEnterTransition(z7 instanceof C1930t3 ? new Z0(0L) : new Z0(600L));
        fragmentTransactionBeginTransaction.replace(R$id.sbss_fcv_content, z7, str).commit();
    }

    public static final void a(mo this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jh) ((A2) this$0.b()).f).a(Ln.a);
    }

    public static final void a(mo this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Ec) ((A2) this$0.b()).g).a(false);
        ((Jh) ((A2) this$0.b()).f).a(Fn.a);
    }

    public final void a(BiometricSuggestionModel biometricSuggestionModel) {
        new MaterialAlertDialogBuilder(requireActivity(), R$style.Spay_ThemeOverlay_MaterialAlertDialog).setTitle((CharSequence) biometricSuggestionModel.getTitle()).setMessage((CharSequence) biometricSuggestionModel.getMessage()).setNegativeButton((CharSequence) biometricSuggestionModel.getNegativeButtonText(), new DialogInterface.OnClickListener() { // from class: npi.spay.mo$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                mo.a(this.f$0, dialogInterface, i);
            }
        }).setPositiveButton((CharSequence) biometricSuggestionModel.getPositiveButtonText(), new DialogInterface.OnClickListener() { // from class: npi.spay.mo$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                mo.b(this.f$0, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: npi.spay.mo$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                mo.a(this.f$0, dialogInterface);
            }
        }).show();
    }
}
