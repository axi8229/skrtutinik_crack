package ru.yoomoney.sdk.auth.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/IllegalParametersErrorResponse;", "Lru/yoomoney/sdk/auth/api/model/ErrorResponse;", "parameterNames", "", "", "(Ljava/util/List;)V", "getParameterNames", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IllegalParametersErrorResponse extends ErrorResponse {

    @SerializedName("parameterNames")
    private final List<String> parameterNames;

    public IllegalParametersErrorResponse(List<String> list) {
        super(null);
        this.parameterNames = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IllegalParametersErrorResponse copy$default(IllegalParametersErrorResponse illegalParametersErrorResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = illegalParametersErrorResponse.parameterNames;
        }
        return illegalParametersErrorResponse.copy(list);
    }

    public final List<String> component1() {
        return this.parameterNames;
    }

    public final IllegalParametersErrorResponse copy(List<String> parameterNames) {
        return new IllegalParametersErrorResponse(parameterNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IllegalParametersErrorResponse) && Intrinsics.areEqual(this.parameterNames, ((IllegalParametersErrorResponse) other).parameterNames);
    }

    public final List<String> getParameterNames() {
        return this.parameterNames;
    }

    public int hashCode() {
        List<String> list = this.parameterNames;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "IllegalParametersErrorResponse(parameterNames=" + this.parameterNames + ")";
    }
}
