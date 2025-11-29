package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes5.dex */
public abstract class FragmentServicesAvailableItemBinding extends ViewDataBinding {
    public final TextView serviceDescription;
    public final TextView serviceName;
    public final TextView servicePrice;

    protected FragmentServicesAvailableItemBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.serviceDescription = textView;
        this.serviceName = textView2;
        this.servicePrice = textView3;
    }
}
