package com.axmor.ash.toolset.service.impl;

import android.app.Service;
import android.content.Context;
import com.axmor.ash.toolset.service.Component;
import com.axmor.ash.toolset.service.Composite;
import com.axmor.ash.toolset.utils.AshAssert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.NonNull;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes.dex */
final class ServiceCore implements Composite, CompositeBuilder {
    private final Context context;
    private final EventBus eventBus;
    private final ServiceLifeline lifeline;
    private final HashMap<Class<?>, Component<?>> components = new HashMap<>();
    private boolean active = false;
    private boolean shutdown = false;

    public ServiceCore(@NonNull Service service) {
        if (service == null) {
            throw new NullPointerException("hostService is marked non-null but is null");
        }
        this.context = service;
        this.eventBus = EventBus.getDefault();
        this.lifeline = new ServiceLifeline(service);
    }

    private void activateComponent(@NonNull Component<?> component) {
        if (component == null) {
            throw new NullPointerException("component is marked non-null but is null");
        }
        component.activate(new ComponentContext(this.context, this.eventBus, new ComponentLifetimeListener(this.lifeline)) { // from class: com.axmor.ash.toolset.service.impl.ServiceCore.1
        });
    }

    private void deactivateComponent(@NonNull Component<?> component) {
        if (component == null) {
            throw new NullPointerException("component is marked non-null but is null");
        }
        component.deactivate();
    }

    public void activate() {
        if (this.active) {
            return;
        }
        this.active = true;
        Iterator<Map.Entry<Class<?>, Component<?>>> it = this.components.entrySet().iterator();
        while (it.hasNext()) {
            activateComponent(it.next().getValue());
        }
    }

    @Override // com.axmor.ash.toolset.service.impl.CompositeBuilder
    public <TService> void addComponent(Class<TService> cls, Component<? extends TService> component) {
        AshAssert.aFalse(this.shutdown);
        AshAssert.aFalse(this.components.containsKey(cls));
        if (this.shutdown) {
            return;
        }
        this.components.put(cls, component);
        if (this.active) {
            activateComponent(component);
        }
    }

    @Override // com.axmor.ash.toolset.service.Composite
    public void busSubscribe(@NonNull Object obj) {
        if (obj == null) {
            throw new NullPointerException("subscriber is marked non-null but is null");
        }
        AshAssert.aFalse(this.shutdown);
        if (this.shutdown) {
            return;
        }
        try {
            this.eventBus.register(obj);
        } catch (Exception unused) {
        }
    }

    @Override // com.axmor.ash.toolset.service.Composite
    public void busUnsubscribe(@NonNull Object obj) {
        if (obj == null) {
            throw new NullPointerException("subscriber is marked non-null but is null");
        }
        AshAssert.aFalse(this.shutdown);
        try {
            this.eventBus.unregister(obj);
        } catch (Exception unused) {
        }
    }

    public void deactivate() {
        if (this.active) {
            this.active = false;
            Iterator<Map.Entry<Class<?>, Component<?>>> it = this.components.entrySet().iterator();
            while (it.hasNext()) {
                deactivateComponent(it.next().getValue());
            }
        }
    }

    @Override // com.axmor.ash.toolset.service.Composite
    public <TService> TService getService(@NonNull Class<TService> cls) {
        if (cls == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        AshAssert.aFalse(this.shutdown);
        if (this.shutdown) {
            throw new IllegalStateException("This service has been shutdown.");
        }
        AshAssert.aTrue(this.active);
        if (!this.active) {
            throw new IllegalStateException("This service has not been activated.");
        }
        Component<?> component = this.components.get(cls);
        if (component == null) {
            throw new IllegalStateException("Requested unknown component.");
        }
        TService tserviceCast = cls.cast(component.getService());
        if (tserviceCast != null) {
            return tserviceCast;
        }
        throw new IllegalStateException("Component failed to provide it's service.");
    }

    public void setHaveBindings(boolean z) {
        AshAssert.aFalse(this.shutdown);
        this.lifeline.setHaveBindings(z);
    }

    public void shutdown() {
        AshAssert.aFalse(this.shutdown);
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        deactivate();
        this.components.clear();
    }
}
