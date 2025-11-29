package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* loaded from: classes3.dex */
public class KfsMinValidatorForLong implements KfsConstraintValidator<KfsMin, Long> {
    private String message;
    private long minValue;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsMin kfsMin) {
        this.message = StringUtil.replaceIfEmptyForMin(kfsMin, str);
        this.minValue = kfsMin.value();
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Long l) {
        return l == null || l.compareTo(Long.valueOf(this.minValue)) >= 0;
    }
}
