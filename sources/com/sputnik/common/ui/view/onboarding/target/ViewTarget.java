package com.sputnik.common.ui.view.onboarding.target;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewTarget.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/target/ViewTarget;", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "point", "Landroid/graphics/Point;", "getPoint", "()Landroid/graphics/Point;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "getView", "()Landroid/view/View;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewTarget implements Target {
    private final View view;

    public ViewTarget(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // com.sputnik.common.ui.view.onboarding.target.Target
    public View getView() {
        return this.view;
    }

    @Override // com.sputnik.common.ui.view.onboarding.target.Target
    public Point getPoint() {
        int[] iArr = new int[2];
        getView().getLocationInWindow(iArr);
        return new Point(iArr[0] + (getView().getWidth() / 2), iArr[1] + (getView().getHeight() / 2));
    }

    @Override // com.sputnik.common.ui.view.onboarding.target.Target
    public Rect getRect() {
        int[] iArr = new int[2];
        getView().getLocationInWindow(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], getView().getWidth() + i, iArr[1] + getView().getHeight());
    }
}
