package androidx.camera.core.impl.utils;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes.dex */
public final class Exif {
    private static final String TAG = "Exif";
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };
    private static final List<String> ALL_EXIF_TAGS = getAllExifTags();
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = Arrays.asList("ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation");

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    public static Exif createFromFile(File file) throws IOException {
        return createFromFileString(file.toString());
    }

    public static Exif createFromImageProxy(ImageProxy imageProxy) throws IOException {
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        buffer.rewind();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.get(bArr);
        return createFromInputStream(new ByteArrayInputStream(bArr));
    }

    public static Exif createFromFileString(String str) throws IOException {
        return new Exif(new ExifInterface(str));
    }

    public static Exif createFromInputStream(InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    private static Date convertFromExifDateTime(String str) throws ParseException {
        return DATETIME_FORMAT.get().parse(str);
    }

    private static Date convertFromExifDate(String str) throws ParseException {
        return DATE_FORMAT.get().parse(str);
    }

    private static Date convertFromExifTime(String str) throws ParseException {
        return TIME_FORMAT.get().parse(str);
    }

    public void copyToCroppedImage(Exif exif) throws NumberFormatException {
        ArrayList<String> arrayList = new ArrayList(ALL_EXIF_TAGS);
        arrayList.removeAll(DO_NOT_COPY_EXIF_TAGS);
        for (String str : arrayList) {
            String attribute = this.mExifInterface.getAttribute(str);
            String attribute2 = exif.mExifInterface.getAttribute(str);
            if (attribute != null && !attribute.equals(attribute2)) {
                exif.mExifInterface.setAttribute(str, attribute);
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription());
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt("Orientation", 0);
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt("ImageWidth", 0);
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt("ImageLength", 0);
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute("ImageDescription");
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 3:
            case 4:
                return pjsip_status_code.PJSIP_SC_RINGING;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public boolean isFlippedVertically() {
        int orientation = getOrientation();
        return orientation == 4 || orientation == 5 || orientation == 7;
    }

    public boolean isFlippedHorizontally() {
        return getOrientation() == 2;
    }

    public long getTimestamp() throws NumberFormatException {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute("DateTimeOriginal"));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute("SubSecTimeOriginal");
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j = Long.parseLong(attribute);
            while (j > 1000) {
                j /= 10;
            }
            return timestamp + j;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.location.Location getLocation() {
        /*
            r16 = this;
            r0 = r16
            androidx.exifinterface.media.ExifInterface r1 = r0.mExifInterface
            java.lang.String r2 = "GPSProcessingMethod"
            java.lang.String r1 = r1.getAttribute(r2)
            androidx.exifinterface.media.ExifInterface r2 = r0.mExifInterface
            double[] r2 = r2.getLatLong()
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            r4 = 0
            double r6 = r3.getAltitude(r4)
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            java.lang.String r8 = "GPSSpeed"
            double r8 = r3.getAttributeDouble(r8, r4)
            androidx.exifinterface.media.ExifInterface r3 = r0.mExifInterface
            java.lang.String r10 = "GPSSpeedRef"
            java.lang.String r3 = r3.getAttribute(r10)
            java.lang.String r10 = "K"
            if (r3 != 0) goto L2d
            r3 = r10
        L2d:
            androidx.exifinterface.media.ExifInterface r11 = r0.mExifInterface
            java.lang.String r12 = "GPSDateStamp"
            java.lang.String r11 = r11.getAttribute(r12)
            androidx.exifinterface.media.ExifInterface r12 = r0.mExifInterface
            java.lang.String r13 = "GPSTimeStamp"
            java.lang.String r12 = r12.getAttribute(r13)
            long r11 = r0.parseTimestamp(r11, r12)
            if (r2 != 0) goto L45
            r1 = 0
            return r1
        L45:
            if (r1 != 0) goto L49
            java.lang.String r1 = androidx.camera.core.impl.utils.Exif.TAG
        L49:
            android.location.Location r13 = new android.location.Location
            r13.<init>(r1)
            r1 = 0
            r14 = r2[r1]
            r13.setLatitude(r14)
            r14 = 1
            r1 = r2[r14]
            r13.setLongitude(r1)
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L61
            r13.setAltitude(r6)
        L61:
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto Lb5
            int r1 = r3.hashCode()
            r2 = 75
            if (r1 == r2) goto L8a
            r2 = 77
            if (r1 == r2) goto L80
            r2 = 78
            if (r1 == r2) goto L76
            goto L92
        L76:
            java.lang.String r1 = "N"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L92
            r1 = r14
            goto L93
        L80:
            java.lang.String r1 = "M"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L92
            r1 = 0
            goto L93
        L8a:
            boolean r1 = r3.equals(r10)
            if (r1 == 0) goto L92
            r1 = 2
            goto L93
        L92:
            r1 = -1
        L93:
            if (r1 == 0) goto La9
            if (r1 == r14) goto La0
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromKilometersPerHour(r8)
            double r1 = r1.toMetersPerSecond()
            goto Lb1
        La0:
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromKnots(r8)
            double r1 = r1.toMetersPerSecond()
            goto Lb1
        La9:
            androidx.camera.core.impl.utils.Exif$Speed$Converter r1 = androidx.camera.core.impl.utils.Exif.Speed.fromMilesPerHour(r8)
            double r1 = r1.toMetersPerSecond()
        Lb1:
            float r1 = (float) r1
            r13.setSpeed(r1)
        Lb5:
            r1 = -1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto Lbe
            r13.setTime(r11)
        Lbe:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.Exif.getLocation():android.location.Location");
    }

    public void rotate(int i) throws NumberFormatException {
        if (i % 90 != 0) {
            Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i)));
            this.mExifInterface.setAttribute("Orientation", String.valueOf(0));
            return;
        }
        int i2 = i % 360;
        int orientation = getOrientation();
        while (i2 < 0) {
            i2 += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i2 > 0) {
            i2 -= 90;
            switch (orientation) {
                case 2:
                    orientation = 7;
                    break;
                case 3:
                    orientation = 8;
                    break;
                case 4:
                    orientation = 5;
                    break;
                case 5:
                    orientation = 2;
                    break;
                case 6:
                    orientation = 3;
                    break;
                case 7:
                    orientation = 4;
                    break;
                case 8:
                    orientation = 1;
                    break;
                default:
                    orientation = 6;
                    break;
            }
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(orientation));
    }

    private long parseTimestamp(String str, String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return convertFromExifDate(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (str == null) {
            try {
                return convertFromExifTime(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return parseTimestamp(str + " " + str2);
    }

    private long parseTimestamp(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return convertFromExifDateTime(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    private static final class Speed {
        static Converter fromKilometersPerHour(double d) {
            return new Converter(d * 0.621371d);
        }

        static Converter fromMilesPerHour(double d) {
            return new Converter(d);
        }

        static Converter fromKnots(double d) {
            return new Converter(d * 1.15078d);
        }

        static final class Converter {
            final double mMph;

            Converter(double d) {
                this.mMph = d;
            }

            double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }
        }
    }

    public static List<String> getAllExifTags() {
        return Arrays.asList("ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType");
    }
}
