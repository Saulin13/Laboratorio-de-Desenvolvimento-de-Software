package sistema;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {

   
    private static Path resolvePath(String nomeArquivo) {
        Path p1 = Paths.get(nomeArquivo);
        if (Files.exists(p1)) return p1;

        Path p2 = Paths.get("Implementacao", "src", "main", "java", nomeArquivo);
        return p2; // se não existir, os métodos chamadores tratam
    }

 
    public static void salvarTxt(List<String> dados, String nomeArquivo) {
        Path path = resolvePath(nomeArquivo);
        try {
            Path parent = path.getParent();
            if (parent != null) Files.createDirectories(parent);
            try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
                for (String linha : dados) writer.println(linha);
            }
            System.out.println("Dados salvos em " + path.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar " + path.toAbsolutePath() + ": " + e.getMessage());
        }
    }

    public static List<String> carregarTxt(String nomeArquivo) {
        Path path = resolvePath(nomeArquivo);
        List<String> dados = new ArrayList<>();
        try {
            if (!Files.exists(path)) {
                System.out.println("Arquivo " + nomeArquivo + " não encontrado em: " + path.toAbsolutePath());
                return dados;
            }
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    linha = linha.replace("\uFEFF", "").trim();
                    if (linha.isEmpty()) continue;
                    dados.add(linha);
                }
            }
            System.out.println("Dados carregados de " + path.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao carregar " + path.toAbsolutePath() + ": " + e.getMessage());
        }
        return dados;
    }


    public static void salvarPeriodo(PeriodoMatriculas p, String nomeArquivo) {
        Path path = resolvePath(nomeArquivo);
        try {
            Path parent = path.getParent();
            if (parent != null) Files.createDirectories(parent);
            try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(path))) {
                if (p != null) {
                    long ini = p.getDataInicio().getTime();
                    long fim = p.getDataFim().getTime();
                    boolean ativo = p.isAtivo();
                    w.println(ini + ";" + fim + ";" + ativo);
                }
            }
            System.out.println("Dados salvos em " + path.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar período em " + path.toAbsolutePath() + ": " + e.getMessage());
        }
    }

    public static PeriodoMatriculas carregarPeriodo(String nomeArquivo) {
        List<String> linhas = carregarTxt(nomeArquivo);
        if (linhas.isEmpty()) return null;
        try {
            String[] p = linhas.get(0).replace("\uFEFF","").trim().split(";");
            long ini = Long.parseLong(p[0].trim());
            long fim = Long.parseLong(p[1].trim());
            boolean ativo = Boolean.parseBoolean(p[2].trim());
            PeriodoMatriculas per = new PeriodoMatriculas(new java.util.Date(ini), new java.util.Date(fim));
            if (ativo) per.ativar(); else per.desativar();
            return per;
        } catch (Exception e) {
            System.out.println("Erro ao ler período: " + e.getMessage());
            return null;
        }
    }
}
