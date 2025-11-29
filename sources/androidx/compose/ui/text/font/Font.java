package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: Font.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font;", "", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getLoadingStrategy-PKNRLFQ", "()I", "style", "Landroidx/compose/ui/text/font/FontStyle;", "getStyle-_-LCdwA", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "Companion", "ResourceLoader", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Font {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: Font.kt */
    @Deprecated
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font$ResourceLoader;", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResourceLoader {
    }

    /* renamed from: getStyle-_-LCdwA, reason: not valid java name */
    int mo1831getStyle_LCdwA();

    FontWeight getWeight();

    /* renamed from: getLoadingStrategy-PKNRLFQ */
    default int mo1821getLoadingStrategyPKNRLFQ() {
        return FontLoadingStrategy.INSTANCE.m1841getBlockingPKNRLFQ();
    }

    /* compiled from: Font.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/text/font/Font$Companion;", "", "<init>", "()V", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
