package com.huawei.wisesecurity.kfs.validation.constrains.validator.in;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class KfsInValidatorForInteger implements KfsConstraintValidator<KfsIn, Integer> {
    private List<Integer> integerList;
    private String message;

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public String getMessage() {
        return this.message;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public void initialize(String str, KfsIn kfsIn) {
        this.integerList = new ArrayList();
        for (int i : kfsIn.intArr()) {
            this.integerList.add(Integer.valueOf(i));
        }
        this.message = StringUtil.replaceIfEmpty(kfsIn.message(), str + " must in intArr:" + Arrays.toString(kfsIn.intArr()));
    }

    @Override // com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator
    public boolean isValid(Integer num) {
        if (num == null) {
            return true;
        }
        return this.integerList.contains(num);
    }
}
