package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: HeightInLinesModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a/\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\r²\u0006\f\u0010\f\u001a\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "", "minLines", "maxLines", "heightInLines", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;II)Landroidx/compose/ui/Modifier;", "", "validateMinMaxLines", "(II)V", "", "typeface", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HeightInLinesModifierKt {
    public static final void validateMinMaxLines(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException(("both minLines " + i + " and maxLines " + i2 + " must be greater than zero").toString());
        }
        if (i <= i2) {
            return;
        }
        throw new IllegalArgumentException(("minLines " + i + " must be less than or equal to maxLines " + i2).toString());
    }

    public static final Modifier heightInLines(Modifier modifier, final TextStyle textStyle, final int i, final int i2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("heightInLines");
                inspectorInfo.getProperties().set("minLines", Integer.valueOf(i));
                inspectorInfo.getProperties().set("maxLines", Integer.valueOf(i2));
                inspectorInfo.getProperties().set("textStyle", textStyle);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt.heightInLines.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i3) {
                composer.startReplaceGroup(408240218);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408240218, i3, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:59)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i, i2);
                if (i == 1 && i2 == Integer.MAX_VALUE) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return companion;
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection);
                TextStyle textStyle2 = textStyle;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TextStyle textStyle3 = (TextStyle) objRememberedValue;
                boolean zChanged2 = composer.changed(resolver) | composer.changed(textStyle3);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = textStyle3.getFontFamily();
                    FontWeight fontWeight = textStyle3.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontStyle fontStyleM1807getFontStyle4Lr2A7w = textStyle3.m1807getFontStyle4Lr2A7w();
                    int value = fontStyleM1807getFontStyle4Lr2A7w != null ? fontStyleM1807getFontStyle4Lr2A7w.getValue() : FontStyle.INSTANCE.m1852getNormal_LCdwA();
                    FontSynthesis fontSynthesisM1808getFontSynthesisZQGJjVo = textStyle3.m1808getFontSynthesisZQGJjVo();
                    objRememberedValue2 = resolver.mo1833resolveDPcqOEQ(fontFamily, fontWeight, value, fontSynthesisM1808getFontSynthesisZQGJjVo != null ? fontSynthesisM1808getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m1862getAllGVVA2EU());
                    composer.updateRememberedValue(objRememberedValue2);
                }
                State state = (State) objRememberedValue2;
                boolean zChanged3 = composer.changed(state.getValue()) | composer.changed(density) | composer.changed(resolver) | composer.changed(textStyle) | composer.changed(layoutDirection);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = Integer.valueOf(IntSize.m2155getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                    composer.updateRememberedValue(objRememberedValue3);
                }
                int iIntValue = ((Number) objRememberedValue3).intValue();
                boolean zChanged4 = composer.changed(layoutDirection) | composer.changed(density) | composer.changed(resolver) | composer.changed(textStyle) | composer.changed(state.getValue());
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = Integer.valueOf(IntSize.m2155getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                    composer.updateRememberedValue(objRememberedValue4);
                }
                int iIntValue2 = ((Number) objRememberedValue4).intValue() - iIntValue;
                int i4 = i;
                Integer numValueOf = i4 == 1 ? null : Integer.valueOf(((i4 - 1) * iIntValue2) + iIntValue);
                int i5 = i2;
                Integer numValueOf2 = i5 != Integer.MAX_VALUE ? Integer.valueOf(iIntValue + (iIntValue2 * (i5 - 1))) : null;
                Modifier modifierM324heightInVpY3zN4 = SizeKt.m324heightInVpY3zN4(Modifier.INSTANCE, numValueOf != null ? density.mo251toDpu2uoSUM(numValueOf.intValue()) : Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM(), numValueOf2 != null ? density.mo251toDpu2uoSUM(numValueOf2.intValue()) : Dp.INSTANCE.m2110getUnspecifiedD9Ej5fM());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM324heightInVpY3zN4;
            }
        });
    }
}
