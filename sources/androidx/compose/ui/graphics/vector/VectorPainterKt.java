package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\f\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a$\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aD\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010!\u001a\u00020 H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a'\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010-\u001a\u00020'*\u00020'2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "image", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "rememberVectorPainter", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Dp;", "defaultWidth", "defaultHeight", "Landroidx/compose/ui/geometry/Size;", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "obtainSizePx", "defaultSize", "", "viewportWidth", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "obtainViewportSize", "Landroidx/compose/ui/graphics/Color;", "tintColor", "Landroidx/compose/ui/graphics/BlendMode;", "tintBlendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter", "viewportSize", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "intrinsicColorFilter", "", "autoMirror", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "density", "imageVector", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "root", "createVectorPainterFromImageVector", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/GroupComponent;)Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "currentGroup", "createGroupComponent", "(Landroidx/compose/ui/graphics/vector/GroupComponent;Landroidx/compose/ui/graphics/vector/VectorGroup;)Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorPainterKt {
    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        float genId = imageVector.getGenId();
        float density2 = density.getDensity();
        boolean zChanged = composer.changed((Float.floatToRawIntBits(density2) & 4294967295L) | (Float.floatToRawIntBits(genId) << 32));
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            objRememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(objRememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }

    /* renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m1238obtainSizePxVpY3zN4(Density density, float f, float f2) {
        return SizeKt.Size(density.mo254toPx0680j_4(f), density.mo254toPx0680j_4(f2));
    }

    /* renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m1239obtainViewportSizePq9zytI(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Size.m878getWidthimpl(j);
        }
        if (Float.isNaN(f2)) {
            f2 = Size.m876getHeightimpl(j);
        }
        return SizeKt.Size(f, f2);
    }

    /* renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m1237createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.INSTANCE.m993tintxETnrds(j, i);
        }
        return null;
    }

    /* renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m1236configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z) {
        vectorPainter.m1234setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m1235setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long jM1238obtainSizePxVpY3zN4 = m1238obtainSizePxVpY3zN4(density, imageVector.getDefaultWidth(), imageVector.getDefaultHeight());
        return m1236configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), jM1238obtainSizePxVpY3zN4, m1239obtainViewportSizePq9zytI(jM1238obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m1237createColorFilterxETnrds(imageVector.getTintColor(), imageVector.getTintBlendMode()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m1226setPathFillTypeoQ8Xj4U(vectorPath.getPathFillType());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m1227setStrokeLineCapBeK7IIE(vectorPath.getStrokeLineCap());
                pathComponent.m1228setStrokeLineJoinWw9F2mQ(vectorPath.getStrokeLineJoin());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }
}
