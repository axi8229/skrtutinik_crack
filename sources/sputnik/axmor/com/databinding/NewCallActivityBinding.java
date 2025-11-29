package sputnik.axmor.com.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;

/* loaded from: classes5.dex */
public abstract class NewCallActivityBinding extends ViewDataBinding {
    public final FragmentContainerView callNavHostFragment;

    protected NewCallActivityBinding(Object obj, View view, int i, FragmentContainerView fragmentContainerView) {
        super(obj, view, i);
        this.callNavHostFragment = fragmentContainerView;
    }
}
