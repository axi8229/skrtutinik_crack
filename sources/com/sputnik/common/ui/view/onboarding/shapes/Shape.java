package com.sputnik.common.ui.view.onboarding.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.sputnik.common.ui.view.onboarding.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Shape.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u0004\u0018\u00010\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u0004\u0018\u00010\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010)\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001f¨\u0006*"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/shapes/Shape;", "", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "target", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "focus", "", "padding", "<init>", "(Lcom/sputnik/common/ui/view/onboarding/target/Target;Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;I)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "eraser", "", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;I)V", "reCalculateAll", "()V", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "getTarget", "()Lcom/sputnik/common/ui/view/onboarding/target/Target;", "setTarget", "(Lcom/sputnik/common/ui/view/onboarding/target/Target;)V", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "getFocus", "()Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "setFocus", "(Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;)V", "I", "getPadding", "()I", "setPadding", "(I)V", "Landroid/graphics/Point;", "getFocusPoint", "()Landroid/graphics/Point;", "focusPoint", "getPoint", "point", "getHeight", "height", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Shape {
    private Focus focus;
    private int padding;
    private Target target;

    public abstract void draw(Canvas canvas, Paint eraser, int padding);

    public abstract int getHeight();

    public abstract Point getPoint();

    public abstract void reCalculateAll();

    public Shape(Target target, Focus focus, int i) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(focus, "focus");
        this.target = target;
        this.focus = focus;
        this.padding = i;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Focus getFocus() {
        return this.focus;
    }

    public final int getPadding() {
        return this.padding;
    }

    protected final Point getFocusPoint() {
        return this.target.getPoint();
    }
}
