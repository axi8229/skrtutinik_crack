package com.sputnik.common.entities.localization.entities.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromisePopupLocale.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/blocking/PromisePopupBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "body", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "payButton", "useButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/common/TextWithParam;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getPayButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getUseButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PromisePopupBody implements Parcelable {
    public static final Parcelable.Creator<PromisePopupBody> CREATOR = new Creator();
    private final TextWithParam body;

    @SerializedName("pay_button")
    private final TextTitle payButton;
    private final String title;

    @SerializedName("use_button")
    private final TextTitle useButton;

    /* compiled from: PromisePopupLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PromisePopupBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PromisePopupBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            TextWithParam textWithParamCreateFromParcel = TextWithParam.CREATOR.createFromParcel(parcel);
            Parcelable.Creator<TextTitle> creator = TextTitle.CREATOR;
            return new PromisePopupBody(string, textWithParamCreateFromParcel, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PromisePopupBody[] newArray(int i) {
            return new PromisePopupBody[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromisePopupBody)) {
            return false;
        }
        PromisePopupBody promisePopupBody = (PromisePopupBody) other;
        return Intrinsics.areEqual(this.title, promisePopupBody.title) && Intrinsics.areEqual(this.body, promisePopupBody.body) && Intrinsics.areEqual(this.payButton, promisePopupBody.payButton) && Intrinsics.areEqual(this.useButton, promisePopupBody.useButton);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.body.hashCode()) * 31) + this.payButton.hashCode()) * 31) + this.useButton.hashCode();
    }

    public String toString() {
        return "PromisePopupBody(title=" + this.title + ", body=" + this.body + ", payButton=" + this.payButton + ", useButton=" + this.useButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.body.writeToParcel(parcel, flags);
        this.payButton.writeToParcel(parcel, flags);
        this.useButton.writeToParcel(parcel, flags);
    }

    public PromisePopupBody(String title, TextWithParam body, TextTitle payButton, TextTitle useButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(payButton, "payButton");
        Intrinsics.checkNotNullParameter(useButton, "useButton");
        this.title = title;
        this.body = body;
        this.payButton = payButton;
        this.useButton = useButton;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextWithParam getBody() {
        return this.body;
    }

    public final TextTitle getPayButton() {
        return this.payButton;
    }

    public final TextTitle getUseButton() {
        return this.useButton;
    }
}
