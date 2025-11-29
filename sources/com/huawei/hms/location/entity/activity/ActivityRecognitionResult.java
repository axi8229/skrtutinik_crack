package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes3.dex */
public class ActivityRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new yn();
    private long elapsedRealtimeMillis;
    private List<DetectedActivity> probableActivities;
    private long time;

    static class yn implements Parcelable.Creator<ActivityRecognitionResult> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecognitionResult createFromParcel(Parcel parcel) {
            return new ActivityRecognitionResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecognitionResult[] newArray(int i) {
            return new ActivityRecognitionResult[0];
        }
    }

    private ActivityRecognitionResult(Parcel parcel) {
        this.time = parcel.readLong();
        this.elapsedRealtimeMillis = parcel.readLong();
        this.probableActivities = parcel.createTypedArrayList(DetectedActivity.CREATOR);
    }

    /* synthetic */ ActivityRecognitionResult(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this.probableActivities = list;
        this.time = j;
        this.elapsedRealtimeMillis = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int i) {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (DetectedActivity detectedActivity : this.probableActivities) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.elapsedRealtimeMillis;
    }

    public DetectedActivity getMostProbableActivity() {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.probableActivities.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.probableActivities;
    }

    public long getTime() {
        return this.time;
    }

    public void setElapsedRealtimeMillis(long j) {
        this.elapsedRealtimeMillis = j;
    }

    public void setProbableActivities(List<DetectedActivity> list) {
        this.probableActivities = list;
    }

    public void setTime(long j) {
        this.time = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.time);
        parcel.writeLong(this.elapsedRealtimeMillis);
        parcel.writeTypedList(this.probableActivities);
    }
}
