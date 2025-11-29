package ru.tinkoff.decoro.watchers;

import ru.tinkoff.decoro.Mask;
import ru.tinkoff.decoro.MaskImpl;

/* loaded from: classes4.dex */
public class MaskFormatWatcher extends FormatWatcher {
    private MaskImpl maskOriginal;

    public MaskFormatWatcher(MaskImpl maskImpl) {
        setMask(maskImpl);
    }

    @Override // ru.tinkoff.decoro.MaskFactory
    public Mask createMask() {
        return new MaskImpl(this.maskOriginal);
    }

    public void setMask(MaskImpl maskImpl) {
        this.maskOriginal = maskImpl;
        refreshMask();
    }
}
