package com.sputnik.domain.entities.prefs;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: VersionModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0018R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/sputnik/domain/entities/prefs/VersionModel;", "", "", "locale", "", "version", "", "loadedText", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Long;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/VersionModel;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLocale", "Ljava/lang/Long;", "getVersion", "()Ljava/lang/Long;", "setVersion", "(Ljava/lang/Long;)V", "Ljava/util/List;", "getLoadedText", "()Ljava/util/List;", "setLoadedText", "(Ljava/util/List;)V", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class VersionModel {
    private List<String> loadedText;
    private final String locale;
    private Long version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

    public VersionModel() {
        this((String) null, (Long) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VersionModel)) {
            return false;
        }
        VersionModel versionModel = (VersionModel) other;
        return Intrinsics.areEqual(this.locale, versionModel.locale) && Intrinsics.areEqual(this.version, versionModel.version) && Intrinsics.areEqual(this.loadedText, versionModel.loadedText);
    }

    public int hashCode() {
        String str = this.locale;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.version;
        return ((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + this.loadedText.hashCode();
    }

    public String toString() {
        return "VersionModel(locale=" + this.locale + ", version=" + this.version + ", loadedText=" + this.loadedText + ")";
    }

    /* compiled from: VersionModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/prefs/VersionModel$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/prefs/VersionModel;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VersionModel> serializer() {
            return VersionModel$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ VersionModel(int i, String str, Long l, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.locale = null;
        } else {
            this.locale = str;
        }
        if ((i & 2) == 0) {
            this.version = null;
        } else {
            this.version = l;
        }
        if ((i & 4) == 0) {
            this.loadedText = CollectionsKt.emptyList();
        } else {
            this.loadedText = list;
        }
    }

    public VersionModel(String str, Long l, List<String> loadedText) {
        Intrinsics.checkNotNullParameter(loadedText, "loadedText");
        this.locale = str;
        this.version = l;
        this.loadedText = loadedText;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(VersionModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.locale != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.locale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.version != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.version);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.loadedText, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.loadedText);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final void setVersion(Long l) {
        this.version = l;
    }

    public /* synthetic */ VersionModel(String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getLoadedText() {
        return this.loadedText;
    }

    public final void setLoadedText(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.loadedText = list;
    }
}
