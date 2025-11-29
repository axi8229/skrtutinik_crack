package com.sputnik.common.ui.utils;

import android.os.SystemClock;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafeClickListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/common/ui/utils/SafeClickListener;", "Landroid/view/View$OnClickListener;", "defaultInterval", "", "onSafeClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "(JLkotlin/jvm/functions/Function1;)V", "lastTimeClicked", "onClick", "v", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeClickListener implements View.OnClickListener {
    private long defaultInterval;
    private long lastTimeClicked;
    private final Function1<View, Unit> onSafeClick;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeClickListener(long j, Function1<? super View, Unit> onSafeClick) {
        Intrinsics.checkNotNullParameter(onSafeClick, "onSafeClick");
        this.defaultInterval = j;
        this.onSafeClick = onSafeClick;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws IllegalStateException {
        if (SystemClock.elapsedRealtime() - this.lastTimeClicked < this.defaultInterval) {
            return;
        }
        this.lastTimeClicked = SystemClock.elapsedRealtime();
        if (v == null) {
            throw new IllegalStateException();
        }
        this.onSafeClick.invoke(v);
    }
}
