package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.viewmodels.CallCodeViewState;

/* loaded from: classes5.dex */
public abstract class GlobalRequestCallCodeFragmentBinding extends ViewDataBinding {
    public final TextView btnLoginBySMS;
    public final LinearLayout loader;
    public final LinearLayout loginInputContainer;
    protected CallCodeViewState mItem;
    public final Toolbar toolbar;
    public final TextView tvErrorCode;
    public final TextView tvInfo;
    public final TextView tvTitle;

    protected GlobalRequestCallCodeFragmentBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnLoginBySMS = textView;
        this.loader = linearLayout;
        this.loginInputContainer = linearLayout2;
        this.toolbar = toolbar;
        this.tvErrorCode = textView2;
        this.tvInfo = textView3;
        this.tvTitle = textView4;
    }
}
