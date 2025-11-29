package com.sputnik.common.ui.view.onboarding.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.sputnik.common.ui.view.onboarding.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Circle.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/shapes/Circle;", "Lcom/sputnik/common/ui/view/onboarding/shapes/Shape;", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "target", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "focus", "", "padding", "<init>", "(Lcom/sputnik/common/ui/view/onboarding/target/Target;Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;I)V", "", "calculateRadius", "(I)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "eraser", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;I)V", "reCalculateAll", "()V", "radius", "I", "Landroid/graphics/Point;", "circlePoint", "Landroid/graphics/Point;", "getPoint", "()Landroid/graphics/Point;", "point", "getHeight", "()I", "height", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Circle extends Shape {
    private Point circlePoint;
    private int radius;

    /* compiled from: Circle.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Focus.values().length];
            try {
                iArr[Focus.MINIMUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Focus.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Circle(Target target, Focus focus, int i) {
        super(target, focus, i);
        Intrinsics.checkNotNull(target);
        Intrinsics.checkNotNull(focus);
        Point focusPoint = getFocusPoint();
        Intrinsics.checkNotNull(focusPoint);
        this.circlePoint = focusPoint;
        calculateRadius(i);
    }

    @Override // com.sputnik.common.ui.view.onboarding.shapes.Shape
    public void draw(Canvas canvas, Paint eraser, int padding) {
        calculateRadius(padding);
        Point focusPoint = getFocusPoint();
        Intrinsics.checkNotNull(focusPoint);
        this.circlePoint = focusPoint;
        Intrinsics.checkNotNull(canvas);
        Point point = this.circlePoint;
        float f = point.x;
        float f2 = point.y;
        float f3 = this.radius;
        Intrinsics.checkNotNull(eraser);
        canvas.drawCircle(f, f2, f3, eraser);
    }

    @Override // com.sputnik.common.ui.view.onboarding.shapes.Shape
    public void reCalculateAll() {
        calculateRadius(getPadding());
        Point focusPoint = getFocusPoint();
        Intrinsics.checkNotNull(focusPoint);
        this.circlePoint = focusPoint;
    }

    private final void calculateRadius(int padding) {
        int iCoerceAtMost;
        int i = WhenMappings.$EnumSwitchMapping$0[getFocus().ordinal()];
        if (i == 1) {
            Rect rect = getTarget().getRect();
            Intrinsics.checkNotNull(rect);
            int iWidth = rect.width() / 2;
            Rect rect2 = getTarget().getRect();
            Intrinsics.checkNotNull(rect2);
            iCoerceAtMost = RangesKt.coerceAtMost(iWidth, rect2.height() / 2);
        } else if (i == 2) {
            Rect rect3 = getTarget().getRect();
            Intrinsics.checkNotNull(rect3);
            int iWidth2 = rect3.width() / 2;
            Rect rect4 = getTarget().getRect();
            Intrinsics.checkNotNull(rect4);
            iCoerceAtMost = RangesKt.coerceAtLeast(iWidth2, rect4.height() / 2);
        } else {
            Rect rect5 = getTarget().getRect();
            Intrinsics.checkNotNull(rect5);
            int iWidth3 = rect5.width() / 2;
            Rect rect6 = getTarget().getRect();
            Intrinsics.checkNotNull(rect6);
            int iCoerceAtMost2 = RangesKt.coerceAtMost(iWidth3, rect6.height() / 2);
            Rect rect7 = getTarget().getRect();
            Intrinsics.checkNotNull(rect7);
            int iWidth4 = rect7.width() / 2;
            Rect rect8 = getTarget().getRect();
            Intrinsics.checkNotNull(rect8);
            iCoerceAtMost = (iCoerceAtMost2 + RangesKt.coerceAtLeast(iWidth4, rect8.height() / 2)) / 2;
        }
        this.radius = iCoerceAtMost + padding;
    }

    @Override // com.sputnik.common.ui.view.onboarding.shapes.Shape
    /* renamed from: getPoint, reason: from getter */
    public Point getCirclePoint() {
        return this.circlePoint;
    }

    @Override // com.sputnik.common.ui.view.onboarding.shapes.Shape
    public int getHeight() {
        return this.radius * 2;
    }
}
