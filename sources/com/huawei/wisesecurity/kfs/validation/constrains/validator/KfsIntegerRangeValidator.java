package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;

/* loaded from: classes3.dex */
public class KfsIntegerRangeValidator implements KfsConstraintValidator<KfsIntegerRange, Integer> {
    private int max;
    private String message;
    private int min;
    private String validateTargetName;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsIntegerRange kfsIntegerRange) throws KfsValidationException {
        this.min = kfsIntegerRange.min();
        this.max = kfsIntegerRange.max();
        this.validateTargetName = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Integer num) {
        StringBuilder sb;
        int i;
        if (num == null) {
            sb = new StringBuilder();
            sb.append(this.validateTargetName);
            sb.append(" is null");
        } else {
            if (this.min > num.intValue()) {
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" must >= ");
                i = this.min;
            } else {
                if (this.max >= num.intValue()) {
                    return true;
                }
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" must <= ");
                i = this.max;
            }
            sb.append(i);
        }
        this.message = sb.toString();
        return false;
    }
}
