package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: Placeable.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH$ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0012R$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R0\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0004@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010$\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020#8\u0004@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R*\u0010'\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 R\u0014\u0010*\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0014\u0010,\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "<init>", "()V", "", "onMeasuredSizeChanged", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "", "<set-?>", "width", "I", "getWidth", "()I", "height", "getHeight", "Landroidx/compose/ui/unit/IntSize;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "measuredSize", "J", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    private int height;
    private int width;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private long apparentToRealOffset = IntOffset.INSTANCE.m2145getZeronOccac();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno */
    public abstract void mo1421placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock);

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredWidth() {
        return IntSize.m2156getWidthimpl(this.measuredSize);
    }

    public int getMeasuredHeight() {
        return IntSize.m2155getHeightimpl(this.measuredSize);
    }

    /* renamed from: getMeasuredSize-YbymL2g, reason: not valid java name and from getter */
    protected final long getMeasuredSize() {
        return this.measuredSize;
    }

    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    protected final void m1442setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m2154equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m2156getWidthimpl(this.measuredSize), Constraints.m2086getMinWidthimpl(this.measurementConstraints), Constraints.m2084getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m2155getHeightimpl(this.measuredSize), Constraints.m2085getMinHeightimpl(this.measurementConstraints), Constraints.m2083getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m2156getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m2155getHeightimpl(this.measuredSize)) / 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo1441placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        mo1421placeAtf8xVGno(position, zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name and from getter */
    protected final long getMeasurementConstraints() {
        return this.measurementConstraints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m1443setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m2078equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }

    /* renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name and from getter */
    protected final long getApparentToRealOffset() {
        return this.apparentToRealOffset;
    }

    /* compiled from: Placeable.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000e\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0012J+\u0010\u0013\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u0013\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\rJ<\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JA\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u001c\u0010\u001bJ<\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019J.\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010 J.\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 J!\u0010\"\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8$X¤\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "<init>", "()V", "Landroidx/compose/ui/layout/Placeable;", "", "handleMotionFrameOfReferencePlacement", "(Landroidx/compose/ui/layout/Placeable;)V", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "placeRelative", "", "x", "y", "(Landroidx/compose/ui/layout/Placeable;IIF)V", "place", "place-70tqf50", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeRelativeWithLayer", "(Landroidx/compose/ui/layout/Placeable;IIFLkotlin/jvm/functions/Function1;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "block", "withMotionFrameOfReferencePlacement", "(Lkotlin/jvm/functions/Function1;)V", "", "motionFrameOfReferencePlacement", "Z", "getParentWidth", "()I", "parentWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class PlacementScope {
        private boolean motionFrameOfReferencePlacement;

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getParentWidth();

        /* renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m1445placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m1451placeRelative70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f);
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2138getXimpl(jIntOffset), IntOffset.m2139getYimpl(jIntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset2, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i2, f);
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m1444place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m1450place70tqf50(placeable, j, f);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1446placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m1452placeRelativeWithLayeraW9wM(placeable, j, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2138getXimpl(jIntOffset), IntOffset.m2139getYimpl(jIntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset2, placeable.apparentToRealOffset), f, function1);
            }
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f2, function1);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1448placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m1454placeWithLayeraW9wM(placeable, j, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1449placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m1455placeWithLayeraW9wM(placeable, j, graphicsLayer, f);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1447placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m1453placeRelativeWithLayeraW9wM(placeable, j, graphicsLayer, f);
        }

        /* renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m1451placeRelative70tqf50(Placeable placeable, long j, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2138getXimpl(j), IntOffset.m2139getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1452placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2138getXimpl(j), IntOffset.m2139getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, function1);
            }
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1453placeRelativeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1441placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2138getXimpl(j), IntOffset.m2139getYimpl(j));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1441placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(jIntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
            }
        }

        /* renamed from: place-70tqf50, reason: not valid java name */
        public final void m1450place70tqf50(Placeable placeable, long j, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1454placeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1421placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1455placeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1441placeAtf8xVGno(IntOffset.m2142plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super PlacementScope, Unit> block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).setPlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }
    }
}
