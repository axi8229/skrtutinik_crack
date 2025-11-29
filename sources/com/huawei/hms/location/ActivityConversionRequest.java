package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ActivityConversionRequest implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionRequest> CREATOR = new yn();
    public static final Comparator<ActivityConversionInfo> IS_EQUAL_CONVERSION = new Vw();

    @Packed
    private List<ActivityConversionInfo> activityConversions;

    static class Vw implements Comparator<ActivityConversionInfo> {
        Vw() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compare(com.huawei.hms.location.ActivityConversionInfo r3, com.huawei.hms.location.ActivityConversionInfo r4) {
            /*
                r2 = this;
                com.huawei.hms.location.ActivityConversionInfo r3 = (com.huawei.hms.location.ActivityConversionInfo) r3
                com.huawei.hms.location.ActivityConversionInfo r4 = (com.huawei.hms.location.ActivityConversionInfo) r4
                int r0 = r3.getActivityType()
                int r1 = r4.getActivityType()
                int r0 = r0 - r1
                if (r0 == 0) goto L12
                if (r0 <= 0) goto L21
                goto L1f
            L12:
                int r3 = r3.getConversionType()
                int r4 = r4.getConversionType()
                int r3 = r3 - r4
                if (r3 == 0) goto L23
                if (r3 <= 0) goto L21
            L1f:
                r3 = 1
                goto L24
            L21:
                r3 = -1
                goto L24
            L23:
                r3 = 0
            L24:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.location.ActivityConversionRequest.Vw.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    static class yn implements Parcelable.Creator<ActivityConversionRequest> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionRequest createFromParcel(Parcel parcel) {
            return new ActivityConversionRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionRequest[] newArray(int i) {
            return new ActivityConversionRequest[i];
        }
    }

    public ActivityConversionRequest() {
    }

    protected ActivityConversionRequest(Parcel parcel) {
        this.activityConversions = parcel.createTypedArrayList(ActivityConversionInfo.CREATOR);
    }

    public ActivityConversionRequest(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && (obj instanceof ActivityConversionRequest)) {
            return Objects.equals(this.activityConversions, ((ActivityConversionRequest) obj).getActivityConversions());
        }
        return false;
    }

    public List<ActivityConversionInfo> getActivityConversions() {
        return this.activityConversions;
    }

    public int hashCode() {
        return this.activityConversions.hashCode();
    }

    public void setActivityConversions(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    public void setDataToIntent(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("ActivityConversionRequest:The parameter is null");
        }
        intent.putExtra("com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_REQUEST", this);
    }

    public String toString() {
        return "ActivityConversionRequest{activityConversions=" + this.activityConversions + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.activityConversions);
    }
}
