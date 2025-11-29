package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;

/* loaded from: classes5.dex */
public abstract class VisitItemBinding extends ViewDataBinding {
    public final View dividerH;
    public final ImageView ivArchive;
    public final ImageView ivPhoneCall;
    public final ImageView ivVisitorItem;
    protected CallHistory mItem;
    public final TextView tvAdressVisitItem;
    public final TextView tvTimeVisitItem;

    protected VisitItemBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.dividerH = view2;
        this.ivArchive = imageView;
        this.ivPhoneCall = imageView2;
        this.ivVisitorItem = imageView3;
        this.tvAdressVisitItem = textView;
        this.tvTimeVisitItem = textView2;
    }

    public static VisitItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VisitItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VisitItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.visit_item, viewGroup, z, obj);
    }
}
