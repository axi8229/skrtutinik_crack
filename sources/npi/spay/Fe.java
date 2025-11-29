package npi.spay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Fe extends View {
    public final int a;
    public int b;
    public final int c;
    public final boolean d;
    public float e;
    public final Paint f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fe(Context context, int i, int i2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 10;
        this.d = true;
        this.f = new Paint();
        this.a = i;
        this.c = i2;
        this.d = true;
        a();
    }

    public final void a() {
        this.f.setAntiAlias(this.d);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(this.c);
        this.e = (this.b / 2) + this.a;
    }

    public final int getStrokeWidth() {
        return this.b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.e;
        canvas.drawCircle(f, f, this.a, this.f);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.a * 2) + this.b;
        setMeasuredDimension(i3, i3);
    }

    public final void setStrokeWidth(int i) {
        this.b = i;
    }
}
