package entities;

import java.time.LocalDateTime;

public class Reserva {
    private Sala salaReservada;
    private LocalDateTime inicio;
    private LocalDateTime termino;
    private Usuario usuario;
    
    public Reserva(Sala salaReservada, LocalDateTime inicio, LocalDateTime termino, Usuario usuario) {
        this.salaReservada = salaReservada;
        this.inicio = inicio;
        this.termino = termino;
        this.usuario = usuario;
    }

    
}
