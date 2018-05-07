package icet.ufam.edu.teste;

import java.util.Random;
import java.util.Timer;
public class Jogo {
    public String nome;
    public int idade;
    public String classe;
    public String pret1;
    public String pret2;
    public String pret3;
    public String cidade1;
    public String cidade2;
    public String cidade3;
    public int filhos;


    //contructor



    // validar nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // validar Idade
    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // validar Classe
    public String getClasse() {
        return this.classe;
    }

    public void setClasse(int idade) {
        Random num = new Random(idade);
        String classe = null;
        int aleatorio;
        for (int i = 0; i < idade; i++) {
            aleatorio = num.nextInt(idade) + 1;
            if (aleatorio % 2 == 0) {
                if (aleatorio % 3 == 0)
                    classe = "Milionário(a)";
                else
                    classe = "Rico(a)";
            } else if (aleatorio % 3 == 0)
                classe = "Milionário(a)";
            else
                classe = "Pobre";
        }
        this.classe = classe;
    }

    // Validar filhos
    public void verificaFilhos(int idade) {
        Random num = new Random(idade);
        int aleatorio, filhos = 0;
        for (int i = 0; i < idade; i++) {
            aleatorio = num.nextInt(idade) + 1;
            if (aleatorio % 2 == 0) {
                if (aleatorio % 3 == 0)
                    filhos = 3;
                else
                    filhos = 2;
            } else if (aleatorio % 3 == 0)
                filhos = 3;
            else
                filhos = 1;
        }
        this.filhos = filhos;
    }

    public int getFilhos() {
        return this.filhos;
    }


    // Validar pretendentes
    public void setPret1(String Pretendente) {
        this.pret1 = Pretendente;
    }
    public void setPret2(String Pretendente) {
        this.pret2 = Pretendente;
    }
    public void setPret3(String Pretendente) {
        this.pret3 = Pretendente;
    }

    public String getPret1() {
        return this.pret1;
    }
    public String getPret2() {
        return this.pret2;
    }
    public String getPret3() {
        return this.pret3;
    }

    // Sortear Pretendentes
    public String sortPretendentes(int idade) {
        Random num = new Random(idade);
        String pretendenteFinal = null;
        int aleatorio;
        for (int i = 0; i < idade; i++) {
            aleatorio = num.nextInt(idade) + 1;
            if (aleatorio % 2 == 0) {
                if (aleatorio % 3 == 0)
                    pretendenteFinal = this.pret3;
                else
                    pretendenteFinal = this.pret2;
            } else if (aleatorio % 3 == 0)
                pretendenteFinal = this.pret3;
            else
                pretendenteFinal = this.pret1;
        }
        return pretendenteFinal;
    }

    // Validar cidades
    public void setCit1(String Pretendente) {
        this.cidade1 = Pretendente;
    }
    public void setCit2(String Pretendente) {
        this.cidade2 = Pretendente;
    }
    public void setCit3(String Pretendente) {
        this.cidade3 = Pretendente;
    }

    public String getCidade1() {
        return this.cidade1;
    }
    public String getCidade2() {
        return this.cidade2;
    }
    public String getCidade3() {
        return this.cidade3;
    }

    // Sortear Cidades
    public String sortCidades(int idade) {
        Random num = new Random(idade);
        String cidadeFinal = null;
        int aleatorio;
        for (int i = 0; i < idade; i++) {
            aleatorio = num.nextInt(idade) + 1;
            if (aleatorio % 2 == 0) {
                if (aleatorio % 3 == 0)
                    cidadeFinal = this.cidade3;
                else
                    cidadeFinal = this.cidade2;
            } else if (aleatorio % 3 == 0)
                cidadeFinal = this.cidade3;
            else
                cidadeFinal = this.cidade1;
        }
        return cidadeFinal;
    }

}
