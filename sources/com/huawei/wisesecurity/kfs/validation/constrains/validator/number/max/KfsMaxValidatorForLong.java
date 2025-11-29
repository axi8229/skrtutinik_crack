package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* loaded from: classes3.dex */
public class KfsMaxValidatorForLong implements KfsConstraintValidator<KfsMax, Long> {
    private long maxValue;
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsMax kfsMax) {
        this.message = StringUtil.replaceIfEmptyForMax(kfsMax, str);
        this.maxValue = kfsMax.value();
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Long l) {
        return l == null || l.compareTo(Long.valueOf(this.maxValue)) <= 0;
    }
}
