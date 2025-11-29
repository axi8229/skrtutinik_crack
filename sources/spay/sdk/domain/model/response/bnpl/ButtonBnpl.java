package spay.sdk.domain.model.response.bnpl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lspay/sdk/domain/model/response/bnpl/ButtonBnpl;", "Landroid/os/Parcelable;", "activeButtonLogo", "", "inactiveButtonLogo", "header", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActiveButtonLogo", "()Ljava/lang/String;", "getContent", "getHeader", "getInactiveButtonLogo", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ButtonBnpl implements Parcelable {
    public static final Parcelable.Creator<ButtonBnpl> CREATOR = new Creator();
    private final String activeButtonLogo;
    private final String content;
    private final String header;
    private final String inactiveButtonLogo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ButtonBnpl> {
        @Override // android.os.Parcelable.Creator
        public final ButtonBnpl createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ButtonBnpl(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonBnpl[] newArray(int i) {
            return new ButtonBnpl[i];
        }
    }

    public ButtonBnpl(String activeButtonLogo, String inactiveButtonLogo, String header, String content) {
        Intrinsics.checkNotNullParameter(activeButtonLogo, "activeButtonLogo");
        Intrinsics.checkNotNullParameter(inactiveButtonLogo, "inactiveButtonLogo");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(content, "content");
        this.activeButtonLogo = activeButtonLogo;
        this.inactiveButtonLogo = inactiveButtonLogo;
        this.header = header;
        this.content = content;
    }

    public static /* synthetic */ ButtonBnpl copy$default(ButtonBnpl buttonBnpl, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonBnpl.activeButtonLogo;
        }
        if ((i & 2) != 0) {
            str2 = buttonBnpl.inactiveButtonLogo;
        }
        if ((i & 4) != 0) {
            str3 = buttonBnpl.header;
        }
        if ((i & 8) != 0) {
            str4 = buttonBnpl.content;
        }
        return buttonBnpl.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActiveButtonLogo() {
        return this.activeButtonLogo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInactiveButtonLogo() {
        return this.inactiveButtonLogo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ButtonBnpl copy(String activeButtonLogo, String inactiveButtonLogo, String header, String content) {
        Intrinsics.checkNotNullParameter(activeButtonLogo, "activeButtonLogo");
        Intrinsics.checkNotNullParameter(inactiveButtonLogo, "inactiveButtonLogo");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ButtonBnpl(activeButtonLogo, inactiveButtonLogo, header, content);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonBnpl)) {
            return false;
        }
        ButtonBnpl buttonBnpl = (ButtonBnpl) other;
        return Intrinsics.areEqual(this.activeButtonLogo, buttonBnpl.activeButtonLogo) && Intrinsics.areEqual(this.inactiveButtonLogo, buttonBnpl.inactiveButtonLogo) && Intrinsics.areEqual(this.header, buttonBnpl.header) && Intrinsics.areEqual(this.content, buttonBnpl.content);
    }

    public final String getActiveButtonLogo() {
        return this.activeButtonLogo;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getInactiveButtonLogo() {
        return this.inactiveButtonLogo;
    }

    public int hashCode() {
        return this.content.hashCode() + AbstractC1553e.a(this.header, AbstractC1553e.a(this.inactiveButtonLogo, this.activeButtonLogo.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ButtonBnpl(activeButtonLogo=");
        sb.append(this.activeButtonLogo);
        sb.append(", inactiveButtonLogo=");
        sb.append(this.inactiveButtonLogo);
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", content=");
        return Q1.a(sb, this.content, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activeButtonLogo);
        parcel.writeString(this.inactiveButtonLogo);
        parcel.writeString(this.header);
        parcel.writeString(this.content);
    }
}
