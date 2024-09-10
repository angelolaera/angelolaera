package u5d7_esercizio.angelolaera.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Blog {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempo_lettura_minuti;
}
