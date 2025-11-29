package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÆ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a%\u0010)\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0'H\u0007¢\u0006\u0004\b)\u0010*\"\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"", "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "letterSpacing", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "lineHeight", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "", "softWrap", "", "maxLines", "minLines", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "onTextLayout", "Landroidx/compose/ui/text/TextStyle;", "style", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function0;", "content", "ProvideTextStyle", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m685Text4IGK_g(final java.lang.String r68, androidx.compose.ui.Modifier r69, long r70, long r72, androidx.compose.ui.text.font.FontStyle r74, androidx.compose.ui.text.font.FontWeight r75, androidx.compose.ui.text.font.FontFamily r76, long r77, androidx.compose.ui.text.style.TextDecoration r79, androidx.compose.ui.text.style.TextAlign r80, long r81, int r83, boolean r84, int r85, int r86, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r87, androidx.compose.ui.text.TextStyle r88, androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m685Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    @kotlin.Deprecated
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m686TextfLXpl1I(final java.lang.String r54, androidx.compose.ui.Modifier r55, long r56, long r58, androidx.compose.ui.text.font.FontStyle r60, androidx.compose.ui.text.font.FontWeight r61, androidx.compose.ui.text.font.FontFamily r62, long r63, androidx.compose.ui.text.style.TextDecoration r65, androidx.compose.ui.text.style.TextAlign r66, long r67, int r69, boolean r70, int r71, kotlin.jvm.functions.Function1 r72, androidx.compose.ui.text.TextStyle r73, androidx.compose.runtime.Composer r74, final int r75, final int r76, final int r77) {
        /*
            Method dump skipped, instructions count: 947
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m686TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1772272796);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) composerStartRestartGroup.consume(providableCompositionLocal)).merge(textStyle)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt.ProvideTextStyle.1
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
                    TextKt.ProvideTextStyle(textStyle, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
