package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class CallHistoryFooterBinding extends ViewDataBinding {
    public final TextView tvVisitsInfo;

    protected CallHistoryFooterBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvVisitsInfo = textView;
    }

    public static CallHistoryFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CallHistoryFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CallHistoryFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.call_history_footer, viewGroup, z, obj);
    }
}
