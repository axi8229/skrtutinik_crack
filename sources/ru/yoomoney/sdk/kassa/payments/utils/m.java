package ru.yoomoney.sdk.kassa.payments.utils;

import android.view.View;
import androidx.constraintlayout.widget.Group;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class m {
    public static final void a(Group group) {
        Intrinsics.checkNotNullParameter(group, "<this>");
        a(group, false);
    }

    public static final void a(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }
}
