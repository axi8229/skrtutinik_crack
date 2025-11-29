package com.sputnik.data.entities.stories;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.domain.entities.stories.StoriesSet;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataStory.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b&\u0010%R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b*\u0010%R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b+\u0010%R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b.\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b/\u0010\u0014R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b0\u0010\u0014R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/sputnik/data/entities/stories/DataStory;", "Landroid/os/Parcelable;", "", "id", "version", "Lcom/sputnik/domain/entities/stories/StoriesSet;", "set", "order", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "background", "screenshot", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "", "Lcom/sputnik/data/entities/stories/DataStoriesButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/sputnik/domain/entities/stories/StoriesSet;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "getVersion", "Lcom/sputnik/domain/entities/stories/StoriesSet;", "getSet", "()Lcom/sputnik/domain/entities/stories/StoriesSet;", "getOrder", "getDuration", "Ljava/lang/String;", "getBackground", "getScreenshot", "getTitle", "getDescription", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataStory implements Parcelable {
    public static final Parcelable.Creator<DataStory> CREATOR = new Creator();
    private final String background;
    private final List<DataStoriesButton> buttons;
    private final String description;
    private final Integer duration;
    private final Integer id;
    private final Integer order;
    private final String screenshot;
    private final StoriesSet set;
    private final String title;
    private final Integer version;

    /* compiled from: DataStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataStory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataStory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            StoriesSet storiesSetValueOf = parcel.readInt() == 0 ? null : StoriesSet.valueOf(parcel.readString());
            Integer numValueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataStoriesButton.CREATOR.createFromParcel(parcel));
                }
            }
            return new DataStory(numValueOf, numValueOf2, storiesSetValueOf, numValueOf3, numValueOf4, string, string2, string3, string4, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataStory[] newArray(int i) {
            return new DataStory[i];
        }
    }

    public DataStory() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataStory)) {
            return false;
        }
        DataStory dataStory = (DataStory) other;
        return Intrinsics.areEqual(this.id, dataStory.id) && Intrinsics.areEqual(this.version, dataStory.version) && this.set == dataStory.set && Intrinsics.areEqual(this.order, dataStory.order) && Intrinsics.areEqual(this.duration, dataStory.duration) && Intrinsics.areEqual(this.background, dataStory.background) && Intrinsics.areEqual(this.screenshot, dataStory.screenshot) && Intrinsics.areEqual(this.title, dataStory.title) && Intrinsics.areEqual(this.description, dataStory.description) && Intrinsics.areEqual(this.buttons, dataStory.buttons);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.version;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        StoriesSet storiesSet = this.set;
        int iHashCode3 = (iHashCode2 + (storiesSet == null ? 0 : storiesSet.hashCode())) * 31;
        Integer num3 = this.order;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.duration;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.background;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.screenshot;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<DataStoriesButton> list = this.buttons;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DataStory(id=" + this.id + ", version=" + this.version + ", set=" + this.set + ", order=" + this.order + ", duration=" + this.duration + ", background=" + this.background + ", screenshot=" + this.screenshot + ", title=" + this.title + ", description=" + this.description + ", buttons=" + this.buttons + ")";
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
        Integer num2 = this.version;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        StoriesSet storiesSet = this.set;
        if (storiesSet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(storiesSet.name());
        }
        Integer num3 = this.order;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.duration;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.background);
        parcel.writeString(this.screenshot);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        List<DataStoriesButton> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<DataStoriesButton> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public DataStory(Integer num, Integer num2, StoriesSet storiesSet, Integer num3, Integer num4, String str, String str2, String str3, String str4, List<DataStoriesButton> list) {
        this.id = num;
        this.version = num2;
        this.set = storiesSet;
        this.order = num3;
        this.duration = num4;
        this.background = str;
        this.screenshot = str2;
        this.title = str3;
        this.description = str4;
        this.buttons = list;
    }

    public /* synthetic */ DataStory(Integer num, Integer num2, StoriesSet storiesSet, Integer num3, Integer num4, String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : storiesSet, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) == 0 ? list : null);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final StoriesSet getSet() {
        return this.set;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getScreenshot() {
        return this.screenshot;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<DataStoriesButton> getButtons() {
        return this.buttons;
    }
}
