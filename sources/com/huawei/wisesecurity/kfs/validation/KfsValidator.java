package com.huawei.wisesecurity.kfs.validation;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.metadata.BeanMetaData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class KfsValidator {
    private static final Map<Class<?>, BeanMetaData<?>> CACHE_BEAN_META_DATA_MAP = new ConcurrentHashMap();

    private static BeanMetaData<?> getBeanMetaData(Class<?> cls) throws KfsValidationException {
        Map<Class<?>, BeanMetaData<?>> map = CACHE_BEAN_META_DATA_MAP;
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        BeanMetaData<?> beanMetaData = new BeanMetaData<>(cls);
        map.put(cls, beanMetaData);
        return beanMetaData;
    }

    public static <T> void validate(T t) throws KfsValidationException {
        if (t == null) {
            throw new KfsValidationException("validate bean is null");
        }
        BeanMetaData<?> beanMetaData = getBeanMetaData(t.getClass());
        if (beanMetaData.hasConstraints()) {
            beanMetaData.validate(t);
        }
    }
}
