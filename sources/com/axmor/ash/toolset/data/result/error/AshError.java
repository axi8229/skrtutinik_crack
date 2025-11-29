package com.axmor.ash.toolset.data.result.error;

import lombok.NonNull;

/* loaded from: classes.dex */
public final class AshError {
    private final long code;
    private final String debugDescription;

    @NonNull
    private final AshErrorDomain errorDomain;

    public static class Builder {
        private long code;
        private String debugDescription;
        private AshErrorDomain errorDomain;

        Builder() {
        }

        public AshError build() {
            return new AshError(this.errorDomain, this.code, null, this.debugDescription);
        }

        public Builder code(long j) {
            this.code = j;
            return this;
        }

        public Builder debugDescription(String str) {
            this.debugDescription = str;
            return this;
        }

        public Builder errorDomain(@NonNull AshErrorDomain ashErrorDomain) {
            if (ashErrorDomain == null) {
                throw new NullPointerException("errorDomain is marked non-null but is null");
            }
            this.errorDomain = ashErrorDomain;
            return this;
        }

        public String toString() {
            return "AshError.Builder(errorDomain=" + this.errorDomain + ", code=" + this.code + ", localizer=" + ((Object) null) + ", debugDescription=" + this.debugDescription + ")";
        }
    }

    AshError(@NonNull AshErrorDomain ashErrorDomain, long j, Localizer localizer, String str) {
        if (ashErrorDomain == null) {
            throw new NullPointerException("errorDomain is marked non-null but is null");
        }
        this.errorDomain = ashErrorDomain;
        this.code = j;
        this.debugDescription = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getCode() {
        return this.code;
    }

    public String getDebugDescription() {
        return this.debugDescription;
    }

    @NonNull
    public AshErrorDomain getErrorDomain() {
        return this.errorDomain;
    }

    public String toString() {
        return "AshError(errorDomain=" + getErrorDomain() + ", code=" + getCode() + ", debugDescription=" + getDebugDescription() + ")";
    }
}
