package spay.sdk.api;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lspay/sdk/api/InitializationResult;", "", "()V", "ConfigError", "Success", "Lspay/sdk/api/InitializationResult$ConfigError;", "Lspay/sdk/api/InitializationResult$Success;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InitializationResult {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lspay/sdk/api/InitializationResult$ConfigError;", "Lspay/sdk/api/InitializationResult;", CrashHianalyticsData.MESSAGE, "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ConfigError extends InitializationResult {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ ConfigError copy$default(ConfigError configError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configError.message;
            }
            return configError.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ConfigError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ConfigError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConfigError) && Intrinsics.areEqual(this.message, ((ConfigError) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("ConfigError(message="), this.message, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lspay/sdk/api/InitializationResult$Success;", "Lspay/sdk/api/InitializationResult;", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success extends InitializationResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    private InitializationResult() {
    }

    public /* synthetic */ InitializationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
