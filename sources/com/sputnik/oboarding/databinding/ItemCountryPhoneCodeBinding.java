package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.country_code.CountryCode;

/* loaded from: classes3.dex */
public abstract class ItemCountryPhoneCodeBinding extends ViewDataBinding {
    protected CountryCode mItem;
    public final TextView tvCountryNameItem;
    public final TextView tvSelectedCategoryTitle;

    protected ItemCountryPhoneCodeBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvCountryNameItem = textView;
        this.tvSelectedCategoryTitle = textView2;
    }
}
