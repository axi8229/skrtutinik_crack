package com.google.i18n.phonenumbers;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
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
    private static PhoneNumberUtil instance;
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
        Map<Character, Character> map7 = ALPHA_MAPPINGS;
        String strValueOf = String.valueOf(Arrays.toString(map7.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        String strValueOf2 = String.valueOf(Arrays.toString(map7.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        VALID_ALPHA = strConcat;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile("[+＋\\p{Nd}]");
        SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
        UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        StringBuilder sb = new StringBuilder(String.valueOf(strConcat).length() + 108);
        sb.append("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*");
        sb.append(strConcat);
        sb.append("\\p{Nd}");
        sb.append("]*");
        String string = sb.toString();
        VALID_PHONE_NUMBER = string;
        String strCreateExtnPattern = createExtnPattern("xｘ#＃~～".length() != 0 ? ",;".concat("xｘ#＃~～") : new String(",;"));
        EXTN_PATTERNS_FOR_PARSING = strCreateExtnPattern;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
        StringBuilder sb2 = new StringBuilder(String.valueOf(strCreateExtnPattern).length() + 5);
        sb2.append("(?:");
        sb2.append(strCreateExtnPattern);
        sb2.append(")$");
        EXTN_PATTERN = Pattern.compile(sb2.toString(), 66);
        StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 5 + String.valueOf(strCreateExtnPattern).length());
        sb3.append(string);
        sb3.append("(?:");
        sb3.append(strCreateExtnPattern);
        sb3.append(")?");
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(sb3.toString(), 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
        instance = null;
    }

    private static String createExtnPattern(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 134);
        sb.append(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[");
        sb.append(str);
        sb.append("]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*");
        sb.append("(\\p{Nd}{1,7})");
        sb.append("#?|[- ]+(");
        sb.append("\\p{Nd}");
        sb.append("{1,5})#");
        return sb.toString();
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> map) {
        this.metadataSource = metadataSource;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
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
        this.nanpaRegions.addAll(map.get(1));
    }

    static CharSequence extractPossibleNumber(CharSequence charSequence) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(charSequence);
        if (matcher.find()) {
            CharSequence charSequenceSubSequence = charSequence.subSequence(matcher.start(), charSequence.length());
            Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(charSequenceSubSequence);
            if (matcher2.find()) {
                charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(charSequenceSubSequence);
            return matcher3.find() ? charSequenceSubSequence.subSequence(0, matcher3.start()) : charSequenceSubSequence;
        }
        return "";
    }

    static boolean isViablePhoneNumber(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(charSequence).matches();
    }

    static StringBuilder normalize(StringBuilder sb) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches()) {
            sb.replace(0, sb.length(), normalizeHelper(sb, ALPHA_PHONE_MAPPINGS, true));
        } else {
            sb.replace(0, sb.length(), normalizeDigitsOnly(sb));
        }
        return sb;
    }

    public static String normalizeDigitsOnly(CharSequence charSequence) {
        return normalizeDigits(charSequence, false).toString();
    }

    static StringBuilder normalizeDigits(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            int iDigit = Character.digit(cCharAt, 10);
            if (iDigit != -1) {
                sb.append(iDigit);
            } else if (z) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    private static String normalizeHelper(CharSequence charSequence, Map<Character, Character> map, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(cCharAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    static synchronized void setInstance(PhoneNumberUtil phoneNumberUtil) {
        instance = phoneNumberUtil;
    }

    private static boolean descHasPossibleNumberData(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        return (phonemetadata$PhoneNumberDesc.getPossibleLengthCount() == 1 && phonemetadata$PhoneNumberDesc.getPossibleLength(0) == -1) ? false : true;
    }

    public static synchronized PhoneNumberUtil getInstance() {
        try {
            if (instance == null) {
                setInstance(createInstance(MetadataManager.DEFAULT_METADATA_LOADER));
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        return createInstance(new MultiFileMetadataSourceImpl(metadataLoader));
    }

    private static PhoneNumberUtil createInstance(MetadataSource metadataSource) {
        if (metadataSource == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    private boolean hasValidCountryCallingCode(int i) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i));
    }

    public String format(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phonenumber$PhoneNumber.getNationalNumber() == 0 && phonenumber$PhoneNumber.hasRawInput()) {
            String rawInput = phonenumber$PhoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(phonenumber$PhoneNumber, phoneNumberFormat, sb);
        return sb.toString();
    }

    public void format(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        sb.setLength(0);
        int countryCode = phonenumber$PhoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phonenumber$PhoneNumber);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.E164;
        if (phoneNumberFormat == phoneNumberFormat2) {
            sb.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat2, sb);
        } else {
            if (!hasValidCountryCallingCode(countryCode)) {
                sb.append(nationalSignificantNumber);
                return;
            }
            Phonemetadata$PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
            maybeAppendFormattedExtension(phonenumber$PhoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb);
        }
    }

    private Phonemetadata$PhoneMetadata getMetadataForRegionOrCallingCode(int i, String str) {
        if ("001".equals(str)) {
            return getMetadataForNonGeographicalRegion(i);
        }
        return getMetadataForRegion(str);
    }

    public String getNationalSignificantNumber(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phonenumber$PhoneNumber.isItalianLeadingZero() && phonenumber$PhoneNumber.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[phonenumber$PhoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phonenumber$PhoneNumber.getNationalNumber());
        return sb.toString();
    }

    private void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        int i2 = AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[phoneNumberFormat.ordinal()];
        if (i2 == 1) {
            sb.insert(0, i).insert(0, '+');
        } else if (i2 == 2) {
            sb.insert(0, " ").insert(0, i).insert(0, '+');
        } else {
            if (i2 != 3) {
                return;
            }
            sb.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
        }
    }

    private String formatNsn(String str, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return formatNsn(str, phonemetadata$PhoneMetadata, phoneNumberFormat, null);
    }

    private String formatNsn(String str, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        List<Phonemetadata$NumberFormat> numberFormatList;
        if (phonemetadata$PhoneMetadata.getIntlNumberFormatList().size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
            numberFormatList = phonemetadata$PhoneMetadata.getNumberFormatList();
        } else {
            numberFormatList = phonemetadata$PhoneMetadata.getIntlNumberFormatList();
        }
        Phonemetadata$NumberFormat phonemetadata$NumberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(numberFormatList, str);
        return phonemetadata$NumberFormatChooseFormattingPatternForNumber == null ? str : formatNsnUsingPattern(str, phonemetadata$NumberFormatChooseFormattingPatternForNumber, phoneNumberFormat, charSequence);
    }

    Phonemetadata$NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata$NumberFormat> list, String str) {
        for (Phonemetadata$NumberFormat phonemetadata$NumberFormat : list) {
            int leadingDigitsPatternCount = phonemetadata$NumberFormat.getLeadingDigitsPatternCount();
            if (leadingDigitsPatternCount == 0 || this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.getLeadingDigitsPattern(leadingDigitsPatternCount - 1)).matcher(str).lookingAt()) {
                if (this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.getPattern()).matcher(str).matches()) {
                    return phonemetadata$NumberFormat;
                }
            }
        }
        return null;
    }

    private String formatNsnUsingPattern(String str, Phonemetadata$NumberFormat phonemetadata$NumberFormat, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        String strReplaceAll;
        String format = phonemetadata$NumberFormat.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.getPattern()).matcher(str);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.NATIONAL;
        if (phoneNumberFormat == phoneNumberFormat2 && charSequence != null && charSequence.length() > 0 && phonemetadata$NumberFormat.getDomesticCarrierCodeFormattingRule().length() > 0) {
            strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(phonemetadata$NumberFormat.getDomesticCarrierCodeFormattingRule().replace("$CC", charSequence)));
        } else {
            String nationalPrefixFormattingRule = phonemetadata$NumberFormat.getNationalPrefixFormattingRule();
            if (phoneNumberFormat == phoneNumberFormat2 && nationalPrefixFormattingRule != null && nationalPrefixFormattingRule.length() > 0) {
                strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            } else {
                strReplaceAll = matcher.replaceAll(format);
            }
        }
        if (phoneNumberFormat != PhoneNumberFormat.RFC3966) {
            return strReplaceAll;
        }
        Matcher matcher2 = SEPARATOR_PATTERN.matcher(strReplaceAll);
        if (matcher2.lookingAt()) {
            strReplaceAll = matcher2.replaceFirst("");
        }
        return matcher2.reset(strReplaceAll).replaceAll("-");
    }

    private void maybeAppendFormattedExtension(Phonenumber$PhoneNumber phonenumber$PhoneNumber, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        if (!phonenumber$PhoneNumber.hasExtension() || phonenumber$PhoneNumber.getExtension().length() <= 0) {
            return;
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            sb.append(";ext=");
            sb.append(phonenumber$PhoneNumber.getExtension());
        } else if (phonemetadata$PhoneMetadata.hasPreferredExtnPrefix()) {
            sb.append(phonemetadata$PhoneMetadata.getPreferredExtnPrefix());
            sb.append(phonenumber$PhoneNumber.getExtension());
        } else {
            sb.append(" ext. ");
            sb.append(phonenumber$PhoneNumber.getExtension());
        }
    }

    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType;
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber$PhoneNumber.CountryCodeSource.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = iArr3;
            try {
                iArr3[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    Phonemetadata$PhoneNumberDesc getNumberDescByType(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[phoneNumberType.ordinal()]) {
            case 1:
                return phonemetadata$PhoneMetadata.getPremiumRate();
            case 2:
                return phonemetadata$PhoneMetadata.getTollFree();
            case 3:
                return phonemetadata$PhoneMetadata.getMobile();
            case 4:
            case 5:
                return phonemetadata$PhoneMetadata.getFixedLine();
            case 6:
                return phonemetadata$PhoneMetadata.getSharedCost();
            case 7:
                return phonemetadata$PhoneMetadata.getVoip();
            case 8:
                return phonemetadata$PhoneMetadata.getPersonalNumber();
            case 9:
                return phonemetadata$PhoneMetadata.getPager();
            case 10:
                return phonemetadata$PhoneMetadata.getUan();
            case 11:
                return phonemetadata$PhoneMetadata.getVoicemail();
            default:
                return phonemetadata$PhoneMetadata.getGeneralDesc();
        }
    }

    Phonemetadata$PhoneMetadata getMetadataForRegion(String str) {
        if (isValidRegionCode(str)) {
            return this.metadataSource.getMetadataForRegion(str);
        }
        return null;
    }

    Phonemetadata$PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i))) {
            return this.metadataSource.getMetadataForNonGeographicalRegion(i);
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int i) {
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        return list == null ? "ZZ" : list.get(0);
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        return testNumberLength(charSequence, phonemetadata$PhoneMetadata, PhoneNumberType.UNKNOWN);
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        List<Integer> possibleLengthList;
        Phonemetadata$PhoneNumberDesc numberDescByType = getNumberDescByType(phonemetadata$PhoneMetadata, phoneNumberType);
        List<Integer> possibleLengthList2 = numberDescByType.getPossibleLengthList().isEmpty() ? phonemetadata$PhoneMetadata.getGeneralDesc().getPossibleLengthList() : numberDescByType.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = numberDescByType.getPossibleLengthLocalOnlyList();
        if (phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!descHasPossibleNumberData(getNumberDescByType(phonemetadata$PhoneMetadata, PhoneNumberType.FIXED_LINE))) {
                return testNumberLength(charSequence, phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata$PhoneNumberDesc numberDescByType2 = getNumberDescByType(phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            if (descHasPossibleNumberData(numberDescByType2)) {
                ArrayList arrayList = new ArrayList(possibleLengthList2);
                if (numberDescByType2.getPossibleLengthCount() == 0) {
                    possibleLengthList = phonemetadata$PhoneMetadata.getGeneralDesc().getPossibleLengthList();
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
        int length = charSequence.length();
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

    public ValidationResult isPossibleNumberWithReason(Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        return isPossibleNumberForTypeWithReason(phonenumber$PhoneNumber, PhoneNumberType.UNKNOWN);
    }

    public ValidationResult isPossibleNumberForTypeWithReason(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberType phoneNumberType) {
        String nationalSignificantNumber = getNationalSignificantNumber(phonenumber$PhoneNumber);
        int countryCode = phonenumber$PhoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return testNumberLength(nationalSignificantNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), phoneNumberType);
    }

    int extractCountryCode(StringBuilder sb, StringBuilder sb2) throws NumberFormatException {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i = 1; i <= 3 && i <= length; i++) {
                int i2 = Integer.parseInt(sb.substring(0, i));
                if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i2))) {
                    sb2.append(sb.substring(i));
                    return i2;
                }
            }
        }
        return 0;
    }

    int maybeExtractCountryCode(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder sb, boolean z, Phonenumber$PhoneNumber phonenumber$PhoneNumber) throws NumberParseException, NumberFormatException {
        String internationalPrefix;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        if (phonemetadata$PhoneMetadata == null) {
            internationalPrefix = "NonMatch";
        } else {
            internationalPrefix = phonemetadata$PhoneMetadata.getInternationalPrefix();
        }
        Phonenumber$PhoneNumber.CountryCodeSource countryCodeSourceMaybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb2, internationalPrefix);
        if (z) {
            phonenumber$PhoneNumber.setCountryCodeSource(countryCodeSourceMaybeStripInternationalPrefixAndNormalize);
        }
        if (countryCodeSourceMaybeStripInternationalPrefixAndNormalize != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() <= 2) {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int iExtractCountryCode = extractCountryCode(sb2, sb);
            if (iExtractCountryCode != 0) {
                phonenumber$PhoneNumber.setCountryCode(iExtractCountryCode);
                return iExtractCountryCode;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
        if (phonemetadata$PhoneMetadata != null) {
            int countryCode = phonemetadata$PhoneMetadata.getCountryCode();
            String strValueOf = String.valueOf(countryCode);
            String string = sb2.toString();
            if (string.startsWith(strValueOf)) {
                StringBuilder sb3 = new StringBuilder(string.substring(strValueOf.length()));
                Phonemetadata$PhoneNumberDesc generalDesc = phonemetadata$PhoneMetadata.getGeneralDesc();
                maybeStripNationalPrefixAndCarrierCode(sb3, phonemetadata$PhoneMetadata, null);
                if ((!this.matcherApi.matchNationalNumber(sb2, generalDesc, false) && this.matcherApi.matchNationalNumber(sb3, generalDesc, false)) || testNumberLength(sb2, phonemetadata$PhoneMetadata) == ValidationResult.TOO_LONG) {
                    sb.append((CharSequence) sb3);
                    if (z) {
                        phonenumber$PhoneNumber.setCountryCodeSource(Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phonenumber$PhoneNumber.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        phonenumber$PhoneNumber.setCountryCode(0);
        return 0;
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int iEnd = matcher.end();
        Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(sb.substring(iEnd));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        sb.delete(0, iEnd);
        return true;
    }

    Phonenumber$PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            normalize(sb);
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(str);
        normalize(sb);
        if (parsePrefixAsIdd(patternForRegex, sb)) {
            return Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder sb, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String nationalPrefixForParsing = phonemetadata$PhoneMetadata.getNationalPrefixForParsing();
        if (length != 0 && nationalPrefixForParsing.length() != 0) {
            Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(sb);
            if (matcher.lookingAt()) {
                Phonemetadata$PhoneNumberDesc generalDesc = phonemetadata$PhoneMetadata.getGeneralDesc();
                boolean zMatchNationalNumber = this.matcherApi.matchNationalNumber(sb, generalDesc, false);
                int iGroupCount = matcher.groupCount();
                String nationalPrefixTransformRule = phonemetadata$PhoneMetadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule == null || nationalPrefixTransformRule.length() == 0 || matcher.group(iGroupCount) == null) {
                    if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(sb.substring(matcher.end()), generalDesc, false)) {
                        return false;
                    }
                    if (sb2 != null && iGroupCount > 0 && matcher.group(iGroupCount) != null) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
                StringBuilder sb3 = new StringBuilder(sb);
                sb3.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(sb3.toString(), generalDesc, false)) {
                    return false;
                }
                if (sb2 != null && iGroupCount > 1) {
                    sb2.append(matcher.group(1));
                }
                sb.replace(0, sb.length(), sb3.toString());
                return true;
            }
        }
        return false;
    }

    String maybeStripExtension(StringBuilder sb) {
        Matcher matcher = EXTN_PATTERN.matcher(sb);
        if (matcher.find() && isViablePhoneNumber(sb.substring(0, matcher.start()))) {
            int iGroupCount = matcher.groupCount();
            for (int i = 1; i <= iGroupCount; i++) {
                if (matcher.group(i) != null) {
                    String strGroup = matcher.group(i);
                    sb.delete(matcher.start(), sb.length());
                    return strGroup;
                }
            }
            return "";
        }
        return "";
    }

    private boolean checkRegionForParsing(CharSequence charSequence, String str) {
        if (isValidRegionCode(str)) {
            return true;
        }
        return (charSequence == null || charSequence.length() == 0 || !PLUS_CHARS_PATTERN.matcher(charSequence).lookingAt()) ? false : true;
    }

    public Phonenumber$PhoneNumber parse(CharSequence charSequence, String str) throws NumberParseException, NumberFormatException {
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        parse(charSequence, str, phonenumber$PhoneNumber);
        return phonenumber$PhoneNumber;
    }

    public void parse(CharSequence charSequence, String str, Phonenumber$PhoneNumber phonenumber$PhoneNumber) throws NumberParseException, NumberFormatException {
        parseHelper(charSequence, str, false, true, phonenumber$PhoneNumber);
    }

    static void setItalianLeadingZerosForPhoneNumber(CharSequence charSequence, Phonenumber$PhoneNumber phonenumber$PhoneNumber) {
        if (charSequence.length() <= 1 || charSequence.charAt(0) != '0') {
            return;
        }
        phonenumber$PhoneNumber.setItalianLeadingZero(true);
        int i = 1;
        while (i < charSequence.length() - 1 && charSequence.charAt(i) == '0') {
            i++;
        }
        if (i != 1) {
            phonenumber$PhoneNumber.setNumberOfLeadingZeros(i);
        }
    }

    private void parseHelper(CharSequence charSequence, String str, boolean z, boolean z2, Phonenumber$PhoneNumber phonenumber$PhoneNumber) throws NumberParseException, NumberFormatException {
        int iMaybeExtractCountryCode;
        if (charSequence == null) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (charSequence.length() > 250) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb = new StringBuilder();
        String string = charSequence.toString();
        buildNationalNumberForParsing(string, sb);
        if (!isViablePhoneNumber(sb)) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (z2 && !checkRegionForParsing(sb, str)) {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (z) {
            phonenumber$PhoneNumber.setRawInput(string);
        }
        String strMaybeStripExtension = maybeStripExtension(sb);
        if (strMaybeStripExtension.length() > 0) {
            phonenumber$PhoneNumber.setExtension(strMaybeStripExtension);
        }
        Phonemetadata$PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        StringBuilder sb2 = new StringBuilder();
        try {
            iMaybeExtractCountryCode = maybeExtractCountryCode(sb, metadataForRegion, sb2, z, phonenumber$PhoneNumber);
        } catch (NumberParseException e) {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
            if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                iMaybeExtractCountryCode = maybeExtractCountryCode(sb.substring(matcher.end()), metadataForRegion, sb2, z, phonenumber$PhoneNumber);
                if (iMaybeExtractCountryCode == 0) {
                    throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                }
            } else {
                throw new NumberParseException(e.getErrorType(), e.getMessage());
            }
        }
        if (iMaybeExtractCountryCode != 0) {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(iMaybeExtractCountryCode);
            if (!regionCodeForCountryCode.equals(str)) {
                metadataForRegion = getMetadataForRegionOrCallingCode(iMaybeExtractCountryCode, regionCodeForCountryCode);
            }
        } else {
            sb2.append((CharSequence) normalize(sb));
            if (str != null) {
                phonenumber$PhoneNumber.setCountryCode(metadataForRegion.getCountryCode());
            } else if (z) {
                phonenumber$PhoneNumber.clearCountryCodeSource();
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
                if (z && sb3.length() > 0) {
                    phonenumber$PhoneNumber.setPreferredDomesticCarrierCode(sb3.toString());
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
        setItalianLeadingZerosForPhoneNumber(sb2, phonenumber$PhoneNumber);
        phonenumber$PhoneNumber.setNationalNumber(Long.parseLong(sb2.toString()));
    }

    private void buildNationalNumberForParsing(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(";phone-context=");
        if (iIndexOf >= 0) {
            int i = iIndexOf + 15;
            if (i < str.length() - 1 && str.charAt(i) == '+') {
                int iIndexOf2 = str.indexOf(59, i);
                if (iIndexOf2 > 0) {
                    sb.append(str.substring(i, iIndexOf2));
                } else {
                    sb.append(str.substring(i));
                }
            }
            int iIndexOf3 = str.indexOf("tel:");
            sb.append(str.substring(iIndexOf3 >= 0 ? iIndexOf3 + 4 : 0, iIndexOf));
        } else {
            sb.append(extractPossibleNumber(str));
        }
        int iIndexOf4 = sb.indexOf(";isub=");
        if (iIndexOf4 > 0) {
            sb.delete(iIndexOf4, sb.length());
        }
    }
}
