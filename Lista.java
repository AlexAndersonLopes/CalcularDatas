package cadpessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lista {
    
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private String nome;
    private String sexo;
    private LocalDate nascimento; 

    public Lista() {
    }

    public Lista(String nome, String sexo, LocalDate nascimento) {
        this.nome = nome;
        setSexo(sexo);
        this.nascimento = nascimento;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if("m".equals(sexo) || "M".equals(sexo)){
            this.sexo = "Masculino";
        }
        if("f".equals(sexo) || "F".equals(sexo)){
            this.sexo = "Feminino";
        }       
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
      
}
