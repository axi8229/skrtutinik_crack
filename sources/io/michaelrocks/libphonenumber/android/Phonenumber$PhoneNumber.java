package io.michaelrocks.libphonenumber.android;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Phonenumber$PhoneNumber implements Serializable {
    private boolean hasCountryCode;
    private boolean hasCountryCodeSource;
    private boolean hasExtension;
    private boolean hasItalianLeadingZero;
    private boolean hasNationalNumber;
    private boolean hasNumberOfLeadingZeros;
    private boolean hasPreferredDomesticCarrierCode;
    private boolean hasRawInput;
    private int countryCode_ = 0;
    private long nationalNumber_ = 0;
    private String extension_ = "";
    private boolean italianLeadingZero_ = false;
    private int numberOfLeadingZeros_ = 1;
    private String rawInput_ = "";
    private String preferredDomesticCarrierCode_ = "";
    private CountryCodeSource countryCodeSource_ = CountryCodeSource.UNSPECIFIED;

    public enum CountryCodeSource {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public int getCountryCode() {
        return this.countryCode_;
    }

    public Phonenumber$PhoneNumber setCountryCode(int value) {
        this.hasCountryCode = true;
        this.countryCode_ = value;
        return this;
    }

    public long getNationalNumber() {
        return this.nationalNumber_;
    }

    public Phonenumber$PhoneNumber setNationalNumber(long value) {
        this.hasNationalNumber = true;
        this.nationalNumber_ = value;
        return this;
    }

    public boolean hasExtension() {
        return this.hasExtension;
    }

    public String getExtension() {
        return this.extension_;
    }

    public Phonenumber$PhoneNumber setExtension(String value) {
        value.getClass();
        this.hasExtension = true;
        this.extension_ = value;
        return this;
    }

    public boolean hasItalianLeadingZero() {
        return this.hasItalianLeadingZero;
    }

    public boolean isItalianLeadingZero() {
        return this.italianLeadingZero_;
    }

    public Phonenumber$PhoneNumber setItalianLeadingZero(boolean value) {
        this.hasItalianLeadingZero = true;
        this.italianLeadingZero_ = value;
        return this;
    }

    public boolean hasNumberOfLeadingZeros() {
        return this.hasNumberOfLeadingZeros;
    }

    public int getNumberOfLeadingZeros() {
        return this.numberOfLeadingZeros_;
    }

    public Phonenumber$PhoneNumber setNumberOfLeadingZeros(int value) {
        this.hasNumberOfLeadingZeros = true;
        this.numberOfLeadingZeros_ = value;
        return this;
    }

    public boolean hasRawInput() {
        return this.hasRawInput;
    }

    public String getRawInput() {
        return this.rawInput_;
    }

    public Phonenumber$PhoneNumber setRawInput(String value) {
        value.getClass();
        this.hasRawInput = true;
        this.rawInput_ = value;
        return this;
    }

    public boolean hasCountryCodeSource() {
        return this.hasCountryCodeSource;
    }

    public CountryCodeSource getCountryCodeSource() {
        return this.countryCodeSource_;
    }

    public Phonenumber$PhoneNumber setCountryCodeSource(CountryCodeSource value) {
        value.getClass();
        this.hasCountryCodeSource = true;
        this.countryCodeSource_ = value;
        return this;
    }

    public Phonenumber$PhoneNumber clearCountryCodeSource() {
        this.hasCountryCodeSource = false;
        this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
        return this;
    }

    public boolean hasPreferredDomesticCarrierCode() {
        return this.hasPreferredDomesticCarrierCode;
    }

    public String getPreferredDomesticCarrierCode() {
        return this.preferredDomesticCarrierCode_;
    }

    public Phonenumber$PhoneNumber setPreferredDomesticCarrierCode(String value) {
        value.getClass();
        this.hasPreferredDomesticCarrierCode = true;
        this.preferredDomesticCarrierCode_ = value;
        return this;
    }

    public boolean exactlySameAs(Phonenumber$PhoneNumber other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return this.countryCode_ == other.countryCode_ && this.nationalNumber_ == other.nationalNumber_ && this.extension_.equals(other.extension_) && this.italianLeadingZero_ == other.italianLeadingZero_ && this.numberOfLeadingZeros_ == other.numberOfLeadingZeros_ && this.rawInput_.equals(other.rawInput_) && this.countryCodeSource_ == other.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(other.preferredDomesticCarrierCode_) && hasPreferredDomesticCarrierCode() == other.hasPreferredDomesticCarrierCode();
    }

    public boolean equals(Object that) {
        return (that instanceof Phonenumber$PhoneNumber) && exactlySameAs((Phonenumber$PhoneNumber) that);
    }

    public int hashCode() {
        return ((((((((((((((((2173 + getCountryCode()) * 53) + Long.valueOf(getNationalNumber()).hashCode()) * 53) + getExtension().hashCode()) * 53) + (isItalianLeadingZero() ? 1231 : 1237)) * 53) + getNumberOfLeadingZeros()) * 53) + getRawInput().hashCode()) * 53) + getCountryCodeSource().hashCode()) * 53) + getPreferredDomesticCarrierCode().hashCode()) * 53) + (hasPreferredDomesticCarrierCode() ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country Code: ");
        sb.append(this.countryCode_);
        sb.append(" National Number: ");
        sb.append(this.nationalNumber_);
        if (hasItalianLeadingZero() && isItalianLeadingZero()) {
            sb.append(" Leading Zero(s): true");
        }
        if (hasNumberOfLeadingZeros()) {
            sb.append(" Number of leading zeros: ");
            sb.append(this.numberOfLeadingZeros_);
        }
        if (hasExtension()) {
            sb.append(" Extension: ");
            sb.append(this.extension_);
        }
        if (hasCountryCodeSource()) {
            sb.append(" Country Code Source: ");
            sb.append(this.countryCodeSource_);
        }
        if (hasPreferredDomesticCarrierCode()) {
            sb.append(" Preferred Domestic Carrier Code: ");
            sb.append(this.preferredDomesticCarrierCode_);
        }
        return sb.toString();
    }
}
