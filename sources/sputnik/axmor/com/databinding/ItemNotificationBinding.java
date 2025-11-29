package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.notifications.Notification;

/* loaded from: classes5.dex */
public abstract class ItemNotificationBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout6;
    public final TextView entryName;
    public final TextView entryPhone;
    public final ConstraintLayout layoutTv;
    public final LinearLayout linearLayout6;
    protected Notification mItem;
    public final ConstraintLayout relativeLayout2;
    public final TextView tvType;
    public final View vDividerCameras;
    public final View view;

    protected ItemNotificationBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.constraintLayout6 = constraintLayout;
        this.entryName = textView;
        this.entryPhone = textView2;
        this.layoutTv = constraintLayout2;
        this.linearLayout6 = linearLayout;
        this.relativeLayout2 = constraintLayout3;
        this.tvType = textView3;
        this.vDividerCameras = view2;
        this.view = view3;
    }
}
