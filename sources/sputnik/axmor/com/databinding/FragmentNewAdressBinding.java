package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentNewAdressBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final LinearLayout lInputs;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final Toolbar toolbar;
    public final EditText tvCity;
    public final TextView tvCityTitle;
    public final EditText tvFlat;
    public final TextView tvFlatTitle;
    public final EditText tvHouse;
    public final TextView tvHouseTitle;
    public final EditText tvStreet;
    public final TextView tvStreetTitle;

    private FragmentNewAdressBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, LinearLayout linearLayout2, ScrollView scrollView, Toolbar toolbar, EditText editText, TextView textView, EditText editText2, TextView textView2, EditText editText3, TextView textView3, EditText editText4, TextView textView4) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.lInputs = linearLayout2;
        this.scrollView = scrollView;
        this.toolbar = toolbar;
        this.tvCity = editText;
        this.tvCityTitle = textView;
        this.tvFlat = editText2;
        this.tvFlatTitle = textView2;
        this.tvHouse = editText3;
        this.tvHouseTitle = textView3;
        this.tvStreet = editText4;
        this.tvStreetTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNewAdressBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.l_inputs;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_inputs);
            if (linearLayout != null) {
                i = R.id.scroll_view;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                if (scrollView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.tvCity;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.tvCity);
                        if (editText != null) {
                            i = R.id.tv_city_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_city_title);
                            if (textView != null) {
                                i = R.id.tvFlat;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.tvFlat);
                                if (editText2 != null) {
                                    i = R.id.tv_flat_title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_flat_title);
                                    if (textView2 != null) {
                                        i = R.id.tvHouse;
                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.tvHouse);
                                        if (editText3 != null) {
                                            i = R.id.tv_house_title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_house_title);
                                            if (textView3 != null) {
                                                i = R.id.tvStreet;
                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(view, R.id.tvStreet);
                                                if (editText4 != null) {
                                                    i = R.id.tv_street_title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_street_title);
                                                    if (textView4 != null) {
                                                        return new FragmentNewAdressBinding((LinearLayout) view, appCompatButton, linearLayout, scrollView, toolbar, editText, textView, editText2, textView2, editText3, textView3, editText4, textView4);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
