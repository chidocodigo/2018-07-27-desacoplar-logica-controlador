package mx.gob.catalogos.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "bancos")
public class Banco extends Catalogo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_bancos")
	@SequenceGenerator(name="sec_id_bancos", sequenceName = "sec_id_bancos", allocationSize=1)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}