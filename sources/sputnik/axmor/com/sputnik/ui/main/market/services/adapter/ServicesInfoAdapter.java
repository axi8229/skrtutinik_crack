package sputnik.axmor.com.sputnik.ui.main.market.services.adapter;

import androidx.databinding.ViewDataBinding;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.market.service.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SubscriptionServiceItemBinding;

/* compiled from: ServicesInfoAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/adapter/ServicesInfoAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/market/service/Service;", "()V", RemoteMessageConst.Notification.COLOR, "", "Ljava/lang/Integer;", "applyColor", "", "onBindViewHolder", "holder", "Lcom/sputnik/common/base/CustomViewHolder;", "position", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesInfoAdapter extends BaseAdapter<Service> {
    private Integer color;

    public ServicesInfoAdapter() {
        super(R.layout.subscription_service_item, null, 1, new ServicesInfoDiffCallback(), 2, null);
    }

    public final void applyColor(int color) {
        this.color = Integer.valueOf(color);
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<Service> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.SubscriptionServiceItemBinding");
        SubscriptionServiceItemBinding subscriptionServiceItemBinding = (SubscriptionServiceItemBinding) binding;
        Integer num = this.color;
        if (num != null) {
            subscriptionServiceItemBinding.tvTitle.setTextColor(num.intValue());
        }
    }
}
