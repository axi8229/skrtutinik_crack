package npi.spay;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.rf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1892rf extends RecyclerView.SimpleOnItemTouchListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e, "e");
        return rv.getScrollState() == 1;
    }
}
