package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetCallHistoryUpdateBinding implements ViewBinding {
    public final Button btnSubscribe;
    public final CoordinatorLayout layoutSnackbar;
    public final LinearLayout linearLayout2;
    private final ScrollView rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetCallHistoryUpdateBinding(ScrollView scrollView, Button button, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnSubscribe = button;
        this.layoutSnackbar = coordinatorLayout;
        this.linearLayout2 = linearLayout;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetCallHistoryUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_call_history_update, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetCallHistoryUpdateBinding bind(View view) {
        int i = R.id.btn_subscribe;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        if (button != null) {
            i = R.id.layout_snackbar;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.layout_snackbar);
            if (coordinatorLayout != null) {
                i = R.id.linearLayout2;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout2);
                if (linearLayout != null) {
                    i = R.id.tv_subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                    if (textView != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView2 != null) {
                            return new BottomSheetCallHistoryUpdateBinding((ScrollView) view, button, coordinatorLayout, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
