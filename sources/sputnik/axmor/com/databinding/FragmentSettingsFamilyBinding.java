package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentSettingsFamilyBinding extends ViewDataBinding {
    public final AppCompatButton btnInvite;
    public final AppCompatButton btnLeaveFromFamily;
    public final RecyclerView familyList;
    public final LinearLayout layoutActions;
    public final LinearLayout layoutFamilyActions;
    public final LinearLayout layoutInvites;
    public final LinearLayout layoutInvitesActions;
    public final ConstraintLayout layoutRoot;
    public final SwipeRefreshLayout layoutSwipeRefresh;
    public final LinearLayout loader;
    public final NestedScrollView nestedScrollView3;
    public final RecyclerView rvInvites;
    public final Toolbar toolbar;
    public final TextView tvInvitesCount;
    public final TextView tvInvitesEmpty;
    public final TextView tvInvitesTitle;

    protected FragmentSettingsFamilyBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, RecyclerView recyclerView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout, SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout5, NestedScrollView nestedScrollView, RecyclerView recyclerView2, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.btnInvite = appCompatButton;
        this.btnLeaveFromFamily = appCompatButton2;
        this.familyList = recyclerView;
        this.layoutActions = linearLayout;
        this.layoutFamilyActions = linearLayout2;
        this.layoutInvites = linearLayout3;
        this.layoutInvitesActions = linearLayout4;
        this.layoutRoot = constraintLayout;
        this.layoutSwipeRefresh = swipeRefreshLayout;
        this.loader = linearLayout5;
        this.nestedScrollView3 = nestedScrollView;
        this.rvInvites = recyclerView2;
        this.toolbar = toolbar;
        this.tvInvitesCount = textView;
        this.tvInvitesEmpty = textView2;
        this.tvInvitesTitle = textView3;
    }

    public static FragmentSettingsFamilyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsFamilyBinding bind(View view, Object obj) {
        return (FragmentSettingsFamilyBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_settings_family);
    }
}
