package mx.gob.catalogos.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "colores_ojo")
public class ColorOjo extends Catalogo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_colores_ojo")
	@SequenceGenerator(name="sec_id_colores_ojo", sequenceName = "sec_id_colores_ojo", allocationSize=1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}