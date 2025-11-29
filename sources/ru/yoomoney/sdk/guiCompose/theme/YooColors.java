package ru.yoomoney.sdk.guiCompose.theme;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.BackgroundColors;
import ru.yoomoney.sdk.guiCompose.theme.ThemeColors;
import ru.yoomoney.sdk.guiCompose.theme.TypeColors;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "", "Lru/yoomoney/sdk/guiCompose/theme/TypeColors;", "type", "Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;", "background", "Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "theme", "<init>", "(Lru/yoomoney/sdk/guiCompose/theme/TypeColors;Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;)V", "copy", "(Lru/yoomoney/sdk/guiCompose/theme/TypeColors;Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;)Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/yoomoney/sdk/guiCompose/theme/TypeColors;", "getType", "()Lru/yoomoney/sdk/guiCompose/theme/TypeColors;", "Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;", "getBackground", "()Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;", "Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "getTheme", "()Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "Companion", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YooColors {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final YooColors defaultColorsDark;
    private static final YooColors defaultColorsLight;
    private final BackgroundColors background;
    private final ThemeColors theme;
    private final TypeColors type;

    public YooColors() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ YooColors copy$default(YooColors yooColors, TypeColors typeColors, BackgroundColors backgroundColors, ThemeColors themeColors, int i, Object obj) {
        if ((i & 1) != 0) {
            typeColors = yooColors.type;
        }
        if ((i & 2) != 0) {
            backgroundColors = yooColors.background;
        }
        if ((i & 4) != 0) {
            themeColors = yooColors.theme;
        }
        return yooColors.copy(typeColors, backgroundColors, themeColors);
    }

    public final YooColors copy(TypeColors type, BackgroundColors background, ThemeColors theme) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(theme, "theme");
        return new YooColors(type, background, theme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YooColors)) {
            return false;
        }
        YooColors yooColors = (YooColors) other;
        return Intrinsics.areEqual(this.type, yooColors.type) && Intrinsics.areEqual(this.background, yooColors.background) && Intrinsics.areEqual(this.theme, yooColors.theme);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.background.hashCode()) * 31) + this.theme.hashCode();
    }

    public String toString() {
        return "YooColors(type=" + this.type + ", background=" + this.background + ", theme=" + this.theme + ")";
    }

    public YooColors(TypeColors type, BackgroundColors background, ThemeColors theme) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.type = type;
        this.background = background;
        this.theme = theme;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ YooColors(ru.yoomoney.sdk.guiCompose.theme.TypeColors r38, ru.yoomoney.sdk.guiCompose.theme.BackgroundColors r39, ru.yoomoney.sdk.guiCompose.theme.ThemeColors r40, int r41, kotlin.jvm.internal.DefaultConstructorMarker r42) {
        /*
            r37 = this;
            r0 = r41 & 1
            if (r0 == 0) goto L23
            ru.yoomoney.sdk.guiCompose.theme.TypeColors r0 = new ru.yoomoney.sdk.guiCompose.theme.TypeColors
            r1 = r0
            r22 = 1023(0x3ff, float:1.434E-42)
            r23 = 0
            r2 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r1.<init>(r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r23)
            goto L25
        L23:
            r0 = r38
        L25:
            r1 = r41 & 2
            if (r1 == 0) goto L55
            ru.yoomoney.sdk.guiCompose.theme.BackgroundColors r1 = new ru.yoomoney.sdk.guiCompose.theme.BackgroundColors
            r2 = r1
            r35 = 65535(0xffff, float:9.1834E-41)
            r36 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r2.<init>(r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36)
            goto L57
        L55:
            r1 = r39
        L57:
            r2 = r41 & 4
            if (r2 == 0) goto L74
            ru.yoomoney.sdk.guiCompose.theme.ThemeColors r2 = new ru.yoomoney.sdk.guiCompose.theme.ThemeColors
            r16 = 63
            r17 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r3 = r2
            r3.<init>(r4, r6, r8, r10, r12, r14, r16, r17)
            r3 = r37
            goto L78
        L74:
            r3 = r37
            r2 = r40
        L78:
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.theme.YooColors.<init>(ru.yoomoney.sdk.guiCompose.theme.TypeColors, ru.yoomoney.sdk.guiCompose.theme.BackgroundColors, ru.yoomoney.sdk.guiCompose.theme.ThemeColors, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TypeColors getType() {
        return this.type;
    }

    public final BackgroundColors getBackground() {
        return this.background;
    }

    public final ThemeColors getTheme() {
        return this.theme;
    }

    /* compiled from: Colors.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/YooColors$Companion;", "", "()V", "defaultColorsDark", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "getDefaultColorsDark", "()Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "defaultColorsLight", "getDefaultColorsLight", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final YooColors getDefaultColorsLight() {
            return YooColors.defaultColorsLight;
        }

        public final YooColors getDefaultColorsDark() {
            return YooColors.defaultColorsDark;
        }
    }

    static {
        TypeColors.Companion companion = TypeColors.INSTANCE;
        TypeColors defaultColorsLight2 = companion.getDefaultColorsLight();
        BackgroundColors.Companion companion2 = BackgroundColors.INSTANCE;
        BackgroundColors defaultColorsLight3 = companion2.getDefaultColorsLight();
        ThemeColors.Companion companion3 = ThemeColors.INSTANCE;
        defaultColorsLight = new YooColors(defaultColorsLight2, defaultColorsLight3, companion3.getDefaultColorsLight());
        defaultColorsDark = new YooColors(companion.getDefaultColorsDark(), companion2.getDefaultColorsDark(), companion3.getDefaultColorsDark());
    }
}
