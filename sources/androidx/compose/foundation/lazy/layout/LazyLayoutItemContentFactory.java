package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutItemContentFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0017R\u00020\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "saveableStateHolder", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemProvider", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function0;)V", "key", "getContentType", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "index", "contentType", "", "getContent", "(ILjava/lang/Object;Ljava/lang/Object;)Lkotlin/jvm/functions/Function2;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Lkotlin/jvm/functions/Function0;", "getItemProvider", "()Lkotlin/jvm/functions/Function0;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "lambdasCache", "Ljava/util/Map;", "CachedItemContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutItemContentFactory {
    private final Function0<LazyLayoutItemProvider> itemProvider;
    private final Map<Object, CachedItemContent> lambdasCache = new LinkedHashMap();
    private final SaveableStateHolder saveableStateHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, Function0<? extends LazyLayoutItemProvider> function0) {
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = function0;
    }

    public final Function0<LazyLayoutItemProvider> getItemProvider() {
        return this.itemProvider;
    }

    public final Object getContentType(Object key) {
        if (key == null) {
            return null;
        }
        CachedItemContent cachedItemContent = this.lambdasCache.get(key);
        if (cachedItemContent != null) {
            return cachedItemContent.getContentType();
        }
        LazyLayoutItemProvider lazyLayoutItemProviderInvoke = this.itemProvider.invoke();
        int index = lazyLayoutItemProviderInvoke.getIndex(key);
        if (index != -1) {
            return lazyLayoutItemProviderInvoke.getContentType(index);
        }
        return null;
    }

    public final Function2<Composer, Integer, Unit> getContent(int index, Object key, Object contentType) {
        CachedItemContent cachedItemContent = this.lambdasCache.get(key);
        if (cachedItemContent != null && cachedItemContent.getIndex() == index && Intrinsics.areEqual(cachedItemContent.getContentType(), contentType)) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(index, key, contentType);
        this.lambdasCache.put(key, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemContentFactory.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000f\u0010\u000eR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "", "", "index", "key", "contentType", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function0;", "", "createContentLambda", "()Lkotlin/jvm/functions/Function2;", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getContentType", "<set-?>", "I", "getIndex", "()I", "_content", "Lkotlin/jvm/functions/Function2;", "getContent", "content", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class CachedItemContent {
        private Function2<? super Composer, ? super Integer, Unit> _content;
        private final Object contentType;
        private int index;
        private final Object key;

        public CachedItemContent(int i, Object obj, Object obj2) {
            this.key = obj;
            this.contentType = obj2;
            this.index = i;
        }

        public final Object getKey() {
            return this.key;
        }

        public final Object getContentType() {
            return this.contentType;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            Function2 function2 = this._content;
            if (function2 != null) {
                return function2;
            }
            Function2<Composer, Integer, Unit> function2CreateContentLambda = createContentLambda();
            this._content = function2CreateContentLambda;
            return function2CreateContentLambda;
        }

        private final Function2<Composer, Integer, Unit> createContentLambda() {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = LazyLayoutItemContentFactory.this;
            return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:92)");
                        }
                        LazyLayoutItemProvider lazyLayoutItemProviderInvoke = lazyLayoutItemContentFactory.getItemProvider().invoke();
                        int index = this.getIndex();
                        if ((index >= lazyLayoutItemProviderInvoke.getItemCount() || !Intrinsics.areEqual(lazyLayoutItemProviderInvoke.getKey(index), this.getKey())) && (index = lazyLayoutItemProviderInvoke.getIndex(this.getKey())) != -1) {
                            this.index = index;
                        }
                        int i2 = index;
                        boolean z = i2 != -1;
                        LazyLayoutItemContentFactory lazyLayoutItemContentFactory2 = lazyLayoutItemContentFactory;
                        LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this;
                        composer.startReusableGroup(207, Boolean.valueOf(z));
                        boolean zChanged = composer.changed(z);
                        composer.startReplaceGroup(-869707859);
                        if (z) {
                            composer.startReplaceGroup(-2120139493);
                            LazyLayoutItemContentFactoryKt.m382SkippableItemJVlU9Rs(lazyLayoutItemProviderInvoke, StableValue.m395constructorimpl(lazyLayoutItemContentFactory2.saveableStateHolder), i2, StableValue.m395constructorimpl(cachedItemContent.getKey()), composer, 0);
                            composer.endReplaceGroup();
                        } else {
                            composer.deactivateToEndGroup(zChanged);
                        }
                        composer.endReplaceGroup();
                        composer.endReusableGroup();
                        Object key = this.getKey();
                        boolean zChangedInstance = composer.changedInstance(this);
                        final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = this;
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent3 = cachedItemContent2;
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            cachedItemContent3._content = null;
                                        }
                                    };
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        EffectsKt.DisposableEffect(key, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
        }
    }
}
