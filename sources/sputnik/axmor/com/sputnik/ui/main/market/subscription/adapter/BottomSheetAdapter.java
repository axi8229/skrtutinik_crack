package sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter;

import android.widget.TextView;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: BottomSheetAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/BottomSheetAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "", "<init>", "()V", "Lcom/sputnik/common/base/CustomViewHolder;", "holder", "", "position", "", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "currentColor", "I", "getCurrentColor", "()I", "setCurrentColor", "(I)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetAdapter extends BaseAdapter<String> {
    private int currentColor;

    public BottomSheetAdapter() {
        super(R.layout.cancel_service_item, null, 1, new BottomSheetDiffCallback(), 2, null);
        this.currentColor = 1030785;
    }

    public final void setCurrentColor(int i) {
        this.currentColor = i;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<String> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ((TextView) holder.getBinding().getRoot().findViewById(R.id.tv_service)).setTextColor(this.currentColor);
    }
}
