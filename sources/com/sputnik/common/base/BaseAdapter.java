package com.sputnik.common.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B;\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/base/BaseAdapter;", "T", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/sputnik/common/base/CustomViewHolder;", "layoutId", "", "onItemClicked", "Lkotlin/Function1;", "", "brItem", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(ILkotlin/jvm/functions/Function1;ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewHolderCreated", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseAdapter<T> extends ListAdapter<T, CustomViewHolder<T>> {
    private final int brItem;
    private final int layoutId;
    private final Function1<T, Unit> onItemClicked;

    public /* synthetic */ BaseAdapter(int i, Function1 function1, int i2, DiffUtil.ItemCallback itemCallback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? new Function1<T, Unit>() { // from class: com.sputnik.common.base.BaseAdapter.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((AnonymousClass1) obj);
                return Unit.INSTANCE;
            }
        } : function1, i2, itemCallback);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseAdapter(int i, Function1<? super T, Unit> onItemClicked, int i2, DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.layoutId = i;
        this.onItemClicked = onItemClicked;
        this.brItem = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), this.layoutId, parent, false);
        Intrinsics.checkNotNull(viewDataBindingInflate);
        CustomViewHolder<T> customViewHolder = new CustomViewHolder<>(viewDataBindingInflate, this.brItem);
        onViewHolderCreated(customViewHolder, viewDataBindingInflate);
        return customViewHolder;
    }

    private final void onViewHolderCreated(final RecyclerView.ViewHolder viewHolder, ViewDataBinding binding) {
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.base.BaseAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseAdapter.onViewHolderCreated$lambda$1(this.f$0, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$1(BaseAdapter this$0, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        this$0.onItemClicked.invoke(this$0.getItem(viewHolder.getBindingAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<T> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindTo(getItem(position));
    }
}
