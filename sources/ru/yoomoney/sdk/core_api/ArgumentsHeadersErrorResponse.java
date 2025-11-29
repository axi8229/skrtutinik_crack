package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/core_api/ArgumentsHeadersErrorResponse;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "headerNames", "", "", "(Ljava/util/List;)V", "getHeaderNames", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArgumentsHeadersErrorResponse extends ApiErrorBodyResponse {
    private final List<String> headerNames;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArgumentsHeadersErrorResponse copy$default(ArgumentsHeadersErrorResponse argumentsHeadersErrorResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = argumentsHeadersErrorResponse.headerNames;
        }
        return argumentsHeadersErrorResponse.copy(list);
    }

    public final List<String> component1() {
        return this.headerNames;
    }

    public final ArgumentsHeadersErrorResponse copy(@JsonProperty("headerNames") List<String> headerNames) {
        Intrinsics.checkNotNullParameter(headerNames, "headerNames");
        return new ArgumentsHeadersErrorResponse(headerNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ArgumentsHeadersErrorResponse) && Intrinsics.areEqual(this.headerNames, ((ArgumentsHeadersErrorResponse) other).headerNames);
    }

    public int hashCode() {
        return this.headerNames.hashCode();
    }

    public String toString() {
        return "ArgumentsHeadersErrorResponse(headerNames=" + this.headerNames + ")";
    }

    public final List<String> getHeaderNames() {
        return this.headerNames;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgumentsHeadersErrorResponse(@JsonProperty("headerNames") List<String> headerNames) {
        super(null);
        Intrinsics.checkNotNullParameter(headerNames, "headerNames");
        this.headerNames = headerNames;
    }
}
