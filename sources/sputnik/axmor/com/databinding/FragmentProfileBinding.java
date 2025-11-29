package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentProfileBinding extends ViewDataBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnDelete;
    public final TextView buttonExit;
    public final ConstraintLayout cardRoot;
    public final View divider;
    public final TextView etNameTitle;
    public final TextView etPhoneTitle;
    public final ImageView ivPhoto;
    public final LinearLayout lAddition;
    public final ConstraintLayout layoutSub;
    public final LinearLayout linearLayout2;
    public final LinearLayout mainLayout;
    public final LinearLayout profileLoader;
    public final ScrollView scrollView;
    public final Toolbar toolbar;
    public final TextView tvChangeAvatarDescription;
    public final EditText tvName;
    public final EditText tvPhone;
    public final TextView tvSubTitle;
    public final TextView tvSubscriptionPayedUntil;
    public final TextView tvSubscriptionPrice;
    public final TextView tvSubscriptionTitle;

    protected FragmentProfileBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, ConstraintLayout constraintLayout, View view2, TextView textView2, TextView textView3, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ScrollView scrollView, Toolbar toolbar, TextView textView4, EditText editText, EditText editText2, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.btnApply = appCompatButton;
        this.btnDelete = appCompatButton2;
        this.buttonExit = textView;
        this.cardRoot = constraintLayout;
        this.divider = view2;
        this.etNameTitle = textView2;
        this.etPhoneTitle = textView3;
        this.ivPhoto = imageView;
        this.lAddition = linearLayout;
        this.layoutSub = constraintLayout2;
        this.linearLayout2 = linearLayout2;
        this.mainLayout = linearLayout3;
        this.profileLoader = linearLayout4;
        this.scrollView = scrollView;
        this.toolbar = toolbar;
        this.tvChangeAvatarDescription = textView4;
        this.tvName = editText;
        this.tvPhone = editText2;
        this.tvSubTitle = textView5;
        this.tvSubscriptionPayedUntil = textView6;
        this.tvSubscriptionPrice = textView7;
        this.tvSubscriptionTitle = textView8;
    }

    public static FragmentProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileBinding bind(View view, Object obj) {
        return (FragmentProfileBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_profile);
    }
}
