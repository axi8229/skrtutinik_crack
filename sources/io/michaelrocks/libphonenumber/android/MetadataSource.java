package io.michaelrocks.libphonenumber.android;

/* loaded from: classes3.dex */
interface MetadataSource {
    Phonemetadata$PhoneMetadata getMetadataForNonGeographicalRegion(int countryCallingCode);

    Phonemetadata$PhoneMetadata getMetadataForRegion(String regionCode);
}
