
package org.avaje.ebean.dbmigration.migration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://ebean-orm.github.io/xml/ns/dbmigration}column"/>
 *       &lt;attGroup ref="{http://ebean-orm.github.io/xml/ns/dbmigration}columnConstraintAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "column")
public class Column {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "defaultValue")
    protected String defaultValue;
    @XmlAttribute(name = "remarks")
    protected String remarks;
    @XmlAttribute(name = "notnull")
    protected Boolean notnull;
    @XmlAttribute(name = "checkConstraint")
    protected String checkConstraint;
    @XmlAttribute(name = "unique")
    protected Boolean unique;
    @XmlAttribute(name = "uniqueConstraintName")
    protected String uniqueConstraintName;
    @XmlAttribute(name = "primaryKey")
    protected Boolean primaryKey;
    @XmlAttribute(name = "primaryKeyName")
    protected String primaryKeyName;
    @XmlAttribute(name = "primaryKeyTablespace")
    protected String primaryKeyTablespace;
    @XmlAttribute(name = "references")
    protected String references;
    @XmlAttribute(name = "foreignKeyConstraintName")
    protected String foreignKeyConstraintName;
    @XmlAttribute(name = "deleteCascade")
    protected Boolean deleteCascade;
    @XmlAttribute(name = "deferrable")
    protected Boolean deferrable;
    @XmlAttribute(name = "initiallyDeferred")
    protected Boolean initiallyDeferred;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the notnull property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotnull() {
        return notnull;
    }

    /**
     * Sets the value of the notnull property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotnull(Boolean value) {
        this.notnull = value;
    }

    /**
     * Gets the value of the checkConstraint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckConstraint() {
        return checkConstraint;
    }

    /**
     * Sets the value of the checkConstraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckConstraint(String value) {
        this.checkConstraint = value;
    }

    /**
     * Gets the value of the unique property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnique() {
        return unique;
    }

    /**
     * Sets the value of the unique property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnique(Boolean value) {
        this.unique = value;
    }

    /**
     * Gets the value of the uniqueConstraintName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueConstraintName() {
        return uniqueConstraintName;
    }

    /**
     * Sets the value of the uniqueConstraintName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueConstraintName(String value) {
        this.uniqueConstraintName = value;
    }

    /**
     * Gets the value of the primaryKey property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrimaryKey() {
        return primaryKey;
    }

    /**
     * Sets the value of the primaryKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrimaryKey(Boolean value) {
        this.primaryKey = value;
    }

    /**
     * Gets the value of the primaryKeyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    /**
     * Sets the value of the primaryKeyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryKeyName(String value) {
        this.primaryKeyName = value;
    }

    /**
     * Gets the value of the primaryKeyTablespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryKeyTablespace() {
        return primaryKeyTablespace;
    }

    /**
     * Sets the value of the primaryKeyTablespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryKeyTablespace(String value) {
        this.primaryKeyTablespace = value;
    }

    /**
     * Gets the value of the references property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferences() {
        return references;
    }

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferences(String value) {
        this.references = value;
    }

    /**
     * Gets the value of the foreignKeyConstraintName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignKeyConstraintName() {
        return foreignKeyConstraintName;
    }

    /**
     * Sets the value of the foreignKeyConstraintName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignKeyConstraintName(String value) {
        this.foreignKeyConstraintName = value;
    }

    /**
     * Gets the value of the deleteCascade property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleteCascade() {
        return deleteCascade;
    }

    /**
     * Sets the value of the deleteCascade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteCascade(Boolean value) {
        this.deleteCascade = value;
    }

    /**
     * Gets the value of the deferrable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeferrable() {
        return deferrable;
    }

    /**
     * Sets the value of the deferrable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeferrable(Boolean value) {
        this.deferrable = value;
    }

    /**
     * Gets the value of the initiallyDeferred property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInitiallyDeferred() {
        return initiallyDeferred;
    }

    /**
     * Sets the value of the initiallyDeferred property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInitiallyDeferred(Boolean value) {
        this.initiallyDeferred = value;
    }

}
