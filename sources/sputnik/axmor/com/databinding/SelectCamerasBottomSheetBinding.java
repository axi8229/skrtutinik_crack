package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class SelectCamerasBottomSheetBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView rvCamerasBottomSheet;
    public final LinearLayout serviceLoader;
    public final TextView title;

    private SelectCamerasBottomSheetBinding(LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.rvCamerasBottomSheet = recyclerView;
        this.serviceLoader = linearLayout2;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SelectCamerasBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.select_cameras_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SelectCamerasBottomSheetBinding bind(View view) {
        int i = R.id.rv_cameras_bottom_sheet;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_cameras_bottom_sheet);
        if (recyclerView != null) {
            i = R.id.serviceLoader;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
            if (linearLayout != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView != null) {
                    return new SelectCamerasBottomSheetBinding((LinearLayout) view, recyclerView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
