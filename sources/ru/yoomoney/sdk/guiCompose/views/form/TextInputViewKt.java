package ru.yoomoney.sdk.guiCompose.views.form;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: TextInputView.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\u001a)\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001aË\u0001\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002"}, d2 = {"BottomMessage", "", "error", "", "description", "enabled", "", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "TextInputView", "text", "onTextChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "hint", "label", "actionOptions", "Lru/yoomoney/sdk/guiCompose/views/form/ActionOptions;", "readOnly", "onFocusChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/guiCompose/views/form/ActionOptions;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/runtime/Composer;III)V", "guiCompose_release", "hasFocus", "alpha", ""}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextInputViewKt {
    private static final float TextInputView$lambda$11$lambda$9$lambda$7$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final boolean TextInputView$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x077f  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0910  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x094d  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x09ee  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x09fa  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x09fe  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0a68  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0a82  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0b13  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0b2d  */
    /* JADX WARN: Removed duplicated region for block: B:402:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextInputView(java.lang.String r97, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r98, androidx.compose.ui.Modifier r99, java.lang.String r100, java.lang.String r101, java.lang.String r102, java.lang.String r103, ru.yoomoney.sdk.guiCompose.views.form.ActionOptions r104, boolean r105, boolean r106, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r107, androidx.compose.ui.text.input.VisualTransformation r108, androidx.compose.foundation.text.KeyboardOptions r109, androidx.compose.foundation.text.KeyboardActions r110, boolean r111, int r112, androidx.compose.runtime.Composer r113, int r114, int r115, int r116) {
        /*
            Method dump skipped, instructions count: 2896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.form.TextInputViewKt.TextInputView(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, java.lang.String, ru.yoomoney.sdk.guiCompose.views.form.ActionOptions, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextInputView$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomMessage(final String str, final String str2, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(112637745);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(112637745, i2, -1, "ru.yoomoney.sdk.guiCompose.views.form.BottomMessage (TextInputView.kt:215)");
            }
            if (str != null) {
                composerStartRestartGroup.startReplaceableGroup(-1630568056);
                String str3 = z ? str : "";
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "TextInputView.error");
                YooTheme yooTheme = YooTheme.INSTANCE;
                TextKt.m685Text4IGK_g(str3, PaddingKt.m313paddingqDBjuR0$default(modifierTestTag, 0.0f, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceXS(), 0.0f, 0.0f, 13, null), yooTheme.getColors(composerStartRestartGroup, 6).getBackground().getAlert(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, 6).getCaption2(), composerStartRestartGroup, 0, 0, 65528);
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
            } else if (str2 != null) {
                composerStartRestartGroup.startReplaceableGroup(-1630567664);
                String str4 = z ? str2 : "";
                Modifier.Companion companion = Modifier.INSTANCE;
                YooTheme yooTheme2 = YooTheme.INSTANCE;
                Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(companion, 0.0f, yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceXS(), 0.0f, 0.0f, 13, null);
                long ghost = yooTheme2.getColors(composerStartRestartGroup, 6).getType().getGhost();
                TextStyle caption2 = yooTheme2.getTypography(composerStartRestartGroup, 6).getCaption2();
                composer2 = composerStartRestartGroup;
                TextKt.m685Text4IGK_g(str4, modifierM313paddingqDBjuR0$default, ghost, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, caption2, composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(-1630567403);
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.form.TextInputViewKt.BottomMessage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    TextInputViewKt.BottomMessage(str, str2, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
