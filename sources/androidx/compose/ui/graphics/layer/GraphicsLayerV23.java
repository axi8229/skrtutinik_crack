package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerV23.android.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010#\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010&\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J;\u00101\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000e0.H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0016J\u000f\u0010<\u001a\u00020\u000eH\u0000¢\u0006\u0004\b;\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010@R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010AR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010BR\u001c\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010=R\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR0\u0010\r\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010\u0010R0\u0010P\u001a\u00020O2\u0006\u0010J\u001a\u00020O8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010\u0010R.\u0010T\u001a\u0004\u0018\u00010S2\b\u0010J\u001a\u0004\u0018\u00010S8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010[\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010IR0\u0010c\u001a\u00020b2\u0006\u0010J\u001a\u00020b8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bc\u0010=\u001a\u0004\bd\u0010?\"\u0004\be\u0010fR*\u0010g\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bg\u0010\\\u001a\u0004\bh\u0010^\"\u0004\bi\u0010`R*\u0010j\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010\\\u001a\u0004\bk\u0010^\"\u0004\bl\u0010`R*\u0010m\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bm\u0010\\\u001a\u0004\bn\u0010^\"\u0004\bo\u0010`R*\u0010p\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010\\\u001a\u0004\bq\u0010^\"\u0004\br\u0010`R*\u0010s\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bs\u0010\\\u001a\u0004\bt\u0010^\"\u0004\bu\u0010`R0\u0010w\u001a\u00020v2\u0006\u0010J\u001a\u00020v8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bw\u0010=\u001a\u0004\bx\u0010?\"\u0004\by\u0010fR0\u0010z\u001a\u00020v2\u0006\u0010J\u001a\u00020v8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bz\u0010=\u001a\u0004\b{\u0010?\"\u0004\b|\u0010fR*\u0010}\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b}\u0010\\\u001a\u0004\b~\u0010^\"\u0004\b\u007f\u0010`R.\u0010\u0080\u0001\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010\\\u001a\u0005\b\u0081\u0001\u0010^\"\u0005\b\u0082\u0001\u0010`R.\u0010\u0083\u0001\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\\\u001a\u0005\b\u0084\u0001\u0010^\"\u0005\b\u0085\u0001\u0010`R.\u0010\u0086\u0001\u001a\u00020Z2\u0006\u0010J\u001a\u00020Z8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010\\\u001a\u0005\b\u0087\u0001\u0010^\"\u0005\b\u0088\u0001\u0010`R/\u0010\u0089\u0001\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u00128\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\b\u0089\u0001\u0010I\u001a\u0005\b\u008a\u0001\u0010\u0014\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010IR\u0018\u0010\u008e\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010IR'\u0010\u008f\u0001\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b\u008f\u0001\u0010I\u001a\u0005\b\u008f\u0001\u0010\u0014\"\u0006\b\u0090\u0001\u0010\u008c\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010\u0099\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009b\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroid/view/View;", "ownerView", "", "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "", "applyCompositingStrategy-Wpw9cng", "(I)V", "applyCompositingStrategy", "", "requiresCompositingLayer", "()Z", "updateLayerProperties", "()V", "applyClip", "Landroid/view/RenderNode;", "renderNode", "verifyShadowColorProperties", "(Landroid/view/RenderNode;)V", "", "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "setOutline", "(Landroid/graphics/Outline;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "discardDisplayListInternal$ui_graphics_release", "discardDisplayListInternal", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroid/view/RenderNode;", "Landroid/graphics/Paint;", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "Z", AppMeasurementSdk.ConditionalUserProperty.VALUE, "I", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "", "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "isInvalidated", "setInvalidated", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getHasDisplayList", "hasDisplayList", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    private static boolean testFailCreateRenderNode;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private final long ownerId;
    private long pivotOffset;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
    }

    public GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = j;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode renderNodeCreate = RenderNode.create("Compose", view);
        this.renderNode = renderNodeCreate;
        this.size = IntSize.INSTANCE.m2160getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            verifyShadowColorProperties(renderNodeCreate);
            discardDisplayListInternal$ui_graphics_release();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
        renderNodeCreate.setClipToBounds(false);
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        m1212applyCompositingStrategyWpw9cng(companion.m1185getAutoke2Ky5w());
        this.compositingStrategy = companion.m1185getAutoke2Ky5w();
        this.blendMode = BlendMode.INSTANCE.m957getSrcOver0nO6VwU();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m853getUnspecifiedF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        Color.Companion companion2 = Color.INSTANCE;
        this.ambientShadowColor = companion2.m986getBlack0d7_KjU();
        this.spotShadowColor = companion2.m986getBlack0d7_KjU();
        this.cameraDistance = 8.0f;
        this.isInvalidated = true;
    }

    public /* synthetic */ GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j, (i & 4) != 0 ? new CanvasHolder() : canvasHolder, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setCompositingStrategy-Wpw9cng */
    public void mo1208setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    /* renamed from: applyCompositingStrategy-Wpw9cng, reason: not valid java name */
    private final void m1212applyCompositingStrategyWpw9cng(int compositingStrategy) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m1184equalsimpl0(compositingStrategy, companion.m1187getOffscreenke2Ky5w())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m1184equalsimpl0(compositingStrategy, companion.m1186getModulateAlphake2Ky5w())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    private final boolean requiresCompositingLayer() {
        return (!CompositingStrategy.m1184equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m1187getOffscreenke2Ky5w()) && BlendMode.m927equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m957getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m1212applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m1187getOffscreenke2Ky5w());
        } else {
            m1212applyCompositingStrategyWpw9cng(getCompositingStrategy());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f) {
        this.alpha = f;
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo1209setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        if (OffsetKt.m857isUnspecifiedk4lQ0M(j)) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX(IntSize.m2156getWidthimpl(this.size) / 2.0f);
            this.renderNode.setPivotY(IntSize.m2155getHeightimpl(this.size) / 2.0f);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.renderNode.setPivotX(Offset.m842getXimpl(j));
            this.renderNode.setPivotY(Offset.m843getYimpl(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f) {
        this.scaleX = f;
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f) {
        this.scaleY = f;
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f) {
        this.translationX = f;
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f) {
        this.translationY = f;
        this.renderNode.setTranslationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo1207setAmbientShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j;
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.m996toArgb8_81llA(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo1211setSpotShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j;
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.m996toArgb8_81llA(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f) {
        this.rotationX = f;
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f) {
        this.rotationY = f;
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.renderNode.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z) {
        this.clip = z;
        applyClip();
    }

    private final void applyClip() {
        boolean z = false;
        boolean z2 = getClip() && !this.outlineIsProvided;
        if (getClip() && this.outlineIsProvided) {
            z = true;
        }
        if (z2 != this.clipToBounds) {
            this.clipToBounds = z2;
            this.renderNode.setClipToBounds(z2);
        }
        if (z != this.clipToOutline) {
            this.clipToOutline = z;
            this.renderNode.setClipToOutline(z);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo1210setPositionH0pRuoY(int x, int y, long size) {
        this.renderNode.setLeftTopRightBottom(x, y, IntSize.m2156getWidthimpl(size) + x, IntSize.m2155getHeightimpl(size) + y);
        if (IntSize.m2154equalsimpl0(this.size, size)) {
            return;
        }
        if (this.shouldManuallySetCenterPivot) {
            this.renderNode.setPivotX(IntSize.m2156getWidthimpl(size) / 2.0f);
            this.renderNode.setPivotY(IntSize.m2155getHeightimpl(size) / 2.0f);
        }
        this.size = size;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block) {
        Canvas canvasStart = this.renderNode.start(IntSize.m2156getWidthimpl(this.size), IntSize.m2155getHeightimpl(this.size));
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvasStart);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
            long jM2162toSizeozmzZPI = IntSizeKt.m2162toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas = canvasDrawScope.getDrawContext().getCanvas();
            long jMo1157getSizeNHjbRc = canvasDrawScope.getDrawContext().mo1157getSizeNHjbRc();
            GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(androidCanvas);
            drawContext.mo1158setSizeuvyYCjk(jM2162toSizeozmzZPI);
            drawContext.setGraphicsLayer(layer);
            androidCanvas.save();
            try {
                block.invoke(canvasDrawScope);
                androidCanvas.restore();
                DrawContext drawContext2 = canvasDrawScope.getDrawContext();
                drawContext2.setDensity(density2);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo1158setSizeuvyYCjk(jMo1157getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
                this.renderNode.end(canvasStart);
                setInvalidated(false);
            } catch (Throwable th) {
                androidCanvas.restore();
                DrawContext drawContext3 = canvasDrawScope.getDrawContext();
                drawContext3.setDensity(density2);
                drawContext3.setLayoutDirection(layoutDirection2);
                drawContext3.setCanvas(canvas);
                drawContext3.mo1158setSizeuvyYCjk(jMo1157getSizeNHjbRc);
                drawContext3.setGraphicsLayer(graphicsLayer);
                throw th;
            }
        } catch (Throwable th2) {
            this.renderNode.end(canvasStart);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix = this.matrix;
        if (matrix == null) {
            matrix = new Matrix();
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        discardDisplayListInternal$ui_graphics_release();
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
        }
    }

    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }
}
