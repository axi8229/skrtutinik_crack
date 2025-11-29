package com.sputnik.common.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/base/CustomViewHolder;", "V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "binding", "", "variableId", "<init>", "(Landroidx/databinding/ViewDataBinding;I)V", "item", "", "bindTo", "(Ljava/lang/Object;)V", "Landroidx/databinding/ViewDataBinding;", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "I", "getVariableId", "()I", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomViewHolder<V> extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;
    private final int variableId;

    public final ViewDataBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomViewHolder(ViewDataBinding binding, int i) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.variableId = i;
    }

    public final void bindTo(V item) {
        this.binding.setVariable(this.variableId, item);
        this.binding.executePendingBindings();
    }
}
