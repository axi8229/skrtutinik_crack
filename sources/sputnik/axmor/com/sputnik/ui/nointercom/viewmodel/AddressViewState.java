package sputnik.axmor.com.sputnik.ui.nointercom.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AddressViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012Jj\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b&\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b'\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b(\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b)\u0010\u0016R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b\u000e\u0010+¨\u0006,"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "customAddress", "", "uuid", "city", "street", "house", "flat", "Lcom/sputnik/domain/common/Event;", "", "isDeleted", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/entities/address/DomainCustomAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;)V", "isBlank", "()Z", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/entities/address/DomainCustomAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "getCustomAddress", "()Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "Ljava/lang/String;", "getUuid", "getCity", "getStreet", "getHouse", "getFlat", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AddressViewState implements VMState {
    private final String city;
    private final DomainCustomAddress customAddress;
    private final String flat;
    private final String house;
    private final Event<Boolean> isDeleted;
    private final Resource.Status serverState;
    private final String street;
    private final String uuid;

    public AddressViewState() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public final AddressViewState copy(Resource.Status serverState, DomainCustomAddress customAddress, String uuid, String city, String street, String house, String flat, Event<Boolean> isDeleted) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(street, "street");
        Intrinsics.checkNotNullParameter(house, "house");
        Intrinsics.checkNotNullParameter(flat, "flat");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        return new AddressViewState(serverState, customAddress, uuid, city, street, house, flat, isDeleted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressViewState)) {
            return false;
        }
        AddressViewState addressViewState = (AddressViewState) other;
        return this.serverState == addressViewState.serverState && Intrinsics.areEqual(this.customAddress, addressViewState.customAddress) && Intrinsics.areEqual(this.uuid, addressViewState.uuid) && Intrinsics.areEqual(this.city, addressViewState.city) && Intrinsics.areEqual(this.street, addressViewState.street) && Intrinsics.areEqual(this.house, addressViewState.house) && Intrinsics.areEqual(this.flat, addressViewState.flat) && Intrinsics.areEqual(this.isDeleted, addressViewState.isDeleted);
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        DomainCustomAddress domainCustomAddress = this.customAddress;
        int iHashCode2 = (iHashCode + (domainCustomAddress == null ? 0 : domainCustomAddress.hashCode())) * 31;
        String str = this.uuid;
        return ((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.city.hashCode()) * 31) + this.street.hashCode()) * 31) + this.house.hashCode()) * 31) + this.flat.hashCode()) * 31) + this.isDeleted.hashCode();
    }

    public String toString() {
        return "AddressViewState(serverState=" + this.serverState + ", customAddress=" + this.customAddress + ", uuid=" + this.uuid + ", city=" + this.city + ", street=" + this.street + ", house=" + this.house + ", flat=" + this.flat + ", isDeleted=" + this.isDeleted + ")";
    }

    public AddressViewState(Resource.Status serverState, DomainCustomAddress domainCustomAddress, String str, String city, String street, String house, String flat, Event<Boolean> isDeleted) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(street, "street");
        Intrinsics.checkNotNullParameter(house, "house");
        Intrinsics.checkNotNullParameter(flat, "flat");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        this.serverState = serverState;
        this.customAddress = domainCustomAddress;
        this.uuid = str;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.isDeleted = isDeleted;
    }

    public /* synthetic */ AddressViewState(Resource.Status status, DomainCustomAddress domainCustomAddress, String str, String str2, String str3, String str4, String str5, Event event, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? null : domainCustomAddress, (i & 4) == 0 ? str : null, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) == 0 ? str5 : "", (i & 128) != 0 ? new Event(Boolean.FALSE) : event);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final DomainCustomAddress getCustomAddress() {
        return this.customAddress;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getStreet() {
        return this.street;
    }

    public final String getHouse() {
        return this.house;
    }

    public final String getFlat() {
        return this.flat;
    }

    public final boolean isBlank() {
        return StringsKt.isBlank(this.city) && StringsKt.isBlank(this.street) && StringsKt.isBlank(this.house) && StringsKt.isBlank(this.flat);
    }
}
