package com.axmor.axvoip.mojo.pjm.common;

import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.ash.toolset.data.result.error.AshErrorDomain;

/* loaded from: classes.dex */
public final class PjmErrors {

    public enum Domains implements AshErrorDomain {
        UNKNOWN,
        ENDPOINT,
        ACCOUNT;

        public AshError.Builder error() {
            return AshError.builder().errorDomain(this);
        }
    }

    public static AshError.Builder unknown(String str) {
        return Domains.UNKNOWN.error().debugDescription(str);
    }
}
