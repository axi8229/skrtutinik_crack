package spay.sdk.domain.model.response.bnpl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006%"}, d2 = {"Lspay/sdk/domain/model/response/bnpl/ButtonBnplParts;", "Landroid/os/Parcelable;", "buttonLogo", "", "buttonLogoInactive", "header", "headerInactive", "content", "contentInactive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonLogo", "()Ljava/lang/String;", "getButtonLogoInactive", "getContent", "getContentInactive", "getHeader", "getHeaderInactive", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ButtonBnplParts implements Parcelable {
    public static final Parcelable.Creator<ButtonBnplParts> CREATOR = new Creator();
    private final String buttonLogo;
    private final String buttonLogoInactive;
    private final String content;
    private final String contentInactive;
    private final String header;
    private final String headerInactive;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ButtonBnplParts> {
        @Override // android.os.Parcelable.Creator
        public final ButtonBnplParts createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ButtonBnplParts(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonBnplParts[] newArray(int i) {
            return new ButtonBnplParts[i];
        }
    }

    public ButtonBnplParts(String buttonLogo, String buttonLogoInactive, String header, String headerInactive, String content, String contentInactive) {
        Intrinsics.checkNotNullParameter(buttonLogo, "buttonLogo");
        Intrinsics.checkNotNullParameter(buttonLogoInactive, "buttonLogoInactive");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(headerInactive, "headerInactive");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentInactive, "contentInactive");
        this.buttonLogo = buttonLogo;
        this.buttonLogoInactive = buttonLogoInactive;
        this.header = header;
        this.headerInactive = headerInactive;
        this.content = content;
        this.contentInactive = contentInactive;
    }

    public static /* synthetic */ ButtonBnplParts copy$default(ButtonBnplParts buttonBnplParts, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonBnplParts.buttonLogo;
        }
        if ((i & 2) != 0) {
            str2 = buttonBnplParts.buttonLogoInactive;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = buttonBnplParts.header;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = buttonBnplParts.headerInactive;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = buttonBnplParts.content;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = buttonBnplParts.contentInactive;
        }
        return buttonBnplParts.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getButtonLogo() {
        return this.buttonLogo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getButtonLogoInactive() {
        return this.buttonLogoInactive;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHeaderInactive() {
        return this.headerInactive;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContentInactive() {
        return this.contentInactive;
    }

    public final ButtonBnplParts copy(String buttonLogo, String buttonLogoInactive, String header, String headerInactive, String content, String contentInactive) {
        Intrinsics.checkNotNullParameter(buttonLogo, "buttonLogo");
        Intrinsics.checkNotNullParameter(buttonLogoInactive, "buttonLogoInactive");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(headerInactive, "headerInactive");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentInactive, "contentInactive");
        return new ButtonBnplParts(buttonLogo, buttonLogoInactive, header, headerInactive, content, contentInactive);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonBnplParts)) {
            return false;
        }
        ButtonBnplParts buttonBnplParts = (ButtonBnplParts) other;
        return Intrinsics.areEqual(this.buttonLogo, buttonBnplParts.buttonLogo) && Intrinsics.areEqual(this.buttonLogoInactive, buttonBnplParts.buttonLogoInactive) && Intrinsics.areEqual(this.header, buttonBnplParts.header) && Intrinsics.areEqual(this.headerInactive, buttonBnplParts.headerInactive) && Intrinsics.areEqual(this.content, buttonBnplParts.content) && Intrinsics.areEqual(this.contentInactive, buttonBnplParts.contentInactive);
    }

    public final String getButtonLogo() {
        return this.buttonLogo;
    }

    public final String getButtonLogoInactive() {
        return this.buttonLogoInactive;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentInactive() {
        return this.contentInactive;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getHeaderInactive() {
        return this.headerInactive;
    }

    public int hashCode() {
        return this.contentInactive.hashCode() + AbstractC1553e.a(this.content, AbstractC1553e.a(this.headerInactive, AbstractC1553e.a(this.header, AbstractC1553e.a(this.buttonLogoInactive, this.buttonLogo.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ButtonBnplParts(buttonLogo=");
        sb.append(this.buttonLogo);
        sb.append(", buttonLogoInactive=");
        sb.append(this.buttonLogoInactive);
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", headerInactive=");
        sb.append(this.headerInactive);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", contentInactive=");
        return Q1.a(sb, this.contentInactive, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.buttonLogo);
        parcel.writeString(this.buttonLogoInactive);
        parcel.writeString(this.header);
        parcel.writeString(this.headerInactive);
        parcel.writeString(this.content);
        parcel.writeString(this.contentInactive);
    }
}
