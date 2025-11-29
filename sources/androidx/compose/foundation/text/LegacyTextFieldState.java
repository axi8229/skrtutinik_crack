package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJl\u0010#\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010A\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010@R1\u0010H\u001a\u00020B2\u0006\u0010;\u001a\u00020B8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010=R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR+\u0010Z\u001a\u00020T2\u0006\u0010;\u001a\u00020T8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010=\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010^\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010=\u001a\u0004\b\\\u0010\f\"\u0004\b]\u0010@R+\u0010b\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010=\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010@R+\u0010f\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010=\u001a\u0004\bd\u0010\f\"\u0004\be\u0010@R+\u0010j\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010=\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010@R$\u0010k\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bk\u0010\fR+\u0010n\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010=\u001a\u0004\bn\u0010\f\"\u0004\bo\u0010@R\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0006¢\u0006\f\n\u0004\b\u001a\u0010t\u001a\u0004\bu\u0010vR#\u0010x\u001a\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020\u00190\u00178\u0006¢\u0006\f\n\u0004\bx\u0010t\u001a\u0004\by\u0010vR\u0017\u0010{\u001a\u00020z8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R,\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0016\n\u0004\b \u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R9\u0010\u0088\u0001\u001a\u00030\u0084\u00012\u0007\u0010;\u001a\u00030\u0084\u00018F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b\u0085\u0001\u0010=\u001a\u0006\b\u0086\u0001\u0010\u0081\u0001\"\u0006\b\u0087\u0001\u0010\u0083\u0001R9\u0010\u008c\u0001\u001a\u00030\u0084\u00012\u0007\u0010;\u001a\u00030\u0084\u00018F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b\u0089\u0001\u0010=\u001a\u0006\b\u008a\u0001\u0010\u0081\u0001\"\u0006\b\u008b\u0001\u0010\u0083\u0001R.\u0010\u0092\u0001\u001a\u0004\u0018\u00010I2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R.\u0010\u0097\u0001\u001a\u0004\u0018\u00010M2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010M8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0098\u0001"}, d2 = {"Landroidx/compose/foundation/text/LegacyTextFieldState;", "", "Landroidx/compose/foundation/text/TextDelegate;", "textDelegate", "Landroidx/compose/runtime/RecomposeScope;", "recomposeScope", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "keyboardController", "<init>", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "", "hasHighlight", "()Z", "Landroidx/compose/ui/text/AnnotatedString;", "untransformedText", "visualText", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "softWrap", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "onValueChange", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "Landroidx/compose/ui/focus/FocusManager;", "focusManager", "Landroidx/compose/ui/graphics/Color;", "selectionBackgroundColor", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "update", "Landroidx/compose/foundation/text/TextDelegate;", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "Landroidx/compose/ui/text/input/EditProcessor;", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "Landroidx/compose/ui/text/input/TextInputSession;", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "<set-?>", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "getHasFocus", "setHasFocus", "(Z)V", "hasFocus", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField$delegate", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField", "Landroidx/compose/ui/layout/LayoutCoordinates;", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResultState", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Landroidx/compose/foundation/text/HandleState;", "handleState$delegate", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState", "showFloatingToolbar$delegate", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar", "showSelectionHandleStart$delegate", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart", "showSelectionHandleEnd$delegate", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd", "showCursorHandle$delegate", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle", "isLayoutResultStale", "Z", "isInTouchMode$delegate", "isInTouchMode", "setInTouchMode", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "onValueChangeOriginal", "Lkotlin/jvm/functions/Function1;", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed", "getOnImeActionPerformed", "Landroidx/compose/ui/graphics/Paint;", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "getHighlightPaint", "()Landroidx/compose/ui/graphics/Paint;", "J", "getSelectionBackgroundColor-0d7_KjU", "()J", "setSelectionBackgroundColor-8_81llA", "(J)V", "Landroidx/compose/ui/text/TextRange;", "selectionPreviewHighlightRange$delegate", "getSelectionPreviewHighlightRange-d9O1mEE", "setSelectionPreviewHighlightRange-5zc-tL8", "selectionPreviewHighlightRange", "deletionPreviewHighlightRange$delegate", "getDeletionPreviewHighlightRange-d9O1mEE", "setDeletionPreviewHighlightRange-5zc-tL8", "deletionPreviewHighlightRange", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "layoutResult", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyTextFieldState {
    private LayoutCoordinates _layoutCoordinates;

    /* renamed from: deletionPreviewHighlightRange$delegate, reason: from kotlin metadata */
    private final MutableState deletionPreviewHighlightRange;

    /* renamed from: handleState$delegate, reason: from kotlin metadata */
    private final MutableState handleState;

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus;
    private final Paint highlightPaint;
    private TextInputSession inputSession;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode;
    private boolean isLayoutResultStale;
    private final KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final MutableState<TextLayoutResultProxy> layoutResultState;

    /* renamed from: minHeightForSingleLineField$delegate, reason: from kotlin metadata */
    private final MutableState minHeightForSingleLineField;
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    private final EditProcessor processor = new EditProcessor();
    private final RecomposeScope recomposeScope;
    private long selectionBackgroundColor;

    /* renamed from: selectionPreviewHighlightRange$delegate, reason: from kotlin metadata */
    private final MutableState selectionPreviewHighlightRange;

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle;

    /* renamed from: showFloatingToolbar$delegate, reason: from kotlin metadata */
    private final MutableState showFloatingToolbar;

    /* renamed from: showSelectionHandleEnd$delegate, reason: from kotlin metadata */
    private final MutableState showSelectionHandleEnd;

    /* renamed from: showSelectionHandleStart$delegate, reason: from kotlin metadata */
    private final MutableState showSelectionHandleStart;
    private TextDelegate textDelegate;
    private AnnotatedString untransformedText;

    public LegacyTextFieldState(TextDelegate textDelegate, RecomposeScope recomposeScope, SoftwareKeyboardController softwareKeyboardController) {
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScope;
        this.keyboardController = softwareKeyboardController;
        Boolean bool = Boolean.FALSE;
        this.hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.minHeightForSingleLineField = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m2100boximpl(Dp.m2102constructorimpl(0)), null, 2, null);
        this.layoutResultState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.handleState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HandleState.None, null, 2, null);
        this.showFloatingToolbar = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showSelectionHandleStart = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showSelectionHandleEnd = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isLayoutResultStale = true;
        this.isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.keyboardActionRunner = new KeyboardActionRunner(softwareKeyboardController);
        this.onValueChangeOriginal = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChangeOriginal$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }
        };
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChange$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
                String text = textFieldValue.getText();
                AnnotatedString untransformedText = this.this$0.getUntransformedText();
                if (!Intrinsics.areEqual(text, untransformedText != null ? untransformedText.getText() : null)) {
                    this.this$0.setHandleState(HandleState.None);
                }
                LegacyTextFieldState legacyTextFieldState = this.this$0;
                TextRange.Companion companion = TextRange.INSTANCE;
                legacyTextFieldState.m426setSelectionPreviewHighlightRange5zctL8(companion.m1797getZerod9O1mEE());
                this.this$0.m424setDeletionPreviewHighlightRange5zctL8(companion.m1797getZerod9O1mEE());
                this.this$0.onValueChangeOriginal.invoke(textFieldValue);
                this.this$0.getRecomposeScope().invalidate();
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onImeActionPerformed$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m428invokeKlQnJC8(imeAction.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m428invokeKlQnJC8(int i) {
                this.this$0.keyboardActionRunner.m416runActionKlQnJC8(i);
            }
        };
        this.highlightPaint = AndroidPaint_androidKt.Paint();
        this.selectionBackgroundColor = Color.INSTANCE.m990getUnspecified0d7_KjU();
        TextRange.Companion companion = TextRange.INSTANCE;
        this.selectionPreviewHighlightRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextRange.m1780boximpl(companion.m1797getZerod9O1mEE()), null, 2, null);
        this.deletionPreviewHighlightRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextRange.m1780boximpl(companion.m1797getZerod9O1mEE()), null, 2, null);
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m421getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField.getValue()).getValue();
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m425setMinHeightForSingleLineField0680j_4(float f) {
        this.minHeightForSingleLineField.setValue(Dp.m2100boximpl(f));
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this._layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this._layoutCoordinates = layoutCoordinates;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return this.layoutResultState.getValue();
    }

    public final void setLayoutResult(TextLayoutResultProxy textLayoutResultProxy) {
        this.layoutResultState.setValue(textLayoutResultProxy);
        this.isLayoutResultStale = false;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HandleState getHandleState() {
        return (HandleState) this.handleState.getValue();
    }

    public final void setHandleState(HandleState handleState) {
        this.handleState.setValue(handleState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowFloatingToolbar() {
        return ((Boolean) this.showFloatingToolbar.getValue()).booleanValue();
    }

    public final void setShowFloatingToolbar(boolean z) {
        this.showFloatingToolbar.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleStart(boolean z) {
        this.showSelectionHandleStart.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleEnd(boolean z) {
        this.showSelectionHandleEnd.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* renamed from: isLayoutResultStale, reason: from getter */
    public final boolean getIsLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectionBackgroundColor() {
        return this.selectionBackgroundColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSelectionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m423getSelectionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.selectionPreviewHighlightRange.getValue()).getPackedValue();
    }

    /* renamed from: setSelectionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m426setSelectionPreviewHighlightRange5zctL8(long j) {
        this.selectionPreviewHighlightRange.setValue(TextRange.m1780boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDeletionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m420getDeletionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.deletionPreviewHighlightRange.getValue()).getPackedValue();
    }

    /* renamed from: setDeletionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m424setDeletionPreviewHighlightRange5zctL8(long j) {
        this.deletionPreviewHighlightRange.setValue(TextRange.m1780boximpl(j));
    }

    public final boolean hasHighlight() {
        return (TextRange.m1786getCollapsedimpl(m423getSelectionPreviewHighlightRanged9O1mEE()) && TextRange.m1786getCollapsedimpl(m420getDeletionPreviewHighlightRanged9O1mEE())) ? false : true;
    }

    /* renamed from: update-fnh65Uc, reason: not valid java name */
    public final void m427updatefnh65Uc(AnnotatedString untransformedText, AnnotatedString visualText, TextStyle textStyle, boolean softWrap, Density density, FontFamily.Resolver fontFamilyResolver, Function1<? super TextFieldValue, Unit> onValueChange, KeyboardActions keyboardActions, FocusManager focusManager, long selectionBackgroundColor) {
        this.onValueChangeOriginal = onValueChange;
        this.selectionBackgroundColor = selectionBackgroundColor;
        KeyboardActionRunner keyboardActionRunner = this.keyboardActionRunner;
        keyboardActionRunner.setKeyboardActions(keyboardActions);
        keyboardActionRunner.setFocusManager(focusManager);
        this.untransformedText = untransformedText;
        TextDelegate textDelegateM458updateTextDelegaterm0N8CA = TextDelegateKt.m458updateTextDelegaterm0N8CA(this.textDelegate, visualText, textStyle, density, fontFamilyResolver, (448 & 32) != 0 ? true : softWrap, (448 & 64) != 0 ? TextOverflow.INSTANCE.m2069getClipgIe3tQ8() : 0, (448 & 128) != 0 ? Integer.MAX_VALUE : 0, (448 & 256) != 0 ? 1 : 0, CollectionsKt.emptyList());
        if (this.textDelegate != textDelegateM458updateTextDelegaterm0N8CA) {
            this.isLayoutResultStale = true;
        }
        this.textDelegate = textDelegateM458updateTextDelegaterm0N8CA;
    }
}
