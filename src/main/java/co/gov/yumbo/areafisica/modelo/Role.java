package co.gov.yumbo.areafisica.modelo;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

    @Id
    @SequenceGenerator(name = "role_seq_gen", sequenceName = "role_seq", initialValue = 1,  allocationSize=2)
	@GeneratedValue(generator= "role_seq_gen") 
	@Column(name="role_id")
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
