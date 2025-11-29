package com.sputnik.domain.entities.market.appearance;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainPlanAppearance.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fHÇ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;", "", "", "planTitle", "priceVerbose", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPlanTitle", "getPriceVerbose", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainPlanAppearance {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String planTitle;
    private final String priceVerbose;

    public DomainPlanAppearance() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPlanAppearance)) {
            return false;
        }
        DomainPlanAppearance domainPlanAppearance = (DomainPlanAppearance) other;
        return Intrinsics.areEqual(this.planTitle, domainPlanAppearance.planTitle) && Intrinsics.areEqual(this.priceVerbose, domainPlanAppearance.priceVerbose);
    }

    public int hashCode() {
        String str = this.planTitle;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.priceVerbose;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DomainPlanAppearance(planTitle=" + this.planTitle + ", priceVerbose=" + this.priceVerbose + ")";
    }

    /* compiled from: DomainPlanAppearance.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainPlanAppearance> serializer() {
            return DomainPlanAppearance$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainPlanAppearance(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.planTitle = null;
        } else {
            this.planTitle = str;
        }
        if ((i & 2) == 0) {
            this.priceVerbose = null;
        } else {
            this.priceVerbose = str2;
        }
    }

    public DomainPlanAppearance(String str, String str2) {
        this.planTitle = str;
        this.priceVerbose = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainPlanAppearance self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.planTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.planTitle);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.priceVerbose == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.priceVerbose);
    }

    public /* synthetic */ DomainPlanAppearance(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getPlanTitle() {
        return this.planTitle;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }
}
