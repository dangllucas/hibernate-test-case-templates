package org.hibernate.bugs;

import jakarta.persistence.*;

@Entity
@Table(name = "demo")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "A_SINGLE_COL", nullable = false)
    private String aSingleCol;

    public DemoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaSingleCol() {
        return aSingleCol;
    }

    public void setaSingleCol(String aSingleCol) {
        this.aSingleCol = aSingleCol;
    }
}
