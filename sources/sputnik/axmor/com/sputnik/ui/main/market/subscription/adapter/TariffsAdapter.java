package sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewHolder;
import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SubItemTariffBinding;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.TariffsAdapter;

/* compiled from: TariffsAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0018B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001c\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/TariffsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/TariffsAdapter$PlanViewHolder;", "onItemClicked", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "checkedPosition", "getCheckedPosition", "()I", "setCheckedPosition", "(I)V", "getOnItemClicked", "()Lkotlin/jvm/functions/Function1;", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PlanViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TariffsAdapter extends ListAdapter<SubsPlans, PlanViewHolder> {
    private int checkedPosition;
    private final Function1<SubsPlans, Unit> onItemClicked;

    public final Function1<SubsPlans, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffsAdapter(Function1<? super SubsPlans, Unit> onItemClicked) {
        super(new PlansDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
    }

    public final int getCheckedPosition() {
        return this.checkedPosition;
    }

    public final void setCheckedPosition(int i) {
        submitList(getCurrentList());
        this.checkedPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SubItemTariffBinding subItemTariffBindingInflate = SubItemTariffBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(subItemTariffBindingInflate, "inflate(...)");
        return new PlanViewHolder(this, subItemTariffBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PlanViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SubsPlans item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bindTo(item);
    }

    /* compiled from: TariffsAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0017J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/TariffsAdapter$PlanViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "binding", "Lsputnik/axmor/com/databinding/SubItemTariffBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/TariffsAdapter;Lsputnik/axmor/com/databinding/SubItemTariffBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/SubItemTariffBinding;", "bindTo", "", "item", "setSelected", "isSelected", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class PlanViewHolder extends BaseViewHolder<SubsPlans> {
        private final SubItemTariffBinding binding;
        final /* synthetic */ TariffsAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public PlanViewHolder(TariffsAdapter tariffsAdapter, SubItemTariffBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = tariffsAdapter;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public SubItemTariffBinding getBinding() {
            return this.binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        @SuppressLint({"SetTextI18n"})
        public void bindTo(final SubsPlans item) {
            Intrinsics.checkNotNullParameter(item, "item");
            setSelected(this.this$0.getCheckedPosition() == getBindingAdapterPosition());
            SubItemTariffBinding binding = getBinding();
            final TariffsAdapter tariffsAdapter = this.this$0;
            TextView tvSubAdd = binding.tvSubAdd;
            Intrinsics.checkNotNullExpressionValue(tvSubAdd, "tvSubAdd");
            ViewKt.gone(tvSubAdd);
            TextView saleTariff = binding.saleTariff;
            Intrinsics.checkNotNullExpressionValue(saleTariff, "saleTariff");
            ViewKt.gone(saleTariff);
            binding.tvSubTitle.setText(item.getTitle());
            String specialBadgeTitle = item.getSpecialBadgeTitle();
            if (specialBadgeTitle != null) {
                TextView saleTariff2 = binding.saleTariff;
                Intrinsics.checkNotNullExpressionValue(saleTariff2, "saleTariff");
                ViewKt.visible(saleTariff2);
                binding.saleTariff.setText(specialBadgeTitle);
            }
            binding.tvSubPrice.setText(item.getPriceVerbose());
            String specialDescription = item.getSpecialDescription();
            if (specialDescription != null) {
                binding.tvSubTitle.setText(this.itemView.getContext().getString(R.string.special_subs));
                TextView tvSubAdd2 = binding.tvSubAdd;
                Intrinsics.checkNotNullExpressionValue(tvSubAdd2, "tvSubAdd");
                ViewKt.visible(tvSubAdd2);
                binding.tvSubAdd.setText(specialDescription);
            }
            binding.cardViewTariff.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter.TariffsAdapter$PlanViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TariffsAdapter.PlanViewHolder.bindTo$lambda$3$lambda$2(tariffsAdapter, this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindTo$lambda$3$lambda$2(TariffsAdapter this$0, PlanViewHolder this$1, SubsPlans item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (this$0.getCheckedPosition() != this$1.getBindingAdapterPosition()) {
                this$0.notifyItemChanged(this$0.getCheckedPosition());
                this$0.setCheckedPosition(this$1.getBindingAdapterPosition());
                this$0.notifyItemChanged(this$1.getBindingAdapterPosition());
                this$0.getOnItemClicked().invoke(item);
            }
        }

        private final void setSelected(boolean isSelected) {
            getBinding().cardViewLayout.setBackground(isSelected ? ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_selected_tariff) : null);
            getBinding().ivSelected.setImageResource(isSelected ? R.drawable.ic_checkmark_outline : R.drawable.ic_circle_outline);
        }
    }
}
