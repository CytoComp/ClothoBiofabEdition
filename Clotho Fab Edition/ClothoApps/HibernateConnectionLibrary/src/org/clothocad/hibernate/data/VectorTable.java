/*
Copyright (c) 2009 The Regents of the University of California.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS..
 */
package org.clothocad.hibernate.data;
// Generated Jun 1, 2010 8:47:54 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.clothocore.api.data.ObjBase;
import org.clothocore.api.data.ObjBase.ObjBaseDatum;
import org.clothocore.api.data.ObjType;
import org.clothocore.api.data.Vector;
import org.clothocore.api.data.Vector.VectorDatum;
import org.clothocad.hibernate.hibernateDatum;

/**
 * VectorTable generated by hbm2java
 */
public class VectorTable implements java.io.Serializable, hibernateDatum {

    public static ObjType getType( Enum field ) {
        if ( field.getDeclaringClass() != Vector.Fields.class ) {
            return null;
        }

        Vector.Fields f = (Vector.Fields) field;

        switch(f) {
            case AUTHOR:
                return ObjType.PERSON;
            case SEQUENCE:
                return ObjType.NUCSEQ;
            case FORMAT:
                return ObjType.FORMAT;
            case PLASMIDS:
                return ObjType.PLASMID;
            default:
                return null;
        }
    }

    public VectorTable( Vector v ) {
        this.idVector = v.getUUID();
        this.name = v.getName();
        this.dateCreated = v.getDateCreated();
        this.lastModified = v.getLastModified();
        this.description = v.getShortDescription();
        this.isCircular = v.isCircular();
        this.isGenomic = v.isGenomic();
        this.riskGroup = v.getRiskGroup();
        this.hash = v.getHash();
        if ( v.getFormat() != null ) {
            this.formatTable = new FormatTable( v.getFormat().getUUID() );
        }
        if ( v.getAuthor() != null ) {
            this.personTable = new PersonTable( v.getAuthor().getUUID() );
        }
        if ( v.getSeq() != null ) {
            this.nucseqTable = new NucseqTable( v.getSeq().getUUID() );
        }
    }

    @Override
    public void runSecondaryProcessing(ObjBase obj) {
    }

    @Override
    public boolean needsSecondaryProcessing() {
        return false;
    }
    
    @Override
    public ObjBase getObject() {
        Vector.VectorDatum d = (VectorDatum) getObjBaseDatum();
        Vector v = new Vector( d );
        return v;
    }

    @Override
    public ObjBaseDatum getObjBaseDatum() {
        Vector.VectorDatum d = new Vector.VectorDatum();
        d.uuid = idVector;
        d.name = name;
        d.dateCreated = dateCreated;
        d.lastModified = lastModified;
        d._hash = hash;
        d._riskGroup = riskGroup;
        d._description = description;
        d._isCircular = isCircular;
        d._isGenomic = isGenomic;
        d._formatUUID = formatTable.getIdformat();
        d._authorUUID = personTable.getIdPerson();
        d._seqID = nucseqTable.getIdNucseq();
        return d;
    }

    @Override
    public String getUUID() {
        return idVector;
    }

    public static String translate( Enum field ) {
        if ( field.getDeclaringClass() != Vector.Fields.class ) {
            return null;
        }

        Vector.Fields f = (Vector.Fields) field;

        switch ( f ) {
            case NAME:
                return "name";
            case DATE_CREATED:
                return "dateCreated";
            case LAST_MODIFIED:
                return "lastModifed";
            case DESCRIPTION:
                return "description";
            case IS_GENOMIC:
                return "isGenomic";
            case RISK_GROUP:
                return "riskGroup";
            case HASH:
                return "hash";
            case AUTHOR:
                return "personTable";
            case FORMAT:
                return "formatTable";
            case SEQUENCE:
                return "nucseqTable";
            case IS_CIRCULAR:
                return "isCircular";
            case PLASMIDS:
                return "plasmidTables";
            default:
                return null;
        }
    }
    /***** AUTO-GENERATED CODE *****/
    private String idVector;
    private PersonTable personTable;
    private FormatTable formatTable;
    private NucseqTable nucseqTable;
    private String description;
    private Boolean isCircular;
    private Boolean isGenomic;
    private String name;
    private Short riskGroup;
    private Date dateCreated;
    private Date lastModified;
    private String hash;
    private Set plasmidTables = new HashSet( 0 );

    public VectorTable() {
    }

    public VectorTable( String idVector ) {
        this.idVector = idVector;
    }

    public VectorTable( String idVector, PersonTable personTable, FormatTable formatTable, NucseqTable nucseqTable, String description, Boolean isCircular, Boolean isGenomic, String name, Short riskGroup, Date dateCreated, Date lastModified, String hash, Set plasmidTables ) {
        this.idVector = idVector;
        this.personTable = personTable;
        this.formatTable = formatTable;
        this.nucseqTable = nucseqTable;
        this.description = description;
        this.isCircular = isCircular;
        this.isGenomic = isGenomic;
        this.name = name;
        this.riskGroup = riskGroup;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.hash = hash;
        this.plasmidTables = plasmidTables;
    }

    public String getIdVector() {
        return this.idVector;
    }

    public void setIdVector( String idVector ) {
        this.idVector = idVector;
    }

    public PersonTable getPersonTable() {
        return this.personTable;
    }

    public void setPersonTable( PersonTable personTable ) {
        this.personTable = personTable;
    }

    public FormatTable getFormatTable() {
        return this.formatTable;
    }

    public void setFormatTable( FormatTable formatTable ) {
        this.formatTable = formatTable;
    }

    public NucseqTable getNucseqTable() {
        return this.nucseqTable;
    }

    public void setNucseqTable( NucseqTable nucseqTable ) {
        this.nucseqTable = nucseqTable;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Boolean getIsCircular() {
        return this.isCircular;
    }

    public void setIsCircular( Boolean isCircular ) {
        this.isCircular = isCircular;
    }

    public Boolean getIsGenomic() {
        return this.isGenomic;
    }

    public void setIsGenomic( Boolean isGenomic ) {
        this.isGenomic = isGenomic;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Short getRiskGroup() {
        return this.riskGroup;
    }

    public void setRiskGroup( Short riskGroup ) {
        this.riskGroup = riskGroup;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated( Date dateCreated ) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified( Date lastModified ) {
        this.lastModified = lastModified;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash( String hash ) {
        this.hash = hash;
    }

    public Set getPlasmidTables() {
        return this.plasmidTables;
    }

    public void setPlasmidTables( Set plasmidTables ) {
        this.plasmidTables = plasmidTables;
    }
}
