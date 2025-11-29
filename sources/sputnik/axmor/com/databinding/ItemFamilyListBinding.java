package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* loaded from: classes5.dex */
public abstract class ItemFamilyListBinding extends ViewDataBinding {
    public final TextView entryName;
    public final TextView entryPhone;
    public final ImageView entryPhoto;
    public final TextView isAdmin;
    public final TextView isSelf;
    public final LinearLayout layoutTv;
    protected Family mItem;
    public final ConstraintLayout relativeLayout8;

    protected ItemFamilyListBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, LinearLayout linearLayout, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.entryName = textView;
        this.entryPhone = textView2;
        this.entryPhoto = imageView;
        this.isAdmin = textView3;
        this.isSelf = textView4;
        this.layoutTv = linearLayout;
        this.relativeLayout8 = constraintLayout;
    }
}
