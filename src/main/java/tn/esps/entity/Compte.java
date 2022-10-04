package tn.esps.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "t_compte")
public class Compte implements Serializable  /*spec JEE*/ {
	private static final long serialVersionUID = 1L;
	@Id /*PK*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Long rib;
	private float solde;
	@Column(name="nom_client", length = 80)
	private String client;

	public Compte(float solde, String client) {
		super();
		this.solde = solde;
		this.client = client;
	}
}
