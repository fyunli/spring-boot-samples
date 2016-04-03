package li.fyunli.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by fyunli on 16/4/2.
 */
@Entity
public class Todo implements Serializable {

    private static final long serialVersionUID = 8277837190593516198L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 255, nullable = false)
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
