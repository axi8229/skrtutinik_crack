package ru.yoomoney.sdk.yoopinning;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateCustomException.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\b\t\n\u000b\fB\u0011\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", CrashHianalyticsData.MESSAGE, "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "CertificateNotModified", "GetCertificateRequestError", "KeyInBlackListException", "KeyTypeException", "SignatureNotVerifyException", "Lru/yoomoney/sdk/yoopinning/PinningException$CertificateNotModified;", "Lru/yoomoney/sdk/yoopinning/PinningException$GetCertificateRequestError;", "Lru/yoomoney/sdk/yoopinning/PinningException$KeyInBlackListException;", "Lru/yoomoney/sdk/yoopinning/PinningException$KeyTypeException;", "Lru/yoomoney/sdk/yoopinning/PinningException$SignatureNotVerifyException;", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PinningException extends Exception {
    private final String message;

    public /* synthetic */ PinningException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    /* compiled from: CertificateCustomException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException$CertificateNotModified;", "Lru/yoomoney/sdk/yoopinning/PinningException;", "()V", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CertificateNotModified extends PinningException {
        public static final CertificateNotModified INSTANCE = new CertificateNotModified();

        private CertificateNotModified() {
            super("CertificateNotModified", null);
        }
    }

    private PinningException(String str) {
        super(str);
        this.message = str;
    }

    /* compiled from: CertificateCustomException.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException$GetCertificateRequestError;", "Lru/yoomoney/sdk/yoopinning/PinningException;", CrashHianalyticsData.MESSAGE, "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GetCertificateRequestError extends PinningException {
        private final String message;

        public static /* synthetic */ GetCertificateRequestError copy$default(GetCertificateRequestError getCertificateRequestError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getCertificateRequestError.message;
            }
            return getCertificateRequestError.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final GetCertificateRequestError copy(String message) {
            return new GetCertificateRequestError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetCertificateRequestError) && Intrinsics.areEqual(this.message, ((GetCertificateRequestError) other).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "GetCertificateRequestError(message=" + this.message + ")";
        }

        public GetCertificateRequestError(String str) {
            super(str, null);
            this.message = str;
        }

        @Override // ru.yoomoney.sdk.yoopinning.PinningException, java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    /* compiled from: CertificateCustomException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException$KeyInBlackListException;", "Lru/yoomoney/sdk/yoopinning/PinningException;", "()V", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeyInBlackListException extends PinningException {
        public static final KeyInBlackListException INSTANCE = new KeyInBlackListException();

        private KeyInBlackListException() {
            super("Key in Black list", null);
        }
    }

    /* compiled from: CertificateCustomException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException$SignatureNotVerifyException;", "Lru/yoomoney/sdk/yoopinning/PinningException;", "()V", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SignatureNotVerifyException extends PinningException {
        public static final SignatureNotVerifyException INSTANCE = new SignatureNotVerifyException();

        private SignatureNotVerifyException() {
            super("Verify signature failure", null);
        }
    }

    /* compiled from: CertificateCustomException.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/yoopinning/PinningException$KeyTypeException;", "Lru/yoomoney/sdk/yoopinning/PinningException;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class KeyTypeException extends PinningException {
        private final String type;

        public static /* synthetic */ KeyTypeException copy$default(KeyTypeException keyTypeException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = keyTypeException.type;
            }
            return keyTypeException.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final KeyTypeException copy(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KeyTypeException(type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof KeyTypeException) && Intrinsics.areEqual(this.type, ((KeyTypeException) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "KeyTypeException(type=" + this.type + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeyTypeException(String type) {
            super("Invalid keyType = " + type, null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final String getType() {
            return this.type;
        }
    }
}
