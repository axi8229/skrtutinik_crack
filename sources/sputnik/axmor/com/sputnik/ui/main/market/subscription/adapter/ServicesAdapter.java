package sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import com.sputnik.common.base.BaseViewHolder;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.InsuranceServiceItemBinding;

/* compiled from: ServicesAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002&\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u0004\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0005R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0005R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServicesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lkotlin/Pair;", "", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServiceElem;", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServicesAdapter$ServiceViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ServiceViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesAdapter extends ListAdapter<Pair<? extends String, ? extends String>, ServiceViewHolder> {
    public ServicesAdapter() {
        super(new ServicesDiffCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InsuranceServiceItemBinding insuranceServiceItemBindingInflate = InsuranceServiceItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(insuranceServiceItemBindingInflate, "inflate(...)");
        return new ServiceViewHolder(this, insuranceServiceItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ServiceViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindTo2((Pair<String, String>) getItem(position));
    }

    /* compiled from: ServicesAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J(\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServicesAdapter$ServiceViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lkotlin/Pair;", "", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServiceElem;", "binding", "Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServicesAdapter;Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ServiceViewHolder extends BaseViewHolder<Pair<? extends String, ? extends String>> {
        private final InsuranceServiceItemBinding binding;
        final /* synthetic */ ServicesAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public ServiceViewHolder(ServicesAdapter servicesAdapter, InsuranceServiceItemBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = servicesAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
            InsuranceServiceItemBinding binding2 = getBinding();
            LinearLayout lAddition = binding2.lAddition;
            Intrinsics.checkNotNullExpressionValue(lAddition, "lAddition");
            ViewKt.gone(lAddition);
            binding2.cardRoot.setClickable(false);
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public /* bridge */ /* synthetic */ void bindTo(Pair<? extends String, ? extends String> pair) {
            bindTo2((Pair<String, String>) pair);
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public InsuranceServiceItemBinding getBinding() {
            return this.binding;
        }

        /* renamed from: bindTo, reason: avoid collision after fix types in other method */
        public void bindTo2(Pair<String, String> item) {
            getBinding().serviceName.setText(item != null ? item.getFirst() : null);
            getBinding().serviceName.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.sputnik_pink));
            getBinding().serviceDescription.setText(item != null ? item.getSecond() : null);
        }
    }
}
