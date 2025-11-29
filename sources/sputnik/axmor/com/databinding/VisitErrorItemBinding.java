package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes5.dex */
public abstract class VisitErrorItemBinding extends ViewDataBinding {
    public final TextView errorName;
    public final AppCompatButton repeatButton;

    protected VisitErrorItemBinding(Object obj, View view, int i, TextView textView, AppCompatButton appCompatButton) {
        super(obj, view, i);
        this.errorName = textView;
        this.repeatButton = appCompatButton;
    }
}
