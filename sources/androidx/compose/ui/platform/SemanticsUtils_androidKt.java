package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Region;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SemanticsUtils.android.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\f\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\u00020\u001bH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u001a\u0010!\u001a\u00020 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "configuration", "Landroidx/compose/ui/text/TextLayoutResult;", "getTextLayoutResult", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Landroidx/compose/ui/text/TextLayoutResult;", "", "getScrollViewportLength", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "findById", "(Ljava/util/List;I)Landroidx/compose/ui/platform/ScrollObservationScope;", "Landroidx/compose/ui/semantics/Role;", "", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "toLegacyClassName", "Landroidx/compose/ui/semantics/SemanticsNode;", "", "isImportantForAccessibility", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/View;", "semanticsIdToView", "(Landroidx/compose/ui/platform/AndroidViewsHandler;I)Landroid/view/View;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getAllUncoveredSemanticsNodesToIntObjectMap", "(Landroidx/compose/ui/semantics/SemanticsOwner;)Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/geometry/Rect;", "DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getDefaultFakeNodeBounds", "()Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsUtils_androidKt {
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    @SuppressLint({"PrimitiveInCollection"})
    public static final Float getScrollViewportLength(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getSemanticsNodeId() == i) {
                return list.get(i2);
            }
        }
        return null;
    }

    /* renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m1641toLegacyClassNameV4PA4sw(int i) {
        Role.Companion companion = Role.INSTANCE;
        if (Role.m1659equalsimpl0(i, companion.m1663getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m1659equalsimpl0(i, companion.m1664getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m1659equalsimpl0(i, companion.m1667getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m1659equalsimpl0(i, companion.m1666getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m1659equalsimpl0(i, companion.m1665getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getUnmergedConfig().containsImportantForAccessibility$ui_release();
    }

    public static final View semanticsIdToView(AndroidViewsHandler androidViewsHandler, int i) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((LayoutNode) ((Map.Entry) next).getKey()).getSemanticsId() == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final IntObjectMap<SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner semanticsOwner) {
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        if (unmergedRootSemanticsNode.getLayoutNode().isPlaced() && unmergedRootSemanticsNode.getLayoutNode().isAttached()) {
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(new Region(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom())), unmergedRootSemanticsNode, mutableIntObjectMapMutableIntObjectMapOf, unmergedRootSemanticsNode, new Region());
        }
        return mutableIntObjectMapMutableIntObjectMapOf;
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, SemanticsNode semanticsNode2, Region region2) {
        LayoutInfo layoutInfo;
        boolean z = (semanticsNode2.getLayoutNode().isPlaced() && semanticsNode2.getLayoutNode().isAttached()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.getId() == semanticsNode.getId()) {
            if (!z || semanticsNode2.getIsFake()) {
                Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
                int iRound = Math.round(touchBoundsInRoot.getLeft());
                int iRound2 = Math.round(touchBoundsInRoot.getTop());
                int iRound3 = Math.round(touchBoundsInRoot.getRight());
                int iRound4 = Math.round(touchBoundsInRoot.getBottom());
                region2.set(iRound, iRound2, iRound3, iRound4);
                int id = semanticsNode2.getId() == semanticsNode.getId() ? -1 : semanticsNode2.getId();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (semanticsNode2.getIsFake()) {
                        SemanticsNode parent = semanticsNode2.getParent();
                        Rect boundsInRoot = (parent == null || (layoutInfo = parent.getLayoutInfo()) == null || !layoutInfo.isPlaced()) ? DefaultFakeNodeBounds : parent.getBoundsInRoot();
                        mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom()))));
                        return;
                    } else {
                        if (id == -1) {
                            mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(region, semanticsNode, mutableIntObjectMap, replacedChildren$ui_release.get(size), region2);
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                }
            }
        }
    }
}
