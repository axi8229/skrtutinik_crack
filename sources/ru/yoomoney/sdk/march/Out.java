package ru.yoomoney.sdk.march;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.Effect;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u000e\u000fB!\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\u0002\u0010\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/march/Out;", "STATE", "INPUT", "", "state", "sources", "", "Lru/yoomoney/sdk/march/Effect;", "(Ljava/lang/Object;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Builder", "Companion", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Out<STATE, INPUT> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Effect<INPUT>> sources;
    private final STATE state;

    /* JADX WARN: Multi-variable type inference failed */
    public Out(STATE state, List<? extends Effect<? extends INPUT>> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        this.state = state;
        this.sources = sources;
    }

    public final STATE getState() {
        return this.state;
    }

    public final List<Effect<INPUT>> getSources() {
        return this.sources;
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJK\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/march/Out$Companion;", "", "<init>", "()V", "STATE", "INPUT", "state", "Lkotlin/Function1;", "Lru/yoomoney/sdk/march/Out$Builder;", "", "builder", "Lru/yoomoney/sdk/march/Out;", "invoke", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/coroutines/Continuation;", "source", "skip", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <STATE, INPUT> Out<STATE, INPUT> invoke(STATE state, Function1<? super Builder<? extends STATE, INPUT>, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Builder builder2 = new Builder(state, null, 2, 0 == true ? 1 : 0);
            builder.invoke(builder2);
            return builder2.build();
        }

        public final <STATE, INPUT> Out<STATE, INPUT> skip(STATE state, Function1<? super Continuation<? super INPUT>, ? extends Object> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Out<>(state, CollectionsKt.listOf(new Effect.Input.Fun(source)));
        }
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/march/Out$Builder;", "STATE", "INPUT", "", "state", "sources", "", "Lru/yoomoney/sdk/march/Effect;", "(Ljava/lang/Object;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getState", "()Ljava/lang/Object;", "Ljava/lang/Object;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/march/Out;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder<STATE, INPUT> {
        private final List<Effect<INPUT>> sources;
        private final STATE state;

        public Builder(STATE state, List<Effect<INPUT>> sources) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            this.state = state;
            this.sources = sources;
        }

        public final STATE getState() {
            return this.state;
        }

        public /* synthetic */ Builder(Object obj, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? new ArrayList() : list);
        }

        public final List<Effect<INPUT>> getSources() {
            return this.sources;
        }

        public final Out<STATE, INPUT> build() {
            return new Out<>(this.state, this.sources);
        }
    }
}
