package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListMeasuredItem.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010'J%\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b&\u0010(J\u0015\u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0003¢\u0006\u0004\b*\u0010+J\u001d\u0010.\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u001d\u00101\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u001d\u00106\u001a\u00020%2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\b¢\u0006\u0004\b6\u00107R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b9\u0010:R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010;R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010<\u001a\u0004\b\t\u0010=R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010>R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010?R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010@R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010<R\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00108R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u00108R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00108R\u001a\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0015\u0010AR\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010B\u001a\u0004\bE\u0010DR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010FR \u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u001c\u0010A\u001a\u0004\bG\u0010HR$\u0010J\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bJ\u00108\u001a\u0004\b.\u0010:R\u001a\u0010K\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u00108\u001a\u0004\bL\u0010:R\u001a\u0010M\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\bM\u00108\u001a\u0004\bN\u0010:R\u001a\u0010O\u001a\u00020\u00038\u0016X\u0096D¢\u0006\f\n\u0004\bO\u00108\u001a\u0004\bP\u0010:R\u001a\u0010Q\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010:R\u0017\u0010S\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bS\u00108\u001a\u0004\bT\u0010:R\"\u0010U\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bU\u0010<\u001a\u0004\bV\u0010=\"\u0004\bW\u0010XR\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00108R\u0016\u0010Y\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u00108R\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u00108R\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u00020\u0003*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0018\u0010c\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010:\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "index", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "", "isVertical", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "Landroidx/compose/ui/unit/IntOffset;", "visualOffset", "", "key", "contentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "Landroidx/compose/ui/unit/Constraints;", "constraints", "<init>", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getParentData", "(I)Ljava/lang/Object;", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "", "position", "(IIII)V", "(III)V", "mainAxisLayoutSize", "updateMainAxisLayoutSize", "(I)V", "getOffset-Bjo55l4", "(I)J", "getOffset", "delta", "updateAnimations", "applyScrollDelta", "(IZ)V", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "isLookingAhead", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Z)V", "I", "getIndex", "()I", "Ljava/util/List;", "Z", "()Z", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/compose/ui/unit/LayoutDirection;", "J", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getContentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "getConstraints-msEJaDk", "()J", "<set-?>", "offset", "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "minMainAxisOffset", "maxMainAxisOffset", "", "placeableOffsets", "[I", "getMainAxis--gyyYBs", "(J)I", "mainAxis", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "mainAxisSize", "getPlaceablesCount", "placeablesCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            height += getIsVertical() ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, layoutWidth, layoutHeight);
    }

    public final void position(int mainAxisOffset, int layoutWidth, int layoutHeight) {
        int width;
        this.offset = mainAxisOffset;
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int i2 = i * 2;
            if (getIsVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true");
                }
                iArr[i2] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                this.placeableOffsets[i2 + 1] = mainAxisOffset;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i2] = mainAxisOffset;
                int i3 = i2 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false");
                }
                iArr2[i3] = vertical.align(placeable.getHeight(), layoutHeight);
                width = placeable.getWidth();
            }
            mainAxisOffset += width;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo356getOffsetBjo55l4(int index) {
        int[] iArr = this.placeableOffsets;
        int i = index * 2;
        return IntOffsetKt.IntOffset(iArr[i], iArr[i + 1]);
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        if (getNonScrollableItem()) {
            return;
        }
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i = 0; i < length; i++) {
            if ((getIsVertical() && i % 2 == 1) || (!getIsVertical() && i % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i] = iArr[i] + delta;
            }
        }
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i2);
                if (animation != null) {
                    long rawOffset = animation.getRawOffset();
                    int iM2138getXimpl = getIsVertical() ? IntOffset.m2138getXimpl(rawOffset) : Integer.valueOf(IntOffset.m2138getXimpl(rawOffset) + delta).intValue();
                    boolean isVertical = getIsVertical();
                    int iM2139getYimpl = IntOffset.m2139getYimpl(rawOffset);
                    if (isVertical) {
                        iM2139getYimpl += delta;
                    }
                    animation.m378setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iM2138getXimpl, iM2139getYimpl));
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope scope, boolean isLookingAhead) {
        GraphicsLayer layer;
        int iM2139getYimpl;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            long jMo356getOffsetBjo55l4 = mo356getOffsetBjo55l4(i);
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (isLookingAhead) {
                    animation.m377setLookaheadOffsetgyyYBs(jMo356getOffsetBjo55l4);
                } else {
                    if (!IntOffset.m2137equalsimpl0(animation.getLookaheadOffset(), LazyLayoutItemAnimation.INSTANCE.m379getNotInitializednOccac())) {
                        jMo356getOffsetBjo55l4 = animation.getLookaheadOffset();
                    }
                    long jM2142plusqkQi6aY = IntOffset.m2142plusqkQi6aY(jMo356getOffsetBjo55l4, animation.m374getPlacementDeltanOccac());
                    if ((m354getMainAxisgyyYBs(jMo356getOffsetBjo55l4) <= mainAxisSize && m354getMainAxisgyyYBs(jM2142plusqkQi6aY) <= mainAxisSize) || (m354getMainAxisgyyYBs(jMo356getOffsetBjo55l4) >= i2 && m354getMainAxisgyyYBs(jM2142plusqkQi6aY) >= i2)) {
                        animation.cancelPlacementAnimation();
                    }
                    jMo356getOffsetBjo55l4 = jM2142plusqkQi6aY;
                }
                layer = animation.getLayer();
            } else {
                layer = null;
            }
            if (this.reverseLayout) {
                int iM2138getXimpl = getIsVertical() ? IntOffset.m2138getXimpl(jMo356getOffsetBjo55l4) : (this.mainAxisLayoutSize - IntOffset.m2138getXimpl(jMo356getOffsetBjo55l4)) - getMainAxisSize(placeable);
                if (getIsVertical()) {
                    iM2139getYimpl = (this.mainAxisLayoutSize - IntOffset.m2139getYimpl(jMo356getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    iM2139getYimpl = IntOffset.m2139getYimpl(jMo356getOffsetBjo55l4);
                }
                jMo356getOffsetBjo55l4 = IntOffsetKt.IntOffset(iM2138getXimpl, iM2139getYimpl);
            }
            long jM2142plusqkQi6aY2 = IntOffset.m2142plusqkQi6aY(jMo356getOffsetBjo55l4, this.visualOffset);
            if (!isLookingAhead && animation != null) {
                animation.m376setFinalOffsetgyyYBs(jM2142plusqkQi6aY2);
            }
            if (getIsVertical()) {
                if (layer != null) {
                    Placeable.PlacementScope.m1449placeWithLayeraW9wM$default(scope, placeable, jM2142plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
                } else {
                    Placeable.PlacementScope.m1448placeWithLayeraW9wM$default(scope, placeable, jM2142plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
                }
            } else if (layer != null) {
                Placeable.PlacementScope.m1447placeRelativeWithLayeraW9wM$default(scope, placeable, jM2142plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                Placeable.PlacementScope.m1446placeRelativeWithLayeraW9wM$default(scope, placeable, jM2142plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m354getMainAxisgyyYBs(long j) {
        return getIsVertical() ? IntOffset.m2139getYimpl(j) : IntOffset.m2138getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }
}
