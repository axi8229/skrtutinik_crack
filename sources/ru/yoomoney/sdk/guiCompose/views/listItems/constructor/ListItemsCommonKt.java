package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: ListItemsCommon.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001aD\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aD\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a$\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/BoxScope;", "", "ListItemDivider", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/runtime/Composer;I)V", "", "text", "Landroidx/compose/ui/Modifier;", "modifier", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "titleType", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "", "multiline", "ListItemTitleText-Sj8uqqQ", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;Landroidx/compose/ui/graphics/Color;ZLandroidx/compose/runtime/Composer;II)V", "ListItemTitleText", "ListItemSubtitleText-Sj8uqqQ", "ListItemSubtitleText", "getTextColor-bMF-p3s", "(Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;I)J", "getTextColor", "textType", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "(Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListItemsCommonKt {

    /* compiled from: ListItemsCommon.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextType.values().length];
            try {
                iArr[TextType.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextType.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void ListItemDivider(final BoxScope boxScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-960483859);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-960483859, i2, -1, "ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemDivider (ListItemsCommon.kt:20)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            SpacerKt.Spacer(boxScope.align(BackgroundKt.m166backgroundbw27NRU$default(SizeKt.m323height3ABfNKs(modifierFillMaxWidth$default, yooTheme.getDimens(composerStartRestartGroup, 6).getDividerHeight()), yooTheme.getColors(composerStartRestartGroup, 6).getBackground().getDivider(), null, 2, null), Alignment.INSTANCE.getBottomCenter()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsCommonKt.ListItemDivider.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ListItemsCommonKt.ListItemDivider(boxScope, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* renamed from: ListItemTitleText-Sj8uqqQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m3444ListItemTitleTextSj8uqqQ(final java.lang.String r32, androidx.compose.ui.Modifier r33, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.TextType r34, androidx.compose.ui.graphics.Color r35, boolean r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsCommonKt.m3444ListItemTitleTextSj8uqqQ(java.lang.String, androidx.compose.ui.Modifier, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.TextType, androidx.compose.ui.graphics.Color, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* renamed from: ListItemSubtitleText-Sj8uqqQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m3443ListItemSubtitleTextSj8uqqQ(final java.lang.String r32, androidx.compose.ui.Modifier r33, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.TextType r34, androidx.compose.ui.graphics.Color r35, boolean r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsCommonKt.m3443ListItemSubtitleTextSj8uqqQ(java.lang.String, androidx.compose.ui.Modifier, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.TextType, androidx.compose.ui.graphics.Color, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: getTextColor-bMF-p3s, reason: not valid java name */
    private static final long m3445getTextColorbMFp3s(TextType textType, Color color, Composer composer, int i) {
        long primary;
        composer.startReplaceableGroup(-249567951);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-249567951, i, -1, "ru.yoomoney.sdk.guiCompose.views.listItems.constructor.getTextColor (ListItemsCommon.kt:70)");
        }
        if (color != null) {
            composer.startReplaceableGroup(869939135);
            composer.endReplaceableGroup();
            primary = color.getValue();
        } else if (textType == TextType.PRIMARY) {
            composer.startReplaceableGroup(869939199);
            primary = YooTheme.INSTANCE.getColors(composer, 6).getType().getPrimary();
            composer.endReplaceableGroup();
        } else if (textType == TextType.SECONDARY) {
            composer.startReplaceableGroup(869939267);
            primary = YooTheme.INSTANCE.getColors(composer, 6).getType().getSecondary();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(869939310);
            primary = YooTheme.INSTANCE.getColors(composer, 6).getType().getPrimary();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return primary;
    }

    private static final TextStyle getTextStyle(TextType textType, Composer composer, int i) {
        TextStyle bodyMedium;
        composer.startReplaceableGroup(-1499680715);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1499680715, i, -1, "ru.yoomoney.sdk.guiCompose.views.listItems.constructor.getTextStyle (ListItemsCommon.kt:80)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[textType.ordinal()];
        if (i2 == 1) {
            composer.startReplaceableGroup(1333007465);
            bodyMedium = YooTheme.INSTANCE.getTypography(composer, 6).getBodyMedium();
            composer.endReplaceableGroup();
        } else {
            if (i2 != 2) {
                composer.startReplaceableGroup(1333005066);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceableGroup(1333007522);
            bodyMedium = YooTheme.INSTANCE.getTypography(composer, 6).getBody();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bodyMedium;
    }
}
