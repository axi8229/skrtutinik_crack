package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/UiParameters;", "Landroid/os/Parcelable;", "showLogo", "", "colorScheme", "Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "(ZLru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;)V", "getColorScheme", "()Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "getShowLogo", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public final /* data */ class UiParameters implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UiParameters> CREATOR = new h();

    @Keep
    private final ColorScheme colorScheme;

    @Keep
    private final boolean showLogo;

    @Keep
    public UiParameters() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UiParameters copy$default(UiParameters uiParameters, boolean z, ColorScheme colorScheme, int i, Object obj) {
        if ((i & 1) != 0) {
            z = uiParameters.showLogo;
        }
        if ((i & 2) != 0) {
            colorScheme = uiParameters.colorScheme;
        }
        return uiParameters.copy(z, colorScheme);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowLogo() {
        return this.showLogo;
    }

    /* renamed from: component2, reason: from getter */
    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public final UiParameters copy(boolean showLogo, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        return new UiParameters(showLogo, colorScheme);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiParameters)) {
            return false;
        }
        UiParameters uiParameters = (UiParameters) other;
        return this.showLogo == uiParameters.showLogo && Intrinsics.areEqual(this.colorScheme, uiParameters.colorScheme);
    }

    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public int hashCode() {
        return this.colorScheme.hashCode() + (Boolean.hashCode(this.showLogo) * 31);
    }

    public String toString() {
        return "UiParameters(showLogo=" + this.showLogo + ", colorScheme=" + this.colorScheme + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.showLogo ? 1 : 0);
        parcel.writeParcelable(this.colorScheme, flags);
    }

    @Keep
    public UiParameters(boolean z) {
        this(z, null, 2, 0 == true ? 1 : 0);
    }

    @Keep
    public UiParameters(boolean z, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.showLogo = z;
        this.colorScheme = colorScheme;
    }

    public /* synthetic */ UiParameters(boolean z, ColorScheme colorScheme, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? ColorScheme.INSTANCE.getDefaultScheme() : colorScheme);
    }
}
