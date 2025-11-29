package sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.domain.entities.call.CallState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.CallHistoryFooterBinding;
import sputnik.axmor.com.databinding.CallHistoryPromoBinding;
import sputnik.axmor.com.databinding.VisitItemBinding;
import sputnik.axmor.com.databinding.VisitsDateItemBinding;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003-,.BQ\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010+¨\u0006/"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "bottomTitle", "Lcom/sputnik/common/entities/market/service/Service;", "archiveService", "Lkotlin/Function2;", "Landroid/view/View;", "", "onItemClicked", "onButtonClicked", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/market/service/Service;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "viewHolder", "Landroidx/databinding/ViewDataBinding;", "binding", "onViewHolderCreated", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/databinding/ViewDataBinding;)V", "", "position", "getCurrentItem", "(I)Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "", "getItems", "()Ljava/util/List;", "getItemViewType", "(I)I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/lang/String;", "Lcom/sputnik/common/entities/market/service/Service;", "getArchiveService", "()Lcom/sputnik/common/entities/market/service/Service;", "setArchiveService", "(Lcom/sputnik/common/entities/market/service/Service;)V", "Lkotlin/jvm/functions/Function2;", "Companion", "CallHistoryViewHolder", "FooterViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryAdapter extends PagingDataAdapter<CallHistoryUi, RecyclerView.ViewHolder> {
    private Service archiveService;
    private final String bottomTitle;
    private final Function2<View, CallHistoryUi, Unit> onButtonClicked;
    private final Function2<View, CallHistoryUi, Unit> onItemClicked;

    public final Service getArchiveService() {
        return this.archiveService;
    }

    public final void setArchiveService(Service service) {
        this.archiveService = service;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CallHistoryAdapter(String str, Service service, Function2<? super View, ? super CallHistoryUi, Unit> onItemClicked, Function2<? super View, ? super CallHistoryUi, Unit> onButtonClicked) {
        super(new CallHistoryDiffCallback(), (CoroutineContext) null, (CoroutineContext) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onButtonClicked, "onButtonClicked");
        this.bottomTitle = str;
        this.archiveService = service;
        this.onItemClicked = onItemClicked;
        this.onButtonClicked = onButtonClicked;
    }

    public final CallHistoryUi getCurrentItem(int position) {
        return getItem(position);
    }

    public final List<CallHistoryUi> getItems() {
        return snapshot().getItems();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        try {
            CallHistoryUi item = getItem(position);
            if (item instanceof CallHistoryUi.CallHistoryItem) {
                return 0;
            }
            if (item instanceof CallHistoryUi.DateItem) {
                return 1;
            }
            if (item instanceof CallHistoryUi.Footer) {
                return 2;
            }
            if (item instanceof CallHistoryUi.Promo) {
                return 3;
            }
            if (item == null) {
                throw new UnsupportedOperationException("Unknown view");
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            CallHistoryUi item = getItem(position);
            if (item != null) {
                CallHistoryViewHolder callHistoryViewHolder = holder instanceof CallHistoryViewHolder ? (CallHistoryViewHolder) holder : null;
                if (callHistoryViewHolder != null) {
                    Service service = this.archiveService;
                    boolean z = true;
                    if (position != getItemCount() - 1) {
                        z = false;
                    }
                    callHistoryViewHolder.bindTo(item, service, z);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == -1) {
            VisitsDateItemBinding visitsDateItemBindingInflate = VisitsDateItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(visitsDateItemBindingInflate, "inflate(...)");
            return new CallHistoryViewHolder(visitsDateItemBindingInflate);
        }
        if (viewType == 0) {
            VisitItemBinding visitItemBindingInflate = VisitItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(visitItemBindingInflate, "inflate(...)");
            CallHistoryViewHolder callHistoryViewHolder = new CallHistoryViewHolder(visitItemBindingInflate);
            onViewHolderCreated(callHistoryViewHolder, visitItemBindingInflate);
            return callHistoryViewHolder;
        }
        if (viewType == 2) {
            CallHistoryFooterBinding callHistoryFooterBindingInflate = CallHistoryFooterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            callHistoryFooterBindingInflate.tvVisitsInfo.setText(this.bottomTitle);
            Intrinsics.checkNotNullExpressionValue(callHistoryFooterBindingInflate, "apply(...)");
            return new FooterViewHolder(callHistoryFooterBindingInflate);
        }
        if (viewType == 3) {
            CallHistoryPromoBinding callHistoryPromoBindingInflate = CallHistoryPromoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            callHistoryPromoBindingInflate.tvPromo1.setText("Вам доступна история посещений с фото\nгостя только за последние сутки.");
            Context context = callHistoryPromoBindingInflate.getRoot().getContext();
            if (context != null) {
                Intrinsics.checkNotNull(context);
                callHistoryPromoBindingInflate.tvPromo2.setText(ViewUtilsKt.highlightText("Просматривайте историю с видео\nза 30 дней с подпиской “Семья”", "историю с видео\nза 30 дней", -16777216, context, R.style.TextView_Body2_Selection));
            }
            callHistoryPromoBindingInflate.btnSubscribe.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallHistoryAdapter.onCreateViewHolder$lambda$4$lambda$3(this.f$0, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(callHistoryPromoBindingInflate, "apply(...)");
            return new FooterViewHolder(callHistoryPromoBindingInflate);
        }
        VisitsDateItemBinding visitsDateItemBindingInflate2 = VisitsDateItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(visitsDateItemBindingInflate2, "inflate(...)");
        return new CallHistoryViewHolder(visitsDateItemBindingInflate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$4$lambda$3(CallHistoryAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<View, CallHistoryUi, Unit> function2 = this$0.onItemClicked;
        Intrinsics.checkNotNull(view);
        function2.invoke(view, CallHistoryUi.Promo.INSTANCE);
    }

    private final void onViewHolderCreated(final RecyclerView.ViewHolder viewHolder, final ViewDataBinding binding) {
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallHistoryAdapter.onViewHolderCreated$lambda$6(this.f$0, viewHolder, binding, view);
            }
        });
        binding.getRoot().findViewById(R.id.iv_archive).setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallHistoryAdapter.onViewHolderCreated$lambda$10(viewHolder, this, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$6(CallHistoryAdapter this$0, RecyclerView.ViewHolder viewHolder, ViewDataBinding binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        CallHistoryUi item = this$0.getItem(viewHolder.getBindingAdapterPosition());
        if (item != null) {
            Function2<View, CallHistoryUi, Unit> function2 = this$0.onItemClicked;
            ImageView ivVisitorItem = ((VisitItemBinding) binding).ivVisitorItem;
            Intrinsics.checkNotNullExpressionValue(ivVisitorItem, "ivVisitorItem");
            function2.invoke(ivVisitorItem, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$10(RecyclerView.ViewHolder viewHolder, CallHistoryAdapter this$0, ViewDataBinding binding, View view) {
        CallHistoryUi item;
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Integer numValueOf = Integer.valueOf(viewHolder.getBindingAdapterPosition());
        int iIntValue = numValueOf.intValue();
        if (iIntValue < 0 || iIntValue > this$0.getItemCount() - 1) {
            numValueOf = null;
        }
        if (numValueOf == null || (item = this$0.getItem(numValueOf.intValue())) == null) {
            return;
        }
        Function2<View, CallHistoryUi, Unit> function2 = this$0.onButtonClicked;
        ImageView ivVisitorItem = ((VisitItemBinding) binding).ivVisitorItem;
        Intrinsics.checkNotNullExpressionValue(ivVisitorItem, "ivVisitorItem");
        function2.invoke(ivVisitorItem, item);
    }

    /* compiled from: CallHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryAdapter$CallHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "bindTo", "", "item", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "archiveService", "Lcom/sputnik/common/entities/market/service/Service;", "isLast", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CallHistoryViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallHistoryViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bindTo(CallHistoryUi item, Service archiveService, boolean isLast) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof CallHistoryUi.CallHistoryItem) {
                if (archiveService != null) {
                    ((CallHistoryUi.CallHistoryItem) item).getItem().setHasArchive(true);
                    ((ImageView) this.binding.getRoot().findViewById(R.id.iv_archive)).setImageResource(R.drawable.ic_archive_outline_new_blue);
                }
                this.binding.setVariable(1, ((CallHistoryUi.CallHistoryItem) item).getItem());
            } else {
                CallHistoryUi.DateItem dateItem = (CallHistoryUi.DateItem) item;
                this.binding.setVariable(1, dateItem.getDate());
                if (dateItem.getState() == CallState.history_date && isLast) {
                    View viewFindViewById = this.binding.getRoot().findViewById(R.id.tv_visits_date);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                    ViewKt.gone(viewFindViewById);
                }
            }
            this.binding.executePendingBindings();
        }
    }

    /* compiled from: CallHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }
}
