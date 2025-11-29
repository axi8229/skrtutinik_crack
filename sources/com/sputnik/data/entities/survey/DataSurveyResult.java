package com.sputnik.data.entities.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSurveyResult.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\f¨\u0006%"}, d2 = {"Lcom/sputnik/data/entities/survey/DataSurveyResult;", "Landroid/os/Parcelable;", "", "surveyId", "", "optionIds", "starsCount", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "<init>", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getSurveyId", "Ljava/util/List;", "getOptionIds", "()Ljava/util/List;", "Ljava/lang/Integer;", "getStarsCount", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getComment", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSurveyResult implements Parcelable {
    public static final Parcelable.Creator<DataSurveyResult> CREATOR = new Creator();
    private final String comment;

    @SerializedName("option_ids")
    private final List<Integer> optionIds;

    @SerializedName("stars_count")
    private final Integer starsCount;

    @SerializedName("survey_id")
    private final int surveyId;

    /* compiled from: DataSurveyResult.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSurveyResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSurveyResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            return new DataSurveyResult(i, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSurveyResult[] newArray(int i) {
            return new DataSurveyResult[i];
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
        if (!(other instanceof DataSurveyResult)) {
            return false;
        }
        DataSurveyResult dataSurveyResult = (DataSurveyResult) other;
        return this.surveyId == dataSurveyResult.surveyId && Intrinsics.areEqual(this.optionIds, dataSurveyResult.optionIds) && Intrinsics.areEqual(this.starsCount, dataSurveyResult.starsCount) && Intrinsics.areEqual(this.comment, dataSurveyResult.comment);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.surveyId) * 31) + this.optionIds.hashCode()) * 31;
        Integer num = this.starsCount;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.comment;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DataSurveyResult(surveyId=" + this.surveyId + ", optionIds=" + this.optionIds + ", starsCount=" + this.starsCount + ", comment=" + this.comment + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.surveyId);
        List<Integer> list = this.optionIds;
        parcel.writeInt(list.size());
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
        Integer num = this.starsCount;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeString(this.comment);
    }

    public DataSurveyResult(int i, List<Integer> optionIds, Integer num, String str) {
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        this.surveyId = i;
        this.optionIds = optionIds;
        this.starsCount = num;
        this.comment = str;
    }

    public final int getSurveyId() {
        return this.surveyId;
    }

    public final List<Integer> getOptionIds() {
        return this.optionIds;
    }

    public final Integer getStarsCount() {
        return this.starsCount;
    }

    public final String getComment() {
        return this.comment;
    }
}
