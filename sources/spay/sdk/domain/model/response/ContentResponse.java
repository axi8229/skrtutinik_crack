package spay.sdk.domain.model.response;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lspay/sdk/domain/model/response/ContentResponse;", "T", "", "()V", "Failure", "Success", "Lspay/sdk/domain/model/response/ContentResponse$Failure;", "Lspay/sdk/domain/model/response/ContentResponse$Success;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContentResponse<T> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lspay/sdk/domain/model/response/ContentResponse$Failure;", "T", "Lspay/sdk/domain/model/response/ContentResponse;", "error", "Lspay/sdk/domain/model/response/ErrorEntity;", "(Lspay/sdk/domain/model/response/ErrorEntity;)V", "getError", "()Lspay/sdk/domain/model/response/ErrorEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Failure<T> extends ContentResponse<T> {
        private final ErrorEntity error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(ErrorEntity error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, ErrorEntity errorEntity, int i, Object obj) {
            if ((i & 1) != 0) {
                errorEntity = failure.error;
            }
            return failure.copy(errorEntity);
        }

        /* renamed from: component1, reason: from getter */
        public final ErrorEntity getError() {
            return this.error;
        }

        public final Failure<T> copy(ErrorEntity error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failure<>(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.error, ((Failure) other).error);
        }

        public final ErrorEntity getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.error + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lspay/sdk/domain/model/response/ContentResponse$Success;", "T", "Lspay/sdk/domain/model/response/ContentResponse;", RemoteMessageConst.DATA, "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lspay/sdk/domain/model/response/ContentResponse$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success<T> extends ContentResponse<T> {
        private final T data;

        /* JADX WARN: Illegal instructions before constructor call */
        public Success() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            this(defaultConstructorMarker, 1, defaultConstructorMarker);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.data, ((Success) other).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        public Success(T t) {
            super(null);
            this.data = t;
        }

        public /* synthetic */ Success(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }
    }

    private ContentResponse() {
    }

    public /* synthetic */ ContentResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
