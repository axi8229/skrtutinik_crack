package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.core.api.JsonParser;
import com.yandex.metrica.modules.api.RemoteConfigExtensionConfiguration;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.hd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0974hd implements JsonParser, Converter {
    private final /* synthetic */ JsonParser a;
    private final /* synthetic */ Converter b;

    public C0974hd(RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration) {
        this.a = remoteConfigExtensionConfiguration.getJsonParser();
        this.b = remoteConfigExtensionConfiguration.getProtobufConverter();
    }

    @Override // com.yandex.metrica.core.api.Parser
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object parse(JSONObject jSONObject) {
        return this.a.parse(jSONObject);
    }

    public Object a(byte[] bArr) {
        return this.b.toModel(bArr);
    }

    public byte[] a(Object obj) {
        return (byte[]) this.b.fromModel(obj);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        return (byte[]) this.b.fromModel(obj);
    }

    @Override // com.yandex.metrica.core.api.Parser
    public Object parseOrNull(Object obj) {
        return this.a.parseOrNull((JSONObject) obj);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        return this.b.toModel((byte[]) obj);
    }
}
