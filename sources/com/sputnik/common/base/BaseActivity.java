package com.sputnik.common.base;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;

/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Lcom/sputnik/common/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/sputnik/common/base/IBaseMethods;", "()V", "contentLayoutId", "", "(I)V", "onStart", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity implements IBaseMethods {
    public BaseActivity() {
    }

    public BaseActivity(int i) {
        super(i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        initViews();
        localize();
    }
}
