package com.axmor.axvoip.mojo.pjm.common;

import lombok.NonNull;
import org.pjsip.pjsua2.OnRegStateParam;

/* loaded from: classes.dex */
public final class PjmSipStatus {

    private enum ResponseType {
        PROVISIONAL(1),
        SUCCESS(2),
        REDIRECT(3),
        CLIENT_FAIL(4),
        SERVER_FAIL(5),
        GLOBAL_FAIL(6);

        private final int major;

        ResponseType(int i) {
            this.major = i;
        }

        public boolean isMatchingCode(int i) {
            return this.major == PjmSipStatus.extractMajor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int extractMajor(int i) {
        return i / 100;
    }

    public static boolean isSuccess(int i) {
        return ResponseType.SUCCESS.isMatchingCode(i);
    }

    public static boolean isUnregistered(@NonNull OnRegStateParam onRegStateParam) {
        if (onRegStateParam != null) {
            return 0 == onRegStateParam.getExpiration();
        }
        throw new NullPointerException("param is marked non-null but is null");
    }
}
