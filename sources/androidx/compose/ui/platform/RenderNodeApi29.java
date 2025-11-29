package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.foundation.DrawStretchOverscrollModifier$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RenderNodeApi29.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J5\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010\r\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00107R\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00107R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00107R\u0014\u0010<\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00107R\u0014\u0010>\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u00107R$\u0010E\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010H\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR$\u0010K\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR$\u0010N\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR$\u0010Q\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bO\u0010B\"\u0004\bP\u0010DR$\u0010T\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bR\u00107\"\u0004\bS\u0010\u0015R$\u0010W\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u00107\"\u0004\bV\u0010\u0015R$\u0010Z\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010B\"\u0004\bY\u0010DR$\u0010]\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010DR$\u0010`\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010B\"\u0004\b_\u0010DR$\u0010c\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\ba\u0010B\"\u0004\bb\u0010DR$\u0010f\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bd\u0010B\"\u0004\be\u0010DR$\u0010i\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010B\"\u0004\bh\u0010DR$\u0010n\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010q\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bo\u0010k\"\u0004\bp\u0010mR$\u0010t\u001a\u00020?2\u0006\u0010@\u001a\u00020?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010B\"\u0004\bs\u0010DR(\u0010z\u001a\u0004\u0018\u00010u2\b\u0010@\u001a\u0004\u0018\u00010u8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR*\u0010}\u001a\u0002032\u0006\u0010@\u001a\u0002038V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b{\u00107\"\u0004\b|\u0010\u0015R\u0014\u0010\u007f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b~\u0010k\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "Landroid/graphics/Outline;", "outline", "", "setOutline", "(Landroid/graphics/Outline;)V", "", "left", "top", "right", "bottom", "", "setPosition", "(IIII)Z", "offset", "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "hasOverlappingRendering", "setHasOverlappingRendering", "(Z)Z", "discardDisplayList", "()V", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/graphics/RenderNode;", "renderNode", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "internalCompositingStrategy", "I", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToOutline", "getClipToBounds", "setClipToBounds", "clipToBounds", "getAlpha", "setAlpha", "alpha", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "compositingStrategy", "getHasDisplayList", "hasDisplayList", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeApi29 implements DeviceRenderNode {
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode = DrawStretchOverscrollModifier$$ExternalSyntheticApiModelOutline0.m("Compose");
    private int internalCompositingStrategy = CompositingStrategy.INSTANCE.m1002getAutoNrFUSI();

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.renderNode.getLeft();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.renderNode.getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.renderNode.getRight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.renderNode.getBottom();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return this.renderNode.getWidth();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return this.renderNode.getHeight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i) {
        this.renderNode.setAmbientShadowColor(i);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int i) {
        this.renderNode.setSpotShadowColor(i);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationZ(float f) {
        this.renderNode.setRotationZ(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z) {
        this.renderNode.setClipToBounds(z);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect renderEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public void mo1613setCompositingStrategyaDBOjCE(int i) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m999equalsimpl0(i, companion.m1004getOffscreenNrFUSI())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m999equalsimpl0(i, companion.m1003getModulateAlphaNrFUSI())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setPosition(int left, int top, int right, int bottom) {
        return this.renderNode.setPosition(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super Canvas, Unit> drawBlock) {
        RecordingCanvas recordingCanvasBeginRecording = this.renderNode.beginRecording();
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(recordingCanvasBeginRecording);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (clipPath != null) {
            androidCanvas.save();
            Canvas.m963clipPathmtrdDE$default(androidCanvas, clipPath, 0, 2, null);
        }
        drawBlock.invoke(androidCanvas);
        if (clipPath != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(android.graphics.Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        return this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }
}
