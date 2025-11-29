package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.adapter;

import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.entities.camera.Camera;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: BottomSheetCamerasAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/adapter/BottomSheetCamerasAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/camera/Camera;", "onItemClicked", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetCamerasAdapter extends BaseAdapter<Camera> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetCamerasAdapter(Function1<? super Camera, Unit> onItemClicked) {
        super(R.layout.recycler_view_camera_item, onItemClicked, 1, new CamerasInfoDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
    }
}
