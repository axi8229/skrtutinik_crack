package dagger.internal;

import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    private MapFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    @Override // javax.inject.Provider
    public Map<K, V> get() {
        LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        private Builder(int i) {
            super(i);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k, Provider<V> provider) {
            super.put((Builder<K, V>) k, (Provider) provider);
            return this;
        }

        @Deprecated
        public Builder<K, V> put(K k, javax.inject.Provider<V> provider) {
            return put((Builder<K, V>) k, (Provider) Providers.asDaggerProvider(provider));
        }

        public MapFactory<K, V> build() {
            return new MapFactory<>(this.map);
        }
    }
}
