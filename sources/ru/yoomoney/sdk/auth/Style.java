package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/Style;", "Landroid/os/Parcelable;", "themeScheme", "Lru/yoomoney/sdk/auth/ThemeScheme;", "composeStyle", "Lru/yoomoney/sdk/auth/ComposeStyle;", "(Lru/yoomoney/sdk/auth/ThemeScheme;Lru/yoomoney/sdk/auth/ComposeStyle;)V", "getComposeStyle", "()Lru/yoomoney/sdk/auth/ComposeStyle;", "getThemeScheme", "()Lru/yoomoney/sdk/auth/ThemeScheme;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Style implements Parcelable {
    public static final Parcelable.Creator<Style> CREATOR = new Creator();
    private final ComposeStyle composeStyle;
    private final ThemeScheme themeScheme;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Style> {
        @Override // android.os.Parcelable.Creator
        public final Style createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Style(parcel.readInt() == 0 ? null : ThemeScheme.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ComposeStyle.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Style[] newArray(int i) {
            return new Style[i];
        }
    }

    public Style() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Style copy$default(Style style, ThemeScheme themeScheme, ComposeStyle composeStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            themeScheme = style.themeScheme;
        }
        if ((i & 2) != 0) {
            composeStyle = style.composeStyle;
        }
        return style.copy(themeScheme, composeStyle);
    }

    /* renamed from: component1, reason: from getter */
    public final ThemeScheme getThemeScheme() {
        return this.themeScheme;
    }

    /* renamed from: component2, reason: from getter */
    public final ComposeStyle getComposeStyle() {
        return this.composeStyle;
    }

    public final Style copy(ThemeScheme themeScheme, ComposeStyle composeStyle) {
        return new Style(themeScheme, composeStyle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Style)) {
            return false;
        }
        Style style = (Style) other;
        return Intrinsics.areEqual(this.themeScheme, style.themeScheme) && Intrinsics.areEqual(this.composeStyle, style.composeStyle);
    }

    public final ComposeStyle getComposeStyle() {
        return this.composeStyle;
    }

    public final ThemeScheme getThemeScheme() {
        return this.themeScheme;
    }

    public int hashCode() {
        ThemeScheme themeScheme = this.themeScheme;
        int iHashCode = (themeScheme == null ? 0 : themeScheme.hashCode()) * 31;
        ComposeStyle composeStyle = this.composeStyle;
        return iHashCode + (composeStyle != null ? composeStyle.hashCode() : 0);
    }

    public String toString() {
        return "Style(themeScheme=" + this.themeScheme + ", composeStyle=" + this.composeStyle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ThemeScheme themeScheme = this.themeScheme;
        if (themeScheme == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            themeScheme.writeToParcel(parcel, flags);
        }
        ComposeStyle composeStyle = this.composeStyle;
        if (composeStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            composeStyle.writeToParcel(parcel, flags);
        }
    }

    public Style(ThemeScheme themeScheme, ComposeStyle composeStyle) {
        this.themeScheme = themeScheme;
        this.composeStyle = composeStyle;
    }

    public /* synthetic */ Style(ThemeScheme themeScheme, ComposeStyle composeStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : themeScheme, (i & 2) != 0 ? null : composeStyle);
    }
}
