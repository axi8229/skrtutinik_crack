package ru.yoomoney.sdk.auth.select.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.select.adapter.SelectAccountItem;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/SelectAccountViewHolder;", "T", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "(Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItem;)V", "Lru/yoomoney/sdk/auth/select/adapter/AccountHolder;", "Lru/yoomoney/sdk/auth/select/adapter/HeaderHolder;", "Lru/yoomoney/sdk/auth/select/adapter/NewAccountHolder;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SelectAccountViewHolder<T extends SelectAccountItem> extends RecyclerView.ViewHolder {
    private SelectAccountViewHolder(View view) {
        super(view);
    }

    public abstract void bind(T item);

    public /* synthetic */ SelectAccountViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
