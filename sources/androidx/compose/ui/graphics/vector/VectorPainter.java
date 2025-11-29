package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R1\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R+\u0010.\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020'8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R(\u0010:\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010=\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00138@@@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR$\u0010C\u001a\u00020>2\u0006\u00105\u001a\u00020>8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010E\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bD\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "root", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "", "alpha", "", "applyAlpha", "(F)Z", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "size$delegate", "Landroidx/compose/runtime/MutableState;", "getSize-NH-jbRc$ui_release", "()J", "setSize-uvyYCjk$ui_release", "(J)V", "size", "autoMirror$delegate", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "getInvalidateCount", "()I", "setInvalidateCount", "(I)V", "invalidateCount", "currentAlpha", "F", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawCount", "I", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "viewportSize", "", "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", AppMeasurementSdk.ConditionalUserProperty.NAME, "getIntrinsicSize-NH-jbRc", "intrinsicSize", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorPainter extends Painter {

    /* renamed from: autoMirror$delegate, reason: from kotlin metadata */
    private final MutableState autoMirror;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private int drawCount;

    /* renamed from: invalidateCount$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateCount;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size;
    private final VectorComponent vector;

    public VectorPainter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VectorPainter(GroupComponent groupComponent) {
        this.size = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m872boximpl(Size.INSTANCE.m884getZeroNHjbRc()), null, 2, null);
        this.autoMirror = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.setInvalidateCallback$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.drawCount == this.this$0.getInvalidateCount()) {
                    VectorPainter vectorPainter = this.this$0;
                    vectorPainter.setInvalidateCount(vectorPainter.getInvalidateCount() + 1);
                }
            }
        });
        this.vector = vectorComponent;
        this.invalidateCount = SnapshotIntStateKt.mutableIntStateOf(0);
        this.currentAlpha = 1.0f;
        this.drawCount = -1;
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GroupComponent() : groupComponent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m1233getSizeNHjbRc$ui_release() {
        return ((Size) this.size.getValue()).getPackedValue();
    }

    /* renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1234setSizeuvyYCjk$ui_release(long j) {
        this.size.setValue(Size.m872boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror.getValue()).booleanValue();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror.setValue(Boolean.valueOf(z));
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1235setViewportSizeuvyYCjk$ui_release(long j) {
        this.vector.m1231setViewportSizeuvyYCjk$ui_release(j);
    }

    public final void setName$ui_release(String str) {
        this.vector.setName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInvalidateCount() {
        return this.invalidateCount.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateCount(int i) {
        this.invalidateCount.setIntValue(i);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1216getIntrinsicSizeNHjbRc() {
        return m1233getSizeNHjbRc$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(DrawScope drawScope) {
        VectorComponent vectorComponent = this.vector;
        ColorFilter intrinsicColorFilter$ui_release = this.currentColorFilter;
        if (intrinsicColorFilter$ui_release == null) {
            intrinsicColorFilter$ui_release = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (getAutoMirror$ui_release() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long jMo1175getCenterF1C5BW0 = drawScope.mo1175getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo1157getSizeNHjbRc = drawContext.mo1157getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo1163scale0AR0LA0(-1.0f, 1.0f, jMo1175getCenterF1C5BW0);
                vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo1158setSizeuvyYCjk(jMo1157getSizeNHjbRc);
            }
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
        }
        this.drawCount = getInvalidateCount();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }
}
