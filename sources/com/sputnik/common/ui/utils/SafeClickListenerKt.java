package com.sputnik.common.ui.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafeClickListener.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, d2 = {"setSafeOnClickListener", "", "Landroid/view/View;", "delay", "", "onSafeClick", "Lkotlin/Function1;", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeClickListenerKt {
    public static /* synthetic */ void setSafeOnClickListener$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        setSafeOnClickListener(view, j, function1);
    }

    public static final void setSafeOnClickListener(View view, long j, final Function1<? super View, Unit> onSafeClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onSafeClick, "onSafeClick");
        view.setOnClickListener(new SafeClickListener(j, new Function1<View, Unit>() { // from class: com.sputnik.common.ui.utils.SafeClickListenerKt$setSafeOnClickListener$safeClickListener$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onSafeClick.invoke(it);
            }
        }));
    }
}
