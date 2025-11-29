package spay.sdk.utils.permissions;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.C0;
import npi.spay.C1560e6;
import npi.spay.C1955u3;
import npi.spay.EnumC1577en;
import npi.spay.EnumC1877r0;
import npi.spay.N9;
import npi.spay.Pj;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lspay/sdk/utils/permissions/PermissionsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class PermissionsActivity extends AppCompatActivity {
    public C1955u3 a;

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = ((Pj) n9).d.b();
        }
        super.onCreate(bundle);
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 13);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C1955u3 c1955u3 = this.a;
        if (c1955u3 != null) {
            c1955u3.a(new C1560e6(EnumC1577en.SC_PERMISSIONS, EnumC1877r0.MERCHANT_VIEW, C0.SC, null, null, null, null, 120));
        }
        for (Map.Entry entry : MapsKt.toMap(ArraysKt.zip(grantResults, permissions)).entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            if (iIntValue == -1) {
                Intent intent = new Intent("action_permissions_denied");
                intent.setPackage(getApplicationContext().getPackageName());
                sendBroadcast(intent);
                arrayList2.add(entry.getValue());
            } else if (iIntValue == 0) {
                Intent intent2 = new Intent("action_permissions_granted");
                intent2.setPackage(getApplicationContext().getPackageName());
                sendBroadcast(intent2);
                arrayList.add(entry.getValue());
            }
        }
        if (this.a != null) {
            C1955u3 c1955u32 = null;
            if (!arrayList.isEmpty()) {
                C1955u3 c1955u33 = this.a;
                if (c1955u33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("metricFacade");
                    c1955u33 = null;
                }
                c1955u33.a(new C1560e6(EnumC1577en.SC_GOOD_PERMISSIONS, EnumC1877r0.MERCHANT_VIEW, C0.SC, MapsKt.mapOf(TuplesKt.to("Granted", arrayList.toString())), null, null, null, 112));
            }
            if (!arrayList2.isEmpty()) {
                C1955u3 c1955u34 = this.a;
                if (c1955u34 != null) {
                    c1955u32 = c1955u34;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("metricFacade");
                }
                c1955u32.a(new C1560e6(EnumC1577en.SC_FAIL_PERMISSIONS, EnumC1877r0.MERCHANT_VIEW, C0.SC, MapsKt.mapOf(TuplesKt.to("Denied", arrayList2.toString())), null, null, null, 112));
            }
        }
        finish();
    }
}
