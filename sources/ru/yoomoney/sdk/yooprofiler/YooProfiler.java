package ru.yoomoney.sdk.yooprofiler;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J<\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u000bH&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "", Scopes.PROFILE, "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", "eventType", "Lru/yoomoney/sdk/yooprofiler/ProfileEventType;", "uid", "", "publicCardSynonym", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "profileWithSessionId", "sessionId", "Result", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface YooProfiler {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Result profile$default(YooProfiler yooProfiler, ProfileEventType profileEventType, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: profile");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return yooProfiler.profile(profileEventType, str, str2);
        }

        public static /* synthetic */ Result profileWithSessionId$default(YooProfiler yooProfiler, String str, ProfileEventType profileEventType, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: profileWithSessionId");
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return yooProfiler.profileWithSessionId(str, profileEventType, str2, str3);
        }

        public static /* synthetic */ void profile$default(YooProfiler yooProfiler, ProfileEventType profileEventType, String str, String str2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: profile");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            yooProfiler.profile(profileEventType, str, str2, function1);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", "", "()V", "Fail", "Success", "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result$Fail;", "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result$Success;", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result$Fail;", "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", "description", "", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Fail extends Result {
            private final String description;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fail(String description) {
                super(null);
                Intrinsics.checkNotNullParameter(description, "description");
                this.description = description;
            }

            public static /* synthetic */ Fail copy$default(Fail fail, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fail.description;
                }
                return fail.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final Fail copy(String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                return new Fail(description);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fail) && Intrinsics.areEqual(this.description, ((Fail) other).description);
            }

            public final String getDescription() {
                return this.description;
            }

            public int hashCode() {
                return this.description.hashCode();
            }

            public String toString() {
                return "Fail(description=" + this.description + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result$Success;", "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", "sessionId", "", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Success extends Result {
            private final String sessionId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String sessionId) {
                super(null);
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                this.sessionId = sessionId;
            }

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.sessionId;
                }
                return success.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            public final Success copy(String sessionId) {
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                return new Success(sessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.sessionId, ((Success) other).sessionId);
            }

            public final String getSessionId() {
                return this.sessionId;
            }

            public int hashCode() {
                return this.sessionId.hashCode();
            }

            public String toString() {
                return "Success(sessionId=" + this.sessionId + ")";
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Result profile(ProfileEventType eventType, String uid, String publicCardSynonym);

    void profile(ProfileEventType eventType, String uid, String publicCardSynonym, Function1<? super Result, Unit> listener);

    Result profileWithSessionId(String sessionId, ProfileEventType eventType, String uid, String publicCardSynonym);
}
