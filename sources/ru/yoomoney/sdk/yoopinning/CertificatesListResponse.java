package ru.yoomoney.sdk.yoopinning;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CertificatesListResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/yoopinning/CertificatesListResponse;", "", "blackList", "", "", "whiteList", "(Ljava/util/List;Ljava/util/List;)V", "getBlackList", "()Ljava/util/List;", "getWhiteList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CertificatesListResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> blackList;
    private final List<String> whiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CertificatesListResponse copy$default(CertificatesListResponse certificatesListResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = certificatesListResponse.blackList;
        }
        if ((i & 2) != 0) {
            list2 = certificatesListResponse.whiteList;
        }
        return certificatesListResponse.copy(list, list2);
    }

    public final List<String> component1() {
        return this.blackList;
    }

    public final List<String> component2() {
        return this.whiteList;
    }

    public final CertificatesListResponse copy(List<String> blackList, List<String> whiteList) {
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        return new CertificatesListResponse(blackList, whiteList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CertificatesListResponse)) {
            return false;
        }
        CertificatesListResponse certificatesListResponse = (CertificatesListResponse) other;
        return Intrinsics.areEqual(this.blackList, certificatesListResponse.blackList) && Intrinsics.areEqual(this.whiteList, certificatesListResponse.whiteList);
    }

    public int hashCode() {
        return (this.blackList.hashCode() * 31) + this.whiteList.hashCode();
    }

    public String toString() {
        return "CertificatesListResponse(blackList=" + this.blackList + ", whiteList=" + this.whiteList + ")";
    }

    public CertificatesListResponse(List<String> blackList, List<String> whiteList) {
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        this.blackList = blackList;
        this.whiteList = whiteList;
    }

    public final List<String> getBlackList() {
        return this.blackList;
    }

    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    /* compiled from: CertificatesListResponse.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/yoopinning/CertificatesListResponse$Companion;", "", "()V", "BLACK_LIST_NAME", "", "WHITE_LIST_NAME", "fromJson", "Lru/yoomoney/sdk/yoopinning/CertificatesListResponse;", "payloadData", "toList", "", "Lorg/json/JSONArray;", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CertificatesListResponse fromJson(String payloadData) throws JSONException {
            Intrinsics.checkNotNullParameter(payloadData, "payloadData");
            JSONObject jSONObject = new JSONObject(payloadData);
            JSONArray jSONArray = jSONObject.getJSONArray("trustlist");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            List<String> list = toList(jSONArray);
            JSONArray jSONArray2 = jSONObject.getJSONArray("blacklist");
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
            return new CertificatesListResponse(toList(jSONArray2), list);
        }

        private final List<String> toList(JSONArray jSONArray) throws JSONException {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(string);
            }
            return arrayList;
        }
    }
}
