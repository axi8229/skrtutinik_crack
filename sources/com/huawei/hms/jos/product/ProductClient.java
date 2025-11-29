package com.huawei.hms.jos.product;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApiInterface;
import java.util.List;

/* loaded from: classes3.dex */
public interface ProductClient extends HuaweiApiInterface {
    Task<List<ProductOrderInfo>> getMissProductOrder(Context context);
}
