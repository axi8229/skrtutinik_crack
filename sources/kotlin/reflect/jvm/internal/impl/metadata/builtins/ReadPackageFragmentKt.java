package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* compiled from: readPackageFragment.kt */
/* loaded from: classes4.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream inputStream) {
        ProtoBuf$PackageFragment from;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            BuiltInsBinaryVersion from2 = BuiltInsBinaryVersion.Companion.readFrom(inputStream);
            if (from2.isCompatibleWithCurrentCompilerVersion()) {
                ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
                BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
                from = ProtoBuf$PackageFragment.parseFrom(inputStream, extensionRegistryLiteNewInstance);
            } else {
                from = null;
            }
            Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> pair = TuplesKt.to(from, from2);
            CloseableKt.closeFinally(inputStream, null);
            return pair;
        } finally {
        }
    }
}
