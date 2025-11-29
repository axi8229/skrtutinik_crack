package com.sputnik.domain.entities.market.subscription;

import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.services.DomainSmallServices$$serializer;
import com.sputnik.domain.entities.market.services.ServiceState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: DomainSubscription.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b-\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0002SRBÍ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dBÁ\u0001\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001c\u0010!J(\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%HÇ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010+R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b7\u00108R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b9\u0010+R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b:\u00108R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b;\u00108R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b<\u0010+R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\b=\u00108R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010D\u001a\u0004\bE\u0010FR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\bG\u0010+R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010N\u001a\u0004\bO\u0010PR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\bQ\u0010+¨\u0006T"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "", "", "productId", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "", "autoRenewStatus", "subscribedFrom", "trial", "canManage", "expansion", "primeSubscription", "", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "services", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "activePlan", "plan", "", "price", "", "refund", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "appearance", "expiresDate", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/sputnik/domain/entities/market/PlansDuration;Lcom/sputnik/domain/entities/market/subscription/DomainPlans;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/sputnik/domain/entities/market/PlansDuration;Lcom/sputnik/domain/entities/market/subscription/DomainPlans;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProductId", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "Ljava/lang/Boolean;", "getAutoRenewStatus", "()Ljava/lang/Boolean;", "getSubscribedFrom", "getTrial", "getCanManage", "getExpansion", "getPrimeSubscription", "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "getActivePlan", "()Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "getPlan", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Ljava/lang/Double;", "getRefund", "()Ljava/lang/Double;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "getExpiresDate", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainSubscription {
    private final DomainPlans activePlan;
    private final DomainSubscriptionAppearance appearance;
    private final Boolean autoRenewStatus;
    private final Boolean canManage;
    private final PlansDuration duration;
    private final String expansion;
    private final String expiresDate;
    private final String plan;
    private final Integer price;
    private final Boolean primeSubscription;
    private final String productId;
    private final Double refund;
    private final List<DomainSmallServices> services;
    private final ServiceState state;
    private final String subscribedFrom;
    private final Boolean trial;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new EnumSerializer("com.sputnik.domain.entities.market.services.ServiceState", ServiceState.values()), null, null, null, null, null, null, new ArrayListSerializer(DomainSmallServices$$serializer.INSTANCE), new EnumSerializer("com.sputnik.domain.entities.market.PlansDuration", PlansDuration.values()), null, null, null, null, null, null};

    public DomainSubscription() {
        this((String) null, (ServiceState) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (List) null, (PlansDuration) null, (DomainPlans) null, (String) null, (Integer) null, (Double) null, (DomainSubscriptionAppearance) null, (String) null, 65535, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSubscription)) {
            return false;
        }
        DomainSubscription domainSubscription = (DomainSubscription) other;
        return Intrinsics.areEqual(this.productId, domainSubscription.productId) && this.state == domainSubscription.state && Intrinsics.areEqual(this.autoRenewStatus, domainSubscription.autoRenewStatus) && Intrinsics.areEqual(this.subscribedFrom, domainSubscription.subscribedFrom) && Intrinsics.areEqual(this.trial, domainSubscription.trial) && Intrinsics.areEqual(this.canManage, domainSubscription.canManage) && Intrinsics.areEqual(this.expansion, domainSubscription.expansion) && Intrinsics.areEqual(this.primeSubscription, domainSubscription.primeSubscription) && Intrinsics.areEqual(this.services, domainSubscription.services) && this.duration == domainSubscription.duration && Intrinsics.areEqual(this.activePlan, domainSubscription.activePlan) && Intrinsics.areEqual(this.plan, domainSubscription.plan) && Intrinsics.areEqual(this.price, domainSubscription.price) && Intrinsics.areEqual(this.refund, domainSubscription.refund) && Intrinsics.areEqual(this.appearance, domainSubscription.appearance) && Intrinsics.areEqual(this.expiresDate, domainSubscription.expiresDate);
    }

    public int hashCode() {
        String str = this.productId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServiceState serviceState = this.state;
        int iHashCode2 = (iHashCode + (serviceState == null ? 0 : serviceState.hashCode())) * 31;
        Boolean bool = this.autoRenewStatus;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.subscribedFrom;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.trial;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canManage;
        int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str3 = this.expansion;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool4 = this.primeSubscription;
        int iHashCode8 = (iHashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        List<DomainSmallServices> list = this.services;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode10 = (iHashCode9 + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        DomainPlans domainPlans = this.activePlan;
        int iHashCode11 = (iHashCode10 + (domainPlans == null ? 0 : domainPlans.hashCode())) * 31;
        String str4 = this.plan;
        int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.refund;
        int iHashCode14 = (iHashCode13 + (d == null ? 0 : d.hashCode())) * 31;
        DomainSubscriptionAppearance domainSubscriptionAppearance = this.appearance;
        int iHashCode15 = (iHashCode14 + (domainSubscriptionAppearance == null ? 0 : domainSubscriptionAppearance.hashCode())) * 31;
        String str5 = this.expiresDate;
        return iHashCode15 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DomainSubscription(productId=" + this.productId + ", state=" + this.state + ", autoRenewStatus=" + this.autoRenewStatus + ", subscribedFrom=" + this.subscribedFrom + ", trial=" + this.trial + ", canManage=" + this.canManage + ", expansion=" + this.expansion + ", primeSubscription=" + this.primeSubscription + ", services=" + this.services + ", duration=" + this.duration + ", activePlan=" + this.activePlan + ", plan=" + this.plan + ", price=" + this.price + ", refund=" + this.refund + ", appearance=" + this.appearance + ", expiresDate=" + this.expiresDate + ")";
    }

    /* compiled from: DomainSubscription.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainSubscription$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainSubscription> serializer() {
            return DomainSubscription$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainSubscription(int i, String str, ServiceState serviceState, Boolean bool, String str2, Boolean bool2, Boolean bool3, String str3, Boolean bool4, List list, PlansDuration plansDuration, DomainPlans domainPlans, String str4, Integer num, Double d, DomainSubscriptionAppearance domainSubscriptionAppearance, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.productId = null;
        } else {
            this.productId = str;
        }
        if ((i & 2) == 0) {
            this.state = null;
        } else {
            this.state = serviceState;
        }
        if ((i & 4) == 0) {
            this.autoRenewStatus = null;
        } else {
            this.autoRenewStatus = bool;
        }
        if ((i & 8) == 0) {
            this.subscribedFrom = null;
        } else {
            this.subscribedFrom = str2;
        }
        if ((i & 16) == 0) {
            this.trial = null;
        } else {
            this.trial = bool2;
        }
        if ((i & 32) == 0) {
            this.canManage = null;
        } else {
            this.canManage = bool3;
        }
        if ((i & 64) == 0) {
            this.expansion = null;
        } else {
            this.expansion = str3;
        }
        this.primeSubscription = (i & 128) == 0 ? Boolean.FALSE : bool4;
        if ((i & 256) == 0) {
            this.services = null;
        } else {
            this.services = list;
        }
        if ((i & 512) == 0) {
            this.duration = null;
        } else {
            this.duration = plansDuration;
        }
        if ((i & 1024) == 0) {
            this.activePlan = null;
        } else {
            this.activePlan = domainPlans;
        }
        if ((i & 2048) == 0) {
            this.plan = null;
        } else {
            this.plan = str4;
        }
        if ((i & 4096) == 0) {
            this.price = null;
        } else {
            this.price = num;
        }
        if ((i & 8192) == 0) {
            this.refund = null;
        } else {
            this.refund = d;
        }
        if ((i & 16384) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainSubscriptionAppearance;
        }
        if ((i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) == 0) {
            this.expiresDate = null;
        } else {
            this.expiresDate = str5;
        }
    }

    public DomainSubscription(String str, ServiceState serviceState, Boolean bool, String str2, Boolean bool2, Boolean bool3, String str3, Boolean bool4, List<DomainSmallServices> list, PlansDuration plansDuration, DomainPlans domainPlans, String str4, Integer num, Double d, DomainSubscriptionAppearance domainSubscriptionAppearance, String str5) {
        this.productId = str;
        this.state = serviceState;
        this.autoRenewStatus = bool;
        this.subscribedFrom = str2;
        this.trial = bool2;
        this.canManage = bool3;
        this.expansion = str3;
        this.primeSubscription = bool4;
        this.services = list;
        this.duration = plansDuration;
        this.activePlan = domainPlans;
        this.plan = str4;
        this.price = num;
        this.refund = d;
        this.appearance = domainSubscriptionAppearance;
        this.expiresDate = str5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainSubscription self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.productId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.state != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.state);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.autoRenewStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.autoRenewStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.subscribedFrom != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.subscribedFrom);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.trial != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.trial);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.canManage != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.canManage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.expansion != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.expansion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.primeSubscription, Boolean.FALSE)) {
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.primeSubscription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.services != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.services);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.duration != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.activePlan != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, DomainPlans$$serializer.INSTANCE, self.activePlan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.plan != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.plan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.refund != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, DoubleSerializer.INSTANCE, self.refund);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.appearance != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, DomainSubscriptionAppearance$$serializer.INSTANCE, self.appearance);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.expiresDate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.expiresDate);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final Boolean getAutoRenewStatus() {
        return this.autoRenewStatus;
    }

    public final Boolean getCanManage() {
        return this.canManage;
    }

    public /* synthetic */ DomainSubscription(String str, ServiceState serviceState, Boolean bool, String str2, Boolean bool2, Boolean bool3, String str3, Boolean bool4, List list, PlansDuration plansDuration, DomainPlans domainPlans, String str4, Integer num, Double d, DomainSubscriptionAppearance domainSubscriptionAppearance, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : serviceState, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : bool3, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? Boolean.FALSE : bool4, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : plansDuration, (i & 1024) != 0 ? null : domainPlans, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : num, (i & 8192) != 0 ? null : d, (i & 16384) != 0 ? null : domainSubscriptionAppearance, (i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? null : str5);
    }

    public final Boolean getPrimeSubscription() {
        return this.primeSubscription;
    }

    public final List<DomainSmallServices> getServices() {
        return this.services;
    }

    public final PlansDuration getDuration() {
        return this.duration;
    }

    public final DomainPlans getActivePlan() {
        return this.activePlan;
    }

    public final Double getRefund() {
        return this.refund;
    }

    public final DomainSubscriptionAppearance getAppearance() {
        return this.appearance;
    }

    public final String getExpiresDate() {
        return this.expiresDate;
    }
}
