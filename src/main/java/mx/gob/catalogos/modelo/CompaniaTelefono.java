package mx.gob.catalogos.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "companias_telefono")
public class CompaniaTelefono extends Catalogo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_companias_telefono")
	@SequenceGenerator(name="sec_id_companias_telefono", sequenceName = "sec_id_companias_telefono", allocationSize=1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}