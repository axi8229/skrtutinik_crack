package npi.spay;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.vc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1989vc extends RecyclerView.Adapter {
    public C1804o1 a;

    public C1989vc(Dk... adapters) {
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        this.a = new C1804o1(ArraysKt.toList(adapters));
    }

    public final void a(List data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List adapters = this.a.a;
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        Intrinsics.checkNotNullParameter(data, "data");
        C1804o1 c1804o1 = new C1804o1(adapters, data);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new R4(this.a, c1804o1));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(diffCallback)");
        Intrinsics.checkNotNullParameter(c1804o1, "<set-?>");
        this.a = c1804o1;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return this.a.a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        C1804o1 c1804o1 = this.a;
        Dk dk = (Dk) c1804o1.a.get(c1804o1.a(i));
        List items = this.a.b;
        dk.getClass();
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(items, "items");
        ViewBinding viewBinding = ((Ck) holder).a;
        Object obj = items.get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of spay.sdk.presentation.base.ViewBindingDelegateAdapter");
        dk.a(viewBinding, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Dk dk = (Dk) this.a.a.get(i);
        dk.getClass();
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Function3 function3 = dk.a;
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        ViewBinding viewBinding = (ViewBinding) function3.invoke(layoutInflater, parent, Boolean.FALSE);
        Intrinsics.checkNotNullParameter(viewBinding, "<this>");
        return new Ck(viewBinding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        C1804o1 c1804o1 = this.a;
        ((Dk) c1804o1.a.get(holder.getItemViewType())).getClass();
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(((Ck) holder).a, "<this>");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        C1804o1 c1804o1 = this.a;
        ((Dk) c1804o1.a.get(holder.getItemViewType())).getClass();
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(((Ck) holder).a, "<this>");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        C1804o1 c1804o1 = this.a;
        ((Dk) c1804o1.a.get(holder.getItemViewType())).getClass();
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(((Ck) holder).a, "<this>");
    }
}
