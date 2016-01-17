package pl.edu.agh.fiis.rest.dto;

/**
 * Created by wemstar on 2015-12-06.
 */
public class ProductDTO {
    private Long id;
    private String name;
    private Double value;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}
