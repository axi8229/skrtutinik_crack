package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class VisitsDateItemBinding extends ViewDataBinding {
    protected String mItem;
    public final TextView tvVisitsDate;

    protected VisitsDateItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvVisitsDate = textView;
    }

    public static VisitsDateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VisitsDateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VisitsDateItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.visits_date_item, viewGroup, z, obj);
    }
}
