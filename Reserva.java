/**
 * Classe Reserva - representa uma reserva na agenda.
 * Autor: Gabriel Sera
 */
public class Reserva {
    private String nome;
    private String data; // formato: dd/mm/aaaa
    private String hora; // formato: HH:mm

    // Construtor
    public Reserva(String nome, String data, String hora) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    // toString para exibir informações da reserva
    @Override
    public String toString() {
        return "Reserva de " + nome + " em " + data + " às " + hora;
    }
}