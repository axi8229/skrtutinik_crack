package io.michaelrocks.libphonenumber.android;

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
    private static final Logger logger = Logger.getLogger(MetadataManager.class.getName());
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> alternateFormatsMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Phonemetadata$PhoneMetadata> shortNumberMetadataMap = new ConcurrentHashMap<>();
    private final Set<Integer> alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private final Set<String> shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();

    MetadataManager(MetadataLoader metadataLoader) {
        this.metadataLoader = metadataLoader;
    }

    <T> Phonemetadata$PhoneMetadata getMetadataFromMultiFilePrefix(T key, ConcurrentHashMap<T, Phonemetadata$PhoneMetadata> map, String filePrefix) {
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = map.get(key);
        if (phonemetadata$PhoneMetadata != null) {
            return phonemetadata$PhoneMetadata;
        }
        String str = filePrefix + "_" + key;
        List<Phonemetadata$PhoneMetadata> metadataFromSingleFileName = getMetadataFromSingleFileName(str, this.metadataLoader);
        if (metadataFromSingleFileName.size() > 1) {
            logger.log(Level.WARNING, "more than one metadata in file " + str);
        }
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata2 = metadataFromSingleFileName.get(0);
        Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadataPutIfAbsent = map.putIfAbsent(key, phonemetadata$PhoneMetadata2);
        return phonemetadata$PhoneMetadataPutIfAbsent != null ? phonemetadata$PhoneMetadataPutIfAbsent : phonemetadata$PhoneMetadata2;
    }

    private static List<Phonemetadata$PhoneMetadata> getMetadataFromSingleFileName(String fileName, MetadataLoader metadataLoader) {
        InputStream inputStreamLoadMetadata = metadataLoader.loadMetadata(fileName);
        if (inputStreamLoadMetadata == null) {
            throw new IllegalStateException("missing metadata: " + fileName);
        }
        List<Phonemetadata$PhoneMetadata> metadataList = loadMetadataAndCloseInput(inputStreamLoadMetadata).getMetadataList();
        if (metadataList.size() != 0) {
            return metadataList;
        }
        throw new IllegalStateException("empty metadata: " + fileName);
    }

    private static Phonemetadata$PhoneMetadataCollection loadMetadataAndCloseInput(InputStream source) throws Throwable {
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(source);
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
                            source.close();
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
