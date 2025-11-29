package org.bouncycastle.pqc.jcajce.provider;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* loaded from: classes4.dex */
public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    public static String PROVIDER_NAME = "BCPQC";
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.70";
    private static final Map keyInfoConverters = new HashMap();
    private static final String[] ALGORITHMS = {"Rainbow", "McEliece", "SPHINCS", "LMS", "NH", "XMSS", "QTESLA"};

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.7d, info);
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                BouncyCastlePQCProvider.this.setup();
                return null;
            }
        });
    }

    private void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class clsLoadClass = loadClass(BouncyCastlePQCProvider.class, str + strArr[i] + "$Mappings");
            if (clsLoadClass != null) {
                try {
                    ((AlgorithmProvider) clsLoadClass.newInstance()).configure(this);
                } catch (Exception e) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e);
                }
            }
        }
    }

    static Class loadClass(Class cls, final String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider.2
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName(str);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        loadAlgorithms("org.bouncycastle.pqc.jcajce.provider.", ALGORITHMS);
    }
}
