package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import ru.yoomoney.sdk.auth.R;

/* loaded from: classes4.dex */
public final class ActivityAuxTokenIssueBinding implements ViewBinding {
    private final View rootView;

    private ActivityAuxTokenIssueBinding(View view) {
        this.rootView = view;
    }

    public static ActivityAuxTokenIssueBinding bind(View view) {
        if (view != null) {
            return new ActivityAuxTokenIssueBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityAuxTokenIssueBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ActivityAuxTokenIssueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_aux_token_issue, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
