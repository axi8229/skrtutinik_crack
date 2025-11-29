package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.sessions.LocalSession;

/* loaded from: classes3.dex */
public abstract class ItemAccountBinding extends ViewDataBinding {
    public final ImageView ivDelete;
    public final ImageView ivProfilePhoto;
    protected LocalSession mItem;
    public final TextView tvName;
    public final TextView tvPhone;

    protected ItemAccountBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivDelete = imageView;
        this.ivProfilePhoto = imageView2;
        this.tvName = textView;
        this.tvPhone = textView2;
    }
}
