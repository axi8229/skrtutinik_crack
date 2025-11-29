package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;

/* loaded from: classes3.dex */
public class KfsLongRangeValidator implements KfsConstraintValidator<KfsLongRange, Long> {
    private Long max;
    private String message;
    private Long min;
    private String validateTargetName;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsLongRange kfsLongRange) throws KfsValidationException {
        this.min = Long.valueOf(kfsLongRange.min());
        this.max = Long.valueOf(kfsLongRange.max());
        this.validateTargetName = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Long l) {
        StringBuilder sb;
        Long l2;
        if (l == null) {
            sb = new StringBuilder();
            sb.append(this.validateTargetName);
            sb.append(" is null");
        } else {
            if (l.longValue() < this.min.longValue()) {
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" must >= ");
                l2 = this.min;
            } else {
                if (l.longValue() <= this.max.longValue()) {
                    return true;
                }
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" must <= ");
                l2 = this.max;
            }
            sb.append(l2);
        }
        this.message = sb.toString();
        return false;
    }
}
