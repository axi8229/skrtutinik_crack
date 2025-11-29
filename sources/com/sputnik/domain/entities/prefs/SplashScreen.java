package com.sputnik.domain.entities.prefs;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SplashScreen.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002+*B1\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tBC\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010!R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010!R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010!R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b\u0007\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/sputnik/domain/entities/prefs/SplashScreen;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "backgroundUrl", "backgroundBase64", "", "isImageLoaded", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/prefs/SplashScreen;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getBackgroundUrl", "setBackgroundUrl", "getBackgroundBase64", "setBackgroundBase64", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setImageLoaded", "(Ljava/lang/Boolean;)V", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class SplashScreen {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String backgroundBase64;
    private String backgroundUrl;
    private Boolean isImageLoaded;
    private String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplashScreen)) {
            return false;
        }
        SplashScreen splashScreen = (SplashScreen) other;
        return Intrinsics.areEqual(this.title, splashScreen.title) && Intrinsics.areEqual(this.backgroundUrl, splashScreen.backgroundUrl) && Intrinsics.areEqual(this.backgroundBase64, splashScreen.backgroundBase64) && Intrinsics.areEqual(this.isImageLoaded, splashScreen.isImageLoaded);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.backgroundUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundBase64;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isImageLoaded;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "SplashScreen(title=" + this.title + ", backgroundUrl=" + this.backgroundUrl + ", backgroundBase64=" + this.backgroundBase64 + ", isImageLoaded=" + this.isImageLoaded + ")";
    }

    @Deprecated
    public /* synthetic */ SplashScreen(int i, String str, String str2, String str3, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, SplashScreen$$serializer.INSTANCE.getDescriptor());
        }
        this.title = str;
        this.backgroundUrl = str2;
        this.backgroundBase64 = str3;
        if ((i & 8) == 0) {
            this.isImageLoaded = null;
        } else {
            this.isImageLoaded = bool;
        }
    }

    public SplashScreen(String str, String str2, String str3, Boolean bool) {
        this.title = str;
        this.backgroundUrl = str2;
        this.backgroundBase64 = str3;
        this.isImageLoaded = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(SplashScreen self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.title);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.backgroundUrl);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.backgroundBase64);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.isImageLoaded == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.isImageLoaded);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }

    public final String getBackgroundBase64() {
        return this.backgroundBase64;
    }

    public final void setBackgroundBase64(String str) {
        this.backgroundBase64 = str;
    }

    /* renamed from: isImageLoaded, reason: from getter */
    public final Boolean getIsImageLoaded() {
        return this.isImageLoaded;
    }

    public final void setImageLoaded(Boolean bool) {
        this.isImageLoaded = bool;
    }

    /* compiled from: SplashScreen.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/entities/prefs/SplashScreen$Companion;", "", "()V", "default", "Lcom/sputnik/domain/entities/prefs/SplashScreen;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SplashScreen> serializer() {
            return SplashScreen$$serializer.INSTANCE;
        }

        /* renamed from: default, reason: not valid java name */
        public final SplashScreen m2545default() {
            return new SplashScreen(null, null, null, Boolean.FALSE);
        }
    }
}
