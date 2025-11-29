package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.market.service.Service;

/* loaded from: classes5.dex */
public abstract class SubscriptionServiceItemBinding extends ViewDataBinding {
    protected Service mItem;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    protected SubscriptionServiceItemBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }
}
