package com.sputnik.data.entities.faq;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFaqQuestion.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b\"\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b#\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/sputnik/data/entities/faq/DataFaqQuestion;", "Landroid/os/Parcelable;", "", "id", "", "question", "answer", "link", "Lcom/sputnik/data/entities/faq/DataFaqQuestion$DataFaqButton;", "button", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/faq/DataFaqQuestion$DataFaqButton;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getQuestion", "getAnswer", "getLink", "Lcom/sputnik/data/entities/faq/DataFaqQuestion$DataFaqButton;", "getButton", "()Lcom/sputnik/data/entities/faq/DataFaqQuestion$DataFaqButton;", "DataFaqButton", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataFaqQuestion implements Parcelable {
    public static final Parcelable.Creator<DataFaqQuestion> CREATOR = new Creator();
    private final String answer;
    private final DataFaqButton button;
    private final Long id;
    private final String link;
    private final String question;

    /* compiled from: DataFaqQuestion.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataFaqQuestion> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFaqQuestion createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataFaqQuestion(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DataFaqButton.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFaqQuestion[] newArray(int i) {
            return new DataFaqQuestion[i];
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
        if (!(other instanceof DataFaqQuestion)) {
            return false;
        }
        DataFaqQuestion dataFaqQuestion = (DataFaqQuestion) other;
        return Intrinsics.areEqual(this.id, dataFaqQuestion.id) && Intrinsics.areEqual(this.question, dataFaqQuestion.question) && Intrinsics.areEqual(this.answer, dataFaqQuestion.answer) && Intrinsics.areEqual(this.link, dataFaqQuestion.link) && Intrinsics.areEqual(this.button, dataFaqQuestion.button);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.question;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.answer;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DataFaqButton dataFaqButton = this.button;
        return iHashCode4 + (dataFaqButton != null ? dataFaqButton.hashCode() : 0);
    }

    public String toString() {
        return "DataFaqQuestion(id=" + this.id + ", question=" + this.question + ", answer=" + this.answer + ", link=" + this.link + ", button=" + this.button + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.id;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.question);
        parcel.writeString(this.answer);
        parcel.writeString(this.link);
        DataFaqButton dataFaqButton = this.button;
        if (dataFaqButton == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataFaqButton.writeToParcel(parcel, flags);
        }
    }

    public DataFaqQuestion(Long l, String str, String str2, String str3, DataFaqButton dataFaqButton) {
        this.id = l;
        this.question = str;
        this.answer = str2;
        this.link = str3;
        this.button = dataFaqButton;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getLink() {
        return this.link;
    }

    public final DataFaqButton getButton() {
        return this.button;
    }

    /* compiled from: DataFaqQuestion.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/sputnik/data/entities/faq/DataFaqQuestion$DataFaqButton;", "Landroid/os/Parcelable;", "", "id", "", RemoteMessageConst.Notification.COLOR, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getColor", "getTitle", "getDeeplink", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataFaqButton implements Parcelable {
        public static final Parcelable.Creator<DataFaqButton> CREATOR = new Creator();
        private final String color;
        private final String deeplink;
        private final Long id;
        private final String title;

        /* compiled from: DataFaqQuestion.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataFaqButton> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataFaqButton createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataFaqButton(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataFaqButton[] newArray(int i) {
                return new DataFaqButton[i];
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
            if (!(other instanceof DataFaqButton)) {
                return false;
            }
            DataFaqButton dataFaqButton = (DataFaqButton) other;
            return Intrinsics.areEqual(this.id, dataFaqButton.id) && Intrinsics.areEqual(this.color, dataFaqButton.color) && Intrinsics.areEqual(this.title, dataFaqButton.title) && Intrinsics.areEqual(this.deeplink, dataFaqButton.deeplink);
        }

        public int hashCode() {
            Long l = this.id;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            String str = this.color;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.title;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.deeplink;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "DataFaqButton(id=" + this.id + ", color=" + this.color + ", title=" + this.title + ", deeplink=" + this.deeplink + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Long l = this.id;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
            parcel.writeString(this.color);
            parcel.writeString(this.title);
            parcel.writeString(this.deeplink);
        }

        public DataFaqButton(Long l, String str, String str2, String str3) {
            this.id = l;
            this.color = str;
            this.title = str2;
            this.deeplink = str3;
        }

        public final Long getId() {
            return this.id;
        }

        public final String getColor() {
            return this.color;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }
    }
}
