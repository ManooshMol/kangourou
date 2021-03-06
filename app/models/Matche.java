package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity 
public class Matche extends Model{
	
	@Id
    public Long id;

	@ManyToOne
    @JoinColumn(name="Equipe1")
    public Equipe equipe1;
    
    @ManyToOne
    @JoinColumn(name="Equipe2")
    public Equipe equipe2;
    
    @Column(name="scoreEquipe1")
    public Integer scoreEquipe1;
    
    @Column(name="scoreEquipe2")
    public Integer scoreEquipe2;
    
    @ManyToOne
    @JoinColumn(name="vainqueur")
    public Equipe vainqueur;
    
    @DateTime(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="dateMatche")
    public Date dateMatche;
    
    public static Finder<Long,Matche> find = new Finder<Long,Matche>(Long.class, Matche.class); 

    public static Matche findById(Long id) {
        return find.byId(id);
    }
    
    public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	/**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page<Matche> page(int page, int pageSize) {
        return 
            find.where().findPagingList(pageSize)
                .getPage(page);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScoreEquipe1() {
		return scoreEquipe1;
	}

	public void setScoreEquipe1(Integer scoreEquipe1) {
		this.scoreEquipe1 = scoreEquipe1;
	}

	public Integer getScoreEquipe2() {
		return scoreEquipe2;
	}

	public void setScoreEquipe2(Integer scoreEquipe2) {
		this.scoreEquipe2 = scoreEquipe2;
	}

	public Equipe getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Equipe vainqueur) {
		this.vainqueur = vainqueur;
	}

	public Date getDateMatche() {
		return dateMatche;
	}

	public void setDateMatche(Date dateMatche) {
		this.dateMatche = dateMatche;
	}
	
	public static void update(Matche matche){
		matche.update();
	}
    
    

}
