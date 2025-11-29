package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Typography.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b(\u0010'R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b*\u0010'R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b+\u0010'R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b-\u0010'R\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b.\u0010'R\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b/\u0010'R\u0017\u0010\u0010\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b0\u0010'R\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b1\u0010'R\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b2\u0010'R\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b3\u0010'R\u0017\u0010\u0014\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b4\u0010'R\u0017\u0010\u0015\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b5\u0010'R\u0017\u0010\u0016\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b6\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/Typography;", "", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "Landroidx/compose/ui/text/TextStyle;", "header", "display1", "display2", "title1", "title2", "title3", "headline1", "headline2", "body", "bodyMedium", "bodyBold16", "caption1", "caption1Medium", "caption2", "captionBar", "caption14", "<init>", "(Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/text/font/FontFamily;", "J", "Landroidx/compose/ui/text/TextStyle;", "getHeader", "()Landroidx/compose/ui/text/TextStyle;", "getDisplay1", "getDisplay2", "getTitle1", "getTitle2", "getTitle3", "getHeadline1", "getHeadline2", "getBody", "getBodyMedium", "getBodyBold16", "getCaption1", "getCaption1Medium", "getCaption2", "getCaptionBar", "getCaption14", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Typography {
    private final TextStyle body;
    private final TextStyle bodyBold16;
    private final TextStyle bodyMedium;
    private final TextStyle caption1;
    private final TextStyle caption14;
    private final TextStyle caption1Medium;
    private final TextStyle caption2;
    private final TextStyle captionBar;
    private final long color;
    private final TextStyle display1;
    private final TextStyle display2;
    private final FontFamily fontFamily;
    private final TextStyle header;
    private final TextStyle headline1;
    private final TextStyle headline2;
    private final TextStyle title1;
    private final TextStyle title2;
    private final TextStyle title3;

    public /* synthetic */ Typography(FontFamily fontFamily, long j, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, TextStyle textStyle16, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontFamily, j, textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13, textStyle14, textStyle15, textStyle16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) other;
        return Intrinsics.areEqual(this.fontFamily, typography.fontFamily) && Color.m977equalsimpl0(this.color, typography.color) && Intrinsics.areEqual(this.header, typography.header) && Intrinsics.areEqual(this.display1, typography.display1) && Intrinsics.areEqual(this.display2, typography.display2) && Intrinsics.areEqual(this.title1, typography.title1) && Intrinsics.areEqual(this.title2, typography.title2) && Intrinsics.areEqual(this.title3, typography.title3) && Intrinsics.areEqual(this.headline1, typography.headline1) && Intrinsics.areEqual(this.headline2, typography.headline2) && Intrinsics.areEqual(this.body, typography.body) && Intrinsics.areEqual(this.bodyMedium, typography.bodyMedium) && Intrinsics.areEqual(this.bodyBold16, typography.bodyBold16) && Intrinsics.areEqual(this.caption1, typography.caption1) && Intrinsics.areEqual(this.caption1Medium, typography.caption1Medium) && Intrinsics.areEqual(this.caption2, typography.caption2) && Intrinsics.areEqual(this.captionBar, typography.captionBar) && Intrinsics.areEqual(this.caption14, typography.caption14);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.fontFamily.hashCode() * 31) + Color.m983hashCodeimpl(this.color)) * 31) + this.header.hashCode()) * 31) + this.display1.hashCode()) * 31) + this.display2.hashCode()) * 31) + this.title1.hashCode()) * 31) + this.title2.hashCode()) * 31) + this.title3.hashCode()) * 31) + this.headline1.hashCode()) * 31) + this.headline2.hashCode()) * 31) + this.body.hashCode()) * 31) + this.bodyMedium.hashCode()) * 31) + this.bodyBold16.hashCode()) * 31) + this.caption1.hashCode()) * 31) + this.caption1Medium.hashCode()) * 31) + this.caption2.hashCode()) * 31) + this.captionBar.hashCode()) * 31) + this.caption14.hashCode();
    }

    public String toString() {
        return "Typography(fontFamily=" + this.fontFamily + ", color=" + Color.m984toStringimpl(this.color) + ", header=" + this.header + ", display1=" + this.display1 + ", display2=" + this.display2 + ", title1=" + this.title1 + ", title2=" + this.title2 + ", title3=" + this.title3 + ", headline1=" + this.headline1 + ", headline2=" + this.headline2 + ", body=" + this.body + ", bodyMedium=" + this.bodyMedium + ", bodyBold16=" + this.bodyBold16 + ", caption1=" + this.caption1 + ", caption1Medium=" + this.caption1Medium + ", caption2=" + this.caption2 + ", captionBar=" + this.captionBar + ", caption14=" + this.caption14 + ")";
    }

    private Typography(FontFamily fontFamily, long j, TextStyle header, TextStyle display1, TextStyle display2, TextStyle title1, TextStyle title2, TextStyle title3, TextStyle headline1, TextStyle headline2, TextStyle body, TextStyle bodyMedium, TextStyle bodyBold16, TextStyle caption1, TextStyle caption1Medium, TextStyle caption2, TextStyle captionBar, TextStyle caption14) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(display1, "display1");
        Intrinsics.checkNotNullParameter(display2, "display2");
        Intrinsics.checkNotNullParameter(title1, "title1");
        Intrinsics.checkNotNullParameter(title2, "title2");
        Intrinsics.checkNotNullParameter(title3, "title3");
        Intrinsics.checkNotNullParameter(headline1, "headline1");
        Intrinsics.checkNotNullParameter(headline2, "headline2");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(bodyMedium, "bodyMedium");
        Intrinsics.checkNotNullParameter(bodyBold16, "bodyBold16");
        Intrinsics.checkNotNullParameter(caption1, "caption1");
        Intrinsics.checkNotNullParameter(caption1Medium, "caption1Medium");
        Intrinsics.checkNotNullParameter(caption2, "caption2");
        Intrinsics.checkNotNullParameter(captionBar, "captionBar");
        Intrinsics.checkNotNullParameter(caption14, "caption14");
        this.fontFamily = fontFamily;
        this.color = j;
        this.header = header;
        this.display1 = display1;
        this.display2 = display2;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.headline1 = headline1;
        this.headline2 = headline2;
        this.body = body;
        this.bodyMedium = bodyMedium;
        this.bodyBold16 = bodyBold16;
        this.caption1 = caption1;
        this.caption1Medium = caption1Medium;
        this.caption2 = caption2;
        this.captionBar = captionBar;
        this.caption14 = caption14;
    }

    public /* synthetic */ Typography(FontFamily fontFamily, long j, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, TextStyle textStyle16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TextStyle textStyle17;
        TextStyle textStyle18;
        TextStyle textStyle19;
        TextStyle textStyle20;
        TextStyle textStyle21;
        TextStyle textStyle22;
        TextStyle textStyle23;
        TextStyle textStyle24;
        TextStyle textStyle25;
        TextStyle textStyle26;
        TextStyle textStyle27;
        TextStyle textStyle28;
        TextStyle textStyle29;
        TextStyle textStyle30;
        TextStyle textStyle31;
        TextStyle textStyle32;
        FontFamily defaultFontFamily = (i & 1) != 0 ? TypographyKt.getDefaultFontFamily() : fontFamily;
        long primary = (i & 2) != 0 ? TypeColors.INSTANCE.getDefaultColorsLight().getPrimary() : j;
        if ((i & 4) != 0) {
            textStyle17 = new TextStyle(primary, TextUnitKt.getSp(50), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(50), null, null, null, 0, 0, null, 16646104, null);
        } else {
            textStyle17 = textStyle;
        }
        if ((i & 8) != 0) {
            textStyle18 = new TextStyle(primary, TextUnitKt.getSp(60), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.82d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(64), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle18 = textStyle2;
        }
        if ((i & 16) != 0) {
            textStyle19 = new TextStyle(primary, TextUnitKt.getSp(48), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(52), null, null, null, 0, 0, null, 16646104, null);
        } else {
            textStyle19 = textStyle3;
        }
        if ((i & 32) != 0) {
            textStyle20 = new TextStyle(primary, TextUnitKt.getSp(34), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(40), null, null, null, 0, 0, null, 16646104, null);
        } else {
            textStyle20 = textStyle4;
        }
        if ((i & 64) != 0) {
            textStyle21 = new TextStyle(primary, TextUnitKt.getSp(25), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.36d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(28), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle21 = textStyle5;
        }
        if ((i & 128) != 0) {
            textStyle22 = new TextStyle(primary, TextUnitKt.getSp(19), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.38d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(24), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle22 = textStyle6;
        }
        if ((i & 256) != 0) {
            textStyle23 = new TextStyle(primary, TextUnitKt.getSp(13), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.2d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(18), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle23 = textStyle7;
        }
        if ((i & 512) != 0) {
            textStyle24 = new TextStyle(primary, TextUnitKt.getSp(12), FontWeight.INSTANCE.getNormal(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.4d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(16), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle24 = textStyle8;
        }
        if ((i & 1024) != 0) {
            textStyle25 = new TextStyle(primary, TextUnitKt.getSp(16), FontWeight.INSTANCE.getNormal(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.2d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(22), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle25 = textStyle9;
        }
        if ((i & 2048) != 0) {
            textStyle26 = new TextStyle(primary, TextUnitKt.getSp(16), FontWeight.INSTANCE.getMedium(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.2d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(22), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle26 = textStyle10;
        }
        if ((i & 4096) != 0) {
            textStyle27 = new TextStyle(primary, TextUnitKt.getSp(16), FontWeight.INSTANCE.getBold(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.2d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle27 = textStyle11;
        }
        if ((i & 8192) != 0) {
            textStyle28 = new TextStyle(primary, TextUnitKt.getSp(13), FontWeight.INSTANCE.getNormal(), null, null, defaultFontFamily, null, TextUnitKt.getSp(-0.08d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(16), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle28 = textStyle12;
        }
        if ((i & 16384) != 0) {
            textStyle29 = new TextStyle(primary, TextUnitKt.getSp(13), FontWeight.INSTANCE.getMedium(), null, null, defaultFontFamily, null, TextUnitKt.getSp(-0.08d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(16), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle29 = textStyle13;
        }
        if ((32768 & i) != 0) {
            textStyle30 = new TextStyle(primary, TextUnitKt.getSp(11), FontWeight.INSTANCE.getNormal(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.07d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(13), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle30 = textStyle14;
        }
        if ((65536 & i) != 0) {
            textStyle31 = new TextStyle(primary, TextUnitKt.getSp(12), FontWeight.INSTANCE.getMedium(), null, null, defaultFontFamily, null, TextUnitKt.getSp(-0.08d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(16), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle31 = textStyle15;
        }
        if ((i & 131072) != 0) {
            textStyle32 = new TextStyle(primary, TextUnitKt.getSp(14), FontWeight.INSTANCE.getNormal(), null, null, defaultFontFamily, null, TextUnitKt.getSp(0.2d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16645976, null);
        } else {
            textStyle32 = textStyle16;
        }
        this(defaultFontFamily, primary, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26, textStyle27, textStyle28, textStyle29, textStyle30, textStyle31, textStyle32, null);
    }

    public final TextStyle getTitle1() {
        return this.title1;
    }

    public final TextStyle getTitle3() {
        return this.title3;
    }

    public final TextStyle getBody() {
        return this.body;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getCaption1() {
        return this.caption1;
    }

    public final TextStyle getCaption1Medium() {
        return this.caption1Medium;
    }

    public final TextStyle getCaption2() {
        return this.caption2;
    }
}
