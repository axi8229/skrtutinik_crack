package com.huawei.wisesecurity.kfs.validation.constrains.validator.in;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class KfsInValidatorForString implements KfsConstraintValidator<KfsIn, String> {
    private String message;
    private List<String> stringList;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsIn kfsIn) {
        this.stringList = Arrays.asList(kfsIn.strArr());
        this.message = StringUtil.replaceIfEmpty(kfsIn.message(), str + " must in strArr:" + Arrays.toString(kfsIn.strArr()));
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(String str) {
        if (str == null) {
            return true;
        }
        return this.stringList.contains(str);
    }
}
