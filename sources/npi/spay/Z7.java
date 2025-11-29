package npi.spay;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1819og;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnpi/spay/Z7;", "Lnpi/spay/og;", "VM", "Landroidx/viewbinding/ViewBinding;", "B", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public abstract class Z7<VM extends AbstractC1819og, B extends ViewBinding> extends Fragment {
    public Ql a;
    public AbstractC1819og b;
    public ViewBinding c;

    public ViewBinding a() {
        return null;
    }

    public final AbstractC1819og b() {
        AbstractC1819og abstractC1819og = this.b;
        if (abstractC1819og != null) {
            return abstractC1819og;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* renamed from: c */
    public abstract Class getE();

    public void d() {
    }

    public abstract void e();

    public void f() {
    }

    public void g() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        e();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ql ql = this.a;
        if (ql == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
            ql = null;
        }
        AbstractC1819og abstractC1819og = (AbstractC1819og) new ViewModelProvider(this, ql).get(getE());
        Intrinsics.checkNotNullParameter(abstractC1819og, "<set-?>");
        this.b = abstractC1819og;
        b().a(C1645hg.a);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewBinding viewBindingA = a();
        this.c = viewBindingA;
        if (viewBindingA == null) {
            throw C2040xd.a;
        }
        View root = viewBindingA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        f();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b().a(C1669ig.a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        b().a(C1694jg.a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        b().a(C1719kg.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        b().a(C1744lg.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        b().a(C1769mg.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        g();
        d();
    }
}
