package com.sputnik.common.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonComponent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"commonComponent", "Lcom/sputnik/common/di/CommonComponent;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/fragment/app/Fragment;", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommonComponentKt {
    public static final CommonComponent commonComponent(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        return ((CommonComponentViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(CommonComponentViewModel.class)).getCommonComponent();
    }

    public static final CommonComponent commonComponent(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        return ((CommonComponentViewModel) new ViewModelProvider(appCompatActivity).get(CommonComponentViewModel.class)).getCommonComponent();
    }
}
