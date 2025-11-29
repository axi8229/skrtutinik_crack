package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a×\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0003¢\u0006\u0004\b#\u0010$\u001a#\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b'\u0010(\u001a'\u0010,\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010-\u001a7\u00102\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103\u001a\u0017\u00104\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b4\u00105\u001a4\u0010:\u001a\u00020\u0003*\u0002062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u00101\u001a\u000200H\u0080@¢\u0006\u0004\b:\u0010;\u001a\u001f\u0010=\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010<\u001a\u00020\u0011H\u0003¢\u0006\u0004\b=\u0010>\u001a\u0017\u0010?\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b?\u0010@\u001a'\u0010A\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\bA\u0010B¨\u0006D²\u0006\f\u0010C\u001a\u00020\u00118\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function1;", "", "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/TextLayoutResult;", "onTextLayout", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Brush;", "cursorBrush", "", "softWrap", "", "maxLines", "minLines", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "enabled", "readOnly", "Lkotlin/Function0;", "decorationBox", "CoreTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "manager", "content", "CoreTextFieldRootBox", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "state", "previewKeyEventToDeselectOnBack", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "allowKeyboard", "tapToFocus", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/focus/FocusRequester;Z)V", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "startInputSession", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/text/input/OffsetMapping;)V", "endInputSession", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "Landroidx/compose/foundation/text/TextDelegate;", "textDelegate", "textLayoutResult", "bringSelectionEndIntoView", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "SelectionToolbarAndHandles", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;)V", "writeable", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05bd A[PHI: r13 r36 r42
  0x05bd: PHI (r13v16 androidx.compose.ui.text.input.ImeOptions) = (r13v11 androidx.compose.ui.text.input.ImeOptions), (r13v17 androidx.compose.ui.text.input.ImeOptions) binds: [B:316:0x05bb, B:313:0x05ac] A[DONT_GENERATE, DONT_INLINE]
  0x05bd: PHI (r36v10 int) = (r36v7 int), (r36v12 int) binds: [B:316:0x05bb, B:313:0x05ac] A[DONT_GENERATE, DONT_INLINE]
  0x05bd: PHI (r42v3 int) = (r42v1 int), (r42v4 int) binds: [B:316:0x05bb, B:313:0x05ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x093f  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x09d0  */
    /* JADX WARN: Removed duplicated region for block: B:482:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /* JADX WARN: Type inference failed for: r0v42, types: [androidx.compose.ui.Modifier] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r54, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r55, androidx.compose.ui.Modifier r56, androidx.compose.ui.text.TextStyle r57, androidx.compose.ui.text.input.VisualTransformation r58, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r59, androidx.compose.foundation.interaction.MutableInteractionSource r60, androidx.compose.ui.graphics.Brush r61, boolean r62, int r63, int r64, androidx.compose.ui.text.input.ImeOptions r65, androidx.compose.foundation.text.KeyboardActions r66, boolean r67, boolean r68, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, androidx.compose.runtime.Composer r70, final int r71, final int r72, final int r73) {
        /*
            Method dump skipped, instructions count: 2540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM727constructorimpl = Updater.m727constructorimpl(composerStartRestartGroup);
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m728setimpl(composerM727constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i2 >> 3) & 126);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m411invokeZmokQxo(keyEvent.getNativeKeyEvent());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m413cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m577deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m1789getMaximpl(textFieldValue.getSelection()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else if (iOriginalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m2155getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1286242594);
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(-1285984396);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1285984395);
                    if (!TextRange.m1786getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(-1680616096);
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m1792getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m1787getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 != null && state3.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(-1680216289);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679975078);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 != null && state4.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(-1679895904);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679655654);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679637798);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(651305535);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation_release;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state == null || !state.getShowCursorHandle() || (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) == null || transformedText$foundation_release.length() <= 0) {
                composerStartRestartGroup.startReplaceGroup(-284257090);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-285446808);
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                final long jM582getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m582getCursorPositiontuRUvjQ$foundation_release((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
                boolean zChanged2 = composerStartRestartGroup.changed(jM582getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo409provideF1C5BW0() {
                            return jM582getCursorPositiontuRUvjQ$foundation_release;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(textDragObserver, textFieldSelectionManager, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (Function2) objRememberedValue3);
                boolean zChanged3 = composerStartRestartGroup.changed(jM582getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, jM582getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                AndroidCursorHandle_androidKt.m402CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue4, 1, null), 0L, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }
}
