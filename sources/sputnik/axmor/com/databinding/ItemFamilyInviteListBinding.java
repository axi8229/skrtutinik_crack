package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.invites.FamilyInvite;

/* loaded from: classes5.dex */
public abstract class ItemFamilyInviteListBinding extends ViewDataBinding {
    public final TextView entryName;
    public final TextView entryPhone;
    public final ImageView entryPhoto;
    protected FamilyInvite mItem;
    public final ConstraintLayout relativeLayout3;

    protected ItemFamilyInviteListBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.entryName = textView;
        this.entryPhone = textView2;
        this.entryPhoto = imageView;
        this.relativeLayout3 = constraintLayout;
    }
}
