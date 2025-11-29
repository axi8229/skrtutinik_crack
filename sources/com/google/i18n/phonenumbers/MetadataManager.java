package com.google.i18n.phonenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class MetadataManager {
    static final MetadataLoader DEFAULT_METADATA_LOADER = new MetadataLoader() { // from class: com.google.i18n.phonenumbers.MetadataManager.1
        @Override // com.google.i18n.phonenumbers.MetadataLoader
        public InputStream loadMetadata(String str) {
            return MetadataManager.class.getResourceAsStream(str);
        }
    };
    private static final Logger logger = Logger.getLogger(MetadataManager.class.getName());
    private static final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> alternateFormatsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Phonemetadata$PhoneMetadata> shortNumberMetadataMap = new ConcurrentHashMap<>();
    private static final Set<Integer> alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private static final Set<String> shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();

    private MetadataManager() {
    }

    static <T> Phonemetadata$PhoneMetadata getMetadataFromMultiFilePrefix(T t, ConcurrentHashMap<T, Phonemetadata$PhoneMetadata> concurrentHashMap, String str, MetadataLoader metadataLoader) {
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = concurrentHashMap.get(t);
        if (phonemetadata$PhoneMetadata != null) {
            return phonemetadata$PhoneMetadata;
        }
        String strValueOf = String.valueOf(t);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + strValueOf.length());
        sb.append(str);
        sb.append("_");
        sb.append(strValueOf);
        String string = sb.toString();
        List<Phonemetadata$PhoneMetadata> metadataFromSingleFileName = getMetadataFromSingleFileName(string, metadataLoader);
        if (metadataFromSingleFileName.size() > 1) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf2 = String.valueOf(string);
            logger2.log(level, strValueOf2.length() != 0 ? "more than one metadata in file ".concat(strValueOf2) : new String("more than one metadata in file "));
        }
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata2 = metadataFromSingleFileName.get(0);
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadataPutIfAbsent = concurrentHashMap.putIfAbsent(t, phonemetadata$PhoneMetadata2);
        return phonemetadata$PhoneMetadataPutIfAbsent != null ? phonemetadata$PhoneMetadataPutIfAbsent : phonemetadata$PhoneMetadata2;
    }

    private static List<Phonemetadata$PhoneMetadata> getMetadataFromSingleFileName(String str, MetadataLoader metadataLoader) {
        InputStream inputStreamLoadMetadata = metadataLoader.loadMetadata(str);
        if (inputStreamLoadMetadata == null) {
            String strValueOf = String.valueOf(str);
            throw new IllegalStateException(strValueOf.length() != 0 ? "missing metadata: ".concat(strValueOf) : new String("missing metadata: "));
        }
        List<Phonemetadata$PhoneMetadata> metadataList = loadMetadataAndCloseInput(inputStreamLoadMetadata).getMetadataList();
        if (metadataList.size() != 0) {
            return metadataList;
        }
        String strValueOf2 = String.valueOf(str);
        throw new IllegalStateException(strValueOf2.length() != 0 ? "empty metadata: ".concat(strValueOf2) : new String("empty metadata: "));
    }

    private static Phonemetadata$PhoneMetadataCollection loadMetadataAndCloseInput(InputStream inputStream) throws Throwable {
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStream);
                try {
                    Phonemetadata$PhoneMetadataCollection phonemetadata$PhoneMetadataCollection = new Phonemetadata$PhoneMetadataCollection();
                    try {
                        phonemetadata$PhoneMetadataCollection.readExternal(objectInputStream2);
                        try {
                            objectInputStream2.close();
                        } catch (IOException e) {
                            logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e);
                        }
                        return phonemetadata$PhoneMetadataCollection;
                    } catch (IOException e2) {
                        throw new RuntimeException("cannot load/parse metadata", e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    try {
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        } else {
                            inputStream.close();
                        }
                    } catch (IOException e3) {
                        logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e3);
                    }
                    throw th;
                }
            } catch (IOException e4) {
                throw new RuntimeException("cannot load/parse metadata", e4);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
