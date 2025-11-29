package com.huawei.location.lite.common.http.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class ResponseInfo implements Parcelable {
    public static final Parcelable.Creator<ResponseInfo> CREATOR = new Parcelable.Creator<ResponseInfo>() { // from class: com.huawei.location.lite.common.http.response.ResponseInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResponseInfo createFromParcel(Parcel parcel) {
            return new ResponseInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResponseInfo[] newArray(int i) {
            return new ResponseInfo[i];
        }
    };
    public static final int ERROR_EXCEPTION_LEVEL = 100;
    public static final int FAILURE_EXCEPTION_LEVEL = 101;
    private static final int MAX_TRANSFER_DATA_LIMIT = 468992;
    private static final String TAG = "ResponseInfo";
    private String bigDataPath;
    private int errorCode;
    private int errorLevel;
    private String msg;
    private byte[] responseBytes;
    private String responseString;

    public ResponseInfo() {
    }

    protected ResponseInfo(Parcel parcel) {
        this.errorLevel = parcel.readInt();
        this.errorCode = parcel.readInt();
        this.msg = parcel.readString();
        this.responseString = parcel.readString();
        this.responseBytes = parcel.createByteArray();
        this.bigDataPath = parcel.readString();
    }

    private void readFromSd() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.bigDataPath), StandardCharsets.UTF_8));
            try {
                StringBuilder sb = new StringBuilder("");
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        new File(this.bigDataPath).delete();
                        this.responseString = sb.toString();
                        bufferedReader.close();
                        return;
                    }
                    sb.append(line);
                }
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("Fly", "readFromSd stream exception");
        }
    }

    private File saveToSd(byte[] bArr) throws IOException {
        File file = new File(this.bigDataPath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("Fly", "saveToSd write exception");
        }
        return file;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getErrorLevel() {
        return this.errorLevel;
    }

    public String getMsg() {
        return this.msg;
    }

    public byte[] getResponseBytes() {
        byte[] bArr = this.responseBytes;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getResponseString() throws IOException {
        if (!TextUtils.isEmpty(this.bigDataPath)) {
            readFromSd();
        }
        return this.responseString;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorLevel(int i) {
        this.errorLevel = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResponseBytes(byte[] bArr) {
        if (bArr != null) {
            this.responseBytes = (byte[]) bArr.clone();
        }
    }

    public void setResponseString(String str) throws IOException {
        if (SDKComponentType.getComponentType() == 200 && !TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length >= MAX_TRANSFER_DATA_LIMIT) {
                LogLocation.i(TAG, "response data over MAX_TRANSFER_DATA_LIMIT");
                this.bigDataPath = LocationUtil.getFilePath(ContextUtil.getContext()) + File.separator + "http_parcelable_data.temp";
                saveToSd(bytes);
                return;
            }
        }
        this.responseString = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorLevel);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.msg);
        parcel.writeString(this.responseString);
        parcel.writeByteArray(this.responseBytes);
        parcel.writeString(this.bigDataPath);
    }
}
