package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SemanticsProperties.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aA\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001c\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0000¢\u0006\u0004\b\u0004\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\r\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000e\u0010\f\u001a\u0011\u0010\u000f\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000f\u0010\f\u001a%\u0010\u0014\u001a\u00020\n*\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a9\u0010\u001b\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001a\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001e\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010 \u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b \u0010\u001f\u001a9\u0010\"\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#\u001a5\u0010&\u001a\u00020\n*\u00020\t2\"\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0%\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006¢\u0006\u0004\b&\u0010'\u001a1\u0010(\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00190\u0010¢\u0006\u0004\b(\u0010\u001c\u001a3\u0010*\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010¢\u0006\u0004\b*\u0010\u001c\u001a3\u0010+\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010¢\u0006\u0004\b+\u0010\u001c\u001a3\u0010,\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010¢\u0006\u0004\b,\u0010\u001c\u001a-\u0010-\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b-\u0010\u001f\u001a3\u0010.\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010¢\u0006\u0004\b.\u0010\u001c\u001a8\u00103\u001a\u00020\n*\u00020\t2\u0006\u00100\u001a\u00020/2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001dø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a?\u00105\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u000104¢\u0006\u0004\b5\u00106\u001a-\u00107\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b7\u0010\u001f\u001a-\u00108\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b8\u0010\u001f\u001a-\u00109\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b9\u0010\u001f\u001a-\u0010:\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b:\u0010\u001f\u001a-\u0010;\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d¢\u0006\u0004\b;\u0010\u001f\u001a-\u0010<\u001a\u00020\n*\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u001d¢\u0006\u0004\b<\u0010\u001f\"(\u0010B\u001a\u00020\u0001*\u00020\t2\u0006\u0010=\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\"/\u0010K\u001a\u00020C*\u00020\t2\u0006\u0010D\u001a\u00020C8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H*\u0004\bI\u0010J\"/\u0010O\u001a\u00020\u0001*\u00020\t2\u0006\u0010D\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bL\u0010?\"\u0004\bM\u0010A*\u0004\bN\u0010J\"/\u0010V\u001a\u00020P*\u00020\t2\u0006\u0010D\u001a\u00020P8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T*\u0004\bU\u0010J\"/\u0010\\\u001a\u00020\u0019*\u00020\t2\u0006\u0010D\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z*\u0004\b[\u0010J\"5\u0010]\u001a\u00020\u0019*\u00020\t2\u0006\u0010D\u001a\u00020\u00198F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b_\u0010\f\u001a\u0004\b]\u0010X\"\u0004\b^\u0010Z*\u0004\b`\u0010J\"/\u0010a\u001a\u00020\u0019*\u00020\t2\u0006\u0010D\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\ba\u0010X\"\u0004\bb\u0010Z*\u0004\bc\u0010J\"/\u0010j\u001a\u00020d*\u00020\t2\u0006\u0010D\u001a\u00020d8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\be\u0010f\"\u0004\bg\u0010h*\u0004\bi\u0010J\"/\u0010n\u001a\u00020d*\u00020\t2\u0006\u0010D\u001a\u00020d8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bk\u0010f\"\u0004\bl\u0010h*\u0004\bm\u0010J\"/\u0010s\u001a\u00020o*\u00020\t2\u0006\u0010D\u001a\u00020o8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bp\u0010R\"\u0004\bq\u0010T*\u0004\br\u0010J\"/\u0010w\u001a\u00020\u0001*\u00020\t2\u0006\u0010D\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bt\u0010?\"\u0004\bu\u0010A*\u0004\bv\u0010J\"(\u0010{\u001a\u00020)*\u00020\t2\u0006\u0010=\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010y\"\u0004\b*\u0010z\"/\u0010~\u001a\u00020)*\u00020\t2\u0006\u0010D\u001a\u00020)8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b|\u0010y\"\u0004\b+\u0010z*\u0004\b}\u0010J\"1\u0010\u007f\u001a\u00020\u0019*\u00020\t2\u0006\u0010D\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0014\u001a\u0004\b\u007f\u0010X\"\u0005\b\u0080\u0001\u0010Z*\u0005\b\u0081\u0001\u0010J\"3\u0010\u0085\u0001\u001a\u00020)*\u00020\t2\u0006\u0010D\u001a\u00020)8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u0082\u0001\u0010y\"\u0005\b\u0083\u0001\u0010z*\u0005\b\u0084\u0001\u0010J\"7\u0010\u008c\u0001\u001a\u00030\u0086\u0001*\u00020\t2\u0007\u0010D\u001a\u00030\u0086\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001*\u0005\b\u008b\u0001\u0010J\"7\u0010\u0093\u0001\u001a\u00030\u008d\u0001*\u00020\t2\u0007\u0010D\u001a\u00030\u008d\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001*\u0005\b\u0092\u0001\u0010J\"3\u0010\u0094\u0001\u001a\u00020\u0019*\u00020\t2\u0006\u0010D\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u0094\u0001\u0010X\"\u0005\b\u0095\u0001\u0010Z*\u0005\b\u0096\u0001\u0010J\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0097\u0001"}, d2 = {"T", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "AccessibilityKey", "(Ljava/lang/String;)Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function2;", "mergePolicy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "disabled", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "popup", "dialog", "password", "Lkotlin/Function1;", "", "", "mapping", "indexForKey", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function1;)V", "label", "", "Landroidx/compose/ui/text/TextLayoutResult;", "", "action", "getTextLayoutResult", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onClick", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onLongClick", "", "scrollBy", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "scrollByOffset", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function2;)V", "scrollToIndex", "Landroidx/compose/ui/text/AnnotatedString;", "setText", "setTextSubstitution", "showTextSubstitution", "clearTextSubstitution", "insertTextAtCursor", "Landroidx/compose/ui/text/input/ImeAction;", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onImeAction", "Lkotlin/Function3;", "setSelection", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "copyText", "cutText", "pasteText", "dismiss", "requestFocus", "getScrollViewportLength", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "contentDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "<set-?>", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "getProgressBarRangeInfo$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "progressBarRangeInfo", "getPaneTitle", "setPaneTitle", "getPaneTitle$delegate", "paneTitle", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setLiveRegion-hR3wRGc", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "getLiveRegion$delegate", "liveRegion", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "getFocused$delegate", "focused", "isContainer", "setContainer", "isContainer$annotations", "isContainer$delegate", "isTraversalGroup", "setTraversalGroup", "isTraversalGroup$delegate", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getHorizontalScrollAxisRange$delegate", "horizontalScrollAxisRange", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "verticalScrollAxisRange", "Landroidx/compose/ui/semantics/Role;", "getRole", "setRole-kuIjeqM", "getRole$delegate", "role", "getTestTag", "setTestTag", "getTestTag$delegate", "testTag", "getText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "text", "getTextSubstitution", "getTextSubstitution$delegate", "textSubstitution", "isShowingTextSubstitution", "setShowingTextSubstitution", "isShowingTextSubstitution$delegate", "getEditableText", "setEditableText", "getEditableText$delegate", "editableText", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "getTextSelectionRange$delegate", "textSelectionRange", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "getCollectionInfo$delegate", "collectionInfo", "isEditable", "setEditable", "isEditable$delegate", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String str) {
        return new SemanticsPropertyKey<>(str, true);
    }

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String str, Function2<? super T, ? super T, ? extends T> function2) {
        return new SemanticsPropertyKey<>(str, true, function2);
    }

    public static final void setContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(str));
    }

    static {
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        semanticsProperties.getStateDescription();
        semanticsProperties.getProgressBarRangeInfo();
        semanticsProperties.getPaneTitle();
        semanticsProperties.getLiveRegion();
        semanticsProperties.getFocused();
        semanticsProperties.getIsTraversalGroup();
        semanticsProperties.getIsTraversalGroup();
        semanticsProperties.getContentType$ui_release();
        semanticsProperties.getContentDataType$ui_release();
        semanticsProperties.getTraversalIndex();
        semanticsProperties.getHorizontalScrollAxisRange();
        semanticsProperties.getVerticalScrollAxisRange();
        semanticsProperties.getRole();
        semanticsProperties.getTestTag();
        semanticsProperties.getTextSubstitution();
        semanticsProperties.getIsShowingTextSubstitution();
        semanticsProperties.getEditableText();
        semanticsProperties.getTextSelectionRange();
        semanticsProperties.getImeAction();
        semanticsProperties.getSelected();
        semanticsProperties.getCollectionInfo();
        semanticsProperties.getCollectionItemInfo();
        semanticsProperties.getToggleableState();
        semanticsProperties.getIsEditable();
        semanticsProperties.getMaxTextLength();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, ProgressBarRangeInfo progressBarRangeInfo) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[1], progressBarRangeInfo);
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void disabled(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    /* renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m1677setLiveRegionhR3wRGc(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue(semanticsPropertyReceiver, $$delegatedProperties[3], LiveRegionMode.m1647boximpl(i));
    }

    public static final void setFocused(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getFocused().setValue(semanticsPropertyReceiver, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public static final void setContainer(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(semanticsPropertyReceiver, $$delegatedProperties[5], Boolean.valueOf(z));
    }

    public static final void setTraversalGroup(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(semanticsPropertyReceiver, $$delegatedProperties[6], Boolean.valueOf(z));
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[10], scrollAxisRange);
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[11], scrollAxisRange);
    }

    public static final void popup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void dialog(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    /* renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m1678setRolekuIjeqM(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsProperties.INSTANCE.getRole().setValue(semanticsPropertyReceiver, $$delegatedProperties[12], Role.m1656boximpl(i));
    }

    public static final void setTestTag(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsProperties.INSTANCE.getTestTag().setValue(semanticsPropertyReceiver, $$delegatedProperties[13], str);
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(annotatedString));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[14], annotatedString);
    }

    public static final void setShowingTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue(semanticsPropertyReceiver, $$delegatedProperties[15], Boolean.valueOf(z));
    }

    public static final void setEditableText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        SemanticsProperties.INSTANCE.getEditableText().setValue(semanticsPropertyReceiver, $$delegatedProperties[16], annotatedString);
    }

    /* renamed from: setTextSelectionRange-FDrldGo, reason: not valid java name */
    public static final void m1679setTextSelectionRangeFDrldGo(SemanticsPropertyReceiver semanticsPropertyReceiver, long j) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue(semanticsPropertyReceiver, $$delegatedProperties[17], TextRange.m1780boximpl(j));
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionInfo collectionInfo) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue(semanticsPropertyReceiver, $$delegatedProperties[20], collectionInfo);
    }

    public static final void setEditable(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue(semanticsPropertyReceiver, $$delegatedProperties[23], Boolean.valueOf(z));
    }

    public static final void password(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void indexForKey(SemanticsPropertyReceiver semanticsPropertyReceiver, Function1<Object, Integer> function1) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIndexForKey(), function1);
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, function1);
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super List<TextLayoutResult>, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onLongClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, function2);
    }

    public static final void scrollBy(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2<? super Float, ? super Float, Boolean> function2) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(str, function2));
    }

    public static final void scrollByOffset(SemanticsPropertyReceiver semanticsPropertyReceiver, Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function2) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollByOffset(), function2);
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, function1);
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super Integer, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, function1);
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setTextSubstitution(semanticsPropertyReceiver, str, function1);
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void showTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        showTextSubstitution(semanticsPropertyReceiver, str, function1);
    }

    public static final void showTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super Boolean, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void clearTextSubstitution$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        clearTextSubstitution(semanticsPropertyReceiver, str, function0);
    }

    public static final void clearTextSubstitution(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void insertTextAtCursor$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        insertTextAtCursor(semanticsPropertyReceiver, str, function1);
    }

    public static final void insertTextAtCursor(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super AnnotatedString, Boolean> function1) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), new AccessibilityAction(str, function1));
    }

    /* renamed from: onImeAction-9UiTYpY$default, reason: not valid java name */
    public static /* synthetic */ void m1676onImeAction9UiTYpY$default(SemanticsPropertyReceiver semanticsPropertyReceiver, int i, String str, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        m1675onImeAction9UiTYpY(semanticsPropertyReceiver, i, str, function0);
    }

    /* renamed from: onImeAction-9UiTYpY, reason: not valid java name */
    public static final void m1675onImeAction9UiTYpY(SemanticsPropertyReceiver semanticsPropertyReceiver, int i, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.m1883boximpl(i));
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, function3);
    }

    public static final void setSelection(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> function3) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(str, function3));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, function0);
    }

    public static final void copyText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, function0);
    }

    public static final void cutText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, function0);
    }

    public static final void pasteText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, function0);
    }

    public static final void dismiss(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        requestFocus(semanticsPropertyReceiver, str, function0);
    }

    public static final void requestFocus(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void getScrollViewportLength$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getScrollViewportLength(semanticsPropertyReceiver, str, function0);
    }

    public static final void getScrollViewportLength(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, final Function0<Float> function0) {
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), new AccessibilityAction(str, new Function1<List<Float>, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt.getScrollViewportLength.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<Float> list) {
                boolean z;
                Float fInvoke = function0.invoke();
                if (fInvoke == null) {
                    z = false;
                } else {
                    list.add(fInvoke);
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }));
    }
}
