package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import ru.yoomoney.sdk.auth.R;

/* loaded from: classes4.dex */
public final class ActivityAuthEntryBinding implements ViewBinding {
    private final View rootView;

    private ActivityAuthEntryBinding(View view) {
        this.rootView = view;
    }

    public static ActivityAuthEntryBinding bind(View view) {
        if (view != null) {
            return new ActivityAuthEntryBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityAuthEntryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ActivityAuthEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_auth_entry, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
