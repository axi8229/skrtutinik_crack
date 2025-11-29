package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRegex;

/* loaded from: classes3.dex */
public class KfsStringRegexValidator implements KfsConstraintValidator<KfsStringRegex, String> {
    private String message;
    private String regex;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsStringRegex kfsStringRegex) throws KfsValidationException {
        this.regex = kfsStringRegex.regex();
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(String str) {
        String str2;
        if (str == null) {
            str2 = "string is null";
        } else {
            if (str.matches(this.regex)) {
                return true;
            }
            str2 = "value is not match";
        }
        this.message = str2;
        return false;
    }
}
