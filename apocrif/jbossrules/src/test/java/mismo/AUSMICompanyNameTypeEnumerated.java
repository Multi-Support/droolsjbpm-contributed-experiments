//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AUS_MICompanyNameTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_MICompanyNameTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AmerinGuaranteeCorporation"/>
 *     &lt;enumeration value="CMG_MICompany"/>
 *     &lt;enumeration value="CommonwealthMortgageAssuranceCompany"/>
 *     &lt;enumeration value="GECapitalMICorporation"/>
 *     &lt;enumeration value="GenworthMortgageInsuranceCorporation"/>
 *     &lt;enumeration value="MortgageGuarantyInsuranceCorporation"/>
 *     &lt;enumeration value="PMI_MICorporation"/>
 *     &lt;enumeration value="RadianGuarantyIncorporated"/>
 *     &lt;enumeration value="RepublicMICompany"/>
 *     &lt;enumeration value="TriadGuarantyInsuranceCorporation"/>
 *     &lt;enumeration value="UnitedGuarantyCorporation"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_MICompanyNameTypeEnumerated")
@XmlEnum
public enum AUSMICompanyNameTypeEnumerated {

    @XmlEnumValue("AmerinGuaranteeCorporation")
    AMERIN_GUARANTEE_CORPORATION("AmerinGuaranteeCorporation"),
    @XmlEnumValue("CMG_MICompany")
    CMG_MI_COMPANY("CMG_MICompany"),
    @XmlEnumValue("CommonwealthMortgageAssuranceCompany")
    COMMONWEALTH_MORTGAGE_ASSURANCE_COMPANY("CommonwealthMortgageAssuranceCompany"),
    @XmlEnumValue("GECapitalMICorporation")
    GE_CAPITAL_MI_CORPORATION("GECapitalMICorporation"),
    @XmlEnumValue("GenworthMortgageInsuranceCorporation")
    GENWORTH_MORTGAGE_INSURANCE_CORPORATION("GenworthMortgageInsuranceCorporation"),
    @XmlEnumValue("MortgageGuarantyInsuranceCorporation")
    MORTGAGE_GUARANTY_INSURANCE_CORPORATION("MortgageGuarantyInsuranceCorporation"),
    @XmlEnumValue("PMI_MICorporation")
    PMI_MI_CORPORATION("PMI_MICorporation"),
    @XmlEnumValue("RadianGuarantyIncorporated")
    RADIAN_GUARANTY_INCORPORATED("RadianGuarantyIncorporated"),
    @XmlEnumValue("RepublicMICompany")
    REPUBLIC_MI_COMPANY("RepublicMICompany"),
    @XmlEnumValue("TriadGuarantyInsuranceCorporation")
    TRIAD_GUARANTY_INSURANCE_CORPORATION("TriadGuarantyInsuranceCorporation"),
    @XmlEnumValue("UnitedGuarantyCorporation")
    UNITED_GUARANTY_CORPORATION("UnitedGuarantyCorporation"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AUSMICompanyNameTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSMICompanyNameTypeEnumerated fromValue(String v) {
        for (AUSMICompanyNameTypeEnumerated c: AUSMICompanyNameTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
