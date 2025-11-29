package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ComposedModifier.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0000*\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "inspectorInfo", "factory", "composed", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composer;", "modifier", "materializeModifier", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "materialize", "materializeImpl", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposedModifierKt {
    public static /* synthetic */ Modifier composed$default(Modifier modifier, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, function1, function3);
    }

    public static final Modifier composed(Modifier modifier, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        return modifier.then(new ComposedModifier(function1, function3));
    }

    public static final Modifier materializeModifier(Composer composer, Modifier modifier) {
        composer.startReplaceGroup(439770924);
        Modifier modifierMaterializeImpl = materializeImpl(composer, modifier);
        composer.endReplaceGroup();
        return modifierMaterializeImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier materializeImpl(final Composer composer, Modifier modifier) {
        if (modifier.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt.materializeImpl.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Modifier.Element element) {
                return Boolean.valueOf(!(element instanceof ComposedModifier));
            }
        })) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.INSTANCE, new Function2<Modifier, Modifier.Element, Modifier>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$result$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Modifier invoke(Modifier modifier3, Modifier.Element element) {
                boolean z = element instanceof ComposedModifier;
                Modifier modifierMaterializeImpl = element;
                if (z) {
                    Function3<Modifier, Composer, Integer, Modifier> factory = ((ComposedModifier) element).getFactory();
                    Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    modifierMaterializeImpl = ComposedModifierKt.materializeImpl(composer, (Modifier) ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 3)).invoke(Modifier.INSTANCE, composer, 0));
                }
                return modifier3.then(modifierMaterializeImpl);
            }
        });
        composer.endReplaceableGroup();
        return modifier2;
    }
}
