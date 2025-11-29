package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SaveableStateHolder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB1\u0012(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00060\u00040\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a$\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00060\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R4\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00060\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0015R\u00020\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "", "", "", "", "", "savedStates", "<init>", "(Ljava/util/Map;)V", "saveAll", "()Ljava/util/Map;", "key", "Lkotlin/Function0;", "", "content", "SaveableStateProvider", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "(Ljava/lang/Object;)V", "Ljava/util/Map;", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "registryHolders", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "parentSaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getParentSaveableStateRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "setParentSaveableStateRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "Companion", "RegistryHolder", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SaveableStateHolderImpl implements SaveableStateHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<SaveableStateHolderImpl, ?> Saver = SaverKt.Saver(new Function2<SaverScope, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Map<Object, Map<String, List<Object>>> invoke(SaverScope saverScope, SaveableStateHolderImpl saveableStateHolderImpl) {
            return saveableStateHolderImpl.saveAll();
        }
    }, new Function1<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SaveableStateHolderImpl invoke(Map<Object, Map<String, ? extends List<? extends Object>>> map) {
            return invoke2((Map<Object, Map<String, List<Object>>>) map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SaveableStateHolderImpl invoke2(Map<Object, Map<String, List<Object>>> map) {
            return new SaveableStateHolderImpl(map);
        }
    });
    private SaveableStateRegistry parentSaveableStateRegistry;
    private final Map<Object, RegistryHolder> registryHolders;
    private final Map<Object, Map<String, List<Object>>> savedStates;

    public SaveableStateHolderImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SaveableStateHolderImpl(Map<Object, Map<String, List<Object>>> map) {
        this.savedStates = map;
        this.registryHolders = new LinkedHashMap();
    }

    public /* synthetic */ SaveableStateHolderImpl(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final SaveableStateRegistry getParentSaveableStateRegistry() {
        return this.parentSaveableStateRegistry;
    }

    public final void setParentSaveableStateRegistry(SaveableStateRegistry saveableStateRegistry) {
        this.parentSaveableStateRegistry = saveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void SaveableStateProvider(final Object obj, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1198538093);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1198538093, i2, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:75)");
            }
            composerStartRestartGroup.startReusableGroup(207, obj);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                SaveableStateRegistry saveableStateRegistry = this.parentSaveableStateRegistry;
                if (!(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(obj) : true)) {
                    throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
                }
                objRememberedValue = new RegistryHolder(obj);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final RegistryHolder registryHolder = (RegistryHolder) objRememberedValue;
            CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(registryHolder.getRegistry()), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            Unit unit = Unit.INSTANCE;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changedInstance(obj) | composerStartRestartGroup.changedInstance(registryHolder);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        boolean zContainsKey = this.this$0.registryHolders.containsKey(obj);
                        Object obj2 = obj;
                        if (!zContainsKey) {
                            this.this$0.savedStates.remove(obj);
                            this.this$0.registryHolders.put(obj, registryHolder);
                            final SaveableStateHolderImpl.RegistryHolder registryHolder2 = registryHolder;
                            final SaveableStateHolderImpl saveableStateHolderImpl = this.this$0;
                            final Object obj3 = obj;
                            return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    registryHolder2.saveTo(saveableStateHolderImpl.savedStates);
                                    saveableStateHolderImpl.registryHolders.remove(obj3);
                                }
                            };
                        }
                        throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 6);
            composerStartRestartGroup.endReusableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    SaveableStateHolderImpl.this.SaveableStateProvider(obj, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Map<String, List<Object>>> saveAll() {
        Map<Object, Map<String, List<Object>>> mutableMap = MapsKt.toMutableMap(this.savedStates);
        Iterator<T> it = this.registryHolders.values().iterator();
        while (it.hasNext()) {
            ((RegistryHolder) it.next()).saveTo(mutableMap);
        }
        if (mutableMap.isEmpty()) {
            return null;
        }
        return mutableMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public void removeState(Object key) {
        RegistryHolder registryHolder = this.registryHolders.get(key);
        if (registryHolder != null) {
            registryHolder.setShouldSave(false);
        } else {
            this.savedStates.remove(key);
        }
    }

    /* compiled from: SaveableStateHolder.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u000b\u001a\u00020\n2&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u00060\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "", "key", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;Ljava/lang/Object;)V", "", "", "", "", "map", "", "saveTo", "(Ljava/util/Map;)V", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "", "shouldSave", "Z", "getShouldSave", "()Z", "setShouldSave", "(Z)V", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class RegistryHolder {
        private final Object key;
        private final SaveableStateRegistry registry;
        private boolean shouldSave = true;

        public RegistryHolder(Object obj) {
            this.key = obj;
            this.registry = SaveableStateRegistryKt.SaveableStateRegistry((Map) SaveableStateHolderImpl.this.savedStates.get(obj), new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$RegistryHolder$registry$1
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj2) {
                    SaveableStateRegistry parentSaveableStateRegistry = saveableStateHolderImpl.getParentSaveableStateRegistry();
                    return Boolean.valueOf(parentSaveableStateRegistry != null ? parentSaveableStateRegistry.canBeSaved(obj2) : true);
                }
            });
        }

        public final void setShouldSave(boolean z) {
            this.shouldSave = z;
        }

        public final SaveableStateRegistry getRegistry() {
            return this.registry;
        }

        public final void saveTo(Map<Object, Map<String, List<Object>>> map) {
            if (this.shouldSave) {
                Map<String, List<Object>> mapPerformSave = this.registry.performSave();
                if (mapPerformSave.isEmpty()) {
                    map.remove(this.key);
                } else {
                    map.put(this.key, mapPerformSave);
                }
            }
        }
    }

    /* compiled from: SaveableStateHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SaveableStateHolderImpl, ?> getSaver() {
            return SaveableStateHolderImpl.Saver;
        }
    }
}
