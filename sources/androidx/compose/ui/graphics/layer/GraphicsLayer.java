package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¸\u00012\u00020\u0001:\u0002¸\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u0011J\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0011J<\u0010/\u001a\u00020\f2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\f0*ø\u0001\u0000¢\u0006\u0004\b-\u0010.J!\u00105\u001a\u00020\f2\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\fH\u0000¢\u0006\u0004\b6\u0010\u0011J\u000f\u00109\u001a\u00020\fH\u0000¢\u0006\u0004\b8\u0010\u0011J\u0015\u0010:\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b:\u0010;J.\u0010B\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020<2\b\b\u0002\u0010\u000b\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020>ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ$\u0010D\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020<2\b\b\u0002\u0010\u000b\u001a\u00020=ø\u0001\u0000¢\u0006\u0004\bC\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010HR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010IR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\f0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010Q\u001a\u00020<8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010S\u001a\u00020=8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010\\\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010PR\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR$\u0010g\u001a\u00020N2\u0006\u0010f\u001a\u00020N8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bg\u0010P\u001a\u0004\bg\u0010hR0\u0010\t\u001a\u00020\b2\u0006\u0010i\u001a\u00020\b8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\t\u0010R\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR0\u0010\u000b\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n8\u0006@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u000b\u0010R\u001a\u0004\bn\u0010k\"\u0004\bo\u0010mR0\u0010p\u001a\u00020<2\u0006\u0010i\u001a\u00020<8\u0006@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bp\u0010R\u001a\u0004\bq\u0010k\"\u0004\br\u0010mR*\u0010x\u001a\u00020s2\u0006\u0010i\u001a\u00020s8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010}\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R,\u0010\u0081\u0001\u001a\u00020~2\u0006\u0010i\u001a\u00020~8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\r\u001a\u0004\b\u007f\u0010u\"\u0005\b\u0080\u0001\u0010wR/\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0082\u00012\t\u0010i\u001a\u0005\u0018\u00010\u0082\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010\u008a\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010z\"\u0005\b\u0089\u0001\u0010|R'\u0010\u008d\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010z\"\u0005\b\u008c\u0001\u0010|R'\u0010\u0090\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010z\"\u0005\b\u008f\u0001\u0010|R'\u0010\u0093\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010z\"\u0005\b\u0092\u0001\u0010|R'\u0010\u0096\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010z\"\u0005\b\u0095\u0001\u0010|R'\u0010\u0099\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010z\"\u0005\b\u0098\u0001\u0010|R'\u0010\u009c\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010z\"\u0005\b\u009b\u0001\u0010|R'\u0010\u009f\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010z\"\u0005\b\u009e\u0001\u0010|R'\u0010¢\u0001\u001a\u00020>2\u0006\u0010i\u001a\u00020>8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u0010z\"\u0005\b¡\u0001\u0010|R/\u0010§\u0001\u001a\u00020N2\u0006\u0010i\u001a\u00020N8F@FX\u0086\u000e¢\u0006\u0016\u0012\u0005\b¦\u0001\u0010\u0011\u001a\u0005\b£\u0001\u0010h\"\u0006\b¤\u0001\u0010¥\u0001R/\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010i\u001a\u0005\u0018\u00010¨\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u0014\u0010°\u0001\u001a\u00020V8F¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R/\u0010´\u0001\u001a\u00030±\u00012\u0007\u0010i\u001a\u00030±\u00018F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\u001a\u0005\b²\u0001\u0010k\"\u0005\b³\u0001\u0010mR/\u0010·\u0001\u001a\u00030±\u00012\u0007\u0010i\u001a\u00030±\u00018F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010k\"\u0005\b¶\u0001\u0010m\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "impl", "Landroidx/compose/ui/graphics/layer/LayerManager;", "layerManager", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "Landroidx/compose/ui/unit/IntSize;", "size", "", "setPosition-VbeCjmY", "(JJ)V", "setPosition", "recordInternal", "()V", "graphicsLayer", "addSubLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/graphics/Canvas;", "androidCanvas", "transformCanvas", "(Landroid/graphics/Canvas;)V", "recreateDisplayListIfNeeded", "onAddedToParentLayer", "onRemovedFromParentLayer", "configureOutline", "Landroidx/compose/ui/graphics/Path;", "path", "Landroid/graphics/Outline;", "updatePathOutline", "(Landroidx/compose/ui/graphics/Path;)Landroid/graphics/Outline;", "obtainAndroidOutline", "()Landroid/graphics/Outline;", "discardContentIfReleasedAndHaveNoParentLayerUsages", "resetOutlineParams", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "record", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "parentLayer", "draw$ui_graphics_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "release$ui_graphics_release", "release", "discardDisplayList$ui_graphics_release", "discardDisplayList", "setPathOutline", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", "", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "setRoundRectOutline", "setRectOutline-tz77jQw", "setRectOutline", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/jvm/functions/Function1;", "androidOutline", "Landroid/graphics/Outline;", "", "outlineDirty", "Z", "roundRectOutlineTopLeft", "J", "roundRectOutlineSize", "roundRectCornerRadius", "F", "Landroidx/compose/ui/graphics/Outline;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "Landroidx/compose/ui/graphics/Paint;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "", "parentLayerUsages", "I", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "<set-?>", "isReleased", "()Z", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "getSize-YbymL2g", "setSize-ozmzZPI", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "compositingStrategy", "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "getScaleX", "setScaleX", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getShadowElevation", "setShadowElevation", "shadowElevation", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getRotationZ", "setRotationZ", "rotationZ", "getCameraDistance", "setCameraDistance", "cameraDistance", "getClip", "setClip", "(Z)V", "getClip$annotations", "clip", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "ambientShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "spotShadowColor", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }
    };
    private boolean outlineDirty = true;

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager) {
        this.impl = graphicsLayerImpl;
        Offset.Companion companion = Offset.INSTANCE;
        this.roundRectOutlineTopLeft = companion.m854getZeroF1C5BW0();
        this.roundRectOutlineSize = Size.INSTANCE.m883getUnspecifiedNHjbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m2145getZeronOccac();
        this.size = IntSize.INSTANCE.m2160getZeroYbymL2g();
        this.pivotOffset = companion.m853getUnspecifiedF1C5BW0();
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m1191getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m1197setCompositingStrategyWpw9cng(int i) {
        if (CompositingStrategy.m1184equalsimpl0(this.impl.getCompositingStrategy(), i)) {
            return;
        }
        this.impl.mo1208setCompositingStrategyWpw9cng(i);
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m1202setTopLeftgyyYBs(long j) {
        if (IntOffset.m2137equalsimpl0(this.topLeft, j)) {
            return;
        }
        this.topLeft = j;
        m1188setPositionVbeCjmY(j, this.size);
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m1189setSizeozmzZPI(long j) {
        if (IntSize.m2154equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        m1188setPositionVbeCjmY(this.topLeft, j);
        if (this.roundRectOutlineSize == 9205357640488583168L) {
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() == f) {
            return;
        }
        this.impl.setAlpha(f);
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m1190getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m1198setPivotOffsetk4lQ0M(long j) {
        if (Offset.m839equalsimpl0(this.pivotOffset, j)) {
            return;
        }
        this.pivotOffset = j;
        this.impl.mo1209setPivotOffsetk4lQ0M(j);
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() == f) {
            return;
        }
        this.impl.setScaleX(f);
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() == f) {
            return;
        }
        this.impl.setScaleY(f);
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() == f) {
            return;
        }
        this.impl.setTranslationX(f);
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() == f) {
            return;
        }
        this.impl.setTranslationY(f);
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() == f) {
            return;
        }
        this.impl.setShadowElevation(f);
        this.impl.setClip(getClip() || f > 0.0f);
        this.outlineDirty = true;
        configureOutline();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() == f) {
            return;
        }
        this.impl.setRotationX(f);
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() == f) {
            return;
        }
        this.impl.setRotationY(f);
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() == f) {
            return;
        }
        this.impl.setRotationZ(f);
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() == f) {
            return;
        }
        this.impl.setCameraDistance(f);
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean z) {
        if (this.impl.getClip() != z) {
            this.impl.setClip(z);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        this.impl.getRenderEffect();
        if (Intrinsics.areEqual(null, renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m1188setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo1210setPositionH0pRuoY(IntOffset.m2138getXimpl(topLeft), IntOffset.m2139getYimpl(topLeft), size);
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m1195recordmLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        m1189setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void recordInternal() {
        /*
            r15 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r15.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependency$p(r0, r1)
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r1 == 0) goto L28
            boolean r2 = r1.isNotEmpty()
            if (r2 == 0) goto L28
            androidx.collection.MutableScatterSet r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r2 != 0) goto L22
            androidx.collection.MutableScatterSet r2 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(r0, r2)
        L22:
            r2.addAll(r1)
            r1.clear()
        L28:
            r1 = 1
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r1)
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r1 = r15.impl
            androidx.compose.ui.unit.Density r2 = r15.density
            androidx.compose.ui.unit.LayoutDirection r3 = r15.layoutDirection
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r4 = r15.drawBlock
            r1.record(r2, r3, r15, r4)
            r1 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r1)
            androidx.compose.ui.graphics.layer.GraphicsLayer r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependency$p(r0)
            if (r2 == 0) goto L44
            r2.onRemovedFromParentLayer()
        L44:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r0 == 0) goto L97
            boolean r2 = r0.isNotEmpty()
            if (r2 == 0) goto L97
            java.lang.Object[] r2 = r0.elements
            long[] r3 = r0.metadata
            int r4 = r3.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L94
            r5 = r1
        L5a:
            r6 = r3[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L8f
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r1
        L74:
            if (r10 >= r8) goto L8d
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.32E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L89
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.ui.graphics.layer.GraphicsLayer r11 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r11
            r11.onRemovedFromParentLayer()
        L89:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L74
        L8d:
            if (r8 != r9) goto L94
        L8f:
            if (r5 == r4) goto L94
            int r5 = r5 + 1
            goto L5a
        L94:
            r0.clear()
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.recordInternal():void");
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        float fM2138getXimpl = IntOffset.m2138getXimpl(this.topLeft);
        float fM2139getYimpl = IntOffset.m2139getYimpl(this.topLeft);
        float fM2138getXimpl2 = IntOffset.m2138getXimpl(this.topLeft) + IntSize.m2156getWidthimpl(this.size);
        float fM2139getYimpl2 = IntOffset.m2139getYimpl(this.topLeft) + IntSize.m2155getHeightimpl(this.size);
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int iM1190getBlendMode0nO6VwU = m1190getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m927equalsimpl0(iM1190getBlendMode0nO6VwU, BlendMode.INSTANCE.m957getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m1184equalsimpl0(m1191getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m1187getOffscreenke2Ky5w())) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(alpha);
            Paint.mo908setBlendModes9anfk8(iM1190getBlendMode0nO6VwU);
            Paint.setColorFilter(colorFilter);
            androidCanvas.saveLayer(fM2138getXimpl, fM2139getYimpl, fM2138getXimpl2, fM2139getYimpl2, Paint.getInternalPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas.translate(fM2138getXimpl, fM2139getYimpl);
        androidCanvas.concat(this.impl.calculateMatrix());
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        if (this.isReleased) {
            return;
        }
        recreateDisplayListIfNeeded();
        configureOutline();
        boolean z = true;
        boolean z2 = getShadowElevation() > 0.0f;
        if (z2) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            nativeCanvas.save();
            transformCanvas(nativeCanvas);
        }
        if (!this.usePathForClip && (zIsHardwareAccelerated || !getClip())) {
            z = false;
        }
        if (z) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.m965clipRectmtrdDE$default(canvas, outline.getRect(), 0, 2, null);
            } else if (outline instanceof Outline.Rounded) {
                Path Path = this.roundRectClipPath;
                if (Path != null) {
                    Path.rewind();
                } else {
                    Path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = Path;
                }
                Path.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.m963clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            } else if (outline instanceof Outline.Generic) {
                androidx.compose.ui.graphics.Canvas.m963clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (z) {
            canvas.restore();
        }
        if (z2) {
            canvas.disableZ();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        nativeCanvas.restore();
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        if (this.outlineDirty) {
            if (getClip() || getShadowElevation() > 0.0f) {
                Path path = this.outlinePath;
                if (path != null) {
                    android.graphics.Outline outlineUpdatePathOutline = updatePathOutline(path);
                    outlineUpdatePathOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineUpdatePathOutline);
                } else {
                    android.graphics.Outline outlineObtainAndroidOutline = obtainAndroidOutline();
                    long jM2162toSizeozmzZPI = IntSizeKt.m2162toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    if (j2 != 9205357640488583168L) {
                        jM2162toSizeozmzZPI = j2;
                    }
                    outlineObtainAndroidOutline.setRoundRect(Math.round(Offset.m842getXimpl(j)), Math.round(Offset.m843getYimpl(j)), Math.round(Offset.m842getXimpl(j) + Size.m878getWidthimpl(jM2162toSizeozmzZPI)), Math.round(Offset.m843getYimpl(j) + Size.m876getHeightimpl(jM2162toSizeozmzZPI)), this.roundRectCornerRadius);
                    outlineObtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineObtainAndroidOutline);
                }
            } else {
                this.impl.setOutline(null);
            }
        }
        this.outlineDirty = false;
    }

    private final android.graphics.Outline updatePathOutline(Path path) {
        android.graphics.Outline outlineObtainAndroidOutline = obtainAndroidOutline();
        int i = Build.VERSION.SDK_INT;
        if (i > 28 || path.isConvex()) {
            if (i <= 30) {
                if (!(path instanceof AndroidPath)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outlineObtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                OutlineVerificationHelper.INSTANCE.setPath(outlineObtainAndroidOutline, path);
            }
            this.usePathForClip = !outlineObtainAndroidOutline.canClip();
        } else {
            android.graphics.Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return outlineObtainAndroidOutline;
    }

    private final android.graphics.Outline obtainAndroidOutline() {
        android.graphics.Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        android.graphics.Outline outline2 = new android.graphics.Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            discardDisplayList$ui_graphics_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void discardDisplayList$ui_graphics_release() {
        /*
            r15 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r15.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            if (r1 == 0) goto Lf
            r1.onRemovedFromParentLayer()
            r1 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setDependency$p(r0, r1)
        Lf:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r0 == 0) goto L5d
            java.lang.Object[] r1 = r0.elements
            long[] r2 = r0.metadata
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5a
            r4 = 0
            r5 = r4
        L20:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L55
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L3a:
            if (r10 >= r8) goto L53
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.32E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4f
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            androidx.compose.ui.graphics.layer.GraphicsLayer r11 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r11
            r11.onRemovedFromParentLayer()
        L4f:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L3a
        L53:
            if (r8 != r9) goto L5a
        L55:
            if (r5 == r3) goto L5a
            int r5 = r5 + 1
            goto L20
        L5a:
            r0.clear()
        L5d:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r0 = r15.impl
            r0.discardDisplayList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.discardDisplayList$ui_graphics_release():void");
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path == null) {
            long jM2162toSizeozmzZPI = IntSizeKt.m2162toSizeozmzZPI(this.size);
            long j = this.roundRectOutlineTopLeft;
            long j2 = this.roundRectOutlineSize;
            if (j2 != 9205357640488583168L) {
                jM2162toSizeozmzZPI = j2;
            }
            float fM842getXimpl = Offset.m842getXimpl(j);
            float fM843getYimpl = Offset.m843getYimpl(j);
            float fM878getWidthimpl = fM842getXimpl + Size.m878getWidthimpl(jM2162toSizeozmzZPI);
            float fM876getHeightimpl = fM843getYimpl + Size.m876getHeightimpl(jM2162toSizeozmzZPI);
            float f = this.roundRectCornerRadius;
            if (f > 0.0f) {
                rectangle = new Outline.Rounded(RoundRectKt.m871RoundRectgG7oq9Y(fM842getXimpl, fM843getYimpl, fM878getWidthimpl, fM876getHeightimpl, CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null)));
            } else {
                rectangle = new Outline.Rectangle(new Rect(fM842getXimpl, fM843getYimpl, fM878getWidthimpl, fM876getHeightimpl));
            }
            this.internalOutline = rectangle;
            return rectangle;
        }
        Outline.Generic generic = new Outline.Generic(path);
        this.internalOutline = generic;
        return generic;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m883getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m854getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m1200setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m839equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m875equalsimpl0(this.roundRectOutlineSize, size) && this.roundRectCornerRadius == cornerRadius && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutline();
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m1199setRectOutlinetz77jQw(long topLeft, long size) {
        m1200setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m1196setAmbientShadowColor8_81llA(long j) {
        if (Color.m977equalsimpl0(j, this.impl.getAmbientShadowColor())) {
            return;
        }
        this.impl.mo1207setAmbientShadowColor8_81llA(j);
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m1201setSpotShadowColor8_81llA(long j) {
        if (Color.m977equalsimpl0(j, this.impl.getSpotShadowColor())) {
            return;
        }
        this.impl.mo1211setSpotShadowColor8_81llA(j);
    }

    static {
        LayerSnapshotImpl layerSnapshotImpl;
        if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotImpl = LayerSnapshotV28.INSTANCE;
        } else if (SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotImpl = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotImpl = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotImpl;
    }
}
