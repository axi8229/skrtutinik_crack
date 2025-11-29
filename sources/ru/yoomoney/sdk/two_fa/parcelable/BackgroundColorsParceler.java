package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import ru.yoomoney.sdk.guiCompose.theme.BackgroundColors;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/BackgroundColorsParceler;", "Lkotlinx/parcelize/Parceler;", "Lru/yoomoney/sdk/guiCompose/theme/BackgroundColors;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackgroundColorsParceler implements Parceler<BackgroundColors> {
    public static final int $stable = 0;
    public static final BackgroundColorsParceler INSTANCE = new BackgroundColorsParceler();

    private BackgroundColorsParceler() {
    }

    public BackgroundColors[] newArray(int i) {
        return (BackgroundColors[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public BackgroundColors create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new BackgroundColors(Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), null);
    }

    public void write(BackgroundColors backgroundColors, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(backgroundColors, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport31.m(backgroundColors.getDefault(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport24.m(backgroundColors.getCard(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport21.m(backgroundColors.getDivider(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport27.m(backgroundColors.getBorder(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport17.m(backgroundColors.getGhost(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport29.m(backgroundColors.getTone(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport19.m(backgroundColors.getInverse(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport18.m(backgroundColors.getSuccess(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport23.m(backgroundColors.getAlert(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport25.m(backgroundColors.getGhostAlert(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport28.m(backgroundColors.getActionRipple(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport16.m(backgroundColors.getActionRippleInverse(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport20.m(backgroundColors.getWhite(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport26.m(backgroundColors.getBlack(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport30.m(backgroundColors.getCardInverse(), 10));
        parcel.writeString(BackgroundColorsParceler$$ExternalSyntheticBackport22.m(backgroundColors.getIconBar(), 10));
    }
}
