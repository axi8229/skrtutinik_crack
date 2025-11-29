package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.localization.Localization;

/* loaded from: classes3.dex */
public abstract class ItemSelectLangiageBinding extends ViewDataBinding {
    public final TextView choosingLanguage;
    public final ImageView ivSelected;
    protected Localization mItem;

    protected ItemSelectLangiageBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.choosingLanguage = textView;
        this.ivSelected = imageView;
    }
}
