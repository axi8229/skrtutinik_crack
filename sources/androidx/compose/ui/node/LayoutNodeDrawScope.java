package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006Jq\u0010\u001c\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJY\u0010!\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JO\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%Jw\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020)2\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010.\u001a\u00020-H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100Jk\u0010<\u001a\u00020\u00192\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00107\u001a\u0002062\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\b\b\u0003\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;JM\u0010A\u001a\u00020\u00192\u0006\u0010>\u001a\u00020=2\u0006\u00102\u001a\u0002012\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@JM\u0010A\u001a\u00020\u00192\u0006\u0010>\u001a\u00020=2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJY\u0010F\u001a\u00020\u00192\u0006\u00102\u001a\u0002012\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJY\u0010F\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJc\u0010M\u001a\u00020\u00192\u0006\u00102\u001a\u0002012\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010J\u001a\u00020I2\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJc\u0010M\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010J\u001a\u00020I2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0017\u0010T\u001a\u00020Q*\u00020PH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u0017\u0010X\u001a\u00020P*\u00020UH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010X\u001a\u00020P*\u00020\tH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010X\u001a\u00020P*\u00020QH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010[J\u0017\u0010_\u001a\u00020\\*\u00020\u0010H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0017\u0010a\u001a\u00020\t*\u00020PH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010ZJ\u0017\u0010a\u001a\u00020\t*\u00020UH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010WJ\u0017\u0010d\u001a\u00020\u0010*\u00020\\H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010^J\u0017\u0010g\u001a\u00020U*\u00020PH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJ\u001a\u0010g\u001a\u00020U*\u00020\tH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010fJ\u000f\u0010i\u001a\u00020\u0019H\u0016¢\u0006\u0004\bi\u0010jJ#\u0010p\u001a\u00020\u0019*\u00020k2\u0006\u0010m\u001a\u00020l2\b\u0010o\u001a\u0004\u0018\u00010n¢\u0006\u0004\bp\u0010qJ<\u0010x\u001a\u00020\u00192\u0006\u0010m\u001a\u00020l2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010s\u001a\u00020r2\u0006\u0010u\u001a\u00020t2\b\u0010o\u001a\u0004\u0018\u00010nH\u0000ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ<\u0010{\u001a\u00020\u00192\u0006\u0010m\u001a\u00020l2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010s\u001a\u00020r2\u0006\u0010u\u001a\u00020k2\b\u0010o\u001a\u0004\u0018\u00010nH\u0000ø\u0001\u0000¢\u0006\u0004\by\u0010zR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010|\u001a\u0004\b}\u0010~R\u0018\u0010u\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010\u007fR\u001c\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0084\u0001\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u008a\u0001\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u0083\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0011\u001a\u00020\u00108VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0081\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0090\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "", "startAngle", "sweepAngle", "", "useCenter", "Landroidx/compose/ui/geometry/Offset;", "topLeft", "Landroidx/compose/ui/geometry/Size;", "size", "alpha", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc", "radius", "center", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "start", "end", "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "Landroidx/compose/ui/graphics/Path;", "path", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/unit/Dp;", "", "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", "drawContent", "()V", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "performDraw", "(Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "Landroidx/compose/ui/Modifier$Node;", "drawNode", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawDirect", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/node/DrawModifierNode;", "getCenter-F1C5BW0", "()J", "getDensity", "()F", "density", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "getFontScale", "fontScale", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getSize-NH-jbRc", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public void mo1143drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1143drawArcyD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo1144drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1144drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo1145drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo1145drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo1146drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1146drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo1147drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1147drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo1148drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1148drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo1149drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1149drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo1150drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1150drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo1151drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1151drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo1152drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1152drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo1153drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1153drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo1175getCenterF1C5BW0() {
        return this.canvasDrawScope.mo1175getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo1176getSizeNHjbRc() {
        return this.canvasDrawScope.mo1176getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo248roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo248roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo249toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo249toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo250toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo250toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo251toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo251toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo252toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo252toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo253toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo253toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo254toPx0680j_4(float f) {
        return this.canvasDrawScope.mo254toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo255toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo255toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo256toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo256toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo257toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo257toSpkPz2Gy4(f);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m1490draweZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode, GraphicsLayer layer) {
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(4);
        DelegatingNode delegatingNodePop = drawNode;
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (delegatingNodePop instanceof DrawModifierNode) {
                m1491drawDirecteZhPAX0$ui_release(canvas, size, coordinator, delegatingNodePop, layer);
            } else if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodePop.getDelegate();
                int i = 0;
                delegatingNodePop = delegatingNodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodePop != 0) {
                                mutableVector.add(delegatingNodePop);
                                delegatingNodePop = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodePop = delegatingNodePop;
                }
                if (i == 1) {
                }
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinatorM1466requireCoordinator64DMado = DelegatableNodeKt.m1466requireCoordinator64DMado(drawModifierNode, NodeKind.m1552constructorimpl(4));
        nodeCoordinatorM1466requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m1491drawDirecteZhPAX0$ui_release(canvas, IntSizeKt.m2162toSizeozmzZPI(nodeCoordinatorM1466requireCoordinator64DMado.mo1422getSizeYbymL2g()), nodeCoordinatorM1466requireCoordinator64DMado, drawModifierNode, graphicsLayer);
    }

    /* renamed from: drawDirect-eZhPAX0$ui_release, reason: not valid java name */
    public final void m1491drawDirecteZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode, GraphicsLayer layer) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        Density density = canvasDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
        long jMo1157getSizeNHjbRc = canvasDrawScope.getDrawContext().mo1157getSizeNHjbRc();
        GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = canvasDrawScope.getDrawContext();
        drawContext.setDensity(coordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo1158setSizeuvyYCjk(size);
        drawContext.setGraphicsLayer(layer);
        canvas.save();
        try {
            drawNode.draw(this);
            canvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo1158setSizeuvyYCjk(jMo1157getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            this.drawNode = drawModifierNode;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.mo1158setSizeuvyYCjk(jMo1157getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        DelegatingNode delegatingNodeNextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (delegatingNodeNextDrawNode == 0) {
            NodeCoordinator nodeCoordinatorM1466requireCoordinator64DMado = DelegatableNodeKt.m1466requireCoordinator64DMado(drawModifierNode, NodeKind.m1552constructorimpl(4));
            if (nodeCoordinatorM1466requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                nodeCoordinatorM1466requireCoordinator64DMado = nodeCoordinatorM1466requireCoordinator64DMado.getWrapped();
                Intrinsics.checkNotNull(nodeCoordinatorM1466requireCoordinator64DMado);
            }
            nodeCoordinatorM1466requireCoordinator64DMado.performDraw(canvas, getDrawContext().getGraphicsLayer());
            return;
        }
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(4);
        MutableVector mutableVector = null;
        while (delegatingNodeNextDrawNode != 0) {
            if (delegatingNodeNextDrawNode instanceof DrawModifierNode) {
                performDraw((DrawModifierNode) delegatingNodeNextDrawNode, canvas, getDrawContext().getGraphicsLayer());
            } else if ((delegatingNodeNextDrawNode.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodeNextDrawNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodeNextDrawNode.getDelegate();
                int i = 0;
                delegatingNodeNextDrawNode = delegatingNodeNextDrawNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodeNextDrawNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodeNextDrawNode != 0) {
                                mutableVector.add(delegatingNodeNextDrawNode);
                                delegatingNodeNextDrawNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodeNextDrawNode = delegatingNodeNextDrawNode;
                }
                if (i == 1) {
                }
            }
            delegatingNodeNextDrawNode = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
