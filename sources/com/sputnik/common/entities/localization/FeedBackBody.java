package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/sputnik/common/entities/localization/FeedBackBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle1", "subtitle2", "subtitle3", "subtitle4", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "commentView", "Lcom/sputnik/common/entities/localization/SendButtonSurvey;", "sendButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;Lcom/sputnik/common/entities/localization/SendButtonSurvey;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle1", "getSubtitle2", "getSubtitle3", "getSubtitle4", "Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "getCommentView", "()Lcom/sputnik/common/entities/localization/entities/common/TextPlaceHolder;", "Lcom/sputnik/common/entities/localization/SendButtonSurvey;", "getSendButton", "()Lcom/sputnik/common/entities/localization/SendButtonSurvey;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeedBackBody implements Parcelable {
    public static final Parcelable.Creator<FeedBackBody> CREATOR = new Creator();

    @SerializedName("comment_view")
    private final TextPlaceHolder commentView;

    @SerializedName("send_button")
    private final SendButtonSurvey sendButton;
    private final String subtitle1;
    private final String subtitle2;
    private final String subtitle3;
    private final String subtitle4;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FeedBackBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedBackBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedBackBody(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (TextPlaceHolder) parcel.readParcelable(FeedBackBody.class.getClassLoader()), parcel.readInt() == 0 ? null : SendButtonSurvey.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeedBackBody[] newArray(int i) {
            return new FeedBackBody[i];
        }
    }

    public FeedBackBody() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedBackBody)) {
            return false;
        }
        FeedBackBody feedBackBody = (FeedBackBody) other;
        return Intrinsics.areEqual(this.title, feedBackBody.title) && Intrinsics.areEqual(this.subtitle1, feedBackBody.subtitle1) && Intrinsics.areEqual(this.subtitle2, feedBackBody.subtitle2) && Intrinsics.areEqual(this.subtitle3, feedBackBody.subtitle3) && Intrinsics.areEqual(this.subtitle4, feedBackBody.subtitle4) && Intrinsics.areEqual(this.commentView, feedBackBody.commentView) && Intrinsics.areEqual(this.sendButton, feedBackBody.sendButton);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle1;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle2;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subtitle3;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subtitle4;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        TextPlaceHolder textPlaceHolder = this.commentView;
        int iHashCode6 = (iHashCode5 + (textPlaceHolder == null ? 0 : textPlaceHolder.hashCode())) * 31;
        SendButtonSurvey sendButtonSurvey = this.sendButton;
        return iHashCode6 + (sendButtonSurvey != null ? sendButtonSurvey.hashCode() : 0);
    }

    public String toString() {
        return "FeedBackBody(title=" + this.title + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", subtitle3=" + this.subtitle3 + ", subtitle4=" + this.subtitle4 + ", commentView=" + this.commentView + ", sendButton=" + this.sendButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle1);
        parcel.writeString(this.subtitle2);
        parcel.writeString(this.subtitle3);
        parcel.writeString(this.subtitle4);
        parcel.writeParcelable(this.commentView, flags);
        SendButtonSurvey sendButtonSurvey = this.sendButton;
        if (sendButtonSurvey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sendButtonSurvey.writeToParcel(parcel, flags);
        }
    }

    public FeedBackBody(String str, String str2, String str3, String str4, String str5, TextPlaceHolder textPlaceHolder, SendButtonSurvey sendButtonSurvey) {
        this.title = str;
        this.subtitle1 = str2;
        this.subtitle2 = str3;
        this.subtitle3 = str4;
        this.subtitle4 = str5;
        this.commentView = textPlaceHolder;
        this.sendButton = sendButtonSurvey;
    }

    public /* synthetic */ FeedBackBody(String str, String str2, String str3, String str4, String str5, TextPlaceHolder textPlaceHolder, SendButtonSurvey sendButtonSurvey, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : textPlaceHolder, (i & 64) != 0 ? null : sendButtonSurvey);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle1() {
        return this.subtitle1;
    }

    public final String getSubtitle2() {
        return this.subtitle2;
    }

    public final String getSubtitle3() {
        return this.subtitle3;
    }

    public final String getSubtitle4() {
        return this.subtitle4;
    }

    public final TextPlaceHolder getCommentView() {
        return this.commentView;
    }

    public final SendButtonSurvey getSendButton() {
        return this.sendButton;
    }
}
