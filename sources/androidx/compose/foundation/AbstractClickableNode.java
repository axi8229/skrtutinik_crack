package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\b\b \u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001rBE\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u0019J\u0014\u0010\u001e\u001a\u00020\u0012*\u00020\u001dH¦@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010!\u001a\u00020\u0012*\u00020 H\u0016¢\u0006\u0004\b!\u0010\"JP\u0010%\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0004ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020\u0012¢\u0006\u0004\b&\u0010\u0019J\r\u0010'\u001a\u00020\u0012¢\u0006\u0004\b'\u0010\u0019J\u000f\u0010(\u001a\u00020\u0012H\u0004¢\u0006\u0004\b(\u0010\u0019J(\u00101\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-ø\u0001\u0000¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u00020\u0012¢\u0006\u0004\b2\u0010\u0019J\u0018\u00107\u001a\u00020\u000b2\u0006\u00104\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0018\u00109\u001a\u00020\u000b2\u0006\u00104\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b8\u00106J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0011\u0010>\u001a\u00020\u0012*\u00020 ¢\u0006\u0004\b>\u0010\"J\u001f\u0010D\u001a\u00020\u0012*\u00020?2\u0006\u0010A\u001a\u00020@H\u0084@ø\u0001\u0000¢\u0006\u0004\bB\u0010CR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010ER\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010FR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010GR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0010\u0010HR$\u0010\f\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\f\u0010J\u001a\u0004\bK\u0010\u0017R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0013\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u000b8\u0006X\u0086D¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010\u0017R\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR \u0010e\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020]0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001c\u0010g\u001a\u00020@8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010ER\u0016\u0010j\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010JR\u001a\u0010l\u001a\u00020k8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0011\u0010q\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bp\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006s"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/IndicationNodeFactory;", "indicationNodeFactory", "", "enabled", "", "onClickLabel", "Landroidx/compose/ui/semantics/Role;", "role", "Lkotlin/Function0;", "", "onClick", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldLazilyCreateIndication", "()Z", "initializeIndicationAndInteractionSourceIfNeeded", "()V", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "clickPointerInput", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applyAdditionalSemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "updateCommon-QzZPfjk", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;)V", "updateCommon", "onAttach", "onDetach", "disposeInteractions", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "Landroidx/compose/ui/input/key/KeyEvent;", "event", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onPreKeyEvent-ZmokQxo", "onPreKeyEvent", "Landroidx/compose/ui/focus/FocusState;", "focusState", "onFocusEvent", "(Landroidx/compose/ui/focus/FocusState;)V", "applySemantics", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "offset", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePressInteraction", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/IndicationNodeFactory;", "Ljava/lang/String;", "Landroidx/compose/ui/semantics/Role;", "<set-?>", "Z", "getEnabled", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "Landroidx/compose/foundation/FocusableInNonTouchMode;", "focusableInNonTouchMode", "Landroidx/compose/foundation/FocusableInNonTouchMode;", "Landroidx/compose/foundation/FocusableNode;", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "", "Landroidx/compose/ui/input/key/Key;", "currentKeyPressInteractions", "Ljava/util/Map;", "centerOffset", "J", "userProvidedInteractionSource", "lazilyCreateIndication", "", "traverseKey", "Ljava/lang/Object;", "getTraverseKey", "()Ljava/lang/Object;", "getShouldMergeDescendantSemantics", "shouldMergeDescendantSemantics", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, FocusEventModifierNode, SemanticsModifierNode, TraversableNode {
    private long centerOffset;
    private final Map<Key, PressInteraction$Press> currentKeyPressInteractions;
    private boolean enabled;
    private final FocusableInNonTouchMode focusableInNonTouchMode;
    private final FocusableNode focusableNode;
    private HoverInteraction$Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction$Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private MutableInteractionSource userProvidedInteractionSource;

    /* renamed from: TraverseKey, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, str, role, function0);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public abstract Object clickPointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation);

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* renamed from: getShouldMergeDescendantSemantics */
    public final boolean getMergeDescendants() {
        return true;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo154onPreKeyEventZmokQxo(KeyEvent event) {
        return false;
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0<Unit> function0) {
        this.interactionSource = mutableInteractionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z;
        this.onClick = function0;
        this.focusableInNonTouchMode = new FocusableInNonTouchMode();
        this.focusableNode = new FocusableNode(this.interactionSource);
        this.currentKeyPressInteractions = new LinkedHashMap();
        this.centerOffset = Offset.INSTANCE.m854getZeroF1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = INSTANCE;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final boolean shouldLazilyCreateIndication() {
        return this.userProvidedInteractionSource == null && this.indicationNodeFactory != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* renamed from: updateCommon-QzZPfjk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void m155updateCommonQzZPfjk(androidx.compose.foundation.interaction.MutableInteractionSource r3, androidx.compose.foundation.IndicationNodeFactory r4, boolean r5, java.lang.String r6, androidx.compose.ui.semantics.Role r7, kotlin.jvm.functions.Function0<kotlin.Unit> r8) {
        /*
            r2 = this;
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = r2.userProvidedInteractionSource
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            r1 = 1
            if (r0 != 0) goto L12
            r2.disposeInteractions()
            r2.userProvidedInteractionSource = r3
            r2.interactionSource = r3
            r3 = r1
            goto L13
        L12:
            r3 = 0
        L13:
            androidx.compose.foundation.IndicationNodeFactory r0 = r2.indicationNodeFactory
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L1e
            r2.indicationNodeFactory = r4
            r3 = r1
        L1e:
            boolean r4 = r2.enabled
            if (r4 == r5) goto L41
            if (r5 == 0) goto L2f
            androidx.compose.foundation.FocusableInNonTouchMode r4 = r2.focusableInNonTouchMode
            r2.delegate(r4)
            androidx.compose.foundation.FocusableNode r4 = r2.focusableNode
            r2.delegate(r4)
            goto L3c
        L2f:
            androidx.compose.foundation.FocusableInNonTouchMode r4 = r2.focusableInNonTouchMode
            r2.undelegate(r4)
            androidx.compose.foundation.FocusableNode r4 = r2.focusableNode
            r2.undelegate(r4)
            r2.disposeInteractions()
        L3c:
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r2)
            r2.enabled = r5
        L41:
            java.lang.String r4 = r2.onClickLabel
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r4 != 0) goto L4e
            r2.onClickLabel = r6
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r2)
        L4e:
            androidx.compose.ui.semantics.Role r4 = r2.role
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 != 0) goto L5b
            r2.role = r7
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r2)
        L5b:
            r2.onClick = r8
            boolean r4 = r2.lazilyCreateIndication
            boolean r5 = r2.shouldLazilyCreateIndication()
            if (r4 == r5) goto L72
            boolean r4 = r2.shouldLazilyCreateIndication()
            r2.lazilyCreateIndication = r4
            if (r4 != 0) goto L72
            androidx.compose.ui.node.DelegatableNode r4 = r2.indicationNode
            if (r4 != 0) goto L72
            goto L73
        L72:
            r1 = r3
        L73:
            if (r1 == 0) goto L88
            androidx.compose.ui.node.DelegatableNode r3 = r2.indicationNode
            if (r3 != 0) goto L7d
            boolean r4 = r2.lazilyCreateIndication
            if (r4 != 0) goto L88
        L7d:
            if (r3 == 0) goto L82
            r2.undelegate(r3)
        L82:
            r3 = 0
            r2.indicationNode = r3
            r2.initializeIndicationAndInteractionSourceIfNeeded()
        L88:
            androidx.compose.foundation.FocusableNode r3 = r2.focusableNode
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.interactionSource
            r3.update(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.m155updateCommonQzZPfjk(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0):void");
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableInNonTouchMode);
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
    }

    protected final void disposeInteractions() {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction$Press pressInteraction$Press = this.pressInteraction;
            if (pressInteraction$Press != null) {
                mutableInteractionSource.tryEmit(new PressInteraction$Cancel(pressInteraction$Press));
            }
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                mutableInteractionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            }
            Iterator<T> it = this.currentKeyPressInteractions.values().iterator();
            while (it.hasNext()) {
                mutableInteractionSource.tryEmit(new PressInteraction$Cancel((PressInteraction$Press) it.next()));
            }
        }
        this.pressInteraction = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        IndicationNodeFactory indicationNodeFactory;
        if (this.indicationNode == null && (indicationNodeFactory = this.indicationNodeFactory) != null) {
            if (this.interactionSource == null) {
                this.interactionSource = InteractionSourceKt.MutableInteractionSource();
            }
            this.focusableNode.update(this.interactionSource);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            Intrinsics.checkNotNull(mutableInteractionSource);
            DelegatableNode delegatableNodeCreate = indicationNodeFactory.create(mutableInteractionSource);
            delegate(delegatableNodeCreate);
            this.indicationNode = delegatableNodeCreate;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public final void mo153onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        long jM2161getCenterozmzZPI = IntSizeKt.m2161getCenterozmzZPI(bounds);
        this.centerOffset = OffsetKt.Offset(IntOffset.m2138getXimpl(jM2161getCenterozmzZPI), IntOffset.m2139getYimpl(jM2161getCenterozmzZPI));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && pass == PointerEventPass.Main) {
            int type = pointerEvent.getType();
            PointerEventType.Companion companion = PointerEventType.INSTANCE;
            if (PointerEventType.m1330equalsimpl0(type, companion.m1331getEnter7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m1330equalsimpl0(type, companion.m1332getExit7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
        if (this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AbstractClickableNode$onPointerEvent$3(this, null)));
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo153onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        HoverInteraction$Enter hoverInteraction$Enter;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (hoverInteraction$Enter = this.hoverInteraction) != null) {
            mutableInteractionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
        }
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo152onKeyEventZmokQxo(KeyEvent event) {
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && Clickable_androidKt.m178isPressZmokQxo(event)) {
            if (this.currentKeyPressInteractions.containsKey(Key.m1263boximpl(KeyEvent_androidKt.m1293getKeyZmokQxo(event)))) {
                return false;
            }
            PressInteraction$Press pressInteraction$Press = new PressInteraction$Press(this.centerOffset, null);
            this.currentKeyPressInteractions.put(Key.m1263boximpl(KeyEvent_androidKt.m1293getKeyZmokQxo(event)), pressInteraction$Press);
            if (this.interactionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, pressInteraction$Press, null), 3, null);
            }
        } else {
            if (!this.enabled || !Clickable_androidKt.m176isClickZmokQxo(event)) {
                return false;
            }
            PressInteraction$Press pressInteraction$PressRemove = this.currentKeyPressInteractions.remove(Key.m1263boximpl(KeyEvent_androidKt.m1293getKeyZmokQxo(event)));
            if (pressInteraction$PressRemove != null && this.interactionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, pressInteraction$PressRemove, null), 3, null);
            }
            this.onClick.invoke();
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusState focusState) {
        if (focusState.isFocused()) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            this.focusableNode.onFocusEvent(focusState);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.m1678setRolekuIjeqM(semanticsPropertyReceiver, role.getValue());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new Function0<Boolean>() { // from class: androidx.compose.foundation.AbstractClickableNode.applySemantics.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                AbstractClickableNode.this.getOnClick().invoke();
                return Boolean.TRUE;
            }
        });
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    /* renamed from: handlePressInteraction-d-4ec7I, reason: not valid java name */
    protected final Object m151handlePressInteractiond4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        Object objCoroutineScope;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return (mutableInteractionSource == null || (objCoroutineScope = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(pressGestureScope, j, mutableInteractionSource, this, null), continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objCoroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction() {
        return ClickableKt.hasScrollableContainer(this) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverEnter() {
        if (this.hoverInteraction == null) {
            HoverInteraction$Enter hoverInteraction$Enter = new HoverInteraction$Enter();
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(mutableInteractionSource, hoverInteraction$Enter, null), 3, null);
            }
            this.hoverInteraction = hoverInteraction$Enter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverExit() {
        HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
        if (hoverInteraction$Enter != null) {
            HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(mutableInteractionSource, hoverInteraction$Exit, null), 3, null);
            }
            this.hoverInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.AbstractClickableNode$TraverseKey, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
