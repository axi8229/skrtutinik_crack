package com.axmor.ash.toolset.data.result;

import com.axmor.ash.toolset.data.result.error.AshError;

/* loaded from: classes.dex */
public final class AshResult<Data> {
    private final Data data;
    private final AshError error;
    private final boolean success;

    public Data getData() {
        return this.data;
    }

    public AshError getError() {
        return this.error;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public AshResult(Data data) {
        this.success = true;
        this.data = data;
        this.error = null;
    }

    public AshResult(AshError ashError) {
        this.success = false;
        this.data = null;
        this.error = ashError;
    }
}
