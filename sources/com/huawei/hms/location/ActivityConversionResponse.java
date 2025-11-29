package com.huawei.hms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ActivityConversionResponse implements Parcelable {
    public static final Parcelable.Creator<ActivityConversionResponse> CREATOR = new yn();
    private static final String EXTRA_CONSTANT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_RESULT";
    private static final String TAG = "ActivityConversionResp";
    private List<ActivityConversionData> activityConversionDatas;

    static class yn implements Parcelable.Creator<ActivityConversionResponse> {
        yn() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionResponse createFromParcel(Parcel parcel) {
            return new ActivityConversionResponse(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityConversionResponse[] newArray(int i) {
            return new ActivityConversionResponse[i];
        }
    }

    public ActivityConversionResponse() {
        this.activityConversionDatas = new ArrayList();
    }

    private ActivityConversionResponse(Parcel parcel) {
        this.activityConversionDatas = new ArrayList();
        this.activityConversionDatas = parcel.createTypedArrayList(ActivityConversionData.CREATOR);
    }

    /* synthetic */ ActivityConversionResponse(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityConversionResponse(List<ActivityConversionData> list) {
        new ArrayList();
        this.activityConversionDatas = list;
    }

    public static boolean containDataFromIntent(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_CONSTANT)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static ActivityConversionResponse getDataFromIntent(Intent intent) {
        try {
            if (!containDataFromIntent(intent)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_CONSTANT);
            if (parcelableExtra == null) {
                parcelableExtra = null;
            } else if (parcelableExtra instanceof Bundle) {
                parcelableExtra = ((Bundle) parcelableExtra).getParcelable("KEY_RESPONSE");
            }
            if (parcelableExtra instanceof ActivityConversionResponse) {
                return (ActivityConversionResponse) parcelableExtra;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityConversionResponse) {
            return getClass() == obj.getClass() && this.activityConversionDatas.equals(((ActivityConversionResponse) obj).activityConversionDatas);
        }
        return false;
    }

    public List<ActivityConversionData> getActivityConversionDatas() {
        return this.activityConversionDatas;
    }

    public int hashCode() {
        return this.activityConversionDatas.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.activityConversionDatas);
    }
}
