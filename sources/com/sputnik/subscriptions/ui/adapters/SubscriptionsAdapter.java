package com.sputnik.subscriptions.ui.adapters;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import com.sputnik.subscriptions.databinding.ItemSubscriptionBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Lcom/sputnik/subscriptions/ui/adapters/SubscriptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sputnik/subscriptions/ui/adapters/SubscriptionViewHolder;", "", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "list", "Lkotlin/Function1;", "", "onItemClick", "onButtonClick", "", "activeUntilTitle", "buttonText", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sputnik/subscriptions/ui/adapters/SubscriptionViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/sputnik/subscriptions/ui/adapters/SubscriptionViewHolder;I)V", "getItemCount", "()I", "Ljava/util/List;", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "getActiveUntilTitle", "()Ljava/lang/String;", "getButtonText", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionsAdapter extends RecyclerView.Adapter<SubscriptionViewHolder> {
    private final String activeUntilTitle;
    private final String buttonText;
    private final List<BaseSubscription> list;
    private final Function1<BaseSubscription, Unit> onButtonClick;
    private final Function1<BaseSubscription, Unit> onItemClick;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionsAdapter(List<BaseSubscription> list, Function1<? super BaseSubscription, Unit> onItemClick, Function1<? super BaseSubscription, Unit> onButtonClick, String activeUntilTitle, String buttonText) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        Intrinsics.checkNotNullParameter(activeUntilTitle, "activeUntilTitle");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.list = list;
        this.onItemClick = onItemClick;
        this.onButtonClick = onButtonClick;
        this.activeUntilTitle = activeUntilTitle;
        this.buttonText = buttonText;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SubscriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSubscriptionBinding itemSubscriptionBindingInflate = ItemSubscriptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSubscriptionBindingInflate, "inflate(...)");
        return new SubscriptionViewHolder(itemSubscriptionBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SubscriptionViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final BaseSubscription baseSubscription = this.list.get(position);
        final View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.subscriptions.ui.adapters.SubscriptionsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubscriptionsAdapter.onBindViewHolder$lambda$1$lambda$0(baseSubscription, this, view, view2);
            }
        });
        holder.bind(baseSubscription, this.onItemClick, this.onButtonClick, this.activeUntilTitle, this.buttonText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(BaseSubscription item, SubscriptionsAdapter this$0, View this_with, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (item.getType() != SubscriptionTypes.active_subscription) {
            this$0.onItemClick.invoke(item);
            this_with.getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, new TypedValue(), true);
            this_with.setForeground(new ColorDrawable(0));
            return;
        }
        this_with.setEnabled(false);
        ViewKt.disactivate(this_with);
        this_with.setClickable(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }
}
