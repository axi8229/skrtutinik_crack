package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import ru.yoomoney.sdk.guiCompose.theme.ThemeColors;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/ThemeColorsParceler;", "Lkotlinx/parcelize/Parceler;", "Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThemeColorsParceler implements Parceler<ThemeColors> {
    public static final int $stable = 0;
    public static final ThemeColorsParceler INSTANCE = new ThemeColorsParceler();

    private ThemeColorsParceler() {
    }

    public ThemeColors[] newArray(int i) {
        return (ThemeColors[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public ThemeColors create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ThemeColors(Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), null);
    }

    public void write(ThemeColors themeColors, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(themeColors, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport8.m(themeColors.getTint(), 10));
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport11.m(themeColors.getTintFade(), 10));
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport7.m(themeColors.getTintGhost(), 10));
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport10.m(themeColors.getTintBg(), 10));
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport9.m(themeColors.getTintCard(), 10));
        parcel.writeString(ThemeColorsParceler$$ExternalSyntheticBackport6.m(themeColors.getTintSelection(), 10));
    }
}
