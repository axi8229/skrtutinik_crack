package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class TypeHelper {
    public static Type extractValidatorType(Class<? extends KfsConstraintValidator<?, ?>> cls) {
        return ((ParameterizedType) cls.getGenericInterfaces()[0]).getActualTypeArguments()[1];
    }
}
