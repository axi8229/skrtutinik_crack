package com.sputnik.service_payments.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: ServicePaymentDeps.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/sputnik/service_payments/di/ServicePaymentDepsStore;", "Lcom/sputnik/service_payments/di/ServicePaymentDepsProvider;", "()V", "<set-?>", "Lcom/sputnik/service_payments/di/ServicePaymentDeps;", "deps", "getDeps", "()Lcom/sputnik/service_payments/di/ServicePaymentDeps;", "setDeps", "(Lcom/sputnik/service_payments/di/ServicePaymentDeps;)V", "deps$delegate", "Lkotlin/properties/ReadWriteProperty;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServicePaymentDepsStore implements ServicePaymentDepsProvider {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ServicePaymentDepsStore.class, "deps", "getDeps()Lcom/sputnik/service_payments/di/ServicePaymentDeps;", 0))};
    public static final ServicePaymentDepsStore INSTANCE = new ServicePaymentDepsStore();

    /* renamed from: deps$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty deps = Delegates.INSTANCE.notNull();

    private ServicePaymentDepsStore() {
    }

    public ServicePaymentDeps getDeps() {
        return (ServicePaymentDeps) deps.getValue(this, $$delegatedProperties[0]);
    }

    public void setDeps(ServicePaymentDeps servicePaymentDeps) {
        Intrinsics.checkNotNullParameter(servicePaymentDeps, "<set-?>");
        deps.setValue(this, $$delegatedProperties[0], servicePaymentDeps);
    }
}
