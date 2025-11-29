package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B7\b\u0000\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/ThemeScheme;", "Landroid/os/Parcelable;", "themeRes", "", "accentColor", "secondaryAccentColor", "thirdAccentColor", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAccentColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecondaryAccentColor", "getThemeRes", "getThirdAccentColor", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThemeScheme implements Parcelable {
    private final Integer accentColor;
    private final Integer secondaryAccentColor;
    private final Integer themeRes;
    private final Integer thirdAccentColor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ThemeScheme> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0006J7\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/ThemeScheme$Companion;", "", "()V", "byAccentColor", "Lru/yoomoney/sdk/auth/ThemeScheme;", "accentColor", "", "secondaryAccentColor", "thirdAccentColor", "(ILjava/lang/Integer;Ljava/lang/Integer;)Lru/yoomoney/sdk/auth/ThemeScheme;", "byThemeRes", "themeRes", "byThemeResAndAccentColor", "(IILjava/lang/Integer;Ljava/lang/Integer;)Lru/yoomoney/sdk/auth/ThemeScheme;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ThemeScheme byAccentColor$default(Companion companion, int i, Integer num, Integer num2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                num = null;
            }
            if ((i2 & 4) != 0) {
                num2 = null;
            }
            return companion.byAccentColor(i, num, num2);
        }

        public static /* synthetic */ ThemeScheme byThemeResAndAccentColor$default(Companion companion, int i, int i2, Integer num, Integer num2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                num = null;
            }
            if ((i3 & 8) != 0) {
                num2 = null;
            }
            return companion.byThemeResAndAccentColor(i, i2, num, num2);
        }

        public final ThemeScheme byAccentColor(int accentColor, Integer secondaryAccentColor, Integer thirdAccentColor) {
            return new ThemeScheme(null, Integer.valueOf(accentColor), secondaryAccentColor, thirdAccentColor, 1, null);
        }

        public final ThemeScheme byThemeRes(int themeRes) {
            return new ThemeScheme(Integer.valueOf(themeRes), null, null, null, 14, null);
        }

        public final ThemeScheme byThemeResAndAccentColor(int themeRes, int accentColor, Integer secondaryAccentColor, Integer thirdAccentColor) {
            return new ThemeScheme(Integer.valueOf(themeRes), Integer.valueOf(accentColor), secondaryAccentColor, thirdAccentColor);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ThemeScheme> {
        @Override // android.os.Parcelable.Creator
        public final ThemeScheme createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ThemeScheme(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final ThemeScheme[] newArray(int i) {
            return new ThemeScheme[i];
        }
    }

    public ThemeScheme() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Integer getAccentColor() {
        return this.accentColor;
    }

    public final Integer getSecondaryAccentColor() {
        return this.secondaryAccentColor;
    }

    public final Integer getThemeRes() {
        return this.themeRes;
    }

    public final Integer getThirdAccentColor() {
        return this.thirdAccentColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.themeRes;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.accentColor;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.secondaryAccentColor;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.thirdAccentColor;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
    }

    public ThemeScheme(Integer num, Integer num2, Integer num3, Integer num4) {
        this.themeRes = num;
        this.accentColor = num2;
        this.secondaryAccentColor = num3;
        this.thirdAccentColor = num4;
    }

    public /* synthetic */ ThemeScheme(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }
}
