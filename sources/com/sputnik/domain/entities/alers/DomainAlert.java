package com.sputnik.domain.entities.alers;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainAlert.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/alers/DomainAlert;", "", "", "version", "", "required", "Lcom/sputnik/domain/entities/alers/DomainAlertAppearance;", "appearance", "", "Lcom/sputnik/domain/entities/alers/DomainButton;", "buttons", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/alers/DomainAlertAppearance;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getRequired", "()Ljava/lang/Boolean;", "Lcom/sputnik/domain/entities/alers/DomainAlertAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/alers/DomainAlertAppearance;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainAlert {
    private final DomainAlertAppearance appearance;
    private final List<DomainButton> buttons;
    private final Boolean required;
    private final Integer version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainAlert)) {
            return false;
        }
        DomainAlert domainAlert = (DomainAlert) other;
        return Intrinsics.areEqual(this.version, domainAlert.version) && Intrinsics.areEqual(this.required, domainAlert.required) && Intrinsics.areEqual(this.appearance, domainAlert.appearance) && Intrinsics.areEqual(this.buttons, domainAlert.buttons);
    }

    public int hashCode() {
        Integer num = this.version;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.required;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        DomainAlertAppearance domainAlertAppearance = this.appearance;
        return ((iHashCode2 + (domainAlertAppearance != null ? domainAlertAppearance.hashCode() : 0)) * 31) + this.buttons.hashCode();
    }

    public String toString() {
        return "DomainAlert(version=" + this.version + ", required=" + this.required + ", appearance=" + this.appearance + ", buttons=" + this.buttons + ")";
    }

    public DomainAlert(Integer num, Boolean bool, DomainAlertAppearance domainAlertAppearance, List<DomainButton> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        this.version = num;
        this.required = bool;
        this.appearance = domainAlertAppearance;
        this.buttons = buttons;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final DomainAlertAppearance getAppearance() {
        return this.appearance;
    }

    public final List<DomainButton> getButtons() {
        return this.buttons;
    }
}
