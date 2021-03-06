
package org.avaje.ebean.dbmigration.migration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;group ref="{http://ebean-orm.github.io/xml/ns/dbmigration}changeSetChildren" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "changeSetChildren"
})
@XmlRootElement(name = "changeSet", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration")
public class ChangeSet {

    @XmlElements({
        @XmlElement(name = "configuration", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = Configuration.class),
        @XmlElement(name = "sql", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = Sql.class),
        @XmlElement(name = "createTable", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = CreateTable.class),
        @XmlElement(name = "dropTable", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = DropTable.class),
        @XmlElement(name = "renameTable", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = RenameTable.class),
        @XmlElement(name = "createHistoryTable", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = CreateHistoryTable.class),
        @XmlElement(name = "createView", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = CreateView.class),
        @XmlElement(name = "dropView", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = DropView.class),
        @XmlElement(name = "renameView", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = RenameView.class),
        @XmlElement(name = "addColumn", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = AddColumn.class),
        @XmlElement(name = "dropColumn", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = DropColumn.class),
        @XmlElement(name = "renameColumn", namespace = "http://ebean-orm.github.io/xml/ns/dbmigration", type = RenameColumn.class)
    })
    protected List<Object> changeSetChildren;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;
    @XmlAttribute(name = "comment")
    protected String comment;

    /**
     * Gets the value of the changeSetChildren property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeSetChildren property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeSetChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Configuration }
     * {@link Sql }
     * {@link CreateTable }
     * {@link DropTable }
     * {@link RenameTable }
     * {@link CreateHistoryTable }
     * {@link CreateView }
     * {@link DropView }
     * {@link RenameView }
     * {@link AddColumn }
     * {@link DropColumn }
     * {@link RenameColumn }
     * 
     * 
     */
    public List<Object> getChangeSetChildren() {
        if (changeSetChildren == null) {
            changeSetChildren = new ArrayList<Object>();
        }
        return this.changeSetChildren;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
