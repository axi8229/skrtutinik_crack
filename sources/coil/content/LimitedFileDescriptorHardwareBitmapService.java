package coil.content;

import coil.size.Dimension;
import coil.size.Size;
import kotlin.Metadata;

/* compiled from: HardwareBitmaps.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcoil/util/LimitedFileDescriptorHardwareBitmapService;", "Lcoil/util/HardwareBitmapService;", "Lcoil/util/Logger;", "logger", "<init>", "(Lcoil/util/Logger;)V", "Lcoil/size/Size;", "size", "", "allowHardwareMainThread", "(Lcoil/size/Size;)Z", "allowHardwareWorkerThread", "()Z", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {
    public LimitedFileDescriptorHardwareBitmapService(Logger logger) {
    }

    @Override // coil.content.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        Dimension width = size.getWidth();
        if ((width instanceof Dimension.Pixels ? ((Dimension.Pixels) width).px : Integer.MAX_VALUE) > 100) {
            Dimension height = size.getHeight();
            if ((height instanceof Dimension.Pixels ? ((Dimension.Pixels) height).px : Integer.MAX_VALUE) > 100) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.content.HardwareBitmapService
    /* renamed from: allowHardwareWorkerThread */
    public boolean getAllowHardware() {
        return FileDescriptorCounter.INSTANCE.hasAvailableFileDescriptors(null);
    }
}
