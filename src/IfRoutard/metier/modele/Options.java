package IfRoutard.metier.modele;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Représente une des options (départ, tarif) que le client peut choisir pour un voyage
 * @author elmhaidara
 */
@Entity
public class Options implements Serializable {
    /**
     * L'identifiant de l'entité dans la base de donnée. Cet identifiant est totalement gérée par JPA et aucune modification n'est possible dessus.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String lieuDepart;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    
    @Column(nullable = false)
    private int tarif;
    
    private String typeTransport;

    public Options(String lieuDepart, Date dateDepart, int tarif, String typeTransport) {
        this.lieuDepart = lieuDepart;
        this.dateDepart = dateDepart;
        this.tarif = tarif;
        this.typeTransport = typeTransport;
    }

    public Options() {
    }

    public long getId() {
        return id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "Date : "+format.format(dateDepart)+ " - Lieu : " + lieuDepart + "- Tarif : " + tarif +" - Transport : "+ typeTransport;
    }
    
    
}
