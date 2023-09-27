package logixtek.moitech.malib.entities;

import jakarta.persistence.*;
import logixtek.moitech.malib.enums.ReaderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    private Integer yob = 0;

    @Enumerated(EnumType.STRING)
    private ReaderStatus status = ReaderStatus.INACTIVE;
}
