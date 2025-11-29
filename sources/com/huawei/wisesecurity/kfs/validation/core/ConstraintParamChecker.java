package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;

/* loaded from: classes3.dex */
public class ConstraintParamChecker {
    public static void checkSizeParam(KfsSize kfsSize) throws KfsValidationException {
        int iMin = kfsSize.min();
        int iMax = kfsSize.max();
        if (iMin < 0) {
            throw new KfsValidationException("min can't be negative");
        }
        if (iMax < 0) {
            throw new KfsValidationException("max can't be negative");
        }
        if (iMax < iMin) {
            throw new KfsValidationException("max should be bigger than min");
        }
    }
}
