package com.sputnik.data.mappers.cameras;

import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCameraToDomainCameraMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/cameras/DataCameraToDomainCameraMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/cameras/DataCamera;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCameraToDomainCameraMapper implements Mapper<DataCamera, DomainCamera> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainCamera map(DataCamera input) {
        DomainCamera.DomainExtraKeyReader domainExtraKeyReader;
        Intrinsics.checkNotNullParameter(input, "input");
        String uuid = input.getUuid();
        String streamUrl = input.getStreamUrl();
        String previewMp4 = input.getPreviewMp4();
        if (previewMp4 == null) {
            previewMp4 = input.getPreviewUrl();
        }
        String str = previewMp4;
        boolean intercom = input.getIntercom();
        String intercomUuid = input.getIntercomUuid();
        String intercomSerial = input.getIntercomSerial();
        int width = input.getWidth();
        int height = input.getHeight();
        String title = input.getTitle();
        Integer order = input.getOrder();
        boolean widget = input.getWidget();
        if (input.getExtraKeyReader() == null) {
            domainExtraKeyReader = null;
        } else {
            DataCamera.DataExtraKeyReader extraKeyReader = input.getExtraKeyReader();
            String kind = extraKeyReader != null ? extraKeyReader.getKind() : null;
            DataCamera.DataExtraKeyReader extraKeyReader2 = input.getExtraKeyReader();
            domainExtraKeyReader = new DomainCamera.DomainExtraKeyReader(kind, extraKeyReader2 != null ? extraKeyReader2.getAlias() : null);
        }
        return new DomainCamera(uuid, streamUrl, str, intercom, intercomUuid, intercomSerial, width, height, title, order, widget, null, false, false, null, domainExtraKeyReader, input.getSubscriptionRequried(), input.getMainScreen(), input.getCanOpen(), 30720, null);
    }
}
