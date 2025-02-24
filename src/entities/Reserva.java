package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public Sala getSalaReservada() {
        return salaReservada;
    }

    public void setSalaReservada(Sala salaReservada) {
        this.salaReservada = salaReservada;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getTermino() {
        return termino;
    }

    public void setTermino(LocalDateTime termino) {
        this.termino = termino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "\nReserva feita por: " + this.usuario.getNome()
            + "\n\nSala: "
            + this.salaReservada.getNome()
            + "\nCapacidade: "
            + this.salaReservada.getCapacidade()
            + "\nDe " + this.inicio.format(formatoData) + " à " + this.termino.format(formatoData);
    }

    
}
