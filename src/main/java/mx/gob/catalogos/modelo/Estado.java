package mx.gob.catalogos.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "estados")
public class Estado extends Catalogo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_estados")
	@SequenceGenerator(name="sec_id_estados", sequenceName = "sec_id_estados", allocationSize=1)
	private Integer id;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Municipio> municipios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
}
