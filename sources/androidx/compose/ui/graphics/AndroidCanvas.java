package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidCanvas.android.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ:\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\"\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0014\u0010.\u001a\u00020+*\u00020!ø\u0001\u0000¢\u0006\u0004\b,\u0010-J*\u00104\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J7\u00105\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u00106JG\u00109\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010:J*\u0010?\u001a\u00020\u00042\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>JO\u0010D\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\r2\u0006\u0010C\u001a\u00020B2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bF\u0010GJ*\u0010M\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020/2\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJB\u0010V\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020P2\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u000f\u0010W\u001a\u00020\u0004H\u0016¢\u0006\u0004\bW\u0010\u0003J\u000f\u0010X\u001a\u00020\u0004H\u0016¢\u0006\u0004\bX\u0010\u0003R,\u0010[\u001a\u00060Yj\u0002`Z8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b[\u0010\\\u0012\u0004\ba\u0010\u0003\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "", "save", "restore", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroidx/compose/ui/graphics/Paint;", "paint", "saveLayer", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Paint;)V", "", "dx", "dy", "translate", "(FF)V", "sx", "sy", "scale", "degrees", FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "(F)V", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "concat-58bKbWc", "([F)V", "concat", "left", "top", "right", "bottom", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-N_I0leg", "(FFFFI)V", "clipRect", "Landroidx/compose/ui/graphics/Path;", "path", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipPath", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "toRegionOp", "Landroidx/compose/ui/geometry/Offset;", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "drawRect", "(FFFFLandroidx/compose/ui/graphics/Paint;)V", "radiusX", "radiusY", "drawRoundRect", "(FFFFFFLandroidx/compose/ui/graphics/Paint;)V", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawCircle", "startAngle", "sweepAngle", "", "useCenter", "drawArc", "(FFFFFFZLandroidx/compose/ui/graphics/Paint;)V", "drawPath", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Paint;)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "enableZ", "disableZ", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "internalCanvas", "Landroid/graphics/Canvas;", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "getInternalCanvas$annotations", "Landroid/graphics/Rect;", "srcRect", "Landroid/graphics/Rect;", "dstRect", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidCanvas implements Canvas {
    private Rect dstRect;
    private android.graphics.Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private Rect srcRect;

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(androidx.compose.ui.geometry.Rect bounds, Paint paint) {
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float dx, float dy) {
        this.internalCanvas.translate(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float sx, float sy) {
        this.internalCanvas.scale(sx, sy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float degrees) {
        this.internalCanvas.rotate(degrees);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo891concat58bKbWc(float[] matrix) {
        if (MatrixKt.m1049isIdentity58bKbWc(matrix)) {
            return;
        }
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m901setFromEL8BTi8(matrix2, matrix);
        this.internalCanvas.concat(matrix2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo890clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
        this.internalCanvas.clipRect(left, top, right, bottom, m896toRegionOp7u2Bmg(clipOp));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo889clipPathmtrdDE(Path path, int clipOp) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m896toRegionOp7u2Bmg(clipOp));
    }

    /* renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m896toRegionOp7u2Bmg(int i) {
        return ClipOp.m968equalsimpl0(i, ClipOp.INSTANCE.m969getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo895drawLineWko1d7g(long p1, long p2, Paint paint) {
        this.internalCanvas.drawLine(Offset.m842getXimpl(p1), Offset.m843getYimpl(p1), Offset.m842getXimpl(p2), Offset.m843getYimpl(p2), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        this.internalCanvas.drawRect(left, top, right, bottom, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint) {
        this.internalCanvas.drawRoundRect(left, top, right, bottom, radiusX, radiusY, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo892drawCircle9KIMszo(long center, float radius, Paint paint) {
        this.internalCanvas.drawCircle(Offset.m842getXimpl(center), Offset.m843getYimpl(center), radius, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        this.internalCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo893drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.m842getXimpl(topLeftOffset), Offset.m843getYimpl(topLeftOffset), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo894drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint) {
        if (this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap bitmapAsAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        Rect rect = this.srcRect;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.m2138getXimpl(srcOffset);
        rect.top = IntOffset.m2139getYimpl(srcOffset);
        rect.right = IntOffset.m2138getXimpl(srcOffset) + IntSize.m2156getWidthimpl(srcSize);
        rect.bottom = IntOffset.m2139getYimpl(srcOffset) + IntSize.m2155getHeightimpl(srcSize);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.m2138getXimpl(dstOffset);
        rect2.top = IntOffset.m2139getYimpl(dstOffset);
        rect2.right = IntOffset.m2138getXimpl(dstOffset) + IntSize.m2156getWidthimpl(dstSize);
        rect2.bottom = IntOffset.m2139getYimpl(dstOffset) + IntSize.m2155getHeightimpl(dstSize);
        canvas.drawBitmap(bitmapAsAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }
}
