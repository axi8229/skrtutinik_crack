package com.sputnik.domain.entities.cameras;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCamerasOrder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "", "", "addressId", "", "Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "cameras", "", "callEnabled", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getAddressId", "()Ljava/lang/Integer;", "Ljava/util/List;", "getCameras", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getCallEnabled", "()Ljava/lang/Boolean;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCamerasOrder {
    private final Integer addressId;
    private final Boolean callEnabled;
    private final List<DomainCameraObject> cameras;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCamerasOrder)) {
            return false;
        }
        DomainCamerasOrder domainCamerasOrder = (DomainCamerasOrder) other;
        return Intrinsics.areEqual(this.addressId, domainCamerasOrder.addressId) && Intrinsics.areEqual(this.cameras, domainCamerasOrder.cameras) && Intrinsics.areEqual(this.callEnabled, domainCamerasOrder.callEnabled);
    }

    public int hashCode() {
        Integer num = this.addressId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<DomainCameraObject> list = this.cameras;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.callEnabled;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DomainCamerasOrder(addressId=" + this.addressId + ", cameras=" + this.cameras + ", callEnabled=" + this.callEnabled + ")";
    }

    public DomainCamerasOrder(Integer num, List<DomainCameraObject> list, Boolean bool) {
        this.addressId = num;
        this.cameras = list;
        this.callEnabled = bool;
    }

    public final Integer getAddressId() {
        return this.addressId;
    }

    public final List<DomainCameraObject> getCameras() {
        return this.cameras;
    }

    public final Boolean getCallEnabled() {
        return this.callEnabled;
    }
}
