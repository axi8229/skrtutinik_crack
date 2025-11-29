package androidx.compose.ui.node;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006 "}, d2 = {"Landroidx/compose/ui/node/Snake;", "", "", RemoteMessageConst.DATA, "constructor-impl", "([I)[I", "Landroidx/compose/ui/node/IntStack;", "diagonals", "", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "addDiagonalToStack", "", "getStartX-impl", "([I)I", "startX", "getStartY-impl", "startY", "getEndX-impl", "endX", "getEndY-impl", "endY", "", "getReverse-impl", "([I)Z", "reverse", "getDiagonalSize-impl", "diagonalSize", "getHasAdditionOrRemoval-impl", "hasAdditionOrRemoval", "isAddition-impl", "isAddition", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
final class Snake {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1564constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m1570getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m1571getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m1566getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m1567getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m1569getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m1565getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m1566getEndXimpl(iArr) - m1570getStartXimpl(iArr), m1567getEndYimpl(iArr) - m1571getStartYimpl(iArr));
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m1568getHasAdditionOrRemovalimpl(int[] iArr) {
        return m1567getEndYimpl(iArr) - m1571getStartYimpl(iArr) != m1566getEndXimpl(iArr) - m1570getStartXimpl(iArr);
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m1572isAdditionimpl(int[] iArr) {
        return m1567getEndYimpl(iArr) - m1571getStartYimpl(iArr) > m1566getEndXimpl(iArr) - m1570getStartXimpl(iArr);
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m1563addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        if (m1568getHasAdditionOrRemovalimpl(iArr)) {
            if (m1569getReverseimpl(iArr)) {
                intStack.pushDiagonal(m1570getStartXimpl(iArr), m1571getStartYimpl(iArr), m1565getDiagonalSizeimpl(iArr));
                return;
            } else if (m1572isAdditionimpl(iArr)) {
                intStack.pushDiagonal(m1570getStartXimpl(iArr), m1571getStartYimpl(iArr) + 1, m1565getDiagonalSizeimpl(iArr));
                return;
            } else {
                intStack.pushDiagonal(m1570getStartXimpl(iArr) + 1, m1571getStartYimpl(iArr), m1565getDiagonalSizeimpl(iArr));
                return;
            }
        }
        intStack.pushDiagonal(m1570getStartXimpl(iArr), m1571getStartYimpl(iArr), m1566getEndXimpl(iArr) - m1570getStartXimpl(iArr));
    }
}
