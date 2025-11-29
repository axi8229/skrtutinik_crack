package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DownloadFileParam implements Parcelable {
    public static final Parcelable.Creator<DownloadFileParam> CREATOR = new Parcelable.Creator<DownloadFileParam>() { // from class: com.huawei.location.lite.common.util.filedownload.DownloadFileParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadFileParam createFromParcel(Parcel parcel) {
            return new DownloadFileParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadFileParam[] newArray(int i) {
            return new DownloadFileParam[i];
        }
    };
    private String fileName;
    private String saveFilePath;
    private String serviceType;
    private String subType;

    public DownloadFileParam() {
    }

    protected DownloadFileParam(Parcel parcel) {
        this.serviceType = parcel.readString();
        this.subType = parcel.readString();
        this.saveFilePath = parcel.readString();
        this.fileName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.serviceType);
        parcel.writeString(this.subType);
        parcel.writeString(this.saveFilePath);
        parcel.writeString(this.fileName);
    }
}
