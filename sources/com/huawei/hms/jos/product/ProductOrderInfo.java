package com.huawei.hms.jos.product;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProductOrderInfo implements Parcelable {
    public static final Parcelable.Creator<ProductOrderInfo> CREATOR = new a();
    private String a;
    private String b;
    private String c;
    private String d;

    static class a implements Parcelable.Creator<ProductOrderInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductOrderInfo createFromParcel(Parcel parcel) {
            return new ProductOrderInfo(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProductOrderInfo[] newArray(int i) {
            return new ProductOrderInfo[i];
        }
    }

    private ProductOrderInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    /* synthetic */ ProductOrderInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    ProductOrderInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("tradeId");
            this.b = jSONObject.optString("productNo");
            this.c = jSONObject.optString("orderId");
            this.d = jSONObject.optString("sign");
        } catch (JSONException unused) {
            HMSLog.e("ProductOrderInfo", "ProductOrderInfo from json meet exception");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOrderId() {
        return this.c;
    }

    public String getProductNo() {
        return this.b;
    }

    public String getSign() {
        return this.d;
    }

    public String getTradeId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
