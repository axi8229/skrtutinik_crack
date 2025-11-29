package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

/* loaded from: classes3.dex */
public class KfsMinValidatorForInteger implements KfsConstraintValidator<KfsMin, Integer> {
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
    public boolean isValid(Integer num) {
        if (num == null) {
            return true;
        }
        if (this.minValue >= 2147483647L) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.minValue);
        sb.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb.toString()))) >= 0;
    }
}
