package io.michaelrocks.libphonenumber.android;

import android.content.Context;
import com.fasterxml.jackson.core.JsonPointer;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber;
import io.michaelrocks.libphonenumber.android.internal.MatcherApi;
import io.michaelrocks.libphonenumber.android.internal.RegexBasedMatcher;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN;
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
    private static final Pattern FIRST_GROUP_PATTERN;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    static final Pattern NON_DIGITS_PATTERN;
    static final Pattern PLUS_CHARS_PATTERN;
    static final Pattern SECOND_NUMBER_START_PATTERN;
    private static final Pattern SEPARATOR_PATTERN;
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX;
    static final Pattern UNWANTED_END_CHAR_PATTERN;
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN;
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    private static final Pattern VALID_START_CHAR_PATTERN;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final MetadataSource metadataSource;
    private final MatcherApi matcherApi = RegexBasedMatcher.create();
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap map = new HashMap();
        map.put(54, "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(map);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(hashSet2);
        HashMap map2 = new HashMap();
        map2.put('0', '0');
        map2.put('1', '1');
        map2.put('2', '2');
        map2.put('3', '3');
        map2.put('4', '4');
        map2.put('5', '5');
        map2.put('6', '6');
        map2.put('7', '7');
        map2.put('8', '8');
        map2.put('9', '9');
        HashMap map3 = new HashMap(40);
        map3.put('A', '2');
        map3.put('B', '2');
        map3.put('C', '2');
        map3.put('D', '3');
        map3.put('E', '3');
        map3.put('F', '3');
        map3.put('G', '4');
        map3.put('H', '4');
        map3.put('I', '4');
        map3.put('J', '5');
        map3.put('K', '5');
        map3.put('L', '5');
        map3.put('M', '6');
        map3.put('N', '6');
        map3.put('O', '6');
        map3.put('P', '7');
        map3.put('Q', '7');
        map3.put('R', '7');
        map3.put('S', '7');
        map3.put('T', '8');
        map3.put('U', '8');
        map3.put('V', '8');
        map3.put('W', '9');
        map3.put('X', '9');
        map3.put('Y', '9');
        map3.put('Z', '9');
        Map<Character, Character> mapUnmodifiableMap = Collections.unmodifiableMap(map3);
        ALPHA_MAPPINGS = mapUnmodifiableMap;
        HashMap map4 = new HashMap(100);
        map4.putAll(mapUnmodifiableMap);
        map4.putAll(map2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.putAll(map2);
        map5.put('+', '+');
        map5.put('*', '*');
        map5.put('#', '#');
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(map5);
        HashMap map6 = new HashMap();
        for (Character ch : mapUnmodifiableMap.keySet()) {
            map6.put(Character.valueOf(Character.toLowerCase(ch.charValue())), ch);
            map6.put(ch, ch);
        }
        map6.putAll(map2);
        map6.put('-', '-');
        map6.put((char) 65293, '-');
        map6.put((char) 8208, '-');
        map6.put((char) 8209, '-');
        map6.put((char) 8210, '-');
        map6.put((char) 8211, '-');
        map6.put((char) 8212, '-');
        map6.put((char) 8213, '-');
        map6.put((char) 8722, '-');
        map6.put(Character.valueOf(JsonPointer.SEPARATOR), Character.valueOf(JsonPointer.SEPARATOR));
        map6.put((char) 65295, Character.valueOf(JsonPointer.SEPARATOR));
        map6.put(' ', ' ');
        map6.put((char) 12288, ' ');
        map6.put((char) 8288, ' ');
        map6.put('.', '.');
        map6.put((char) 65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(map6);
        SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map7 = ALPHA_MAPPINGS;
        sb.append(Arrays.toString(map7.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map7.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String string = sb.toString();
        VALID_ALPHA = string;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile("[+＋\\p{Nd}]");
        SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
        UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + string + "\\p{Nd}]*";
        VALID_PHONE_NUMBER = str;
        String strCreateExtnPattern = createExtnPattern(",;xｘ#＃~～");
        EXTN_PATTERNS_FOR_PARSING = strCreateExtnPattern;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
        EXTN_PATTERN = Pattern.compile("(?:" + strCreateExtnPattern + ")$", 66);
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(str + "(?:" + strCreateExtnPattern + ")?", 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    }

    private static String createExtnPattern(String singleExtnSymbols) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[" + singleExtnSymbols + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> countryCallingCodeToRegionCodeMap) {
        this.metadataSource = metadataSource;
        this.countryCallingCodeToRegionCodeMap = countryCallingCodeToRegionCodeMap;
        for (Map.Entry<Integer, List<String>> entry : countryCallingCodeToRegionCodeMap.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && "001".equals(value.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else {
                this.supportedRegions.addAll(value);
            }
        }
        if (this.supportedRegions.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(1));
    }

    static CharSequence extractPossibleNumber(CharSequence number) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(number);
        if (matcher.find()) {
            CharSequence charSequenceSubSequence = number.subSequence(matcher.start(), number.length());
            Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(charSequenceSubSequence);
            if (matcher2.find()) {
                charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(charSequenceSubSequence);
            return matcher3.find() ? charSequenceSubSequence.subSequence(0, matcher3.start()) : charSequenceSubSequence;
        }
        return "";
    }

    static boolean isViablePhoneNumber(CharSequence number) {
        if (number.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(number).matches();
    }

    static StringBuilder normalize(StringBuilder number) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(number).matches()) {
            number.replace(0, number.length(), normalizeHelper(number, ALPHA_PHONE_MAPPINGS, true));
        } else {
            number.replace(0, number.length(), normalizeDigitsOnly(number));
        }
        return number;
    }

    public static String normalizeDigitsOnly(CharSequence number) {
        return normalizeDigits(number, false).toString();
    }

    static StringBuilder normalizeDigits(CharSequence number, boolean keepNonDigits) {
        StringBuilder sb = new StringBuilder(number.length());
        for (int i = 0; i < number.length(); i++) {
            char cCharAt = number.charAt(i);
            int iDigit = Character.digit(cCharAt, 10);
            if (iDigit != -1) {
                sb.append(iDigit);
            } else if (keepNonDigits) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    private static String normalizeHelper(CharSequence number, Map<Character, Character> normalizationReplacements, boolean removeNonMatches) {
        StringBuilder sb = new StringBuilder(number.length());
        for (int i = 0; i < number.length(); i++) {
            char cCharAt = number.charAt(i);
            Character ch = normalizationReplacements.get(Character.valueOf(Character.toUpperCase(cCharAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!removeNonMatches) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static boolean descHasPossibleNumberData(Phonemetadata$PhoneNumberDesc desc) {
        return (desc.getPossibleLengthCount() == 1 && desc.getPossibleLength(0) == -1) ? false : true;
    }

    public static PhoneNumberUtil createInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context could not be null.");
        }
        return createInstance(new AssetsMetadataLoader(context.getAssets()));
    }

    public static PhoneNumberUtil createInstance(MetadataSource metadataSource) {
        if (metadataSource == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        return createInstance(new MultiFileMetadataSourceImpl(metadataLoader));
    }

    private boolean isValidRegionCode(String regionCode) {
        return regionCode != null && this.supportedRegions.contains(regionCode);
    }

    private boolean hasValidCountryCallingCode(int countryCallingCode) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(countryCallingCode));
    }

    public String format(Phonenumber$PhoneNumber number, PhoneNumberFormat numberFormat) {
        if (number.getNationalNumber() == 0 && number.hasRawInput()) {
            String rawInput = number.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(number, numberFormat, sb);
        return sb.toString();
    }

    public void format(Phonenumber$PhoneNumber number, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        formattedNumber.setLength(0);
        int countryCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.E164;
        if (numberFormat == phoneNumberFormat) {
            formattedNumber.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, formattedNumber);
        } else {
            if (!hasValidCountryCallingCode(countryCode)) {
                formattedNumber.append(nationalSignificantNumber);
                return;
            }
            Phonemetadata$PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            formattedNumber.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, numberFormat));
            maybeAppendFormattedExtension(number, metadataForRegionOrCallingCode, numberFormat, formattedNumber);
            prefixNumberWithCountryCallingCode(countryCode, numberFormat, formattedNumber);
        }
    }

    private Phonemetadata$PhoneMetadata getMetadataForRegionOrCallingCode(int countryCallingCode, String regionCode) {
        if ("001".equals(regionCode)) {
            return getMetadataForNonGeographicalRegion(countryCallingCode);
        }
        return getMetadataForRegion(regionCode);
    }

    public String getNationalSignificantNumber(Phonenumber$PhoneNumber number) {
        StringBuilder sb = new StringBuilder();
        if (number.isItalianLeadingZero() && number.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[number.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(number.getNationalNumber());
        return sb.toString();
    }

    private void prefixNumberWithCountryCallingCode(int countryCallingCode, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        int i = AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[numberFormat.ordinal()];
        if (i == 1) {
            formattedNumber.insert(0, countryCallingCode).insert(0, '+');
        } else if (i == 2) {
            formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, '+');
        } else {
            if (i != 3) {
                return;
            }
            formattedNumber.insert(0, "-").insert(0, countryCallingCode).insert(0, '+').insert(0, "tel:");
        }
    }

    private String formatNsn(String number, Phonemetadata$PhoneMetadata metadata, PhoneNumberFormat numberFormat) {
        return formatNsn(number, metadata, numberFormat, null);
    }

    private String formatNsn(String number, Phonemetadata$PhoneMetadata metadata, PhoneNumberFormat numberFormat, CharSequence carrierCode) {
        List<Phonemetadata$NumberFormat> listNumberFormats;
        if (metadata.intlNumberFormats().size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL) {
            listNumberFormats = metadata.numberFormats();
        } else {
            listNumberFormats = metadata.intlNumberFormats();
        }
        Phonemetadata$NumberFormat phonemetadata$NumberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(listNumberFormats, number);
        return phonemetadata$NumberFormatChooseFormattingPatternForNumber == null ? number : formatNsnUsingPattern(number, phonemetadata$NumberFormatChooseFormattingPatternForNumber, numberFormat, carrierCode);
    }

    Phonemetadata$NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata$NumberFormat> availableFormats, String nationalNumber) {
        for (Phonemetadata$NumberFormat phonemetadata$NumberFormat : availableFormats) {
            int iLeadingDigitsPatternSize = phonemetadata$NumberFormat.leadingDigitsPatternSize();
            if (iLeadingDigitsPatternSize == 0 || this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.getLeadingDigitsPattern(iLeadingDigitsPatternSize - 1)).matcher(nationalNumber).lookingAt()) {
                if (this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.getPattern()).matcher(nationalNumber).matches()) {
                    return phonemetadata$NumberFormat;
                }
            }
        }
        return null;
    }

    private String formatNsnUsingPattern(String nationalNumber, Phonemetadata$NumberFormat formattingPattern, PhoneNumberFormat numberFormat, CharSequence carrierCode) {
        String strReplaceAll;
        String format = formattingPattern.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(formattingPattern.getPattern()).matcher(nationalNumber);
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.NATIONAL;
        if (numberFormat == phoneNumberFormat && carrierCode != null && carrierCode.length() > 0 && formattingPattern.getDomesticCarrierCodeFormattingRule().length() > 0) {
            strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(formattingPattern.getDomesticCarrierCodeFormattingRule().replace("$CC", carrierCode)));
        } else {
            String nationalPrefixFormattingRule = formattingPattern.getNationalPrefixFormattingRule();
            if (numberFormat == phoneNumberFormat && nationalPrefixFormattingRule != null && nationalPrefixFormattingRule.length() > 0) {
                strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            } else {
                strReplaceAll = matcher.replaceAll(format);
            }
        }
        if (numberFormat != PhoneNumberFormat.RFC3966) {
            return strReplaceAll;
        }
        Matcher matcher2 = SEPARATOR_PATTERN.matcher(strReplaceAll);
        if (matcher2.lookingAt()) {
            strReplaceAll = matcher2.replaceFirst("");
        }
        return matcher2.reset(strReplaceAll).replaceAll("-");
    }

    private void maybeAppendFormattedExtension(Phonenumber$PhoneNumber number, Phonemetadata$PhoneMetadata metadata, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        if (!number.hasExtension() || number.getExtension().length() <= 0) {
            return;
        }
        if (numberFormat == PhoneNumberFormat.RFC3966) {
            formattedNumber.append(";ext=");
            formattedNumber.append(number.getExtension());
        } else if (metadata.hasPreferredExtnPrefix()) {
            formattedNumber.append(metadata.getPreferredExtnPrefix());
            formattedNumber.append(number.getExtension());
        } else {
            formattedNumber.append(" ext. ");
            formattedNumber.append(number.getExtension());
        }
    }

    /* renamed from: io.michaelrocks.libphonenumber.android.PhoneNumberUtil$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber$PhoneNumber.CountryCodeSource.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource = iArr3;
            try {
                iArr3[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    Phonemetadata$PhoneNumberDesc getNumberDescByType(Phonemetadata$PhoneMetadata metadata, PhoneNumberType type) {
        switch (AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[type.ordinal()]) {
            case 1:
                return metadata.getPremiumRate();
            case 2:
                return metadata.getTollFree();
            case 3:
                return metadata.getMobile();
            case 4:
            case 5:
                return metadata.getFixedLine();
            case 6:
                return metadata.getSharedCost();
            case 7:
                return metadata.getVoip();
            case 8:
                return metadata.getPersonalNumber();
            case 9:
                return metadata.getPager();
            case 10:
                return metadata.getUan();
            case 11:
                return metadata.getVoicemail();
            default:
                return metadata.getGeneralDesc();
        }
    }

    Phonemetadata$PhoneMetadata getMetadataForRegion(String regionCode) {
        if (isValidRegionCode(regionCode)) {
            return this.metadataSource.getMetadataForRegion(regionCode);
        }
        return null;
    }

    Phonemetadata$PhoneMetadata getMetadataForNonGeographicalRegion(int countryCallingCode) {
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(countryCallingCode))) {
            return this.metadataSource.getMetadataForNonGeographicalRegion(countryCallingCode);
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int countryCallingCode) {
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCallingCode));
        return list == null ? "ZZ" : list.get(0);
    }

    private ValidationResult testNumberLength(CharSequence number, Phonemetadata$PhoneMetadata metadata) {
        return testNumberLength(number, metadata, PhoneNumberType.UNKNOWN);
    }

    private ValidationResult testNumberLength(CharSequence number, Phonemetadata$PhoneMetadata metadata, PhoneNumberType type) {
        List<Integer> possibleLengthList;
        Phonemetadata$PhoneNumberDesc numberDescByType = getNumberDescByType(metadata, type);
        List<Integer> possibleLengthList2 = numberDescByType.getPossibleLengthList().isEmpty() ? metadata.getGeneralDesc().getPossibleLengthList() : numberDescByType.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = numberDescByType.getPossibleLengthLocalOnlyList();
        if (type == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!descHasPossibleNumberData(getNumberDescByType(metadata, PhoneNumberType.FIXED_LINE))) {
                return testNumberLength(number, metadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata$PhoneNumberDesc numberDescByType2 = getNumberDescByType(metadata, PhoneNumberType.MOBILE);
            if (descHasPossibleNumberData(numberDescByType2)) {
                ArrayList arrayList = new ArrayList(possibleLengthList2);
                if (numberDescByType2.getPossibleLengthList().size() == 0) {
                    possibleLengthList = metadata.getGeneralDesc().getPossibleLengthList();
                } else {
                    possibleLengthList = numberDescByType2.getPossibleLengthList();
                }
                arrayList.addAll(possibleLengthList);
                Collections.sort(arrayList);
                if (possibleLengthLocalOnlyList.isEmpty()) {
                    possibleLengthLocalOnlyList = numberDescByType2.getPossibleLengthLocalOnlyList();
                } else {
                    ArrayList arrayList2 = new ArrayList(possibleLengthLocalOnlyList);
                    arrayList2.addAll(numberDescByType2.getPossibleLengthLocalOnlyList());
                    Collections.sort(arrayList2);
                    possibleLengthLocalOnlyList = arrayList2;
                }
                possibleLengthList2 = arrayList;
            }
        }
        if (possibleLengthList2.get(0).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = number.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int iIntValue = possibleLengthList2.get(0).intValue();
        if (iIntValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (iIntValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (possibleLengthList2.get(possibleLengthList2.size() - 1).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        return possibleLengthList2.subList(1, possibleLengthList2.size()).contains(Integer.valueOf(length)) ? ValidationResult.IS_POSSIBLE : ValidationResult.INVALID_LENGTH;
    }

    int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) throws NumberFormatException {
        if (fullNumber.length() != 0 && fullNumber.charAt(0) != '0') {
            int length = fullNumber.length();
            for (int i = 1; i <= 3 && i <= length; i++) {
                int i2 = Integer.parseInt(fullNumber.substring(0, i));
                if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i2))) {
                    nationalNumber.append(fullNumber.substring(i));
                    return i2;
                }
            }
        }
        return 0;
    }

    int maybeExtractCountryCode(CharSequence number, Phonemetadata$PhoneMetadata defaultRegionMetadata, StringBuilder nationalNumber, boolean keepRawInput, Phonenumber$PhoneNumber phoneNumber) throws NumberParseException, NumberFormatException {
        String internationalPrefix;
        if (number.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(number);
        if (defaultRegionMetadata == null) {
            internationalPrefix = "NonMatch";
        } else {
            internationalPrefix = defaultRegionMetadata.getInternationalPrefix();
        }
        Phonenumber$PhoneNumber.CountryCodeSource countryCodeSourceMaybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb, internationalPrefix);
        if (keepRawInput) {
            phoneNumber.setCountryCodeSource(countryCodeSourceMaybeStripInternationalPrefixAndNormalize);
        }
        if (countryCodeSourceMaybeStripInternationalPrefixAndNormalize != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb.length() <= 2) {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int iExtractCountryCode = extractCountryCode(sb, nationalNumber);
            if (iExtractCountryCode != 0) {
                phoneNumber.setCountryCode(iExtractCountryCode);
                return iExtractCountryCode;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
        if (defaultRegionMetadata != null) {
            int countryCode = defaultRegionMetadata.getCountryCode();
            String strValueOf = String.valueOf(countryCode);
            String string = sb.toString();
            if (string.startsWith(strValueOf)) {
                StringBuilder sb2 = new StringBuilder(string.substring(strValueOf.length()));
                Phonemetadata$PhoneNumberDesc generalDesc = defaultRegionMetadata.getGeneralDesc();
                maybeStripNationalPrefixAndCarrierCode(sb2, defaultRegionMetadata, null);
                if ((!this.matcherApi.matchNationalNumber(sb, generalDesc, false) && this.matcherApi.matchNationalNumber(sb2, generalDesc, false)) || testNumberLength(sb, defaultRegionMetadata) == ValidationResult.TOO_LONG) {
                    nationalNumber.append((CharSequence) sb2);
                    if (keepRawInput) {
                        phoneNumber.setCountryCodeSource(Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phoneNumber.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        phoneNumber.setCountryCode(0);
        return 0;
    }

    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        Matcher matcher = iddPattern.matcher(number);
        if (!matcher.lookingAt()) {
            return false;
        }
        int iEnd = matcher.end();
        Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(number.substring(iEnd));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        number.delete(0, iEnd);
        return true;
    }

    Phonenumber$PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder number, String possibleIddPrefix) {
        if (number.length() == 0) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(number);
        if (matcher.lookingAt()) {
            number.delete(0, matcher.end());
            normalize(number);
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(possibleIddPrefix);
        normalize(number);
        if (parsePrefixAsIdd(patternForRegex, number)) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder number, Phonemetadata$PhoneMetadata metadata, StringBuilder carrierCode) {
        int length = number.length();
        String nationalPrefixForParsing = metadata.getNationalPrefixForParsing();
        if (length != 0 && nationalPrefixForParsing.length() != 0) {
            Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(number);
            if (matcher.lookingAt()) {
                Phonemetadata$PhoneNumberDesc generalDesc = metadata.getGeneralDesc();
                boolean zMatchNationalNumber = this.matcherApi.matchNationalNumber(number, generalDesc, false);
                int iGroupCount = matcher.groupCount();
                String nationalPrefixTransformRule = metadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule == null || nationalPrefixTransformRule.length() == 0 || matcher.group(iGroupCount) == null) {
                    if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(number.substring(matcher.end()), generalDesc, false)) {
                        return false;
                    }
                    if (carrierCode != null && iGroupCount > 0 && matcher.group(iGroupCount) != null) {
                        carrierCode.append(matcher.group(1));
                    }
                    number.delete(0, matcher.end());
                    return true;
                }
                StringBuilder sb = new StringBuilder(number);
                sb.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(sb.toString(), generalDesc, false)) {
                    return false;
                }
                if (carrierCode != null && iGroupCount > 1) {
                    carrierCode.append(matcher.group(1));
                }
                number.replace(0, number.length(), sb.toString());
                return true;
            }
        }
        return false;
    }

    String maybeStripExtension(StringBuilder number) {
        Matcher matcher = EXTN_PATTERN.matcher(number);
        if (matcher.find() && isViablePhoneNumber(number.substring(0, matcher.start()))) {
            int iGroupCount = matcher.groupCount();
            for (int i = 1; i <= iGroupCount; i++) {
                if (matcher.group(i) != null) {
                    String strGroup = matcher.group(i);
                    number.delete(matcher.start(), number.length());
                    return strGroup;
                }
            }
            return "";
        }
        return "";
    }

    private boolean checkRegionForParsing(CharSequence numberToParse, String defaultRegion) {
        if (isValidRegionCode(defaultRegion)) {
            return true;
        }
        return (numberToParse == null || numberToParse.length() == 0 || !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) ? false : true;
    }

    public Phonenumber$PhoneNumber parse(CharSequence numberToParse, String defaultRegion) throws NumberParseException, NumberFormatException {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        parse(numberToParse, defaultRegion, phonenumber$PhoneNumber);
        return phonenumber$PhoneNumber;
    }

    public void parse(CharSequence numberToParse, String defaultRegion, Phonenumber$PhoneNumber phoneNumber) throws NumberParseException, NumberFormatException {
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    public Phonenumber$PhoneNumber parseAndKeepRawInput(CharSequence numberToParse, String defaultRegion) throws NumberParseException, NumberFormatException {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phonenumber$PhoneNumber);
        return phonenumber$PhoneNumber;
    }

    public void parseAndKeepRawInput(CharSequence numberToParse, String defaultRegion, Phonenumber$PhoneNumber phoneNumber) throws NumberParseException, NumberFormatException {
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    static void setItalianLeadingZerosForPhoneNumber(CharSequence nationalNumber, Phonenumber$PhoneNumber phoneNumber) {
        if (nationalNumber.length() <= 1 || nationalNumber.charAt(0) != '0') {
            return;
        }
        phoneNumber.setItalianLeadingZero(true);
        int i = 1;
        while (i < nationalNumber.length() - 1 && nationalNumber.charAt(i) == '0') {
            i++;
        }
        if (i != 1) {
            phoneNumber.setNumberOfLeadingZeros(i);
        }
    }

    private void parseHelper(CharSequence numberToParse, String defaultRegion, boolean keepRawInput, boolean checkRegion, Phonenumber$PhoneNumber phoneNumber) throws NumberParseException, NumberFormatException {
        int iMaybeExtractCountryCode;
        if (numberToParse == null) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (numberToParse.length() > 250) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb = new StringBuilder();
        String string = numberToParse.toString();
        buildNationalNumberForParsing(string, sb);
        if (!isViablePhoneNumber(sb)) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (checkRegion && !checkRegionForParsing(sb, defaultRegion)) {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (keepRawInput) {
            phoneNumber.setRawInput(string);
        }
        String strMaybeStripExtension = maybeStripExtension(sb);
        if (strMaybeStripExtension.length() > 0) {
            phoneNumber.setExtension(strMaybeStripExtension);
        }
        Phonemetadata$PhoneMetadata metadataForRegion = getMetadataForRegion(defaultRegion);
        StringBuilder sb2 = new StringBuilder();
        try {
            iMaybeExtractCountryCode = maybeExtractCountryCode(sb, metadataForRegion, sb2, keepRawInput, phoneNumber);
        } catch (NumberParseException e) {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
            if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                iMaybeExtractCountryCode = maybeExtractCountryCode(sb.substring(matcher.end()), metadataForRegion, sb2, keepRawInput, phoneNumber);
                if (iMaybeExtractCountryCode == 0) {
                    throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                }
            } else {
                throw new NumberParseException(e.getErrorType(), e.getMessage());
            }
        }
        if (iMaybeExtractCountryCode != 0) {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(iMaybeExtractCountryCode);
            if (!regionCodeForCountryCode.equals(defaultRegion)) {
                metadataForRegion = getMetadataForRegionOrCallingCode(iMaybeExtractCountryCode, regionCodeForCountryCode);
            }
        } else {
            sb2.append((CharSequence) normalize(sb));
            if (defaultRegion != null) {
                phoneNumber.setCountryCode(metadataForRegion.getCountryCode());
            } else if (keepRawInput) {
                phoneNumber.clearCountryCodeSource();
            }
        }
        if (sb2.length() < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (metadataForRegion != null) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder(sb2);
            maybeStripNationalPrefixAndCarrierCode(sb4, metadataForRegion, sb3);
            ValidationResult validationResultTestNumberLength = testNumberLength(sb4, metadataForRegion);
            if (validationResultTestNumberLength != ValidationResult.TOO_SHORT && validationResultTestNumberLength != ValidationResult.IS_POSSIBLE_LOCAL_ONLY && validationResultTestNumberLength != ValidationResult.INVALID_LENGTH) {
                if (keepRawInput && sb3.length() > 0) {
                    phoneNumber.setPreferredDomesticCarrierCode(sb3.toString());
                }
                sb2 = sb4;
            }
        }
        int length = sb2.length();
        if (length < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (length > 17) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        setItalianLeadingZerosForPhoneNumber(sb2, phoneNumber);
        phoneNumber.setNationalNumber(Long.parseLong(sb2.toString()));
    }

    private void buildNationalNumberForParsing(String numberToParse, StringBuilder nationalNumber) {
        int iIndexOf = numberToParse.indexOf(";phone-context=");
        if (iIndexOf >= 0) {
            int i = iIndexOf + 15;
            if (i < numberToParse.length() - 1 && numberToParse.charAt(i) == '+') {
                int iIndexOf2 = numberToParse.indexOf(59, i);
                if (iIndexOf2 > 0) {
                    nationalNumber.append(numberToParse.substring(i, iIndexOf2));
                } else {
                    nationalNumber.append(numberToParse.substring(i));
                }
            }
            int iIndexOf3 = numberToParse.indexOf("tel:");
            nationalNumber.append(numberToParse.substring(iIndexOf3 >= 0 ? iIndexOf3 + 4 : 0, iIndexOf));
        } else {
            nationalNumber.append(extractPossibleNumber(numberToParse));
        }
        int iIndexOf4 = nationalNumber.indexOf(";isub=");
        if (iIndexOf4 > 0) {
            nationalNumber.delete(iIndexOf4, nationalNumber.length());
        }
    }
}
