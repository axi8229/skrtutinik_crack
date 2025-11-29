package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import ru.yoomoney.sdk.guiCompose.theme.Palette;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/PaletteParceler;", "Lkotlinx/parcelize/Parceler;", "Lru/yoomoney/sdk/guiCompose/theme/Palette;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaletteParceler implements Parceler<Palette> {
    public static final int $stable = 0;
    public static final PaletteParceler INSTANCE = new PaletteParceler();

    private PaletteParceler() {
    }

    public Palette[] newArray(int i) {
        return (Palette[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public Palette create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        YooColorsParceler yooColorsParceler = YooColorsParceler.INSTANCE;
        return new Palette(yooColorsParceler.create(parcel), yooColorsParceler.create(parcel));
    }

    public void write(Palette palette, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(palette, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        YooColorsParceler yooColorsParceler = YooColorsParceler.INSTANCE;
        yooColorsParceler.write(palette.getLight(), parcel, i);
        yooColorsParceler.write(palette.getDark(), parcel, i);
    }
}
