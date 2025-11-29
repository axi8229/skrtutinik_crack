package org.bouncycastle.jce.provider;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;

/* loaded from: classes4.dex */
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    private static String info = "BouncyCastle Security Provider v1.70";
    public static final ProviderConfiguration CONFIGURATION = new BouncyCastleProviderConfiguration();
    private static final Map keyInfoConverters = new HashMap();
    private static final Class revChkClass = ClassUtil.loadClass(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");
    private static final String[] SYMMETRIC_GENERIC = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
    private static final String[] SYMMETRIC_MACS = {"SipHash", "SipHash128", "Poly1305"};
    private static final String[] SYMMETRIC_CIPHERS = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};
    private static final String[] ASYMMETRIC_GENERIC = {"X509", "IES", "COMPOSITE"};
    private static final String[] ASYMMETRIC_CIPHERS = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};
    private static final String[] DIGESTS = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};
    private static final String[] KEYSTORES = {"BC", "BCFKS", "PKCS12"};
    private static final String[] SECURE_RANDOMS = {"DRBG"};

    public BouncyCastleProvider() {
        super("BC", 1.7d, info);
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.jce.provider.BouncyCastleProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                BouncyCastleProvider.this.setup();
                return null;
            }
        });
    }

    private void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class clsLoadClass = ClassUtil.loadClass(BouncyCastleProvider.class, str + strArr[i] + "$Mappings");
            if (clsLoadClass != null) {
                try {
                    ((AlgorithmProvider) clsLoadClass.newInstance()).configure(this);
                } catch (Exception e) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e);
                }
            }
        }
    }

    private void loadPQCKeys() {
        addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new Sphincs256KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.newHope, new NHKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcEliece, new McElieceKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcElieceCca2, new McElieceCCA2KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.rainbow, new RainbowKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_I, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_III, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSKeyFactorySpi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        String str;
        String str2;
        loadAlgorithms("org.bouncycastle.jcajce.provider.digest.", DIGESTS);
        loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_GENERIC);
        loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_MACS);
        loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_CIPHERS);
        loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_GENERIC);
        loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_CIPHERS);
        loadAlgorithms("org.bouncycastle.jcajce.provider.keystore.", KEYSTORES);
        loadAlgorithms("org.bouncycastle.jcajce.provider.drbg.", SECURE_RANDOMS);
        loadPQCKeys();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class cls = revChkClass;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (cls != null) {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
        } else {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        }
        put("CertPathBuilder.RFC3280", str2);
        put("CertPathValidator.PKIX", str);
        put("CertPathBuilder.PKIX", str2);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map = keyInfoConverters;
        synchronized (map) {
            map.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }
}
