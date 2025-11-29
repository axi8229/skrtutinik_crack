package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes3.dex */
public abstract class FlussonicSdkAdapterFactory implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public abstract /* synthetic */ TypeAdapter create(Gson gson, TypeToken typeToken);

    public static TypeAdapterFactory create() {
        return new AutoValueGson_FlussonicSdkAdapterFactory();
    }
}
