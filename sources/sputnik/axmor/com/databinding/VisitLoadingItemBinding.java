package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.paging.LoadState;

/* loaded from: classes5.dex */
public abstract class VisitLoadingItemBinding extends ViewDataBinding {
    protected LoadState mItem;
    public final ProgressBar progressBar;

    protected VisitLoadingItemBinding(Object obj, View view, int i, ProgressBar progressBar) {
        super(obj, view, i);
        this.progressBar = progressBar;
    }
}
