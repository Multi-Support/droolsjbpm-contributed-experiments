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
 * <p>Java class for AUS_LoanOriginatorTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_LoanOriginatorTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Broker"/>
 *     &lt;enumeration value="Correspondent"/>
 *     &lt;enumeration value="Lender"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_LoanOriginatorTypeEnumerated")
@XmlEnum
public enum AUSLoanOriginatorTypeEnumerated {

    @XmlEnumValue("Broker")
    BROKER("Broker"),
    @XmlEnumValue("Correspondent")
    CORRESPONDENT("Correspondent"),
    @XmlEnumValue("Lender")
    LENDER("Lender"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AUSLoanOriginatorTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSLoanOriginatorTypeEnumerated fromValue(String v) {
        for (AUSLoanOriginatorTypeEnumerated c: AUSLoanOriginatorTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}