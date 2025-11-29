package ru.yoomoney.sdk.kassa.payments.ui.compose;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "content", "Landroidx/compose/ui/platform/ComposeView;", "fragmentComposeView", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/platform/ComposeView;", "", "isDarkMode", "MoneyPaymentComposeContent", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "isUiModeDark", "(Landroid/content/Context;)Z", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FragmentComposeViewKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void MoneyPaymentComposeContent(final boolean r9, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r10, androidx.compose.runtime.Composer r11, final int r12, final int r13) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1957316430(0x74aa474e, float:1.0792684E32)
            androidx.compose.runtime.Composer r11 = r11.startRestartGroup(r0)
            r1 = r12 & 14
            if (r1 != 0) goto L1f
            r1 = r13 & 1
            if (r1 != 0) goto L1c
            boolean r1 = r11.changed(r9)
            if (r1 == 0) goto L1c
            r1 = 4
            goto L1d
        L1c:
            r1 = 2
        L1d:
            r1 = r1 | r12
            goto L20
        L1f:
            r1 = r12
        L20:
            r2 = r13 & 2
            if (r2 == 0) goto L27
            r1 = r1 | 48
            goto L37
        L27:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L37
            boolean r2 = r11.changedInstance(r10)
            if (r2 == 0) goto L34
            r2 = 32
            goto L36
        L34:
            r2 = 16
        L36:
            r1 = r1 | r2
        L37:
            r2 = r1 & 91
            r3 = 18
            if (r2 != r3) goto L48
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L44
            goto L48
        L44:
            r11.skipToGroupEnd()
            goto La9
        L48:
            r11.startDefaults()
            r2 = r12 & 1
            if (r2 == 0) goto L60
            boolean r2 = r11.getDefaultsInvalid()
            if (r2 == 0) goto L56
            goto L60
        L56:
            r11.skipToGroupEnd()
            r2 = r13 & 1
            if (r2 == 0) goto L73
        L5d:
            r1 = r1 & (-15)
            goto L73
        L60:
            r2 = r13 & 1
            if (r2 == 0) goto L73
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r9 = r11.consume(r9)
            android.content.Context r9 = (android.content.Context) r9
            boolean r9 = isUiModeDark(r9)
            goto L5d
        L73:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L82
            r2 = -1
            java.lang.String r3 = "ru.yoomoney.sdk.kassa.payments.ui.compose.MoneyPaymentComposeContent (FragmentComposeView.kt:46)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L82:
            ru.yoomoney.sdk.guiCompose.theme.Palette r0 = ru.yoomoney.sdk.kassa.payments.ui.color.PaletteKt.getMSDKTheme()
            int r2 = ru.yoomoney.sdk.guiCompose.theme.Palette.$stable
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r1 = r1 << 9
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r7 = r2 | r1
            r4 = 0
            r8 = 12
            r3 = 0
            r1 = r0
            r2 = r9
            r5 = r10
            r6 = r11
            ru.yoomoney.sdk.guiCompose.theme.ThemesKt.YooTheme(r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto La9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La9:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 == 0) goto Lb7
            ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt$MoneyPaymentComposeContent$1 r0 = new ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt$MoneyPaymentComposeContent$1
            r0.<init>()
            r11.updateScope(r0)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt.MoneyPaymentComposeContent(boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ComposeView fragmentComposeView(Context context, final Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-60345704, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt$fragmentComposeView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-60345704, i, -1, "ru.yoomoney.sdk.kassa.payments.ui.compose.fragmentComposeView.<anonymous>.<anonymous> (FragmentComposeView.kt:38)");
                }
                FragmentComposeViewKt.MoneyPaymentComposeContent(false, content, composer, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return composeView;
    }

    public static final boolean isUiModeDark(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        return configuration != null && (configuration.uiMode & 48) == 32;
    }
}
