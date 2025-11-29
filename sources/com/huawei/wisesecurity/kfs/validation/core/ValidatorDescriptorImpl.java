package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ValidatorDescriptorImpl<A extends Annotation> implements ValidatorDescriptor<A> {
    private final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> validatorDefaultMap = new ConcurrentHashMap();
    private final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> validatorArrayMap = new ConcurrentHashMap();
    private final Map<Class<?>, Class<?>> primitiveTypeMap = new ConcurrentHashMap<Class<?>, Class<?>>() { // from class: com.huawei.wisesecurity.kfs.validation.core.ValidatorDescriptorImpl.1
        {
            put(Byte.TYPE, Byte.class);
            put(Short.TYPE, Short.class);
            put(Integer.TYPE, Integer.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
            put(Character.TYPE, Character.class);
            put(Boolean.TYPE, Boolean.class);
        }
    };
    private final Map<Class<?>, Class<?>> primitiveArrayClassMap = new ConcurrentHashMap<Class<?>, Class<?>>() { // from class: com.huawei.wisesecurity.kfs.validation.core.ValidatorDescriptorImpl.2
        {
            put(Byte.TYPE, byte[].class);
            put(Short.TYPE, short[].class);
            put(Integer.TYPE, int[].class);
            put(Long.TYPE, long[].class);
            put(Float.TYPE, float[].class);
            put(Double.TYPE, double[].class);
            put(Character.TYPE, char[].class);
            put(Boolean.TYPE, boolean[].class);
        }
    };

    @SafeVarargs
    public ValidatorDescriptorImpl(Class<? extends KfsConstraintValidator<A, ?>>... clsArr) {
        for (Class<? extends KfsConstraintValidator<A, ?>> cls : clsArr) {
            putConstraint(cls);
        }
    }

    private Class<? extends KfsConstraintValidator<A, ?>> getValidatorForClassAndHierarchy(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Class<?> cls) {
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        Class<? extends KfsConstraintValidator<A, ?>> validatorType = getValidatorType(map, cls.getGenericSuperclass());
        if (validatorType != null) {
            return validatorType;
        }
        for (Type type : cls.getGenericInterfaces()) {
            Class<? extends KfsConstraintValidator<A, ?>> validatorType2 = getValidatorType(map, type);
            if (validatorType2 != null) {
                return validatorType2;
            }
        }
        return null;
    }

    private Class<? extends KfsConstraintValidator<A, ?>> getValidatorType(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Type type) {
        Class<? extends KfsConstraintValidator<A, ?>> validatorForClassAndHierarchy;
        if (type == null) {
            return null;
        }
        if ((type instanceof Class) && (validatorForClassAndHierarchy = getValidatorForClassAndHierarchy(map, (Class) type)) != null) {
            return validatorForClassAndHierarchy;
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getRawType() instanceof Class) {
            return getValidatorForClassAndHierarchy(map, (Class) parameterizedType.getRawType());
        }
        return null;
    }

    private Class<?> normalizeClass(Class<?> cls) {
        return this.primitiveTypeMap.containsKey(cls) ? this.primitiveTypeMap.get(cls) : cls;
    }

    private void putConstraint(Class<? extends KfsConstraintValidator<A, ?>> cls) {
        Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map;
        Type typeExtractValidatorType = TypeHelper.extractValidatorType(cls);
        if (typeExtractValidatorType instanceof Class) {
            Class cls2 = (Class) typeExtractValidatorType;
            if (cls2.isArray()) {
                this.validatorArrayMap.put(cls2.getComponentType(), cls);
            }
            map = this.validatorDefaultMap;
        } else {
            if (!(typeExtractValidatorType instanceof GenericArrayType)) {
                return;
            }
            Class cls3 = (Class) ((GenericArrayType) typeExtractValidatorType).getGenericComponentType();
            if (!this.primitiveArrayClassMap.containsKey(cls3)) {
                return;
            }
            map = this.validatorDefaultMap;
            typeExtractValidatorType = this.primitiveArrayClassMap.get(cls3);
        }
        map.put(typeExtractValidatorType, cls);
    }

    @Override // com.huawei.wisesecurity.kfs.validation.core.ValidatorDescriptor
    public Class<? extends KfsConstraintValidator<A, ?>> getValidator(Class<?> cls) {
        Class<? extends KfsConstraintValidator<A, ?>> cls2;
        if (cls == null) {
            return null;
        }
        Class<?> clsNormalizeClass = normalizeClass(cls);
        if (this.validatorDefaultMap.containsKey(Object.class)) {
            cls2 = this.validatorDefaultMap.get(Object.class);
        } else {
            if (!this.validatorDefaultMap.containsKey(clsNormalizeClass)) {
                Class<? extends KfsConstraintValidator<A, ?>> validatorType = clsNormalizeClass.isArray() ? getValidatorType(this.validatorArrayMap, clsNormalizeClass.getComponentType()) : getValidatorType(this.validatorDefaultMap, clsNormalizeClass);
                if (validatorType != null) {
                    this.validatorDefaultMap.put(clsNormalizeClass, validatorType);
                }
                return validatorType;
            }
            cls2 = this.validatorDefaultMap.get(clsNormalizeClass);
        }
        return cls2;
    }
}
