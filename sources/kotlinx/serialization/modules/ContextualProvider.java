package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* compiled from: SerializersModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006H¦\u0002\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider;", "", "()V", "invoke", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "", "Argless", "WithTypeArguments", "Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ContextualProvider {
    public abstract KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers);

    private ContextualProvider() {
    }

    /* compiled from: SerializersModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider;", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "invoke", "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "serializer", "Lkotlinx/serialization/KSerializer;", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Argless extends ContextualProvider {
        private final KSerializer<?> serializer;

        public final KSerializer<?> getSerializer() {
            return this.serializer;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.serializer;
        }

        public boolean equals(Object other) {
            return (other instanceof Argless) && Intrinsics.areEqual(((Argless) other).serializer, this.serializer);
        }

        public int hashCode() {
            return this.serializer.hashCode();
        }
    }

    /* compiled from: SerializersModule.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R1\u0010\b\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "Lkotlinx/serialization/modules/ContextualProvider;", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "invoke", "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Function1;", "provider", "Lkotlin/jvm/functions/Function1;", "getProvider", "()Lkotlin/jvm/functions/Function1;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WithTypeArguments extends ContextualProvider {
        private final Function1<List<? extends KSerializer<?>>, KSerializer<?>> provider;

        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> getProvider() {
            return this.provider;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.provider.invoke(typeArgumentsSerializers);
        }
    }
}
