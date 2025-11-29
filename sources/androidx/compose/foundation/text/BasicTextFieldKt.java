package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a×\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a×\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020 2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001e\u0010!\"\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006.²\u0006\f\u0010)\u001a\u00020(8\nX\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u00020(8\nX\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u00020(8\nX\u008a\u0084\u0002²\u0006\u000e\u0010,\u001a\u00020 8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010-\u001a\u00020\u00008\n@\nX\u008a\u008e\u0002"}, d2 = {"", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function1;", "", "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "readOnly", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "singleLine", "", "maxLines", "minLines", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/TextLayoutResult;", "onTextLayout", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Brush;", "cursorBrush", "Lkotlin/Function0;", "decorationBox", "BasicTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Landroidx/compose/ui/unit/DpSize;", "MinTouchTargetSizeForHandles", "J", "", "cursorHandleState", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = new TextFieldDecorator() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$DefaultTextFieldDecorator$1
    };
    private static final long MinTouchTargetSizeForHandles;

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$21(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    static {
        float f = 40;
        MinTouchTargetSizeForHandles = DpKt.m2112DpSizeYgX7TsA(Dp.m2102constructorimpl(f), Dp.m2102constructorimpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final java.lang.String r41, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r42, androidx.compose.ui.Modifier r43, boolean r44, boolean r45, androidx.compose.ui.text.TextStyle r46, androidx.compose.foundation.text.KeyboardOptions r47, androidx.compose.foundation.text.KeyboardActions r48, boolean r49, int r50, int r51, androidx.compose.ui.text.input.VisualTransformation r52, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.ui.graphics.Brush r55, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, androidx.compose.runtime.Composer r57, final int r58, final int r59, final int r60) {
        /*
            Method dump skipped, instructions count: 1159
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r37, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, int r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
