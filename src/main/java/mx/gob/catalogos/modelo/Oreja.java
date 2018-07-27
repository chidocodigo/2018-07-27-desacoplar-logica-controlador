package mx.gob.catalogos.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "orejas")
public class Oreja extends Catalogo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_orejas")
	@SequenceGenerator(name="sec_id_orejas", sequenceName = "sec_id_orejas", allocationSize=1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}