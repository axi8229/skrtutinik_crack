package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/core_api/TooManyRequestsResponse;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "retryAfter", "", "(I)V", "getRetryAfter", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TooManyRequestsResponse extends ApiErrorBodyResponse {
    private final int retryAfter;

    public static /* synthetic */ TooManyRequestsResponse copy$default(TooManyRequestsResponse tooManyRequestsResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tooManyRequestsResponse.retryAfter;
        }
        return tooManyRequestsResponse.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRetryAfter() {
        return this.retryAfter;
    }

    public final TooManyRequestsResponse copy(@JsonProperty("retryAfter") int retryAfter) {
        return new TooManyRequestsResponse(retryAfter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TooManyRequestsResponse) && this.retryAfter == ((TooManyRequestsResponse) other).retryAfter;
    }

    public int hashCode() {
        return Integer.hashCode(this.retryAfter);
    }

    public String toString() {
        return "TooManyRequestsResponse(retryAfter=" + this.retryAfter + ")";
    }

    public final int getRetryAfter() {
        return this.retryAfter;
    }

    public TooManyRequestsResponse(@JsonProperty("retryAfter") int i) {
        super(null);
        this.retryAfter = i;
    }
}
