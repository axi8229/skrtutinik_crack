package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRange;

/* loaded from: classes3.dex */
public class KfsStringRangeValidator implements KfsConstraintValidator<KfsStringRange, String> {
    private int max;
    private String message;
    private int min;
    private String validateTargetName;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsStringRange kfsStringRange) throws KfsValidationException {
        this.min = kfsStringRange.min();
        this.max = kfsStringRange.max();
        this.validateTargetName = str;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(String str) {
        StringBuilder sb;
        int i;
        if (str == null) {
            sb = new StringBuilder();
            sb.append(this.validateTargetName);
            sb.append(" is null");
        } else {
            if (str.length() < this.min) {
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" length must >= ");
                i = this.min;
            } else {
                if (str.length() <= this.max) {
                    return true;
                }
                sb = new StringBuilder();
                sb.append(this.validateTargetName);
                sb.append(" length must <= ");
                i = this.max;
            }
            sb.append(i);
        }
        this.message = sb.toString();
        return false;
    }
}
