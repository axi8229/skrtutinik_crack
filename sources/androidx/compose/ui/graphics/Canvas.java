package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;

/* compiled from: Canvas.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J<\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000¢\u0006\u0004\b&\u0010'J$\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u00102\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u000bJ7\u00103\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b3\u00104JG\u00107\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b7\u00108J*\u0010=\u001a\u00020\u00022\u0006\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b;\u0010<JO\u0010B\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010A\u001a\u00020@2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\bD\u0010EJ*\u0010K\u001a\u00020\u00022\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\bI\u0010JJJ\u0010T\u001a\u00020\u00022\u0006\u0010G\u001a\u00020F2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020N2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u000f\u0010U\u001a\u00020\u0002H&¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\u0002H&¢\u0006\u0004\bV\u0010\u0004ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006WÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Canvas;", "", "", "save", "()V", "restore", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroidx/compose/ui/graphics/Paint;", "paint", "saveLayer", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Paint;)V", "", "dx", "dy", "translate", "(FF)V", "sx", "sy", "scale", "degrees", FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "(F)V", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "concat-58bKbWc", "([F)V", "concat", "rect", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "clipRect", "left", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "Landroidx/compose/ui/graphics/Path;", "path", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipPath", "Landroidx/compose/ui/geometry/Offset;", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "drawRect", "(FFFFLandroidx/compose/ui/graphics/Paint;)V", "radiusX", "radiusY", "drawRoundRect", "(FFFFFFLandroidx/compose/ui/graphics/Paint;)V", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawCircle", "startAngle", "sweepAngle", "", "useCenter", "drawArc", "(FFFFFFZLandroidx/compose/ui/graphics/Paint;)V", "drawPath", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Paint;)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "enableZ", "disableZ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Canvas {
    /* renamed from: clipPath-mtrdD-E */
    void mo889clipPathmtrdDE(Path path, int clipOp);

    /* renamed from: clipRect-N_I0leg */
    void mo890clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* renamed from: concat-58bKbWc */
    void mo891concat58bKbWc(float[] matrix);

    void disableZ();

    void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint);

    /* renamed from: drawCircle-9KIMszo */
    void mo892drawCircle9KIMszo(long center, float radius, Paint paint);

    /* renamed from: drawImage-d-4ec7I */
    void mo893drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint);

    /* renamed from: drawImageRect-HPBpro0 */
    void mo894drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint);

    /* renamed from: drawLine-Wko1d7g */
    void mo895drawLineWko1d7g(long p1, long p2, Paint paint);

    void drawPath(Path path, Paint paint);

    void drawRect(float left, float top, float right, float bottom, Paint paint);

    void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint);

    void enableZ();

    void restore();

    void rotate(float degrees);

    void save();

    void saveLayer(Rect bounds, Paint paint);

    void scale(float sx, float sy);

    void translate(float dx, float dy);

    /* renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m965clipRectmtrdDE$default(Canvas canvas, Rect rect, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m970getIntersectrtfAjoo();
        }
        canvas.m966clipRectmtrdDE(rect, i);
    }

    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m966clipRectmtrdDE(Rect rect, int clipOp) {
        mo890clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), clipOp);
    }

    /* renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m964clipRectN_I0leg$default(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m970getIntersectrtfAjoo();
        }
        canvas.mo890clipRectN_I0leg(f, f2, f3, f4, i);
    }

    /* renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m963clipPathmtrdDE$default(Canvas canvas, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m970getIntersectrtfAjoo();
        }
        canvas.mo889clipPathmtrdDE(path, i);
    }

    default void drawRect(Rect rect, Paint paint) {
        drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }
}
