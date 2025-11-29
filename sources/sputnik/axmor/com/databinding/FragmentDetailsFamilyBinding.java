package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* loaded from: classes5.dex */
public abstract class FragmentDetailsFamilyBinding extends ViewDataBinding {
    public final AppCompatButton btnDelete;
    public final AppCompatButton btnMakeAdmin;
    public final TextView entryName;
    public final TextView entryPhone;
    public final ImageView ivPhoto;
    public final LinearLayout lButtons;
    public final LinearLayout lFamilyDetails;
    protected Family mItem;
    public final Toolbar toolbar;
    public final ScrollView viewMain;

    public abstract void setItem(Family family);

    protected FragmentDetailsFamilyBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, ScrollView scrollView) {
        super(obj, view, i);
        this.btnDelete = appCompatButton;
        this.btnMakeAdmin = appCompatButton2;
        this.entryName = textView;
        this.entryPhone = textView2;
        this.ivPhoto = imageView;
        this.lButtons = linearLayout;
        this.lFamilyDetails = linearLayout2;
        this.toolbar = toolbar;
        this.viewMain = scrollView;
    }

    public static FragmentDetailsFamilyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetailsFamilyBinding bind(View view, Object obj) {
        return (FragmentDetailsFamilyBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_details_family);
    }
}
