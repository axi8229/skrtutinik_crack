package com.sputnik.common.mappers.cameras;

import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import com.sputnik.domain.entities.cameras.DomainCamera;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;

/* compiled from: DomainCameraToCameraMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "Lcom/sputnik/common/entities/camera/Camera;", "mapper", "Lcom/sputnik/common/mappers/archive/DomainFlussonicToFlussonicMapper;", "(Lcom/sputnik/common/mappers/archive/DomainFlussonicToFlussonicMapper;)V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainCameraToCameraMapper implements Mapper<DomainCamera, Camera> {
    private final DomainFlussonicToFlussonicMapper mapper;

    public DomainCameraToCameraMapper(DomainFlussonicToFlussonicMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Camera map(DomainCamera input) {
        Camera.ExtraKeyReader extraKeyReader;
        Intrinsics.checkNotNullParameter(input, "input");
        String uuid = input.getUuid();
        String streamUrl = input.getStreamUrl();
        String previewUrl = input.getPreviewUrl();
        boolean isIntercom = input.getIsIntercom();
        String intercomUuid = input.getIntercomUuid();
        String intercomSerial = input.getIntercomSerial();
        int width = input.getWidth();
        int height = input.getHeight();
        String title = input.getTitle();
        if (title == null) {
            title = "Door";
        }
        String str = title;
        Integer order = input.getOrder();
        boolean widget = input.getWidget();
        String address = input.getAddress();
        boolean isLoadPhotoFailed = input.getIsLoadPhotoFailed();
        boolean isLoadVideoFailed = input.getIsLoadVideoFailed();
        String str2 = input.getPreviewUrl() + RandomKt.Random(System.currentTimeMillis()).nextLong();
        DomainFlussonic flussonicData = input.getFlussonicData();
        Flussonic map = flussonicData != null ? this.mapper.map(flussonicData) : null;
        if (input.getExtraKeyReader() == null) {
            extraKeyReader = null;
        } else {
            DomainCamera.DomainExtraKeyReader extraKeyReader2 = input.getExtraKeyReader();
            String kind = extraKeyReader2 != null ? extraKeyReader2.getKind() : null;
            DomainCamera.DomainExtraKeyReader extraKeyReader3 = input.getExtraKeyReader();
            extraKeyReader = new Camera.ExtraKeyReader(kind, extraKeyReader3 != null ? extraKeyReader3.getAlias() : null);
        }
        Boolean subscriptionRequried = input.getSubscriptionRequried();
        Boolean mainScreen = input.getMainScreen();
        return new Camera(uuid, streamUrl, previewUrl, isIntercom, intercomUuid, intercomSerial, width, height, str, order, widget, address, isLoadPhotoFailed, isLoadVideoFailed, str2, map, extraKeyReader, mainScreen != null ? mainScreen.booleanValue() : false, subscriptionRequried, input.getCanOpen(), false, false, 3145728, null);
    }
}
