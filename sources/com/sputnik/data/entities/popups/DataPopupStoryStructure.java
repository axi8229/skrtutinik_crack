package com.sputnik.data.entities.popups;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPopupStoryStructure.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010\u000eR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;", "Landroid/os/Parcelable;", "", "id", "version", RemoteMessageConst.Notification.PRIORITY, "", "trigger", "", "Lcom/sputnik/data/entities/popups/DataPopupStory;", "popupStories", "<init>", "(JJJLjava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getId", "()J", "getVersion", "getPriority", "Ljava/lang/String;", "getTrigger", "Ljava/util/List;", "getPopupStories", "()Ljava/util/List;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPopupStoryStructure implements Parcelable {
    public static final Parcelable.Creator<DataPopupStoryStructure> CREATOR = new Creator();
    private final long id;

    @SerializedName("popup_stories")
    private final List<DataPopupStory> popupStories;
    private final long priority;
    private final String trigger;
    private final long version;

    /* compiled from: DataPopupStoryStructure.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPopupStoryStructure> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPopupStoryStructure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            long j3 = parcel.readLong();
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(DataPopupStory.CREATOR.createFromParcel(parcel));
            }
            return new DataPopupStoryStructure(j, j2, j3, string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPopupStoryStructure[] newArray(int i) {
            return new DataPopupStoryStructure[i];
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
        if (!(other instanceof DataPopupStoryStructure)) {
            return false;
        }
        DataPopupStoryStructure dataPopupStoryStructure = (DataPopupStoryStructure) other;
        return this.id == dataPopupStoryStructure.id && this.version == dataPopupStoryStructure.version && this.priority == dataPopupStoryStructure.priority && Intrinsics.areEqual(this.trigger, dataPopupStoryStructure.trigger) && Intrinsics.areEqual(this.popupStories, dataPopupStoryStructure.popupStories);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.version)) * 31) + Long.hashCode(this.priority)) * 31) + this.trigger.hashCode()) * 31) + this.popupStories.hashCode();
    }

    public String toString() {
        return "DataPopupStoryStructure(id=" + this.id + ", version=" + this.version + ", priority=" + this.priority + ", trigger=" + this.trigger + ", popupStories=" + this.popupStories + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.version);
        parcel.writeLong(this.priority);
        parcel.writeString(this.trigger);
        List<DataPopupStory> list = this.popupStories;
        parcel.writeInt(list.size());
        Iterator<DataPopupStory> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public DataPopupStoryStructure(long j, long j2, long j3, String trigger, List<DataPopupStory> popupStories) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(popupStories, "popupStories");
        this.id = j;
        this.version = j2;
        this.priority = j3;
        this.trigger = trigger;
        this.popupStories = popupStories;
    }

    public final long getId() {
        return this.id;
    }

    public final long getVersion() {
        return this.version;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final String getTrigger() {
        return this.trigger;
    }

    public final List<DataPopupStory> getPopupStories() {
        return this.popupStories;
    }
}
