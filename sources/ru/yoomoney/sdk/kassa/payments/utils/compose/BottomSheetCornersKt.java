package ru.yoomoney.sdk.kassa.payments.utils.compose;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"roundBottomSheetCorners", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetCornersKt {
    public static final Modifier roundBottomSheetCorners(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceableGroup(1207513179);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1207513179, i, -1, "ru.yoomoney.sdk.kassa.payments.utils.compose.roundBottomSheetCorners (BottomSheetCorners.kt:30)");
        }
        YooTheme yooTheme = YooTheme.INSTANCE;
        int i2 = YooTheme.$stable;
        Modifier modifierClip = ClipKt.clip(modifier, RoundedCornerShapeKt.m401RoundedCornerShapea9UjIt4$default(yooTheme.getDimens(composer, i2).getRadiusL(), yooTheme.getDimens(composer, i2).getRadiusL(), 0.0f, 0.0f, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierClip;
    }
}
