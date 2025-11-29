package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import ru.yoomoney.sdk.guiCompose.theme.TypeColors;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/TypeColorsParceler;", "Lkotlinx/parcelize/Parceler;", "Lru/yoomoney/sdk/guiCompose/theme/TypeColors;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeColorsParceler implements Parceler<TypeColors> {
    public static final int $stable = 0;
    public static final TypeColorsParceler INSTANCE = new TypeColorsParceler();

    private TypeColorsParceler() {
    }

    public TypeColors[] newArray(int i) {
        return (TypeColors[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public TypeColors create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new TypeColors(Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), Color.m972constructorimpl(ComposeStyleParcelableKt.readULong(parcel)), null);
    }

    public void write(TypeColors typeColors, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(typeColors, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport17.m(typeColors.getPrimary(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport13.m(typeColors.getSecondary(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport18.m(typeColors.getGhost(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport14.m(typeColors.getInverse(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport19.m(typeColors.getSecondaryInverse(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport10.m(typeColors.getGhostInverse(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport16.m(typeColors.getSuccess(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport12.m(typeColors.getAlert(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport15.m(typeColors.getBlack(), 10));
        parcel.writeString(TypeColorsParceler$$ExternalSyntheticBackport11.m(typeColors.getDisable(), 10));
    }
}
