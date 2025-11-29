package ru.yoomoney.sdk.kassa.payments.ui.color;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.huawei.hms.framework.common.EmuiUtil;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "Landroid/os/Parcelable;", "primaryColor", "", "(I)V", EmuiUtil.GET_PRIMARY_COLOR, "()I", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
/* loaded from: classes5.dex */
public class ColorScheme implements Parcelable {
    public static final int $stable = 0;

    @Keep
    private final int primaryColor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ColorScheme> CREATOR = new Creator();
    private static final int defaultPrimaryColor = Color.rgb(0, 112, 240);
    private static final int legacyPrimaryColor = Color.rgb(KotlinVersion.MAX_COMPONENT_VALUE, 219, 77);

    @Keep
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme$Companion;", "", "()V", "defaultPrimaryColor", "", "getDefaultPrimaryColor", "()I", "legacyPrimaryColor", "getDefaultScheme", "Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "getLegacyScheme", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDefaultPrimaryColor() {
            return ColorScheme.defaultPrimaryColor;
        }

        @JvmStatic
        @Keep
        public final ColorScheme getDefaultScheme() {
            return new ColorScheme(getDefaultPrimaryColor());
        }

        @JvmStatic
        @Keep
        public final ColorScheme getLegacyScheme() {
            return new ColorScheme(ColorScheme.legacyPrimaryColor);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ColorScheme> {
        @Override // android.os.Parcelable.Creator
        public final ColorScheme createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ColorScheme(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ColorScheme[] newArray(int i) {
            return new ColorScheme[i];
        }
    }

    @Keep
    public ColorScheme(int i) {
        this.primaryColor = i;
    }

    @JvmStatic
    @Keep
    public static final ColorScheme getDefaultScheme() {
        return INSTANCE.getDefaultScheme();
    }

    @JvmStatic
    @Keep
    public static final ColorScheme getLegacyScheme() {
        return INSTANCE.getLegacyScheme();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getPrimaryColor() {
        return this.primaryColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.primaryColor);
    }
}
