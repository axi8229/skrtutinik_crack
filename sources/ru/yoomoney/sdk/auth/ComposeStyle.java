package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.FontResource;
import ru.yoomoney.sdk.two_fa.parcelable.PaletteParcelable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/ComposeStyle;", "Landroid/os/Parcelable;", "darkTheme", "", "palette", "Lru/yoomoney/sdk/two_fa/parcelable/PaletteParcelable;", "fontResources", "", "Lru/yoomoney/sdk/two_fa/FontResource;", "(ZLru/yoomoney/sdk/two_fa/parcelable/PaletteParcelable;Ljava/util/List;)V", "getDarkTheme", "()Z", "getFontResources", "()Ljava/util/List;", "getPalette", "()Lru/yoomoney/sdk/two_fa/parcelable/PaletteParcelable;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ComposeStyle implements Parcelable {
    public static final Parcelable.Creator<ComposeStyle> CREATOR = new Creator();
    private final boolean darkTheme;
    private final List<FontResource> fontResources;
    private final PaletteParcelable palette;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ComposeStyle> {
        @Override // android.os.Parcelable.Creator
        public final ComposeStyle createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            PaletteParcelable paletteParcelable = (PaletteParcelable) parcel.readParcelable(ComposeStyle.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(parcel.readParcelable(ComposeStyle.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new ComposeStyle(z, paletteParcelable, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final ComposeStyle[] newArray(int i) {
            return new ComposeStyle[i];
        }
    }

    public ComposeStyle() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComposeStyle copy$default(ComposeStyle composeStyle, boolean z, PaletteParcelable paletteParcelable, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = composeStyle.darkTheme;
        }
        if ((i & 2) != 0) {
            paletteParcelable = composeStyle.palette;
        }
        if ((i & 4) != 0) {
            list = composeStyle.fontResources;
        }
        return composeStyle.copy(z, paletteParcelable, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDarkTheme() {
        return this.darkTheme;
    }

    /* renamed from: component2, reason: from getter */
    public final PaletteParcelable getPalette() {
        return this.palette;
    }

    public final List<FontResource> component3() {
        return this.fontResources;
    }

    public final ComposeStyle copy(boolean darkTheme, PaletteParcelable palette, List<FontResource> fontResources) {
        return new ComposeStyle(darkTheme, palette, fontResources);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComposeStyle)) {
            return false;
        }
        ComposeStyle composeStyle = (ComposeStyle) other;
        return this.darkTheme == composeStyle.darkTheme && Intrinsics.areEqual(this.palette, composeStyle.palette) && Intrinsics.areEqual(this.fontResources, composeStyle.fontResources);
    }

    public final boolean getDarkTheme() {
        return this.darkTheme;
    }

    public final List<FontResource> getFontResources() {
        return this.fontResources;
    }

    public final PaletteParcelable getPalette() {
        return this.palette;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.darkTheme) * 31;
        PaletteParcelable paletteParcelable = this.palette;
        int iHashCode2 = (iHashCode + (paletteParcelable == null ? 0 : paletteParcelable.hashCode())) * 31;
        List<FontResource> list = this.fontResources;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ComposeStyle(darkTheme=" + this.darkTheme + ", palette=" + this.palette + ", fontResources=" + this.fontResources + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.darkTheme ? 1 : 0);
        parcel.writeParcelable(this.palette, flags);
        List<FontResource> list = this.fontResources;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<FontResource> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
    }

    public ComposeStyle(boolean z, PaletteParcelable paletteParcelable, List<FontResource> list) {
        this.darkTheme = z;
        this.palette = paletteParcelable;
        this.fontResources = list;
    }

    public /* synthetic */ ComposeStyle(boolean z, PaletteParcelable paletteParcelable, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : paletteParcelable, (i & 4) != 0 ? null : list);
    }
}
