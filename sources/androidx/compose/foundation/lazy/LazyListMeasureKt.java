package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListMeasure.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0013\u001a\u009e\u0002\u00101\u001a\u00020.2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2*\u0010-\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)\u0012\u0004\u0012\u00020,0(H\u0000ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001ac\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b6\u00107\u001a;\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u00108\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0002¢\u0006\u0004\b9\u0010:\u001a\u0093\u0001\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bC\u0010D\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"", "itemsCount", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "measuredItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "", "scrollToBeConsumed", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "isVertical", "", "headerIndexes", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "reverseLayout", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "itemAnimator", "beyondBoundsItemCount", "pinnedItems", "hasLookaheadPassOccurred", "isLookingAhead", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "postLookaheadLayoutInfo", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList", "", "visibleItems", "consumedScroll", "lastPostLookaheadLayoutInfo", "createItemsAfterList", "(Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IILjava/util/List;FZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;)Ljava/util/List;", "currentFirstItemIndex", "createItemsBeforeList", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;ILjava/util/List;)Ljava/util/List;", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "calculateItemsOffsets", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;)Ljava/util/List;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0415  */
    /* renamed from: measureLazyList-x0Ok8Vo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m352measureLazyListx0Ok8Vo(int r40, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r41, int r42, int r43, int r44, int r45, int r46, int r47, float r48, long r49, boolean r51, java.util.List<java.lang.Integer> r52, androidx.compose.foundation.layout.Arrangement.Vertical r53, androidx.compose.foundation.layout.Arrangement.Horizontal r54, boolean r55, androidx.compose.ui.unit.Density r56, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> r57, int r58, java.util.List<java.lang.Integer> r59, boolean r60, boolean r61, androidx.compose.foundation.lazy.LazyListLayoutInfo r62, kotlinx.coroutines.CoroutineScope r63, final androidx.compose.runtime.MutableState<kotlin.Unit> r64, androidx.compose.ui.graphics.GraphicsContext r65, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r66) {
        /*
            Method dump skipped, instructions count: 1112
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m352measureLazyListx0Ok8Vo(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2, float f, boolean z, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int mainAxisSizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem3;
        int index;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem4;
        LazyListMeasuredItem lazyListMeasuredItem5;
        int i3 = i - 1;
        int iMin2 = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i2, i3);
        int index2 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        if (index2 <= iMin2) {
            ArrayList arrayList2 = null;
            while (true) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList = arrayList2;
                arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index2, 0L, 2, null));
                if (index2 == iMin2) {
                    break;
                }
                index2++;
                arrayList2 = arrayList;
            }
        } else {
            arrayList = null;
        }
        if (z && lazyListLayoutInfo != null && !lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size).getIndex() > iMin2 && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= iMin2)) {
                    break;
                }
            }
            lazyListItemInfo = visibleItemsInfo.get(size);
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (iMin = Math.min(lazyListItemInfo2.getIndex(), i3))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                lazyListMeasuredItem5 = null;
                                break;
                            }
                            lazyListMeasuredItem5 = arrayList.get(i4);
                            if (lazyListMeasuredItem5.getIndex() == index) {
                                break;
                            }
                            i4++;
                        }
                        lazyListMeasuredItem4 = lazyListMeasuredItem5;
                    } else {
                        lazyListMeasuredItem4 = null;
                    }
                    if (lazyListMeasuredItem4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index, 0L, 2, null));
                    }
                    if (index == iMin) {
                        break;
                    }
                    index++;
                }
            }
            float viewportEndOffset = ((lazyListLayoutInfo.getViewportEndOffset() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f;
            if (viewportEndOffset > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i5 = 0;
                while (index3 < i && i5 < viewportEndOffset) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size3) {
                                lazyListMeasuredItem3 = null;
                                break;
                            }
                            lazyListMeasuredItem3 = list.get(i6);
                            if (lazyListMeasuredItem3.getIndex() == index3) {
                                break;
                            }
                            i6++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size4) {
                                lazyListMeasuredItem2 = null;
                                break;
                            }
                            lazyListMeasuredItem2 = arrayList.get(i7);
                            if (lazyListMeasuredItem2.getIndex() == index3) {
                                break;
                            }
                            i7++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem2;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        mainAxisSizeWithSpacings = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getMainAxisSizeWithSpacings();
                    }
                    i5 += mainAxisSizeWithSpacings;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > iMin2) {
            iMin2 = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i8 = 0; i8 < size5; i8++) {
            int iIntValue = list2.get(i8).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i3, 0L, 2, null));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m357getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue, 0L, 2, null));
                }
                if (i4 < 0) {
                    break;
                }
                size = i4;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset");
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z3) {
            int size = list2.size();
            int mainAxisSizeWithSpacings = i5;
            for (int i7 = 0; i7 < size; i7++) {
                LazyListMeasuredItem lazyListMeasuredItem = list2.get(i7);
                mainAxisSizeWithSpacings -= lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem.position(mainAxisSizeWithSpacings, i, i2);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i8 = 0; i8 < size2; i8++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i8);
                lazyListMeasuredItem2.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i9 = 0; i9 < size3; i9++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i9);
                lazyListMeasuredItem3.position(mainAxisSizeWithSpacings2, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i10 = 0; i10 < size4; i10++) {
                iArr[i10] = list.get(calculateItemsOffsets$reverseAware(i10, z2, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i11 = 0; i11 < size4; i11++) {
                iArr2[i11] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size5 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(first, z2, size4));
                    if (z2) {
                        size5 = (i6 - size5) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(size5, i, i2);
                    arrayList.add(lazyListMeasuredItem4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }
}
