package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentFlussonicBinding extends ViewDataBinding {
    public final LinearLayout container;
    public final Toolbar title;
    public final FlussonicWatcherView watcherView;

    protected FragmentFlussonicBinding(Object obj, View view, int i, LinearLayout linearLayout, Toolbar toolbar, FlussonicWatcherView flussonicWatcherView) {
        super(obj, view, i);
        this.container = linearLayout;
        this.title = toolbar;
        this.watcherView = flussonicWatcherView;
    }

    public static FragmentFlussonicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFlussonicBinding bind(View view, Object obj) {
        return (FragmentFlussonicBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_flussonic);
    }
}
