package it.ddbdev.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Account.findAll",
                query = "SELECT u FROM Account u"),
        @NamedQuery(name = "Account.findById", query = "select new it.ddbdev.demo.dto.response.AccountResponse(a.id, a.username, a.password) from Account a where a.id = :id")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
