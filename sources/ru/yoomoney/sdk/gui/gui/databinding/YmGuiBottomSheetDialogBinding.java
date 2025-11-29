package ru.yoomoney.sdk.gui.gui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.widget.ContentScrollView;

/* loaded from: classes3.dex */
public final class YmGuiBottomSheetDialogBinding implements ViewBinding {
    public final LinearLayout itemsContainer;
    private final ContentScrollView rootView;
    public final ContentScrollView scrollView;

    private YmGuiBottomSheetDialogBinding(ContentScrollView contentScrollView, LinearLayout linearLayout, ContentScrollView contentScrollView2) {
        this.rootView = contentScrollView;
        this.itemsContainer = linearLayout;
        this.scrollView = contentScrollView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ContentScrollView getRoot() {
        return this.rootView;
    }

    public static YmGuiBottomSheetDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.ym_gui_bottom_sheet_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YmGuiBottomSheetDialogBinding bind(View view) {
        int i = R$id.items_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            ContentScrollView contentScrollView = (ContentScrollView) view;
            return new YmGuiBottomSheetDialogBinding(contentScrollView, linearLayout, contentScrollView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
