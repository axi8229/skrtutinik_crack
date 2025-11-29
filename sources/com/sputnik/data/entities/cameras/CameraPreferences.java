package com.sputnik.data.entities.cameras;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraPreferences.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/sputnik/data/entities/cameras/CameraPreferences;", "", "", "uuid", "", "scale", "posX", "posY", "<init>", "(Ljava/lang/String;FFF)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "F", "getScale", "()F", "getPosX", "getPosY", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CameraPreferences {
    private final float posX;
    private final float posY;
    private final float scale;
    private final String uuid;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraPreferences)) {
            return false;
        }
        CameraPreferences cameraPreferences = (CameraPreferences) other;
        return Intrinsics.areEqual(this.uuid, cameraPreferences.uuid) && Float.compare(this.scale, cameraPreferences.scale) == 0 && Float.compare(this.posX, cameraPreferences.posX) == 0 && Float.compare(this.posY, cameraPreferences.posY) == 0;
    }

    public int hashCode() {
        return (((((this.uuid.hashCode() * 31) + Float.hashCode(this.scale)) * 31) + Float.hashCode(this.posX)) * 31) + Float.hashCode(this.posY);
    }

    public String toString() {
        return "CameraPreferences(uuid=" + this.uuid + ", scale=" + this.scale + ", posX=" + this.posX + ", posY=" + this.posY + ")";
    }

    public CameraPreferences(String uuid, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.scale = f;
        this.posX = f2;
        this.posY = f3;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final float getScale() {
        return this.scale;
    }
}
