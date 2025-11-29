package com.sputnik.data.entities.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.data.entities.alerts.DataButton;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSurvey.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001:\u0001FB³\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u001fJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b3\u00102R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b4\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b5\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b6\u00102R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b7\u00102R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b8\u00102R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b9\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b:\u0010\u001dR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\bA\u0010\u001dR\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\bB\u0010=R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010C\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/sputnik/data/entities/survey/DataSurvey;", "Landroid/os/Parcelable;", "", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "multipass", "enabled", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "stars", "timed", "multioption", "startDate", "endDate", "", "Lcom/sputnik/data/entities/survey/DataSurveyOption;", "options", "Lcom/sputnik/data/entities/survey/DataSurveySelection;", "selection", "starsTitle", "Lcom/sputnik/data/entities/alerts/DataButton;", "buttons", "Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody;", "richBody", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/sputnik/data/entities/survey/DataSurveySelection;Ljava/lang/String;Ljava/util/List;Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getName", "Ljava/lang/Boolean;", "getMultipass", "()Ljava/lang/Boolean;", "getEnabled", "getTitle", "getBody", "getStars", "getTimed", "getMultioption", "getStartDate", "getEndDate", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "Lcom/sputnik/data/entities/survey/DataSurveySelection;", "getSelection", "()Lcom/sputnik/data/entities/survey/DataSurveySelection;", "getStarsTitle", "getButtons", "Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody;", "getRichBody", "()Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody;", "DataRichBody", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSurvey implements Parcelable {
    public static final Parcelable.Creator<DataSurvey> CREATOR = new Creator();

    @SerializedName("body")
    private final String body;
    private final List<DataButton> buttons;

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("end_date")
    private final String endDate;

    @SerializedName("id")
    private final Integer id;

    @SerializedName("multioption")
    private final Boolean multioption;

    @SerializedName("multipass")
    private final Boolean multipass;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private final String name;

    @SerializedName("options")
    private final List<DataSurveyOption> options;

    @SerializedName("rich_body")
    private final DataRichBody richBody;

    @SerializedName("selection")
    private final DataSurveySelection selection;

    @SerializedName("stars")
    private final Boolean stars;

    @SerializedName("stars_title")
    private final String starsTitle;

    @SerializedName("start_date")
    private final String startDate;

    @SerializedName("timed")
    private final Boolean timed;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    /* compiled from: DataSurvey.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSurvey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSurvey createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            DataSurveySelection dataSurveySelection;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Boolean boolValueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf5 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataSurveyOption.CREATOR.createFromParcel(parcel));
                }
            }
            DataSurveySelection dataSurveySelectionCreateFromParcel = parcel.readInt() == 0 ? null : DataSurveySelection.CREATOR.createFromParcel(parcel);
            String string6 = parcel.readString();
            if (parcel.readInt() == 0) {
                dataSurveySelection = dataSurveySelectionCreateFromParcel;
                arrayList2 = null;
            } else {
                int i3 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i3);
                dataSurveySelection = dataSurveySelectionCreateFromParcel;
                int i4 = 0;
                while (i4 != i3) {
                    arrayList3.add(DataButton.CREATOR.createFromParcel(parcel));
                    i4++;
                    i3 = i3;
                }
                arrayList2 = arrayList3;
            }
            return new DataSurvey(numValueOf, string, boolValueOf, boolValueOf2, string2, string3, boolValueOf3, boolValueOf4, boolValueOf5, string4, string5, arrayList, dataSurveySelection, string6, arrayList2, parcel.readInt() == 0 ? null : DataRichBody.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSurvey[] newArray(int i) {
            return new DataSurvey[i];
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
        if (!(other instanceof DataSurvey)) {
            return false;
        }
        DataSurvey dataSurvey = (DataSurvey) other;
        return Intrinsics.areEqual(this.id, dataSurvey.id) && Intrinsics.areEqual(this.name, dataSurvey.name) && Intrinsics.areEqual(this.multipass, dataSurvey.multipass) && Intrinsics.areEqual(this.enabled, dataSurvey.enabled) && Intrinsics.areEqual(this.title, dataSurvey.title) && Intrinsics.areEqual(this.body, dataSurvey.body) && Intrinsics.areEqual(this.stars, dataSurvey.stars) && Intrinsics.areEqual(this.timed, dataSurvey.timed) && Intrinsics.areEqual(this.multioption, dataSurvey.multioption) && Intrinsics.areEqual(this.startDate, dataSurvey.startDate) && Intrinsics.areEqual(this.endDate, dataSurvey.endDate) && Intrinsics.areEqual(this.options, dataSurvey.options) && Intrinsics.areEqual(this.selection, dataSurvey.selection) && Intrinsics.areEqual(this.starsTitle, dataSurvey.starsTitle) && Intrinsics.areEqual(this.buttons, dataSurvey.buttons) && Intrinsics.areEqual(this.richBody, dataSurvey.richBody);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.multipass;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.body;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.stars;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.timed;
        int iHashCode8 = (iHashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.multioption;
        int iHashCode9 = (iHashCode8 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str4 = this.startDate;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endDate;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<DataSurveyOption> list = this.options;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        DataSurveySelection dataSurveySelection = this.selection;
        int iHashCode13 = (iHashCode12 + (dataSurveySelection == null ? 0 : dataSurveySelection.hashCode())) * 31;
        String str6 = this.starsTitle;
        int iHashCode14 = (iHashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<DataButton> list2 = this.buttons;
        int iHashCode15 = (iHashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31;
        DataRichBody dataRichBody = this.richBody;
        return iHashCode15 + (dataRichBody != null ? dataRichBody.hashCode() : 0);
    }

    public String toString() {
        return "DataSurvey(id=" + this.id + ", name=" + this.name + ", multipass=" + this.multipass + ", enabled=" + this.enabled + ", title=" + this.title + ", body=" + this.body + ", stars=" + this.stars + ", timed=" + this.timed + ", multioption=" + this.multioption + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", options=" + this.options + ", selection=" + this.selection + ", starsTitle=" + this.starsTitle + ", buttons=" + this.buttons + ", richBody=" + this.richBody + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.name);
        Boolean bool = this.multipass;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.enabled;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        Boolean bool3 = this.stars;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.timed;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.multioption;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.startDate);
        parcel.writeString(this.endDate);
        List<DataSurveyOption> list = this.options;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<DataSurveyOption> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        DataSurveySelection dataSurveySelection = this.selection;
        if (dataSurveySelection == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataSurveySelection.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.starsTitle);
        List<DataButton> list2 = this.buttons;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            Iterator<DataButton> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        DataRichBody dataRichBody = this.richBody;
        if (dataRichBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataRichBody.writeToParcel(parcel, flags);
        }
    }

    public DataSurvey(Integer num, String str, Boolean bool, Boolean bool2, String str2, String str3, Boolean bool3, Boolean bool4, Boolean bool5, String str4, String str5, List<DataSurveyOption> list, DataSurveySelection dataSurveySelection, String str6, List<DataButton> list2, DataRichBody dataRichBody) {
        this.id = num;
        this.name = str;
        this.multipass = bool;
        this.enabled = bool2;
        this.title = str2;
        this.body = str3;
        this.stars = bool3;
        this.timed = bool4;
        this.multioption = bool5;
        this.startDate = str4;
        this.endDate = str5;
        this.options = list;
        this.selection = dataSurveySelection;
        this.starsTitle = str6;
        this.buttons = list2;
        this.richBody = dataRichBody;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getMultipass() {
        return this.multipass;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final Boolean getStars() {
        return this.stars;
    }

    public final Boolean getTimed() {
        return this.timed;
    }

    public final Boolean getMultioption() {
        return this.multioption;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final List<DataSurveyOption> getOptions() {
        return this.options;
    }

    public final DataSurveySelection getSelection() {
        return this.selection;
    }

    public final String getStarsTitle() {
        return this.starsTitle;
    }

    public final List<DataButton> getButtons() {
        return this.buttons;
    }

    public final DataRichBody getRichBody() {
        return this.richBody;
    }

    /* compiled from: DataSurvey.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody$DataNotice;", "notice", "<init>", "(Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody$DataNotice;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody$DataNotice;", "getNotice", "()Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody$DataNotice;", "DataNotice", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataRichBody implements Parcelable {
        public static final Parcelable.Creator<DataRichBody> CREATOR = new Creator();
        private final DataNotice notice;

        /* compiled from: DataSurvey.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataRichBody> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataRichBody createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataRichBody(parcel.readInt() == 0 ? null : DataNotice.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataRichBody[] newArray(int i) {
                return new DataRichBody[i];
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
            return (other instanceof DataRichBody) && Intrinsics.areEqual(this.notice, ((DataRichBody) other).notice);
        }

        public int hashCode() {
            DataNotice dataNotice = this.notice;
            if (dataNotice == null) {
                return 0;
            }
            return dataNotice.hashCode();
        }

        public String toString() {
            return "DataRichBody(notice=" + this.notice + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            DataNotice dataNotice = this.notice;
            if (dataNotice == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                dataNotice.writeToParcel(parcel, flags);
            }
        }

        public DataRichBody(DataNotice dataNotice) {
            this.notice = dataNotice;
        }

        public final DataNotice getNotice() {
            return this.notice;
        }

        /* compiled from: DataSurvey.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/data/entities/survey/DataSurvey$DataRichBody$DataNotice;", "Landroid/os/Parcelable;", "", "body", RemoteMessageConst.MessageBody.PARAM, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBody", "getParam", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DataNotice implements Parcelable {
            public static final Parcelable.Creator<DataNotice> CREATOR = new Creator();
            private final String body;
            private final String param;

            /* compiled from: DataSurvey.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<DataNotice> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final DataNotice createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new DataNotice(parcel.readString(), parcel.readString());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final DataNotice[] newArray(int i) {
                    return new DataNotice[i];
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
                if (!(other instanceof DataNotice)) {
                    return false;
                }
                DataNotice dataNotice = (DataNotice) other;
                return Intrinsics.areEqual(this.body, dataNotice.body) && Intrinsics.areEqual(this.param, dataNotice.param);
            }

            public int hashCode() {
                String str = this.body;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.param;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "DataNotice(body=" + this.body + ", param=" + this.param + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.body);
                parcel.writeString(this.param);
            }

            public DataNotice(String str, String str2) {
                this.body = str;
                this.param = str2;
            }

            public final String getBody() {
                return this.body;
            }

            public final String getParam() {
                return this.param;
            }
        }
    }
}
