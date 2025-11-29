package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ActivityTransitionRequest implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new yn();
    private List<ActivityTransition> transitions;

    static class yn implements Parcelable.Creator<ActivityTransitionRequest> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransitionRequest createFromParcel(Parcel parcel) {
            return new ActivityTransitionRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityTransitionRequest[] newArray(int i) {
            return new ActivityTransitionRequest[i];
        }
    }

    public ActivityTransitionRequest() {
        this.transitions = new CopyOnWriteArrayList();
    }

    protected ActivityTransitionRequest(Parcel parcel) {
        this.transitions = new CopyOnWriteArrayList();
        this.transitions = parcel.createTypedArrayList(ActivityTransition.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ActivityTransition> getTransitions() {
        return this.transitions;
    }

    public void setTransitions(List<ActivityTransition> list) {
        this.transitions = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.transitions);
    }
}
