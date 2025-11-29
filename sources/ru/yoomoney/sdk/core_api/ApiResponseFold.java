package ru.yoomoney.sdk.core_api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* compiled from: ApiResponseFold.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0001\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponseFold;", "Success", "", "Error", "NotModified", "RetryAfter", "Lru/yoomoney/sdk/core_api/ApiResponseFold$Error;", "Lru/yoomoney/sdk/core_api/ApiResponseFold$NotModified;", "Lru/yoomoney/sdk/core_api/ApiResponseFold$RetryAfter;", "Lru/yoomoney/sdk/core_api/ApiResponseFold$Success;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ApiResponseFold<Success> {

    /* compiled from: ApiResponseFold.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponseFold$Success;", "Success", "Lru/yoomoney/sdk/core_api/ApiResponseFold;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "headers", "Lokhttp3/Headers;", "(Ljava/lang/Object;Lokhttp3/Headers;)V", "getHeaders", "()Lokhttp3/Headers;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Lokhttp3/Headers;)Lru/yoomoney/sdk/core_api/ApiResponseFold$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Success<Success> implements ApiResponseFold<Success> {
        private final Headers headers;
        private final Success value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, Headers headers, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.value;
            }
            if ((i & 2) != 0) {
                headers = success.headers;
            }
            return success.copy(obj, headers);
        }

        public final Success component1() {
            return this.value;
        }

        /* renamed from: component2, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }

        public final Success<Success> copy(Success value, Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return new Success<>(value, headers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.value, success.value) && Intrinsics.areEqual(this.headers, success.headers);
        }

        public int hashCode() {
            Success success = this.value;
            return ((success == null ? 0 : success.hashCode()) * 31) + this.headers.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ", headers=" + this.headers + ")";
        }

        public Success(Success success, Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.value = success;
            this.headers = headers;
        }

        public final Headers getHeaders() {
            return this.headers;
        }

        public final Success getValue() {
            return this.value;
        }
    }

    /* compiled from: ApiResponseFold.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponseFold$Error;", "Success", "Lru/yoomoney/sdk/core_api/ApiResponseFold;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "(Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;)V", "getValue", "()Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error<Success> implements ApiResponseFold<Success> {
        private final ApiErrorBodyResponse value;

        public static /* synthetic */ Error copy$default(Error error, ApiErrorBodyResponse apiErrorBodyResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                apiErrorBodyResponse = error.value;
            }
            return error.copy(apiErrorBodyResponse);
        }

        /* renamed from: component1, reason: from getter */
        public final ApiErrorBodyResponse getValue() {
            return this.value;
        }

        public final Error<Success> copy(ApiErrorBodyResponse value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Error<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.value, ((Error) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Error(value=" + this.value + ")";
        }

        public Error(ApiErrorBodyResponse value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ApiErrorBodyResponse getValue() {
            return this.value;
        }
    }

    /* compiled from: ApiResponseFold.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponseFold$RetryAfter;", "Success", "Lru/yoomoney/sdk/core_api/ApiResponseFold;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lru/yoomoney/sdk/core_api/ProcessApiResponseBody;", "(Lru/yoomoney/sdk/core_api/ProcessApiResponseBody;)V", "getValue", "()Lru/yoomoney/sdk/core_api/ProcessApiResponseBody;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RetryAfter<Success> implements ApiResponseFold<Success> {
        private final ProcessApiResponseBody value;

        public static /* synthetic */ RetryAfter copy$default(RetryAfter retryAfter, ProcessApiResponseBody processApiResponseBody, int i, Object obj) {
            if ((i & 1) != 0) {
                processApiResponseBody = retryAfter.value;
            }
            return retryAfter.copy(processApiResponseBody);
        }

        /* renamed from: component1, reason: from getter */
        public final ProcessApiResponseBody getValue() {
            return this.value;
        }

        public final RetryAfter<Success> copy(ProcessApiResponseBody value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new RetryAfter<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RetryAfter) && Intrinsics.areEqual(this.value, ((RetryAfter) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "RetryAfter(value=" + this.value + ")";
        }

        public RetryAfter(ProcessApiResponseBody value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ProcessApiResponseBody getValue() {
            return this.value;
        }
    }

    /* compiled from: ApiResponseFold.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/core_api/ApiResponseFold$NotModified;", "Success", "Lru/yoomoney/sdk/core_api/ApiResponseFold;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lokhttp3/Headers;", "(Lokhttp3/Headers;)V", "getValue", "()Lokhttp3/Headers;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NotModified<Success> implements ApiResponseFold<Success> {
        private final Headers value;

        public static /* synthetic */ NotModified copy$default(NotModified notModified, Headers headers, int i, Object obj) {
            if ((i & 1) != 0) {
                headers = notModified.value;
            }
            return notModified.copy(headers);
        }

        /* renamed from: component1, reason: from getter */
        public final Headers getValue() {
            return this.value;
        }

        public final NotModified<Success> copy(Headers value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new NotModified<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NotModified) && Intrinsics.areEqual(this.value, ((NotModified) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "NotModified(value=" + this.value + ")";
        }

        public NotModified(Headers value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final Headers getValue() {
            return this.value;
        }
    }
}
