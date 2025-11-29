package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;

/* loaded from: classes3.dex */
public class KfsNotBlankValidator implements KfsConstraintValidator<KfsNotBlank, CharSequence> {
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsNotBlank kfsNotBlank) {
        this.message = StringUtil.replaceIfEmpty(kfsNotBlank.message(), str + " can't be blank");
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().trim().length() > 0;
    }
}
