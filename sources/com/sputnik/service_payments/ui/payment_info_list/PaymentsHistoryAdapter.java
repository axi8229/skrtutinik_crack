package com.sputnik.service_payments.ui.payment_info_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.service_payments.databinding.ItemHistoryPaymentBinding;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PaymentsHistoryAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB-\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/sputnik/service_payments/ui/payment_info_list/PaymentsHistoryAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "bottomTitle", "Lkotlin/Function2;", "Landroid/view/View;", "", "onItemClicked", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "viewHolder", "Lcom/sputnik/service_payments/databinding/ItemHistoryPaymentBinding;", "binding", "onViewHolderCreated", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Lcom/sputnik/service_payments/databinding/ItemHistoryPaymentBinding;)V", "holder", "", "position", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function2;", "PaymentHistoryViewHolder", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PaymentsHistoryAdapter extends PagingDataAdapter<PaymentHistory, RecyclerView.ViewHolder> {
    private final String bottomTitle;
    private final Function2<View, PaymentHistory, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentsHistoryAdapter(String str, Function2<? super View, ? super PaymentHistory, Unit> onItemClicked) {
        super((DiffUtil.ItemCallback) new PaymentsHistoryDiffCallback(), (CoroutineDispatcher) null, (CoroutineDispatcher) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.bottomTitle = str;
        this.onItemClicked = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PaymentHistory item = getItem(position);
        if (item != null) {
            PaymentHistoryViewHolder paymentHistoryViewHolder = holder instanceof PaymentHistoryViewHolder ? (PaymentHistoryViewHolder) holder : null;
            if (paymentHistoryViewHolder != null) {
                paymentHistoryViewHolder.bindTo(item);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemHistoryPaymentBinding itemHistoryPaymentBindingInflate = ItemHistoryPaymentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemHistoryPaymentBindingInflate, "inflate(...)");
        PaymentHistoryViewHolder paymentHistoryViewHolder = new PaymentHistoryViewHolder(itemHistoryPaymentBindingInflate);
        onViewHolderCreated(paymentHistoryViewHolder, itemHistoryPaymentBindingInflate);
        return paymentHistoryViewHolder;
    }

    private final void onViewHolderCreated(final RecyclerView.ViewHolder viewHolder, final ItemHistoryPaymentBinding binding) {
        binding.tvAction.setText(this.bottomTitle);
        binding.tvAction.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.payment_info_list.PaymentsHistoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentsHistoryAdapter.onViewHolderCreated$lambda$3$lambda$2(this.f$0, viewHolder, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$3$lambda$2(PaymentsHistoryAdapter this$0, RecyclerView.ViewHolder viewHolder, ItemHistoryPaymentBinding binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        PaymentHistory item = this$0.getItem(viewHolder.getBindingAdapterPosition());
        if (item != null) {
            Function2<View, PaymentHistory, Unit> function2 = this$0.onItemClicked;
            CardView root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            function2.invoke(root, item);
        }
    }

    /* compiled from: PaymentsHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/service_payments/ui/payment_info_list/PaymentsHistoryAdapter$PaymentHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/sputnik/service_payments/databinding/ItemHistoryPaymentBinding;", "(Lcom/sputnik/service_payments/databinding/ItemHistoryPaymentBinding;)V", "bindTo", "", "item", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PaymentHistoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemHistoryPaymentBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentHistoryViewHolder(ItemHistoryPaymentBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bindTo(PaymentHistory item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ItemHistoryPaymentBinding itemHistoryPaymentBinding = this.binding;
            itemHistoryPaymentBinding.tvPrice.setText(item.getAmount());
            itemHistoryPaymentBinding.tvPaymentTitle.setText(item.getPaymentDate());
        }
    }
}
