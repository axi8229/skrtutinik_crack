package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes5.dex */
public abstract class CancelServiceItemBinding extends ViewDataBinding {
    protected String mItem;
    public final TextView tvService;

    protected CancelServiceItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvService = textView;
    }
}
