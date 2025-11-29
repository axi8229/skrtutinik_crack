package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.Palette;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/PaletteParcelable;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lru/yoomoney/sdk/guiCompose/theme/Palette;", "(Lru/yoomoney/sdk/guiCompose/theme/Palette;)V", "getValue", "()Lru/yoomoney/sdk/guiCompose/theme/Palette;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaletteParcelable implements Parcelable {
    public static final int $stable = Palette.$stable;
    public static final Parcelable.Creator<PaletteParcelable> CREATOR = new Creator();
    private final Palette value;

    /* compiled from: ComposeStyleParcelable.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaletteParcelable> {
        @Override // android.os.Parcelable.Creator
        public final PaletteParcelable createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaletteParcelable(PaletteParceler.INSTANCE.create(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final PaletteParcelable[] newArray(int i) {
            return new PaletteParcelable[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        PaletteParceler.INSTANCE.write(this.value, parcel, flags);
    }

    public PaletteParcelable(Palette value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final Palette getValue() {
        return this.value;
    }
}
