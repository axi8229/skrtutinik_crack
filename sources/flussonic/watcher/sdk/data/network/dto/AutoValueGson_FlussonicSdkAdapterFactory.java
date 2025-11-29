package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes3.dex */
final class AutoValueGson_FlussonicSdkAdapterFactory extends FlussonicSdkAdapterFactory {
    AutoValueGson_FlussonicSdkAdapterFactory() {
    }

    @Override // flussonic.watcher.sdk.data.network.dto.FlussonicSdkAdapterFactory, com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (CameraDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CameraDto.typeAdapter(gson);
        }
        if (EventDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) EventDto.typeAdapter(gson);
        }
        if (MediaInfoDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MediaInfoDto.typeAdapter(gson);
        }
        if (PermissionsDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PermissionsDto.typeAdapter(gson);
        }
        if (PlaybackConfigDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PlaybackConfigDto.typeAdapter(gson);
        }
        if (StreamAvailableRangeDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StreamAvailableRangeDto.typeAdapter(gson);
        }
        if (StreamRangeDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StreamRangeDto.typeAdapter(gson);
        }
        if (StreamRangesDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StreamRangesDto.typeAdapter(gson);
        }
        if (StreamStatusDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StreamStatusDto.typeAdapter(gson);
        }
        if (TrackDto.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TrackDto.typeAdapter(gson);
        }
        return null;
    }
}
