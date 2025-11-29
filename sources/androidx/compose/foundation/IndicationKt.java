package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Indication.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005\"\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/foundation/Indication;", "indication", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/Indication;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalIndication", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalIndication", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndicationKt {
    private static final ProvidableCompositionLocal<Indication> LocalIndication = CompositionLocalKt.staticCompositionLocalOf(new Function0<Indication>() { // from class: androidx.compose.foundation.IndicationKt$LocalIndication$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Indication invoke() {
            return DefaultDebugIndication.INSTANCE;
        }
    });

    public static final Modifier indication(Modifier modifier, final InteractionSource interactionSource, final Indication indication) {
        if (indication == null) {
            return modifier;
        }
        if (indication instanceof IndicationNodeFactory) {
            return modifier.then(new IndicationModifierElement(interactionSource, (IndicationNodeFactory) indication));
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.IndicationKt$indication$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("indication");
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
                inspectorInfo.getProperties().set("indication", indication);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.IndicationKt.indication.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-353972293);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-353972293, i, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:182)");
                }
                IndicationInstance indicationInstanceRememberUpdatedInstance = indication.rememberUpdatedInstance(interactionSource, composer, 0);
                boolean zChanged = composer.changed(indicationInstanceRememberUpdatedInstance);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new IndicationModifier(indicationInstanceRememberUpdatedInstance);
                    composer.updateRememberedValue(objRememberedValue);
                }
                IndicationModifier indicationModifier = (IndicationModifier) objRememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return indicationModifier;
            }
        });
    }

    public static final ProvidableCompositionLocal<Indication> getLocalIndication() {
        return LocalIndication;
    }
}
