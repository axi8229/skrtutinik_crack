package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiErrorBodyResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/core_api/TechnicalErrorResponse;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "retryAfter", "", "description", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getRetryAfter", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lru/yoomoney/sdk/core_api/TechnicalErrorResponse;", "equals", "", "other", "", "hashCode", "toString", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TechnicalErrorResponse extends ApiErrorBodyResponse {
    private final String description;
    private final Integer retryAfter;

    public static /* synthetic */ TechnicalErrorResponse copy$default(TechnicalErrorResponse technicalErrorResponse, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = technicalErrorResponse.retryAfter;
        }
        if ((i & 2) != 0) {
            str = technicalErrorResponse.description;
        }
        return technicalErrorResponse.copy(num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final TechnicalErrorResponse copy(@JsonProperty("retryAfter") Integer retryAfter, @JsonProperty("description") String description) {
        return new TechnicalErrorResponse(retryAfter, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TechnicalErrorResponse)) {
            return false;
        }
        TechnicalErrorResponse technicalErrorResponse = (TechnicalErrorResponse) other;
        return Intrinsics.areEqual(this.retryAfter, technicalErrorResponse.retryAfter) && Intrinsics.areEqual(this.description, technicalErrorResponse.description);
    }

    public int hashCode() {
        Integer num = this.retryAfter;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.description;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TechnicalErrorResponse(retryAfter=" + this.retryAfter + ", description=" + this.description + ")";
    }

    public final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public final String getDescription() {
        return this.description;
    }

    public TechnicalErrorResponse(@JsonProperty("retryAfter") Integer num, @JsonProperty("description") String str) {
        super(null);
        this.retryAfter = num;
        this.description = str;
    }
}
